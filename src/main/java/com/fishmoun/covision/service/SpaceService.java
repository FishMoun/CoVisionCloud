package com.fishmoun.covision.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fishmoun.covision.model.dto.space.SpaceAddRequest;
import com.fishmoun.covision.model.entity.Space;
import com.fishmoun.covision.model.entity.User;

/**
* @author 23208
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2026-03-25 00:33:56
*/
public interface SpaceService extends IService<Space> {
    void validSpace(Space space, boolean add);

    void fillSpaceBySpaceLevel(Space space);

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);
}
