package example.manager;

import example.JsonUtil;
import example.cache.RedisCacheManager;
import example.dao.CityDao;
import example.domain.City;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * Created by liyinhao on 18/7/22.
 */
@Component
public class CityManager {

    @Resource
    private CityDao cityDao;


    public City getCityById(int id) {
        City city = null;

        String key = getRedisKey(id);
        String val = RedisCacheManager.get(key);

        if (StringUtils.isEmpty(val)) {

            city = cityDao.selectCityById(id);

            RedisCacheManager.set(key, JsonUtil.toJson(city));
        } else {
            city = JsonUtil.fromJson(val, City.class);
        }

        return city;
    }

    private String getRedisKey(int id) {
        return "city:" + id;
    }
}
