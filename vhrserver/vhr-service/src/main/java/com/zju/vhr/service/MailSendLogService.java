package com.zju.vhr.service;

import com.zju.vhr.mapper.MailSendLogMapper;
import com.zju.vhr.model.MailSendLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MailSendLogService
 * @Description
 * @Author Administrator
 * @Date 2021/5/7 19:06
 * @Version
 */
@Service
public class MailSendLogService {

    @Autowired
    MailSendLogMapper mailsendLogMapper;

    public Integer updateMailSendLogStatus(String msgId, Integer status){
        return mailsendLogMapper.updateMailSendLogStatus(msgId,status);
    }

    public Integer insert(MailSendLog mailSendLog){
        return mailsendLogMapper.insert(mailSendLog);
    }

    public List<MailSendLog> getMailSendLogsByStatus(){
        return mailsendLogMapper.getMailSendLogsByStatus();
    }

    public Integer updateCount(String msgId,Date date){
        return mailsendLogMapper.updateCount(msgId,date);
    }
}
