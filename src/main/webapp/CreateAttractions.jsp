<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增景點</title>
</head>
<body>
	<form action="CreateAttraction.do" method="POST"enctype="multipart/form-data">

		<div>
			景點名稱：<input type="text" name="attractName">
		</div>
		<div>
			城市名稱：<input type="text" name="locationName">
		</div>
		<div>
			照片：<input type="file" name="attractPhoto">
		</div>
		<div>
			描述：<input type="text" name="discribes">
		</div>

		<button>建立</button>

	</form>
	
	 
</body>
</html>