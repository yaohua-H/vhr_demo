package com.zju.vhr.mapper;

import com.zju.vhr.model.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName MenuRoleMapper
 * @Description
 * @Author Administrator
 * @Date 2021/4/27 15:54
 * @Version
 */
public interface MenuRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MenuRole record);

    int insertSelective(MenuRole record);

    MenuRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MenuRole record);

    int updateByPrimaryKey(MenuRole record);

    void deleteByRid(Integer id);

    Integer insertRecord(@Param("rid") Integer rid,
                         @Param("mids") Integer[] mids);

}
