package me.xiayong.example.springboot.config;

import lombok.Getter;
import me.xiayong.example.springboot.service.impl.JPABasedUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

/**
 * @author YongXia.
 * @since 1.0
 */
@Getter
@Configuration
public class WebSecurityConfiguration {
    private static Logger logger = LoggerFactory.getLogger(WebSecurityConfiguration.class);

    @Autowired
    private JPABasedUserDetailsService userDetailsService;

    @Bean
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    public ApplicationSecurity applicationSecurity() {
        return new ApplicationSecurity();
    }


    protected class ApplicationSecurity extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/css/**", "/js/**").permitAll().anyRequest().fullyAuthenticated()
//                    .antMatchers( "/view", "/view/").permitAll().anyRequest().fullyAuthenticated()
                    .and()
                    .formLogin().loginProcessingUrl("/login").permitAll().loginPage("/view/login").successForwardUrl("/view").failureUrl("/view/login?error")
                    .successHandler(((request, response, authentication) -> {
                        User user = (User) authentication.getPrincipal();
                        logger.info("User: {} login successful.", user.getUsername());
                        response.sendRedirect(request.getContextPath() + "/view");
                    }))
                    .and()
                    .logout().logoutUrl("/logout").permitAll().logoutSuccessUrl("/view/login?logout")
                    .logoutSuccessHandler(((request, response, authentication) -> {
                        User user = (User) authentication.getPrincipal();
                        logger.info("User: {} logout successful.", user.getUsername());
                        response.sendRedirect(request.getContextPath() + "/view/login?logout");
                    }))
                    .and()
                    .headers().frameOptions().disable()
                    .and()
                    .csrf().disable()
            ;


            // super.configure(http);
        }

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
//            auth.inMemoryAuthentication()
//                    .withUser("admin").password("admin").roles("ADMIN", "USER")
//                    .and()
//                    .withUser("user").password("user").roles("USER");
            auth.userDetailsService(userDetailsService);
        }
    }


}
