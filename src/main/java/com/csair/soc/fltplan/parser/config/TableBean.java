package com.csair.soc.fltplan.parser.config;

import java.util.List;

/**
 * 表结构
 * Created by pfXiong on 2017/1/7.
 */
public class TableBean {
    private String field;
    private String regex;
    private int group;
    /**
     * 表格行之间的分隔标志
     */
    private String splitReg;
    /**
     * 一个表格可以有多行
     */
    private List<TableRow> rows;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getSplitReg() {
        return splitReg;
    }

    public void setSplitReg(String splitReg) {
        this.splitReg = splitReg;
    }

    public List<TableRow> getRows() {
        return rows;
    }

    public void setRows(List<TableRow> rows) {
        this.rows = rows;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "TableBean{" +
                "field='" + field + '\'' +
                ", regex='" + regex + '\'' +
                ", splitReg='" + splitReg + '\'' +
                ", rows=" + rows +
                '}';
    }
}
