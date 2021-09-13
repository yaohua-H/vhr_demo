package com.zju.vhr.mapper;

import com.zju.vhr.model.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName PositionMapper
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 15:30
 * @Version
 */
public interface PositionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    List<Position> getAllPositions();

    Integer deletePositionsByIds(@Param("ids") Integer[] ids);

}
