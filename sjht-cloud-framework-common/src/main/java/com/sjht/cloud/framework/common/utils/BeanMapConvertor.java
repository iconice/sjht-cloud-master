package com.sjht.cloud.framework.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 ********************************************** 
 * @ClassName: BeanMapConvertor  
 * @Description:对象和map之间的转换
 * @Author maojianyun
 * @Date 2019年9月1日
 * @Copyright: 2019 重庆数聚汇通信息技术有限公司
 **********************************************
 */
public class BeanMapConvertor {
	
	/**
	 *********************************************************   
	 * @Title: mapToObject   
	 * @Description: map转换成对象 
	 * @Param:  map map
	 * @Param:  beanClass 转换成的对象
	 * @Throws Exception      
	 * @Return: Object      
	 * @Author xiongzhongjiang
	 **********************************************************
	 */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }

            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }

        return obj;
    }

    /**
     *********************************************************   
     * @Title: objectToMap   
     * @Description: 对象转换成map(注意如果有继承父类则父类的字段转换不了)  
     * @Param:  obj
     * @Throws Exception      
     * @Return: Map<String,Object>      
     * @Author xiongzhongjiang
     **********************************************************
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }
    /**
     *********************************************************   
     * @Title: objectToMap   
     * @Description: 对象转换成map(注意如果有继承父类则父类的字段转换不了)  
     * @Param:  obj
     * @Throws Exception      
     * @Return:  Map<String, String>    
     * @Author xiongzhongjiang
     **********************************************************
     */
    public static Map<String, String> objectToMapS(Object obj) throws Exception {
        if(obj == null){
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj).toString());
        }
        return map;
    }
    /**
     *********************************************************   
     * @Title: objectSuperToMap   
     * @Description: 有继承的类需要把父类的字段都转换到map中
     * @Param: obj
     * @Param: @throws Exception      
     * @Return: Map<String,Object>      
     * @Author maojianyun
     **********************************************************
     */
    public static Map<String, Object> objectSuperToMap(Object obj) throws Exception {
    	if(obj == null){
    		return null;
    	}
    	Map<String, Object> map = new HashMap<String, Object>();
    	// 得到父类字段
    	Field[] SuperFields = obj.getClass().getSuperclass().getDeclaredFields();
    	// 本类字段
    	Field[] declaredFields = obj.getClass().getDeclaredFields();
    	for (Field field : declaredFields) {
    		field.setAccessible(true);
    		map.put(field.getName(), field.get(obj));
    	}
    	// 如果父类的字段不为空就加入map
    	if (SuperFields.length > 0) {
    		for (Field field : SuperFields) {
    			field.setAccessible(true);
    			map.put(field.getName(), field.get(obj));
    		}
    	}
    	return map;
    }
}
