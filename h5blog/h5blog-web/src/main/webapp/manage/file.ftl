<#assign menu="file">
    <#include "/manage/head.ftl">
        <style type="text/css">
        .drophover {
            background-color: #CCCCCC;
        }
        </style>
        <div class="main-container">
            <div class="padding-md">
                <h2 class="header-text no-margin">
                    文件管理
                </h2>
                <div class="row" style="margin-top: 1em;">
                    <div class="col-sm-4">
                        <section class="panel">
                            <header class="panel-heading" style="font-size: 20px;">
                                文件分类
                            </header>
                            <div class="panel-body">
                                <div class="form-group">
                                    <div id="tree"></div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        <button class="btn btn-primary" type="button" onclick="addcatlog()">新增目录</button>
                                    </div>
                                    <div class="col-sm-4">
                                        <button class="btn btn-primary" type="button" onclick="updatecatlog()">修改目录</button>
                                    </div>
                                    <div class="col-sm-4">
                                        <button class="btn btn-primary" type="button" onclick="deletecatlog()">删除目录</button>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="col-sm-8">
                        <section class="panel">
                            <header class="panel-heading" style="font-size: 20px;">
                                文件列表
                                <a href="javascript:listUnsorted()" class="btn btn-primary" style="float:right">未分类</a>
                            </header>
                            <div class="panel-body">
                                <div class="adv-table">
                                    <div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                                        <table class="table table-striped table-advance table-hover">
                                            <thead>
                                                <div id="testdd">
                                                    <tr>
                                                        <th class="col-sm-3">文件名称</th>
                                                        <th class="col-sm-3">文件描述</th>
                                                        <th class="col-sm-2">文件大小</th>
                                                        <th class="col-sm-2">操作</th>
                                                    </tr>
                                                </div>
                                            </thead>
                                            <tbody id="tbody" role="alert" aria-live="polite" aria-relevant="all">
                                            </tbody>
                                        </table>
                                        <div style="height: 30px;">
                                            <div class="pagination"> </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3">
                                            <a class="btn btn-primary" href="javascript:uploadFiles();">上传文件</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
        </div>
        <input type="hidden" id="catlogId" />
        <input type="hidden" id="catlogName" />
        <div id="newFileCatlogBootbox" style="display: none">
            <form id="newFileCatlogForm" action="${BASE_PATH}/manage/file/newCatlog.json" method='post' class="form-horizontal">
                <input type="hidden" id="parentId" name="parentId" />
                <div class="row">
                    <label class="col-sm-3 control-label">分类名称</label>
                    <div class="col-sm-6">
                        <input type='text' name='catlogName' class='form-control' placeholder='分类名称' />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-3 control-label">分类描述</label>
                    <div class="col-sm-6">
                        <input type="text" name="catlogDesc" class="form-control" placeholder="分类描述" />
                    </div>
                </div>
            </form>
        </div>
        <div id="updateFileCatlogBootbox" style="display: none">
            <form id="updateFileCatlogForm" action="${BASE_PATH}/manage/file/updateCatlog.json" method='post' class="form-horizontal">
                <input type="hidden" id="ucatlogId" name="ucatlogId" />
                <div class="row">
                    <label class="col-sm-3 control-label">分类名称</label>
                    <div class="col-sm-6">
                        <input type='text' id="ucatlogName" name='ucatlogName' class='form-control' placeholder='分类名称' />
                    </div>
                </div>
                <div class="row">
                    <label class="col-sm-3 control-label">分类描述</label>
                    <div class="col-sm-6">
                        <input type="text" id="ucatlogDesc" name="ucatlogDesc" class="form-control" placeholder="分类描述" />
                    </div>
                </div>
            </form>
        </div>
        <div class="modal fade" id="update_file" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                            &times;
                        </button>
                        <h4 class="modal-title">修改文件描述</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" autocomplete="off" action="">
                            <input type="text" id="ufileId" hidden="true">
                            <label class="col-sm-3 control-label">文件描述</label>
                            <div class="col-sm-6">
                                <input type='text' id="ufileDesc" class='form-control' />
                            </div>
                        </form>
                        <button class="btn btn-danger" id="updateFileButton">确认</button>
                    </div>
                </div>
            </div>
        </div>
        <#include "/manage/foot.ftl">
            <link rel="stylesheet" type="text/css" href="${BASE_PATH}/css/bootstrap-treeview.css" />
            <script src="${BASE_PATH}/js/bootstrap-treeview.js"></script>
            <script>
            $(function() {
                $("tbody").sortable({
                    items: "> tr",
                    appendTo: "parent",
                    helper: "clone"
                }).disableSelection();
                buildTree();
                $('#updateFileButton').bind("click", function() {
                    $.ajax({
                        url: "${BASE_PATH}/manage/file/updateFile.json",
                        data: {
                            'ufileDesc': $('#ufileDesc').val(),
                            'ufileId': $('#ufileId').val(),
                        },
                        method: 'post',
                        dataType: 'json',
                        success: function(data) {
                            if (data.result) {
                                toastr.success(data.msg);
                                refreshRightForm($("#catlogId").val());
                            } else {
                                toastr.error(data.errors['error']);
                            }
                        }
                    });
                    $('#update_file').modal('hide');
                })
            });

            function listUnsorted() {
                refreshRightForm(null);
            }

            function buildTree() {
                $.ajax({
                    type: "post",
                    dataType: 'json',
                    url: "${BASE_PATH}/manage/file/getTree.json",
                    success: function(data) {
                        console.log(data);
                        var catlogTree = [];
                        var obj = {
                            id: data.catlogId,
                            text: data.catlogName,
                            desc: data.catlogDesc
                        };
                        if (data.child) {
                            obj.nodes = [];
                            walkNode(data.child, obj.nodes);
                        }
                        catlogTree.push(obj);

                        var options = {
                            bootstrap2: false,
                            showTags: true,
                            levels: 3,
                            data: catlogTree,
                            onNodeSelected: function(event, node) {
                                $("#parentId").val(node.id);
                                $("#catlogId").val(node.id);
                                $("#catlogName").val(node.text);
                                $("#ucatlogId").val(node.id);
                                $("#ucatlogName").attr("placeholder", node.text);
                                $("#ucatlogDesc").attr("placeholder", node.desc);
                                refreshRightForm(node.id);
                            },
                            onRenderCallback: treeDroppable
                        };
                        $('#tree').treeview(options);
                    }
                });
            }

            function walkNode(childs, nodes) {
                if (!childs) {
                    return;
                }
                $.each(childs, function(index, child) {
                    var obj = {
                        id: child.catlogId,
                        text: child.catlogName,
                        desc: child.catlogDesc
                    };
                    if (child.child) {
                        obj.nodes = [];
                        walkNode(child.child, obj.nodes);
                    }
                    nodes.push(obj);
                });
            }

            function treeDroppable() {
                $("#tree>ul>li").droppable({
                    hoverClass: "drophover",
                    tolerance: "pointer",
                    drop: function(e, ui) {
                        var catlogId = $(e.target).data('dataid');
                        var fildId = $(ui.draggable[0]).data('dataid');
                        changeCatlog(fildId, catlogId);
                        $(ui.draggable[0]).remove();
                    }
                });
            }

            function changeCatlog(fid, cid) {
                bootbox.confirm("是否要移动目录？", function(result) {
                    if (result) {
                        $.post("${BASE_PATH}/manage/file/changeFileCatlog.json", {
                                'fid': fid,
                                'cid': cid
                            },
                            function(data) {
                                if (data.result) {} else {
                                    for (var i in data.errors) {
                                        bootbox.alert(data.errors[i]);
                                    }
                                }
                            },
                            "json");
                    }
                });
            }


            function addcatlog() {
                var confimrStr = $("#newFileCatlogBootbox").html();
                $("#newFileCatlogBootbox").html('');
                bootbox.confirm({
                    title: "新增目录",
                    message: confimrStr,
                    callback: function(result) {
                        if (result) {
                            var options = {
                                dataType: 'json',
                                success: function(data) {
                                    if (data.result) {
                                        toastr.success(data.msg);
                                        buildTree();
                                    } else {
                                        toastr.error(data.errors['error']);
                                    }
                                }
                            };
                            $("#newFileCatlogForm").ajaxSubmit(options);
                            $("#newFileCatlogBootbox").html(confimrStr);
                        } else {
                            $("#newFileCatlogBootbox").html(confimrStr);
                        }
                    }
                });
            }

            function updatecatlog() {
                var confimrStr = $("#updateFileCatlogBootbox").html();
                $("#updateFileCatlogBootbox").html('');
                bootbox.confirm({
                    title: "修改目录",
                    message: confimrStr,
                    callback: function(result) {
                        if (result) {
                            var options = {
                                dataType: 'json',
                                success: function(data) {
                                    if (data.result) {
                                        toastr.success(data.msg);
                                        buildTree();
                                    } else {
                                        toastr.error(data.errors['error']);
                                    }
                                }
                            };
                            $("#updateFileCatlogForm").ajaxSubmit(options);
                            $("#updateFileCatlogBootbox").html(confimrStr);
                        } else {
                            $("#updateFileCatlogBootbox").html(confimrStr);
                        }
                    }
                });
            }

            function deletecatlog() {
                bootbox.confirm("是否要删除目录？" + $("#catlogName").val(), function(result) {
                    if (result) {
                        $.post("${BASE_PATH}/manage/file/deleteCatlog.json", {
                                'catlogId': $("#catlogId").val()
                            },
                            function(data) {
                                if (data.result) {
                                    buildTree();
                                } else {
                                    for (var i in data.errors) {
                                        bootbox.alert(data.errors[i]);
                                    }
                                }
                            },
                            "json");
                    }
                });
            }

            function editFileDesc(fileId) {
                $('#update_file').modal('show');
                $('#ufileId').val(fileId);
            }

            function deleteFile(fileId, fileName) {
                bootbox.confirm("是否要删除文件？" + fileName, function(result) {
                    if (result) {
                        $.post("${BASE_PATH}/manage/file/deleteFile.json", {
                                'fileId': fileId
                            },
                            function(data) {
                                if (data.result) {
                                    toastr.success(data.msg);
                                    refreshRightForm($("#catlogId").val());
                                } else {
                                    for (var i in data.errors) {
                                        bootbox.alert(data.errors[i]);
                                    }
                                }
                            },
                            "json");
                    }
                });
            }

            function uploadFiles() {
                bootbox.alert({
                    title: "上传文件",
                    message: "<div id='upload'></div>",
                    buttons: {
                        ok: {
                            label: '确认'
                        }
                    },
                    callback: function() {
                        refreshRightForm($("#catlogId").val());
                    }
                });
                var up = $('#upload').html5uploader({
                    auto: true,
                    multi: true,
                    formData: {
                        'catlogId': $("#catlogId").val()
                    },
                    fileSizeLimit: 1024000, //允许上传的文件大小，单位KB
                    uploader: '${BASE_PATH}/manage/file/upload.json'
                });
            }

            function refreshRightForm(catlogId) {
                $.ajax({
                    type: "post",
                    dataType: 'json',
                    data: {
                        'catlogId': catlogId == "" ? 0 : catlogId
                    },
                    url: "${BASE_PATH}/manage/file/listFileByCatlog.json",
                    success: function(result) {
                        var data = result.t;
                        var htmlstr = "";
                        for (var i in data) {
                            htmlstr += "<tr class='gradeA odd' data-dataid='" + data[i]['fileId'] + "'>";
                            htmlstr += "<td>" + data[i]['fileName'] + "</td>";
                            htmlstr += "<td>" + (data[i]['fileDesc'] != null ? data[i]['fileDesc'] : '') + "</td>";
                            htmlstr += "<td>" + data[i]['fileSize'] + "KB</td>";
                            htmlstr += "<td>" +
                                "<a href='javascript:editFileDesc(" + data[i]['fileId'] + ")' >" +
                                "<button class='btn btn-primary btn-xs'>" +
                                "<i class='fa fa-edit'></i>" +
                                " 修改</button>" +
                                "</a>";
                            htmlstr +=
                                "<a href='javascript:deleteFile(" + data[i]['fileId'] + ",\"" + data[i]['fileName'] + "\")' style='margin-left:0.5em;'>" +
                                "<button class='btn btn-primary btn-xs'>" +
                                "<i class='fa fa-trash-o'></i>" +
                                " 删除</button>" +
                                "</a></td></tr>";
                        }
                        $("#tbody").html(htmlstr);
                    }
                });
            }
            </script>
            </body>

            </html>
