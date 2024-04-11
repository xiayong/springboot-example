package me.xiayong.example.service;

import java.util.List;

/**
 * @author: Yong Xia.
 * @date: Jun-26/2023
 * @since: v1.0
 **/
public interface ICountryService {
    void saveCountry(String country);

    void saveManyCountries(List<String> countries);

    List<String> getCountries(String country);
}
