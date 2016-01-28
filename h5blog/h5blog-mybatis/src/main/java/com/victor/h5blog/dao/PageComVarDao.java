package com.victor.h5blog.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.victor.h5blog.entity.PageComVar;
import com.victor.h5blog.entity.PageComVarExample;

@Repository
public interface PageComVarDao {
    int countByExample(PageComVarExample example);

    int deleteByExample(PageComVarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PageComVar record);

    int insertSelective(PageComVar record);

    List<PageComVar> selectByExample(PageComVarExample example);

    PageComVar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PageComVar record, @Param("example") PageComVarExample example);

    int updateByExample(@Param("record") PageComVar record, @Param("example") PageComVarExample example);

    int updateByPrimaryKeySelective(PageComVar record);

    int updateByPrimaryKey(PageComVar record);
}