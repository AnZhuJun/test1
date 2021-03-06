
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="教师的班级信息"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="9"/>
<%@include file="common/adminNavigator.jsp" %>

<div class="container" >
    <ol class="breadcrumb">
        <li>教师的班级信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">教师班级编号</th>
            <th scope="col">教师编号</th>
            <th scope="col">课程编码</th>
            <th scope="col">课程名</th>
            <th scope="col">学分</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${teacherCourses.content}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.tcid}</th>
                <td>${u.teacherid}</td>
                <td>${u.courseid}</td>
                <td>${u.coursename}</td>
                <td>${u.point}</td>
                <td><a href="/teacherCourse/delete/${u.tcid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/teacherCourse/edit?id=${u.tcid}"><span class="glyphicon glyphicon-edit"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center">
    <a href="?start=0">[首  页]</a>
    <a href="?start=${teacherCourses.number-1}">[上一页]</a>
    <a href="?start=${teacherCourses.number+1}">[下一页]</a>
    <a href="?start=${teacherCourses.totalPages-1}">[末  页]</a>
</div>

<%@include file="common/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>


<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">查找</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form1" action="/teacherCourse/search" enctype="multipart/form-data">
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
                <form class="form-horizontal" method="post" id="up-form" action="/teacherCourse/teacherCourse" enctype="multipart/form-data">
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
                        <label for="teacherid" class="col-sm-2 control-label">学分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="point" name="point" placeholder="请输入学分">
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
