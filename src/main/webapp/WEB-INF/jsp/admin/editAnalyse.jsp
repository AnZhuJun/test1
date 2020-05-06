
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="编辑目标信息"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="12"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container">
    <h4 class="page-header">编辑</h4>
    <div class="row" >
        <div class="panel panel-default" style="width: 600px;margin:0 auto">
            <div class="panel-heading">编辑</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="/analyse/aupdate" >

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程编码</label>
                        <div class="col-sm-10">
                            <input type="number" class="form-control" value="${aans.courseid}"  readonly id="courseid" name="courseid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.coursename}" readonly id="coursename" name="coursename">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">教师编号</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.teacherid}" readonly id="teacherid" name="teacherid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">教师名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.teachername}" readonly id="teachername" name="teachername">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">班级编号</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.classid}" readonly id="classid" name="classid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">班级名</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.classname}" readonly  id="classname" name="classname">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${aans.aimid}" id="aimid" name="aimid">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">支撑指标点</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.zbpoint}" readonly  id="zbpoint" name="zbpoint" >
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10">
                            <input type="hidden"  class="form-control" value="${aans.examwaysid}" id="examwaysid" name="examwaysid" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">课程达成度</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.achidegree}" readonly id="achidegree" name="achidegree" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">优秀人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.sumbest}" readonly id="sumbest" name="sumbest" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">良好人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.sumgood}" readonly id="sumgood" name="sumgood" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">及格人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.sumsoso}" readonly id="sumsoso" name="sumsoso" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">不及格人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.sumworse}" readonly id="sumworse" name="sumworse" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">选课人数</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.sumselect}" readonly id="sumselect" name="sumselect" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学分</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.point}" readonly id="point" name="point" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学年</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.year}" readonly id="year" name="year" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">学期</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.term}" readonly id="term" name="term" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">考核方式</label>
                        <div class="col-sm-10">
                            <input type="text"  class="form-control" value="${aans.examwaysinfo}" height="100" readonly id="examwaysinfo" name="examwaysinfo" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">存在问题及改进</label>
                        <div class="col-sm-10" title="${aans.problem}">
                            ${aans.problem}
                            <input type="hidden"  class="form-control" value="${aans.problem}"  height="100" id="problem" name="problem" >
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseid" class="col-sm-2 control-label">质评办评价</label>
                        <div class="col-sm-10" >
                            <input type="text"  style="height: auto" class="form-control" value="${aans.comment}" height="100"  id="comment" name="comment" >
                        </div>
                    </div>


                    <input type="hidden" name="analyseid" value="${aans.analyseid}">

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