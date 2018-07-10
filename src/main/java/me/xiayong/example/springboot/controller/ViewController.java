package me.xiayong.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YongXia.
 * @since 1.0
 */
@Controller
@RequestMapping("view")
public class ViewController {
    @RequestMapping(value = {"", "/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        modelAndView.addObject("message", "Hello !");
        request.getParameterMap().forEach((key, value)-> modelAndView.addObject(key, value.length > 1 ? value : value[0]));
        return modelAndView;
    }

    @RequestMapping("/{page}")
    public ModelAndView mapping(@PathVariable String page, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(page);
        request.getParameterMap().forEach((key, value)-> modelAndView.addObject(key, value.length > 1 ? value : value[0]));
        return modelAndView;
    }

    @RequestMapping("/{module}/{page}")
    public ModelAndView mapping(@PathVariable String module, @PathVariable String page, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(module + "/" + page);
        request.getParameterMap().forEach((key, value)-> modelAndView.addObject(key, value.length > 1 ? value : value[0]));
        return modelAndView;
    }
}
