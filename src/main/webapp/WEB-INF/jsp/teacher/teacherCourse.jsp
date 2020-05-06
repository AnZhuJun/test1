
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="我的课程"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="18"/>
<%@include file="teachermain/adminNavigator.jsp" %>

<div class="container" >
    <ol class="breadcrumb">
        <li>我的课程</li>
    </ol>
    <table class="table table-hover table-striped">
        <thead>
        <tr>
            <th scope="col">课程编码</th>
            <th scope="col">课程名</th>
            <th scope="col">学分</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${teacherCourses.content}" var="u" varStatus="vs">
            <tr>
                <td>${u.courseid}</td>
                <td>${u.coursename}</td>
                <td>${u.point}</td>
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

<%@include file="teachermain/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
