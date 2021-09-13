package com.zju.vhr.converter;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DataConverter
 * @Description 处理数据格式转换
 * @Author Administrator
 * @Date 2021/5/9 10:26
 * @Version
 */
@Component
public class DataConverter implements Converter<String, Date> {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    @Override
    public Date convert(String s) {
        try {
            return sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
