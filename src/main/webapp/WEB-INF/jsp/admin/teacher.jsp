
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="学生信息"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="10"/>
<%@include file="common/adminNavigator.jsp" %>



<div class="container" >
    <ol class="breadcrumb">
        <li>教师信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">教师编号</th>
            <th scope="col">教师姓名</th>
            <th scope="col">用户名</th>
            <th scope="col">密码</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${teachers.content}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.teacherid}</th>
                <td>${u.teachername}</td>
                <td>${u.username}</td>
                <td><div class="css2" title="${u.password}">...</div></td>
                <td><a href="/teacher/delete/${u.teacherid}"><span class="glyphicon glyphicon-trash"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center">
    <a href="?start=0">[首  页]</a>
    <a href="?start=${teachers.number-1}">[上一页]</a>
    <a href="?start=${teachers.number+1}">[下一页]</a>
    <a href="?start=${teachers.totalPages-1}">[末  页]</a>
</div>

<%@include file="common/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">查找</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form1" action="/teacher/search" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="teacherid" name="teacherid"  placeholder="请输入教师编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <div style="text-align: center">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button id="search" type="submit" name="${_csrf.parameterName}" value="${_csrf.token}" class="btn btn-success btn-sm">查找</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div>
    <h1> </h1>
</div>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">添加</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form" action="/teacher/teacher" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="teachername" class="col-sm-2 control-label">教师姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="teachername" name="teachername"  placeholder="请输入教师姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teachername" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="username" name="username" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teachername" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="password" name="password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div style="text-align: center">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button id="create" type="submit" name="${_csrf.parameterName}" value="${_csrf.token}" class="btn btn-success btn-sm">提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>




