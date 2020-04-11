
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="8"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/examways/update" >
                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编码</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="courseid" name="courseid"
                                   placeholder="请输入课程编码" value="${ews.courseid}">
                        </div>
                    </div>

                    <div class="form-group">

                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${ews.teacherid}" id="teacherid" name="teacherid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">平时成绩占比</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${ews.psper}" id="psper" name="psper" placeholder="请输入平时成绩占比">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">期中成绩占比</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${ews.midper}" id="midper" name="midper" placeholder="请输入期中成绩占比">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">期末成绩占比</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${ews.finper}" id="finper" name="finper" placeholder="请输入期末成绩占比">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">指标点</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ews.orderpoint}" id="orderpoint" name="orderpoint" placeholder="请输入指标点">
                        </div>
                    </div>

                    <input type="hidden" name="examwaysid" value="${ews.examwaysid}">

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