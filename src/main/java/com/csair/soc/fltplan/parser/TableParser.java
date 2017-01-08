package com.csair.soc.fltplan.parser;

import com.csair.soc.fltplan.parser.config.TableBean;
import com.csair.soc.fltplan.parser.config.TableRow;
import com.csair.soc.fltplan.parser.util.RegExpTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pfXiong on 2017/1/8.
 */
public class TableParser {
    private static Logger logger = LogManager.getLogger(TableParser.class);
    /**
     *
     * @param content
     * @param tb
     * @return list中的第一个map表示大table的内容
     */
    static List<Map<String,String>> parseTable(String content, TableBean tb){
        List<Map<String,String>> list = new ArrayList<Map<String, String>>();
        if (content == null)return list;
        if (tb == null) throw new RuntimeException("table can't be null,content:\n"+content);
        if (tb.getRegex() == null || tb.getField() == null || tb.getSplitReg() == null)
            throw new RuntimeException("regex or field or SplitReg can't be null,tableBean:\n"+tb);
        String tableContent = RegExpTool.find(tb.getRegex(),content,tb.getGroup());
        if (tableContent != null){
            tableContent = tableContent.replace("\f","");
            //最外层table的解析
            Map<String, String> tableMap = new HashMap<String, String>();
            tableMap.put(tb.getField(),tableContent);
            list.add(tableMap);
            String[] rowsList = tableContent.split(tb.getSplitReg());
            for (String rowMsg : rowsList){
                //行为空值，不需要解析 行分隔符，不需要解析
                if("".equals(rowMsg.trim())||RegExpTool.isMatched(tb.getSplitReg(),rowMsg.trim()))continue;
                Map<String,String> rowMap = parseRow(rowMsg,tb.getRows());
                list.add(rowMap);//添加解析结果到list中
            }
        }
        return list;
    }
    /**
     * 解析表格中的一行数据
     */
    static Map<String,String> parseRow(String content, List<TableRow> trs){
        Map<String,String> map = new HashMap<String, String>();
        if (content == null)return map;
        if (trs == null) throw new RuntimeException("TableRows can't be null,content:\n"+content);
        String[] lines = content.split("\n");
        for (TableRow tr : trs){
            if (tr.getField() == null)
                throw new RuntimeException("field can't be null,TableRow:\n"+tr);
            if(lines.length < tr.getRowNum()) {
                throw new RuntimeException("lines.length < tr.getRowNum(),content={}" +
                        content + "\n tr="+ tr.toString());
            }
            //查找结束的位置
            int rowNum = tr.getRowNum()-1;//tr.getRowNum()从1开始
            String rowString = lines[rowNum];
            int endPos = rowString.indexOf(tr.getEndFlag(),tr.getStartPos()+1);
            if(tr.getStartPos()>0&&endPos>tr.getStartPos()&&endPos<rowString.length()){
                String value = rowString.substring(tr.getStartPos(),endPos);
                logger.debug("name: {} value: {}",tr.getField(),value);
                map.put(tr.getField(),value);
            }
        }
        return map;
    }
}
