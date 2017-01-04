package com.csair.soc.fltplan.parser.vo;

import java.io.Serializable;

public class OfpHeaderVo implements Serializable{		
			
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String ofpNr;//飞行计划编号
		private String dispName;//计划制作日期 
		private String dispSeat;//签派席位
		private String dispTime;//计划制作日期 
		private String fltDt;//航班日期 
		private String tailNr;//机尾型号
		private String routeNr;
		private String routeDist;
		private String depCd; // 始发站，四字编码
		private String arvCd; // 到达站，四字�?
		private String depDt;//起飞时间
		private String arvDt;//落地时间
		private String airDistDescription;//	
		private String ete;//预计飞行时间
		private String cruiseFLDescription;//巡航高度描述

		
		public void setOfpNr(String ofpNr) {
			this.ofpNr = ofpNr;
		}


		public String getOfpNr() {
			return ofpNr;
		}

		public String getDispName() {
			return dispName;
		}

		public void setDispName(String dispName) {
			this.dispName = dispName;
		}
		
		public String getDispSeat() {
			return dispSeat;
		}

		public void setDispSeat(String dispSeat) {
			this.dispSeat = dispSeat;
		}
		
		
		public String getDispTime() {
			return dispTime;
		}

		public void setDispTime(String dispTime) {
			this.dispTime = dispTime;
		}
		public String getFltDt() {
			return fltDt;
		}

		public void setFltDt(String fltDt) {
			this.fltDt = fltDt;
		}
		
		public String getTailNr() {
			return tailNr;
		}

		public void setTailNr(String tailNr) {
			this.tailNr = tailNr;
		}
		public String getRouteNr() {
			return routeNr;
		}

		public void setRouteNr(String routeNr) {
			this.routeNr = routeNr;
		}
		public String getRouteDist() {
			return routeDist;
		}

		public void setRouteDist(String routeDist) {
			this.routeDist = routeDist;
		}
		
		public String getDepCd() {
			return depCd;
		}

		public void setDepCd(String depCd) {
			this.depCd = depCd;
		}


		public String getArvCd() {
			return arvCd;
		}

		public void setArvCd(String arvCd) {
			this.arvCd = arvCd;
		}

		public String getDepDt() {
			return depDt;
		}

		public void setDepDt(String depDt) {
			this.depDt = depDt;
		}

		public String getArvDt() {
			return arvDt;
		}

		public void setArvDt(String arvDt) {
			this.arvDt = arvDt;
		}
		public String getAirDistDescription() {
			return airDistDescription;
		}

		public void setAirDistDescription(String airDistDescription) {
			this.airDistDescription = airDistDescription;
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
		}
		//---------------------------
}