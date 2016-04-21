package com.victor.h5blog.dao;

import com.victor.h5blog.entity.Catlog;
import com.victor.h5blog.entity.CatlogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface CatlogMapper {
    int countByExample(CatlogExample example);

    int deleteByExample(CatlogExample example);

    int deleteByPrimaryKey(Long catlogId);

    int insert(Catlog record);

    int insertSelective(Catlog record);

    List<Catlog> selectByExample(CatlogExample example);

    Catlog selectByPrimaryKey(Long catlogId);

    int updateByExampleSelective(@Param("record") Catlog record, @Param("example") CatlogExample example);

    int updateByExample(@Param("record") Catlog record, @Param("example") CatlogExample example);

    int updateByPrimaryKeySelective(Catlog record);

    int updateByPrimaryKey(Catlog record);
}