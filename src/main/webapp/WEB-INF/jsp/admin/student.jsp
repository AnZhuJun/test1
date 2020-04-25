
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="学生信息"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="6"/>
<%@include file="common/adminNavigator.jsp" %>



<div class="container" >
    <ol class="breadcrumb">
        <li>学生信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">学号</th>
            <th scope="col">学生姓名</th>
            <th scope="col">班级</th>
            <th scope="col">系</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${students.content}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.studentid}</th>
                <td>${u.name}</td>
                <td>${u.classs}</td>
                <td>${u.department}</td>
                <td><a href="/student/delete/${u.studentid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/student/edit?id=${u.studentid}"><span class="glyphicon glyphicon-edit"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center">
    <a href="?start=0">[首  页]</a>
    <a href="?start=${students.number-1}">[上一页]</a>
    <a href="?start=${students.number+1}">[下一页]</a>
    <a href="?start=${students.totalPages-1}">[末  页]</a>
</div>
<%@include file="common/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">查找</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form1" action="/student/search" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="studentid" name="studentid"  placeholder="请输入学号">
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
                <form class="form-horizontal" method="post" id="up-form" action="/student/student" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">学生姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name"  placeholder="请输入学生姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">班级</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="classs" name="classs" placeholder="请输入班级">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">系</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="department" name="department" placeholder="请输入系">
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




