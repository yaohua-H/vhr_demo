package com.zju.vhr.service;

import com.zju.vhr.mapper.RoleMapper;
import com.zju.vhr.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description
 * @Author Administrator
 * @Date 2021/4/29 21:11
 * @Version
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getAllRoles(){
        return roleMapper.getAllRoles();
    }

    public Integer addRole(Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_" + role.getName());
        }
        return roleMapper.insert(role);
    }

    public Integer deleteRoleById(Integer id){
        return roleMapper.deleteByPrimaryKey(id);
    }

}
