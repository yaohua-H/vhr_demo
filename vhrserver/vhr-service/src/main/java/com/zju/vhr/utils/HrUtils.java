package com.zju.vhr.utils;

import com.zju.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @ClassName HrUtils
 * @Description
 * @Author Administrator
 * @Date 2021/4/27 13:29
 * @Version
 */
public class HrUtils {

    public static Hr getCurrentHr(){
            return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
