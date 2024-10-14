<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>${webName}-新增景點</title>
<jsp:include page="${component }/CommonImports.jsp"></jsp:include>
</head>


<body>
	<jsp:include page="/WEB-INF/view/component/BackHeader.jsp"></jsp:include>
	<main class="m-5">
		<div class="container">
			<div class="row">
				<div class="col text-center">
					<form action="CreateAttraction" method="POST"
						enctype="multipart/form-data">
						<div class="mb-3">
							<label>景點名稱：<input type="text"
								name="attractName" class="form-control" /></label>
						</div>
						<div class="mb-3">
							<label>所在城市：<input type="text"
								name="locationName" class="form-control" /></label>
						</div>
						<div class="mb-3">
							<label>描述：<textarea name = "discribes" class="form-control" rows="10" cols="35" >${a.discribe }</textarea></label>
						</div>
						<div class="mb-1">
							<label>照片：<input type="file"
								name="attractPhoto" class="form-control"
								id="attrationPhotoInput" /></label>
						</div>
						<div class="mb-3">
							<img src="${root}/assets/no_image.png" id="previewPhotoIMG"
								class="w-25" />
						</div>
						<button class="btn btn-secondary" id="cancelBTN">取消</button>
						<button class="btn btn-primary">新增</button>
					</form>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="/WEB-INF/view/component/Footer.jsp"></jsp:include>
</body>

<script type="text/javascript">
	// 選取元素
	const previewPhotoIMG = document.getElementById("previewPhotoIMG");
	const attrationPhotoInput = document.getElementById("attrationPhotoInput");
	const cancelBTN = document.getElementById("cancelBTN");

	// 預覽圖片
	attrationPhotoInput.addEventListener("change", function() {
		const file = this.files[0];
		if (file == null) {
			previewPhotoIMG.src = "${root}/assets/no_image.png";
			return;
		}
		const tempURL = URL.createObjectURL(file);
		previewPhotoIMG.src = tempURL;
	});

	// 點擊圖片觸發上傳檔案
	previewPhotoIMG.addEventListener("click", function() {
		attrationPhotoInput.click();
	});

	// 點擊取消按鈕返回上一頁
	cancelBTN.addEventListener("click", function(e) {
		e.preventDefault();
		window.history.back();
	});
</script>
</html>