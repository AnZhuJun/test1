
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑学生"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="1"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/student/update" >
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">学生姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name"
                                   placeholder="请输入学生" value="${da.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">班级</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${da.classs}" id="classs" name="classs" placeholder="请输入班级">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">系</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${da.department}" id="department" name="department" placeholder="请输入系">
                        </div>
                    </div>
                    <input type="hidden" name="studentid" value="${da.studentid}">
                    <div class="form-group">
                        <div style="text-align: center">
                            <button type="submit" name="${_csrf.parameterName}" value="${_csrf.token}" class="btn btn-success btn-sm">保存</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="common/adminFooter.jsp" %>