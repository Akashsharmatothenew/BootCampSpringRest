package com.project.ecommerce.projectEcommerce.Service;


////import net.minidev.json.JSONArray;
////import net.minidev.json.JSONObject;
//import org.springframework.boot.jackson.JsonObjectDeserializer;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service
//public class JsonToMapService {
//
//    public static Map<String, Object> jsonToMap(JsonObjectDeserializer json) throws JSONException {
//        Map<String, Object> retMap = new HashMap<String, Object>();
//
//        if(json != JSONObject.NULL) {
//            retMap = toMap(json);
//        }
//        return retMap;
//    }
//
//    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
//        Map<String, Object> map = new HashMap<String, Object>();
//        Iterator<String> keysItr = object.keys;
//        while(keysItr.hasNext()) {
//            String key = keysItr.next();
//            Object value = object.get(key);
//            if(value instanceof JSONArray) {
//                value = toList((JSONArray) value);
//            }
//            else if(value instanceof JSONObject) {
//                value = toMap((JSONObject) value);
//            }
//            map.put(key, value);
//        }
//        return map;
//    }
//
//    public static List<Object> toList(JSONArray array) throws JSONException {
//        List<Object> list = new ArrayList<Object>();
//        for(int i = 0; i < array.length(); i++) {
//            Object value = array.get(i);
//            if(value instanceof JSONArray) {
//                value = toList((JSONArray) value);
//            }
//            else if(value instanceof JSONObject) {
//                value = toMap((JSONObject) value);
//            }
//            list.add(value);
//        }
//        return list;
//    }
//}
