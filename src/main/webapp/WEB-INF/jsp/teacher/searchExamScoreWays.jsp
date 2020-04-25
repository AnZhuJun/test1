
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="查找结果"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="9"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">查找结果</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">查找结果</div>
            <div class="panel-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">班级编号</label>
                        <div class="col-sm-10">
                            <h5>${sesw.scorewayid}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">班级名</label>
                        <div class="col-sm-10">
                            <h5>${sesw.courseid}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">优秀</label>
                        <div class="col-sm-10">
                            <h5>${sesw.best}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">良好</label>
                        <div class="col-sm-10">
                            <h5>${sesw.good}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">及格</label>
                        <div class="col-sm-10">
                            <h5>${sesw.soso}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">不及格</label>
                        <div class="col-sm-10">
                            <h5>${sesw.worse}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <div style="text-align: center">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </div>
                    </div>

            </div>
        </div>
    </div>
</div>

<%@include file="teachermain/adminFooter.jsp" %>