package com.zju.vhr.service;

import com.zju.vhr.mapper.SalaryMapper;
import com.zju.vhr.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SalaryService
 * @Description
 * @Author Administrator
 * @Date 2021/5/8 13:17
 * @Version
 */
@Service
public class SalaryService {
    @Autowired
    SalaryMapper salaryMapper;

    public List<Salary> getAllSalaries(){
        return salaryMapper.getAllSalaries();
    }

    public Integer addSalary(Salary salary){
        salary.setCreateDate(new Date());
        return salaryMapper.insertSelective(salary);
    }

    public Integer deleteSalaryById(Integer id){
        return salaryMapper.deleteByPrimaryKey(id);
    }

    public Integer updateSalaryById(Salary salary){
        return salaryMapper.updateByPrimaryKeySelective(salary);
    }
}
