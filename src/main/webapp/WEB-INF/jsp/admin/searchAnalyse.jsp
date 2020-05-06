
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="查找结果"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="12"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">查找结果</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">查找结果</div>
            <div class="panel-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">编号</label>
                        <div class="col-sm-10">
                            <h5>${asan.analyseid}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">班级名</label>
                        <div class="col-sm-10">
                            <h5>${asan.courseid}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <h5>${asan.teacherid}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <h5>${asan.classid}</h5>
                        </div>
                    </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">教师名</label>
                    <div class="col-sm-10">
                        <h5>${asan.teachername}</h5>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">班级名</label>
                    <div class="col-sm-10">
                        <h5>${asan.classname}</h5>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">课程名</label>
                    <div class="col-sm-10">
                        <h5>${asan.coursename}</h5>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">学年</label>
                    <div class="col-sm-10">
                        <h5>${asan.year}</h5>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">学期</label>
                    <div class="col-sm-10">
                        <h5>${asan.term}</h5>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">考核方式</label>
                    <div class="col-sm-10">
                        <h5>${asan.examwaysinfo}</h5>
                    </div>
                </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">支撑指标点</label>
                        <div class="col-sm-10">
                            <h5>${asan.zbpoint}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">达成度</label>
                        <div class="col-sm-10">
                            <h5>${asan.achidegree}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">优秀人数</label>
                        <div class="col-sm-10">
                            <h5>${asan.sumbest}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">良好人数</label>
                        <div class="col-sm-10">
                            <h5>${asan.sumgood}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">及格人数</label>
                        <div class="col-sm-10">
                            <h5>${asan.sumsoso}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">不及格人数</label>
                        <div class="col-sm-10">
                            <h5>${asan.sumworse}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">总人数</label>
                        <div class="col-sm-10">
                            <h5>${asan.sumselect}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">学期</label>
                        <div class="col-sm-10">
                            <h5>${asan.point}</h5>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label">存在问题及改进</label>
                        <div class="col-sm-10">
                            <h5>${asan.problem}</h5>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label">质评办评价</label>
                        <div class="col-sm-10">
                            <h5>${asan.comment}</h5>
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