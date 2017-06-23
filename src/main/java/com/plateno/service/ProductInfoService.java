package com.plateno.service;

import com.plateno.common.pager.Pager;
import com.plateno.dao.model.ProductInfo;
import com.plateno.pojo.ProductInfoQueryVo;

public interface ProductInfoService {

	/**
	 * 插入商品信息
	 * @param productInfo
	 * @return
	 */
	public int insertProductInfo(ProductInfo productInfo);
	
	/**
	 * 删除商品信息
	 * @param id
	 * @return
	 */
	public int deleteProductInfo(Integer id);
	
	/**
	 * 根据id查询商品信息
	 * @param id
	 * @return
	 */
	public ProductInfo queryProductInfoById(Integer id);
	
	/**
	 * 修改商品信息
	 * @param productInfo
	 * @return
	 */
	public int updateProductInfo(ProductInfo productInfo);
	
	/**
	 * 分页条件查询
	 * @param condition
	 * @return
	 */
	public Pager queryProductPagerByCondition(ProductInfoQueryVo condition);
}
