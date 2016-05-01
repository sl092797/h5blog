<#assign menu="photo">
    <#include "/manage/head.ftl">
        <div class="main-container">
            <div class="padding-md">
                <h2 class="header-text no-margin">
						画廊管理
					</h2>
                <a href="javascript:newGallery();" class="btn btn-primary" style="margin:1em 2em;float:right;">新建相册</a>
                <div class="gallery-filter m-top-md">
                    <ul class="clearfix">
                        <!-- <li class="active"><a href="#">All</a></li>
                        <li><a href="#">Albums</a></li>
                        <li><a href="#">Friends</a></li>
                        <li><a href="#">Trips</a></li> -->
                        <li><a href="#"></a></li>
                    </ul>
                </div>
                <div class="gallery-list m-top-md">
                   

                </div>
                <!-- ./gallery-list -->
            </div>
            <!-- ./padding-md -->
        </div>
        <!-- /main-container -->
        </div>
        <!-- /wrapper -->
        <div id="newGalleryBootbox" style="display: none">
            <form id="newGalleryForm" action="${BASE_PATH}/manage/photo/newGallery.json" method='post' class="form-horizontal">
                <div class="row">
                    <label class="col-sm-3 control-label">相册名称</label>
                    <div class="col-sm-6">
                        <input type='text' id='galleryName' name='galleryName' class='form-control' placeholder='相册名称' />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-3 control-label">相册描述</label>
                    <div class="col-sm-6">
                        <input type="text" id="galleryDesc" name="galleryDesc" class="form-control" placeholder="相册描述" />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-3 control-label">相册标签</label>
                    <div class="col-sm-6">
                        <input type="text" id="galleryTag" name="galleryTag" class="form-control" placeholder="相册标签" />
                    </div>
                </div>
            </form>
        </div>
        <#include "/manage/foot.ftl">
            <script>
            $(function() {

                $('.gallery-item').bind('touchstart', function(e) {
                    $(this).siblings().removeClass('active');
                    $(this).addClass('active');
                });

                getGallerys();

            });

            function getGallerys(){
            	$.post("${BASE_PATH}/manage/photo/getGallerys.json",{},function(data){
            		if(data.result){
            			var htmlStr='';
            			for(index in data.t){
            				var gallery = data.t[index];
            				htmlStr += ' <div class="gallery-item"><div class="gallery-wrapper"><a class="gallery-remove" href="javascript:deleteGallery('+gallery.catlogId+',\''+gallery.catlogName+'\');"><i class="fa fa-times"></i></a>';
            				if(gallery.coverFilePath!=undefined){
            					htmlStr += '<img class="gallery-img" src="${BASE_PATH}/'+gallery.coverFilePath+'" alt="">';
            				}else{
            					htmlStr += '<img class="gallery-img" src="${BASE_PATH}/images/gallery/default.jpg" alt="新相册">';
            				}
            				htmlStr +='<div class="gallery-title"><a href="${BASE_PATH}/manage/photo/photoList.htm?galleryId='+gallery.catlogId+'">'+gallery.catlogName+'</a></div><div class="gallery-overlay"><a href="${BASE_PATH}/manage/photo/photoList.htm?galleryId='+gallery.catlogId+'" class="gallery-action enlarged-photo"><i class="fa fa-plus fa-lg"></i></a></div></div></div>';
            			}
            			$(".gallery-list").html(htmlStr);
            		}
            	});
            	
            }

            function newGallery() {
                var confimrStr = $("#newGalleryBootbox").html();
                $("#newGalleryBootbox").html('');
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
    									getGallerys();
    								} else {
    									toastr.error(data.errors['error']);
    								}
    							}
    						};
                            $("#newGalleryForm").ajaxSubmit(options);
                            $("#newGalleryBootbox").html(confimrStr);
                        } else {
                            $("#newGalleryBootbox").html(confimrStr);
                        }
                    }
                });
            }

            function deleteGallery(catlogId,catlogName){
                bootbox.confirm("<h4>确认删除相册<b>"+catlogName+"</b>吗？</h4>", function(result) {
                    if (result) {
                        var options = {
                            url:"${BASE_PATH}/manage/photo/deleteGallery.json",
                            data:{'galleryId':catlogId},
                            method:'post',
                            dataType : 'json',
                            success : function(data) {
                                if (data.result) {
                                    toastr.success(data.msg);
                                    getGallerys();
                                } else {
                                    toastr.error(data.errors['error']);
                                }
                            }
                        };
                        $.ajax(options);
                    } 
                });
            }

            </script>
            </body>

            </html>
