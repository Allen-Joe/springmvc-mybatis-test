var product = {
	
    /**
     * 商品预新增
     */
	preAddProduct:function(){
		location.href=baseUrl+"/product/preAdd";
	},
	
	/**
	 * 保存商品信息
	 */
    saveProduct:function(){
    	$('#productForm').submit();
    },
	
    /**
     * 删除确认
     * @param product_id
     */
	deleteConfirm:function(url){
		$('#myModal').modal('show');		
		$('#sureDelete').on('click', function () {
			location.href=baseUrl+"/product/"+url;
		});
	},
    
    /**
     * 提交查询
     */
    querySubmit:function(){
    	$('#queryForm').submit();
    },
	
	/**
	 * 导出
	 */
	dataExport:function(){

	}
}