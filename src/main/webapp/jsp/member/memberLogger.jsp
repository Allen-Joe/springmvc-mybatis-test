<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../common/top.jsp"/> 
<script type="text/javascript" src="<%=request.getContextPath()%>/publics/js/member.js"></script>
<div class="content">
        
        <div class="header">
            
            <h1 class="page-title">编辑  会员</h1>
        </div>
        
                <ul class="breadcrumb">
            <li><a href="index.html">首页</a> <span class="divider">/</span></li>
            <li><a href="users.html">会员管理</a> <span class="divider">/</span></li>
            <li class="active">编辑</li>
        </ul>

   <div class="container-fluid">
      <div class="row-fluid">
                    
		<div class="btn-toolbar">
		    <button class="btn btn-primary" onclick="member.saveMember();"><i class="icon-save"></i> 保存</button>
		  <div class="btn-group">
		  </div>
		</div>
		<div class="well">
			<div id="myTabContent" class="tab-content">
			  <div class="tab-pane active in" id="home">
			  <c:forEach items="${loggers}" var="message">
				       <label>
			               ${message}
				       </label>
			    </c:forEach>
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
    