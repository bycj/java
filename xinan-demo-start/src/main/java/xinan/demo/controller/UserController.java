package xinan.demo.controller;

import cdyb.dal.dto.UserDO;
import cdyb.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xinan
 * @date 2020/05/23
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "获取用户")
    @RequestMapping("/getuser")
    UserDO getUser(@RequestParam(value = "age") Integer age){
        return userService.getUser(age);
    }
}
