package com.bob.ssm.service.impl;

import com.bob.ssm.dao.BannerDao;
import com.bob.ssm.dao.IndexDao;
import com.bob.ssm.model.Banner;
import com.bob.ssm.model.WebSubject;
import com.bob.ssm.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Auth: Administrator
 * Date: 2017/5/20.
 */

@Service
public class IndexServiceImpl implements IndexService {


    @Resource
    IndexDao indexDao;

    @Resource
    BannerDao bannerDao;

    public List<WebSubject> getAllSubjects() {
        return indexDao.getAllSubjects();
    }

    public List<Banner> getBanners() {
        return bannerDao.getBanners();
    }
}
