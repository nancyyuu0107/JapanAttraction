<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${webName}-所有景點</title>
<style>


  .heart {
    display: inline-block;
    cursor: pointer;
  }
  .heart i {
    color:#F19483;
  }
  .heart.clicked i {
    font-weight: bolder;
  }


/* 基本樣式 */
.scroll-to-top {
  display: none; /* 預設隱藏 */
  position: fixed;
  bottom: 20px;
  right: 30px;
  background-color:#BDC0BA;
  color: #FCFAF2;
  width: 45px;
  height: 45px;
  text-align: center;
  line-height: 40px;
  font-size: 30px;
  border-radius: 50%;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
  z-index: 99;
  transition: opacity 0.3s, visibility 0.3s;
}

/* 滾動顯示按鈕 */
.scroll-to-top.show {
  display: block;
}

/* 滾動效果 */
.scroll-to-top:hover {
  background-color: #BDC0BA;
}

/* 網頁內容區域樣式（示例） */
.content {
  padding: 20px;
  height: 2000px; /* 示範用，實際應該根據內容高度調整 */
}

body{
background-color:#808F7C;

}

.modal-body{

display:flex;
justify-content:space-around;
box-sizing:border-box;
}
.box1{
width:70%;
}
.box2{
width:30%;
text-align:left;
font-size:18px;
line-height:2em;
margin-left:-35px;
}


    .bigcard {
        transition: transform 0.2s ease; /* 添加过渡效果 */
    }

    .bigcard:hover {
        transform: scale(1.05); /* 鼠标悬停时放大卡片 */
    }
</style>


</head>
<jsp:include page="${component }/CommonImports.jsp"></jsp:include>
<body class="main">
	<jsp:include page="/WEB-INF/view/component/Header.jsp"></jsp:include>
	
<a href="#" class="scroll-to-top" style="text-decoration:none; color:#FFFFFB;"><i class="fa-solid fa-angle-up" style="color:#FFFFFB; margin-top:8px;"></i></a>
<!-- 	row-cols-md-4教室電腦改成5 -->
	<div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-0  text-center"  style="margin-right:48px; margin-left:-10px;"
		>
		<c:forEach items="${allAttractions }" var="a">
			<div class="col ">
				<div class="card bigcard m-5 shadow-sm ml-0" style="width: 330px; height:390px; ">
			
				<div  style="height:500px">
					<img data-id="${a.attractionID }" src="${a.attractionPhotoBase64 }" 
						class="card-img-top">
						</div>
					<div class="card-body ">
						<h5 class="card-title" style="color:#616138; font-weight:bolder;" >${a.attractionName }</h5>
					
						<p class="card-text" style="color:#616138; font-weight:bolder;">${a.location }</p>
						
<!-- 						<button class="lookMoreBtn btn btn-secondary " type="button" data-bs-toggle="modal" data-bs-target="#Modal"   style="margin-top:5px; margin-bottom:5px;">Look more...</button> -->
						<button  type="button" class="lookMoreBtn btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#Model-${a.attractionID}" style="margin-top:5px; margin-bottom:5px;">
Look more...
</button>

					</div>
				</div>
			</div>
<!-- Modal -->
<div class="modal fade" id="Model-${a.attractionID}"  tabindex="-1" aria-labelledby="exModel-${a.attractionID}" aria-hidden="true">
  <div class="modal-dialog  modal-dialog-scrollable modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exModel-${a.attractionID}" 	style="color:#4D5139; font-weight:bolder;margin-left:10px;font-size:21px;">${a.attractionName }</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" style="margin-right:20px;"></button>
      </div>
      <div class="modal-body" >
        <img class="box 1" data-id="${a.attractionID}" style="height:460px; " src="${a.attractionPhotoBase64 }">
					<p 	class="box2"style="color:#4D5139;">${a.discribe }</p>
      </div>
      <div class="modal-footer">
      <a href="#" class="heart" onclick="toggleHeart(event)"><i class="far fa-regular fa-heart" 	style="color:#F19483; font-size:28px; margin-right:20px;margin-top:5px"></i></a>
<!--         <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button> -->
      </div>
    </div>
  </div>
</div>
		</c:forEach>
	</div>

	<jsp:include page="/WEB-INF/view/component/Footer.jsp"></jsp:include>


</body>

<script type="text/javascript">
function toggleHeart(event) {
  event.preventDefault(); // 防止點擊連結時跳轉
  const heart = event.currentTarget;
  heart.classList.toggle('clicked');
  const icon = heart.querySelector('i');
  if (heart.classList.contains('clicked')) {
    icon.classList.remove('far');
    icon.classList.add('fas');
  } else {
    icon.classList.remove('fas');
    icon.classList.add('far');
  }
}


//監聽頁面滾動事件
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  var scrollToTopBtn = document.querySelector(".scroll-to-top");
  
  // 如果滾動超過300像素，顯示按鈕
  if (document.body.scrollTop > 300 || document.documentElement.scrollTop > 300) {
    scrollToTopBtn.classList.add("show");
  } else {
    scrollToTopBtn.classList.remove("show");
  }
}

// 點擊按鈕時滾動到頁面頂部
document.querySelector(".scroll-to-top").addEventListener("click", function() {
  document.body.scrollTop = 0; // For Safari
  document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
});

</script>
</html>