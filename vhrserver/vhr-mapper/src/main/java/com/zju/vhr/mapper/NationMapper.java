package com.zju.vhr.mapper;

import com.zju.vhr.model.Nation;

import java.util.List;

/**
 * @ClassName NationMapper
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 17:02
 * @Version
 */
public interface NationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Nation record);

    int insertSelective(Nation record);

    Nation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Nation record);

    int updateByPrimaryKey(Nation record);

    List<Nation> getAllNations();

}
