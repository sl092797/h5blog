package com.victor.h5blog.dao;

import com.victor.h5blog.entity.PageTemplate;
import com.victor.h5blog.entity.PageTemplateExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PageTemplateDao {
    int countByExample(PageTemplateExample example);

    int deleteByExample(PageTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PageTemplate record);

    int insertSelective(PageTemplate record);

    List<PageTemplate> selectByExample(PageTemplateExample example);

    PageTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PageTemplate record, @Param("example") PageTemplateExample example);

    int updateByExample(@Param("record") PageTemplate record, @Param("example") PageTemplateExample example);

    int updateByPrimaryKeySelective(PageTemplate record);

    int updateByPrimaryKey(PageTemplate record);
}