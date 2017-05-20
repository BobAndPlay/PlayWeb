package com.bob.ssm.dao;

import com.bob.ssm.model.WebSubject;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Auth: Administrator
 * Date: 2017/5/20.
 */

@Repository
public interface IndexDao {
    List<WebSubject> getAllSubjects();
}
