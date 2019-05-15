<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trang Chủ Quản Trị</title>
	<meta name="description" content="responsive photo gallery using colorbox" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<link href="Template/Backend/assets/css/bootstrap.min.css" rel="stylesheet" />
	
	<link rel="stylesheet" href="Template/Backend/assets/css/colorbox.css" />

	<link rel="stylesheet" href="Template/Backend/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="Template/Backend/assets/css/ace-fonts.css" />

	<link rel="stylesheet" href="Template/Backend/assets/css/ace.min.css" />
	<link rel="stylesheet" href="Template/Backend/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="Template/Backend/assets/css/ace-skins.min.css" />
	
	<script src="Template/Backend/assets/js/ace-extra.min.js"></script>

	<style type="text/css">
		.paddingtop-image
		{
			padding-top:130px;
		}
	</style>
</head>
<body class="no-skin">
	<!-- Header -->
	<jsp:include page="HeaderAdmin.jsp"/>
	<!-- End Header -->
	
	<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>
			
			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>
	
				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>
	
					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>
	
							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>
	
							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>
	
							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>
	
						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>
	
							<span class="btn btn-info"></span>
	
							<span class="btn btn-warning"></span>
	
							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->
	
					<ul class="nav nav-list">
						<li>
							<a href="#" class="dropdown-toggle">
								<i class="icon-list"></i>
								<span class="menu-text"> Guideline Manage </span>

								<b class="arrow icon-angle-down"></b>
							</a>

							<ul class="submenu">
								<li>
									<a href="Listgrammarguidelinemanage	">
										<i class="icon-double-angle-right"></i>
										Grammar
									</a>
								</li>

								<li>
									<a href="Quanlydethiforward">
										<i class="icon-double-angle-right"></i>
										Exam
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.nav-list -->
					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>
				</div>
				
				<!-- Begin content	 -->
				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>
	
						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="AdminForward">Trang Chủ</a>
							</li>	
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!--  <div class="row-fluid">
									<ul class="ace-thumbnails">
										<li>
											<a href="assets/images/gallery/image-1.jpg" title="Photo Title" data-rel="colorbox">
												<center>
												<img alt="" src="Template/Backend/assets/images/gallery/thumb-1.jpg" />
												</center>
											</a>
										</li>
									</ul>
								</div-->
								<center class="paddingtop-image">
								<img width="500" height="250" alt="" src="Template/Backend/assets/images/admin.png" />
								</center> 
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
		</div><!-- /.main-container-inner -->		
		
	<!-- basic scripts -->
	
	<!--[if !IE]> -->
	
	<script type="text/javascript">
	window.jQuery || document.write("<script src='Template/Backend/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
	</script>
	
	<!-- <![endif]-->
	<!--[if IE]>
	<script type="text/javascript">
	 window.jQuery || document.write("<script src='Template/Backend/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
	</script>
	<![endif]-->
	
	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='Template/Backend/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="Template/Backend/assets/js/bootstrap.min.js"></script>
		<script src="Template/Backend/assets/js/typeahead-bs2.min.js"></script>
	
		<!-- page specific plugin scripts -->
	
		<script src="Template/Backend/assets/js/jquery.colorbox-min.js"></script>
	
		<!-- ace scripts -->
	
		<script src="Template/Backend/assets/js/ace-elements.min.js"></script>
		<script src="Template/Backend/assets/js/ace.min.js"></script>
	
		<!-- inline scripts related to this page -->
	
		<script type="text/javascript">
				jQuery(function($) {
		var colorbox_params = {
			reposition:true,
			scalePhotos:true,
			scrolling:false,
			previous:'<i class="icon-arrow-left"></i>',
			next:'<i class="icon-arrow-right"></i>',
			close:'&times;',
			current:'{current} of {total}',
			maxWidth:'100%',
			maxHeight:'100%',
			onOpen:function(){
				document.body.style.overflow = 'hidden';
			},
			onClosed:function(){
				document.body.style.overflow = 'auto';
			},
			onComplete:function(){
				$.colorbox.resize();
			}
		};
	
		$('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
		$("#cboxLoadingGraphic").append("<i class='icon-spinner orange'></i>");
	})
	</script>
</body>
</html>