package com.csair.soc.fltplan.parser.config;

import java.util.List;

/**
 * Created by pfXiong on 2017/1/7.
 */
public class RegexBean {
    private String regex;
    private String field;
    /**
     * group 默认为1
     */
    private int group = 1;
    private List<RegexBean> regexBeans;

    private List<TableBean> tableBeans;

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public List<RegexBean> getRegexBeans() {
        return regexBeans;
    }

    public void setRegexBeans(List<RegexBean> regexBeans) {
        this.regexBeans = regexBeans;
    }

    public List<TableBean> getTableBeans() {
        return tableBeans;
    }

    public void setTableBeans(List<TableBean> tableBeans) {
        this.tableBeans = tableBeans;
    }

    @Override
    public String toString() {
        return "RegexBean{" +
                "regex='" + regex + '\'' +
                ", field='" + field + '\'' +
                ", group=" + group +
                ", regexBeans=" + regexBeans +
                ", tableBeans=" + tableBeans +
                '}';
    }
}
