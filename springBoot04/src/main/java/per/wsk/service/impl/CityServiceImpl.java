package per.wsk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import per.wsk.bean.City;
import per.wsk.mapper.CityMapper;
import per.wsk.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

//    Counter counter;

    /*public CityServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.saveCity.count");
    }*/


    @Override
    public City getById(Long id){
        return cityMapper.getById(id);
    }


    @Override
    public void saveCity(City city) {
//        counter.increment();
        cityMapper.insert(city);

    }
}
