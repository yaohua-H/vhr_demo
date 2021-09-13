package com.zju.vhr.mapper;

import com.zju.vhr.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @ClassName EmployeeMapper
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 17:02
 * @Version
 */
public interface EmployeeMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeByPage(@Param("page") Integer page,
                                     @Param("size") Integer size,
                                     @Param("emp") Employee employee,
                                     @Param("beginDateScope") Date[] beginDateScope);

    Long getTotal(@Param("emp") Employee emp,
                  @Param("beginDateScope") Date[] beginDateScope);

    Integer maxWorkID();

    Integer addEmps(@Param("list") List<Employee> list);

    Employee getEmployeeById(Integer id);

    List<Employee> getEmployeeByPageWithSalary(@Param("page") Integer page,
                                               @Param("size") Integer size);

    Integer updateEmployeeSalaryById(@Param("eid") Integer eid,
                                     @Param("sid") Integer sid);

}
