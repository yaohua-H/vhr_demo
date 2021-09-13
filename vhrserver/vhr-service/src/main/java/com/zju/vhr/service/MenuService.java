package com.zju.vhr.service;

import com.zju.vhr.mapper.MenuMapper;
import com.zju.vhr.mapper.MenuRoleMapper;
import com.zju.vhr.model.Menu;
import com.zju.vhr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName MenuService
 * @Description
 * @Author Administrator
 * @Date 2021/4/27 15:52
 * @Version
 */
@Service
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {

    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getMenusByHrId(){
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }

    @Cacheable
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }

    public List<Menu> getAllMenus(){
        return menuMapper.getAllMenus();
    }

    public List<Integer> getMidsByRid(Integer rid){
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids){
        menuRoleMapper.deleteByRid(rid);
        if(mids == null || mids.length == 0){
            return true;
        }
        return menuRoleMapper.insertRecord(rid,mids) == mids.length;
    }

}
