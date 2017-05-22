package com.bob.ssm.controller;

import com.bob.ssm.base.BaseResponse;
import com.bob.ssm.model.Banner;
import com.bob.ssm.model.WebSubject;
import com.bob.ssm.service.IndexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Auth: Administrator
 * Date: 2017/5/20.
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    private Logger log = Logger.getLogger(IndexService.class);

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/allSubject", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllSubject() throws JsonProcessingException {
        log.info("get all subject");
        List<WebSubject> allSubjects = indexService.getAllSubjects();
        ObjectMapper objectMapper = new ObjectMapper();
        BaseResponse response = new BaseResponse();
        response.setData(allSubjects);
        return objectMapper.writeValueAsString(response);
    }

    @RequestMapping(value = "/banners", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getBanners(@RequestParam(value = "type") String type) throws JsonProcessingException {
        log.info("get all banners");
        List<Banner> banners = indexService.getBanners(type);
        ObjectMapper objectMapper = new ObjectMapper();
        BaseResponse response = new BaseResponse();
        response.setData(banners);
        return objectMapper.writeValueAsString(response);
    }


}
