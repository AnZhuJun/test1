
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="文件信息"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="11"/>
<%@include file="common/adminNavigator.jsp" %>
<div class="container" >
    <ol class="breadcrumb">
        <li>文件信息</li>
    </ol>
<table class="table table-hover table-striped">
    <thead>
    <tr>
        <th>文件编号</th>
        <th>文件名称</th>
        <th>下载</th>
        <th>删除</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${files}" var="u" varStatus="vs">
        <tr>
            <th scope="row">${u.outlineid}</th>
            <td>${u.name}</td>
            <td><a href="/upload/download?id=${u.outlineid}"><span class="glyphicon glyphicon-edit"></span></a></td>
            <td><a href="/upload/delete?id=${u.outlineid}"><span class="glyphicon glyphicon-trash"></span></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</div>



<div class="container">
    <div class="row" >
        <div class="panel panel-default" style="width: 650px;margin:auto">
            <div class="panel-heading">查找</div>
            <div class="panel-body" >
                <form action="/upload/upload" method="post" enctype="multipart/form-data">
                    <input align="center" type="file" name="file">
                        <input align="center" type="submit" value="上传文件">
                </form>

            </div>
        </div>
    </div>
</div>


<%@include file="common/adminFooter.jsp" %>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
