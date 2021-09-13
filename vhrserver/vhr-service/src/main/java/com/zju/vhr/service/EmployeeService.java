package com.zju.vhr.service;

import com.zju.vhr.mapper.EmployeeMapper;
import com.zju.vhr.model.Employee;
import com.zju.vhr.model.MailConstants;
import com.zju.vhr.model.MailSendLog;
import com.zju.vhr.model.RespPageBean;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @ClassName EmployeeService
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 16:59
 * @Version
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    MailSendLogService mailSendLogService;

    public final static Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    public RespPageBean getEmployeeByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope){
        if(page != null && size != null){
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, employee, beginDateScope);
        Long total = employeeMapper.getTotal(employee,beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee){
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        //计算合同期限
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employeeMapper.insertSelective(employee);
        if(result == 1){
            Employee emp = employeeMapper.getEmployeeById(employee.getId());
            //生成消息的唯一标识
            String msgId = UUID.randomUUID().toString();
            MailSendLog mailSendLog = new MailSendLog();
            mailSendLog.setMsgId(msgId);
            mailSendLog.setCreateTime(new Date());
            mailSendLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
            mailSendLog.setRouteKey(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailSendLog.setEmpId(emp.getId());
            mailSendLog.setTryTime(new Date(System.currentTimeMillis() + 1000 * 60 * MailConstants.MSG_TIMEOUT));
            mailSendLogService.insert(mailSendLog);
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, emp, new CorrelationData(msgId));
        }
        return result;
    }

    public Integer maxWorkID(){
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpByEid(Integer id){
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmp(Employee emp){
        return employeeMapper.updateByPrimaryKeySelective(emp);
    }

   public Integer addEmps(List<Employee> list){
        return employeeMapper.addEmps(list);
   }


   public RespPageBean getEmployeeByPageWithSalary(Integer page, Integer size){
        if(page != null && size != null){
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPageWithSalary(page, size);
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(data);
        respPageBean.setTotal(employeeMapper.getTotal(null,null));
        return respPageBean;
   }

   public Integer updateEmployeeSalaryById(Integer eid, Integer sid){
        return employeeMapper.updateEmployeeSalaryById(eid,sid);
   }

   public Employee getEmployeeById(Integer id){
        return employeeMapper.getEmployeeById(id);
   }


}
