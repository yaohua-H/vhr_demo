package com.zju.vhr.exception;

import com.zju.vhr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 统一异常处理
 * @Author Administrator
 * @Date 2021/5/9 10:14
 * @Version
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联数据，操作失败！");
        }
        return RespBean.error("数据库异常，操作失败！");
    }
}
