<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/jsp/common/head.jsp"%>
<div class="right">
    <img class="wColck" src="${pageContext.request.contextPath }/images/clock.jpg" alt=""/>
    <div class="wFont">
        <h3>你好：${userSession.username }</h3>
        <h2>欢迎来到学生管理系统!</h2>
    </div>
</div>
</section>
<%@include file="/jsp/common/foot.jsp" %>
