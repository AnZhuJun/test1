
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑班级"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="7"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/class/update" >
                    <div class="form-group">
                        <label for="classname" class="col-sm-2 control-label">班级名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="classname" name="classname"
                                   placeholder="请输入班级名" value="${cl.classname}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="classname" class="col-sm-2 control-label">系</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${cl.department}" id="department" name="department"
                                   placeholder="请输入系">
                        </div>
                    </div>
                    <input type="hidden" name="classid" value="${cl.classid}">
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