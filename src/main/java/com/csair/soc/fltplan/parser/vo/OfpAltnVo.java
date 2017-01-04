package com.csair.soc.fltplan.parser.vo;

import java.io.Serializable;


/*
 * 飞行计划备降场信息表:存放飞行计划备降场信�?
 *author:xt
 */
public class OfpAltnVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7230902389611228319L;
	
	private String ofpNr;//飞行计划编号
	private String altnSeqNr;//备降场顺序号
	private String altnIcaoCd;//备降场四字代�?
	private String altnIataCd;//备降场三字代�?
	private String altnMora;//MORA
	private String altnDist;//距离
	private String altnFl;//飞行高度�?
	private String altnWc;//平均高空�?
	private String altnEet;//预计飞行时间
	private String altnEta;//预计到达时间
	private String altnTime;//时间
	private String altnTimeDiff;//时间�?
	private String altnFuel;//油量
	private String altnFuelDiff;//油量�?
	private String altnDesc;//备降航路描述
	private String operDt;//操作时间
	public String getOfpNr() {
		return ofpNr;
	}
	public void setOfpNr(String ofpNr) {
		this.ofpNr = ofpNr;
	}
	public String getAltnSeqNr() {
		return altnSeqNr;
	}
	public void setAltnSeqNr(String altnSeqNr) {
		this.altnSeqNr = altnSeqNr;
	}
	public String getAltnIcaoCd() {
		return altnIcaoCd;
	}
	public void setAltnIcaoCd(String altnIcaoCd) {
		this.altnIcaoCd = altnIcaoCd;
	}
	public String getAltnIataCd() {
		return altnIataCd;
	}
	public String getAltnEet() {
		return altnEet;
	}
	public void setAltnEet(String altnEet) {
		this.altnEet = altnEet;
	}
	public String getAltnEta() {
		return altnEta;
	}
	public void setAltnEta(String altnEta) {
		this.altnEta = altnEta;
	}
	public void setAltnIataCd(String altnIataCd) {
		this.altnIataCd = altnIataCd;
	}
	public String getAltnMora() {
		return altnMora;
	}
	public void setAltnMora(String altnMora) {
		this.altnMora = altnMora;
	}
	public String getAltnDist() {
		return altnDist;
	}
	public void setAltnDist(String altnDist) {
		this.altnDist = altnDist;
	}
	public String getAltnFl() {
		return altnFl;
	}
	public void setAltnFl(String altnFl) {
		this.altnFl = altnFl;
	}
	public String getAltnWc() {
		return altnWc;
	}
	public void setAltnWc(String altnWc) {
		this.altnWc = altnWc;
	}
	public String getAltnTime() {
		return altnTime;
	}
	public void setAltnTime(String altnTime) {
		this.altnTime = altnTime;
	}
	public String getAltnTimeDiff() {
		return altnTimeDiff;
	}
	public void setAltnTimeDiff(String altnTimeDiff) {
		this.altnTimeDiff = altnTimeDiff;
	}
	public String getAltnFuel() {
		return altnFuel;
	}
	public void setAltnFuel(String altnFuel) {
		this.altnFuel = altnFuel;
	}
	public String getAltnFuelDiff() {
		return altnFuelDiff;
	}
	public void setAltnFuelDiff(String altnFuelDiff) {
		this.altnFuelDiff = altnFuelDiff;
	}
	public String getAltnDesc() {
		return altnDesc;
	}
	public void setAltnDesc(String altnDesc) {
		this.altnDesc = altnDesc;
	}
	public String getOperDt() {
		return operDt;
	}
	public void setOperDt(String operDt) {
		this.operDt = operDt;
	}
	
	
	
	
}
