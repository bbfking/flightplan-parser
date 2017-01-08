package com.csair.soc.fltplan.parser;

import com.csair.soc.fltplan.parser.config.ReadYaml;
import com.csair.soc.fltplan.parser.config.RegexBean;
import org.junit.Test;

import java.util.List;

/**
 * 测试config
 * Created by pfXiong on 2017/1/8.
 */
public class ConfigTest {
    @Test
    public void testParseYaml() {
        List<RegexBean> rbs = ReadYaml.getPatternList("regYaml");
        System.out.println(rbs);
    }
}
