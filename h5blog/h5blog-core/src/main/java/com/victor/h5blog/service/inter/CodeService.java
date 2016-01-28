package com.victor.h5blog.service.inter;

import java.util.ArrayList;

import com.victor.h5blog.entity.Code;

public interface CodeService {

	public ArrayList<Code> findAllCodes(String codeType);
}
