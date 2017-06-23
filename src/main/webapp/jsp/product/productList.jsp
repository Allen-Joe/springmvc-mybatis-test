<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="ct" %>
<%@taglib uri="http://javacrazyer.iteye.com/tags/pager" prefix="pageTag"%>
<jsp:useBean id="fc" class="com.plateno.common.constants.FrontConstants" scope="page"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品信息</title>
</head>
<body>
  <a href="preAdd">添加商品</a>
  <hr>
  <fieldset style="width: 30%;">
     <legend>条件查询</legend>
     <form action="<%=request.getContextPath()%>/product/search" method="post" name="productForm" >
	      <div>
	      <span>商品名称：</span>
		  <input type="text" name="productName" value="${condition.productName}" placeholder="请输入姓名" />
		  </div>
		  <br>
		  <div>
		  <span>商品类别：</span>
		  <select name="productType">
			    <option value="">请选择</option>		  
		        <c:forEach items="${fc.producttypes}" var="productType">
		          <option value="${productType.key}" <c:if test="${condition.productType eq productType.key}">selected</c:if>>${productType.value}</option>
		        </c:forEach>
		  </select>
		  </div>
		  <br>
		  <hr>
	  	  <div align="center">
	  	     <input type="submit" value="查询">
	  	  </div>
     </form>
  </fieldset>
  <hr>
  <style type="text/css">#tablelist tr td { border:solid 1px;text-align:center; padding: 5px; vertical-align:middle;border-color:#cccccc}
                         #tablelist {border:solid 1px;border-color:#cccccc;width: 98%;} #tablelist tr:hover{ background: #f1f1f1;} #tablelist tr:hover { background-color: #f1f1f1; }
  </style>
  <table id="tablelist">
     <thead>
       <tr style="background-color: #f1f1f1">
	       <th>商品名称</th>
	       <th>商品类别</th>
	       <th>简介</th>
	       <th>单价</th>
	       <th>库存</th>
	       <th>操作</th>
       </tr>
     </thead>
     <tbody>
        <c:forEach items="${pager.resultList}" var="product">
		     <tr>
		       <td>${product.pName}</td>
		       <td>
		             ${fc.producttypes[product.pType]}
		       </td>
		       <td>${product.pBrief}</td>
		       <td>${product.pPrice}</td>
		       <td>${product.pStock}</td>
		       <td>
		         <a href="delete?proId=${product.id}">删除</a>
		         <a href="preUpdate?proId=${product.id}">修改</a>
		       </td>
		     </tr>
		  </c:forEach>
     </tbody>
  </table>
   <hr>
  <div style="float: left;">
  <pageTag:pager pageSize="${pager.pageSize}" pageNo="${pager.pageNo}" url="search" recordCount="${pager.rowCount}"/>
  </div>
</body>
</html>