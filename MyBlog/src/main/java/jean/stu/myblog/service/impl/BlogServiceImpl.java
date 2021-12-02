package jean.stu.myblog.service.impl;

import jean.stu.myblog.entity.Blog;
import jean.stu.myblog.mapper.BlogMapper;
import jean.stu.myblog.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
