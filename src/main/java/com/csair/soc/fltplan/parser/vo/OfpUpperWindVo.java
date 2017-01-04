package com.csair.soc.fltplan.parser.vo;

import java.io.Serializable;

public class OfpUpperWindVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9002716060366568804L;
	private String ofpNr;//飞行计划编号
	private String wpNr;//航路点编�?
	private String wayPoint;//航路�?
	private String fl;//高度�?
	private String flTemper;//高度层对应的气象预报
	private String operTm;//入库/更新时间 yyyyMMddHHmmss
	public String getOfpNr() {
		return ofpNr;
	}
	public void setOfpNr(String ofpNr) {
		this.ofpNr = ofpNr;
	}
	public String getWpNr() {
		return wpNr;
	}
	public void setWpNr(String wpNr) {
		this.wpNr = wpNr;
	}
	public String getWayPoint() {
		return wayPoint;
	}
	public void setWayPoint(String wayPoint) {
		this.wayPoint = wayPoint;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getFlTemper() {
		return flTemper;
	}
	public void setFlTemper(String flTemper) {
		this.flTemper = flTemper;
	}
	public String getOperTm() {
		return operTm;
	}
	public void setOperTm(String operTm) {
		this.operTm = operTm;
	}
	
}
