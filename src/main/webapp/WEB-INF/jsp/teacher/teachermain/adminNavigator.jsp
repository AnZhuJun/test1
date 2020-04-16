
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
             <li class="${light==1?'active':''}"><a  href="/finscoreave/all?username=${name}">期末平均分管理</a></li>
             <li class="${light==2?'active':''}"><a  href="/midscoreave/all?username=${name}">期中平均分管理</a></li>
             <li class="${light==3?'active':''}"><a  href="/psscoreacc/all?username=${name}">平时成绩应得分管理</a></li>
             <li class="${light==4?'active':''}"><a  href="/psscoreave/all?username=${name}">平时成绩应得分管理</a></li>
             <li class="${light==5?'active':''}"><a  href="/psscore/all?username=${name}">平时成绩管理</a></li>
             <li class="${light==7?'active':''}"><a  href="/paper/all?username=${name}">试卷赋分管理</a></li>
             <li class="${light==8?'active':''}"><a  href="/examways/all?username=${name}">考核方式管理</a></li>
             <li class="${light==9?'active':''}"><a  href="/examscoreways/all?username=${name}">考核方式管理</a></li>
             <li class="${light==10?'active':''}"><a  href="/finalscore/all?username=${name}">期末成绩管理</a></li>
             <li class="${light==11?'active':''}"><a  href="/midscore/all?username=${name}">期中成绩管理</a></li>
             <li class="${light==12?'active':''}"><a  href="/psscoreways/all?username=${name}">平时成绩评定管理</a></li>
             <li class="${light==13?'active':''}"><a  href="/finscoreacc/all?username=${name}">期末题目应得分管理</a></li>
             <li class="${light==14?'active':''}"><a  href="/midscoreacc/all?username=${name}">期中题目应得分管理</a></li>
            </ul>
        </div>

    </div>
</nav>
