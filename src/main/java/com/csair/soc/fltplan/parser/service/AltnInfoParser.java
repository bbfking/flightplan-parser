package com.csair.soc.fltplan.parser.service;

import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;
import com.csair.soc.fltplan.parser.vo.OfpAltnVo;

import java.util.ArrayList;
import java.util.List;

public class AltnInfoParser {
	public String msgContent;
	public FpVo fpVo;
	public String ofpNr;
	public AltnInfoParser(FpVo newFpVo) {
		fpVo=newFpVo;
		msgContent=fpVo.getOfpText();
		msgContent=msgContent.substring(msgContent.indexOf("PRIMARY ALTERNATES SUMMARY"),
				msgContent.indexOf("RVSM ALTIMETER CHECK"));			
		ofpNr=fpVo.getOfpNr();
	}
	public void altnInfoImpl(){
		StringBuffer sb=new StringBuffer(msgContent);
		List<OfpAltnVo> list=new ArrayList<OfpAltnVo>();
		String ofoAltnRegex="([A-Z]{4})\\s*(\\d+)\\s*FL(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\d+)\\s*(\\w+)\\W";
		try {
			int altnSeqNr=1;
			while(RegExpTool.isMatched(ofoAltnRegex, sb.toString())) {
				//test
				String allMessage=RegExpTool.find(ofoAltnRegex, sb.toString());

				String altnIcaoCd = RegExpTool.find(ofoAltnRegex, sb.toString(), 1);
				String altnDist=RegExpTool.find(ofoAltnRegex, sb.toString(), 2);
				String altnFl=RegExpTool.find(ofoAltnRegex, sb.toString(), 3);
				String altnEet=RegExpTool.find(ofoAltnRegex, sb.toString(), 4);
				String altnEta=RegExpTool.find(ofoAltnRegex, sb.toString(), 5);
				String altnFuel=RegExpTool.find(ofoAltnRegex, sb.toString(), 6);
				String altnWc=RegExpTool.find(ofoAltnRegex, sb.toString(), 7);

				sb.delete(sb.indexOf(allMessage),sb.indexOf(allMessage)+63);


				OfpAltnVo ofpAltnVo=new OfpAltnVo();
				ofpAltnVo.setOfpNr(ofpNr);
				ofpAltnVo.setAltnSeqNr(String.valueOf(altnSeqNr));
				ofpAltnVo.setAltnIcaoCd(altnIcaoCd);
				ofpAltnVo.setAltnDist(altnDist);
				ofpAltnVo.setAltnFl(altnFl);
				ofpAltnVo.setAltnEet(altnEet);
				ofpAltnVo.setAltnEta(altnEta);
				ofpAltnVo.setAltnFuel(altnFuel);
				ofpAltnVo.setAltnWc(altnWc);
				////

				//logger.info(JSONObject.fromObject(ofpAltnVo).toString()+"\n");

				list.add(ofpAltnVo);

				altnSeqNr++;
			}
		}
		catch (Exception e) {
			//logger.info("getAltnInfo 异常..." + e.getMessage());
		}
		fpVo.setOfpAltnVo(list);
		//return list;
		
	}
}