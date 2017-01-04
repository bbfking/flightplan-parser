package com.csair.soc.fltplan.parser.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringWriter;

public abstract class JacksonUtil {
    private static final ObjectMapper OM = new ObjectMapper();

    public static <T> String toString(T value){
        if(value == null){
            return "";
        }
        String str = "";
        try {
            str = OM.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static <T> String writeValue(T value){
        if(value == null){
            return "";
        }
        StringWriter str = new StringWriter();
        try {
           OM.writeValue(str,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toString();
    }
    
    public static <T> byte[] toBytes(T mb) {
        byte[] bytes = null;
        try {
            bytes = OM.writeValueAsBytes(mb);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * 
     * 从byte[]类型，还原数据
     * @param o
     * @param typeReference
     * @return
     */
    public static <T> T getData(byte[] o, TypeReference<T> typeReference) {
        T data = null;
        try {
            data = OM.readValue((byte[]) o, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    
    /**
     * 
     * 从byte[]类型，还原数据
     * @return
     */
    public static <T> T getData(String dateStr, Class<T> valueType ) {
    	T data=null;
        try {
            data = OM.readValue(dateStr,valueType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
     
}
