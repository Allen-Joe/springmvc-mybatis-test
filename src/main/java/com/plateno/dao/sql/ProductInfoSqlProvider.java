package com.plateno.dao.sql;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.plateno.dao.model.ProductInfo;
import com.plateno.pojo.ProductInfoQueryVo;

import static org.apache.ibatis.jdbc.SqlBuilder.AND;
import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.OR;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;


public class ProductInfoSqlProvider extends BaseSqlProvider{

	/**
	 * 生成插入商品信息的Sql
	 * @param params
	 * @return
	 */
	public String getInsertProductInfoSql(Map<String, Object> params){
		BEGIN();
		INSERT_INTO("product_info");
		addValue(params.get("productInfo"), "productInfo");
		return SQL();
	}
	
	/**
	 * 生成删除商品信息的Sql
	 * @return
	 */
	public String getDeleteProductInfoSql(){
		BEGIN();
		DELETE_FROM("product_info");
		WHERE("id=#{id,jdbcType=INTEGER}");
		return SQL();
	}
	
	/**
	 * 生成根据id查询商品信息的Sql
	 * @return
	 */
	public String getProductInfoByIdSql(){
		BEGIN();
		SELECT(getResultSetSQL(ProductInfo.class));
		FROM("product_info");
		WHERE("id=#{id,jdbcType=INTEGER}");
		return SQL();
	}
	
	/**
	 * 生成修改商品信息的Sql
	 * @return
	 */
	public String getUpdateProductInfoSql(Map<String, Object> params){
		BEGIN();
		UPDATE("product_info");
		sets(params.get("productInfo"), "productInfo");
		WHERE("id=#{productInfo.id,jdbcType=INTEGER}");
		return SQL();
	}
	
	/**
	 * 生成分页条件查询的Sql
	 * @param params
	 * @return
	 */
	public String getProductInfosByCondition(Map<String,Object> params){
		ProductInfoQueryVo queryVo=(ProductInfoQueryVo) params.get("queryVo");
		BEGIN();
		SELECT(getResultSetSQL(ProductInfo.class));
		FROM("product_info");
		WHERE("1=1");
		if(StringUtils.isNotBlank(queryVo.getProductName())){
			AND();
			WHERE("pName like \"%\"#{queryVo.productName}\"%\" ");
		}
		if(StringUtils.isNotBlank(queryVo.getProductType())){
			AND();
			WHERE("pType=#{queryVo.productType}");
		}
		ORDER_BY(" id asc limit #{queryVo.startIndex},#{queryVo.pageSize}");
		return SQL();
	}
	
	/**
	 * 生成获取条件查询总记录数的Sql
	 * @param params
	 * @return
	 */
	public String getCountByCondition(Map<String,Object> params){
		ProductInfoQueryVo queryVo=(ProductInfoQueryVo) params.get("queryVo");
		BEGIN();
		SELECT("count(1)");
		FROM("product_info");
		WHERE("1=1");
		if(StringUtils.isNotBlank(queryVo.getProductName())){
			AND();
			WHERE("pName like \"%\"#{queryVo.productName}\"%\" ");
		}
		if(StringUtils.isNotBlank(queryVo.getProductType())){
			AND();
			WHERE("pType=#{queryVo.productType}");
		}
		return SQL();
	}
	
}
