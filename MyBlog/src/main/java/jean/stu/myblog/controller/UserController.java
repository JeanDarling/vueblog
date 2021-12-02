package jean.stu.myblog.controller;


import jean.stu.myblog.common.lang.Result;
import jean.stu.myblog.entity.User;
import jean.stu.myblog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Jean
 * @since 2021-11-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(1L);
        return Result.success( user);
    }

    @PostMapping("/save")
    public Object  save(@Validated @RequestBody User user) {

        return user.toString();
    }


}
