
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="7"/>
<%@include file="teachermain/adminNavigator.jsp" %>

<head>
    <title>试卷管理</title>
</head>
<div class="container" >
    <ol class="breadcrumb">
        <li>试卷信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">试卷编号</th>
            <th scope="col">课程编号</th>
            <th scope="col">班级编号</th>
            <th scope="col">大题号</th>
            <th scope="col">小题号</th>
            <th scope="col">赋分</th>
            <th scope="col">用户名</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${papers.content}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.paperid}</th>
                <td>${u.courseid}</td>
                <td>${u.classid}</td>
                <td>${u.dt}</td>
                <td>${u.xt}</td>
                <td>${u.scores}</td>
                <td>${u.username}</td>
                <td><a href="/paper/delete/${u.paperid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/paper/edit?id=${u.paperid}"><span class="glyphicon glyphicon-edit"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center">
    <a href="?username=${name}&start=0">[首  页]</a>
    <a href="?username=${name}&start=${papers.number-1}">[上一页]</a>
    <a href="?username=${name}&start=${papers.number+1}">[下一页]</a>
    <a href="?username=${name}&start=${papers.totalPages-1}">[末  页]</a>
</div>

<%@include file="teachermain/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">查找</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form1" action="/paper/search" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="courseid" name="courseid"  placeholder="课程编号">
                        </div>
                        <div class="col-sm-10">

                                <input type="hidden" name="username" value="${name}">

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
                <form class="form-horizontal" method="post" id="up-form" action="/paper/paper" enctype="multipart/form-data">
                    <div class="form-group">

<%--                        <c:forEach items="${papers}" var="v" varStatus="vs">--%>
                            <div class="col-sm-10">
                                <input type="hidden" value="${name}" class="form-control" id="username" name="username">
                            </div>
<%--                        </c:forEach>--%>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="courseid" name="courseid" placeholder="请输入课程编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">班级编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="classid" name="classid" placeholder="请输入班级编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">大题号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="dt" name="dt" placeholder="请输入大题号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">小题号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="xt" name="xt" placeholder="请输入小题好">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">赋分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="scores" name="scores" placeholder="请输入赋分">
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




