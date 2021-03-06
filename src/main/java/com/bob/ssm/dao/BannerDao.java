package com.bob.ssm.dao;

import com.bob.ssm.model.Banner;
import com.bob.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Auth: Administrator
 * Date: 2017/5/20.
 */

@Repository
public interface BannerDao {

    List<Banner> getBanners(@Param("type") String type);
}
