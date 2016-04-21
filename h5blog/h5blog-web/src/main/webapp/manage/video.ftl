<#assign menu="video">
    <#include "/manage/head.ftl">
        <style type="text/css">
        .videos-list .videos-item{
            width:32.1%;
            padding:8px;
        }
        .video-title{
            overflow: hidden;
            text-align: center;
            color: #31343b;
            line-height: 60px;
            font-size: 16px;
            height: 2.7em;
        }
        .video-title a{
            text-decoration: none;
        }
        .video-play-span{
            color: white;
            font-size: 22px;
        }
        </style>
        <div class="main-container">
            <div class="padding-md">
                <h2 class="header-text no-margin">
						视频管理
					</h2>
                <a href="javascript:newVideoList();" class="btn btn-primary" style="margin:1em 1em 0em 0em;float:right;">新建分类</a>
                <a href="javascript:updateVideoList();" class="btn btn-primary" style="margin:1em 1em 0em 0em;float:right;">修改分类</a>
                <a href="javascript:uploadVideos();" class="btn btn-primary" style="margin:1em 1em 0em 0em;float:right;">上传视频</a>
                <div class="videos-filter m-top-md">
                    <ul class="clearfix">
                        <#list VideoList as catlog>
                            <#if catlog_index == 0>
                                <li class="active" name="${catlog.catlogId}" data-name="${catlog.catlogName}" data-desc="${catlog.catlogDesc}"><a href="javascript:getVideos(${catlog.catlogId});">${catlog.catlogName}</a></li>
                            <#else>
                                <li name="${catlog.catlogId}" data-name="${catlog.catlogName}" data-desc="${catlog.catlogDesc}"><a href="javascript:getVideos(${catlog.catlogId});">${catlog.catlogName}</a></li>
                            </#if>
                        </#list>
                    </ul>
                </div>
                <div class="videos-list m-top-md">
                   

                </div>
                <!-- ./videos-list -->
            </div>
            <!-- ./padding-md -->
        </div>
        <!-- /main-container -->
        </div>
        <!-- /wrapper -->
        <div id="newVideoListBootbox" style="display: none">
            <form id="newVideoListForm" action="${BASE_PATH}/manage/video/newVideoList.json" method='post' class="form-horizontal">
                <div class="row">
                    <label class="col-sm-3 control-label">分类名称</label>
                    <div class="col-sm-6">
                        <input type='text' id='catlogName' name='catlogName' class='form-control' placeholder='分类名称' />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-3 control-label">分类描述</label>
                    <div class="col-sm-6">
                        <input type="text" id="catlogDesc" name="catlogDesc" class="form-control" placeholder="分类描述" />
                    </div>
                </div>
            </form>
        </div>

        <div id="updateVideoListBootbox" style="display: none">
            <form id="updateVideoListForm" action="${BASE_PATH}/manage/video/updateVideoList.json" method='post' class="form-horizontal">
                <input type='text' id='update_catlogId' name='update_catlogId' style="display: none;" />
                <div class="row">
                    <label class="col-sm-3 control-label">分类名称</label>
                    <div class="col-sm-6">
                        <input type='text' id='update_catlogName' name='update_catlogName' class='form-control' />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-3 control-label">分类描述</label>
                    <div class="col-sm-6">
                        <input type="text" id='update_catlogDesc' name="update_catlogDesc" class="form-control" />
                    </div>
                </div>
            </form>
        </div>
        
        <#include "/manage/foot.ftl">
            <script>
            $(function() {
                $('.videos-filter>ul>li>a').click(function(){
                    $(this).parent().siblings().removeClass('active');
                    $(this).parent().addClass('active');
                });

                $('.videos-filter>ul>li.active>a')[0].click();

                $('.videos-item').bind('touchstart', function(e) {
                    $(this).siblings().removeClass('active');
                    $(this).addClass('active');
                });

                $(".fancybox").fancybox({
                    fitToView   : false,
                    width       : 995,
                    height      : 560,
                    autoSize    : false,
                    closeClick  : false,
                    openEffect  : 'none',
                    closeEffect : 'none'
                });
            });

            function getVideoList(catlogId){
            	$.post("${BASE_PATH}/manage/video/getVideoList.json",{},function(data){
            		if(data.result){
                        $('.videos-filter>ul').html('');
            			var htmlStr='';
            			for(index in data.t){
            				var catlog = data.t[index];
                            if(catlog.catlogId == catlogId){
                                $('.videos-filter>ul').append('<li class="active" name="'+catlog.catlogId+'" data-name="'+catlog.catlogName+'" data-desc="'+catlog.catlogDesc+'"><a href="javascript:getVideos('+catlog.catlogId+');">'+catlog.catlogName+'</a></li>');
                            }else{
                                $('.videos-filter>ul').append('<li name="'+catlog.catlogId+'" data-name="'+catlog.catlogName+'" data-desc="'+catlog.catlogDesc+'"><a href="javascript:getVideos('+catlog.catlogId+');">'+catlog.catlogName+'</a></li>');
                            }
            			}
                        $('.videos-filter>ul>li>a').click(function(){
                            $(this).parent().siblings().removeClass('active');
                            $(this).parent().addClass('active');
                        });
            		}
            	});
            }

            function getVideos(catlogId){
                $.post("${BASE_PATH}/manage/video/getVideos.json",{'catlogId':catlogId},function(data){
                    if(data.result){
                        var videoList = data.t;
                        var htmlStr = "";
                        for(i in videoList){
                            htmlStr += '<div class="videos-item"><div class="videos-wrapper"><a href="javascript:deleteVideo('+videoList[i].videoId+',\''+videoList[i].videoName+'\');" class="videos-remove"><i class="fa fa-times"></i></a><a data-fancybox-type="iframe" href="${BASE_PATH}/front/video/playVideo.htm?video='+videoList[i].videoId+'" class="fancybox"><img src="${BASE_PATH}/'+videoList[i].videoPosterpath+'" class="videos-img" alt=""><div class="videos-overlay"><span class="video-play-span">- 播放 -</span></div></a></div><p class="video-title"><a data-fancybox-type="iframe" href="${BASE_PATH}/front/video/playVideo.htm?video='+videoList[i].videoId+'" class="fancybox">'+videoList[i].videoName+'</a></p></div>';
                        }
                        $('.videos-list').html(htmlStr);
                    }
                });
            }

            function updateVideoList(){
                var catlogId = $('.videos-filter>ul>li.active').attr("name");
                var catlogName = $('.videos-filter>ul>li.active').data ("name");
                var catlogDesc = $('.videos-filter>ul>li.active').data ("desc");
                $('#update_catlogId').attr('value',catlogId);
                $('#update_catlogName').attr('value',catlogName);
                $('#update_catlogDesc').attr('value',catlogDesc);
                var confimrStr = $("#updateVideoListBootbox").html();
                $("#updateVideoListBootbox").html('');
                bootbox.confirm({
                    title:"修改相册",
                    message:confimrStr, 
                    callback:function(result) {
                        if (result) {
                            var options = {
                                dataType : 'json',
                                success : function(data) {
                                    if (data.result) {
                                        toastr.success(data.msg);
                                        //刷新视频分类信息
                                        getVideoList(data.t);
                                    } else {
                                        toastr.error(data.errors['error']);
                                    }
                                }
                            };
                            $("#updateVideoListForm").ajaxSubmit(options);
                            $("#updateVideoListBootbox").html(confimrStr);
                        } else {
                            $("#updateVideoListBootbox").html(confimrStr);
                        }
                    }
                });
            }

           

            function deleteVideo(videoId,videoName){
                bootbox.confirm("<h4>确认删除视频<b>" + videoName + "</b>吗？</h4>", function(result) {
                    if (result) {
                        var options = {
                            url: "${BASE_PATH}/manage/video/deleteVideo.json",
                            data: {
                                'videoId': videoId
                            },
                            method: 'post',
                            dataType: 'json',
                            success: function(data) {
                                if (data.result) {
                                    toastr.success(data.msg);
                                    setTimeout("window.location.reload();",1000);
                                } else {
                                    toastr.error(data.errors['error']);
                                }
                            }
                        };
                        $.ajax(options);
                    }
                });
            }

            function newVideoList() {
                var confimrStr = $("#newVideoListBootbox").html();
                $("#newVideoListBootbox").html('');
                bootbox.confirm({
                    title:"新建相册",
                    message:confimrStr, 
                    callback:function(result) {
                        if (result) {
                            var options = {
                            	dataType : 'json',
    							success : function(data) {
    								if (data.result) {
    									toastr.success(data.msg);
                                        //刷新视频分类信息
    									getVideoList(data.t);
                                        //刷新视频分类下视频信息
                                        getVideos(data.t);
    								} else {
    									toastr.error(data.errors['error']);
    								}
    							}
    						};
                            $("#newVideoListForm").ajaxSubmit(options);
                            $("#newVideoListBootbox").html(confimrStr);
                        } else {
                            $("#newVideoListBootbox").html(confimrStr);
                        }
                    }
                });
            }

            function uploadVideos() {
                var catlogId = $('.videos-filter>ul>li.active').attr("name");
                bootbox.alert({
                    title: "上传视频",
                    message: "<div id='upload'></div>",
                    buttons: {
                        ok: {
                            label: '确认'
                        }
                    },
                    callback: function() {
                        toastr.info("视频压缩处理中,请稍后查看!");
                    }
                });
                var up = $('#upload').html5uploader({
                    auto: true,
                    fileTypeExts: '*.mp4;*.wmv;*.flv;*.MP4;*.WMV;*.FLV',
                    multi: true,
                    formData: {
                        'catlogId': catlogId
                    },
                    fileSizeLimit: 2048000, //允许上传的文件大小，单位KB
                    uploader: '${BASE_PATH}/manage/video/upload.json'
                });
            }
            </script>
            </body>

            </html>
