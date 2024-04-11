package me.xiayong.example.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Yong Xia.
 * @date: Jun-27/2023
 * @since: v1.0
 **/
@Repository
public class CountryRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CountryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertCountry(String country) {
        return this.jdbcTemplate.update("INSERT INTO `country`(`country`) VALUES(?)", country);
    }

    public List<String> getCountry(String country) {
        return this.jdbcTemplate.query("SELECT * FROM `country` WHERE `country` LIKE ?",
                (rs, rowNum) -> rs.getString("country"),
                "%" + country + "%");
    }
}
