package com.csair.soc.fltplan.parser.service;

import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;

import java.util.Calendar;

public class HeaderParser {
    public static String msgContent;
    public static FpVo fpVo;
    /*规定key值
	 * 1.
	 * 2.
	 * 3.
	 * 4.
	 */
    //public Map<String,String> regexs;

    public static void HeaderInfoImpl(FpVo newFpVo) {

        fpVo = newFpVo;
        msgContent = fpVo.getOfpText();
        msgContent = msgContent.substring(msgContent.indexOf("START OF FLIGHT PLAN"),
                msgContent.indexOf("ALL WEIGHTS IN KILOS"));
        //飞行计划编号
        fltNrImpl();
        //签派员
        DispImpl();
        //flt时间
        fltDtImpl();
        //机尾号 机型
        tailNrImpl();
        //航线和航程
        routeAndDistImpl();
        //始发站抵达站 备降站场代码
        codeOfDepAvrAltn();
        // 航路描述
        AirDistDiscription();
        //预计飞行时间和巡航高度层描述
        cruiseFLDescripImpl();

    }

    //飞行计划编号
    public static void fltNrImpl() {
        //String fltNrRegex=regexs.get("fltNrRegex");
        String fltNrRegex = "([A-Z]{3})\\s*(\\d{3,4})\\s*([A-Z]{0,1})\\s*[A-Z]{4}-[A-Z]{4}\\s*(\\w*)\\s*";
        if (RegExpTool.isMatched(fltNrRegex, msgContent)) {
            String alnCd = RegExpTool.find(fltNrRegex, msgContent, 1);
            String fltNr = RegExpTool.find(fltNrRegex, msgContent, 2);
            String fltSuffix = RegExpTool.find(fltNrRegex, msgContent, 3);
            String ofpNr = RegExpTool.find(fltNrRegex, msgContent, 4);
            Calendar cal = Calendar.getInstance();

            if (fltSuffix == "") {
                fltSuffix = "";
            }
            if (fltNr.length() < 4) {
                //fltNr = publicMethod.addZero(fltNr);
                fltNr = fltNr + "0";
            }
            if (alnCd.equalsIgnoreCase("CSN")) {
                alnCd = "CZ";
            } else if (alnCd.equalsIgnoreCase("CQN")) {
                alnCd = "OQ";
            }
            fpVo.setAlnCd(alnCd);
            fpVo.setFltNr(fltNr);
            fpVo.setFltSuffix(fltSuffix);
            int temp = cal.get(Calendar.YEAR);
            fpVo.setOfpNr(temp + ofpNr);

            //System.out.println("fltNr:" + alnCd + fltNr+fltSuffix+" ofpNr:"+fpVo.getOfpNr()+"\n");

        }
    }

    //flt时间
    public static void fltDtImpl() {
        String fltDtRegex = "/(\\d{2}\\w{3}\\d{2})Z";
        if (RegExpTool.isMatched(fltDtRegex, msgContent)) {
            String fltDt = RegExpTool.find(fltDtRegex, msgContent, 1);
            fpVo.setFltDt(fltDt);
            //fpVo.setFltDt(publicMethod.getDateInfo(fltDt));
            //logger.info("fltDt: " + fpVo.getFltDt()+"\n");
        }
    }

    //机尾型号信号
    public static void tailNrImpl() {
        String tailNrRegex = "ACFT\\s*(B\\d{4})\\s*[A-Z]/(\\w*)/\\w*\\s*/\\w*\\s*(\\w*)\\s*";
        if (RegExpTool.isMatched(tailNrRegex, msgContent)) {
            String tailNr = RegExpTool.find(tailNrRegex, msgContent, 1);
            String eqpCd = RegExpTool.find(tailNrRegex, msgContent, 2);
            String cruiseMode = RegExpTool.find(tailNrRegex, msgContent, 3);
            fpVo.setTailNr(tailNr);
            fpVo.setEqpCd(eqpCd);
            fpVo.setCruiseMode(cruiseMode);
            //logger.info("tailNr: " + tailNr+" eqpCd: "+eqpCd+" cruiseMode:"+cruiseMode+"\n");
        }
    }

    //航线和航程
	/*
	 * 更改了正则表达式
	 */
    public static void routeAndDistImpl() {
        String routeAndDistRegex = "ROUTE[A-Z]{0,2}\\s+(\\w*)\\s+(\\d+)NM";
        if (RegExpTool.isMatched(routeAndDistRegex, msgContent)) {
            String routeNr = RegExpTool.find(routeAndDistRegex, msgContent, 1);
            String routDist = RegExpTool.find(routeAndDistRegex, msgContent, 2);
            //logger.info("routeNr: " + routeNr +" routDist: " +routDist+"\n");
            fpVo.setRouteNr(routeNr);
            fpVo.setRouteDist(routDist);
        }
    }

    //始发站场和抵达站场备降站场代码
    public static void codeOfDepAvrAltn() {
        String depArvCdAndTimeRegex = "([A-Z]{4})\\s+(\\d{4})Z\\s+\\-\\s+([A-Z]{4})\\s+(\\d{4})Z\\s*ALTN\\s*([A-Z]{4})";

        //  	String depArvCdAndTimeRegex = "([A-Z]{4})\\s+(\\d{4})Z\\s+-\\s+([A-Z]{4})\\s+(\\d{4})Z\\s*ALTN\\s*([A-Z]{4}\\s*/\\s*[A-Z]{3})";
        if (RegExpTool.isMatched(depArvCdAndTimeRegex, msgContent)) {
            String depArpCdStr = RegExpTool.find(depArvCdAndTimeRegex, msgContent, 1);
            String depDt = RegExpTool.find(depArvCdAndTimeRegex, msgContent, 2);
            String ArvCrpCdStr = RegExpTool.find(depArvCdAndTimeRegex, msgContent, 3);
            String arvDt = RegExpTool.find(depArvCdAndTimeRegex, msgContent, 4);
            String altncd = RegExpTool.find(depArvCdAndTimeRegex, msgContent, 5);
            fpVo.setDepCd(depArpCdStr);
            fpVo.setDepDt(fpVo.getFltDt() + " " + depDt.substring(0, 2) + ":" + depDt.substring(2));
            fpVo.setArvCd(ArvCrpCdStr);
            fpVo.setArvDt(fpVo.getFltDt() + " " + arvDt.substring(0, 2) + ":" + arvDt.substring(2));
            fpVo.setAltncd(altncd);
            //logger.info("dep: " + depArpCdStr  +" time:"+fpVo.getDepDt()+ ", arv:"
            //		+ ArvCrpCdStr +" time: "+fpVo.getArvDt()+"\n");
        }
    }

    //航路描述
    public static void AirDistDiscription() {
        String airDist = fpVo.getRouteDist() + "NM";
        if (msgContent.indexOf(airDist) != -1) {
            String airDistDescription = msgContent.substring(msgContent.indexOf(airDist) + airDist.length(), msgContent.indexOf("ETE"));
            fpVo.setAirDistDescription(airDistDescription.trim());
            //logger.info("airDistDescription: "+airDistDescription+"\n");
        }
    }

    //预计飞行时间和巡航高度层描述
    public static void cruiseFLDescripImpl() {
        if (msgContent.indexOf("ETE") != -1 && msgContent.indexOf("FL") != -1) {
            String temp = msgContent.substring(msgContent.indexOf("ETE"));
            String ete = temp.substring(temp.indexOf("ETE") + 3, temp.indexOf("FL")).trim();
            String cruiseFLDescription = temp.substring(temp.indexOf("FL") + 2);
            fpVo.setEte(ete);
            fpVo.setCruiseFLDescription(cruiseFLDescription.trim());
            //logger.info("ete: "+ete+" cruiseFlDescription:"+cruiseFlDescription);
        }
    }

    //飞行计划时间时间
    public static void ofpDtImpl() {
        String OfpDRegex = "\\.\\w{7}\\s+(\\d{6})";
        if (RegExpTool.isMatched(OfpDRegex, msgContent)) {
            String ofpDt = RegExpTool.find(OfpDRegex, msgContent, 1);
            //fpVo.setOfpDt(publicMethod.getDayInfo(ofpDt));
            //logger.info("ofpDt: " +fpVo.getOfpDt());
            fpVo.setOfpDt(ofpDt);
            //System.out.println("ofpDt: " +ofpDt); //新增加
        }
    }

    //签派信息
    public static void DispImpl() {
        String dispRegex = "DISP\\s*(\\w*\\s*\\w*\\s*\\w*)\\s*RUN\\s*AT\\s*(\\d*)Z\\s*(\\w*)";
        if (RegExpTool.isMatched(dispRegex, msgContent)) {
            String dispName = RegExpTool.find(dispRegex, msgContent, 1).trim();
            String dispTime = RegExpTool.find(dispRegex, msgContent, 2);
            String dispSeat = RegExpTool.find(dispRegex, msgContent, 3);
            fpVo.setDispName(dispName);
            fpVo.setDispTime(dispTime);
            fpVo.setDispSeat(dispSeat);
            //System.out.println("dispName: " + fpVo.getDispName()+" dispTime:"+fpVo.getDispTime()+" dispSeat:"+fpVo.getDispSeat()+"\n");
            //logger.info("dispName: " + fpVo.getDispName()+" dispTime:"+fpVo.getDispTime()+" dispSeat:"+fpVo.getDispSeat()+"\n");
        }
    }

    //起始点和目的地
    public static void startAndDestImpl() {
        String routeAndDistRegex = "ROUTE\\s+(\\w*)\\s+(\\d+)NM";
        String startAndDestRegex = "REFILE\\s*FLT\\d+ORG\\*(\\w+)\\s*/\\s*DEST\\s*(\\w+)";
        if (RegExpTool.isMatched(startAndDestRegex, msgContent)) {
            String refileStart = RegExpTool.find(routeAndDistRegex, msgContent, 1);
            String refileDest = RegExpTool.find(routeAndDistRegex, msgContent, 2);
            //logger.info("refileStart: " + refileStart +" refileDest: " +refileDest+"\n");
            fpVo.getOfpRefileVo().setRefileStart(refileStart);
            fpVo.getOfpRefileVo().setRefileDest(refileDest);
        }
    }


}