<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- <aside> -->


<!-- <div class="  offcanvas offcanvas-start   " style="width:50px" tabindex="-1" id="offcanvas" aria-labelledby="offcanvasLabel"> -->
<!--   <div class="offcanvas-header"> -->
<!--     <h5 class="offcanvas-title  " id="offcanvasLabel">Offcanvas</h5> -->
<!--     <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close">所有景點</button> -->
<!--   </div> -->
<!--   <div class="offcanvas-body offcanvas.show "> -->
<!--     Content for the offcanvas goes here. You can place just about any Bootstrap component or custom elements here. -->
<!--   </div> -->
<!-- </div> -->
<!-- </aside> -->

<aside 
	style="width: 200px; text-align: justify;margin-top: -15px;padding-left: 4px; padding-right: 10px;">

	<a href="${root}/BackAllAttraction" style="text-decoration: none; ">
		<section 
			style="color:gray; font-weight: bolder; padding: 3px 5px 3px 10px; font-size: 18px;">
			<i class="fa-regular fa-map" style="color:gray;"></i>所有景點
		</section>
	</a>
	<a href="#" style="text-decoration: none; ">
		<section 
			style="color:gray; font-weight: bolder; padding: 3px 5px 3px 10px; font-size: 18px; margin-top:12px;">
			<i class="fa-regular fa-circle-user" style="color:gray;"></i>所有使用者
		</section>
	</a>
</aside>
