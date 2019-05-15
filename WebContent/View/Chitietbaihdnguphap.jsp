<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hướng dẫn học ngữ pháp page</title>
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	
	<link href="Template/Fontend/css/bootstrap.min.css" rel="stylesheet">
	<link href="Template/Fontend/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link href="Template/Fontend/css/style.css" rel="stylesheet">
	
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  


    <!-- SCRIPT 
    ============================================================-->  
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="Template/Fontend/js/bootstrap.min.js"></script>
</head>
<body>

<!-- /BEGIN HEADER ROW -->
  <jsp:include page="Header.jsp"></jsp:include>
  <!-- /HEADER ROW -->

	<div class="container">
	  <!--PAGE TITLE-->

	<div class="row">
		<div class="span12">
		<div class="page-header">
				<h1>
				Bài hướng dẫn ngữ pháp
			</h1>
		</div>
		</div>
	</div>

  <!-- /. PAGE TITLE-->



	<div class="row">

	
		<div class="span9">
			<!--Blog Post-->
			<div class="blog-post">
				
				<div class="postmetadata">
					<ul>
							<li>
								<i class="icon-user"></i> <a href="#">Author Name</a>
							</li>

							<li>
								 <i class="icon-calendar"></i>September 20th, 2013
							</li>

							<li>
								<i class="icon-comment"></i> <a href="#">100 Comments</a>
							</li>
							<li>
								<i class="icon-tags"></i> <a href="#">Themes</a>, <a href="#">Template</a>
							</li>
					</ul>
				</div>
				
					<p>
						<c:set var="kq1" value="${fn:replace(gammarcontent,kitutrongdatabase1,kitutronghtml1)}"></c:set>
						<c:out value="${kq1}" escapeXml="false"></c:out>
					${gammarcontent}
					</p>	
	
			</div>



			<!--/.Blog Post-->



			<!--Comments-->

			<h2>Comments</h2>


			<div class="comments">
				<span class="span6">
		  			<form>
						<fieldset>
							 <h3>Bình luận</h3>
		
							 <textarea  class="input-xxlarge"  rows="10"  placeholder="Your Message"></textarea>
								<br>
							 <button type="submit" class="btn">Submit</button>
						</fieldset>
					</form>
		  		</span>
			</div>

			<!--/.Comments-->

		</div>	
		<div class="span3">
			<div class="side-bar">
				<h3>Danh Mục</h3>
				<ul class="nav nav-list">
					<li><a href="#">Hướng dẫn học ngữ pháp</a></li>
					<li><a href="#">Hướng dẫn học từ vựng</a></li>
					<li><a href="#">Làm bài tập phần đọc</a></li>
					<li><a href="#">Làm bài tập phần nghe</a></li>
				    <li><a href="#">Thi thử Toeic</a></li>
				</ul>

			</div>
		</div>


		</div>

		
		<!--==================-->
	</div>
</div>

<!--Footer
==========================-->
	<jsp:include page="Footer.jsp"/>
<!--/.Footer-->
</body>
</html>