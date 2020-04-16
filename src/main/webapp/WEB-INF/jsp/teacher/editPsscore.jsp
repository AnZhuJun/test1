
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="5"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/psscore/update" >

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编码</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" id="courseid" name="courseid"
                                   placeholder="请输入课程编码" value="${ps.courseid}">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${ps.teacherid}" id="teacherid" name="teacherid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学年</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ps.year}" id="year" name="year" placeholder="请输入学年">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学期</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ps.term}" id="term" name="term" placeholder="请输入学期">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">填表日期</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ps.time}" id="time" name="time" placeholder="请输入填表日期">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${ps.studentid}" id="studentid" name="studentid" placeholder="请输入学号">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编号</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${ps.classid}" id="classid" name="classid" placeholder="请输入课程编号">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学生姓名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ps.name}" id="name" name="name" placeholder="请输入学生姓名">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">平时成绩得分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${ps.kaoqin}" id="kaoqin" name="kaoqin" placeholder="请输入平时成绩得分">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">作业成绩得分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${ps.zuoye}" id="zuoye" name="zuoye" placeholder="请输入作业成绩得分">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">考勤成绩得分</label>
                        <div class="col-sm-10">
                            <input type="number"  class="form-control" value="${ps.shiyan}" id="shiyan" name="shiyan" placeholder="请输入考勤成绩得分">
                        </div>
                    </div>

                    <input type="hidden" name="psscoreid" value="${ps.psscoreid}">

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