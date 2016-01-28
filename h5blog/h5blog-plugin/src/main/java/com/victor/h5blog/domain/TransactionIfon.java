package com.victor.h5blog.domain;

import com.victor.h5blog.utils.CommUtils;

public class TransactionIfon {
	
	private String tranDate;//��������
	private String shopName;//�̻�����
	private String tranDesc;//��������
	private String currTrans;//���ױ���
	private String amtTrans;//���׽��
	
	private CommUtils commUtils = new CommUtils();
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	public String getTranDate() {
		return commUtils.formDate(this.tranDate);
	}
	public String getTranDesc() {
		return tranDesc;
	}
	public void setTranDesc(String tranDesc) {
		this.tranDesc = tranDesc;
	}
	public String getCurrTrans() {
		return currTrans;
	}
	public void setCurrTrans(String currTrans) {
		this.currTrans = currTrans;
	}
	public String getAmtTrans() {
		return amtTrans;
	}
	public void setAmtTrans(String amtTrans) {
		this.amtTrans = amtTrans;
	}
}
