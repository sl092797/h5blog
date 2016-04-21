<!DOCTYPE html>
<html>
<head>
  <title>Video.js | HTML5 Video Player</title>

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
  controls preload="auto" width="360px" height="240px"
  poster="../upload/video/Wildlife.jpg" data-setup=''>
  <source src="../upload/video/Wildlife.mp4" type='video/mp4' />
  <source src="video/video.webm" type='video/webm' />
  <source src="video/video.ogv" type='video/ogg' />
 <p class="vjs-no-js">播放视频需要启用 JavaScript，推荐使用支持HTML5的浏览器访问。</p>
</video>

</body>
</html>
