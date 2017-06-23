<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="ct" %>
<%@taglib uri="http://javacrazyer.iteye.com/tags/pager" prefix="pageTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会员信息</title>
</head>
<body>
  <a href="preAddMember">添加会员<ct:Hello/></a>
  <hr>
  <fieldset style="width: 30%;">
     <legend>条件查询</legend>
     <form action="<%=request.getContextPath()%>/member/queryByCondion" method="post" name="memberQueryForm" >
	      <div>
	      <span>姓名：</span>
		  <input type="text" name="memberName" value="${memberName}" placeholder="请输入姓名" />
		  </div>
		  <br>
		  <div>
		  <span>性别：</span>
		  <select name="memberSex">
		    <option value="1" <c:if test="${memberSex eq 1}">selected</c:if>>男</option>
	        <option value="2" <c:if test="${memberSex eq 2}">selected</c:if>>女</option>
		  </select>
		  </div>
		  <br>
		  <hr>
	  	  <div align="center">
	  	     <input type="submit" value="查询所有">
	  	     &nbsp;&nbsp;&nbsp;
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
	       <th>姓名</th>
	       <th>性别</th>
	       <th>年龄</th>
	       <th>操作</th>
       </tr>
     </thead>
     <tbody>
         <c:forEach items="${memberList}" var="member">
		     <tr>
		       <td>${member.name}</td>
		       <td>
		            <c:if test="${member.sex eq 1}">男</c:if>
		            <c:if test="${member.sex eq 2}">女</c:if>
		       </td>
		       <td>${member.age}</td>
		       <td>
		         <a href="delete?memberId=${member.id}">删除</a>
		         <a href="preUpdate?memberId=${member.id}">修改</a>
		       </td>
		     </tr>
		  </c:forEach>
     </tbody>
  </table>
   <hr>
  <div style="float: left;">
  <pageTag:pager pageSize="10" pageNo="1" url="queryMemberList" recordCount="100"/>
  </div>
</body>
</html>