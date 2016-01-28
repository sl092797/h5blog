package com.victor.h5blog.dao;

import com.victor.h5blog.entity.PageDef;
import com.victor.h5blog.entity.PageDefExample;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PageDefDao {
	int countByExample(PageDefExample example);

	int deleteByExample(PageDefExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PageDef record);

	int insertSelective(PageDef record);

	List<PageDef> selectByExample(PageDefExample example);

	PageDef selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PageDef record,
			@Param("example") PageDefExample example);

	int updateByExample(@Param("record") PageDef record,
			@Param("example") PageDefExample example);

	int updateByPrimaryKeySelective(PageDef record);

	int updateByPrimaryKey(PageDef record);

	ArrayList<PageDef> getPagesByAuthCode(String authCode);
}