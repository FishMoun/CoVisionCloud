package com.fishmoun.covision.model.vo;

import java.util.Date;

public class UserVO {
    /**
     * 用户id
     */
    private Long id;

    /**
     * 账号
     */
    private  String userAccount;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private  String userProfile;

    /**
     * 用户角色
     */
    private String userRole;

    /**
     * 创建时间
     */
    private Date createTime;


    private static final long serialVersionUID = 1L;
}
