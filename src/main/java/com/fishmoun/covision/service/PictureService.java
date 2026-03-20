package com.fishmoun.covision.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fishmoun.covision.model.dto.picture.PictureQueryRequest;
import com.fishmoun.covision.model.dto.picture.PictureReviewRequest;
import com.fishmoun.covision.model.dto.picture.PictureUploadRequest;
import com.fishmoun.covision.model.entity.Picture;
import com.fishmoun.covision.model.entity.User;
import com.fishmoun.covision.model.vo.PictureVO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 23208
 * @description 针对表【picture(图片)】的数据库操作Mapper
 * @createDate 2026-03-20 19:40:02
 * @Entity generator.domain.Picture
 */
public interface PictureService extends IService<Picture> {
    /**
     * 上传图片
     *
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object inputSource, PictureUploadRequest pictureUploadRequest, User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);


    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);


    void fillReviewParams(Picture picture, User loginUser);
}




