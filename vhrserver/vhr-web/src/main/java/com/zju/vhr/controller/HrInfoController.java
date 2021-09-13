package com.zju.vhr.controller;

import com.zju.vhr.config.FastDFSUtils;
import com.zju.vhr.model.Hr;
import com.zju.vhr.model.RespBean;
import com.zju.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class HrInfoController {

    @Autowired
    HrService hrService;

    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication){
        return (Hr) authentication.getPrincipal();
    }

    @PutMapping("/hr/info")
    public RespBean updateHr(@RequestBody Hr hr,Authentication authentication){
        if(hrService.updateHr(hr) == 1){
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("hr更新成功！");
        }
        return RespBean.error("hr更新失败！");
    }

    @PutMapping("/hr/pass")
    public RespBean updateHrPasswd(@RequestBody Map<String,Object> info){
        String oldpass = (String) info.get("oldpass");
        String pass = (String) info.get("pass");
        Integer hrid = (Integer) info.get("hrid");
        if(hrService.updateHrPasswd(oldpass,pass,hrid)){
            return RespBean.ok("passwd更新成功！");
        }
        return RespBean.error("passwd更新失败！");
    }

    @PostMapping("/hr/userface")
    public RespBean updateHrUserface(MultipartFile file, Integer id, Authentication authentication){
        String fileId = FastDFSUtils.upload(file);
        String url = nginxHost + fileId;
        if(hrService.updateUserface(url,id) == 1){
            Hr hr = (Hr) authentication.getPrincipal();
            hr.setUserface(url);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,authentication.getCredentials(),authentication.getAuthorities()));
            return RespBean.ok("userface更新成功！");
        }
        return RespBean.error("userface更新失败！");
    }
}
