package example.controller;

import example.domain.City;
import example.service.CityService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liyinhao on 18/7/10.
 */
@RestController
public class CityController {

    @Resource
    private CityService cityService;

    @RequestMapping("/city")
    public String city() {
        City city = cityService.getCity(1);

        return city == null ? "null" : city.getName();
    }

}
