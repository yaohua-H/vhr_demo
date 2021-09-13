package com.zju.vhr.service;

import com.zju.vhr.mapper.NationMapper;
import com.zju.vhr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName NationService
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 17:00
 * @Version
 */
@Service
public class NationService {
    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations(){
        return nationMapper.getAllNations();
    }
}
