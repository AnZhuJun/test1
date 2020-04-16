
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="期末题目平均分管理"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="1"/>
<%@include file="teachermain/adminNavigator.jsp" %>

<head>
    <title>期末题目平均分管理</title>
</head>
<div class="container" >
    <ol class="breadcrumb">
        <li>期末题目平均分信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">课程编码</th>
            <th scope="col">班级编号</th>
            <th scope="col">教师编号</th>
            <th scope="col">大题号</th>
            <th scope="col">小题号</th>
            <th scope="col">平均分</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${finscoreaves}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.courseid}</th>
                <td>${u.classid}</td>
                <td>${u.teacherid}</td>
                <td>${u.dt}</td>
                <td>${u.xt}</td>
                <td>${u.averange}</td>
                <td><a href="/finscoreave/delete/${u.fsavid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/finscoreave/edit?id=${u.fsavid}"><span class="glyphicon glyphicon-edit"></span></a></td>
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
                <form class="form-horizontal" method="post" id="up-form" action="/finscoreave/finscoreave" enctype="multipart/form-data">
                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="hidden" class="form-control" value="${fsavTeacherId.teacherid}" id="teacherid" name="teacherid">
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编码</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="courseid" name="courseid" placeholder="请输入课程编码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">班级编码</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="classid" name="classid" placeholder="请输入班级编码">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">大题编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="dt" name="dt" placeholder="请输入大题编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">小题编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="xt" name="xt" placeholder="请输入小题编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">平均分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="averange" name="averange" placeholder="请输入平均分">
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
