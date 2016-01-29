<!DOCTYPE HTML>
<html>

<head>
    <title>Home</title>
    <#include "/page/head.ftl">
</head>

<body class="background_image">
    <div role="navigation" class="zu-top">
        <div class="zg-wrap modal-shifting clearfix" id="zh-top-inner">
            <a class="zu-top-link-logo" id="zh-top-link-logo" data-za-c="view_home" data-za-a="visit_home" data-za-l="top_navigation_zhihu_logo">LOGO</a>
            <div class="head-nav">
                <span class="menu"> </span>
                <ul class="cl-effect-3">
                    <li class="active"><a href="${BASE_PATH}/main/index">微博</a></li>
                    <li><a href="">相册</a></li>
                    <li><a href="">视频</a></li>
                    <li><a href="">文章</a></li>
                    <div class="clearfix"> </div>
                </ul>
            </div>
            <div class="head-contact">
                <ul class="number">
                    <li><span><i class="phone"> </i>+0123 456 789</span></li>
                    <li><a href="mailto:dyulai@msn.com"><i class="mail"> </i>dyulai@msn.com</a></li>
                    <div class="clearfix"> </div>
                </ul>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-push-1 col-md-10 col-xs-12">
                <!-- banner -->
                <div>
                    <div id="banner_tabs" class="flexslider">
                        <ul class="slides">
                            <li>
                                <a title="" target="_blank" href="#">
                                    <img width="920px" height="300px" alt="" style="background: url(/h5blog/static/page/images/banner1.jpg) no-repeat center;" src="/h5blog/static/page/images/alpha.png">
                                </a>
                            </li>
                            <li>
                                <a title="" href="#">
                                    <img width="920px" height="300px" alt="" style="background: url(/h5blog/static/page/images/banner2.jpg) no-repeat center;" src="/h5blog/static/page/images/alpha.png">
                                </a>
                            </li>
                            <li>
                                <a title="" href="#">
                                    <img width="920px" height="300px" alt="" style="background: url(/h5blog/static/page/images/banner3.jpg) no-repeat center;" src="/h5blog/static/page/images/alpha.png">
                                </a>
                            </li>
                        </ul>
                        <ul class="flex-direction-nav">
                            <li><a class="flex-prev" href="javascript:;">Previous</a></li>
                            <li><a class="flex-next" href="javascript:;">Next</a></li>
                        </ul>
                        <ol id="bannerCtrl" class="flex-control-nav flex-control-paging">
                            <li><a>1</a></li>
                            <li><a>2</a></li>
                            <li><a>2</a></li>
                        </ol>
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <!-- banner -->
                <!-- main_blog start-->
                <div class="row">
                <div class="col-md-8 col-xs-12" style="height:100%;">
                    <div class="feed_wrap">
                        <img src="${BASE_PATH}/static/page/images/Snap1.png" width="100%">
                    </div>
                    <div class="feed_wrap">
                        <img src="${BASE_PATH}/static/page/images/Snap2.png" width="100%">
                    </div>
                    <div class="feed_wrap">
                        <img src="${BASE_PATH}/static/page/images/Snap3.png" width="100%">
                    </div>
                    <div class="feed_wrap">
                        <img src="${BASE_PATH}/static/page/images/Snap4.png" width="100%">
                    </div>
                    <div class="feed_wrap">
                        <img src="${BASE_PATH}/static/page/images/Snap5.png" width="100%">
                    </div>
                    <div class="feed_wrap">
                        <img src="${BASE_PATH}/static/page/images/Snap6.png" width="100%">
                    </div>
                    <div class="clearfix"> </div>
                </div>
                <!-- main_blog stop -->
                <!-- right start-->
                <!-- right stop -->
                <!-- footer-top -->
                <div class="col-md-4 col-xs-12 footer-top row">
                    <div class="col-md-4 foo-left">
                        <a href="${BASE_PATH}/static/page/index.html"><img src="${BASE_PATH}/static/page/images/logo.png" class="img-responsive" alt=""></a>
                        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore. sed diam nonumy eirmod tempor invidunt ut labore. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore.</p>
                    </div>
                    <div class="col-md-4 foo-left">
                        <h3>Twitter Update</h3>
                        <h6>ABOUT 9 HOURS</h6>
                        <p>AGOMeet Aldous - a Brave New World for #rails with more cohesion, less coupling and greater dev speed http://t.co/rsekglotzs</p>
                        <h6>ABOUT 1 DAY AGO</h6>
                        <p>Here's a rare Interview with #graphicdesign legend Massimo Vignelli http://t.co/duxnpoh57z http://t.co/kxO3gPBTo7</p>
                    </div>
                    <div class="col-md-4 foo-left">
                        <h3>Useful lnks</h3>
                        <ul>
                            <li class="active"><a href="${BASE_PATH}/static/page/about.html">About Us</a></li>
                            <li><a href="#">Services </a></li>
                            <li><a href="#">Work </a></li>
                            <li><a href="${BASE_PATH}/static/page/blog.html">Our Blog</a></li>
                            <li><a href=" ${BASE_PATH}/static/page/404.html">Customers Testimonials</a></li>
                            <li><a href="#">Affliate</a></li>
                            <li><a href=" ${BASE_PATH}/static/page/contact.html">Contact Us</a></li>
                            <div class="clearfix"> </div>
                        </ul>
                    </div>
                </div>
                </div>
                <!-- footer-top -->
                <!-- footer-bottom -->
                <div class="col-md-12 row footer-bottom  col-xs-12">
                    <p>Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">example</a></p>
                </div>
                <!-- footer-bottom -->
            </div>
        </div>
    </div>
</body>
<#include "/page/foot.ftl">

</html>
<script type="text/javascript">
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
    $('#banner_tabs .flex-prev').click(function() {
        bannerSlider.prev()
    });
    $('#banner_tabs .flex-next').click(function() {
        bannerSlider.next()
    });
});

// addEventListener("load", function() {
//     setTimeout(hideURLbar, 0);
// }, false);

// function hideURLbar() {
//     window.scrollTo(0, 1);
// }


$("span.menu").click(function() {
    $(".head-nav ul").slideToggle(300, function() {
        // Animation complete.
    });
});
</script>
