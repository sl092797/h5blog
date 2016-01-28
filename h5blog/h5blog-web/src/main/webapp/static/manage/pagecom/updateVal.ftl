<#assign menu="pageCom">
    <#assign submenu="update_var">
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
                                            设置变量值
                                        </div>
                                        <div class="col-lg-12">
                                            <a class="btn btn-danger" style="float:right;" onclick="resetPwd();">重置</a>
                                        </div>
                                    </div>
                                </header>
                                <div class="panel-body">
                                    <form id="update_val_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/pagecom/updateVal.json">
                                        <fieldset>
                                            <#if pageVo.id??>
                                                <input type="hidden" name="id" value="${pageVo.id}">
                                            </#if>
                                            <#if pageComDefId??>
                                                <input type="hidden" name="pgComDefId" value="${pageComDefId}" />
                                            </#if>
                                            <#if pageComVarId??>
                                                <input type="hidden" name="pageComVar.id" value="${pageComVarId}">
                                            </#if>
                                            <div class="row">
                                                <label class="col-sm-2 control-label">名称</label>
                                                <div class="col-sm-4">
                                                    <#if pageVo.pageComVar.name??>
                                                        <input type="text" class="form-control" name="pageComVarName" placeholder="" id="pageComVarName" value="${pageVo.pageComVar.name}">
                                                        <#else>
                                                            <input type="text" class="form-control" name="pageComVarName" placeholder="" id="pageComVarName" value="">
                                                    </#if>
                                                </div>
                                                <label class="col-sm-2 control-label">描述</label>
                                                <div class="col-sm-4">
                                                    <#if pageVo.pageComVar.desc??>
                                                        <input type="text" class="form-control" name="pageComVarDesc" placeholder="" id="pageComVarDesc" value="${pageVo.pageComVar.desc}">
                                                        <#else>
                                                            <input type="text" class="form-control" name="pageComVarDesc" placeholder="" id="pageComVarDesc" value="">
                                                    </#if>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <#if pageVo.pageComVar.code??>
                                                    <label class="col-sm-2 control-label">代码</label>
                                                    <div class="col-sm-4">
                                                        <input type="text" class="form-control" name="pgComCode" readonly="readonly" id="pgComCode" value="${pageVo.pageComVar.code}">
                                                    </div>
                                                </#if>
                                                <label class="col-sm-2 control-label">变量值</label>
                                                <div class="col-sm-4">
                                                    <#if pageVo.pgComValue??>
                                                        <input type="text" class="form-control" name="pgComValue" placeholder="" id="pgComValue" value="${pageVo.pgComValue}">
                                                        <#else>
                                                            <input type="text" class="form-control" name="pgComValue" placeholder="" id="pgComValue" value="">
                                                    </#if>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <#if pageVo.createUser??>
                                                    <label class="col-sm-2 control-label">创建人</label>
                                                    <div class="col-sm-4">
                                                        <input type="text" readonly="readonly" name="createUser" class="form-control" value="${pageVo.createUser}" />
                                                    </div>
                                                    <label class="col-sm-2 control-label">创建时间</label>
                                                    <div class="col-sm-4">
                                                        <input type="text" readonly="readonly" name="createDate" class="form-control" value="${pageVo.createDate?datetime}" />
                                                    </div>
                                                </#if>
                                            </div>
                                            <div class="row">
                                                <#if pageVo.changeUser??>
                                                    <label class="col-sm-2 control-label">修改人</label>
                                                    <div class="col-sm-4">
                                                        <input type="text" readonly="readonly" name="changeUser" class="form-control" value="${pageVo.changeUser}" />
                                                    </div>
                                                    <label class="col-sm-2 control-label">修改时间</label>
                                                    <div class="col-sm-4">
                                                        <input type="text" readonly="readonly" name="changeDate" class="form-control" value="${pageVo.changeDate?datetime}" />
                                                    </div>
                                                </#if>
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
                $('#update_val_form').ajaxForm({
                    dataType: 'json',
                    success: function(data) {
                        if (data.result) {
                            bootbox.alert("保存成功，将刷新页面", function() {
                                window.location.href = "${BASE_PATH}/manage/pagecom/update.htm?pageComDefId=${pageComDefId}";
                            });
                        } else {
                            showErrors($('#update_val_form'), data.errors);
                        }
                    },
                    error: function(data) {
                        console.log(data);
                    }
                });
            });
            </script>
            <#include "/manage/foot.ftl">
