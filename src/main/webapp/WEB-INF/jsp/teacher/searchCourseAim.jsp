
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="查找结果"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="6"/>
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
                    <th scope="col">目标</th>
                    <th scope="col">支撑指标点</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${sca}" var="u" varStatus="vs">
                    <tr>
                        <th scope="row">${u.aimid}</th>
                        <td>${u.courseid}</td>
                        <td>${u.aim}</td>
                        <td>${u.zbpoint}</td>
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