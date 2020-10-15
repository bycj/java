package xinan.demo.service;

import cdyb.dal.dto.UserDO;

/**
 * @author xinan
 * @date 2020/05/23
 */
public interface UserService {
    UserDO getUser(Integer age);
}
