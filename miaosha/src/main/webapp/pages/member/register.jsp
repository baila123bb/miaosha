<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="/pages/commons/common.jsp"%>


<html>
<body>
<div>
	<span>${xxx}</span><br>
	<span>${time}</span>
</div>
这个是从后台传过来的数据 ： 


写注册页面


这一段是测试更新

<div>
	<form action="/member/register">
		<span width="100">name:	</span>	<input height="150px" width="200px" name="username" type="text"><br>
		<span width="100">psw:	</span>	<input height="150px" width="200px" name="password" type="text"><br>
		<span width="100">repsw:</span>	<input height="150px" width="200px" name="repassword" type="text"><br>
	
		<input type="submit" name="submit" value="注册">	
	</form>

</div>


</body>
</html>
