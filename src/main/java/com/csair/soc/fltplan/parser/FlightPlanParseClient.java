package com.csair.soc.fltplan.parser;


import com.csair.soc.fltplan.parser.service.*;
import com.csair.soc.fltplan.parser.util.JacksonUtil;
import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *  飞行计划报文解析类
 * @author 
 *
 */
public class FlightPlanParseClient {


	private static Logger logger = LogManager.getLogger(FlightPlanParseClient.class);

	public static FpVo flightPlanParse(String msgContent){

		FpVo fpVo=new FpVo();
		fpVo.setOfpText(msgContent);

		flightPlanParse(fpVo);

		logger.info(fpVo.getOfpNr()+"        THIS IS END");  
		return fpVo;
	}


	//解析报文
	private static void flightPlanParse(FpVo fpVo){
		String msgContent=fpVo.getOfpText();
		//报文时间
		FltDtParser getOfpDt=new FltDtParser(fpVo);
		getOfpDt.ofpDtImpl();
		logger.info("报文发送时间       ofpDt: " +fpVo.getOfpDt()+"\n"); //新增加
		/*
		 * 公共部分:飞行计划头(序列号，签派员，机尾号机型，航线和航程，始发站抵达站备降站，航路描述，飞行时间和巡航高度层描述),备降场,高度层,高空风
		 * 解析飞行计划报头 
		 */
		//解析报头信息	
		HeaderParser.HeaderInfoImpl(fpVo);
		logger.info("--------------------------解析报头信息--------------------------- \nHeader"+
				JacksonUtil.toString(fpVo.getOfpHeaderVo()+"\n"));

		//解析备降场信息集	
		AltnInfoParser getAltnInfo=new AltnInfoParser(fpVo);
		getAltnInfo.altnInfoImpl();
		logger.info("---------------------------解析备降场信息------------------------\nAltn "+
				JacksonUtil.toString(fpVo.getOfpAltnVo())+"\n");

		//解析高度层信息集
		FlightLevelParser geFlightLevelInfo=new FlightLevelParser(fpVo,"1");
		geFlightLevelInfo.flightLevelInfoImpl();	    
		logger.info("-------------------------解析高度层信息集-------------------------\nFlightLevel"+
				JacksonUtil.toString(fpVo.getOfpFlightLevelVo())+"\n");

		//解析高空风信息集
		System.out.println(" ");
		UpperWindParser getUpperWindInfo=new UpperWindParser(fpVo);
		getUpperWindInfo.upperWindInfoImpl();
		logger.info("-------------------------解析高空风层信息集------------------------\nUpperWind"+
				JacksonUtil.toString(fpVo.getOfpUpperWindVo())+"\n");

		//解析一次放行航路点
		WayPointParser getWayPointInfo=new WayPointParser( fpVo,"1");
		getWayPointInfo.wayPointInfoImpl();
		logger.info("-------------------------一次放行航路点----------------------------\nWayPoints "+
				JacksonUtil.toString(fpVo.getOfpWayPoints()).toString()+"\n");

		//解析杂项
		logger.info("-------------------------解析杂项----------------------------- ");
		getTheRest(msgContent, fpVo);

		//判断是否含有二次放行，如果含有的话则。。		
		if(msgContent.indexOf("REFILE FLIGHT PLAN")!=-1){
			logger.info("-------------------------解析二次放行信息-----------------------------\n ");
			getTheRestAndRefile(msgContent,fpVo);
			RefileParser.refileInfoImpl(fpVo);
		}

		//如果有延程运行信息的话则解析ETP
		if(msgContent.indexOf("ETP")!=-1){	
			logger.info("-------------------------解析ETOPS信息-----------------------------\n ");
			EtopsParser getEtopsInfo=new EtopsParser(fpVo);
			getEtopsInfo.ofpEtopsImpl();
		}


		//测试语句	
		//logger.info(JSONObject.fromObject(fpVo).toString());


	}

	//杂项
	private static void getTheRest(String msg,FpVo fpVo){
		try {
			//含有二次放行和不含有二次放行的公共部分
			publicRestPart(msg,fpVo);

			//目的地着陆油量
			String targetFuelRegex = "TARGET ARRIVAL FUEL\\s*(\\d+)KGS";
			if(RegExpTool.isMatched(targetFuelRegex,msg)) {
				String targetFuel = RegExpTool.find(targetFuelRegex, msg, 1);
				logger.info("targetFuel:" + targetFuel);
				//System.out.println("targetFuel:" + targetFuel);
				fpVo.setTargetFuel(targetFuel);
			}
			//航路耗油
			String tripFuelRegex = "TRIP\\s*[A-Z]+\\s*(\\d+\\s*\\d+)";
			if(RegExpTool.isMatched(tripFuelRegex,msg)) {
				String tripFuel = RegExpTool.find(tripFuelRegex, msg, 1);
				logger.info("tripFuel:" + tripFuel);
				//System.out.println("tripFuel:" + tripFuel);
				fpVo.setTripFuel(tripFuel);
			}
			//到目的地机场所需油量和时间
			String destFuelRegex = "DEST\\s*[A-Z]*\\s(\\d+\\s*\\d+)\\s*";
			if(RegExpTool.isMatched(destFuelRegex,msg)) {
				String destFuel = RegExpTool.find(destFuelRegex, msg, 1);
				logger.info("destFuel: " + destFuel);
				//System.out.println("destFuel: " + destFuel);
				fpVo.setDestFuel(destFuel);
				//一次放行备份油量和时间			
				String rsvrFuelRegex ="RSVR\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*";
				if(RegExpTool.isMatched(rsvrFuelRegex,msg)) {
					String rsvrFuel= RegExpTool.find(rsvrFuelRegex, msg, 1);
					logger.info("rsvrFuel: " + rsvrFuel );
					//System.out.println("rsvrFuel: " + rsvrFuel);
					fpVo.setRsvrFuel(rsvrFuel);
				}
				//备降油量和时间
				String altnFuelRegex = "ALTN\\s*[A-Z]*\\s*(\\d+\\s*\\d+)\\s*";
				if(RegExpTool.isMatched(altnFuelRegex,msg)) {
					String altnFuel = RegExpTool.find(altnFuelRegex, msg, 1);
					logger.info("altnFuel: "+altnFuel);
					//System.out.println("altnFuel: "+altnFuel);
					fpVo.setAltnFuel(altnFuel);
				}
				//等待油量和时间
				String holdFuelRegex = "HOLD\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*";
				if(RegExpTool.isMatched(holdFuelRegex,msg)) {
					String holdFuel = RegExpTool.find(holdFuelRegex, msg, 1);
					logger.info("holdFuel:"+holdFuel);
					//System.out.println("holdFuel:"+holdFuel);
					fpVo.setHoldFuel(holdFuel);
				}
				//REQD FUEL
				String reqdFuelRegex = "REQD\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*";
				if(RegExpTool.isMatched(holdFuelRegex,msg)) {
					String reqdFuel = RegExpTool.find(reqdFuelRegex, msg, 1);
					logger.info("holdFuel:"+reqdFuel);
					//System.out.println("holdFuel:"+reqdFuel);
					fpVo.setHoldFuel(reqdFuel);
				}
				//额外油量和时间
				String extrFuelRegex = "EXTR\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*";
				if(RegExpTool.isMatched(extrFuelRegex,msg)) {
					String extrFuel = RegExpTool.find(extrFuelRegex, msg, 1);
					logger.info("extrFuel: " + extrFuel );
					//System.out.println("extrFuel: " + extrFuel);
					fpVo.setExtrFuel(extrFuel);
				}
				//起飞油量和时间
				String tkofFuelRegex = "TKOF\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*";
				if(RegExpTool.isMatched(tkofFuelRegex,msg)) {
					String tkofFuel = RegExpTool.find(tkofFuelRegex, msg, 1);
					logger.info("tkofFuel: " + tkofFuel );
					//System.out.println("tkofFuel: " + tkofFuel);
					fpVo.setTkofFuel(tkofFuel);
				}
			}
		}
		catch (Exception e) {
			logger.info("getTheRest 异常..." + e.getMessage());
		}

	}

	//公共部分
	private static void publicRestPart(String msg,FpVo fpVo){
		try {
			if(msg.indexOf("TOGW   BURN LGW   DESFL  FOD   TIME   COMP AVTAS/GS  AIRMILES/GND")!=-1){
				String togwAndSome=msg.substring(msg.indexOf("TOGW   BURN LGW   DESFL  FOD   TIME   COMP AVTAS/GS  AIRMILES/GND"));
				String togwRegex="(\\d+\\.\\d+)\\s*(\\d+\\.\\d+)\\s*(\\d+\\.\\d+)\\s*(\\d+\\.\\d+)\\s*(\\d+\\.\\d+)\\s*(\\d+)\\s*(\\w+)\\s*(\\d+)/(\\d+)\\s*(\\d+)/(\\d+)NM";
				if(RegExpTool.isMatched(togwRegex, togwAndSome)){
					String togw=RegExpTool.find(togwRegex, togwAndSome,1);
					String burn=RegExpTool.find(togwRegex, togwAndSome,2);
					String lgw=RegExpTool.find(togwRegex, togwAndSome,3);
					String descfl=RegExpTool.find(togwRegex, togwAndSome,4);
					String fod=RegExpTool.find(togwRegex, togwAndSome,5);
					String time=RegExpTool.find(togwRegex, togwAndSome,6);
					String comp=RegExpTool.find(togwRegex, togwAndSome,7);
					String avtas=RegExpTool.find(togwRegex, togwAndSome,8);
					String gs=RegExpTool.find(togwRegex, togwAndSome,9);
					String airmiles=RegExpTool.find(togwRegex, togwAndSome,10);
					String gnd=RegExpTool.find(togwRegex, togwAndSome,11);

					fpVo.setTogw(togw);
					fpVo.setBurn(burn);
					fpVo.setLgw(lgw);
					fpVo.setDescFl(descfl);
					fpVo.setFod(fod);
					fpVo.setTime(time);
					fpVo.setComp(comp);
					fpVo.setAvtas(avtas);
					fpVo.setGs(gs);
					fpVo.setAirmiles(airmiles);
					fpVo.setGnd(gnd);

					logger.info("togw:"+togw+" burn:"+burn+" lgw:"+lgw+" descfl:"+descfl+" fod:"+fod+
							" time:"+time+" comp:"+comp+" avtas:"+avtas+" gs:"+gs+" airmiles:"+airmiles+" gnd:"+gnd);

				}
			}
			//滑出油量
			String taxiOutFuelRegex = "TAXI\\s*OUTF\\s*(\\d+)*";
			if(RegExpTool.isMatched(taxiOutFuelRegex,msg)) {
				String taxiOutFuel = RegExpTool.find(taxiOutFuelRegex, msg, 1);
				logger.info("taxiOutFuel: " + taxiOutFuel);
				//System.out.println("taxiOutFuel: " + taxiOutFuel);
				fpVo.setTaxiOutFuel(taxiOutFuel);
			}
			//总加油量 和时间
			String loadFuelRegex = "LOAD\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*";
			if(RegExpTool.isMatched(loadFuelRegex,msg)) {
				String loadFuel = RegExpTool.find(loadFuelRegex, msg, 1);
				logger.info("loadFuel: " + loadFuel);
				//System.out.println("loadFuel: " + loadFuel);
				fpVo.setLoadFuel(loadFuel);
			}
			//重量1
			String weight1Regex = "ETOW\\s*(\\d+)\\s*ELDW\\s*(\\d+)\\s*EZFW\\s*(\\d+)\\s*EPLD\\s*(\\d+)";
			if(RegExpTool.isMatched(weight1Regex,msg)) {
				String etow = RegExpTool.find(weight1Regex, msg, 1);
				String eldw = RegExpTool.find(weight1Regex, msg, 2);
				String ezfw = RegExpTool.find(weight1Regex, msg, 3);
				String epld = RegExpTool.find(weight1Regex, msg, 4);
				logger.info("etow: " + etow+" eldw: " + eldw+" ezfw: " + ezfw+" epld: " + epld);
				fpVo.setEtow(etow);fpVo.setEldw(eldw);fpVo.setEzfw(ezfw);fpVo.setEpld(epld);
			}
			//重量2
			String weight2Regex = "MTOW\\s*(\\d+)\\s*MLDW\\s*(\\d+)\\s*MZFW\\s*(\\d+)\\s*APLD";
			if(RegExpTool.isMatched(weight2Regex,msg)) {
				String mtow = RegExpTool.find(weight2Regex, msg, 1);
				String mldw = RegExpTool.find(weight2Regex, msg, 2);
				String mzfw = RegExpTool.find(weight2Regex, msg, 3);
				logger.info("mtow: " + mtow+" mldw: " + mldw+" mzfw: " + mzfw);
				fpVo.setMtow(mtow);fpVo.setMldw(mldw);fpVo.setMzfw(mzfw);
			}

			if(msg.indexOf("2ND LEVEL")!=-1){
				StringBuffer sb=new StringBuffer(msg.substring(msg.indexOf("2ND LEVEL"), msg.indexOf("PRIMARY ALTERNATES")));
				String[] str=sb.toString().split("\n");
				//第二高度层
				String secondInfoRegex="2ND LEVEL\\s*(\\w+)\\s*ETE\\s*(\\d+)\\s*FUEL\\s*(\\d+)\\s*ZFW\\s*(\\d+)";
				if(RegExpTool.isMatched(secondInfoRegex,msg)) {
					String secondLevelCruiseMode=RegExpTool.find(secondInfoRegex, msg, 1);
					String secondLevelEte = RegExpTool.find(secondInfoRegex, msg, 2);
					String secondLevelFuel = RegExpTool.find(secondInfoRegex, msg, 3);
					String secondLevelZfw = RegExpTool.find(secondInfoRegex, msg, 4);
					logger.info("secondLevelCruiseMode:"+secondLevelCruiseMode+" secondLevelEte: " + secondLevelEte+" secondLevelFuel: "+secondLevelFuel+" secondLevelZfw: "+secondLevelZfw);
					logger.info("secondLevelDesc:"+str[1]);
					fpVo.setSecondLevelCruiseMode(secondLevelCruiseMode);
					fpVo.setSecondLevelEte(secondLevelEte);
					fpVo.setSecondLevelFuel(secondLevelFuel);
					fpVo.setSecondLevelZfw(secondLevelZfw);
					fpVo.setSecondLevelDesc(str[1]);
				}
				//第三高度层
				String thirdInfoRegex="3RD LEVEL\\s*(\\w+)\\s*ETE\\s*(\\d+)\\s*FUEL\\s*(\\d+)\\s*ZFW\\s*(\\d+)";
				if(RegExpTool.isMatched(thirdInfoRegex,msg)) {
					String thirdLevelCruiseMode=RegExpTool.find(thirdInfoRegex, msg, 1);
					String thirdLevelEte = RegExpTool.find(thirdInfoRegex, msg, 2);
					String thirdLevelFuel = RegExpTool.find(thirdInfoRegex, msg, 3);
					String thirdLevelZfw = RegExpTool.find(thirdInfoRegex, msg, 4);
					logger.info("thirdLevelEte: " + thirdLevelEte+"thirdLevelFuel: "+thirdLevelFuel+"thirdLevelZfw: "+thirdLevelZfw);
					logger.info("thirdLevelDesc: "+str[4]);
					//System.out.println("thirdLevelEte: " + thirdLevelEte+"thirdLevelFuel: "+thirdLevelFuel+"thirdLevelZfw: "+thirdLevelZfw);
					//System.out.println("thirdLevelDesc: "+str[4]);
					fpVo.setThirdLevelCruiseMode(thirdLevelCruiseMode);
					fpVo.setThirdLevelEte(thirdLevelEte);
					fpVo.setThirdLevelFuel(thirdLevelFuel);
					fpVo.setThirdLevelZfw(thirdLevelZfw);
					fpVo.setThirdLevelDesc(str[4]);
				}
			}
			//下降层
			String descFlRegex="DESC\\s*FL\\s*(\\d+\\s*[\\d+\\s*]*)";
			String descFlTemperRegex="WIND\\s*(\\d+\\s*[\\d+\\s*]*)";
			if(RegExpTool.isMatched(descFlRegex,msg)) {
				String descFl = RegExpTool.find(descFlRegex, msg, 1);
				String descFlTemper=RegExpTool.find(descFlTemperRegex, msg, 1);
				logger.info("descFl: " + descFl+"descFlTemper: "+descFlTemper);
				//System.out.println("descFl: " + descFl+"descFlTemper: "+descFlTemper);
				fpVo.setDescFl(descFl);
				fpVo.setDescFlTemper(descFlTemper);
			}
		}
		catch (Exception e) {
			logger.info("publicRestPart 异常..." + e.getMessage());
			//System.out.println("publicRestPart 异常..." + e.getMessage());
		}
	}
	//带二次放行的其他部分
	private static void getTheRestAndRefile(String msg,FpVo fpVo){
		//含有二次放行和不含有二次放行的公共部分
		publicRestPart(msg,fpVo);

		try{
			logger.info("-------------------------这里是getTheRestAndRefile()方法----------------------------\n ");
			//到目的地机场所需油量和时间    起飞至二放点所需油量和时间
			String destFuelRegex = "DEST\\s*[A-Z]*\\s*(\\d+\\s*\\d+)\\s*\\w+\\-\\s*\\w+\\s*(\\d+\\s*\\d+)";
			if(RegExpTool.isMatched(destFuelRegex,msg)) {
				String destFuel = RegExpTool.find(destFuelRegex, msg, 1);
				String destRclFuel = RegExpTool.find(destFuelRegex, msg, 2);
				logger.info("到目的地机场所需油量和时间: " + destFuel+" 起飞至二放点所需油量和时间: "+destRclFuel);
				//System.out.println("到目的地机场所需油量和时间: " + destFuel+" 起飞至二放点所需油量和时间: "+destRclFuel);
				fpVo.setDestFuel(destFuel);
				fpVo.getOfpRefileVo().setDestRclFuel(destRclFuel);
			}
			//二放点至初始放行机场所需油量和时间
			String rclDestFuelRegex = "\\s{20,}\\w+\\s*\\w+\\s*(\\d+\\s*\\d+)\\W";
			if(RegExpTool.isMatched(rclDestFuelRegex,msg)) {
				String rclDestFuel = RegExpTool.find(rclDestFuelRegex, msg, 1);
				logger.info("二放点至初始放行机场所需油量和时间: " + rclDestFuel);
				//System.out.println("二放点至初始放行机场所需油量和时间: " + rclDestFuel);
				fpVo.getOfpRefileVo().setRclDestFuel(rclDestFuel);
			}
			//二次放行航路备份油和时间 一次放行备份油量和时间
			String rsvrFuelRegex = "RSVR\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*RSVR\\s*FUEL\\s*(\\d+\\s*\\d+)";
			if(RegExpTool.isMatched(rsvrFuelRegex,msg)) {
				String rclRsvrFuel = RegExpTool.find(rsvrFuelRegex, msg, 1);
				String rsvrFuel= RegExpTool.find(rsvrFuelRegex, msg, 2);
				logger.info("rclRsvrFuel: " + rsvrFuel +"rsvrFuel: "+rclRsvrFuel);
				//System.out.println("rclRsvrFuel: " + rsvrFuel +"rsvrFuel: "+rclRsvrFuel);
				fpVo.setRsvrFuel(rsvrFuel);
				fpVo.getOfpRefileVo().setRclRsvrFuel(rclRsvrFuel);
			}
			//目的地机场至主备降的油量和时间  初始放行场至其备降场的油量和时间
			String altnFuelRegex = "ALTN\\s*[A-Z]*\\s*(\\d+\\s*\\d+)\\s*ALTN\\s*[A-Z]*\\s*(\\d+\\s*\\d+)";
			if(RegExpTool.isMatched(altnFuelRegex,msg)) {
				String altnFuel = RegExpTool.find(altnFuelRegex, msg, 1);
				String rclAltnFuel= RegExpTool.find(altnFuelRegex, msg, 2);
				logger.info("altnFuel: "+altnFuel+"rclAltnFuel: " + rclAltnFuel );
				fpVo.setAltnFuel(altnFuel);
				fpVo.getOfpRefileVo().setRclAltnFuel(rclAltnFuel);
			}

			// 在目的地机场备降场的等待油量和时间  初始放行场备降的等待油量和时间
			String holdFuelRegex = "HOLD\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*HOLD\\s*FUEL\\s*(\\d+\\s*\\d+)";
			if(RegExpTool.isMatched(holdFuelRegex,msg)) {
				String holdFuel = RegExpTool.find(holdFuelRegex, msg, 1);
				String rclHoldFuel= RegExpTool.find(holdFuelRegex, msg, 2);
				/*
				 * 输出目的机场等待需要油量，初次放行备降所需等待油量
				 */
				logger.info("holdFuel:"+holdFuel+"rclHoldFuel: " + rclHoldFuel);
				fpVo.setHoldFuel(holdFuel);
				fpVo.getOfpRefileVo().setRclHoldFuel(rclHoldFuel);
			}

			//额外油量和时间  以及二放点
			String extrFuelRegex = "EXTR\\s*FUEL\\s*(\\d+\\s*\\d+)\\s*EXTR\\s*FUEL\\s*(\\d+\\s*\\d+)";
			if(RegExpTool.isMatched(extrFuelRegex,msg)) {
				String rclExtrFuel = RegExpTool.find(extrFuelRegex, msg, 1);
				String extrFuel= RegExpTool.find(extrFuelRegex, msg, 2);
				/*
				 * 输出额外油量以以及二放点？？？
				 */
				logger.info("rclExtrFuel: "+rclExtrFuel+"extrFuel: " + extrFuel);
				//System.out.println("rclExtrFuel: "+rclExtrFuel+"extrFuel: " + extrFuel);
				fpVo.setExtrFuel(extrFuel);
				fpVo.getOfpRefileVo().setRclExtrFuel(rclExtrFuel);
			}

			//以下是用来处理？？？？？？
			if(msg.indexOf("REFILE INFORMATION")!=-1 && msg.indexOf("2ND LEVEL")!=-1){
				String moreRcl=msg.substring(msg.indexOf("REFILE INFORMATION"),msg.indexOf("2ND LEVEL"));
				/**
				 * 二次放行机场至目的地机场所需油量和时间
				 */
				String destRegex = "DEST\\s*[A-Z]{4}\\s*(\\d+\\s+\\d+)";
				if(RegExpTool.isMatched(destRegex,moreRcl)) {
					String refileDestFuel = RegExpTool.find(destRegex, moreRcl, 1);
					/*
					 * 输出二房所需油量和时间
					 */
					logger.info(""+"refileDestFuel: " + refileDestFuel+"\n");
					//System.out.println("refileDestFuel: " + refileDestFuel);
					fpVo.getOfpRefileVo().setRefileDestFuel(refileDestFuel);
				}
				/**
				 * 二放计划用油
				 */
				String rclPlanFuelRegex = "PLAN\\s*FUEL\\s*FOR\\s*RCL\\s*(\\d+)\\s*";
				if(RegExpTool.isMatched(rclPlanFuelRegex,moreRcl)) {
					String rclPlanFuel = RegExpTool.find(rclPlanFuelRegex, moreRcl, 1);
					/*
					 * 输出二次放行计划用油
					 */
					logger.info("二次放行计划用油"+"rclPlanFuel: " + rclPlanFuel+"\n");
					//System.out.println("rclPlanFuel: " + rclPlanFuel);
					fpVo.getOfpRefileVo().setRclPlanFuel(rclPlanFuel);
				}
				/**
				 * 二放必须用油
				 */
				String rclReqdFuelRegex = "REQD\\s*FUEL\\s*FOR\\s*RCL\\s*(\\d+)\\s*";
				if(RegExpTool.isMatched(rclReqdFuelRegex,moreRcl)) {
					String rclReqdFuel = RegExpTool.find(rclReqdFuelRegex, moreRcl, 1);
					/*
					 * 输出
					 */
					logger.info("二次放行必须油量"+"rclReqdFuel: " + rclReqdFuel+"\n");
					//System.out.println("rclReqdFuel: " + rclReqdFuel);
					fpVo.getOfpRefileVo().setRclReqdFuel(rclReqdFuel);
				}

			}

		}catch (Exception e) {
			logger.info("getTheRestAndRefile 异常..." + e.getMessage());
			//System.out.println("getTheRestAndRefile 异常..." + e.getMessage());
		}



	}
}
