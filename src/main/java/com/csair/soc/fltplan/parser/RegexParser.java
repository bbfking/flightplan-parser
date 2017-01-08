package com.csair.soc.fltplan.parser;

import com.csair.soc.fltplan.parser.config.RegexBean;
import com.csair.soc.fltplan.parser.util.RegExpTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 正则表达式解析器
 * Created by pfXiong on 2017/1/8.
 */
public class RegexParser {
    private static Logger logger = LogManager.getLogger(RegexParser.class);

    public void parse(String content, RegexBean regexBean) {

        String text = RegExpTool.find(content,regexBean.getRegex(),regexBean.getGroup());

    }

    /**
     * 使用正则表达式解析
     * @param content 待解析内容
     * @param regexBean 解析规则
     * @return
     */
    static Map<String, String> getFieldParseMap(String content, RegexBean regexBean){
        Map<String, String> map = new HashMap<String, String>();
        if (content == null)return map;
        if (regexBean == null) throw new RuntimeException("regexBean can't be null,content:\n"+content);
        if (regexBean.getRegex() == null || regexBean.getField() == null)
            throw new RuntimeException("regex or field can't be null,regexBean:\n"+regexBean);
        String text = RegExpTool.find(regexBean.getRegex(),content,regexBean.getGroup());
        if (text != null){
            map.put(regexBean.getField(),text.trim());
            if(regexBean.getRegexBeans() != null){
                //上一份regexBean的regex,规则为如果此份RegexBean，没有regex，则延用上一份的regex
                String preRegex = null;
                for (RegexBean rb : regexBean.getRegexBeans()) {
                    if(rb.getRegex() == null){
                        rb.setRegex(preRegex);
                    }
                    preRegex = rb.getRegex();
                    //递归解析text
                    map.putAll(getFieldParseMap(text,rb));
                }
            }
        }
        return map;
    }
}
