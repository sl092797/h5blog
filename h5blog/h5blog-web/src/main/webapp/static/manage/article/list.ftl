<#assign menu="article">
    <#assign submenu="article_list">
        <#include "/manage/head.ftl">
            <style type="text/css">
            .pagination {
                border-radius: 4px;
                display: inline-block;
                margin: 0;
                padding-left: 0;
            }
            
            .howto,
            .nonessential,
            #edit-slug-box,
            .form-input-tip,
            .subsubsub {
                color: #666666;
            }
            
            .subsubsub {
                float: left;
                font-size: 12px;
                list-style: none outside none; 
                margin: 8px 0 5px;
                padding: 0;
            }
            
            .form-group {
                width: 100%;
            }
            
            .count {
                position: absolute;
                right: 0px;
            }
            
            .arrticle_status {
                float: left;
            }
            </style>
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <#if SESSION_ADMIN.isAdmin>
                        <div class="row">
                            <div class="col-lg-12">
                                <!--breadcrumbs start -->
                                <ul class="breadcrumb">
                                    <li>
                                        <a href="${BASE_PATH}/manage/article/list.htm">全部文章</a>
                                    </li>
                                    <li>
                                        <a href="${BASE_PATH}/manage/article/list.htm?check=init">未审核</a>
                                    </li>
                                    <li>
                                        <a href="${BASE_PATH}/manage/article/list.htm?check=no">审核退回</a>
                                    </li>
                                </ul>
                                <!--breadcrumbs end -->
                            </div>
                        </div>
                    </#if>
                    <!-- page start-->
                    <section class="panel">
                        <header class="panel-heading">
                            <div class="row">
                                <div class="col-sm-10">
                                    <a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/article/add.htm?">增加文章</a>
                                </div>
                            </div>
                        </header>
                        <div class="panel-body">
                            <div class="adv-table">
                                <div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                                    <table class="table table-striped table-advance table-hover">
                                        <thead>
                                            <tr>
                                                <th>文章名称</th>
                                                <th>最后更新时间</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody role="alert" aria-live="polite" aria-relevant="all">
                                            <#list pageVo as e>
                                                <tr class="gradeA odd">
                                                    <td>
                                                        <#if e.desc??>${e.desc}</#if>
                                                    </td>
                                                    <td>
                                                        <#if e.changeDate??>${e.changeDate?string("yyyy-MM-dd")}
                                                        </#if>
                                                    </td>
                                                    <td>
                                                        <!-- Icons -->
                                                        <a href="${BASE_PATH}/manage/article/update.htm?articleId=${e.id}" title="修改">
                  								编辑
                  							</a> |
                                                        <a href="javascript:void(0);" class="js_article_delete" articleId="${e.id}" title="是否删除文章">
                  								删除
                  							</a> |
                                                        <a href="${BASE_PATH}/manage/article/preview.htm?articleId=${e.id}" target="_blank">
                  								预览
                  							</a>
                                                    </td>
                                                </tr>
                                            </#list>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </section>
                    <!-- page end-->
                </section>
            </section>
            <!--main content end-->
            <script>
            $(function() {
                $('.js_article_delete').click(function() {
                    var articleId = $(this).attr('articleId');
                    var status = "trash";
                    bootbox.dialog({
                        message: $(this).attr('title'),
                        title: "提示",
                        buttons: {
                            "delete": {
                                label: "确定",
                                className: "btn-success",
                                callback: function() {
                                    $.post("${BASE_PATH}/manage/article/delete.json", {
                                        "articleId": articleId
                                    }, function(data) {
                                        window.location.reload();
                                    }, "json");
                                }
                            },
                            "cancel": {
                                label: "取消",
                                className: "btn-primary",
                                callback: function() {

                                }
                            }
                        }
                    });
                });
            });
            </script>
            <#include "/manage/foot.ftl">
