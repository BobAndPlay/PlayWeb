package com.heitian.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Author: Bob
 * Date:   2017/5/9.
 */

@Controller
public class ImageController {

    private Logger log = Logger.getLogger(ImageController.class);

    @RequestMapping("/upload")
    public String uploadImage(@RequestParam(value = "uploadFile", required = false) MultipartFile file, HttpSession session, Model model) throws IOException {
        log.info("上传图片");

        String name = file.getOriginalFilename();
        String suffix = name.substring(name.lastIndexOf("."));

        String filname = session.getServletContext().getRealPath("/images");

        File imageFile = new File(filname, UUID.randomUUID().toString() + suffix);

        file.transferTo(imageFile);

        model.addAttribute("fileUrl", "images/" + imageFile.getName());

        return "showImage";
    }
}
