package com.plateno.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.plateno.dao.model.ProductInfo;
import com.plateno.dao.sql.ProductInfoSqlProvider;
import com.plateno.pojo.ProductInfoQueryVo;

public interface ProductInfoMapper {

	/**
	 * 插入商品信息
	 * @param productInfo
	 * @return
	 */
	@InsertProvider(type=ProductInfoSqlProvider.class,method="getInsertProductInfoSql")
	public int insertProductInfo(@Param("productInfo")ProductInfo productInfo);
	
	/**
	 * 删除商品信息
	 * @param id
	 * @return
	 */
	@DeleteProvider(type=ProductInfoSqlProvider.class,method="getDeleteProductInfoSql")
	public int deleteProductInfo(@Param("id")Integer id);
	
	/**
	 * 根据id查询商品信息
	 * @param id
	 * @return
	 */
	@SelectProvider(type=ProductInfoSqlProvider.class,method="getProductInfoByIdSql")
	public ProductInfo queryProductInfoById(@Param("id")Integer id);
	
	/**
	 * 修改商品信息
	 * @param productInfo
	 * @return
	 */
	@UpdateProvider(type=ProductInfoSqlProvider.class,method="getUpdateProductInfoSql")
	public int updateProductInfo(@Param("productInfo")ProductInfo productInfo);
	
	/**
	 * 分页条件查询
	 * @param queryVo
	 * @return
	 */
	@SelectProvider(type=ProductInfoSqlProvider.class,method="getProductInfosByCondition")
	public List<ProductInfo> queryProductInfoByCondition(@Param("queryVo")ProductInfoQueryVo queryVo);
	
	/**
	 * 获取条件查询的总记录数（不用分页）
	 * @param queryVo
	 * @return
	 */
	@SelectProvider(type=ProductInfoSqlProvider.class,method="getCountByCondition")
	public int queryCountByCondition(@Param("queryVo")ProductInfoQueryVo queryVo);
	
}
