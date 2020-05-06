
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑教师课程表"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="9"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/teacherCourse/update" >
                    <div class="form-group">
                        <label for="teacherid" class="col-sm-2 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="teacherid" name="teacherid"
                                   placeholder="请输入教师编号" value="${tc.teacherid}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teacherid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${tc.courseid}" id="courseid" name="courseid"
                                   placeholder="请输入课程编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teacherid" class="col-sm-2 control-label">学分</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${tc.point}" id="point" name="point"
                                   placeholder="请输入学分">
                        </div>
                    </div>
                    <input type="hidden" name="tcid" value="${tc.tcid}">
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