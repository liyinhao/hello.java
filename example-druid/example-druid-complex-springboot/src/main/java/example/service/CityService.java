package example.service;

import example.domain.City;
import example.manager.CityManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liyinhao on 18/7/10.
 */

@Service
public class CityService {

    @Resource
    private CityManager cityManager;

    public City getCity(int id) {
        return cityManager.getCityById(id);
    }

}
