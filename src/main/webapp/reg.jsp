<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 学生信息管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <script type="text/javascript">
        /* if(top.location!=self.location){
              top.location=self.location;
         } */
    </script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>学生信息管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath }/reg"  name="actionForm" id="actionForm"  method="post" >
            <div class="info">${error }</div>
            <div class="inputbox">
                <label>你的学号：</label>
                    <input type="text" class="input-text" name="id">
            </div>
            <div class="inputbox">
                <label>你的姓名：</label>
                <input type="text" name="username">
            </div>
            <div class="inputbox">
                <label>你的密码：</label>
                <input type="password" name="password">
            </div>
            <div class="inputbox">
                <label>所属学院：</label>
                <input type="text" name="faculties">
            </div>
            <div class="inputbox">
                <label>所在宿舍：</label>
                <input type="text" name="dormitory">
            </div>
            <div class="inputbox">
                <label>联系电话：</label>
                <input type="text" name="telephone">
            </div>
            <div class="inputbox">
                <label>入学时间：</label>
                <input type="text" name="time">
            </div>
        <input type="submit" value="注册">
    </form>
    </section>
</section>
</body>
</html>