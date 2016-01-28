package com.victor.h5blog.dao;

import com.victor.h5blog.entity.PageCom;
import com.victor.h5blog.entity.PageComExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PageComDao {
    int countByExample(PageComExample example);

    int deleteByExample(PageComExample example);

    int deleteByPrimaryKey(Long id);

    Long insert(PageCom record);

    int insertSelective(PageCom record);

    List<PageCom> selectByExampleWithBLOBs(PageComExample example);

    List<PageCom> selectByExample(PageComExample example);

    PageCom selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PageCom record, @Param("example") PageComExample example);

    int updateByExampleWithBLOBs(@Param("record") PageCom record, @Param("example") PageComExample example);

    int updateByExample(@Param("record") PageCom record, @Param("example") PageComExample example);

    int updateByPrimaryKeySelective(PageCom record);

    int updateByPrimaryKeyWithBLOBs(PageCom record);

    int updateByPrimaryKey(PageCom record);
}