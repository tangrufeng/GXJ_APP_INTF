package com.zhuyin.gxj.entity;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DeviceRedisBean implements Serializable{

    private final static long serialVersionUID = -1466826803517713019l;


	private String deviceId ="";

	@NotNull
	private String deviceSN="";


	private long sdSize=0l;

	private long sdUsed=0l;

	private int state=-1;

	private String ip="";

	private String gw="";

	private String dns="";

	private String mac="";

	private String version="";

	private int pingInterval=10000;

	private List<ActionBean> actions=new ArrayList<>();

	public List<ActionBean> getActions() {
		return actions;
	}

	public void setActions(List<ActionBean> actions) {
		this.actions = actions;
	}

	private long lastPingTime=0l;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public long getSdSize() {
		return sdSize;
	}

	public void setSdSize(long sdSize) {
		this.sdSize = sdSize;
	}

	public long getSdUsed() {
		return sdUsed;
	}

	public void setSdUsed(long sdUsed) {
		this.sdUsed = sdUsed;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getGw() {
		return gw;
	}

	public void setGw(String gw) {
		this.gw = gw;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public long getLastPingTime() {
		return lastPingTime;
	}

	public void setLastPingTime(long lastPingTime) {
		this.lastPingTime = lastPingTime;
	}

	public int getPingInterval() {
		return pingInterval;
	}

	public void setPingInterval(int pingInterval) {
		this.pingInterval = pingInterval;
	}

	@Override
	public String toString() {
		return "DeviceRedisBean{" +
				"deviceId='" + deviceId + '\'' +
				", deviceSN='" + deviceSN + '\'' +
				", sdSize=" + sdSize +
				", sdUsed=" + sdUsed +
				", state=" + state +
				", ip='" + ip + '\'' +
				", gw='" + gw + '\'' +
				", dns='" + dns + '\'' +
				", mac='" + mac + '\'' +
				", version='" + version + '\'' +
				", pingInterval=" + pingInterval +
				", actions=" + actions +
				", lastPingTime=" + lastPingTime +
				'}';
	}

	public String getDeviceSN() {
		return deviceSN;
	}

	public void setDeviceSN(String deviceSN) {
		this.deviceSN = deviceSN;
	}

}
