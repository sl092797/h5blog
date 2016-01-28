package com.victor.h5blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.PageComVal;
import com.victor.h5blog.entity.PageComValExample;

@Repository
public interface PageComValDao {
    int countByExample(PageComValExample example);

    int deleteByExample(PageComValExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PageComVal record);

    int insertSelective(PageComVal record);

    List<PageComVal> selectByExample(PageComValExample example);

    PageComVal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PageComVal record, @Param("example") PageComValExample example);

    int updateByExample(@Param("record") PageComVal record, @Param("example") PageComValExample example);

    int updateByPrimaryKeySelective(PageComVal record);

    int updateByPrimaryKey(PageComVal record);
}