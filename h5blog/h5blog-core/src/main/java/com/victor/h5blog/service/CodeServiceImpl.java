package com.victor.h5blog.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.CodeDao;
import com.victor.h5blog.entity.Code;
import com.victor.h5blog.service.inter.CodeService;

@Service("codeService")
public class CodeServiceImpl implements CodeService {

	@Autowired
	private CodeDao codeDao;

	@Override
	public ArrayList<Code> findAllCodes(String codeType) {
		return codeDao.selectCodeByType(codeType);
	}

}
