<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hướng dẫn ngữ pháp page</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	
	<link href="Template/Fontend/css/bootstrap.min.css" rel="stylesheet">
	<link href="Template/Fontend/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link href="Template/Fontend/css/style.css" rel="stylesheet">
  <link rel="Template/Fontend/apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="Template/Fontend/apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="Template/Fontend/apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="Template/Fontend/apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="Template/Fontend/shortcut icon" href="img/favicon.png">
  
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="Template/Fontend/js/bootstrap.min.js"></script>
    <style type="text/css">
    	#para1
    	{
    		padding-top:60px;
    	}
    </style>
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
					Danh sách bài tập hướng dẫn ngữ pháp
				</h1>
			</div>
			</div>
		</div>
	
	  <!-- /. PAGE TITLE "Imageupload/${l.grammarimage}-->
	
		<div class="row">
			<c:forEach items="${listgrammarguideline}" var="l">
				<div class="span6">
					<div class="media">
						 <a href="#" class="pull-left"><img src="ImageUpload/${l.grammarimage}" class="media-object" width="128px" height="128px"/></a>
						<div class="media-body">
							<p>	
								${l.grammarname}
							</p>
							<a href="Chitietbaihdnguphapforward?mabaihdnguphap=${l.grammarguidelineid}" class="btn" type="button">Xem bài hướng dẫn</a>
						</div>
					</div>
				</div>			
			</c:forEach>
		</div>
		
		<!-- Bắt đầu phân trang -->
		<div class="pagination">
				<ul>
					<c:if test="${numberpage == 1}">
						<li class="disabled"><a href="#">Prev</a></li>
						<li><a href="Dsbaihdnguphapforwad?pageid=${numberpage+1}">Next</a></li>
					</c:if>
					<c:if test="${numberpage == maxpageid}">
						<li><a href="Dsbaihdnguphapforwad?pageid=${numberpage-1}">Prev</a></li>
						<li class="disabled"><a href="#">Next</a></li>
					</c:if>
					<c:if test="${numberpage > 1 && numberpage < maxpageid}">
						<li><a href="Dsbaihdnguphapforwad?pageid=${numberpage-1}">Prev</a></li>
						<li><a href="Dsbaihdnguphapforwad?pageid=${numberpage+1}">Next</a></li>
					</c:if>
				</ul>
		</div>	
		<!-- Kết thúc phân trang -->
	</div>

<!--Footer
==========================-->
	<jsp:include page="Footer.jsp"/>
<!--/.Footer-->
</body>
</html>