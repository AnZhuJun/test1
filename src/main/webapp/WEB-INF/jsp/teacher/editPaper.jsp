
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑试卷信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="7"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/paper/update" >
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编码</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="courseid" name="courseid"
                                   placeholder="请输入课程编码" value="${pap.courseid}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">班级编码</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${pap.classid}" id="classid" name="classid" placeholder="请输入班级编码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">大题号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${pap.dt}" id="dt" name="dt" placeholder="请输入大题号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">小题号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${pap.xt}" id="xt" name="xt" placeholder="请输入小题号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">赋分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${pap.scores}" id="scores" name="scores" placeholder="请输入赋分">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${pap.paperid}" id="paperid" name="paperid">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${pap.username}" id="username" name="username">
                        </div>
                    </div>

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

<%@include file="../admin/common/adminFooter.jsp" %>