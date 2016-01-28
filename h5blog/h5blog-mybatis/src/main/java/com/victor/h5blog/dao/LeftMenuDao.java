package com.victor.h5blog.dao;

import com.victor.h5blog.entity.LeftMenu;
import com.victor.h5blog.entity.LeftMenuExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeftMenuDao {
    int countByExample(LeftMenuExample example);

    int deleteByExample(LeftMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LeftMenu record);

    int insertSelective(LeftMenu record);

    List<LeftMenu> selectByExample(LeftMenuExample example);

    LeftMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") LeftMenu record, @Param("example") LeftMenuExample example);

    int updateByExample(@Param("record") LeftMenu record, @Param("example") LeftMenuExample example);

    int updateByPrimaryKeySelective(LeftMenu record);

    int updateByPrimaryKey(LeftMenu record);
}