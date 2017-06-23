import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.plateno.common.constants.Constants;
import com.plateno.common.constants.FrontConstants;
import com.plateno.common.pager.Pager;
import com.plateno.dao.model.ProductInfo;
import com.plateno.pojo.ProductInfoQueryVo;
import com.plateno.service.ProductInfoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
public class ProductTest {
    
	@Autowired
	private ProductInfoService productInfoService;
	
	@Test
	public void testInsert(){
		ProductInfo p=new ProductInfo();
		p.setpName("魅族5");
		p.setpType(Constants.PRODUCT_TYPE_MOBILE);
		p.setpBrief("魅族公司出品的旗舰机....");
		p.setpPrice(2800.00);
		p.setpStock(30000);
		
//		ProductInfo p1=new ProductInfo();
//		p.setpName("华为P8");
//		p.setpType(Constants.PRODUCT_TYPE_MOBILE);
//		p.setpBrief("华为公司出品的顶级旗舰机....");
//		p.setpPrice(3800.00);
//		p.setpStock(100000);
		
		int cnt1=this.productInfoService.insertProductInfo(p);
		//int cnt2=this.productInfoService.insertProductInfo(p1);		
		
	}
	
	@Test
	public void testQueryById(){
		ProductInfo p=this.productInfoService.queryProductInfoById(2);
		
		System.out.println(p.getpName()+": "+p.getpBrief());
	}
	
	@Test
	public void testDelete(){
		int cnt=this.productInfoService.deleteProductInfo(3);
		System.out.println(cnt);
	}
	
	@Test
	public void testUpdate(){
		ProductInfo p=this.productInfoService.queryProductInfoById(2);
		
		p.setpName("小米科技周刊");
		p.setpType(Constants.PRODUCT_TYPE_BOOK);
		p.setpBrief("介绍小米公司的最新科技产品，智能家居，为发烧而生....");
		p.setpPrice(20.00);
		p.setpStock(100000);
		
		int cnt=this.productInfoService.updateProductInfo(p);
		System.out.println(cnt);
	}
	
	@Test
	public void testQueryByCondition(){
		ProductInfoQueryVo condition=new ProductInfoQueryVo();
		//condition.setProductName("小米");
		//condition.setProductType(Constants.PRODUCT_TYPE_BOOK);
		condition.setPageNo(1);
		condition.setPageSize(10);
		condition.setStartIndex(condition.getPageSize()*(condition.getPageNo()-1));
		Pager pager=this.productInfoService.queryProductPagerByCondition(condition);
		if(CollectionUtils.isNotEmpty(pager.getResultList())){
			List<ProductInfo> resultList=pager.getResultList();
			for (ProductInfo productInfo : resultList) {
				System.out.println("商品名称--》"+productInfo.getpName()+"  商品类型--》"+FrontConstants.productTypes.get(productInfo.getpType()));
			}
		}
	}
	
	
}
