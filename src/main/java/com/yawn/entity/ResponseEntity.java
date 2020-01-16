package com.yawn.entity;

/**
 * <p>
 * <code>response</code>
 * </p>
 *
 * @author huiwang45@iflytek.com
 * @description
 * @date 2020/01/15 16:01
 */
public class ResponseEntity {

    /***
     * 描述
     */
    private String msg;
    /***
     * 状态 200成功: 500失败
     */
    private int code;
    /***
     *
     */
    private User user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ResponseEntity() {
    }

    public ResponseEntity(String msg, int code, User user) {
        this.msg = msg;
        this.code = code;
        this.user = user;
    }
}
