package com.csair.soc.fltplan.parser.service;


import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;
import com.csair.soc.fltplan.parser.vo.OfpEtopsVo;

import java.util.ArrayList;
import java.util.List;

public class EtopsParser {
	
	public String msg;
	public FpVo fpVo;
	public String ofpNr;

	public EtopsParser(FpVo newFpVo) {
		
		fpVo=newFpVo;
		msg=fpVo.getOfpText();
/*		msg=msg.substring(msg.indexOf("PRIMARY ALTERNATES SUMMARY"),
				msg.indexOf("RVSM ALTIMETER CHECK"));	*/
		
		ofpNr=fpVo.getOfpNr();
	}

	public void ofpEtopsImpl(){
		List<OfpEtopsVo> list=new ArrayList<OfpEtopsVo>();
		StringBuffer sb=new StringBuffer(msg);
		String[] ofpEtops=sb.toString().split("\\r\\n");


		String line1="ETP\\w+\\s*([A-Z]{4})\\s*\\-\\s*(\\d+Z\\+0100)\\s*\\.....\\s*([A-Z]{4})\\s*\\-\\s*(\\d+Z\\-0100)\\s*\\.....";
		String line2="EET\\s*(\\d+:\\d+)\\s*ETA\\......\\s*FUEL REQ TO ETP\\s*(\\d+)";
		String line3="AT\\s*LAT/LONG\\s*(\\w+\\s*\\d+\\.\\d*)\\s*(\\w+\\s*\\d+\\.\\d+)\\s*\\-\\s*(\\d+)";
		String line4="W/C TO \\w+\\s*(\\w+)\\s*W/C TO \\w+\\s*(\\w+)\\s*ETE\\s*(\\d+:\\d+)\\s*DIVER FUEL\\s*(\\d+)";
		String line5="FUEL REQ TO ALTN\\s*(\\d+)";

		int etopsNr=1;
		for(int index=0;index<ofpEtops.length;index++) {
			if(RegExpTool.isMatched(line1,ofpEtops[index])){
				OfpEtopsVo ofpEtopsVo=new OfpEtopsVo();

				String etopCd1 = RegExpTool.find(line1, sb.toString(), 1);
				String maxArv = RegExpTool.find(line1, sb.toString(), 2);
				String etopCd2 = RegExpTool.find(line1, sb.toString(), 3);
				String minArv = RegExpTool.find(line1, sb.toString(), 4);

				ofpEtopsVo.setOfpNr(ofpNr);
				ofpEtopsVo.setEtopsNr(String.valueOf(etopsNr));
				ofpEtopsVo.setEtopCd1(etopCd1);
				ofpEtopsVo.setMaxArv(maxArv);
				ofpEtopsVo.setEtopCd2(etopCd2);
				ofpEtopsVo.setMinArv(minArv);

				//String operTm=publicMethod.getCurrentDt();ofpEtopsVo.setOperTm(operTm);

				list.add(ofpEtopsVo);
				etopsNr++;
			}
		}	
		int start=0;
		for(int etopIndex=0;etopIndex<=list.size();etopIndex++) {
			for(int index=start;index<ofpEtops.length;index++) {
				if(RegExpTool.isMatched(line2,ofpEtops[index])){
					String eet = RegExpTool.find(line2,ofpEtops[index], 1);
					String reqFuel = RegExpTool.find(line2, ofpEtops[index], 2);
					String lat = RegExpTool.find(line3, ofpEtops[++index], 1);
					String lon = RegExpTool.find(line3, ofpEtops[index], 2);
					String beforeNm = RegExpTool.find(line3, ofpEtops[index], 3);
					String wind1 = RegExpTool.find(line4, ofpEtops[++index], 1);
					String wind2 = RegExpTool.find(line4, ofpEtops[index], 2);
					String ete = RegExpTool.find(line4, ofpEtops[index], 3);
					String diverFuel = RegExpTool.find(line4, ofpEtops[index], 4);
					String reqAltnFuel = RegExpTool.find(line5, ofpEtops[index], 1);
					start=index;

					list.get(etopIndex).setEet(eet);
					list.get(etopIndex).setReqFuel(reqFuel);
					list.get(etopIndex).setLat(lat);
					list.get(etopIndex).setLon(lon);
					list.get(etopIndex).setBeforeNm(beforeNm);
					list.get(etopIndex).setWind1(wind1);
					list.get(etopIndex).setWind2(wind2);
					list.get(etopIndex).setEte(ete);
					list.get(etopIndex).setDiverFuel(diverFuel);
					list.get(etopIndex).setReqAltnFuel(reqAltnFuel);
					//logger.info(JSONObject.fromObject(list.get(etopIndex)).toString());
					break;
				}
			}
			
		}

	fpVo.setOfpEtopsVos(list);

	}
}
