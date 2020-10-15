package xinan.demo.dal.mapper;

import cdyb.dal.dto.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xinan
 * @date 2020/05/23
 */
@Mapper
public interface UserDAO {
    UserDO getUser(Integer age);
}
