<#assign menu="file">
    <#include "/manage/head.ftl">
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
                                                        <th class="col-sm-3">组件定义</th>
                                                        <th class="col-sm-3">模板描述</th>
                                                        <th class="col-sm-2">模板类型</th>
                                                        <th class="col-sm-2">是否可用</th>
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
                                                <a class="btn btn-primary" href="${BASE_PATH}/manage/pagecom/upload.htm">上传文件</a>
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
        <input type="hidden" id="catlogId" name="catlogId" />
        <div id="newFileCatlogBootbox" style="display: none">
            <form id="newFileCatlogForm" action="${BASE_PATH}/manage/file/newCatlog.json" method='post' class="form-horizontal">
                <input type="hidden" id="parentId" name="parentId" />
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
        <#include "/manage/foot.ftl">
         <link rel="stylesheet" type="text/css" href="${BASE_PATH}/css/bootstrap-treeview.css" />
        <script src="${BASE_PATH}/js/bootstrap-treeview.js"></script>
            <script>
            $(function() {
                buildTree();
            });

             function buildTree() {
                 $.ajax({
                     type: "post",
                     dataType: 'json',
                     url:"${BASE_PATH}/manage/file/getTree.json",
                     success: function(data) {
                        console.log(data);
                         var catlogTree = [];
                         var obj = {
                             id: data.catlogId,
                             text: data.catlogName,
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
                                 $("#uid").val(node.id);
                                 $("#catlogId").val(node.id);
                                 $("#uname").attr("placeholder", node.text);
                                 // refreshRightForm(node.id);
                             },
                         };
                         console.log(options);
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
                     };
                     if (child.child) {
                         obj.nodes = [];
                         walkNode(child.child, obj.nodes);
                     }
                     nodes.push(obj);
                 });
             }

             function addcatlog() {
                 var confimrStr = $("#newFileCatlogBootbox").html();
                $("#newFileCatlogBootbox").html('');
                bootbox.confirm({
                    title:"新增目录",
                    message:confimrStr, 
                    callback:function(result) {
                        if (result) {
                            var options = {
                                dataType : 'json',
                                success : function(data) {
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
                 $('#UPDATE_CATLOG').modal('show');
             }

             function deletecatlog() {
                 bootbox.confirm("是否要删除目录？", function(result) {
                     if (result) {
                         $.post(CONTEXT + "/manage/file/deleteCatlog.json", {
                                 'id': $("#catlogId").val()
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
            </script>
            </body>

        </html>
