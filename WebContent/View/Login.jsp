<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login page</title>

		<link href="Template/Backend/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="Template/Backend/assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="Template/Backend/assets/css/ace-fonts.css" />

		<link rel="stylesheet" href="Template/Backend/assets/css/ace.min.css" />
		<link rel="stylesheet" href="Template/Backend/assets/css/ace-rtl.min.css" />

		
</head>
<body class="login-layout">
<div class="main-container">
	<div class="main-content">
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div class="login-container">
					<div class="center">
						<h1>
							<i class="icon-leaf green"></i>
							<span class="red">LEARN</span>
							<span class="white">TOEIC</span>
						</h1>
						<h4 class="blue">&copy; Myclass</h4>
					</div>

					<div class="space-6"></div>

					<div class="position-relative">
						<div id="login-box" class="login-box visible widget-box no-border">
							<div class="widget-body">
								<div class="widget-main">
									<h4 class="header blue lighter bigger">
										<i class="icon-coffee green"></i>
										Please Enter Your Information
									</h4>

									<div class="space-6"></div>

									<form action="LoginController" method="POST">
										<fieldset>
											<label class="block clearfix" style="color:red">
											<%=request.getAttribute("msgLogin")!=null?request.getAttribute("msgLogin"):" " %>
											</label>
											<label class="block clearfix">
												<span class="block input-icon input-icon-right">
													<input type="text" class="form-control" placeholder="Username" name="nembername" />
													<i class="icon-user"></i>
												</span>
											</label>

											<label class="block clearfix">
												<span class="block input-icon input-icon-right">
													<input type="password" class="form-control" placeholder="Password" name="nemberpass"/>
													<i class="icon-lock"></i>
												</span>
											</label>

											<div class="space"></div>

											<div class="clearfix">	

												<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
													<i class="icon-key"></i>
													Login
												</button>
											</div>

											<div class="space-4"></div>
										</fieldset>
									</form>
								</div><!-- /widget-main -->

								<div class="toolbar clearfix">
									<div>
										<a href="HomeForward" class="forgot-password-link">
											<i class="icon-arrow-left"></i>
											Back my home
										</a>
									</div>
								</div>
							</div><!-- /widget-body -->
						<div class="toolbar center">
							<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
								<i class="icon-arrow-left"></i>
								Back to login
							</a>
						</div>
							</div><!-- /widget-body -->
						</div><!-- /signup-box -->
					</div><!-- /position-relative -->
				</div>
			</div><!-- /.col -->
		</div><!-- /.row -->
</div><!-- /.main-container -->
		
	<script type="text/javascript">
		window.jQuery || document.write("<script src='Template/Backend/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
	</script>

	<script type="text/javascript">
		if("ontouchend" in document) document.write("<script src='Template/Backend/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
	</script>

	<script type="text/javascript">
		function show_box(id) {
		 jQuery('.widget-box.visible').removeClass('visible');
		 jQuery('#'+id).addClass('visible');
		}
	</script>
</body>
</html>