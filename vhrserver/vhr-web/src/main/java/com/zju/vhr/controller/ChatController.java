package com.zju.vhr.controller;

import com.zju.vhr.model.Hr;
import com.zju.vhr.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName ChatController
 * @Description
 * @Author huangyaohua
 * @Date 2021-05-10 11:01
 * @Version
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    HrService hrService;

    @GetMapping("/hrs")
    public List<Hr> getAllHrs(){
        return hrService.getAllHrsExceptCurrentHr();
    }
}
