package com.csair.soc.fltplan.parser.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RegExpTool
 * @Description: Java姝ｅ垯琛ㄨ揪寮忓伐鍏风被
 * @author: liuzhiheng
 * @date: 2013-3-8
 * 
 */
public class RegExpTool {
	
	/**
	 * 
	 * @param expressionStr 表达式
	 * @param matcherStr  待匹配的字符串
	 * @return 如果能匹配成功，返回第一个匹配成功的字符串。
	 */
	public static String find(String expressionStr, String matcherStr) {
		Pattern pattern = Pattern.compile(expressionStr, Pattern.DOTALL); //包含行模式
		Matcher matcher = pattern.matcher(matcherStr);
		if (matcher.find()) {
			return matcher.group();
		}
		return null;
	}

	/**
	 * 
	 * @param expressionStr
	 * @param matcherStr
	 * @param groupIndex
	 * @return 如果能匹配成功，返回第groupIndex个匹配成功的字符串。
	 */
	public static String find(String expressionStr, String matcherStr,
			int groupIndex) {
		Pattern pattern = Pattern.compile(expressionStr);
		Matcher matcher = pattern.matcher(matcherStr);
		if (matcher.find()) {
			return matcher.group(groupIndex);
		}

		return null;
	}
	
	/**
	 * 
	 * @param expressionStr
	 * @param matcherStr
	 * @return 返回所有匹配成功的字符串
	 */

	public static List<String> findAll(String expressionStr, String matcherStr) {
		Pattern pattern = Pattern.compile(expressionStr);
		Matcher matcher = pattern.matcher(matcherStr);
		List<String> matchList = new ArrayList<String>();
		while (matcher.find()) {
			matchList.add(matcher.group());
		}
		return matchList;
	}
	
	
	/**
	 * 
	 * @param expressionStr
	 * @param matcherStr
	 * @return 判断是否有匹配的字符串，有则返回true
	 */
	public static boolean isMatched(String expressionStr, String matcherStr) {
		Pattern pattern = Pattern.compile(expressionStr);
		Matcher matcher = pattern.matcher(matcherStr);
		return matcher.find();
	}
	
	/**
	 * 
	 * @param expressionStr
	 * @param matcherStr
	 * @param patternFlag
	 * @return 可选择匹配模式的的isMatched();
	 */

	public static boolean isMatched(String expressionStr, String matcherStr,
			int patternFlag) {
		Pattern pattern = Pattern.compile(expressionStr, patternFlag);
		Matcher matcher = pattern.matcher(matcherStr);
		return matcher.find();
	}
	
	/**
	 * 
	 * @param expressionStr
	 * @param matcherStr
	 * @return 如果匹配成功，返回字符串的第一个索引值，否则返回-1；
	 */
	public static int start(String expressionStr, String matcherStr) {
		Pattern pattern = Pattern.compile(expressionStr);
		Matcher matcher = pattern.matcher(matcherStr);
		if (matcher.find())
			return matcher.start();
		else
			return -1;
	}
	
	/**
	 * 
	 * @param expressionStr
	 * @param matcherStr
	 * @param nBeginPos 指定其起始搜索位置
	 * @return 
	 */
	public static int start(String expressionStr, String matcherStr,
			int nBeginPos) {
		if (expressionStr == null || matcherStr == null)
			return -1;
		Pattern pattern = Pattern.compile(expressionStr);
		Matcher matcher = pattern.matcher(matcherStr);
		if (matcher.find(nBeginPos))
			return matcher.start();
		else
			return -1;
	}

	public static void main(String[] args) {
		 System.out.println(RegExpTool.start("\\d{4,6}", "899  kjghgh"));
		// String m= RegExpTool.find("((\\w{2}\\s){1}.+[/|\\r|\\n])++",
		// "-  PRG/FNCSN3740/DTZGSD,05O,96,030515,291A69\r");
		// System.out.println("result===" +m);
	}
}
