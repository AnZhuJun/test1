
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="15"/>
<%@include file="teachermain/adminNavigator.jsp" %>

<head>
    <title>最终成绩管理</title>
</head>
<div class="container" >
    <ol class="breadcrumb">
        <li>考核方式信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">最终成绩编号</th>
            <th scope="col">学年</th>
            <th scope="col">学期</th>
            <th scope="col">教师编号</th>
            <th scope="col">课程编号</th>
            <th scope="col">班级编号</th>
            <th scope="col">学号</th>
            <th scope="col">学生姓名</th>
            <th scope="col">得分</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${stuscores.content}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.stuscoreid}</th>
                <td>${u.year}</td>
                <td>${u.term}</td>
                <td>${u.teacherid}</td>
                <td>${u.courseid}</td>
                <td>${u.classid}</td>
                <td>${u.studentid}</td>
                <td>${u.stuname}</td>
                <td>${u.sscore}</td>
                <td><a href="/stuscore/delete/${u.stuscoreid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/stuscore/edit?id=${u.stuscoreid}"><span class="glyphicon glyphicon-edit"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center">
    <a href="?username=${name}&start=0">[首  页]</a>
    <a href="?username=${name}&start=${stuscores.number-1}">[上一页]</a>
    <a href="?username=${name}&start=${stuscores.number+1}">[下一页]</a>
    <a href="?username=${name}&start=${stuscores.totalPages-1}">[末  页]</a>
</div>


<%@include file="teachermain/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>


<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">查找</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form1" action="/stuscore/search" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">考核方式</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="studentid" name="studentid"  placeholder="请输入学号">
                        </div>
                        <div class="col-sm-10">
                            <c:forEach items="${stuscores.content}" var="u" varStatus="vs">
                                <input type="hidden" name="teacherid" value="${u.teacherid}">
                            </c:forEach>
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
                <form class="form-horizontal" method="post" id="up-form" action="/stuscore/stuscore" enctype="multipart/form-data">
                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="hidden" class="form-control" value="${ssTeacherId.teacherid}" id="teacherid" name="teacherid">
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="courseid" name="courseid" placeholder="请输入课程编号">
                        </div>
                    </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="classid" name="classid" placeholder="请输入教师编号">
                        </div>
                    </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="studentid" name="studentid" placeholder="请输入学号">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学年</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="year" name="year" placeholder="请输入学年">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学期</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="term" name="term" placeholder="请输入学期">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">成绩</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="sscore" name="sscore" placeholder="请输入学期">
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
