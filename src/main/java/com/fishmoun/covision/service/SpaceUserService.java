package com.fishmoun.covision.service;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fishmoun.covision.model.dto.spaceuser.SpaceUserAddRequest;
import com.fishmoun.covision.model.dto.spaceuser.SpaceUserQueryRequest;
import com.fishmoun.covision.model.entity.SpaceUser;
import com.fishmoun.covision.model.vo.SpaceUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
* @author 23208
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2026-03-26 15:46:40
*/
public interface SpaceUserService extends IService<SpaceUser> {
    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);
    void validSpaceUser(SpaceUser spaceUser, boolean add);

    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);
    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser, HttpServletRequest request);
    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);
}
