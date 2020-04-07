
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="6"/>
<%@include file="teachermain/adminNavigator.jsp" %>



<div class="container" >
    <ol class="breadcrumb">
        <li>目标信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">目标编号</th>
            <th scope="col">教师编号</th>
            <th scope="col">课程编号</th>
            <th scope="col">目标</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${courseAims}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.aimid}</th>
                <td>${u.teacherid}</td>
                <td>${u.courseid}</td>
                <td>${u.aim}</td>
                <td><a href="/courseAim/delete/${u.aimid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/courseAim/edit?id=${u.aimid}"><span class="glyphicon glyphicon-edit"></span></a></td>
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
                <form class="form-horizontal" method="post" id="up-form" action="/courseAim/courseAim" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="teacherid" class="col-sm-2 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="teacherid" name="teacherid"  placeholder="请输入教师编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teacherid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="courseid" name="courseid" placeholder="请输入课程编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teacherid" class="col-sm-2 control-label">目标</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="aim" name="aim" placeholder="请输入目标">
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




