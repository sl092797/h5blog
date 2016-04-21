package com.victor.h5blog.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.PhotoMapper;
import com.victor.h5blog.dao.VideoMapper;
import com.victor.h5blog.entity.Photo;
import com.victor.h5blog.entity.PhotoExample;
import com.victor.h5blog.entity.Video;
import com.victor.h5blog.entity.VideoExample;
import com.victor.h5blog.exception.UploadException;

@Service
public class VideoService{
	@Autowired
	private VideoMapper videoDao;
	
	public Video selectById(Long id){
		return videoDao.selectByPrimaryKey(id);
	}
	
	public List<Video> findByCatlogId(Long catlogId){
		VideoExample e = new VideoExample();
		e.createCriteria().andCatlogIdEqualTo(catlogId);
		return videoDao.selectByExample(e);
	}
	
	
	public void deleteVideoById(HttpServletRequest request,Long id){
		Video v = this.selectById(id);
		if(v.getVideoOriginalpath()!=null){
			 File file = new File(request.getSession().getServletContext().getRealPath(File.separator)+v.getVideoOriginalpath());
			 if(file.exists()){
				 file.delete();
			 }
		}
		if(v.getVideoCompressedpath()!=null){
			 File file = new File(request.getSession().getServletContext().getRealPath(File.separator)+v.getVideoCompressedpath());
			 if(file.exists()){
				 file.delete();
			 }
		}
		if(v.getVideoPosterpath()!=null){
			 File file = new File(request.getSession().getServletContext().getRealPath(File.separator)+v.getVideoPosterpath());
			 if(file.exists()){
				 file.delete();
			 }
		}
		videoDao.deleteByPrimaryKey(id);
	}

	public void addVideo(Video record){
		videoDao.insert(record);
	}
}
