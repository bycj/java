package xinan.demo.dal.mapper;


import org.apache.ibatis.annotations.Mapper;
import xinan.demo.dal.dto.UserDO;


/**
 * @author xinan
 * @date 2020/05/23
 */
@Mapper
public interface UserDAO {
    UserDO getUser(Integer age);
}
