

package com.smsgatewayadapter.ft.dynamic.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by exuxxio on 05/02/2018
 */
public class MapUtils {

    private static final Logger logger = LoggerFactory.getLogger(MapUtils.class);

    public static void setValue(Map<String, Object> tripMap, String key, Object value) {
        String[] keys = key.trim().split("\\.");
        if (keys.length > 0) {
            Map<String, Object> currentMap = tripMap;
            Map<String, Object> lastMap = tripMap;
            for (int i = 0; i < keys.length - 1; i++) {
                currentMap = (Map<String, Object>) lastMap.get(keys[i]);
                if (currentMap == null) {
                    currentMap = new HashMap<String, Object>();
                    lastMap.put(keys[i], currentMap);
                }
                lastMap = currentMap;
            }
            currentMap.put(keys[keys.length - 1], value);
        }
    }

    public static Object getValue(Map<String, Object> tripMap, String key) {
        String[] keys = key.trim().split("\\.");
        if (keys.length > 0) {
            Map<String, Object> currentMap = tripMap;
            for (int i = 0; i < keys.length - 1; i++) {
                Object value = currentMap.get(keys[i]);
                if (value instanceof Map) {
                    currentMap = (Map<String, Object>) currentMap.get(keys[i]);
                } else {
                    return null;
                }

            }
            return currentMap.get(keys[keys.length - 1]);
        }
        return null;
    }

    public static void remove(Map<String, Object> tripMap, String key) {
        String[] keys = key.trim().split("\\.");
        if (keys.length > 0) {
            Map<String, Object> currentMap = tripMap;
            for (int i = 0; i < keys.length - 1; i++) {
                Object value = currentMap.get(keys[i]);
                if (value instanceof Map) {
                    currentMap = (Map<String, Object>) currentMap.get(keys[i]);
                } else {
                    return;
                }
            }
             currentMap.remove(keys[keys.length - 1]);
        }
    }

    public static void setDefaultValueIfEmpty(Map<String, Object> tripMap, String key, Object defaultValue) {
        Object value = getValue(tripMap, key);
        if (value == null) {
            setValue(tripMap, key, defaultValue);
        }
    }

    public static Object getValue(Map<String, Object> tripMap, String key, Object defaultValue) {
        Object value = getValue(tripMap, key);
        if (value == null || (value instanceof String && StringUtils.isEmpty((CharSequence) value))) {
            return defaultValue;
        }
        return value;
    }

    public static Map<String, Object> putAll(Map<String, Object> orgMap, Map<String, Object> newMap) {
        Map<String, Object> mergedMap = new HashMap<>();

        orgMap.forEach((k, v) -> {
            if (newMap.containsKey(k)) {
                Object data = newMap.get(k);
                if (v == null || data == null) {
                    if (data == null && v == null) {
                        mergedMap.put(k, null);
                    } else {
                        mergedMap.put(k, data);
                    }
                } else {
//                    if (!v.getClass().isAssignableFrom(data.getClass())) {
//                        if (!(ClassUtils.isPrimitiveOrWrapper(v.getClass())
//                                && ClassUtils.isPrimitiveOrWrapper(data.getClass()))) {
//                            logger.error("fail to merge data, dismatch format");
//                            logger.error("original data key: {}, format: {}, new data format: {}", k, v.getClass(),
//                                    data.getClass());
//                            throw new RuntimeException("Merge map error");
//                        }
//                    }

                    if (data instanceof Map) {
                        Map<String, Object> temp = putAll((Map<String, Object>) v, (Map<String, Object>) data);
                        mergedMap.put(k, temp);
                    } else if (data instanceof List) {
                        Set<Object> mergedList = new HashSet<>();
                        mergedList.addAll((Collection<?>) v);
                        mergedList.addAll((Collection<?>) data);

                        List<Object> array = new ArrayList<>();
                        array.addAll(mergedList);
                        mergedMap.put(k, array);
                    } else {
                        mergedMap.put(k, data);
                    }
                }
            } else {
                mergedMap.put(k, v);
            }
        });

        newMap.forEach((k, v) -> {
            if (!orgMap.containsKey(k)) {
                mergedMap.put(k, v);
            }
        });
        return mergedMap;
    }

    public static <T extends Object> void sortByDesc(List<Map<String, T>> mapList, String compareFieldName){
    	Collections.sort(mapList, new Comparator<Map<String, T>>(){
    		 
		   @Override
			public int compare(Map<String, T> o1, Map<String, T> o2) {
			    String name1 =(String)o1.get(compareFieldName);
			    String name2= (String)o2.get(compareFieldName);
			    return name2.compareTo(name1);  
	   }});
    }
}
