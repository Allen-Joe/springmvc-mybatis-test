<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="fc" class="com.plateno.common.constants.FrontConstants" scope="page"/>
<jsp:include page="../common/top.jsp"/> 
<script type="text/javascript" src="<%=request.getContextPath()%>/publics/js/product.js"></script>
<%@taglib uri="http://javacrazyer.iteye.com/tags/pager" prefix="pageTag"%>
<%@taglib uri="http://javacrazyer.iteye.com/tags/formExport" prefix="formExport"%>
<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">商品管理</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="<%=request.getContextPath()%>/indexController/index">首页</a> <span class="divider">/</span></li>
            <li class="active">商品管理</li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
		<div class="btn-toolbar">
		    <button class="btn btn-primary" onclick="product.preAddProduct();"><i class="icon-plus"></i> 新增商品</button>
		    <button class="btn">导入</button>
		    <button class="btn" onclick="product.dataExport();" id="dataExport">导出</button>
		  <div class="btn-group">
		  </div>
		</div>
		<div class="search-well">
                <form class="form-inline" action="<%=request.getContextPath()%>/product/search" method="post" name="productForm" id="queryForm">
                     <input type="text" name="productName" value="${condition.productName}" placeholder="请输入商品名称..." class="input-xlarge" style="height: 30px;"/>&nbsp;&nbsp;                    
                     <select name="productType" class="input-xlarge">
					    <option value="">请选择</option>		  
				        <c:forEach items="${fc.producttypes}" var="productType">
				          <option value="${productType.key}" <c:if test="${condition.productType eq productType.key}">selected</c:if>>${productType.value}</option>
				        </c:forEach>
		            </select>&nbsp;&nbsp;
                    <button class="btn" type="button" onclick="product.querySubmit();"><i class="icon-search"></i> 搜一搜</button>
                </form>
        </div>
		<div class="well">
		    <table class="table">
		      <thead>
		        <tr>
		           <th>序号</th>
		           <th>商品名称</th>
			       <th>商品类别</th>
			       <th>简介</th>
			       <th>单价</th>
			       <th>库存</th>
		           <th style="width: 26px;">操作</th>
		        </tr>
		      </thead>
		      <tbody>
		         <c:forEach items="${pager.resultList}" var="product" varStatus="xh">
				     <tr>
				       <td>${xh.count}</td>
				       <td>${product.pName}</td>
				       <td>
				             ${fc.producttypes[product.pType]}
				       </td>
				       <td>${product.pBrief}</td>
				       <td>${product.pPrice}</td>
				       <td>${product.pStock}</td>
				       <td>
				         <a href="preUpdate?proId=${product.id}"><i class="icon-pencil"></i></a>
		                 <a href="javascript:void(0);" role="button" data-toggle="modal" onclick="product.deleteConfirm('delete?proId=${product.id}');"><i class="icon-remove"></i></a>
				       </td>
				     </tr>
				  </c:forEach>
		      </tbody>
		    </table>
		</div>
		<div class="pagination">
		    <pageTag:pager pageSize="${pager.pageSize}" pageNo="${pager.pageNo}" url="search" recordCount="${pager.rowCount}"/>
		</div>

		<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		        <h3 id="myModalLabel">温馨提示</h3>
		    </div>
		    <div class="modal-body">
		        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你确定要删除这条商品信息吗?</p>
		    </div>
		    <div class="modal-footer">
		        <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
		        <button class="btn btn-danger" id="sureDelete">删除</button>
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

