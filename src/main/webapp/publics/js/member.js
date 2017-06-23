var member = {
	
    /**
     * 商品预新增
     */
	preAddMember:function(){
		location.href=baseUrl+"/member/preAddMember";
	},
	
	/**
	 * 保存商品信息
	 */
    saveMember:function(){
    	$('#memberForm').submit();
    },
	
    /**
     * 删除确认
     * @param product_id
     */
	deleteConfirm:function(url){
		$('#myModal').modal('show');		
		$('#sureDelete').on('click', function () {
			location.href=baseUrl+"/member/"+url;
		});
	},
    
    /**
     * 提交查询
     */
    querySubmit:function(){
    	$('#queryForm').submit();
    }
}