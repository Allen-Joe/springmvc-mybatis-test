<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="fc" class="com.plateno.common.constants.FrontConstants" scope="page"/>
<jsp:include page="../common/top.jsp"/> 
<script type="text/javascript" src="<%=request.getContextPath()%>/publics/js/product.js"></script>
<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">新增  商品</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">首页</a> <span class="divider">/</span></li>
            <li><a href="users.html">商品管理</a> <span class="divider">/</span></li>
            <li class="active">新增</li>
        </ul>

   <div class="container-fluid">
      <div class="row-fluid">
                    
		<div class="btn-toolbar">
		    <button class="btn btn-primary" onclick="product.saveProduct();"><i class="icon-save"></i> 保存</button>
		  <div class="btn-group">
		  </div>
		</div>
		<div class="well">
			<div id="myTabContent" class="tab-content">
			  <div class="tab-pane active in" id="home">
			    <form id="productForm" action="<%=request.getContextPath()%>/product/add" method="post" name="productAddForm">
			        <label>商品名称</label>
			        <input type="text" name="pName" class="input-xlarge" style="height: 35px;">
			        <label>商品类别</label>
			        <select name="pType" class="input-xlarge">
				            <option value="">请选择</option>		  
					        <c:forEach items="${fc.producttypes}" var="productType">
					          <option value="${productType.key}">${productType.value}</option>
					        </c:forEach>
				    </select>
			        <label>单价</label>
			        <input type="text" name="pPrice" class="input-xlarge" style="height: 35px;">
			        <label>库存</label>
			        <input type="text" name="pStock" class="input-xlarge" style="height: 35px;">
			        <label>简介</label>
			        <textarea name="pBrief" rows="3" class="input-xlarge"></textarea>
			    </form>
			    </div>
			  </div>
		
		</div>    
        <footer>
            <hr>
            <p class="pull-right">Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>

            <p>&copy; 2012 <a href="#" target="_blank">Portnine</a></p>
        </footer>
                    
        </div>
     </div>
 </div>
<jsp:include page="../common/bottom.jsp"/>
    