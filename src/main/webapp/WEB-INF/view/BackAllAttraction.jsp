<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${webName}-景點一覽表</title>

<style>
.all {
	display: flex;
	margin: 20px;
}

.search {
	display: flex;
	flex-direction: row;
	margin-right: 15px;
	margin-left:193px;
	margin-top: 20px;
	justify-content:space-between;
}

td {
	width: 80px;
	text-align: center;
	vertical-align: middle;
}

i {
	padding-right: 8px;
}

section:hover {
	background-color: rgb(237, 237, 237);
	border-radius: 3px;
}

a:link {
	text-decoration: none;
}

.deleteBtn {
	border-radius: 6px;
}

table {
	margin-right: 3px;
	margin-top: -15px;
}
</style>

<jsp:include page="${component }/CommonImports.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/BackHeader.jsp"></jsp:include>

		<div class="search">
		<a href="${root}/BackAddAttraction">
		<button type="button" class="btn btn-outline-secondary" style="margin:7px;">新增景點</button>
		</a>
			<nav class="navbar navbar-light ">
				<div class="container-fluid">
					<form action="BackShowAttraction" class="d-flex" method="post"
						enctype="multipart/form-data">
						<input name="attractionName" class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button  class="btn btn-outline-dark" type="submit">Search</button>
					</form>
				</div>
			</nav>
		</div>
	<div class="all">
		<jsp:include page="/WEB-INF/view/component/BackOffcanvas.jsp"></jsp:include>

		<table class="table table-light">
			<thead>
				<tr style="font-weight:bolder">
					<td>景點ID</td>
					<td>景點名稱</td>
					<td>所在城市</td>
					<td style="width: 60px;">照片</td>
					<td style="width: 200px;">描述</td>
					<td>刪除</td>
					<td>更新</td>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${allAttractions }" var="a">
					<tr>
						<td>${a.attractionID }</td>
						<td>${a.attractionName }</td>
						<td>${a.location }</td>
						<td style="width: 60px;"><img data-id="${a.attractionID }"
							src="${a.attractionPhotoBase64 }" style="width: 200px"></td>
						<td style="width: 200px;">${a.discribe }</td>
						<td>
							<button type="button" data-id="${ a.attractionID}"
								class="deleteBtn btn-sm btn-secondary">Delete</button>
						</td>

						<td>
							<button type="button" data-id="${ a.attractionID}"
								class="updateBtn btn-sm btn-secondary">Update</button>
						</td>


					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 	<table> -->
	<!-- 		<thead> -->
	<!-- 			<tr> -->
	<!-- 				<td>景點ID</td> -->
	<!-- 				<td>景點名稱</td> -->
	<!-- 				<td>城市名稱</td> -->
	<!-- 				<td>照片</td> -->
	<!-- 				<td>描述</td> -->
	<!-- 				<td>刪除</td> -->

	<!-- 			</tr> -->
	<!-- 		</thead> -->
	<!-- 		<tbody> -->

	<!-- 		</tbody> -->

	<!-- 	</table> -->

	<jsp:include page="/WEB-INF/view/component/Footer.jsp"></jsp:include>


	<script type="text/javascript">
		const imgs = document.querySelectorAll("img")
		const deleteBtns = document.querySelectorAll(".deleteBtn");
		const updateBtns = document.querySelectorAll(".updateBtn");

		for(let btn of deleteBtns){
			btn.addEventListener("click",()=>{
				if(confirm("確定要刪除嗎")){
					fetch("/JapanAttraction/DeleteAttractionById?id="+btn.dataset["id"]).then(rs=>rs.text()).then(message=>{

						if(message=="done"){
							btn.parentElement.parentElement.remove();
						}

					})
					}
		})
				}
		
		
		for(let upBtn of updateBtns){
			upBtn.addEventListener("click",()=>{
				window.location="/JapanAttraction/BackUpdate?id="+upBtn.dataset["id"];
		})
				}
		
	

// 		for(let img of imgs){
// 			img.addEventListener("click",()=>{
// 				window.location="/JapanAttraction/BackShowAttraction?id="+img.dataset["id"];
// 			})
// 		}

	</script>
</body>
</html>