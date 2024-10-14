<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<header>
	<nav class="navbar navbar-expand-lg navbar-light ">
		<div class="container-fluid">
			<a class="navbar-brand" href="${root}/Index"> <img
				src="${root}/assets/logo.png" alt="" width="34" height="24"
				class="d-inline-block align-text-top ms-3"> <span class="ms-1"
				style="font-weight: bolder; color: #5E5D65;">JapanAttraction</span>
			</a>

			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-5">
				<li class="nav-item"><a class="nav-link active"
					style="font-weight: bolder; color: #5E5D65;" aria-current="page"
					href="${root}/BackAllAttraction"><i
						class="fa-regular fa-pen-to-square" style="color: #5E5D65;"></i>Edit</a>
				</li>
				<li class="nav-item"><a class="nav-link ms-3"
					style="font-weight: bolder; color: #5E5D65;"
					href="${root}/ShowAllAttraction"><i class="fa-solid fa-display"
						style="color: #5E5D65;"></i>Pages</a></li>
			</ul>
			<!-- 			<button class="navbar-toggler" type="button" -->
			<!-- 				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" -->
			<!-- 				aria-controls="navbarSupportedContent" aria-expanded="false" -->
			<!-- 				aria-label="Toggle navigation"> -->
			<!-- 				<span class="navbar-toggler-icon"></span> -->
			<!-- 			</button> -->
			<!-- 			<div class="collapse navbar-collapse" id="navbarSupportedContent"> -->
			<!-- 				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-5"> -->
			<!-- 					<li class="nav-item"><a class="nav-link active" -->
			<%-- 						style="color: black" aria-current="page" href="${root}/Index">Home</a> --%>
			<!-- 					</li> -->
			<!-- 					<li class="nav-item"><a class="nav-link ms-3" -->
			<%-- 						style="color: black" href="${root}/ShowAllAttraction">Attractions</a> --%>
			<!-- 					</li> -->

			<!-- 				</ul> -->

			<!-- 			</div> -->


			<div class="dropdown text-end">

<%-- 				<c:if test="${loggedInUser==null }"> --%>
<%-- 					<a href="${root}/Login"> --%>
<!-- 						<button class="btn " -->
<!-- 							style="margin-right: 20px; font-weight: bolder; color: #4F4F48;"> -->
<!-- 							<i class="fa-regular fa-user" -->
<!-- 								style="color: #4F4F48; text-decoration: none; margin-right: 4px;"></i>使用者登入 -->
<!-- 						</button> -->
<!-- 					</a> -->
<%-- 				</c:if> --%>

				<c:if test="${loggedInUser!=null }">
					<div style="font-weight: bolder; margin-right: 50px; color: #A28C37; font-size: 19px;">
						
						<img style="width: 100px" src="${loggedInUser.userPhoto }"> ${loggedInUser.userName } 
						
<%-- 						<a href="${root}/Login">  --%>
<!-- 							<i class="fa-regular fa-user" style="color: #4F4F48; text-decoration: none; margin-right: 4px; margin-left: 10px; font-weight: bolder;"></i> -->
<!-- 						</a>  -->
						
						<a href="${root}/Login"> 
							<i class="fa-solid fa-arrow-right-from-bracket"	style="color:#616138; text-decoration: none; margin-right: 4px; margin-left: 10px; font-weight: bolder;  font-size: 19px;"></i>
						</a>
					</div>
				</c:if>

			</div>
	</nav>
</header>