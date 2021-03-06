package com.zju.vhr.controller.salary;


import com.zju.vhr.model.RespBean;
import com.zju.vhr.model.RespPageBean;
import com.zju.vhr.model.Salary;
import com.zju.vhr.service.EmployeeService;
import com.zju.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SobConfigController
 * @Description
 * @Author Administrator
 * @Date 2021/5/8 15:43
 * @Version
 */
@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPageWithSalary(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size ){
        return employeeService.getEmployeeByPageWithSalary(page,size);
    }

    @GetMapping("/salaries")
    public List<Salary> getAllSalaries(){
        return salaryService.getAllSalaries();
    }

    @PutMapping("/")
    public RespBean updateEmployeeSalaryById(Integer eid, Integer sid){
        Integer result = employeeService.updateEmployeeSalaryById(eid, sid);
        if(result == 1 || result == 2){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
