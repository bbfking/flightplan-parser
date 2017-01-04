package com.csair.soc.fltplan.parser.vo;

import java.io.Serializable;

public class OfpEtopsVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6613261169758019267L;
	
	private String ofpNr;//外键，关联飞行计划信息表的主键ID
	private String etopsNr;//等时点序�?
	private String etopCd1;//机场1
	private String etopCd2;//机场2
	private String maxArv;//�?晚到达时间（yyyyMMddhhmmss加减hhmm�?
	private String minArv;//�?早到达时间（yyyyMMddhhmmss
	private String eet;//预计到达等时点的飞行时间	HHMM
	private String reqFuel;//到达等时点所�?油量
	private String lon;//等时点经度E155 01.8
	private String lat;//等时点纬度N42 36.0
	private String beforeNm;//等时点距�?
	private String	wind1;//等时点平均风1
	private String	wind2;//等时点平均风2
	private String	ete;//改航时间（hhmm�?0220
	private String	diverFuel;//�?�?改航油量 064512
	private String	reqAltnFuel;//�?�?备降油量 053142
	private String	operTm;//入库/更新时间 yyyyMMddHHmmss
	
	public String getOfpNr() {
		return ofpNr;
	}
	public void setOfpNr(String ofpNr) {
		this.ofpNr = ofpNr;
	}	
	public String getEtopCd1() {
		return etopCd1;
	}
	public void setEtopCd1(String etopCd1) {
		this.etopCd1 = etopCd1;
	}
	public String getEtopCd2() {
		return etopCd2;
	}
	public void setEtopCd2(String etopCd2) {
		this.etopCd2 = etopCd2;
	}
	public String getEtopsNr() {
		return etopsNr;
	}
	public void setEtopsNr(String etopsNr) {
		this.etopsNr = etopsNr;
	}
	public String getMaxArv() {
		return maxArv;
	}
	public void setMaxArv(String maxArv) {
		this.maxArv = maxArv;
	}
	public String getMinArv() {
		return minArv;
	}
	public void setMinArv(String minArv) {
		this.minArv = minArv;
	}
	public String getEet() {
		return eet;
	}
	public void setEet(String eet) {
		this.eet = eet;
	}
	public String getReqFuel() {
		return reqFuel;
	}
	public void setReqFuel(String reqFuel) {
		this.reqFuel = reqFuel;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getBeforeNm() {
		return beforeNm;
	}
	public void setBeforeNm(String beforeNm) {
		this.beforeNm = beforeNm;
	}
	public String getWind1() {
		return wind1;
	}
	public void setWind1(String wind1) {
		this.wind1 = wind1;
	}
	public String getWind2() {
		return wind2;
	}
	public void setWind2(String wind2) {
		this.wind2 = wind2;
	}
	public String getEte() {
		return ete;
	}
	public void setEte(String ete) {
		this.ete = ete;
	}
	public String getDiverFuel() {
		return diverFuel;
	}
	public void setDiverFuel(String diverFuel) {
		this.diverFuel = diverFuel;
	}
	public String getReqAltnFuel() {
		return reqAltnFuel;
	}
	public void setReqAltnFuel(String reqAltnFuel) {
		this.reqAltnFuel = reqAltnFuel;
	}
	public String getOperTm() {
		return operTm;
	}
	public void setOperTm(String operTm) {
		this.operTm = operTm;
	}
	
}
