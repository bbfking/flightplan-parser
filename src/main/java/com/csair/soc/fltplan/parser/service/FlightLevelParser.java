package com.csair.soc.fltplan.parser.service;

import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;
import com.csair.soc.fltplan.parser.vo.OfpFlightLevelVo;

import java.util.ArrayList;
import java.util.List;

public class FlightLevelParser {
	public String msgContent;
	public String type;
	public FpVo fpVo;
	public String ofpNr;
	public FlightLevelParser(FpVo newFpVo, String newType) {
		fpVo=newFpVo;
		ofpNr=fpVo.getOfpNr();
		msgContent=fpVo.getOfpText();
		msgContent=msgContent.substring(msgContent.indexOf("FL  ATA ZTM/TTME POSN"),
				msgContent.indexOf("ARR ATIS"));
		type=newType;			
		
	}
	public void flightLevelInfoImpl() {
		String[] str=msgContent.split("\r\n");       
		List<OfpFlightLevelVo> list=new ArrayList<OfpFlightLevelVo>();
		String ofpFlightRegex1="(\\w+)\\s*(\\d+)/*\\s*(\\d+)\\s*(\\w+)\\s*(\\w+)\\s*(\\d+)\\s*(\\d+)\\s*(\\.*\\d*[A-Z]*)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+\\.*\\d*)";
		String ofpFlightRegex2="(\\w*)\\s*\\.+\\s*(\\d+)\\s*\\.+\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*";
		String ofpFlightFirstLine="([A-Z]{4})\\s{20,}(\\d+)\\s{10,}(\\d+\\.*\\d*)";
		boolean first=true;
		//System.out.println("？？？？？？？？？？？？？？？？？？进来了？？？？？？？？？？？？？");
		try {
			int flSeqNr=1;
			//Log   logger   =   LogFactory.getLog("fp"); 
			for(int i=0;i<str.length-1;i++){
				
				if(first && RegExpTool.isMatched(ofpFlightFirstLine,str[i])){
					String posn=RegExpTool.find(ofpFlightFirstLine,str[i],1);
					//System.out.println(msgContent+"\n"+"-------------------------------------------------------");
					//System.out.println(str[i]);
					String dtgo=RegExpTool.find(ofpFlightFirstLine,str[i],2);
					String efr=RegExpTool.find(ofpFlightFirstLine,str[i],3);
					OfpFlightLevelVo ofpFlightLevelVo=new OfpFlightLevelVo();
					ofpFlightLevelVo.setPosn(posn);
					ofpFlightLevelVo.setDtgo(dtgo);
					ofpFlightLevelVo.setEfr(efr);
					ofpFlightLevelVo.setTime("0");
					ofpFlightLevelVo.setZtm("0");
					ofpFlightLevelVo.setType(type);
					ofpFlightLevelVo.setFlSeqNr(flSeqNr);
					ofpFlightLevelVo.setOfpNr(ofpNr);
					//logger.info(JSONObject.fromObject(ofpFlightLevelVo).toString());
					list.add(ofpFlightLevelVo);
					first=false;
					flSeqNr++;
				}

				if(RegExpTool.isMatched(ofpFlightRegex1, str[i]) && 
						RegExpTool.isMatched(ofpFlightRegex2, str[i+1])) {
					//test
					String flightLevel = RegExpTool.find(ofpFlightRegex1,  str[i], 1);
					String ztm=RegExpTool.find(ofpFlightRegex1,  str[i], 2);
					String time=RegExpTool.find(ofpFlightRegex1,  str[i], 3);
					String posn=RegExpTool.find(ofpFlightRegex1,  str[i], 4);
					String awy=RegExpTool.find(ofpFlightRegex1,  str[i], 5);
					String dst=RegExpTool.find(ofpFlightRegex1,  str[i], 6);
					String dtgo=RegExpTool.find(ofpFlightRegex1,  str[i], 7);
					String mach=RegExpTool.find(ofpFlightRegex1,  str[i], 8);
					String tas=RegExpTool.find(ofpFlightRegex1,  str[i], 9);
					String wind=RegExpTool.find(ofpFlightRegex1,  str[i], 10);
					String efr=RegExpTool.find(ofpFlightRegex1,  str[i], 11);


					String oat=RegExpTool.find(ofpFlightRegex2, str[i+1], 1);
					String msa=RegExpTool.find(ofpFlightRegex2, str[i+1], 2);
					String mtk=RegExpTool.find(ofpFlightRegex2, str[i+1], 3);
					String ws=RegExpTool.find(ofpFlightRegex2, str[i+1], 4);
					String gs=RegExpTool.find(ofpFlightRegex2, str[i+1], 5);


					OfpFlightLevelVo ofpFlightLevelVo=new OfpFlightLevelVo();

					ofpFlightLevelVo.setOfpNr(ofpNr);
					ofpFlightLevelVo.setFlSeqNr(flSeqNr);
					ofpFlightLevelVo.setFlightLevel(flightLevel);
					ofpFlightLevelVo.setZtm(ztm);
					ofpFlightLevelVo.setTime(time);
					ofpFlightLevelVo.setPosn(posn);
					ofpFlightLevelVo.setAwy(awy);
					ofpFlightLevelVo.setDst(dst);
					ofpFlightLevelVo.setDtgo(dtgo);
					ofpFlightLevelVo.setMach(mach);
					ofpFlightLevelVo.setTas(tas);
					ofpFlightLevelVo.setWind(wind);
					ofpFlightLevelVo.setEfr(efr);
					ofpFlightLevelVo.setOat(oat);
					ofpFlightLevelVo.setMsa(msa);
					ofpFlightLevelVo.setMtk(mtk);
					ofpFlightLevelVo.setWs(ws);
					ofpFlightLevelVo.setGs(gs);
					ofpFlightLevelVo.setType(type);
					//logger.info("***********8这是正常的"+JSONObject.fromObject(ofpFlightLevelVo).toString());
					
					list.add(ofpFlightLevelVo);
					flSeqNr++;
					//fpVo.setOfpFlightLevel(list);
				}
				
				
				
			}
			fpVo.setOfpFlightLevel(list);
//			System.out.println("？？？？？？？？？？？？？？？？？？进来了？？？？？？？？？？？？？");

			//logger.info("************************有毛病"+JSONObject.fromObject(list.get(1).toString()));
			
			//logger.info("***********************有毛病"+"zhixihgshkdfh");
			
		}
		catch (Exception e) {
			//logger.info("getFlightLevel 异常..." + e.getMessage());
		}

		
	}
}
