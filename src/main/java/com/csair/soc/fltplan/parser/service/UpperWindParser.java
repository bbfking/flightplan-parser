package com.csair.soc.fltplan.parser.service;


import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;
import com.csair.soc.fltplan.parser.vo.OfpUpperWindVo;

import java.util.ArrayList;
import java.util.List;

public class UpperWindParser {
	public String msgContent;
	public FpVo fpVo;
	public String ofpNr;
	public UpperWindParser(FpVo newFpVo) {
		
		fpVo=newFpVo;	
		ofpNr=fpVo.getOfpNr();
		msgContent=fpVo.getOfpText();
		msgContent=msgContent.substring(msgContent.indexOf("UPPER WIND DIRECTION"),
				msgContent.indexOf("PILOT REPORT"));
	}
	public void upperWindInfoImpl(){
		List<OfpUpperWindVo> list=new ArrayList<OfpUpperWindVo>();

		
		String[] str=msgContent.split("\r\n");
		String flRegex="POINT\\s*([FL\\d+\\s*]*)";
		String flTemperRegex="(\\w+)\\s*(\\d+/\\d+\\-\\d+\\s*[\\d+/\\d+\\-\\d+\\s*]*)";

		try {
			int wpNr=1;
			String fl="";
			
			for(int i=0;i<str.length;i++){
				if(RegExpTool.isMatched(flRegex, str[i])){
					fl=RegExpTool.find(flRegex, str[i],1).trim();
					break;
				}
			}
			for(int i=0;i<str.length;i++){
				if(RegExpTool.isMatched(flTemperRegex,str[i])) {

					OfpUpperWindVo ofpUpperWindVo=new OfpUpperWindVo();	
					ofpUpperWindVo.setFl(fl);
					ofpUpperWindVo.setWpNr(String.valueOf(wpNr));

					String wayPoint=RegExpTool.find(flTemperRegex, str[i],1);
					String flTemper=RegExpTool.find(flTemperRegex, str[i],2);

					ofpUpperWindVo.setOfpNr(ofpNr);
					ofpUpperWindVo.setWayPoint(wayPoint);
					ofpUpperWindVo.setFlTemper(flTemper);
					//Log   logger   =   LogFactory.getLog("fp"); 
					//logger.info(JSONObject.fromObject(ofpUpperWindVo).toString()+"\n");

					list.add(ofpUpperWindVo);
					//fpVo.getOfpUpperWindVo().add(ofpUpperWindVo);
					wpNr++;
				}
			}
		}
		catch (Exception e) {
			//logger.info("getOfpUpperWind 异常..." + e.getMessage());
		}

		fpVo.setOfpUpperWindVo(list);
	}

}
