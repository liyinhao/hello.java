package example.mapper;

import example.domain.Hotel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liyinhao on 18/7/10.
 */
@Mapper
public interface HotelMapper {

    Hotel selectByCityId(int id);
}
