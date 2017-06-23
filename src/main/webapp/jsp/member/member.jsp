<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/top.jsp"/> 
<script type="text/javascript" src="<%=request.getContextPath()%>/publics/js/member.js"></script>
<%@taglib uri="http://javacrazyer.iteye.com/tags/formExport" prefix="formExport"%>
<%@taglib uri="http://javacrazyer.iteye.com/tags/pager" prefix="pageTag"%>
<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">会员管理</h1>
        </div>
        
        <ul class="breadcrumb">
            <li><a href="<%=request.getContextPath()%>/indexController/index">首页</a> <span class="divider">/</span></li>
            <li class="active">会员管理</li>
            <li><a href="<%=request.getContextPath()%>/logger/showLogger">日志</a> <span class="divider"></span></li>
        </ul>

        <div class="container-fluid">
            <div class="row-fluid">
                    
		<div class="btn-toolbar">
		    <button class="btn btn-primary" onclick="member.preAddMember();"><i class="icon-plus"></i> 新增会员</button>
		    <button class="btn">导入</button>
		    <button class="btn">导出</button>
		  <div class="btn-group">
		  </div>
		</div>
		<div class="search-well">
              <form class="form-inline" action="<%=request.getContextPath()%>/member/search" method="post" name="memberForm" id="queryForm">
                   <input type="text" name="memberName" value="${condition.memberName}" placeholder="请输入会员姓名..." class="input-xlarge" style="height: 30px;"/>&nbsp;&nbsp;                    
                   <select name="memberSex" class="input-xlarge">
                        <option value="">请选择</option>
					    <option value="1" <c:if test="${condition.memberSex eq 1}">selected</c:if>>男</option>
				        <option value="2" <c:if test="${condition.memberSex eq 2}">selected</c:if>>女</option>
				   </select>
                  <button class="btn" type="button" onclick="member.querySubmit();"><i class="icon-search"></i> 搜一搜</button>
              </form>
        </div>
		<div class="well">
		    <table class="table">
		      <thead>
		        <tr>
		          <th>序号</th>
		          <th>姓名</th>
		          <th>性别</th>
		          <th>年龄</th>
		          <th style="width: 26px;">操作</th>
		        </tr>
		      </thead>
		      <tbody>
		        <c:forEach items="${pager.resultList}" var="member" varStatus="xh">
				     <tr>
				       <td>${xh.count}</td>
				       <td>${member.name}</td>
				       <td>
				            <c:if test="${member.sex eq 1}">男</c:if>
				            <c:if test="${member.sex eq 2}">女</c:if>
				       </td>
				       <td>${member.age}</td>
				       <td>		                 
		                 <a href="preUpdate?memberId=${member.id}"><i class="icon-pencil"></i></a>
		                 <a href="javascript:void(0);" role="button" data-toggle="modal" onclick="member.deleteConfirm('delete?memberId=${member.id}');"><i class="icon-remove"></i></a>
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
		        <p class="error-text"><i class="icon-warning-sign modal-icon"></i>你确定要删除这条会员信息吗?</p>
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

