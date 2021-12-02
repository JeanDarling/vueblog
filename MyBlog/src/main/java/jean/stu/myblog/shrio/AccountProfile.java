package jean.stu.myblog.shrio;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by The High Priestess
 *
 * @description
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

    private LocalDateTime created;

}
