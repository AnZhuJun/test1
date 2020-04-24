
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="12"/>
<%@include file="teachermain/adminNavigator.jsp" %>

<head>
    <title>平时成绩评级方式管理</title>
</head>
<div class="container" >
    <ol class="breadcrumb">
        <li>平时成绩评级方式信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">成绩评级编号</th>
            <th scope="col">教师编号</th>
            <th scope="col">课程编号</th>
            <th scope="col">优秀(>90)</th>
            <th scope="col">良好(75~89)</th>
            <th scope="col">及格(60~74)</th>
            <th scope="col">不及格(<60)</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${psscoreway}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.psswid}</th>
                <td>${u.teacherid}</td>
                <td>${u.courseid}</td>
                <td><div class="css2" title="${u.best}">...</div></td>
                <td><div class="css2" title="${u.good}">...</div></td>
                <td><div class="css2" title="${u.soso}">...</div></td>
                <td><div class="css2" title="${u.worse}">...</div></td>
                <td><a href="/psscoreways/delete/${u.psswid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/psscoreways/edit?id=${u.psswid}"><span class="glyphicon glyphicon-edit"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<%@include file="teachermain/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">添加</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form" action="/psscoreways/psscoreways" enctype="multipart/form-data">
                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="hidden" class="form-control" value="${pswTeacherId.teacherid}" id="teacherid" name="teacherid">
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="courseid" name="courseid" placeholder="请输入课程编号">
                        </div>
                    </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">优秀</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="best" name="best" placeholder="请输入优秀">
                        </div>
                    </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">良好</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="good" name="good" placeholder="请输入良好">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">及格</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="soso" name="soso" placeholder="请输入及格">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">不及格</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="worse" name="worse" placeholder="请输入不及格">
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
