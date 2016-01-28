package com.victor.h5blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.PageComDef;
import com.victor.h5blog.entity.PageComDefExample;

@Repository
public interface PageComDefDao {
    int countByExample(PageComDefExample example);

    int deleteByExample(PageComDefExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PageComDef record);

    int insertSelective(PageComDef record);

    List<PageComDef> selectByExample(PageComDefExample example);

    PageComDef selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PageComDef record, @Param("example") PageComDefExample example);

    int updateByExample(@Param("record") PageComDef record, @Param("example") PageComDefExample example);

    int updateByPrimaryKeySelective(PageComDef record);

    int updateByPrimaryKey(PageComDef record);
}