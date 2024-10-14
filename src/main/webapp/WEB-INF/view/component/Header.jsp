<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<header">
	<nav class="navbar navbar-expand-lg navbar-light bg-light"
		style="height: 65px;">
		<div class="container-fluid">
			<a class="navbar-brand" href="Index"> <img
				src="${root}/assets/logo.png" alt="" width="34" height="24"
				class="d-inline-block align-text-top ms-3"> <span class="ms-1"
				style="font-weight: bolder; color: #4F4F48;">JapanAttraction</span>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-5">
					<li class="nav-item"><a class="nav-link active"
						style="font-weight: bolder; color: #4F4F48;" aria-current="page"
						href="${root}/Index">Home</a></li>
					<!-- 					<li class="nav-item"><a class="nav-link ms-3" -->
					<!-- 						style="font-weight: bolder; color: #4F4F48;" -->
					<%-- 						href="${root}/ShowAllAttraction"> Attractions</a></li> --%>

					<div class="dropdown" style="margin-left: 15px; margin-top: 2px;">
						<a class="btn dropdown-toggle" href="#"
							style="font-weight: bolder; color: #4F4F48;" role="button"
							id="dropdownMenuLink" data-bs-toggle="dropdown"
							aria-expanded="false"> Attractions </a>

						<ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<li><a class="dropdown-item"
								href="${root}/ShowAllAttraction">All Attractions</a></li>
							<li><a class=" city dropdown-item" data-id="Tokyo">Tokyo</a></li>
							<li><a class=" city dropdown-item" data-id="Osaka">Osaka</a></li>
						</ul>
					</div>
				</ul>
				<div class="dropdown text-end">

					<c:if test="${loggedInUser==null }">
						<a href="${root}/Login">
							<button class="btn "
								style="margin-right: 20px; font-weight: bolder; color: #4F4F48;">
								<i class="fa-regular fa-user"
									style="color: #4F4F48; text-decoration: none; margin-right: 4px;"></i>使用者登入
							</button>
						</a>
					</c:if>

					<c:if test="${loggedInUser!=null }">
						<div
							style="font-weight: bolder; margin-right: 50px; color:#A28C37; font-size: 19px;">
							<img style="width: 100px" src="${loggedInUser.userPhoto }">
							${loggedInUser.userName } 


							<%-- 							<a href="${root}/Login">  --%>
							<!-- 							<i class="fa-regular fa-user" -->
							<!-- 								style="color: #4F4F48; text-decoration: none; margin-right: 4px; margin-left: 10px; font-weight: bolder;"></i> -->
							<!-- 							</a>  -->
							<a href="${root}/Logout"> <i
								class="fa-solid fa-arrow-right-from-bracket"
								style="color:#616138; text-decoration: none; margin-right: 4px; margin-left: 10px; font-weight: bolder; font-size: 19px;"></i>
							</a>
						</div>
					</c:if>

				</div>
				<!--       <form class="d-flex"> -->
				<!--         <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"> -->
				<!--         <button class="btn btn-outline-success" type="submit">Search</button> -->
				<!--       </form> -->
			</div>
		</div>
	</nav>
	<script type="text/javascript">	
	

    document.addEventListener("DOMContentLoaded", function() {
        const options = document.querySelectorAll(".city");

        options.forEach(city => {
            city.addEventListener("click", () => {
                const location = city.dataset["id"];
                window.location.href = "/JapanAttraction/FindByName?location=" + location;
            });
        });
    });
</script>



</header>
