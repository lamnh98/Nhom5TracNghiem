<%@ page pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home page</title>

    <link href="Template/Fontend/css/bootstrap.css" rel="stylesheet">
    <link href="Template/Fontend/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="Template/Fontend/css/style.css" rel="stylesheet"> 
    
    <link href='Template/Fontend/font/font.css' rel='stylesheet' type='text/css'>
    
      <link rel="shortcut icon" href="ico/favicon.ico">
      <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
      <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
      <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">

    <script src="Template/Fontend/js/jquery_1.js"></script>
    <script src="Template/Fontend/js/bootstrap.min.js"></script>
</head>
<body>
  <!-- /BEGIN HEADER ROW -->
  <jsp:include page="Header.jsp"></jsp:include>
  <!-- /HEADER ROW -->

  


  <div class="container">

  <!--Carousel
  ==================================================-->

  <div id="myCarousel" class="carousel slide">
    <div class="carousel-inner">

      <div class="active item">
        <div class="container">
          <div class="row">
            
              <div class="span6">

                <div class="carousel-caption">
                      <h1>Hướng Dẫn Phần Nghe, Đọc Toeic</h1>
                      <p class="lead">Chúng tôi cung cấp cho các bạn những kiến thức tốt nhất.</p>
                      <a class="btn btn-large btn-primary" href="#">Tham Gia</a>
                </div>

              </div>

                <div class="span6"> <img src="Template/Fontend/img/slide/slide1.jpg" height="390px" width="390px"></div>

          </div>
        </div>
      </div>

	  <c:forEach items="${listslidebanner}" var="list">
		    <div class="item">
		     
		      <div class="container">
		        <div class="row">
		          
		            <div class="span6">
		
		              <div class="carousel-caption">
		                    <h1>${list.slidename}</h1>
		                    <p class="lead">${list.slidecontent}</p>
		                    <a class="btn btn-large btn-primary" href="#">Tham Gia</a>
		              </div>
		
		            </div>
		
		              <div class="span6"> <img src="Template/Fontend/img/slide/${list.slideimage}" height="1200px" width="700px"></div>
		
		        </div>
		      </div>
		
		    </div>

		</c:forEach>



    </div>
       <!-- Carousel nav -->
      <a class="carousel-control left " href="#myCarousel" data-slide="prev"><i class="icon-chevron-left"></i></a>
      <a class="carousel-control right" href="#myCarousel" data-slide="next"><i class="icon-chevron-right"></i></a>
        <!-- /.Carousel nav -->

  </div>
    <!-- /Carousel -->



<!-- Feature 
  ==============================================-->


  <div class="row feature-box">
      <div class="span12 cnt-title">
       <h1>Chúng tôi cung cấp cho bạn các giao diện học và thi thân thiện với người dùng</h1> 
        <span>(--Học thử, Làm bài tập, Thi thử--)</span>        
      </div>

      <div class="span4">
        <img src="Template/Fontend/images/huongdanhoc.jpg"  width="190" height="160">
        <h2>Hướng dẫn phần bài tập ngữ pháp</h2>
        <p>
            Cung cấp các bài hướng dẫn sát với đề thi.
        </p>

        <a class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Chi tiết &rarr;</a>

      </div>

      <div class="span4">
        <img src="Template/Fontend/img/exercise.jpg">
        <h2>Bài tập phần nghe và đọc</h2>
        <p>
            Chúng tôi cung cấp các dạng bài tập có trong phần thi Toeic.
        </p>   
          <a href="#">Bài tập &rarr;</a>    
      </div>

      <div class="span4">
        <img src="Template/Fontend/images/test.jpg" width="300" height="200">
        <h2>Làm đề thi</h2>
        <p>
            Chúng tôi cung cấp cho các bạn đề thi sát với thi thật.
        </p>
          <a href="#">Đề thi thật &rarr;</a>
      </div>
  </div>


<!-- /.Feature -->

  <div class="hr-divider"></div>
    
</div>


<!-- /.Row View -->



<!--Footer
==========================-->
	<jsp:include page="Footer.jsp"/>
<!--/.Footer-->

	<!-- start modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">DANH SÁCH LOẠT BÀI HƯỚNG DẪN</h4>
				</div>
				<div class="modal-body">
					<div class=	"media">
						<a class="pull-left"><img src="Tempalte/Fontend/images/nghe1.png" class="media-object" alt=''></a>
						<div class="media-body">
							<h4>
								<a href="">Bài hướng dẫn phần nghe.</a>
							</h4>
						</div>
					</div>
					<div class=	"media">
						<a class="pull-left"><img src="Tempalte/Fontend/images/doc.png" class="media-object" alt=''></a>
						<div class="media-body">
							<h4>	
								<a href="Dsbaihdnguphapforwad?pageid=1">Bài hướng dẫn phần ngữ pháp.</a>
							</h4>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->
</body>
</html>