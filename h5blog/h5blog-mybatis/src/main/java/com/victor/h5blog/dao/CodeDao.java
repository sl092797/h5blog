package com.victor.h5blog.dao;

import com.victor.h5blog.entity.Code;
import com.victor.h5blog.entity.CodeExample;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	int countByExample(CodeExample example);

	int deleteByExample(CodeExample example);

	int deleteByPrimaryKey(Long codeId);

	int insert(Code record);

	int insertSelective(Code record);

	List<Code> selectByExample(CodeExample example);

	Code selectByPrimaryKey(Long codeId);

	int updateByExampleSelective(@Param("record") Code record,
			@Param("example") CodeExample example);

	int updateByExample(@Param("record") Code record,
			@Param("example") CodeExample example);

	int updateByPrimaryKeySelective(Code record);

	int updateByPrimaryKey(Code record);

	ArrayList<Code> selectCodeByType(String codeType);
}