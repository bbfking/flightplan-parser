package com.csair.soc.fltplan.parser.service;

import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;

public class RefileParser {
	public static String msgContent;
	public static FpVo fpVo;

	public void refileInfoImpl() {

		try{

			FpVo secondFpVo=new FpVo();
			HeaderParser.HeaderInfoImpl(secondFpVo);
			//飞行计划编号
			//fltPlanheaderImpl.fltNrImpl();
			fpVo.getOfpRefileVo().setRefileAlnCd(secondFpVo.getAlnCd());
			fpVo.getOfpRefileVo().setRefileFltNr(secondFpVo.getFltNr());
			fpVo.getOfpRefileVo().setRefileFltSuffix(secondFpVo.getFltSuffix());
			fpVo.getOfpRefileVo().setOfpNr(secondFpVo.getOfpNr());	

			//签派员
			//fltPlanheaderImpl.DispImpl();

			//flt时间
			//fltPlanheaderImpl.fltDtImpl();
			fpVo.getOfpRefileVo().setRefileFltDt(secondFpVo.getFltDt());

			//机尾号 机型
			//fltPlanheaderImpl.tailNrImpl();
			fpVo.getOfpRefileVo().setRefileTailNr(secondFpVo.getTailNr());
			fpVo.getOfpRefileVo().setRefileEqpCd(secondFpVo.getEqpCd());
			fpVo.getOfpRefileVo().setRefileCruiseMode(secondFpVo.getCruiseMode());

			//航线和航程
			//fltPlanheaderImpl.routeAndDistImpl();
			//logger.info("RefilerouteNr: " + RefilerouteNr +" RefileroutDist: " +RefileroutDist+"\n");
			fpVo.getOfpRefileVo().setRefileRouteNr(secondFpVo.getRouteNr());
			fpVo.getOfpRefileVo().setRefileRouteDis(secondFpVo.getRouteDist());

			//始发站抵达站 备降站场代码
			//fltPlanheaderImpl.codeOfDepAvrAltn();
			fpVo.getOfpRefileVo().setRefileDepCd(secondFpVo.getDepCd());
			fpVo.getOfpRefileVo().setRefileDepDt(secondFpVo.getDepDt());
			fpVo.getOfpRefileVo().setRefileArvCd(secondFpVo.getArvCd());
			fpVo.getOfpRefileVo().setRefileArvDt(secondFpVo.getArvDt());
			fpVo.getOfpRefileVo().setRefileAltncd(secondFpVo.getAltncd());

			// 航路描述
			//fltPlanheaderImpl.AirDistDiscription();
			fpVo.getOfpRefileVo().setRefileAirDistDescription(secondFpVo.getAirDistDescription());

			//预计飞行时间和巡航高度层描述
			//fltPlanheaderImpl.cruiseFLDescripImpl();
			fpVo.getOfpRefileVo().setRefileEte(secondFpVo.getEte());
			fpVo.getOfpRefileVo().setRefileFl(secondFpVo.getCruiseFLDescription());


			// 起始点和目的地  这个解析式过程是狗欠妥？？？？没有二次飞行的报文
			String startAndDestRegex="REFILE\\s*FLT\\d+ORG\\*(\\w+)\\s*/\\s*DEST\\s*(\\w+)";
			if (RegExpTool.isMatched(startAndDestRegex, msgContent)) {
				String routeAndDistRegex="ROUTE\\s+(\\w*)\\s+(\\d+)NM";
				String refileStart = RegExpTool.find(routeAndDistRegex, msgContent, 1);
				String refileDest = RegExpTool.find(routeAndDistRegex, msgContent, 2);
				//logger.info("refileStart: " + refileStart +" refileDest: " +refileDest+"\n");
				fpVo.getOfpRefileVo().setRefileStart(refileStart);
				fpVo.getOfpRefileVo().setRefileDest(refileDest);
			}

			//getFlightLevel(, fpVo.getOfpNr(), "2");
			//高空风信息集
			FlightLevelParser getFlightLevelInfo=new FlightLevelParser(fpVo,"2");
			getFlightLevelInfo.flightLevelInfoImpl();

			//getWaypointSummary(msgContent, fpVo.getOfpNr(), "2");


		} catch (Exception e) {
			//logger.info("getRelife 异常..." + e.getMessage());
		}


	}
	public static void refileInfoImpl(FpVo newFpVo){
		fpVo=newFpVo;
		msgContent=fpVo.getOfpText();
		msgContent=msgContent.substring(msgContent.indexOf("REFILE FLIGHT PLAN"));
		RefileParser refileInfo=new RefileParser();
		refileInfo.refileInfoImpl();
		

	}


}
