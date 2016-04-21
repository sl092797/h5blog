package com.victor.h5blog.entity.vo;

import java.util.List;

import com.victor.h5blog.entity.Photo;

public class GalleryVo extends CatlogVo{
	private List<Photo> photoList;

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}
}
