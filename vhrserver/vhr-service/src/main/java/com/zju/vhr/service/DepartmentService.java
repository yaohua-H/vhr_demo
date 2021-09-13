package com.zju.vhr.service;

import com.zju.vhr.mapper.DepartmentMapper;
import com.zju.vhr.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DepartmentService
 * @Description
 * @Author Administrator
 * @Date 2021/4/29 23:44
 * @Version
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments(){
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    public void addDep(Department department){
        department.setEnabled(true);
        departmentMapper.addDep(department);
    }

    public void deleteDepById(Department dep){
        departmentMapper.deleteDepById(dep);
    }

    public List<Department> getAllDepartmentsWithOutChildren(){
        return departmentMapper.getAllDepartmentsWithOutChildren();
    }


}
