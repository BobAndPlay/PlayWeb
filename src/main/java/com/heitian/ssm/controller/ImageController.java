package com.heitian.ssm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Author: Bob
 * Date:   2017/5/9.
 */

@Controller
@RequestMapping("/image")
public class ImageController {

    private Logger log = Logger.getLogger(ImageController.class);

    @RequestMapping("/upload")
    public String uploadImage(MultipartFile file, HttpSession session , Model model) throws IOException {
        log.info("上传图片");

        String originalFilename = file.getOriginalFilename();

        String filname = session.getServletContext().getRealPath("/images");

        File imageFile = new File(filname, originalFilename);

        file.transferTo(imageFile);

        model.addAttribute("image_path",imageFile.getAbsolutePath());

        return "showUser";
    }
}
