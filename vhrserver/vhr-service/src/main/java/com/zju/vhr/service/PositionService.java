package com.zju.vhr.service;

import com.zju.vhr.mapper.PositionMapper;
import com.zju.vhr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PositionService
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 15:26
 * @Version
 */
@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;

    public List<Position> getAllPositions(){
        return positionMapper.getAllPositions();
    }

    public Integer addPosition(Position position){
        position.setCreateDate(new Date());
        position.setEnabled(true);
        return positionMapper.insertSelective(position);
    }

    public Integer updatePositons(Position position){
        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id){
        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionsByIds(Integer[] ids){
        return positionMapper.deletePositionsByIds(ids);
    }
}
