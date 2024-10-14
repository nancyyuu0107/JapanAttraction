<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${webName}-更新資訊</title>
<jsp:include page="${component }/CommonImports.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/WEB-INF/view/component/BackHeader.jsp"></jsp:include>


	<main class="m-5">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<form action="UpdateAttraction" method="POST"
						enctype="multipart/form-data">
						<input type="hidden" name="id" value="${a.attractionID }">
						<div class="mb-3">
						 <label>景點名稱：<input
								type="text" name="attractName" class="form-control"
								value="${a.attractionName }" /></label>
						</div>
						<div class="mb-3">
							<label>所在城市：<input type="text" name="locationName"
								class="form-control" value="${a.location }"  /></label>
						</div>
						<div class="mb-3">
<!-- 							<label>描述：<input type="text" name="discribes" -->
<%-- 								class="form-control" value="${a.discribe }"  style="height:200px width:100px"/></label> --%>
								
							<label>描述：<textarea name = "discribes" class="form-control" rows="10" cols="35" >${a.discribe }</textarea></label>
						</div>
						<div class="mb-1">
							<label>照片：<input type="file" name="attractPhoto"
								class="form-control" id="attrationPhotoInput" /></label>
						</div>
						<div class="mb-3">
							<img class="w-25" 
								id="previousIMG" src="${a.attractionPhotoBase64 }"/>
						</div>
						<button class="btn btn-secondary" id="cancelBTN">取消</button>
						<button class="btn btn-primary">更新</button>
					</form>
				</div>
			</div>
		</div>
	</main>





	<jsp:include page="/WEB-INF/view/component/Footer.jsp"></jsp:include>


</body>

<script type="text/javascript">
	// 選取元素
	const previousIMG = document.getElementById("previousIMG");
	const attrationPhotoInput = document.getElementById("attrationPhotoInput");
	const cancelBTN = document.getElementById("cancelBTN");

	// 預覽圖片
	attrationPhotoInput.addEventListener("change", function() {
		const file = this.files[0];
		if (file == null) {
			previousIMG.src = "${root}/assets/no_image.png";
			return;
		}
		const tempURL = URL.createObjectURL(file);
		previousIMG.src = tempURL;
	});

	// 點擊圖片觸發上傳檔案
	previousIMG.addEventListener("click", function() {
		attrationPhotoInput.click();
	});

	// 點擊取消按鈕返回上一頁
	cancelBTN.addEventListener("click", function(e) {
		e.preventDefault();
		window.history.back();
	});
</script>
</html>