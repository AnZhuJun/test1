
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑目标信息"/>
<%@include file="teachermain/adminHeader.jsp" %>
<c:set var="light" value="16"/>
<%@include file="teachermain/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/analyse/update" >

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编码</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" value="${ans.courseid}"  readonly id="courseid" name="courseid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.coursename}" readonly id="coursename" name="coursename">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.teacherid}" readonly id="teacherid" name="teacherid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">教师名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.teachername}" readonly id="teachername" name="teachername">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">班级编号</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.classid}" readonly id="classid" name="classid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">班级名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.classname}" readonly  id="classname" name="classname">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${ans.aimid}" id="aimid" name="aimid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">支撑指标点</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.zbpoint}" readonly  id="zbpoint" name="zbpoint" >
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${ans.examwaysid}" id="examwaysid" name="examwaysid" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程达成度</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.achidegree}" readonly id="achidegree" name="achidegree" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">优秀人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.sumbest}" readonly id="sumbest" name="sumbest" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">良好人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.sumgood}" readonly id="sumgood" name="sumgood" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">及格人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.sumsoso}" readonly id="sumsoso" name="sumsoso" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">不及格人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.sumworse}" readonly id="sumworse" name="sumworse" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">选课人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.sumselect}" readonly id="sumselect" name="sumselect" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学分</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.point}" readonly id="point" name="point" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学年</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.year}" readonly id="year" name="year" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学期</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.term}" readonly id="term" name="term" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">考核方式</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.examwaysinfo}" height="100" readonly id="examwaysinfo" name="examwaysinfo" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">存在问题及改进</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${ans.problem}" height="100" id="problem" name="problem" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">质评办评价</label>
                        <div class="col-sm-10" title="${ans.comment}">
                            ${ans.comment}
                            <input type="hidden"  style="height: auto" class="form-control" value="${ans.comment}" height="100" readonly id="comment" name="comment" >
                        </div>
                    </div>


                    <input type="hidden" name="analyseid" value="${ans.analyseid}">

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