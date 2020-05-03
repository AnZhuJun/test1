
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="查找结果"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="15"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">查找结果</h4>
    <div class="row" >
        <div class="container" >
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">编号</th>
                    <th scope="col">学年</th>
                    <th scope="col">学期</th>
                    <th scope="col">学号</th>
                    <th scope="col">班级编号</th>
                    <th scope="col">班级名</th>
                    <th scope="col">课程编号</th>
                    <th scope="col">课程名</th>
                    <th scope="col">教师编号</th>
                    <th scope="col">学生姓名</th>
                    <th scope="col">成绩</th>

                </tr>
                </thead>
                <tbody>

                <c:forEach items="${sss}" var="u" varStatus="vs">
                    <tr>
                        <th scope="row">${u.stuscoreid}</th>
                        <td>${u.year}</td>
                        <td>${u.term}</td>
                        <td>${u.studentid}</td>
                        <td>${u.classid}</td>
                        <td>${u.classname}</td>
                        <td>${u.courseid}</td>
                        <td>${u.coursename}</td>
                        <td>${u.teacherid}</td>
                        <td>${u.stuname}</td>
                        <td>${u.sscore}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="form-group">
            <div style="text-align: center">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </div>
        </div>
    </div>
</div>

<%@include file="teachermain/adminFooter.jsp" %>