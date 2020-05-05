
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="查找结果"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="16"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">查找结果</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">查找结果</div>
            <div class="panel-body">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">编号</label>
                        <div class="col-sm-10">
                            <h5>${san.analyseid}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">班级名</label>
                        <div class="col-sm-10">
                            <h5>${san.courseid}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <h5>${san.teacherid}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <h5>${san.classid}</h5>
                        </div>
                    </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">教师名</label>
                    <div class="col-sm-10">
                        <h5>${san.teachername}</h5>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">班级名</label>
                    <div class="col-sm-10">
                        <h5>${san.classname}</h5>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">课程名</label>
                    <div class="col-sm-10">
                        <h5>${san.coursename}</h5>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">学年</label>
                    <div class="col-sm-10">
                        <h5>${san.year}</h5>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-3 control-label">学期</label>
                    <div class="col-sm-10">
                        <h5>${san.term}</h5>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">考核方式</label>
                    <div class="col-sm-10">
                        <h5>${san.examwaysinfo}</h5>
                    </div>
                </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">支撑指标点</label>
                        <div class="col-sm-10">
                            <h5>${san.zbpoint}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">达成度</label>
                        <div class="col-sm-10">
                            <h5>${san.achidegree}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">优秀人数</label>
                        <div class="col-sm-10">
                            <h5>${san.sumbest}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">良好人数</label>
                        <div class="col-sm-10">
                            <h5>${san.sumgood}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">及格人数</label>
                        <div class="col-sm-10">
                            <h5>${san.sumsoso}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">不及格人数</label>
                        <div class="col-sm-10">
                            <h5>${san.sumworse}</h5>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">总人数</label>
                        <div class="col-sm-10">
                            <h5>${san.sumselect}</h5>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-3 control-label">学期</label>
                        <div class="col-sm-10">
                            <h5>${san.point}</h5>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label">存在问题及改进</label>
                        <div class="col-sm-10">
                            <h5>${san.problem}</h5>
                        </div>
                    </div>


                    <div class="form-group">
                        <label class="col-sm-3 control-label">质评办评价</label>
                        <div class="col-sm-10">
                            <h5>${san.comment}</h5>
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