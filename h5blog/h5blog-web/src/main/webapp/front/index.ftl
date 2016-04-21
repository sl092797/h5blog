<!DOCTYPE html>
<html lang="en">
	<!--
	#######################################
		- THE HEAD PART -
	######################################
	-->
	<head>
    	<meta charset="utf-8">
    	<title>沪城学士</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="description" content="">
	    <meta name="author" content="">

	    <!-- Bootstrap core CSS -->
	    <link href="${BASE_PATH}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Font Awesome -->
		<link href="${BASE_PATH}/css/font-awesome.min.css" rel="stylesheet">

		<!-- ionicons -->
		<!-- <link href="${BASE_PATH}/css/ionicons.min.css" rel="stylesheet"> -->
		
		<!-- Owl -->
		<!-- <link href="${BASE_PATH}/css/owl.carousel.min.css" rel="stylesheet"> -->
		<!-- <link href="${BASE_PATH}/css/owl.theme.default.min.css" rel="stylesheet"> -->

		<link href="${BASE_PATH}/css/style.css" rel="stylesheet">
		<link href="${BASE_PATH}/css/front.css" rel="stylesheet">
		<!-- <link href="${BASE_PATH}/css/extralayers.css" rel="stylesheet"> -->
		<!-- slider -->
		<link href="${BASE_PATH}/css/flexslider.css" rel="stylesheet">
		<!-- FancyBox -->
		<link rel="stylesheet" href="${BASE_PATH}/css/jquery.fancybox-v=2.1.5.css" type="text/css" media="screen">

		<!-- Simplify -->
		<link href="${BASE_PATH}/css/simplify.min.css" rel="stylesheet">


		<style type="text/css">
			.navbar-nav a{
				font-size: 1.5em;
				font-weight: 600;
			}
			.navbar-brand{
				width:280px;
				background: url(${BASE_PATH}/images/front/new_logo.png) no-repeat 0 center;
				background-size: contain;
			}
			.gallery-img{
				max-height: 188px;
			}
		</style>

	</head>

<!--
#######################################
	- THE BODY PART -
######################################
-->
	<body>
		<div class="wrapper front-end-wrapper">
			<header class="navbar front-end-navbar" data-spy="affix" data-offset-top="1">
			  <div class="container">
			    <div class="navbar-header">
			      <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a href="./index.htm" class="navbar-brand"></a>
			    </div>
			    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
			      <ul class="nav navbar-nav">
			        <li>
			          <a href="#weiboSection">微博</a>
			        </li>
			        <li>
			          <a href="#videoSection">视频</a>
			        </li>
			        <li>
			          <a href="#gallerySection">相册</a>
			        </li>
			        <li>
			          <a href="#fileSection">文档</a>
			        </li>
			        <li>
			          <a href="#blogSection">博客</a>
			        </li>
			      </ul>
			    </nav>
			  </div>
			</header>

			<!--
			#################################
				- THEMEPUNCH BANNER -
			#################################
			-->
			<div class="tp-banner-container">
				<div class="tp-banner" >
					<ul>	<!-- SLIDE  -->
						<div id="banner_tabs" class="flexslider">
	                        <ul class="slides">
	                            <li>
	                                <a title="" target="_blank" href="#">
	                                    <img alt="" style="background: url(${BASE_PATH}/images/front/banner1.jpg) no-repeat;background-size: cover;" src="${BASE_PATH}/images/front/alpha.png">
	                                </a>
	                            </li>
	                            <li>
	                                <a title="" href="#">
	                                    <img alt="" style="background: url(${BASE_PATH}/images/front/banner2.jpg) no-repeat;background-size: cover;" src="${BASE_PATH}/images/front/alpha.png">
	                                </a>
	                            </li>
	                            <li>
	                                <a title="" href="#">
	                                    <img alt="" style="background: url(${BASE_PATH}/images/front/banner3.jpg) no-repeat;background-size: cover;" src="${BASE_PATH}/images/front/alpha.png">
	                                </a>
	                            </li>
	                        </ul>
	                        <!-- <ul class="flex-direction-nav">
	                            <li><a class="flex-prev" href="javascript:;">Previous</a></li>
	                            <li><a class="flex-next" href="javascript:;">Next</a></li>
	                        </ul> -->
	                        <a class="left carousel-control" href="#" data-slide="prev">
					            <span class="icon-prev"></span>
					        </a>
					        <a class="right carousel-control" href="#" data-slide="next">
					            <span class="icon-next"></span>
					        </a>
	                        <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
	                            <li><a>1</a></li>
	                            <li><a>2</a></li>
	                            <li><a>2</a></li>
	                        </ol>
	                    </div>
					</ul>
				</div>	<!-- ./tp-banner -->
			</div>	<!-- ./tp-banner-container -->

			<div class="section bg-skyblue section-padding" id="weiboSection">
				<div class="container">
					<#list weibos as weibo>
						<div class="wb_card">
							<div class="wb_author clearfix">
								<div class="wb_avatar">
									<a href="http://weibo.com/dyulai1966?refer_flag=1001030101_">
										<img src="${BASE_PATH}/images/profile/profile1.jpg" width="50" height="50" alt="沪城学士">
									</a>
								</div>
								<div class="wb_author_info">
									<a href="http://weibo.com/dyulai1966?refer_flag=1001030101_">
										沪城学士
									</a>
									<i title="微博达人" class="W_icon icon_club" node-type="daren"></i>
									<em class="W_icon icon_member6"></em>
									<span> ${weibo.time!}</span>
								</div>
							</div>
							<div class="wb_origin">
								${weibo.title!}
							</div>
							<div class="wb_quote">
								<div class="wb_text">
									${weibo.quote!}
								</div>
								<ul class="wb_link clearfix">
									<#list weibo.pictureList as picture>
										<li>
											${picture}
										</li>
									</#list>
								</ul>
							</div>
						</div>
					</#list>
					<a href="http://weibo.com/dyulai1966?refer_flag=1001030101_" target="_blank" class="btn btn-lg wb_morebutton">查看更多</a>
				</div>
			</div>

			<div class="section bg-dark-blue section-padding" id="videoSection">
				<div class="container">
					<div class="text-center">
						<h3 class="text-upper" id="videoSectionName">V I D E O S</h3>
					</div>
					<div class="videos-filter m-top-md">
	                    <ul class="clearfix">
	                        
	                    </ul>
	                </div>
					<div class="row">
						<div class="videos-list m-top-md">
                		</div>
					</div><!-- ./row -->
				</div><!-- ./container -->
			</div><!-- ./section -->

			<div class="section bg-grey section-padding" id="gallerySection">
				<div class="container">
					<a id="returnGallery" href="javascript:photo.returnGallery();" style="cursor: pointer;display: none;"><i class="fa fa-arrow-left fa-2x"> 返回</i></a>
					<div class="text-center">
						<h3 class="text-upper" id="galleryName">G A L L E R Y</h3>
					</div>

					<div class="row">
						<div class="gallery-list m-top-md">
                		</div>
					</div><!-- ./row -->
				</div><!-- ./container -->
			</div><!-- section -->	

			<div class="section bg-success section-padding" id="fileSection">
				<div class="container text-center">
					
				</div><!-- ./container -->
			</div><!-- ./section -->
			<div class="section bg-white section-padding" id="blogSection">
				<div class="container text-center">
				</div>
			</div><!-- ./section -->
		
			<footer class="front-end-footer">
				<div class="container">
					<div class="row">
						<div class="col-md-offset-2 col-md-5">
							<h4>Contact Us</h4>
							<address class="m-top-md">
							  <strong>Twitter, Inc.</strong><br>
								795 Folsom Ave, Suite 600<br>
								San Francisco, CA 94107<br>
								<div class="seperator"></div>
								<strong>Phone : <span class="theme-font">(123) 456-7890</span></strong><br>
								<strong>Email : <span class="theme-font">endless.themes@gmail.com</span></strong><br>
								<strong>Website : <span class="theme-font">Your website</span></strong>
							</address>
						</div><!-- ./col -->
						<div class="col-md-5">
							<span class="footer-brand">
							<strong class="text-danger">H5</strong> Blog
							</span>
							<p class="no-margin">
								&copy; 2016 <strong>Vic</strong>. ALL Rights Reserved. 
							</p>
						</div><!-- ./col -->
					</div><!-- ./row -->
				</div><!-- ./container -->
			</footer>

			<a href="#" class="scroll-to-top hidden-print"><i class="fa fa-chevron-up fa-lg"></i></a>
		</div><!-- /wrapper -->

		<!-- Jquery -->
		<script src="${BASE_PATH}/js/jquery-1.11.1.min.js"></script>

		<!-- Bootstrap -->
		<script src="${BASE_PATH}/bootstrap/js/bootstrap.min.js"></script>

		<!-- ScrollTo -->
		<script src="${BASE_PATH}/js/jquery.scrollTo.min.js"></script>

		<!-- Local Scroll -->
		<script src="${BASE_PATH}/js/jquery.localScroll.min.js"></script>

		<!-- Slider -->
		<script src="${BASE_PATH}/js/slider.js"></script>

		<!-- FancyBox -->
		<script type="text/javascript" src="${BASE_PATH}/js/jquery.fancybox.js"></script>

		<script type="text/javascript">

		jQuery(document).ready(function() {		

			//Section Animation
			// if (Modernizr.mq('(min-width: 1349px)')) {
			// 	$('.animation-element').waypoint(function() {
			// 			$(this).removeClass('disabled');
			// 	}, { offset: 700 });
			// }
			// else if (Modernizr.mq('(min-width: 992px)') && Modernizr.mq('(max-width: 1349px)')) {
			// 	$('.animation-element').waypoint(function() {
			// 			$(this).removeClass('disabled');
			// 	}, { offset: 550 });
			// }
			// else	{
			// 	$('.animation-element').removeClass('disabled');
			// }


			//Scrollto section
	        $('.front-end-wrapper .navbar-collapse .navbar-nav').localScroll({
	          duration:800,
	          offset: -100
	        });
		});	

		$(window).scroll(function(){
			 var position = $(window).scrollTop();
		
			 if(position >= 200)	{
				$('.scroll-to-top').addClass('active')
			 }
			 else	{
				$('.scroll-to-top').removeClass('active')
			 }
		});
			
		$(function() {
		    var bannerSlider = new Slider($('#banner_tabs'), {
		        time: 5000,
		        delay: 400,
		        event: 'hover',
		        auto: true,
		        mode: 'fade',
		        controller: $('#bannerCtrl'),
		        activeControllerCls: 'active'
		    });
		    $('#banner_tabs .left').click(function() {
		        bannerSlider.prev()
		    });
		    $('#banner_tabs .right').click(function() {
		        bannerSlider.next()
		    });
		});

		//myjs
		 $(function() {
		 	// $.post("${BASE_PATH}/front/weibo/getWeibos.json",{},function(data){
    //     		if(data.result){
    //     			var htmlStr="";
    //     			for(var i in data.t){
    //     				htmlStr += 
	   //      			'<div class="wb_card">'+
				// 			'<div class="wb_author clearfix">'+
				// 				'<div class="wb_avatar">'+
				// 					'<a href="http://weibo.com/dyulai1966?refer_flag=1001030101_">'+
				// 						'<img src="${BASE_PATH}/images/profile/profile1.jpg" width="50" height="50" alt="沪城学士">'+
				// 					'</a>'+
				// 				'</div>'+
				// 				'<div class="wb_author_info">'+
				// 					'<a href="http://weibo.com/dyulai1966?refer_flag=1001030101_">'+
				// 						'沪城学士'+
				// 					'</a>'+
				// 					'<i title="微博达人" class="W_icon icon_club" node-type="daren"></i>'+
				// 					'<em class="W_icon icon_member6"></em>'+
				// 					'<span> '+data.t[i].time+'</span>'+
				// 				'</div>'+
				// 			'</div>'+
				// 			'<div class="wb_origin">'+
				// 				data.t[i].title+
				// 			'</div>'+
				// 			'<div class="wb_quote">'+
				// 				'<div class="wb_text">'+
				// 					data.t[i].quote+
				// 				'</div>'+
				// 				'<ul class="wb_link clearfix">';
				// 					for(var j in data.t[i].pictureList){
				// 						htmlStr += '<li>'+data.t[i].pictureList[j]+'</li>';
				// 					}
				// 					htmlStr +=
				// 				'</ul>'+
				// 			'</div>'+
				// 		'</div>';
    //     			}
    //     			$("#weiboSection .container").prepend(htmlStr);
    //     			$(".fancyboxWB").fancybox({
		  //               padding: 10,
		  //               helpers: {
		  //                   overlay: {
		  //                       locked: false
		  //                   }
		  //               }
		  //           });
    //     		}
    //     	});

            $('.gallery-item').bind('touchstart', function(e) {
                $(this).siblings().removeClass('active');
                $(this).addClass('active');
            });

            $(".fancyboxVideo").fancybox({
                fitToView   : false,
                width       : 995,
                height      : 560,
                autoSize    : false,
                closeClick  : false,
                openEffect  : 'none',
                closeEffect : 'fade',
                afterClose:function(){
                	setTimeout("$('a[href=\"#videoSection\"]')[0].click();",500);
                }
            });

            photo.getGallerys();
            video.getVideoList();
        });

		var photo = {
			getGallerys:function(){
				$.post("${BASE_PATH}/front/photo/getGallerys.json",{},function(data){
            		if(data.result){
            			var htmlStr='';
            			for(index in data.t){
            				var gallery = data.t[index];
            				htmlStr += ' <div class="gallery-item"><div class="gallery-wrapper">';
            				if(gallery.coverFilePath!=undefined){
            					htmlStr += '<img class="gallery-img" src="${BASE_PATH}/'+gallery.coverFilePath+'" alt="">';
            				}else{
            					htmlStr += '<img class="gallery-img" src="${BASE_PATH}/images/gallery/default.jpg" alt="新相册">';
            				}
            				htmlStr +='<div class="gallery-title"><a href="javascript:photo.getPhotos('+gallery.catlogId+',\''+gallery.catlogName+'\',\''+gallery.catlogDesc+'\');">'+gallery.catlogName+'</a></div><div class="gallery-overlay"><a href="javascript:photo.getPhotos('+gallery.catlogId+',\''+gallery.catlogName+'\',\''+gallery.catlogDesc+'\');" class="gallery-action enlarged-photo"><i class="fa fa-arrow-right fa-lg"></i></a></div></div></div>';
            			}
            			$(".gallery-list").html(htmlStr);
            		}
            	});
			},
			getPhotos:function(galleryId,galleryName,galleryDesc){
				$.post("${BASE_PATH}/front/photo/getPhotos.json", {
                    'galleryId': galleryId
                }, function(data) {
                    if (data.result) {
                        var htmlStr = '';
                        for (index in data.t) {
                            var photo = data.t[index];
                            htmlStr += ' <div class="gallery-item"><div class="gallery-wrapper">';
                            htmlStr += '<img src="${BASE_PATH}/' + photo.photoPath + '" alt="">';
                            htmlStr += '<div class="gallery-overlay"><a rel="gallery1" href="${BASE_PATH}/' + photo.photoPath + '" class="gallery-action enlarged-photo fancybox"><i class="fa fa-search-plus fa-lg"></i></a><h3 style="position:relative;top:-3em;color:white;">' + photo.photoName + '</h3></div></div></div>';
                        }
                        $(".gallery-list").html(htmlStr);
                        $(".fancybox").fancybox({
                            padding: 10,
                            helpers: {
                                overlay: {
                                    locked: false
                                }
                            }
                        });
                        $("#galleryName").html(galleryName);
                        $("#galleryDesc").html(galleryDesc);
                        $("#returnGallery").show();
                    }
                });
			},
			returnGallery:function(){
				photo.getGallerys();
            	$("#returnGallery").hide();
            	$("#galleryName").html("照片墙");
			}

		}
		var video={
			getVideoList:function(){
				$.post("${BASE_PATH}/front/video/getVideoList.json",{},function(data){
            		if(data.result){
                        $('.videos-filter>ul').html('');
            			var htmlStr='';
            			for(index in data.t){
            				var catlog = data.t[index];
                            if(index == 0){
                            	video.getVideos(catlog.catlogId);
                                $('.videos-filter>ul').append('<li class="active" name="'+catlog.catlogId+'" data-name="'+catlog.catlogName+'" data-desc="'+catlog.catlogDesc+'"><a href="javascript:video.getVideos('+catlog.catlogId+');">'+catlog.catlogName+'</a></li>');
                            }else{
                                $('.videos-filter>ul').append('<li name="'+catlog.catlogId+'" data-name="'+catlog.catlogName+'" data-desc="'+catlog.catlogDesc+'"><a href="javascript:video.getVideos('+catlog.catlogId+');">'+catlog.catlogName+'</a></li>');
                            }
            			}
                        $('.videos-filter>ul>li>a').click(function(){
                            $(this).parent().siblings().removeClass('active');
                            $(this).parent().addClass('active');
                        });
            		}
            	});
			},
			getVideos:function(catlogId){
				$.post("${BASE_PATH}/front/video/getVideos.json",{'catlogId':catlogId},function(data){
                    if(data.result){
                        var videoList = data.t;
                        var htmlStr = "";
                        for(i in videoList){
                            htmlStr += '<div class="videos-item"><div class="videos-wrapper"><a data-fancybox-type="iframe" href="${BASE_PATH}/front/video/playVideo.htm?video='+videoList[i].videoId+'" class="fancyboxVideo"><img src="${BASE_PATH}/'+videoList[i].videoPosterpath+'" class="videos-img" alt=""><div class="videos-overlay"><span class="video-play-span">- 播放 -</span></div></a></div><p class="video-title"><a data-fancybox-type="iframe" href="${BASE_PATH}/front/video/playVideo.htm?video='+videoList[i].videoId+'" class="fancyboxVideo">'+videoList[i].videoName+'</a></p></div>';
                        }
                        $('.videos-list').html(htmlStr);
                    }
                });
			},

		}
	</script>
					
	</body>
</html>