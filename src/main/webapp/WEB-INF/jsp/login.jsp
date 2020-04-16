
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<link rel="stylesheet" href="/assets1/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/assets1/css/style.css">


<body>

<div class="header">
    <div class="container">
        <div class="row">
            <div class="logo span5">
                <h1><a href="">工程认证管理系统登陆</a></h1>
            </div>
            <div class="links span8">
                <a class="home" href="javascript:isLogin(1)"  rel="tooltip" data-placement="bottom" data-original-title="登陆"></a>
                <a class="blog" href="javascript:isLogin(0)"  rel="tooltip" data-placement="bottom" data-original-title="注册"></a>
            </div>
        </div>
    </div>
</div>

<div class="register-container container"  id="registDiv" style="display: none;">
    <div class="row">
        <div class="iphone span5">
        </div>
        <div class="register span6">
            <form method="post" class="" action="/registration">
                <h2> <span class="red"><strong>注册</strong></span></h2>
                <label for="teachername">教师名</label>
                <input type="text" id="teachername" name="teachername" placeholder="请输入教师名称...">
                <label for="userName">用户名</label>
                <input type="text" id="username" name="username" placeholder="请输入用户名称...">
                <label for="passWord">密码</label>
                <input type="passWord" id="password" name="password" placeholder="请输入登陆密码...">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">注册</button>
            </form>
        </div>
    </div>
</div>

<div class="register-container container" id="loginDiv" >
    <div class="row">
        <div class="iphone span3">
        </div>
        <div class="register span6">
            <form action="/login" method="post" class="">
                <h2>Login <span class="red"><strong>登陆</strong></span></h2>
                <label for="username">用户名</label>
                <input type="text" id="username" name="username" placeholder="请输入用户名称...">
                <label for="passWord">密码</label>
                <input type="password" id="password" name="password" placeholder="请输入登陆密码...">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <span>${error }</span>
                <button  type="submit" value="submit">登陆</button>
            </form>
        </div>
    </div>
</div>

<!-- Javascript -->
<script src="/assets1/js/jquery-1.8.2.min.js"></script>
<script src="/assets1/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets1/js/jquery.backstretch.min.js"></script>
<script src="/assets1/js/scripts.js"></script>
</body>


<script>

    function isLogin(is){
        if(is==1){
            $("#registDiv").css('display','none')
            $("#loginDiv").css('display','block')
        }else{
            $("#loginDiv").css('display','none')
            $("#registDiv").css('display','block')
        }
    }

    function login(){
        $.post("http://localhost:8080/login",$("#userLogin").serialize(),function(res){
            if(res!=null){
                alert("登陆失败！")
            }else{
                window.localStorage.setItem("user",res.token)
                window.location.href="index.html"
            }

        })

    }

</script>

    