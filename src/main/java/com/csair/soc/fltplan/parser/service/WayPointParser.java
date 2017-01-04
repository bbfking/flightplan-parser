package com.csair.soc.fltplan.parser.service;


import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;
import com.csair.soc.fltplan.parser.vo.OfpWayPointVo;

import java.util.ArrayList;
import java.util.List;

public class WayPointParser {
	
		private static final String newTpye = null;
		public String msgContent;
		public FpVo fpVo;
		public String ofpNr;
		public String type;
		public WayPointParser(FpVo newFpVo, String newType) {
			fpVo=newFpVo;	
			type=newTpye;
			msgContent=fpVo.getOfpText();
			msgContent=msgContent.substring(msgContent.indexOf("WAYPOINT SUMMARY"),
					msgContent.indexOf("UPPER WIND DIRECTION"));			
			ofpNr=fpVo.getOfpNr();
		}
	public void wayPointInfoImpl(){
		List<OfpWayPointVo> list = new ArrayList<OfpWayPointVo>();
		StringBuffer sb=new StringBuffer(msgContent);
		String[] wayPoint=sb.toString().split("\\r\\n");
		String WayPointRegex="([A-Z][A-Z0-9]+)\\s+((N|S)\\d+\\s+\\d+.\\d)\\s+((E|W)\\d+\\s+\\d+.\\d)\\s*(\\d+\\.\\d+)*\\s*([A-Z]{4}\\s*\\d*)*";
		try {
			int wpNum=1;
			for(int index=0;index<wayPoint.length;index++ ) {
				//test
				if (RegExpTool.isMatched(WayPointRegex, wayPoint[index])) {
					String wpName = RegExpTool.find(WayPointRegex, wayPoint[index], 1);
					String wpLat=RegExpTool.find(WayPointRegex, wayPoint[index], 2);
					String wpLon=RegExpTool.find(WayPointRegex, wayPoint[index], 4);
					String freq=RegExpTool.find(WayPointRegex, wayPoint[index], 6);
					String informationCode=RegExpTool.find(WayPointRegex, wayPoint[index], 7);

					OfpWayPointVo wp=new OfpWayPointVo();
					wp.setWayPoint(wpName);
					wp.setLat(wpLat);
					wp.setLon(wpLon);
					wp.setWpNr(wpNum++);
					wp.setOfpNr(ofpNr);
					wp.setFreq(freq);
					wp.setInformationCode(informationCode);
					wp.setType(type);
					
					//logger.info("测试测试测试waypoint"+JSONObject.fromObject(wp).toString()+"\n");
					list.add(wp);
				}
			}
		}
		catch (Exception e) {
			//logger.info("getWaypointSummary 异常..." + e.getMessage()+"\n");
		}

		//Log logger=LogFactory.getLog("fp");;
		//return list;
		fpVo.setOfpWayPoints(list);
		//logger.info("测试测试测试waypoint"+JacksonUtil.toString(fpVo.getOfpWayPoints()).toString()+"\n");
	}
}
