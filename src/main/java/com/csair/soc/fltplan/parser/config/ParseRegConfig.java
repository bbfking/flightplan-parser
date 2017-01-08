package com.csair.soc.fltplan.parser.config;

/**
 * 解析正则表达式配置
 * Created by pfXiong on 2017/1/7.
 */
public class ParseRegConfig {
    //判断是否是飞行计划原文的标志
    private String flightSign = "START OF FLIGHT PLAN";

    //取出rlsText部分
    private String rlsTextReg = "[\n|\\f]+(.*CHINA SOUTHERN AIRLINES[\\w\\W]*?)[\n]+.*START OF FLIGHT PLAN";

    //截取ofp部分
    private String ofpTextReg = "[\\f|\n]+(.*START OF FLIGHT PLAN[\\w\\W]*END OF FLIGHT PLAN.*)[\n|\\f]+";
    //fpl部分
    private String fplTextReg = "END OF FLIGHT PLAN.*[\n|\\f]+([\\w\\W]*?)[\n]+.*OFP SUMMARY";

    //ofpSummar部分
    private String ofpSummaryReg = "OFP SUMMARY.*[\n|\\f]+([\\w\\W]*?)[\n|\\f]+=================";
    //other部分
    private String otherPartReg = "CREW ALERT.*[\n|\\f]+([\\w\\W]*?)[\n|\\f]+D I S P A T C H  B R I E F I N G  I N F O";
    //notam部分
    private String notamPargReg = "-NOTAM-BULLETIN INCLUDES NOTAM.*[\n|\\f]+([\\w\\W]*?)[\n|\\f]+.*END OF LIDO-NOTAM-BULLETIN";
    //解析飞越许可
    private String overFlightPermissionReg = "[\n|\\f]+(.*OVERFLIGHT PERMISSION[\\w\\W]*?)[\n|\\f]+.*                              ";

    // etops信息
    private String etopsReg = "[\n|\\f]+(.*ETOPS SUMMARY[\\w\\W]*?DEP ATIS:).*[\n|\\f]+.*";

}
