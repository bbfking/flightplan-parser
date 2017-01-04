package com.csair.soc.fltplan.parser.service;


import com.csair.soc.fltplan.parser.util.RegExpTool;
import com.csair.soc.fltplan.parser.vo.FpVo;

public class FltDtParser {
	public String msgContent;
	public FpVo fpVo;

	public FltDtParser(FpVo newFpVo) {
		
		fpVo=newFpVo;
		msgContent=fpVo.getOfpText();
	}
	
	public void fltDtImpl(){
		String fltDtRegex = "/(\\d{2}\\w{3}\\d{2})Z";
		if (RegExpTool.isMatched(fltDtRegex, msgContent)) {
			String fltDt = RegExpTool.find(fltDtRegex, msgContent, 1);
			fpVo.setFltDt(fltDt);
			//fpVo.setFltDt(publicMethod.getDateInfo(fltDt));
			//logger.info("fltDt: " + fpVo.getFltDt()+"\n");
		}
	}
	
	public void ofpDtImpl(){
		String OfpDRegex = "\\.\\w{7}\\s+(\\d{6})";
		if (RegExpTool.isMatched(OfpDRegex, msgContent)) {
			String ofpDt = RegExpTool.find(OfpDRegex, msgContent, 1);
			/**
			 * 以下两行DELL-PC 注解掉
			 */
			//fpVo.setOfpDt(publicMethod.getDayInfo(ofpDt));			
			//logger.info("ofpDt: " +fpVo.getOfpDt());
			fpVo.setOfpDt(ofpDt);
			//System.out.println("ofpDt: " +ofpDt); //新增加
		}
	}

}