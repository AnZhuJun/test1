
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="查找结果"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="10"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">查找结果</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">查找结果</div>
            <div class="panel-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <h5>${ste.teacherid}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">教师姓名</label>
                        <div class="col-sm-10">
                            <h5>${ste.teachername}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">用户名</label>
                        <div class="col-sm-10">
                            <h5>${ste.username}</h5>
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

<%@include file="common/adminFooter.jsp" %>