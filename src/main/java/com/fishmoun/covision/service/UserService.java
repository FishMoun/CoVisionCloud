package com.fishmoun.covision.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fishmoun.covision.model.dto.user.UserQueryRequest;
import com.fishmoun.covision.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fishmoun.covision.model.vo.LoginUserVO;
import com.fishmoun.covision.model.vo.UserVO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 23208
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2026-03-18 19:08:03
*/
public interface UserService extends IService<User> {
    /**
     * @param userAccount
     * @param userPassword
     * @param checkPassword
     * @return
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * @param userAccount
     * @param userPassword
     * @param request
     * @return
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 获取当前登录用户
     * @param
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取脱敏的已登录的用户信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户注销
     * @param request
     * @return
     */
    boolean userLogout(HttpServletRequest request);

    String getEncryptPassword(String userPassword);

    /**
     * 分页
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    UserVO getUserVO(User user);

    List<UserVO> getUserVOList(List<User> userList);
}
