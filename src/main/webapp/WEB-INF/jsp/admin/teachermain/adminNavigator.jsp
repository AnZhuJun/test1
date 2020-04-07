
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="adminHeader.jsp" %>


<nav class="navbar navbar-default clearfix">
    <div class="top-bar">
        <span class="top-left">
            <c:if test="${!empty name}">
                <span style="margin-left: 0"><span class=" glyphicon glyphicon-home redColor" style="margin-left: 0"></span>欢迎</span>
                ${name } <a href ="javascript:document.forms['logout'].submit()">注销</a>
                <form id="logout" method="post" action="/logout">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        </form>
            </c:if>
            <c:if test="${empty name}">
                <a href="../../login" id="login">请登录</a>
            </c:if>
        </span>
    </div>

    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">工程认证管理系统教师系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
             <li class="${light==6?'active':''}"><a  href="/courseAim/all">课程目标管理</a></li>
            </ul>
        </div>

    </div>
</nav>
