package com.plateno.dao.sql;

import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * sql基础类
 * 创建人：MoChunrun <br>
 * 创建时间：2016年1月25日 上午10:14:30<br>
 * 描述：<br>
 * @version v1.0<br>
 */
public class BaseSqlProvider {

	/**
	 * 查询结果SQL
	 * 创建人：MoChunrun 
	 * 创建时间：2016年1月19日 上午9:13:41
	 * 描述：
	 * @version v1.0
	 * @param t
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String getResultSetSQL(Class clazz){
		return getResultSetSQL(clazz,null);
	}
	@SuppressWarnings("rawtypes")
	public static String getResultSetSQL(Class clazz,String filters){
		try{
			String sql = "";
			Field [] fields = clazz.getDeclaredFields();
			for(Field f:fields){
				String name = f.getName();
				if(filters==null || filters.indexOf(","+name+",")==-1){
					sql += name+",";
				}
			}
			if(sql.length()>2){
				sql = sql.substring(0,sql.length()-1);
			}
			return sql;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("查询出错了");
		}
	}
	
	/**
	 * 获取批量插入值
	 * 创建人：MoChunrun <br>
	 * 创建时间：2016年1月25日 上午11:19:10<br>
	 * 描述：<br>
	 * @version v1.0<br>
	 * @param clazz
	 * @param filters
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public SqlResult getBatchInsertValues(Class clazz,String paramName,String filters){
		SqlResult sql = new SqlResult();
		try{
			String insert = "";
			String values = "";
			Field [] fields = clazz.getDeclaredFields();
			for(Field f:fields){
				String name = f.getName();
				String className = f.getType().getSimpleName();
				if(filters==null || filters.indexOf(","+name+",")==-1){
					insert += name+",";
					if("Integer".equalsIgnoreCase(className) || "int".equalsIgnoreCase(className)){
						values += "#'{'"+paramName+"[{0}]."+name+",javaType=INTEGER,jdbcType=INTEGER},";
					}else if("double".equalsIgnoreCase(className)){
						values += "#'{'"+paramName+"[{0}]."+name+",javaType=DOUBLE,jdbcType=DOUBLE},";
					}else if("float".equalsIgnoreCase(className)){
						values += "#'{'"+paramName+"[{0}]."+name+",javaType=FLOAT,jdbcType=FLOAT},";
					}else if("string".equalsIgnoreCase(className)){
						values += "#'{'"+paramName+"[{0}]."+name+",javaType=string,jdbcType=VARCHAR},";
					}else if("date".equalsIgnoreCase(className)){
						values += "#'{'"+paramName+"[{0}]."+name+",javaType=java.util.Date,jdbcType=TIMESTAMP},";
					}else{
						values += "#'{'"+paramName+"[{0}]."+name+"},";
					}
				}
			}
			if(insert.length()>2){
				insert = insert.substring(0,insert.length()-1);
				values = values.substring(0,values.length()-1);
			}
			sql.setInsert(insert);
			sql.setValues(values);
			return sql;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("出错了");
		}
	}
	
	/**
	 * 获取批量更新
	 * 创建人：MoChunrun <br>
	 * 创建时间：2016年1月25日 下午2:49:26<br>
	 * 描述：<br>
	 * @version v1.0<br>
	 * @param clazz
	 * @param paramName
	 * @param filters
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String getBatchSets(Class clazz,String paramName,String filters){
		Field [] fields = clazz.getDeclaredFields();
		String sets = "";
		Map<String,Field> map = new HashMap<String,Field>();
		for(Field f:fields){
			String name = f.getName();
			map.put(name, f);
			String className = f.getType().getSimpleName();
			if(filters==null || filters.indexOf(","+name+",")==-1){
				if("Integer".equalsIgnoreCase(className) || "int".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=INTEGER,jdbcType=INTEGER},";
				}else if("double".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=DOUBLE,jdbcType=DOUBLE},";
				}else if("float".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=FLOAT,jdbcType=FLOAT},";
				}else if("string".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=string,jdbcType=VARCHAR},";
				}else if("date".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=java.util.Date,jdbcType=TIMESTAMP},";
				}else{
					sets += name+"=#'{'"+paramName+"[{0}]."+name+"},";
				}
			}
		}
		if(sets.length()>2){
			sets = sets.substring(0,sets.length()-1);
		}
		/*if(where!=null && where.length>0){
			sets += " where ";
			int length = where.length;
			for(int i=0;i<length;i++){
				String name = where[i];
				Field f = map.get(name);
				String className = f.getType().getSimpleName();
				if("Integer".equalsIgnoreCase(className) || "int".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=INTEGER,jdbcType=INTEGER},";
				}else if("double".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=DOUBLE,jdbcType=DOUBLE},";
				}else if("float".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=FLOAT,jdbcType=FLOAT},";
				}else if("string".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=string,jdbcType=VARCHAR},";
				}else if("date".equalsIgnoreCase(className)){
					sets += name+"=#'{'"+paramName+"[{0}]."+name+",javaType=java.util.Date,jdbcType=TIMESTAMP},";
				}else{
					sets += name+"=#'{'"+paramName+"[{0}]."+name+"},";
				}
				if(i<(length-1)){
					sets += " and ";
				}
			}
		}*/
		return sets;
	}
	
	/**
	 * 修改对象转为sql
	 * 创建人：MoChunrun <br>
	 * 创建时间：2016年1月25日 下午2:25:06<br>
	 * 描述：<br>
	 * @version v1.0<br>
	 * @param t
	 * @param beanName
	 */
	public static <T>void sets(T t,String beanName){
		try{
			Field [] fields = t.getClass().getDeclaredFields();
			for(Field f:fields){
				f.setAccessible(true);
				String name = f.getName();
				Object obj = f.get(t);
				if(obj!=null){
					if(obj instanceof Integer){
						SET(name+"=#{"+beanName+"."+name+",javaType=INTEGER,jdbcType=INTEGER}");
					}else if(obj instanceof Double){
						SET(name+"=#{"+beanName+"."+name+",javaType=DOUBLE,jdbcType=DOUBLE}");
					}else if(obj instanceof Float){
						SET(name+"=#{"+beanName+"."+name+",javaType=FLOAT,jdbcType=FLOAT}");
					}else if(obj instanceof String){
						SET(name+"=#{"+beanName+"."+name+",javaType=string,jdbcType=VARCHAR}");
					}else if(obj instanceof Date){
						SET(name+"=#{"+beanName+"."+name+",javaType=java.util.Date,jdbcType=TIMESTAMP}");
					}else{
						SET(name+"=#{"+beanName+"."+name+"}");
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("插入出错了");
		}
	}
	
	/**
	 * 清加values
	 * 创建人：MoChunrun 
	 * 创建时间：2016年1月15日 下午2:32:30
	 * 描述：
	 * @version v1.0
	 * @param t
	 * @param beanName
	 */
	public static <T>void addValue(T t,String beanName){
		try{
			Field [] fields = t.getClass().getDeclaredFields();
			for(Field f:fields){
				f.setAccessible(true);
				String name = f.getName();
				Object obj = f.get(t);
				if(obj!=null){
					if(obj instanceof Integer){
						VALUES(name,"#{"+beanName+"."+name+",javaType=INTEGER,jdbcType=INTEGER}");
					}else if(obj instanceof Double){
						VALUES(name,"#{"+beanName+"."+name+",javaType=DOUBLE,jdbcType=DOUBLE}");
					}else if(obj instanceof Float){
						VALUES(name,"#{"+beanName+"."+name+",javaType=FLOAT,jdbcType=FLOAT}");
					}else if(obj instanceof String){
						VALUES(name,"#{"+beanName+"."+name+",javaType=string,jdbcType=VARCHAR}");
					}else if(obj instanceof Date){
						VALUES(name,"#{"+beanName+"."+name+",javaType=java.util.Date,jdbcType=TIMESTAMP}");
					}else{
						VALUES(name,"#{"+beanName+"."+name+"}");
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("插入出错了");
		}
	}
	
	/**
	 * sql对象
	 * 创建人：MoChunrun <br>
	 * 创建时间：2016年1月25日 下午2:25:31<br>
	 * 描述：<br>
	 * @version v1.0<br>
	 */
	public static class SqlResult{
		private String insert;
		private String values;
		public String getInsert() {
			return insert;
		}
		public void setInsert(String insert) {
			this.insert = insert;
		}
		public String getValues() {
			return values;
		}
		public void setValues(String values) {
			this.values = values;
		}
	}
}
