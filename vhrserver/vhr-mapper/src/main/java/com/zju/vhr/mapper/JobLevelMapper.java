package com.zju.vhr.mapper;

import com.zju.vhr.model.JobLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName JobLevelMapper
 * @Description
 * @Author Administrator
 * @Date 2021/4/30 11:53
 * @Version
 */
public interface JobLevelMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(JobLevel record);

    int insertSelective(JobLevel record);

    JobLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobLevel record);

    int updateByPrimaryKey(JobLevel record);

    List<JobLevel> getAllJobLevels();

    Integer deleteJobLevelsByIds(@Param("ids") Integer[] ids);
}
