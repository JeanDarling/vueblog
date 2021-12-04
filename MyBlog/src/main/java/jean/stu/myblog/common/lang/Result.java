package jean.stu.myblog.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by The High Priestess
 *
 * @description 统一结果集封装
 */

@Data
public class Result implements Serializable {

    private int code;
    private Object data;
    private String msg;

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("操作成功！");
        result.setData(data);
        return result;
    }

    public static Result success(int code, String msg, Object date) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(date);
        return result;
    }

    public static Result fail(String msg) {
        return Result.fail(400, msg, null);
    }

    public static Result fail(String msg, Object date) {
        return Result.fail(400, msg, date);
    }

    public static Result fail(int code, String msg, Object date) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(date);
        return result;
    }
}
