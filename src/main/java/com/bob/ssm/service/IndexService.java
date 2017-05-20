package com.bob.ssm.service;

import com.bob.ssm.model.Banner;
import com.bob.ssm.model.WebSubject;

import java.util.List;

/**
 * Auth: Administrator
 * Date: 2017/5/20.
 */
public interface IndexService {
    List<WebSubject> getAllSubjects();
    List<Banner> getBanners();
}
