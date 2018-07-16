package example.mapper;

import example.domain.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by liyinhao on 18/7/10.
 */
@Mapper
public interface CityMapper {

    City selectCityById(int id);

    List<City> selectCityByCountry(String country);

    Integer addCity(City city);

    Integer deleteCityById(int id);

    Integer deleteCityByName(String name);

    Integer updateCity(City city);


}
