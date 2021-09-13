package com.zju.vhr.mapper;

import com.zju.vhr.model.Department;

import java.util.List;

/**
 * @ClassName DepartmentMapper
 * @Description
 * @Author Administrator
 * @Date 2021/4/29 21:00
 * @Version
 */
public interface DepartmentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    List<Department> getAllDepartmentsByParentId(Integer pid);

    void addDep(Department dep);

    void deleteDepById(Department dep);

    List<Department> getAllDepartmentsWithOutChildren();
}
