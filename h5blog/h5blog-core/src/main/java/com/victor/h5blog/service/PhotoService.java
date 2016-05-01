package com.victor.h5blog.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.h5blog.dao.PhotoMapper;
import com.victor.h5blog.entity.Photo;
import com.victor.h5blog.entity.PhotoExample;

@Service
public class PhotoService{
	@Autowired
	private PhotoMapper photoDao;
	
	public Photo selectById(Long photoId){
		return photoDao.selectByPrimaryKey(photoId);
	}
	
	public List<Photo> findByGalleryId(Long galleryId){
		PhotoExample pe = new PhotoExample();
		pe.createCriteria().andCatlogIdEqualTo(galleryId);
		return photoDao.selectByExample(pe);
	}
	
	public void deletePhotosByGalleryId(HttpServletRequest request,Long galleryId){
		List<Photo> plist = this.findByGalleryId(galleryId);
		for(Photo p:plist){
			this.deletePhotoById(request,p.getPhotoId());
		}
	}
	
	public void deletePhotoById(HttpServletRequest request,Long photoId){
		Photo p = this.selectById(photoId);
		if(p.getPhotoPath()!=null){
			 File file = new File(request.getSession().getServletContext().getRealPath(File.separator)+p.getPhotoPath());
			 if(file.exists()){
				 file.delete();
			 }
		}
		photoDao.deleteByPrimaryKey(photoId);
	}

	public void addPhoto(Photo photo){
		photoDao.insert(photo);
	}
}
