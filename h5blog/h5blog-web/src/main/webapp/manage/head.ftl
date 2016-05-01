<!DOCTYPE html>
<html lang="en">
  	<head>
	    <meta charset="utf-8">
	    <title>网站管理系统</title>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">

	   

		<link href="${BASE_PATH}/pkg/lib.css" rel="stylesheet"/>	

		<link href="${BASE_PATH}/css/ionicons.min.css" rel="stylesheet">
		<!-- Datepicker -->
		<link href="${BASE_PATH}/css/datepicker.css" rel="stylesheet"/>	

		<!-- Animate -->
		<link href="${BASE_PATH}/css/animate.min.css" rel="stylesheet">

		<!-- Toastr -->
		<link href="${BASE_PATH}/css/toastr.css" rel="stylesheet">

		<!-- H5uploader -->
		<link href="${BASE_PATH}/css/jquery.h5uploader.css" rel="stylesheet">


		<link href="${BASE_PATH}/video/video-js.css" rel="stylesheet" type="text/css">
		<!-- video.js must be in the <head> for older IEs to work. -->
		<script src="${BASE_PATH}/video/video.js"></script>
		<script>
	    	videojs.options.flash.swf = "${BASE_PATH}/video/video-js.swf";
	  	</script>
		<!-- style -->
		<link href="${BASE_PATH}/css/style.css" rel="stylesheet">
	
  	</head>

  	<body class="overflow-hidden">
		<div class="wrapper preload">
			<header class="top-nav">
				<div class="top-nav-inner">
					<div class="nav-header">
						<button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleSM">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						
						<ul class="nav-notification pull-right">
							<li>
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog fa-lg"></i></a>
								<span class="badge badge-danger bounceIn">1</span>
								<ul class="dropdown-menu dropdown-sm pull-right user-dropdown">
									<li class="user-avatar">
										<img src="${BASE_PATH}/images/profile/profile1.jpg" alt="" class="img-circle">
										<div class="user-content">
											<h5 class="no-m-bottom">管理员</h5>
										</div>
									</li>	  
									<li>
										<a href="profile.htm">
											个人资料
										</a>
									</li>			  
									<li>
										<a href="${BASE_PATH}/logout.htm">
											登出
										</a>
									</li>			  
								</ul>
							</li>
						</ul>
						
						<a href="index.html" class="brand">
							<span class="brand-name">网站管理系统</span>
						</a>
					</div>
					<div class="nav-container">
						<button type="button" class="navbar-toggle pull-left sidebar-toggle" id="sidebarToggleLG">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<ul class="nav-notification">	
							<li class="search-list">
								<div class="search-input-wrapper">
									<div class="search-input">
										<input type="text" class="form-control input-sm inline-block">
										<a href="#" class="input-icon text-normal"><i class="ion-ios7-search-strong"></i></a>
									</div>
								</div>
							</li>
						</ul>
						<div class="pull-right m-right-sm">
							<div class="user-block hidden-xs">
								<a href="#" id="userToggle" data-toggle="dropdown">
									<img src="${BASE_PATH}/images/profile/profile1.jpg" alt="" class="img-circle inline-block user-profile-pic">
									<div class="user-detail inline-block">
										管理员
										<i class="fa fa-angle-down"></i>
									</div>
								</a>
								<div class="panel border dropdown-menu user-panel">
									<div class="panel-body paddingTB-sm">
										<ul>
											<li>
												<a href="profile.html">
													<i class="fa fa-edit fa-lg"></i><span class="m-left-xs">My Profile</span>
												</a>
											</li>
											<li>
												<a href="${BASE_PATH}/logout.htm">
													<i class="fa fa-power-off fa-lg"></i><span class="m-left-xs">Sign out</span>
												</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div><!-- ./top-nav-inner -->	
			</header>
			<aside class="sidebar-menu fixed">
				<div class="sidebar-inner scrollable-sidebar">
					<div class="main-menu">
						<ul class="accordion">
							<li class="menu-header">
								Main Menu
							</li>
							<li class="bg-palette1 <#if menu="index">active</#if> ">
								<a href="${BASE_PATH}/manage/index.htm">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-home fa-lg"></i></span>
										<span class="text m-left-sm">主页</span>
									</span>
									<span class="menu-content-hover block">
										主页
									</span>
								</a>
							</li>
							<li class="bg-palette2 <#if menu="website">active</#if> ">
								<a href="${BASE_PATH}/">
									<span class="menu-content block">
										<span class="menu-icon"><i class="block fa fa-desktop fa-lg"></i></span>
										<span class="text m-left-sm">网站</span>
									</span>
									<span class="menu-content-hover block">
										网站
									</span>
								</a>
							</li>
							<li class="bg-palette3 <#if menu="video">active</#if> ">
								<a href="${BASE_PATH}/manage/video/index.htm">
									<span class="menu-content block">
									<span class="menu-icon"><i class="block fa fa-play-circle fa-lg"></i></span>
										<span class="text m-left-sm">视频</span>
									</span>
									<span class="menu-content-hover block">
										视频
									</span>
								</a>
							</li>
								<li class="bg-palette4 <#if menu="photo">active</#if> ">
								<a href="${BASE_PATH}/manage/photo/index.htm">
									<span class="menu-content block">
									<span class="menu-icon"><i class="block fa fa-th-large fa-lg"></i></span>
										<span class="text m-left-sm">相册</span>
									</span>
									<span class="menu-content-hover block">
										相册
									</span>
								</a>
							</li>
							<li class="bg-palette1 <#if menu="file">active</#if> ">
								<a href="${BASE_PATH}/manage/file/index.htm">
									<span class="menu-content block">
									<span class="menu-icon"><i class="block fa fa-folder-open fa-lg"></i></span>
										<span class="text m-left-sm">文件</span>
									</span>
									<span class="menu-content-hover block">
										文件
									</span>
								</a>
							</li>
							<li class="bg-palette2 <#if menu="blog">active</#if> ">
								<a href="${BASE_PATH}/manage/blog/index.htm">
									<span class="menu-content block">
									<span class="menu-icon"><i class="block fa fa-edit fa-lg"></i></span>
										<span class="text m-left-sm">博客</span>
									</span>
									<span class="menu-content-hover block">
										博客
									</span>
								</a>
							</li>
						</ul>
					</div>	
				</div><!-- sidebar-inner -->
			</aside>