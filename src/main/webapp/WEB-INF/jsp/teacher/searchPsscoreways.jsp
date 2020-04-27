
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="查找结果"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="12"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">查找结果</h4>
    <div class="row" >
        <div class="container" >
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th scope="col">编号</th>
                    <th scope="col">课程编号</th>
                    <th scope="col">教师编号</th>
                    <th scope="col">优秀</th>
                    <th scope="col">良好</th>
                    <th scope="col">及格</th>
                    <th scope="col">不及格</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${spsw}" var="u" varStatus="vs">
                    <tr>
                        <th scope="row">${u.psswid}</th>
                        <td>${u.courseid}</td>
                        <td>${u.teacherid}</td>
                        <td><div class="css2" title="${u.best}">...</div></td>
                        <td><div class="css2" title="${u.good}">...</div></td>
                        <td><div class="css2" title="${u.soso}">...</div></td>
                        <td><div class="css2" title="${u.worse}">...</div></td>
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