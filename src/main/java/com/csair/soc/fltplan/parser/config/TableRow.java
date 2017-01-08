package com.csair.soc.fltplan.parser.config;

/**
 * Created by pfXiong on 2017/1/7.
 */
public class TableRow {
    //行号， 有些表格一条数据可能有两行
    int rowNum = 1;
    //数据起始位置,startPos位置从1开始
    int startPos;
    //数据结束标志，默认为一个空格" "
    String endFlag = " ";
    String field;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public String getEndFlag() {
        return endFlag;
    }

    public void setEndFlag(String endFlag) {
        this.endFlag = endFlag;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "TableRow{" +
                "rowNum=" + rowNum +
                ", startPos=" + startPos +
                ", endFlag='" + endFlag + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
