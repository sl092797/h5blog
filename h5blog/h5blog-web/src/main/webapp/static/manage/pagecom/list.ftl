<#assign menu="pagecom">
    <#assign submenu="pagecom_list">
        <#include "/manage/head.ftl">
            <style type="text/css">
            .pagination {
                border-radius: 4px;
                display: inline-block;
                margin: 0;
                padding-left: 0;
            }
            .drophover {
            	background-color: #CCCCCC;
            }
            </style>
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <!-- page start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <!--breadcrumbs start -->
                            <ul class="breadcrumb">
                                <li><a href="${BASE_PATH}/manage/folder/list.htm?folderId=0"><i
							class="icon-home"></i> 根目录</a></li>
                            </ul>
                            <!--breadcrumbs end -->
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <section class="panel">
                                <header class="panel-heading">
                                    组件分类
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
                                <header class="panel-heading">
                                	组件管理
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
                                                    <#list pageVo as e>
                                                        <tr class="gradeA odd" data-dataid="${e.id}">
                                                            <td>
                                                                <#if e.desc??>${e.desc}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.pageCom.desc??>${e.pageCom.desc}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.pageCom.type??>${e.pageCom.type}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.aval??>${e.aval}</#if>
                                                            </td>
                                                            <td>
                                                                <!-- Icons -->
                                                                <a href="javascript:editPageComDef(${e.id})" title="编辑" >
                                                                    <button class="btn btn-primary btn-xs">
                                                                        <i class="icon-edit"></i>
                                                                    </button>
                                                                </a>
                                                                <a href="javascript:updateVal(${e.id},${e.pageCom.id})" title="设置" style="margin-left: 0.2em;">
                                                                    <button class="btn btn-primary btn-xs">
                                                                        <i class="icon-cog"></i>
                                                                    </button>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </#list>
                                                </tbody>
                                            </table>
                                            <div style="height: 30px;">
                                                <div class="pagination"> </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-3">
                                                <a class="btn btn-primary" href="${BASE_PATH}/manage/pagecom/upload.htm">增加组件模板</a>
                                            </div>
                                            <div class="col-sm-3">
                                                <a class="btn btn-primary" href="${BASE_PATH}/manage/pagecom/chooseCom.htm">增加组件定义</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                    <link rel="stylesheet" type="text/css" href="${BASE_PATH}/static/manage/css/bootstrap-treeview.css?v=${config_v}" />
                    <script src="${BASE_PATH}/static/manage/js/bootstrap-treeview.js?v=${config_v}"></script>
                    <!-- page end-->
                </section>
                <!-- modal start-->
                <div class="modal fade" id="ADD_CATLOG" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel">新增目录</h4>
                            </div>
                            <div class="modal-body">
                                <form id="add_catlog_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/catlog/addCatlog.json?type=pagecom">
                                    <fieldset>
                                        <input type="hidden" id="parentId" name="parentId" />
                                        <div class="form-group">
                                            <label class="col-sm-6 control-label">目录名称</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="name" placeholder="" id="name">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label"></label>
                                            <button class="btn btn-danger" type="submit">确认</button>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <div class="modal fade" id="UPDATE_CATLOG" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title">修改目录</h4>
                            </div>
                            <div class="modal-body">
                                <form id="update_catlog_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/catlog/updateCatlog.json?type=pagecom">
                                    <fieldset>
                                        <input type="hidden" id="uid" name="id" />
                                        <div class="form-group">
                                            <label class="col-sm-6 control-label">目录名称</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="name" id="uname">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label"></label>
                                            <button class="btn btn-danger" type="submit">确认</button>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <div class="modal fade" id="UPDATE_PAGECOMDEF" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title">修改组件</h4>
                            </div>
                            <div class="modal-body">
                                <form id="update_pageComDef_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/pagecom/updatePageComDef.json">
                                    <fieldset>
                                        <input type="hidden" id="upid" name="id" />
                                        <div class="form-group">
                                            <label class="col-sm-6 control-label">组件名称</label>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control" name="desc" id="upname">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 col-sm-2 control-label"></label>
                                            <button class="btn btn-danger" type="submit">确认</button>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.modal -->
                <input type="hidden" id="catlogId" name="catlogId" />
                <!--main content end-->
                <script src="${BASE_PATH}/static/manage/pagecom/list.js?v=${config_v}"></script>
                <script type="text/javascript">
                	var CONTEXT = '${BASE_PATH}';
                </script>
                <#include "/manage/foot.ftl">
