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
	        <form class="loginForm" action="${pageContext.request.contextPath }/login"  name="actionForm" id="actionForm"  method="post" >
				<div class="info">${error }${yes}</div>
				<div class="inputbox">
                    <label>学号：</label>
					<input type="text" class="input-text" id="userCode" name="id" placeholder="请输入学号" required/>
				</div>	
				<div class="inputbox">
                    <label>密码：</label>
                    <input type="password" id="userPassword" name="password" placeholder="请输入密码" required/>
                </div>	
				<div class="subBtn">
					
                    <input type="submit" value="登录"/>
                    <a href="reg.jsp"> <input type="button" value="注册"/></a>
                </div>	
			</form>
        </section>
    </section>
</body>
</html>
