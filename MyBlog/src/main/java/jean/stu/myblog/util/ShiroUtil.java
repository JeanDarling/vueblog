package jean.stu.myblog.util;

import jean.stu.myblog.shrio.AccountProfile;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;

/**
 * Created by The High Priestess
 *
 * @description
 */
public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
