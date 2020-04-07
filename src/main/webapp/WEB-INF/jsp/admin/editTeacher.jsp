
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑教师"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="10"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/teacher/update" >
                    <div class="form-group">
                        <label for="teachername" class="col-sm-2 control-label">教师姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="teachername" name="teachername"
                                   placeholder="请输入学生" value="${te.teachername}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teachername" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${te.username}" id="username" name="username" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teachername" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${te.password}" id="password" name="password" placeholder="请输入密码">
                        </div>
                    </div>
                    <input type="hidden" name="teacherid" value="${te.teacherid}">
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