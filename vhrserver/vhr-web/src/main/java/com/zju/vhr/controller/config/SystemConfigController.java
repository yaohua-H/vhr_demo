package com.zju.vhr.controller.config;

import com.zju.vhr.model.Menu;
import com.zju.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName SystemConfigController
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 16:48
 * @Version
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu>  getMenuByHrId(){
        return menuService.getMenusByHrId();
    }
}
