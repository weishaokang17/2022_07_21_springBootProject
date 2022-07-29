package per.wsk.service;

import per.wsk.bean.City;

public interface CityService {

    City getById(Long id);

    void saveCity(City city);

}
