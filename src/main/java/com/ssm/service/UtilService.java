package com.ssm.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author STARS
 */
public interface UtilService {
    /**图片存储
     *
     * @param files MultipartFile[]
     * @param path String
     * @return Object
     */
    Object addImg(MultipartFile[] files, String path);
}
