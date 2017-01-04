package com.csair.soc.fltplan.parser.vo;

import java.io.Serializable;

public class OfpRefileVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6564912228361899358L;
	
	
	private String refileFltDt;//二次计划航班日期 
	private String refileFltNr; //二次计划 航班�?
	private String refileFltSuffix;//二次计划航班后缀
	private String refileDepCd; // 二次计划起飞机场，四字码
	private String refileAlnCd;//航空公司代码
	private String ofpNr;//从属飞行计划编号
	private String refileTailNr;//机尾�? 
	private String refileEqpCd;//机型	
	private String refileCruiseMode;//巡航方式
	private String refileAirDistDescription;//航路描述
	private String refileEngineNr;//发动机号
	private String refileEngineDesc;// 发动机备�?
	private String refileAircraftBias;// 飞机损�?�率
	private String refileArvCd; // 二次计划初始放行机场，四字码
	private String refileDepDt;//起飞时间
	private String refileArvDt;//落地时间 
	private String refileRouteDis;//航路距离
	private String refileRouteNr;//航路代号
	private String refileAltncd;	//二次计划 初始放行机场备降�?
	private String refileEte;//二次计划预计飞行时间
	private String refileFl;//二次计划高度层描�?
	
	private String refileStart;//二次计划 起始�?
	private String refileDest;// 二次计划 目的地机�?
	
	private String destRclFuel;//起飞至二放点�?�?油量时间
	private String rclDestFuel;//二放点至初始放行机场�?�?油量和时�?
	private String rclRsvrFuel;//二次放行航路备份油和时间
	private String rclAltnFuel;//目的地机场至主备降的油量和时�?
	private String rclHoldFuel;//目的地机场备降场的等待油量和时间
	private String rclExtrFuel;//二次放行后的额外油量和时�?
	
	private String refileDestFuel;//二次放行机场至目的地机场�?�?油量和时�?
	private String rclPlanFuel;//二放点的计划的剩余用�? 
	private String rclReqdFuel;//二次放行�?�?的油�? 
	
	private String togw;//起飞全重
	private String burn;//航路耗油
	private String lgw;//�?陆全�?
	private String desfl;//下降耗油
	private String fod;//�?陆后剩余油量
	private String time;//计划飞行时间
	private String comp;//平均高空�?
	private String avtas;//平均真空�?
	private String gs;//平均地�??
	private String airmiles;//空中距离
	private String gnd;//地面距离
	
	
	
	public String getRefileFltDt() {
		return refileFltDt;
	}
	public void setRefileFltDt(String refileFltDt) {
		this.refileFltDt = refileFltDt;
	}
	public String getRefileFltNr() {
		return refileFltNr;
	}
	public void setRefileFltNr(String refileFltNr) {
		this.refileFltNr = refileFltNr;
	}
	public String getRefileFltSuffix() {
		return refileFltSuffix;
	}
	public void setRefileFltSuffix(String refileFltSuffix) {
		this.refileFltSuffix = refileFltSuffix;
	}
	public String getRefileDepCd() {
		return refileDepCd;
	}
	public void setRefileDepCd(String refileDepCd) {
		this.refileDepCd = refileDepCd;
	}
	public String getRefileAlnCd() {
		return refileAlnCd;
	}
	public void setRefileAlnCd(String refileAlnCd) {
		this.refileAlnCd = refileAlnCd;
	}
	public String getRefileRouteDis() {
		return refileRouteDis;
	}
	public void setRefileRouteDis(String refileRouteDis) {
		this.refileRouteDis = refileRouteDis;
	}
	public String getRefileRouteNr() {
		return refileRouteNr;
	}
	public void setRefileRouteNr(String refileRouteNr) {
		this.refileRouteNr = refileRouteNr;
	}
	public String getOfpNr() {
		return ofpNr;
	}
	public void setOfpNr(String ofpNr) {
		this.ofpNr = ofpNr;
	}
	public String getRefileTailNr() {
		return refileTailNr;
	}
	public void setRefileTailNr(String refileTailNr) {
		this.refileTailNr = refileTailNr;
	}
	public String getRefileEqpCd() {
		return refileEqpCd;
	}
	public void setRefileEqpCd(String refileEqpCd) {
		this.refileEqpCd = refileEqpCd;
	}
	public String getRefileCruiseMode() {
		return refileCruiseMode;
	}
	public void setRefileCruiseMode(String refileCruiseMode) {
		this.refileCruiseMode = refileCruiseMode;
	}
	public String getRefileAirDistDescription() {
		return refileAirDistDescription;
	}
	public void setRefileAirDistDescription(String refileAirDistDescription) {
		this.refileAirDistDescription = refileAirDistDescription;
	}
	public String getRefileEngineNr() {
		return refileEngineNr;
	}
	public void setRefileEngineNr(String refileEngineNr) {
		this.refileEngineNr = refileEngineNr;
	}
	public String getRefileEngineDesc() {
		return refileEngineDesc;
	}
	public void setRefileEngineDesc(String refileEngineDesc) {
		this.refileEngineDesc = refileEngineDesc;
	}
	public String getRefileAircraftBias() {
		return refileAircraftBias;
	}
	public void setRefileAircraftBias(String refileAircraftBias) {
		this.refileAircraftBias = refileAircraftBias;
	}
	public String getRefileArvCd() {
		return refileArvCd;
	}
	public void setRefileArvCd(String refileArvCd) {
		this.refileArvCd = refileArvCd;
	}
	public String getRefileDepDt() {
		return refileDepDt;
	}
	public void setRefileDepDt(String refileDepDt) {
		this.refileDepDt = refileDepDt;
	}
	public String getRefileArvDt() {
		return refileArvDt;
	}
	public void setRefileArvDt(String refileArvDt) {
		this.refileArvDt = refileArvDt;
	}
	public String getRefileAltncd() {
		return refileAltncd;
	}
	public void setRefileAltncd(String refileAltncd) {
		this.refileAltncd = refileAltncd;
	}
	public String getRefileEte() {
		return refileEte;
	}
	public void setRefileEte(String refileEte) {
		this.refileEte = refileEte;
	}
	public String getRefileFl() {
		return refileFl;
	}
	public void setRefileFl(String refileFl) {
		this.refileFl = refileFl;
	}
	public String getRefileStart() {
		return refileStart;
	}
	public void setRefileStart(String refileStart) {
		this.refileStart = refileStart;
	}
	public String getRefileDest() {
		return refileDest;
	}
	public void setRefileDest(String refileDest) {
		this.refileDest = refileDest;
	}
	public String getDestRclFuel() {
		return destRclFuel;
	}
	public void setDestRclFuel(String destRclFuel) {
		this.destRclFuel = destRclFuel;
	}
	public String getRclDestFuel() {
		return rclDestFuel;
	}
	public void setRclDestFuel(String rclDestFuel) {
		this.rclDestFuel = rclDestFuel;
	}
	public String getRclRsvrFuel() {
		return rclRsvrFuel;
	}
	public void setRclRsvrFuel(String rclRsvrFuel) {
		this.rclRsvrFuel = rclRsvrFuel;
	}
	public String getRclAltnFuel() {
		return rclAltnFuel;
	}
	public void setRclAltnFuel(String rclAltnFuel) {
		this.rclAltnFuel = rclAltnFuel;
	}
	public String getRclHoldFuel() {
		return rclHoldFuel;
	}
	public void setRclHoldFuel(String rclHoldFuel) {
		this.rclHoldFuel = rclHoldFuel;
	}
	public String getRclExtrFuel() {
		return rclExtrFuel;
	}
	public void setRclExtrFuel(String rclExtrFuel) {
		this.rclExtrFuel = rclExtrFuel;
	}
	public String getRefileDestFuel() {
		return refileDestFuel;
	}
	public void setRefileDestFuel(String refileDestFuel) {
		this.refileDestFuel = refileDestFuel;
	}
	public String getRclPlanFuel() {
		return rclPlanFuel;
	}
	public void setRclPlanFuel(String rclPlanFuel) {
		this.rclPlanFuel = rclPlanFuel;
	}
	public String getRclReqdFuel() {
		return rclReqdFuel;
	}
	public void setRclReqdFuel(String rclReqdFuel) {
		this.rclReqdFuel = rclReqdFuel;
	}
	public String getTogw() {
		return togw;
	}
	public void setTogw(String togw) {
		this.togw = togw;
	}
	public String getBurn() {
		return burn;
	}
	public void setBurn(String burn) {
		this.burn = burn;
	}
	public String getLgw() {
		return lgw;
	}
	public void setLgw(String lgw) {
		this.lgw = lgw;
	}
	public String getDesfl() {
		return desfl;
	}
	public void setDesfl(String desfl) {
		this.desfl = desfl;
	}
	public String getFod() {
		return fod;
	}
	public void setFod(String fod) {
		this.fod = fod;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getComp() {
		return comp;
	}
	public void setComp(String comp) {
		this.comp = comp;
	}
	public String getAvtas() {
		return avtas;
	}
	public void setAvtas(String avtas) {
		this.avtas = avtas;
	}
	public String getGs() {
		return gs;
	}
	public void setGs(String gs) {
		this.gs = gs;
	}
	public String getAirmiles() {
		return airmiles;
	}
	public void setAirmiles(String airmiles) {
		this.airmiles = airmiles;
	}
	public String getGnd() {
		return gnd;
	}
	public void setGnd(String gnd) {
		this.gnd = gnd;
	}
	
	
	
}
