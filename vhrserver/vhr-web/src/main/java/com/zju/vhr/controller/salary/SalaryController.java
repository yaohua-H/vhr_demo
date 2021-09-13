package com.zju.vhr.controller.salary;

import com.zju.vhr.model.RespBean;
import com.zju.vhr.model.Salary;
import com.zju.vhr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SalaryController
 * @Description
 * @Author Administrator
 * @Date 2021/5/8 13:15
 * @Version
 */
@RestController
@RequestMapping("/salary/sob")
public class SalaryController {

    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getSalaries(){
        return salaryService.getAllSalaries();
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary){
        if(salaryService.addSalary(salary) == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id){
        if(salaryService.deleteSalaryById(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateSalaryById(@RequestBody Salary salary){
        if(salaryService.updateSalaryById(salary) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
