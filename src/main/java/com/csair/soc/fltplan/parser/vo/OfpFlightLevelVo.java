package com.csair.soc.fltplan.parser.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


/*
 * 飞行计划高度层信息表:存放飞行计划高度层信息
 *author:xt
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OfpFlightlevelInfoVO")
public class OfpFlightLevelVo implements Serializable {

	/**
	 * 
	 */
	
	//---------add--------
	private String type;//判断属于是一次放行还是二次放行
	//---------add--------
	private String uploadTm;
	
	
	private static final long serialVersionUID = 6736706799681433988L;
	private String ofpNr;//飞行计划编号
	private String flightLevel;//高度层
	private int flSeqNr;//高度层顺序号
	private String ztm;//航段飞行时间
	private String time;//由起飞机场至当前航路点总飞行时间
	private String posn;//航路点名称
	private String awy;//高空航路名称
	private String dst;//至下个导航点的距离
	private String dtgo;//从当前导航点到目的地机场的距离
	private String mach;//空速马赫数
	private String tas;//真空速
	private String wind;//高空风数据
	private String efr;//至当前导航点时的预计剩余油量
	private String oat;//高空温度
	private String msa;//最低安全高度
	private String mtk;//磁航向
	private String gs;//地速
	private String ws;//颠簸指数
	private String lon;//航路点经度
	private String lat;//航路点纬度
	private String operDt;//操作时间
	
	
	
	public String getOfpNr() {
		return ofpNr;
	}
	public void setOfpNr(String ofpNr) {
		this.ofpNr = ofpNr;
	}
	public String getFlightLevel() {
		return flightLevel;
	}
	public void setFlightLevel(String flightLevel) {
		this.flightLevel = flightLevel;
	}
	public String getWs() {
		return ws;
	}
	public void setWs(String ws) {
		this.ws = ws;
	}
	public int getFlSeqNr() {
		return flSeqNr;
	}
	public void setFlSeqNr(int flSeqNr) {
		this.flSeqNr = flSeqNr;
	}
	public String getZtm() {
		return ztm;
	}
	public void setZtm(String ztm) {
		this.ztm = ztm;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPosn() {
		return posn;
	}
	public void setPosn(String posn) {
		this.posn = posn;
	}
	public String getAwy() {
		return awy;
	}
	public void setAwy(String awy) {
		this.awy = awy;
	}
	public String getDst() {
		return dst;
	}
	public void setDst(String dst) {
		this.dst = dst;
	}
	public String getDtgo() {
		return dtgo;
	}
	public void setDtgo(String dtgo) {
		this.dtgo = dtgo;
	}
	public String getMach() {
		return mach;
	}
	public void setMach(String mach) {
		this.mach = mach;
	}
	public String getTas() {
		return tas;
	}
	public void setTas(String tas) {
		this.tas = tas;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getEfr() {
		return efr;
	}
	
	public String getUploadTm() {
		return uploadTm;
	}
	public void setUploadTm(String uploadTm) {
		this.uploadTm = uploadTm;
	}
	public void setEfr(String efr) {
		this.efr = efr;
	}
	public String getOat() {
		return oat;
	}
	public void setOat(String oat) {
		this.oat = oat;
	}
	public String getMsa() {
		return msa;
	}
	public void setMsa(String msa) {
		this.msa = msa;
	}
	public String getMtk() {
		return mtk;
	}
	public void setMtk(String mtk) {
		this.mtk = mtk;
	}
	public String getGs() {
		return gs;
	}
	public void setGs(String gs) {
		this.gs = gs;
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
	public String getOperDt() {
		return operDt;
	}
	public void setOperDt(String operDt) {
		this.operDt = operDt;
	}
	
	
}
