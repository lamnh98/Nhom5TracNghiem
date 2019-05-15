<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Quản lý hướng dẫn ngữ pháp</title>
	<meta name="description" content="" />

	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	<link href="Template/Backend/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="Template/Backend/assets/css/font-awesome.min.css" />


	<link rel="stylesheet" href="Template/Backend/assets/css/jquery-ui-1.10.3.custom.min.css" />


	<link rel="stylesheet" href="Template/Backend/assets/css/ace-fonts.css" />


	<link rel="stylesheet" href="Template/Backend/assets/css/ace.min.css" />
	<link rel="stylesheet" href="Template/Backend/assets/css/ace-rtl.min.css" />
	<link rel="stylesheet" href="Template/Backend/assets/css/ace-skins.min.css" />

	<script src="Template/Backend/assets/js/ace-extra.min.js"></script>

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
									<a href="Grammarguidelinemanage">
										<i class="icon-double-angle-right"></i>
										Grammar
									</a>
								</li>

								<li>
									<a href="">
										<i class="icon-double-angle-right"></i>
										Vocabulary
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.nav-list -->
					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>
				</div>
				<div class="main-content">
					<div class="breadcrumbs" id="breadcrumbs">
						<script type="text/javascript">
							try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
						</script>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home home-icon"></i>
								<a href="#">Home</a>
							</li>

							<li>
								<a href="#">Manage</a>
							</li>
							<li class="active">Grammar</li>
						</ul><!-- .breadcrumb -->
					</div>

					<div class="page-content">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS --> 
								<div class="row">
									<div class="col-sm-6">
										<h4 class="header green">Soạn thảo nội dung ngữ pháp</h4>
											<h4 class="pink">
													<i class="icon-hand-right icon-animated-hand-pointer blue"></i>
													<a role="button" class="red" data-toggle="modal"><%=request.getAttribute("msggrammarguidelinecontent")!=null?request.getAttribute("msggrammarguidelinecontent"):""%></a>
											</h4>
										<div class="widget-box">
											<div class="widget-header widget-header-small header-color-blue">  </div>
												<form action="Grammarguidelinecontentcontroller?grammarguidelineid=<%=request.getAttribute("grammarguidelineid")%>" method="POST">
													<div class="widget-body">
														<div class="widget-main no-padding">
															<textarea class="span12" name="content" data-provide="markdown" rows="10" data-hidden-buttons="Image">
															</textarea>
														</div>
		
														<div class="widget-toolbox padding-4 clearfix">
															<div class="btn-group pull-right">
																<button class="btn btn-sm btn-purple" type="submit">
																	<i class="icon-save bigger-125"></i>
																	Save 
																</button>
															</div>
														</div>
													</div>
												</form>
										</div>
									</div>
								</div>

								<script type="text/javascript">
									var $path_assets = "assets";//this will be used in loading jQuery UI if needed!
								</script>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div><!-- /.main-content -->
			</div><!-- /.main-container-inner -->

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->

		<script type="text/javascript">
			window.jQuery || document.write("<script src='Template/Backend/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='Template/Backend/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="Template/Backend/assets/js/bootstrap.min.js"></script>
		<script src="Template/Backend/assets/js/typeahead-bs2.min.js"></script>

		<!-- page specific plugin scripts -->

		<script src="Template/Backend/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
		<script src="Template/Backend/assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="Template/Backend/assets/js/markdown/markdown.min.js"></script>
		<script src="Template/Backend/assets/js/markdown/bootstrap-markdown.min.js"></script>
		<script src="Template/Backend/assets/js/jquery.hotkeys.min.js"></script>
		<script src="Template/Backend/assets/js/bootstrap-wysiwyg.min.js"></script>
		<script src="Template/Backend/assets/js/bootbox.min.js"></script>

		<!-- ace scripts -->

		<script src="Template/Backend/assets/js/ace-elements.min.js"></script>
		<script src="Template/Backend/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($){
	
	function showErrorAlert (reason, detail) {
		var msg='';
		if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
		else {
			console.log("error uploading file", reason, detail);
		}
		$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
		 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
	}

	//$('#editor1').ace_wysiwyg();//this will create the default editor will all buttons

	//but we want to change a few buttons colors for the third style
	$('#editor1').ace_wysiwyg({
		toolbar:
		[
			'font',
			null,
			'fontSize',
			null,
			{name:'bold', className:'btn-info'},
			{name:'italic', className:'btn-info'},
			{name:'strikethrough', className:'btn-info'},
			{name:'underline', className:'btn-info'},
			null,
			{name:'insertunorderedlist', className:'btn-success'},
			{name:'insertorderedlist', className:'btn-success'},
			{name:'outdent', className:'btn-purple'},
			{name:'indent', className:'btn-purple'},
			null,
			{name:'justifyleft', className:'btn-primary'},
			{name:'justifycenter', className:'btn-primary'},
			{name:'justifyright', className:'btn-primary'},
			{name:'justifyfull', className:'btn-inverse'},
			null,
			{name:'createLink', className:'btn-pink'},
			{name:'unlink', className:'btn-pink'},
			null,
			{name:'insertImage', className:'btn-success'},
			null,
			'foreColor',
			null,
			{name:'undo', className:'btn-grey'},
			{name:'redo', className:'btn-grey'}
		],
		'wysiwyg': {
			fileUploadError: showErrorAlert
		}
	}).prev().addClass('wysiwyg-style2');

	

	$('#editor2').css({'height':'200px'}).ace_wysiwyg({
		toolbar_place: function(toolbar) {
			return $(this).closest('.widget-box').find('.widget-header').prepend(toolbar).children(0).addClass('inline');
		},
		toolbar:
		[
			'bold',
			{name:'italic' , title:'Change Title!', icon: 'icon-leaf'},
			'strikethrough',
			null,
			'insertunorderedlist',
			'insertorderedlist',
			null,
			'justifyleft',
			'justifycenter',
			'justifyright'
		],
		speech_button:false
	});


	$('[data-toggle="buttons"] .btn').on('click', function(e){
		var target = $(this).find('input[type=radio]');
		var which = parseInt(target.val());
		var toolbar = $('#editor1').prev().get(0);
		if(which == 1 || which == 2 || which == 3) {
			toolbar.className = toolbar.className.replace(/wysiwyg\-style(1|2)/g , '');
			if(which == 1) $(toolbar).addClass('wysiwyg-style1');
			else if(which == 2) $(toolbar).addClass('wysiwyg-style2');
		}
	});


	

	//Add Image Resize Functionality to Chrome and Safari
	//webkit browsers don't have image resize functionality when content is editable
	//so let's add something using jQuery UI resizable
	//another option would be opening a dialog for user to enter dimensions.
	if ( typeof jQuery.ui !== 'undefined' && /applewebkit/.test(navigator.userAgent.toLowerCase()) ) {
		
		var lastResizableImg = null;
		function destroyResizable() {
			if(lastResizableImg == null) return;
			lastResizableImg.resizable( "destroy" );
			lastResizableImg.removeData('resizable');
			lastResizableImg = null;
		}

		var enableImageResize = function() {
			$('.wysiwyg-editor')
			.on('mousedown', function(e) {
				var target = $(e.target);
				if( e.target instanceof HTMLImageElement ) {
					if( !target.data('resizable') ) {
						target.resizable({
							aspectRatio: e.target.width / e.target.height,
						});
						target.data('resizable', true);
						
						if( lastResizableImg != null ) {//disable previous resizable image
							lastResizableImg.resizable( "destroy" );
							lastResizableImg.removeData('resizable');
						}
						lastResizableImg = target;
					}
				}
			})
			.on('click', function(e) {
				if( lastResizableImg != null && !(e.target instanceof HTMLImageElement) ) {
					destroyResizable();
				}
			})
			.on('keydown', function() {
				destroyResizable();
			});
	    }
		
		enableImageResize();

		/**
		//or we can load the jQuery UI dynamically only if needed
		if (typeof jQuery.ui !== 'undefined') enableImageResize();
		else {//load jQuery UI if not loaded
			$.getScript($path_assets+"/js/jquery-ui-1.10.3.custom.min.js", function(data, textStatus, jqxhr) {
				if('ontouchend' in document) {//also load touch-punch for touch devices
					$.getScript($path_assets+"/js/jquery.ui.touch-punch.min.js", function(data, textStatus, jqxhr) {
						enableImageResize();
					});
				} else	enableImageResize();
			});
		}
		*/
	}


});
		</script>
</body>
</html>