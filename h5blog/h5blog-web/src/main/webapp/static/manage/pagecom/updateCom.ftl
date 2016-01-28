<#assign menu="pageCom">
    <#assign submenu="update_com">
        <#include "/manage/head.ftl">
            <style type="text/css">

            </style>
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <!-- page start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    <div class="row">
                                        <div class="col-lg-4">
                                            修改组件模板
                                        </div>
                                        <div class="col-lg-12">
                                            <a class="btn btn-danger" style="float:right;" onclick="resetPwd();">重置</a>
                                        </div>
                                    </div>
                                </header>
                                <div class="panel-body">
                                    <form id="update_com_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/pagecom/updateCom.json">
                                        <fieldset>
                                            <#if pageCom.id??>
                                                <input type="hidden" name="id" value="${pageCom.id}" />
                                            </#if>
                                            <#if pageCom.ftlPath??>
                                                <input type="hidden" name="ftlPath" value="${pageCom.ftlPath}" />
                                            </#if>
                                            <#if pageCom.createUser??>
                                                <input type="hidden" name="createUser" value="${pageCom.createUser}" />
                                            </#if>
                                            <#if pageCom.createDate??>
                                                <input type="hidden" name="createDate" value="${pageCom.createDate}" />
                                            </#if>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">组件模板名称</label>
                                                <div class="col-sm-4">
                                                    <#if pageCom.name??>
                                                        <input type="text" class="form-control" name="name" placeholder="" id="name" value="${pageCom.name}">
                                                        <#else>
                                                            <input type="text" class="form-control" name="name" placeholder="" id="name" value="">
                                                    </#if>
                                                </div>
                                                <label class="col-sm-2 control-label">组件模板描述</label>
                                                <div class="col-sm-4">
                                                    <#if pageCom.desc??>
                                                        <input type="text" class="form-control" name="desc" placeholder="" id="desc" value="${pageCom.desc}">
                                                        <#else>
                                                            <input type="text" class="form-control" name="desc" placeholder="" id="desc" value="">
                                                    </#if>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">组件模板类型</label>
                                                <div class="col-sm-4">
                                                    <#if pageCom.type??>
                                                        <input type="text" class="form-control" name="type" placeholder="" id="type" value="${pageCom.type}">
                                                        <#else>
                                                            <input type="text" class="form-control" name="type" placeholder="" id="type" value="">
                                                    </#if>
                                                </div>
                                                <label class="col-sm-2 control-label">组件模板上下文</label>
                                                <div class="col-sm-4">
                                                    <#if pageCom.context??>
                                                        <input type="text" class="form-control" name="context" placeholder="" id="context" value="${pageCom.context}">
                                                        <#else>
                                                            <input type="text" class="form-control" name="context" placeholder="" id="context" value="">
                                                    </#if>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-2 control-label"></label>
                                                <button class="btn btn-danger" type="submit">修改</button>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>
                            </section>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
            </section>
            <!--main content end-->
            <script type="text/javascript">
            $(function() {
                $('#update_com_form').ajaxForm({
                    dataType: 'json',
                    success: function(data) {
                        if (data.result) {
                            bootbox.alert("保存成功，将刷新页面", function() {
                                window.location.href = "${BASE_PATH}/manage/pagecom/updateCom.htm?pageComId=${pageCom.id}";
                            });
                        } else {
                            showErrors($('#update_com_form'), data.errors);
                        }
                    },
                    error: function(data) {
                        console.log(data);
                    }
                });
            });
            </script>
            <#include "/manage/foot.ftl">
