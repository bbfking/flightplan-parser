package com.csair.soc.fltplan.parser.vo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
  javaBeans
 * ofp_data_info --> OfpDataInfo 
 * <table explanation>
 * @author 2014-09-02 09:32:16
 * 
 */

public class FpVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7000885490853953842L;


	//add-start
	private String dispTime;//计划制作日期
	private String dispSeat;//签派席位
	private String cruiseMode;//巡航方式
	private String airDistDescription;//航路描述
	private String secondLevelCruiseMode;//第二高度层巡航方??
	private String thirdLevelCruiseMode;//第三高度层巡航方??
	private String airmiles;//空中距离
	private String gnd;//地面距离
	private OfpRefileVo ofpRefileVo=new OfpRefileVo();//二次放行??
	private String ete;//预计飞行时间
	private String cruiseFLDescription;//巡航高度描述
	//add-end


	private String fltDt;//航班日期
	private String fltNr; // 航班??
	private String fltSuffix;//	航班后缀
	private String depCd; // 始发站，四字编码
	private String alnCd;//航空公司代码
	private String ofpNr;//飞行计划编号
	private String tailNr;//机尾型号
	private String eqpCd;//机型
	private String engineNr;//发动机号
	private String engineDesc;// 发动机备??
	private String aircraftBias;// 飞机损???率
	private String arvCd; // 到达站，四字??
	private String depDt;//起飞时间
	private String arvDt;//落地时间
	private String airDist;	//空中距离
	private String gndDist;	// 地面距离
	private String altncd;	//目的备降??
	private String tkofAltncd;// 起飞备降??
	private String driftAltnCd;// 飘降备降??

	private String targetFuel;//落地剩余油量
	private String tripFuel;//航路耗油和时??
	private String destFuel;//到目的地机场????油量和时??
	private String rsvrFuel;//初次放行航路备份油和时间
	private String altnFuel;//初始放行场至其备降场的油量和时间
	private String holdFuel;//初始放行场备降的等待油量和时??
	private String extrFuel;//初次放行的额外油量和时间
	private String tkofFuel;//起飞机场油量和时??
	private String taxiOutFuel;//在起飞机场的滑出油量

	private String routeDist;//航路距离
	private String routeNr;//航路代号
	private String loadFuel;//总加油量


	private String etow;//预计起飞重量
	private String mtow;//??大起飞重??
	private String eldw;//预计??陆重??
	private String mldw;//??大着陆重??
	private String ezfw;//预计无油重量
	private String mzfw;//??大无油重??
	private String epld;//预计业载
	private String reqdFuel;//DEST+RSVR+ALTN+HOLD的油量???和
	private String reqdTm;//DEST+RSVR+ALTN+HOLD的时间???和
	private String ci1;// 成本指数
	private String ci2;// 成本指数
	private String mel;// MEL信息

	private String wxprogTm;// 高空风时间段
	private String obsDt;// 观测时间
	private String ofpDt;//飞行计划生成时间
	private String ofpText;//飞行计划内容
	private String rlsText;// 放行单内??
	private String dispName;//签派员名??
	private String dispPhone;//签派员电??
	private String operDt;// 入库时间

	private String togw;//起飞全重
	private String burn;//航路耗油
	private String lgw;//??陆全??
	private String desfl;//下降耗油
	private String fod;//??陆后剩余油量
	private String time;//计划飞行时间
	private String comp;//平均高空??
	private String avtas;//平均真空??
	private String gs;//平均地???



	private String secondLevelEte;//第二高度层预计飞行时??
	private String secondLevelFuel;//第二高度层航路???油
	private String secondLevelZfw;//第二高度层无油重??
	private String secondLevelDesc;//第二高度层描??

	private String thirdLevelEte;//第三高度层预计飞行时??
	private String thirdLevelFuel;//第三高度层航路???油
	private String thirdLevelZfw;//第三高度层无油重??
	private String thirdLevelDesc;//第三高度层描??

	private String descFl;//下降层高??
	private String descFlTemper;//下降层气象预??

	private OfpHeaderVo ofpHeaderVo=new OfpHeaderVo();//航路点信息集?

	private List<OfpWayPointVo> ofpWayPoints=new ArrayList<OfpWayPointVo>();//航路点信息集??

	private List<OfpFlightLevelVo> ofpFlightLevel=new ArrayList<OfpFlightLevelVo>();//高度层信息集??

	private List<OfpAltnVo> ofpAltnVo=new ArrayList<OfpAltnVo>();//备降场信息集??

	private List<OfpUpperWindVo> ofpUpperWindVo=new ArrayList<OfpUpperWindVo>();//高空风集??

	private List<OfpEtopsVo> ofpEtopsVos=new ArrayList<OfpEtopsVo>();//ETOPS集合

	public List<OfpEtopsVo> ofpEtopsVos() {
		return ofpEtopsVos;
	}
	public void setOfpEtopsVos(List<OfpEtopsVo> ofpEtopsVos) {
		this.ofpEtopsVos = ofpEtopsVos;
	}


	public void setOfpHeaderVo(OfpHeaderVo ofpHeaderVo) {
		this.ofpHeaderVo = ofpHeaderVo;
	}


	public OfpHeaderVo getOfpHeaderVo() {
		return ofpHeaderVo;
	}



	public List<OfpUpperWindVo> getOfpUpperWindVo() {
		return ofpUpperWindVo;
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
	public String getCruiseMode() {
		return cruiseMode;
	}

	public String getEte() {
		return ete;
	}

	public void setEte(String ete) {
		this.ete = ete;
	}

	public String getCruiseFLDescription() {
		return cruiseFLDescription;
	}

	public void setCruiseFLDescription(String cruiseFLDescription) {
		this.cruiseFLDescription = cruiseFLDescription;
		this.ofpHeaderVo.setCruiseFLDescription(cruiseFLDescription);
	}

	public void setCruiseMode(String cruiseMode) {
		this.cruiseMode = cruiseMode;
	}
	public String getDesfl() {
		return desfl;
	}

	public String getDispTime() {
		return dispTime;
	}

	public void setDispTime(String dispTime) {
		this.dispTime = dispTime;
		this.ofpHeaderVo.setDispTime(dispName);
	}

	public String getDispSeat() {
		return dispSeat;
	}

	public void setDispSeat(String dispSeat) {
		this.dispSeat = dispSeat;
		this.ofpHeaderVo.setDispSeat(dispSeat);
	}
	public void setDesfl(String desfl) {
		this.desfl = desfl;
	}
	public String getDescFl() {
		return descFl;
	}
	public String getAirDistDescription() {
		return airDistDescription;
	}

	public void setAirDistDescription(String airDistDescription) {
		this.airDistDescription = airDistDescription;
		this.ofpHeaderVo.setAirDistDescription(airDistDescription);
	}
	public void setDescFl(String descFl) {
		this.descFl = descFl;
	}

	public String getDescFlTemper() {
		return descFlTemper;
	}

	public void setDescFlTemper(String descFlTemper) {
		this.descFlTemper = descFlTemper;
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

	public List<OfpEtopsVo> getOfpEtopsVos() {
		return ofpEtopsVos;
	}
	public void setOfpUpperWindVo(List<OfpUpperWindVo> ofpUpperWindVo) {
		this.ofpUpperWindVo = ofpUpperWindVo;
	}

	public String getFltDt() {
		return fltDt;
	}

	public void setFltDt(String fltDt) {
		this.fltDt = fltDt;
		this.ofpHeaderVo.setFltDt(fltDt);
	}

	public String getFltNr() {
		return fltNr;
	}

	public void setFltNr(String fltNr) {
		this.fltNr = fltNr;
	}

	public String getFltSuffix() {
		return fltSuffix;
	}

	public void setFltSuffix(String fltSuffix) {
		this.fltSuffix = fltSuffix;
	}

	public String getDepCd() {
		return depCd;
	}

	public void setDepCd(String depCd) {
		this.depCd = depCd;
		this.ofpHeaderVo.setDepCd(depCd);
	}

	public String getAlnCd() {
		return alnCd;
	}

	public void setAlnCd(String alnCd) {
		this.alnCd = alnCd;
	}

	public String getOfpText() {
		return ofpText;
	}

	public void setOfpText(String ofpText) {
		this.ofpText = ofpText;
	}

	public String getOfpNr() {
		return ofpNr;
	}

	public void setOfpNr(String ofpNr) {
		this.ofpNr = ofpNr;
		this.ofpHeaderVo.setOfpNr(ofpNr);
	}

	public String getTailNr() {
		return tailNr;

	}

	public void setTailNr(String tailNr) {
		this.tailNr = tailNr;
		this.ofpHeaderVo.setTailNr(tailNr);
	}

	public String getEqpCd() {
		return eqpCd;
	}

	public void setEqpCd(String eqpCd) {
		this.eqpCd = eqpCd;
		this.ofpHeaderVo.setEte(eqpCd);
	}

	public String getEngineNr() {
		return engineNr;
	}

	public void setEngineNr(String engineNr) {
		this.engineNr = engineNr;
	}

	public String getEngineDesc() {
		return engineDesc;
	}

	public String getRouteDist() {
		return routeDist;
	}

	public void setRouteDist(String routeDist) {
		this.routeDist = routeDist;
		this.ofpHeaderVo.setRouteDist(routeDist);
	}

	public void setEngineDesc(String engineDesc) {
		this.engineDesc = engineDesc;
	}

	public String getAircraftBias() {
		return aircraftBias;
	}

	public void setAircraftBias(String aircraftBias) {
		this.aircraftBias = aircraftBias;
	}

	public String getArvCd() {
		return arvCd;
	}

	public void setArvCd(String arvCd) {
		this.arvCd = arvCd;
		this.ofpHeaderVo.setArvCd(arvCd);
	}

	public String getDepDt() {
		return depDt;
	}

	public void setDepDt(String depDt) {
		this.depDt = depDt;
		this.ofpHeaderVo.setDepDt(depDt);
	}

	public String getArvDt() {
		return arvDt;
	}

	public void setArvDt(String arvDt) {
		this.arvDt = arvDt;
		this.ofpHeaderVo.setArvDt(arvDt);
	}

	public String getAirDist() {
		return airDist;
	}

	public void setAirDist(String airDist) {
		this.airDist = airDist;
	}

	public String getGndDist() {
		return gndDist;
	}

	public void setGndDist(String gndDist) {
		this.gndDist = gndDist;
	}

	public String getAltncd() {
		return altncd;
	}

	public void setAltncd(String altncd) {
		this.altncd = altncd;
	}

	public String getTkofAltncd() {
		return tkofAltncd;
	}

	public void setTkofAltncd(String tkofAltncd) {
		this.tkofAltncd = tkofAltncd;
	}

	public String getDriftAltnCd() {
		return driftAltnCd;
	}

	public void setDriftAltnCd(String driftAltnCd) {
		this.driftAltnCd = driftAltnCd;
	}

	public String getTargetFuel() {
		return targetFuel;
	}

	public void setTargetFuel(String targetFuel) {
		this.targetFuel = targetFuel;
	}

	public String getTripFuel() {
		return tripFuel;
	}

	public void setTripFuel(String tripFuel) {
		this.tripFuel = tripFuel;
	}

	public String getDestFuel() {
		return destFuel;
	}

	public void setDestFuel(String destFuel) {
		this.destFuel = destFuel;
	}

	public String getRsvrFuel() {
		return rsvrFuel;
	}

	public void setRsvrFuel(String rsvrFuel) {
		this.rsvrFuel = rsvrFuel;
	}

	public String getAltnFuel() {
		return altnFuel;
	}

	public void setAltnFuel(String altnFuel) {
		this.altnFuel = altnFuel;
	}

	public String getHoldFuel() {
		return holdFuel;
	}

	public void setHoldFuel(String holdFuel) {
		this.holdFuel = holdFuel;
	}

	public String getExtrFuel() {
		return extrFuel;
	}

	public void setExtrFuel(String extrFuel) {
		this.extrFuel = extrFuel;
	}

	public String getTkofFuel() {
		return tkofFuel;
	}

	public void setTkofFuel(String tkofFuel) {
		this.tkofFuel = tkofFuel;
	}

	public String getTaxiOutFuel() {
		return taxiOutFuel;
	}

	public void setTaxiOutFuel(String taxiOutFuel) {
		this.taxiOutFuel = taxiOutFuel;
	}

	public OfpRefileVo getOfpRefileVo() {
		return ofpRefileVo;
	}

	public void setOfpRefileVo(OfpRefileVo ofpRefileVo) {
		this.ofpRefileVo = ofpRefileVo;
	}


	public String getLoadFuel() {
		return loadFuel;
	}

	public void setLoadFuel(String loadFuel) {
		this.loadFuel = loadFuel;
	}

	public String getEtow() {
		return etow;
	}

	public void setEtow(String etow) {
		this.etow = etow;
	}

	public String getMtow() {
		return mtow;
	}

	public void setMtow(String mtow) {
		this.mtow = mtow;
	}

	public String getEldw() {
		return eldw;
	}

	public void setEldw(String eldw) {
		this.eldw = eldw;
	}

	public String getMldw() {
		return mldw;
	}

	public void setMldw(String mldw) {
		this.mldw = mldw;
	}

	public String getEzfw() {
		return ezfw;
	}

	public void setEzfw(String ezfw) {
		this.ezfw = ezfw;
	}

	public String getMzfw() {
		return mzfw;
	}

	public void setMzfw(String mzfw) {
		this.mzfw = mzfw;
	}

	public String getEpld() {
		return epld;
	}

	public void setEpld(String epld) {
		this.epld = epld;
	}

	public String getReqdFuel() {
		return reqdFuel;
	}

	public void setReqdFuel(String reqdFuel) {
		this.reqdFuel = reqdFuel;
	}

	public String getReqdTm() {
		return reqdTm;
	}

	public void setReqdTm(String reqdTm) {
		this.reqdTm = reqdTm;
	}

	public String getCi1() {
		return ci1;
	}

	public void setCi1(String ci1) {
		this.ci1 = ci1;
	}

	public String getCi2() {
		return ci2;
	}

	public void setCi2(String ci2) {
		this.ci2 = ci2;
	}

	public String getMel() {
		return mel;
	}

	public void setMel(String mel) {
		this.mel = mel;
	}

	public String getRouteNr() {
		return routeNr;
	}

	public void setRouteNr(String routeNr) {
		this.routeNr = routeNr;
		this.ofpHeaderVo.setRouteNr(routeNr);
	}

	public String getWxprogTm() {
		return wxprogTm;
	}

	public void setWxprogTm(String wxprogTm) {
		this.wxprogTm = wxprogTm;
	}

	public String getObsDt() {
		return obsDt;
	}

	public void setObsDt(String obsDt) {
		this.obsDt = obsDt;
	}

	public Object getOfpDt() {
		return ofpDt;
	}

	public void setOfpDt(String ofpdt) {
		this.ofpDt = ofpdt;
	}

	public String getRlsText() {
		return rlsText;
	}

	public void setRlsText(String rlsText) {
		this.rlsText = rlsText;
	}

	public String getDispName() {
		return dispName;

	}

	public void setDispName(String dispName) {
		this.dispName = dispName;
		this.ofpHeaderVo.setDispName(dispName);
	}

	public String getDispPhone() {
		return dispPhone;
	}

	public void setDispPhone(String dispPhone) {
		this.dispPhone = dispPhone;
	}

	public String getOperDt() {
		return operDt;
	}

	public void setOperDt(String operDt) {
		this.operDt = operDt;
	}

	public List<OfpWayPointVo> getOfpWayPoints() {
		return ofpWayPoints;
	}

	public void setOfpWayPoints(List<OfpWayPointVo> ofpWayPoints) {
		this.ofpWayPoints = ofpWayPoints;
	}
	public String getSecondLevelEte() {
		return secondLevelEte;
	}

	public void setSecondLevelEte(String secondLevelEte) {
		this.secondLevelEte = secondLevelEte;
	}

	public String getSecondLevelFuel() {
		return secondLevelFuel;
	}

	public void setSecondLevelFuel(String secondLevelFuel) {
		this.secondLevelFuel = secondLevelFuel;
	}

	public String getSecondLevelZfw() {
		return secondLevelZfw;
	}

	public void setSecondLevelZfw(String secondLevelZfw) {
		this.secondLevelZfw = secondLevelZfw;
	}

	public String getSecondLevelDesc() {
		return secondLevelDesc;
	}

	public void setSecondLevelDesc(String secondLevelDesc) {
		this.secondLevelDesc = secondLevelDesc;
	}

	public String getThirdLevelEte() {
		return thirdLevelEte;
	}

	public void setThirdLevelEte(String thirdLevelEte) {
		this.thirdLevelEte = thirdLevelEte;
	}

	public String getThirdLevelFuel() {
		return thirdLevelFuel;
	}

	public void setThirdLevelFuel(String thirdLevelFuel) {
		this.thirdLevelFuel = thirdLevelFuel;
	}

	public String getThirdLevelZfw() {
		return thirdLevelZfw;
	}

	public void setThirdLevelZfw(String thirdLevelZfw) {
		this.thirdLevelZfw = thirdLevelZfw;
	}

	public String getThirdLevelDesc() {
		return thirdLevelDesc;
	}

	public void setThirdLevelDesc(String thirdLevelDesc) {
		this.thirdLevelDesc = thirdLevelDesc;
	}

	public List<OfpFlightLevelVo> getOfpFlightLevel() {

		//System.out.println("测试"+ofpFlightLevel.get(1).getAwy());
		return ofpFlightLevel;
	}

	public void setOfpFlightLevel(List<OfpFlightLevelVo> ofpFlightLevel) {
		this.ofpFlightLevel = ofpFlightLevel;
		//System.out.println("测试"+ofpFlightLevel.get(1).getAwy());
	}

	public List<OfpAltnVo> getOfpAltnVo() {
		return ofpAltnVo;
	}

	public void setOfpAltnVo(List<OfpAltnVo> ofpAltnVo) {
		this.ofpAltnVo = ofpAltnVo;
	}

	public String getSecondLevelCruiseMode() {
		return secondLevelCruiseMode;
	}

	public void setSecondLevelCruiseMode(String secondLevelCruiseMode) {
		this.secondLevelCruiseMode = secondLevelCruiseMode;
	}

	public String getThirdLevelCruiseMode() {
		return thirdLevelCruiseMode;
	}

	public void setThirdLevelCruiseMode(String thirdLevelCruiseMode) {
		this.thirdLevelCruiseMode = thirdLevelCruiseMode;
	}

	//public String getRouteDist() {
	// TODO Auto-generated method stub
	//	return this.routeDist;
	//ofpHeaderVo.setRouteDist(routeDist);
	//return null;
	//}

	public List<OfpFlightLevelVo> getOfpFlightLevelVo() {
		// TODO Auto-generated method stub
		return this.ofpFlightLevel;
	}
}