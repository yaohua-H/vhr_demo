package com.zju.vhr.controller;

import com.zju.vhr.config.VerificationCode;
import com.zju.vhr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName LoginController
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 16:11
 * @Version
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login(){
        return RespBean.error("尚未登陆，请登录！");
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        HttpSession session = request.getSession();
        session.setAttribute("verify_code",text);
        VerificationCode.output(image,resp.getOutputStream());
    }
}
