package com.fishmoun.covision.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fishmoun.covision.model.dto.space.SpaceAddRequest;
import com.fishmoun.covision.model.dto.space.SpaceQueryRequest;
import com.fishmoun.covision.model.entity.Space;
import com.fishmoun.covision.model.entity.User;
import com.fishmoun.covision.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 23208
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2026-03-25 00:33:56
*/
public interface SpaceService extends IService<Space> {
    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);

    void checkSpaceAuth(User loginUser, Space space);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    SpaceVO getSpaceVO(Space space, HttpServletRequest request);

    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

}
