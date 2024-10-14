<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 響應式中繼標籤記 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>${webName }</title>

<jsp:include page="${component }/CommonImports.jsp"></jsp:include>

<style type="text/css">
.backgroundImg {
	background-image: url('${root}/assets/japan.jpg');
	background-repeat: no-repeat;
/* 	background-attachment: fixed; */
	background-position: center;
	background-size: cover;
	height:600px;
}


</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/Header.jsp"></jsp:include>
	
	
	
	<main>
		<div
			class="position-relative p-3 p-md-5 m-md-3 text-center backgroundImg">
			<div class="col-md-5 p-lg-5 mx-auto my-5 " >
				<h1 class="display-4 fw-normal  " style="margin-top:90px; color:#656765; font-size:60px;">Japan</h1>
				<h6 class="display-4 fw-normal  " style=" color:#656765;font-size:21px; ">Where to go</h6>
				<a class="btn btn-outline-secondary" style="margin-top:12px;" href="${root}/ShowAllAttraction" >SEARCH</a>
			</div>
		</div>
	</main>
	
<%-- 		<jsp:include page="/WEB-INF/view/component/Footer.jsp"></jsp:include> --%>
	
</body>
</html>