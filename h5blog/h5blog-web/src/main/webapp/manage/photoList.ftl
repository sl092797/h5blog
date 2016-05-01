<#assign menu="photo">
    <#include "/manage/head.ftl">
        <div class="main-container">
            <div class="padding-md">
                <div class="header-text no-margin">
                    <h2 class="margin-xs">
                    ${galleryVo.catlogName!}
                </h2>
                    <h3 class="margin-xs">
                    ${galleryVo.catlogDesc!}
                </h3>
                </div>
                <a href="javascript:uploadPhotos();" class="btn btn-primary" style="margin:1em 1em;float:right;">上传相片</a>
                <a href="javascript:updateGallery();" class="btn btn-primary" style="margin:1em 0em;float:right;">修改相册</a>
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
                    <#list galleryVo.photoList as photo>
                        <div class="gallery-item">
                            <div class="gallery-wrapper">
                                <a class="gallery-remove" href="javascript:deletePhoto(${photo.photoId},'${photo.photoName!}');"><i class="fa fa-times"></i></a>
                                <img src="${BASE_PATH}/${photo.photoPath}" class="gallery-img" alt="">
                                <div class="gallery-overlay">
                                    <a rel="gallery1" href="${BASE_PATH}/${photo.photoPath}" class="gallery-action enlarged-photo fancybox"><i class="fa fa-search-plus fa-lg"></i></a>
                                    <h3 style="position: relative;top:-3em;color:white;">
                                        ${photo.photoName!}
                                    </h3>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
                <!-- ./gallery-list -->
            </div>
            <!-- ./padding-md -->
        </div>
        <!-- /main-container -->
        </div>
        <!-- /wrapper -->
        <div id="newPhotoBootbox" style="display: none">
        </div>
        </div>
        <#include "/manage/foot.ftl">
            <script>
            var galleryId = ${
                galleryVo.catlogId
            };
            $(function() {

                $('.gallery-item').bind('touchstart', function(e) {
                    $(this).siblings().removeClass('active');
                    $(this).addClass('active');
                });

                // getPhotos();
                $(".fancybox").fancybox({
                    padding: 10,
                    helpers: {
                        overlay: {
                            locked: false
                        }
                    }
                });

            });

            function getPhotos(galleryId) {
                $.post("${BASE_PATH}/manage/photo/getPhotos.json", {
                    'galleryId': galleryId
                }, function(data) {
                    if (data.result) {
                        var htmlStr = '';
                        for (index in data.t) {
                            var photo = data.t[index];
                            htmlStr += ' <div class="gallery-item"><div class="gallery-wrapper"><a class="gallery-remove" href="javascript:deletePhoto(' + photo.photoId + ',\'' + photo.photoName + '\');"><i class="fa fa-times"></i></a>';
                            htmlStr += '<img src="${BASE_PATH}/' + photo.photoPath + '" alt="">';
                            htmlStr += '<div class="gallery-overlay"><a href="${BASE_PATH}/' + photo.photoPath + '" class="gallery-action enlarged-photo"><i class="fa fa-search-plus fa-lg"></i></a><h3 style="position:relative;top:-3em;color:white;">' + photo.photoName + '</h3></div></div></div>';
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
                    }
                });

            }


            function deletePhoto(photoId, photoName) {
                bootbox.confirm("<h4>确认删除相片<b>" + photoName + "</b>吗？</h4>", function(result) {
                    if (result) {
                        var options = {
                            url: "${BASE_PATH}/manage/photo/deletePhoto.json",
                            data: {
                                'photoId': photoId
                            },
                            method: 'post',
                            dataType: 'json',
                            success: function(data) {
                                if (data.result) {
                                    toastr.success(data.msg);
                                    getPhotos(galleryId);
                                } else {
                                    toastr.error(data.errors['error']);
                                }
                            }
                        };
                        $.ajax(options);
                    }
                });
            }

            function uploadPhotos() {
                bootbox.alert({
                    title: "上传相片",
                    message: "<div id='upload'></div>",
                    buttons: {
                        ok: {
                            label: '确认'
                        }
                    },
                    callback: function() {
                        setTimeout("window.location.reload();",1000);
                    }
                });
                var up = $('#upload').html5uploader({
                    auto: true,
                    fileTypeExts: '*.png;*.PNG;*.jpg;*.JPG;*.jpeg;*.JPEG',
                    multi: true,
                    formData: {
                        'galleryId': galleryId
                    },
                    fileSizeLimit: 10240, //允许上传的文件大小，单位KB
                    uploader: '${BASE_PATH}/manage/photo/upload.json'
                });
            }

            function updateGallery(){
                bootbox.confirm({
                    title: "修改相册",
                    message: '<form id="updateGalleryForm" action="${BASE_PATH}/manage/photo/updateGallery.json?galleryId='+galleryId+'" method="post" class="form-horizontal"><div class="row"><label class="col-sm-3 control-label">相册名称</label><div class="col-sm-6"><input type="text" id="galleryName" name="galleryName" class="form-control" placeholder="${galleryVo.catlogName!}" /></div></div><div class="row"><label class="col-sm-3 control-label">相册描述</label><div class="col-sm-6"><input type="text" id="galleryDesc" name="galleryDesc" class="form-control" placeholder="${galleryVo.catlogDesc!}" /></div></div><div class="row"><label class="col-sm-3 control-label">相册标签</label><div class="col-sm-6"><input type="text" id="galleryTag" name="galleryTag" class="form-control" placeholder="${galleryVo.catlogTag!}" /></div></div></form>',
                    callback: function(result) {
                        if (result) {
                            var options = {
                                dataType : 'json',
                                success : function(data) {
                                    if (data.result) {
                                        toastr.success(data.msg);
                                        window.location.reload();
                                    } else {
                                        toastr.error(data.errors['error']);
                                    }
                                }
                            };
                            $("#updateGalleryForm").ajaxSubmit(options);
                        }
                    }
                });
            }
            </script>
            </body>
            </html>
