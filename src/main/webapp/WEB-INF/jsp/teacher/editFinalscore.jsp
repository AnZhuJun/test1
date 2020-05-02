
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="10"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/finalscore/update" >

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编码</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="courseid" name="courseid"
                                   placeholder="请输入课程编码" value="${fs.courseid}">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${fs.teacherid}" id="teacherid" name="teacherid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学年</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.year}" id="year" name="year" placeholder="请输入学年">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学期</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.term}" id="term" name="term" placeholder="请输入学期">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">填表日期</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.time}" id="time" name="time" placeholder="请输入填表日期">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.studentid}" id="studentid" name="studentid" placeholder="请输入学号">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.classid}" id="classid" name="classid" placeholder="请输入课程编号">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学生姓名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.name}" id="name" name="name" placeholder="请输入学生姓名">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">第一大题得分</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.first}" id="first" name="first" placeholder="请输入第一大题得分">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">第二大题得分</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.second}" id="second" name="second" placeholder="请输入第二大题得分">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">第三大题得分</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.third}" id="third" name="third" placeholder="请输入第三大题得分">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">第四大题得分</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${fs.fourth}" id="fourth" name="fourth" placeholder="请输入第四大题得分">
                        </div>
                    </div>

                    <input type="hidden" name="finalscoreid" value="${fs.finalscoreid}">

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