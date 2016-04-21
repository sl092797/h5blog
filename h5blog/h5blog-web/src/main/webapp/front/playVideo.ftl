<!DOCTYPE html>
<html>
<head>
  <title>${Video.videoName}</title>

  <!-- Chang URLs to wherever Video.js files will be hosted -->
  <link href="${BASE_PATH}/video/video-js.css" rel="stylesheet" type="text/css">
  <!-- video.js must be in the <head> for older IEs to work. -->
  <script src="${BASE_PATH}/video/video.js"></script>

  <!-- Unless using the CDN hosted version, update the URL to the Flash SWF -->
  <script>
    videojs.options.flash.swf = "video-js.swf";
  </script>


</head>
<body>
      <video id="video" class="video-js vjs-default-skin vjs-big-play-centered"  
        controls preload="auto" width="960px" height="540px"
        poster="${BASE_PATH}/${Video.videoPosterpath}" data-setup=''>
        <source src="${BASE_PATH}/${Video.videoCompressedpath}" type='video/mp4' />
        <source src="video/video.webm" type='video/webm' />
        <source src="video/video.ogv" type='video/ogg' />
       <p class="vjs-no-js">播放视频需要启用 JavaScript，推荐使用支持HTML5的浏览器访问。</p>
      </video>
      <br/>
      <!-- JiaThis Button BEGIN -->
      <div class="jiathis_style">
      <span class="jiathis_txt">分享到：</span>
      <a class="jiathis_button_tsina">新浪微博</a>
      <a class="jiathis_button_weixin">微信</a>
      <a class="jiathis_button_qzone">QQ空间</a>
      <a class="jiathis_button_tqq">腾讯微博</a>
      
      <a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jiathis_separator jtico jtico_jiathis" target="_blank">更多</a>
      <a class="jiathis_counter_style"></a>
      </div>
      <script type="text/javascript" >
      var jiathis_config={
        siteNum:4,
        sm:"renren,douban,kaixin001,tieba",
        summary:"",
        shortUrl:false,
        hideMore:true
      }
      </script>
      <script type="text/javascript" src="http://v3.jiathis.com/code_mini/jia.js" charset="utf-8"></script>
      <!-- JiaThis Button END -->
      <!-- UY BEGIN -->
      <br/>
      <div id="uyan_frame"></div>
      <script type="text/javascript" src="http://v2.uyan.cc/code/uyan.js?uid=2096402"></script>
      <!-- UY END -->
</body>
</html>
