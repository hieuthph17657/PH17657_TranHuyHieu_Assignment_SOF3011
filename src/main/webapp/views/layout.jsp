<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ban hang online</title>
<link rel="stylesheet"
	href="/PH17657_TranHuyHieu_Assignment_SOF3011/css/bootstrap.min.css" />
</head>
<body>
	<div class="row">
	<img src="https://th.bing.com/th/id/R.0b3418cb82070b272a55d43776fe88b5?rik=fiG3i3%2fj9scPfA&riu=http%3a%2f%2fthoitrangphucan.com%2fimage%2fcache%2fcatalog%2fNew+ZALORA+banner-1140x380.jpg&ehk=oeseZNwPjuK2TJfNrg4cQUMErdC%2fieaLo5N7fIVRJPE%3d&risl=&pid=ImgRaw&r=0">
	</div>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-md navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Navbar</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/PH17657_TranHuyHieu_Assignment_SOF3011/layout_product/danhmuc">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="/PH17657_TranHuyHieu_Assignment_SOF3011/layout_product/lichsudat">Lịch sử</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Quản lý
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="/PH17657_TranHuyHieu_Assignment_SOF3011/products/index">Quản lý sản phẩm</a></li>
	            <li><a class="dropdown-item" href="/PH17657_TranHuyHieu_Assignment_SOF3011/categories/index">Quản lý danh mục</a></li>
	            <li><a class="dropdown-item" href="/PH17657_TranHuyHieu_Assignment_SOF3011/users/index">Quản lý tài khoản</a></li>
	            <li><a class="dropdown-item" href="/PH17657_TranHuyHieu_Assignment_SOF3011/carts/index">Quản lý đơn hàng</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="/PH17657_TranHuyHieu_Assignment_SOF3011/login?action=dangnhap">Đăng nhập</a></li>
	            <li><a class="dropdown-item" href="/PH17657_TranHuyHieu_Assignment_SOF3011/login?action=dangxuat">Đăng xuất</a></li>
	          </ul>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link disabled">Disabled</a>
	        </li>
	      </ul>
	      <form class="d-flex">
	      <a class="mt-2 me-2 text-decoration-none text-secondary">${user1.email}</a>
	        <a class="btn btn-success ms-auto" href="/PH17657_TranHuyHieu_Assignment_SOF3011/layout_product/giohang"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart-check-fill" viewBox="0 0 16 16">
  <path d="M.5 1a.5.5 0 0 0 0 1h1.11l.401 1.607 1.498 7.985A.5.5 0 0 0 4 12h1a2 2 0 1 0 0 4 2 2 0 0 0 0-4h7a2 2 0 1 0 0 4 2 2 0 0 0 0-4h1a.5.5 0 0 0 .491-.408l1.5-8A.5.5 0 0 0 14.5 3H2.89l-.405-1.621A.5.5 0 0 0 2 1H.5zM6 14a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm7 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0zm-1.646-7.646-3 3a.5.5 0 0 1-.708 0l-1.5-1.5a.5.5 0 1 1 .708-.708L8 8.293l2.646-2.647a.5.5 0 0 1 .708.708z"/>
</svg>Giỏ hàng</a>
	      </form>
	    </div>
	  </div>
	</nav>
	<!-- End Navbar -->
	
	<div class="row">
		<div class="col-3"></div>
		<div class="col-9">
			<jsp:include page="${ view }"></jsp:include>
		</div>
	</div>
	
	<div class="bg-dark text-white text-center">HieuTHPH17657</div>

	<script src="/PH17657_TranHuyHieu_Assignment_SOF3011/js/jquery.min.js"></script>
	<script src="/PH17657_TranHuyHieu_Assignment_SOF3011/js/popper.min.js"></script>
	<script src="/PH17657_TranHuyHieu_Assignment_SOF3011/js/bootstrap.min.js"></script>
</body>
</html>