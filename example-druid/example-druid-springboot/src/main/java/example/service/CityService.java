package example.service;

import example.dao.CityDao;
import example.domain.City;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liyinhao on 18/7/10.
 */

@Service
public class CityService {

    @Resource
    private CityDao cityDao;

    public City getCity(int id) {
        return cityDao.selectCityById(id);
    }

}
