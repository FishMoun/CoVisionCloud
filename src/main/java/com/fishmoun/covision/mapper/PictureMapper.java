package com.fishmoun.covision.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fishmoun.covision.model.entity.Picture;


/**
* @author 23208
* @description 针对表【picture(图片)】的数据库操作Mapper
* @createDate 2026-03-20 19:40:02
* @Entity generator.domain.Picture
*/
public interface PictureMapper extends BaseMapper<Picture> {
    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */


}




