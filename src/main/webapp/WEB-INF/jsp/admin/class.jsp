
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="班级信息"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="7"/>
<%@include file="common/adminNavigator.jsp" %>

<div class="container" >
    <ol class="breadcrumb">
        <li>班级信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">班级编号</th>
            <th scope="col">班级名</th>
            <th scope="col">系</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${classes.content}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.classid}</th>
                <td>${u.classname}</td>
                <td>${u.department}</td>
                <td><a href="/class/delete/${u.classid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/class/edit?id=${u.classid}"><span class="glyphicon glyphicon-edit"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center">
    <a href="?start=0">[首  页]</a>
    <a href="?start=${classes.number-1}">[上一页]</a>
    <a href="?start=${classes.number+1}">[下一页]</a>
    <a href="?start=${classes.totalPages-1}">[末  页]</a>
</div>

<%@include file="common/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">查找</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form1" action="/class/search" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">班级编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="classid" name="classid"  placeholder="请输入班级编号">
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
                <form class="form-horizontal" method="post" id="up-form" action="/class/class" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">班级名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name"  placeholder="请输入班级名">
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
