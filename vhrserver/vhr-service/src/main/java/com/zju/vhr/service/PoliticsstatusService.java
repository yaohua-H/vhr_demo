package com.zju.vhr.service;

import com.zju.vhr.mapper.PoliticsstatusMapper;
import com.zju.vhr.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PoliticsstatusService
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 17:00
 * @Version
 */
@Service
public class PoliticsstatusService {

    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsstatus(){
        return politicsstatusMapper.getAllPoliticsstatus();
    }


}
