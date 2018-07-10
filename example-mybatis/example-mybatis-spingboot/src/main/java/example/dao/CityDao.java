/**
 * Copyright ${license.git.copyrightYears} the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.dao;


import example.domain.City;
import example.mapper.CityMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CityDao {

    @Resource
    private CityMapper cityMapper;

    public City selectCityById(int id) {
        return cityMapper.selectCityById(id);
    }

    public List<City> getCountryCites(String country) {
        return cityMapper.selectCityByCountry(country);
    }

    public int addCity(City city) {
        return cityMapper.addCity(city);
    }

    public int deleteCityByName(String name) {
        return cityMapper.deleteCityByName(name);
    }

    public int deleteCityById(int id) {
        return cityMapper.deleteCityById(id);
    }

    public int updateCity(City city) {
        return cityMapper.updateCity(city);
    }


}
