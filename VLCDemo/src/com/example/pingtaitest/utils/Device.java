package com.example.pingtaitest.utils;

public class Device {
	private String devKey; //设备key
    private String devid;  //设备id
	private int online;    //在线状态
	private int ptzFlag;   //PTZ控制能力
	private int reverseFlag; //反转倒置能力标示
	private String video;  //视频编码能力
	
	public Device() {
		super();
	}
	public Device(String devKey, String devid, int online, int ptzFlag, int reverseFlag, String video) {
		super();
		this.devKey = devKey;
		this.devid = devid;
		this.online = online;
		this.ptzFlag = ptzFlag;
		this.reverseFlag = reverseFlag;
		this.video = video;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getDevKey() {
		return devKey;
	}
	public void setDevKey(String devKey) {
		this.devKey = devKey;
	}
	public String getDevid() {
		return devid;
	}
	public void setDevid(String devid) {
		this.devid = devid;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public int getPtzFlag() {
		return ptzFlag;
	}
	public void setPtzFlag(int ptzFlag) {
		this.ptzFlag = ptzFlag;
	}
	public int getReverseFlag() {
		return reverseFlag;
	}
	public void setReverseFlag(int reverseFlag) {
		this.reverseFlag = reverseFlag;
	}	
}
