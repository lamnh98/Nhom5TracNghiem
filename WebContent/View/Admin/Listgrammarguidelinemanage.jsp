<%@ page pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm danh sách bài hướng dẫn ngữ pháp</title>
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
</head>
<body>

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
									<a href="Listgrammarguidelinemanage">
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
							<li>
								<a href="#">Manage</a>
							</li>
							<li class="active">Add List Grammar</li>
						</ul><!-- .breadcrumb -->
					</div>
					<div class="page-content">
						<c:if test="${msglistgrammarguidelinemanage!=''}">
							<h4 class="pink">
									<i class="icon-hand-right icon-animated-hand-pointer blue"></i>
									<a href="#modal-table" role="button" class="green" data-toggle="modal">${msglistgrammarguidelinemanage}</a>
							</h4>
						</c:if>
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-12">
										<div class="table-responsive">
											<table id="sample-table-1" class="table table-striped table-bordered table-hover">
												<thead>
													<tr>
														<th class="center">
															ID
														</th>
														<th class="center">
															Tên Bài
														</th>
														<th class="center">
															Tên Hình
														</th>
														<th class="center">
															Xóa Bài
														</th>
														<th class="center">
															Thêm Nội Dung
														</th>
														<th class="center">
															Check Nội Dung 
														</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${listgrammarguidelinemanage}" var="l">
														<tr>
															<td class="center">
																${l.grammarguidelineid}
															</td>
															<td class="center">
																${l.grammarname}
															</td>
															<td class="center">
																${l.grammarimage}
															</td>
															<td class="center">
																<a class="red" href="Xoabaihdnguphap?grammarguidelineid=${l.grammarguidelineid}">
																	<i class="icon-trash bigger-130"></i>
																</a>
															</td>
															<td class="center">
																<a class="green" href="Grammarguidelinecontentforward?id=${l.grammarguidelineid}">
																	<i class="icon-pencil bigger-130"></i>
																</a>
															</td>
															<td class="center">
																<ul class="list-unstyled">
																	<c:if test="${l.content!=null}">
																		<li>
																			<i class="icon-check"></i>
																			icon-check
																		</li>
																	</c:if>
																	<c:if test="${l.content==null}">
																		<li>
																			<i class="icon-check-empty"></i>
																			icon-check-empty
																		</li>
																	</c:if>
																</ul>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<button type="button" class="btn" data-toggle="modal" data-target="#myModal">
												<i class="icon-pencil align-top bigger-125"></i>
												Save Learn
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- /.main-content -->
		</div><!-- /.main-container-inner -->	
		
		
		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
			<form action="Insertgrammarguidelinename" method="POST" >
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Thêm bài hướng dẫn ngữ pháp</h4>
			      </div>
			      <div class="modal-body">
			       	<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> Nhập Tên Bài </label>
	
						<div class="col-sm-9">
							<input type="text" id="form-field-1" placeholder="Tên bài hướng dẫn" class="col-xs-10 col-sm-5" name="grammarname" />
						</div>
					</div>
			      </div>
			      <div class="modal-footer">
			        <button class="btn btn-info" type="submit">
						<i class="icon-ok bigger-110"></i>
						Submit
					</button>
			      </div>
			    </div>
			</form>
		  </div>
		</div>

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

		<script src="Template/Backend/assets/js/jquery.dataTables.min.js"></script>
		<script src="Template/Backend/assets/js/jquery.dataTables.bootstrap.js"></script>

		<!-- ace scripts -->

		<script src="Template/Backend/assets/js/ace-elements.min.js"></script>
		<script src="Template/Backend/assets/js/ace.min.js"></script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			jQuery(function($) {
				var oTable1 = $('#sample-table-2').dataTable( {
				"aoColumns": [
			      { "bSortable": false },
			      null, null,null, null, null,
				  { "bSortable": false }
				] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			
			
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			})
		</script>
</body>
</html>