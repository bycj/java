package xinan.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xinan.demo.dal.DO.UserDO;
import xinan.demo.dal.mapper.UserDAO;


/**
 * @author xinan
 * @date 2020/05/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public UserDO getUser(Integer age) {
        UserDO userDO = userDAO.getUser(age);
        return userDO;
    }
}
