package com.plateno.common.util;

import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * @描述：map和bean转换工具类
 * @创建人：Chenliqiao
 * @创建时间：2017年1月9日下午3:35:19
 * @version v1.5.1
 */
public class MapBeanUtil {

	/**
	 * 
	 * @描述:map转换为bean
	 * @param map
	 * @param beanClass
	 * @return
	 * @throws Exception
	 * @返回类型 Object
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月9日下午3:36:41
	 */
	public static Object mapToObject(Map<String,Object> map,Class<?> beanClass) throws Exception{
		if(map==null)
			return null;
		Object obj=beanClass.newInstance();
		BeanUtils.populate(obj, map);
		return obj;
	}
	
	/**
	 * 
	 * @描述:bean转换成map
	 * @param obj
	 * @return
	 * @返回类型 Map<?,?>
	 * @创建人 Chenliqiao
	 * @创建时间 2017年1月9日下午3:41:45
	 */
	public static Map<?,?> objectToMap(Object obj){
		if(obj==null)
			return null;
		return new BeanMap(obj);
	}
}
