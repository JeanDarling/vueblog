package jean.stu.myblog.service.impl;

import jean.stu.myblog.entity.User;
import jean.stu.myblog.mapper.UserMapper;
import jean.stu.myblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Jean
 * @since 2021-11-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
