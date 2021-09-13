package com.zju.vhr.mapper;

import com.zju.vhr.model.Menu;

import java.util.List;

public interface MenuMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Menu menu);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getMenusByHrId(Integer hrid);

    List<Menu> getAllMenusWithRole();

    List<Menu> getAllMenus();

    List<Integer> getMidsByRid(Integer rid);


}
