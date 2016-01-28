package com.victor.h5blog.dao;

import com.victor.h5blog.entity.PageDefAreaCom;
import com.victor.h5blog.entity.PageDefAreaComExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PageDefAreaComDao {
    int countByExample(PageDefAreaComExample example);

    int deleteByExample(PageDefAreaComExample example);

    int deleteByPrimaryKey(Long defAreaComId);

    int insert(PageDefAreaCom record);

    int insertSelective(PageDefAreaCom record);

    List<PageDefAreaCom> selectByExample(PageDefAreaComExample example);

    PageDefAreaCom selectByPrimaryKey(Long defAreaComId);

    int updateByExampleSelective(@Param("record") PageDefAreaCom record, @Param("example") PageDefAreaComExample example);

    int updateByExample(@Param("record") PageDefAreaCom record, @Param("example") PageDefAreaComExample example);

    int updateByPrimaryKeySelective(PageDefAreaCom record);

    int updateByPrimaryKey(PageDefAreaCom record);
}