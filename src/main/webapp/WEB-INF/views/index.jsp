<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#ajax").click(function(){
		$.ajax({
			url : "${pageContext.request.contextPath}/test2",
			type : "post",
			dataType : "json",
			success : function(result) {
				console.log(result)
				$.each(result,function(index,item){
					$("#div").append(item)
				})
			},
			error : function(err) {
				alert("err : " + err);
			}
		})

});
		
	})
	



</script>
</head>
<body>
	<h1>Spring Boot 시작하기....</h1>
	<a href="${pageContext.request.contextPath}/test">이동하기</a>
	<hr>
	<h3> Ajax Test</h3>
	  <a href="#" id="ajax">test2 요청</a>
	  <div id="div"></div>
</body>
</html>