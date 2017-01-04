package com.csair.soc.fltplan.parser;

import com.csair.soc.fltplan.parser.util.EncodingDetect;
import com.csair.soc.fltplan.parser.util.FileUtil;
import com.csair.soc.fltplan.parser.util.JacksonUtil;
import com.csair.soc.fltplan.parser.vo.FpVo;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by pfXiong on 2017/1/4.
 */
public class FlightPlanParseClientTest {
    private static final String FLT_PLAN_TYPE = ".txt";
    private static final String FLT_PLAN_PATH = "src\\test\\resources\\flightPlan";
    private static Logger logger = LogManager.getLogger(FlightPlanParseClientTest.class);

    @Test
    public void testParseFlightPlan(){
        List<File> fileLists = FileUtil.getFileList(FLT_PLAN_PATH,FLT_PLAN_TYPE);
        for (File file : fileLists){
            try {
                String encode = EncodingDetect.getJavaEncode(file.getPath());
                String msgContent = FileUtils.readFileToString(file,encode);
                logger.info("飞行计划原文,文件编码{}\n ***************************************\n",encode);
                logger.info(msgContent);
                logger.info("\n ***************************************\n");
                FpVo fp = FlightPlanParseClient.flightPlanParse(msgContent);
                logger.info("parser finish");
                logger.info(JacksonUtil.toString(fp));
            } catch (IOException e) {
                logger.error(e);
            }
        }

    }
}
