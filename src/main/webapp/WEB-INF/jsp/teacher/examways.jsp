
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="8"/>
<%@include file="teachermain/adminNavigator.jsp" %>

<head>
    <title>考核方式管理</title>
</head>
<div class="container" >
    <ol class="breadcrumb">
        <li>考核方式信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">考核方式编号</th>
            <th scope="col">教师编号</th>
            <th scope="col">课程编号</th>
            <th scope="col">平时成绩占比</th>
            <th scope="col">期中成绩占比</th>
            <th scope="col">期末成绩占比</th>
            <th scope="col">指标点</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${examway}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.examwaysid}</th>
                <td>${u.teacherid}</td>
                <td>${u.courseid}</td>
                <td>${u.psper}</td>
                <td>${u.midper}</td>
                <td>${u.finper}</td>
                <td>${u.orderpoint}</td>
                <td><a href="/examways/delete/${u.examwaysid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/examways/edit?id=${u.examwaysid}"><span class="glyphicon glyphicon-edit"></span></a></td>
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
                <form class="form-horizontal" method="post" id="up-form" action="/examways/examways" enctype="multipart/form-data">
                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="hidden" class="form-control" value="${ewsTeacherId.teacherid}" id="teacherid" name="teacherid">
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="courseid" name="courseid" placeholder="请输入课程编号">
                        </div>
                    </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">平时占比</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="psper" name="psper" placeholder="请输入平时占比">
                        </div>
                    </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">期中占比</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="midper" name="midper" placeholder="请输入期中占比">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">期末占比</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="finper" name="finper" placeholder="请输入期末占比">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">指标点</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="orderpoint" name="orderpoint" placeholder="请输入指标点">
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
