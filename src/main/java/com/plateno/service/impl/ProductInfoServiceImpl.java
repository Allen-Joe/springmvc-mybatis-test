package com.plateno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateno.common.pager.Pager;
import com.plateno.dao.mapper.ProductInfoMapper;
import com.plateno.dao.model.ProductInfo;
import com.plateno.pojo.ProductInfoQueryVo;
import com.plateno.service.ProductInfoService;

@Service("productService")
public class ProductInfoServiceImpl implements ProductInfoService{
	
	@Autowired
	private ProductInfoMapper productInfoMapper;

	public int insertProductInfo(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		return this.productInfoMapper.insertProductInfo(productInfo);
	}

	public int deleteProductInfo(Integer id) {
		// TODO Auto-generated method stub
		return this.productInfoMapper.deleteProductInfo(id);
	}

	public ProductInfo queryProductInfoById(Integer id) {
		// TODO Auto-generated method stub
		return this.productInfoMapper.queryProductInfoById(id);
	}

	public int updateProductInfo(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		return this.productInfoMapper.updateProductInfo(productInfo);
	}

	public Pager queryProductPagerByCondition(ProductInfoQueryVo condition) {
		// TODO Auto-generated method stub
		//分页条件查询结果集
		List<ProductInfo> resultList=this.productInfoMapper.queryProductInfoByCondition(condition);
		//分页条件查询总记录数
		int rowCount=this.productInfoMapper.queryCountByCondition(condition);		
		return new Pager(condition.getPageNo(),condition.getPageSize(),rowCount,resultList);
	}

}
