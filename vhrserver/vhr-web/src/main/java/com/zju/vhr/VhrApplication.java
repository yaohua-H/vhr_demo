package com.zju.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName VhrApplication
 * @Description
 * @Author Administrator
 * @Date 2021/4/27 17:50
 * @Version
 */
@SpringBootApplication
@EnableCaching
@MapperScan(basePackages = "com.zju.vhr.mapper")
@EnableScheduling
public class VhrApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrApplication.class,args);
    }
}
