package com.victor.h5blog.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.PageTemplateArea;
import com.victor.h5blog.entity.PageTemplateAreaExample;


@Repository
public interface PageTemplateAreaDao {
    int countByExample(PageTemplateAreaExample example);

    int deleteByExample(PageTemplateAreaExample example);

    int deleteByPrimaryKey(Long pgTplArea);

    int insert(PageTemplateArea record);

    int insertSelective(PageTemplateArea record);

    List<PageTemplateArea> selectByExample(PageTemplateAreaExample example);
    
    List<String> selectAreaNameByExample(PageTemplateAreaExample example);

    PageTemplateArea selectByPrimaryKey(Long pgTplArea);
    
    List<PageTemplateArea> selectByPageDefKey(Map<String, Long> param);

    int updateByExampleSelective(@Param("record") PageTemplateArea record, @Param("example") PageTemplateAreaExample example);

    int updateByExample(@Param("record") PageTemplateArea record, @Param("example") PageTemplateAreaExample example);

    int updateByPrimaryKeySelective(PageTemplateArea record);

    int updateByPrimaryKey(PageTemplateArea record);
}