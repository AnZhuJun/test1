
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="12"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/psscoreways/update" >
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编码</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="courseid" name="courseid"
                                   placeholder="请输入课程编码" value="${psw.courseid}">
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${psw.teacherid}" id="teacherid" name="teacherid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">优秀</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${psw.best}" id="best" name="best" placeholder="请输入优秀">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">良好</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${psw.good}" id="good" name="good" placeholder="请输入良好">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">及格</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${psw.soso}" id="soso" name="soso" placeholder="请输入及格">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">不及格</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${psw.worse}" id="worse" name="worse" placeholder="请输入不及格">
                        </div>
                    </div>

                    <input type="hidden" name="psswid" value="${psw.psswid}">

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