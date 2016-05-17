package com.victor.h5blog.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.FileMapper;
import com.victor.h5blog.dao.PhotoMapper;
import com.victor.h5blog.entity.File;
import com.victor.h5blog.entity.FileExample;
import com.victor.h5blog.entity.Photo;
import com.victor.h5blog.entity.PhotoExample;
import com.victor.h5blog.exception.UploadException;

@Service
public class FileService{
	@Autowired
	private FileMapper fileDao;
	
	public File selectById(Long fileId){
		return fileDao.selectByPrimaryKey(fileId);
	}
	
	public List<File> findByCatlogId(Long catlogId){
		FileExample fe = new FileExample();
		fe.createCriteria().andCatlogIdEqualTo(catlogId);
		return fileDao.selectByExample(fe);
	}
	
	public void deleteByCatlogId(HttpServletRequest request,Long catlogId){
		
	}
	
	public void deleteFileById(HttpServletRequest request,Long fileId){
		File f = this.selectById(fileId);
		if(f.getFilePath()!=null){
			 java.io.File file = new java.io.File(request.getSession().getServletContext().getRealPath(java.io.File.separator)+f.getFilePath());
			 if(file.exists()){
				 file.delete();
			 }
		}
		fileDao.deleteByPrimaryKey(fileId);
	}

	public void addFile(File file){
		fileDao.insert(file);
	}
	
	public void updateFile(File file){
		fileDao.updateByPrimaryKey(file);
	}
}
