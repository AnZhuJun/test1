
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="期末成绩信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="10"/>
<%@include file="teachermain/adminNavigator.jsp" %>

<head>
    <title>期末成绩管理</title>
</head>
<div class="container" >
    <ol class="breadcrumb">
        <li>期末成绩信息</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">编号</th>
            <th scope="col">学年</th>
            <th scope="col">学期</th>
            <th scope="col">登记时间</th>
            <th scope="col">学分</th>
            <th scope="col">学号</th>
            <th scope="col">班级编号</th>
            <th scope="col">课程编号</th>
            <th scope="col">教师编号</th>
            <th scope="col">学生姓名</th>
            <th scope="col">第一大题得分</th>
            <th scope="col">第二大题得分</th>
            <th scope="col">第三大题得分</th>
            <th scope="col">第四大题得分</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${finalscores.content}" var="u" varStatus="vs">
            <tr>
                <th scope="row">${u.finalscoreid}</th>
                <td>${u.year}</td>
                <td>${u.term}</td>
                <td>${u.time}</td>
                <td>${u.point}</td>
                <td>${u.studentid}</td>
                <td>${u.classid}</td>
                <td>${u.courseid}</td>
                <td>${u.teacherid}</td>
                <td>${u.name}</td>
                <td>${u.first}</td>
                <td>${u.second}</td>
                <td>${u.third}</td>
                <td>${u.fourth}</td>
                <td><a href="/finalscore/delete/${u.finalscoreid}"><span class="glyphicon glyphicon-trash"></span></a></td>
                <td><a href="/finalscore/edit?id=${u.finalscoreid}"><span class="glyphicon glyphicon-edit"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div style="text-align: center">
    <a href="?username=${name}&start=0">[首  页]</a>
    <a href="?username=${name}&start=${finalscores.number-1}">[上一页]</a>
    <a href="?username=${name}&start=${finalscores.number+1}">[下一页]</a>
    <a href="?username=${name}&start=${finalscores.totalPages-1}">[末  页]</a>
</div>


<%@include file="teachermain/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>


<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">查找</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="up-form1" action="/finalscore/search" enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学生姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name"  placeholder="请输入学生姓名">
                        </div>
                        <div class="col-sm-10">
                            <c:forEach items="${finalscores.content}" var="u" varStatus="vs">
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
                <form class="form-horizontal" method="post" id="up-form" action="/finalscore/finalscore" enctype="multipart/form-data">
                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="hidden" class="form-control" value="${fsTeacherId.teacherid}" id="teacherid" name="teacherid">
                        </div>

                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学年</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="year" name="year" placeholder="请输入学年">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学期</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="term" name="term" placeholder="请输入学期">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">填表日期</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="time" name="time" placeholder="请输入填表日期">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="point" name="point" placeholder="请输入学分">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="studentid" name="studentid" placeholder="请输入学号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">班级编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="classid" name="classid" placeholder="请输入班级编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="courseid" name="courseid" placeholder="请输入课程编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学生姓名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" id="name" name="name" placeholder="请输入学生姓名">
                        </div>
                    </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">第一大题得分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="first" name="first" placeholder="请输入第一大题得分">
                        </div>
                    </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">第二大题得分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="second" name="second" placeholder="请输入第二大题得分">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">第三大题得分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="third" name="third" placeholder="请输入第三大题得分">
                        </div>
                     </div>

                     <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">第四大题得分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" id="fourth" name="fourth" placeholder="请输入第四大题得分">
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
