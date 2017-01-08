package com.csair.soc.fltplan.parser;

import com.csair.soc.fltplan.parser.config.ReadYaml;
import com.csair.soc.fltplan.parser.config.RegexBean;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.csair.soc.fltplan.parser.FlightPlanParseClientTest.readTestFile;

/**
 * Created by pfXiong on 2017/1/8.
 */
public class RegexParserTest {
    @Test
    public void getFieldParseMap() {
        String testFile = readTestFile();
        List<RegexBean> rbs = ReadYaml.getPatternList("regYaml");
        Map<String,String> map = RegexParser.getFieldParseMap(testFile,rbs.get(0));
        System.out.println(map);
    }

}
