<#assign menu="pageCom">
    <#assign submenu="update_pageCom">
        <#include "/manage/head.ftl">
            <style type="text/css">
            .m-bot15 {
                margin-bottom: 5px;
            }
            
            .form-control {
                border: 1px solid #E2E2E4;
                box-shadow: none;
                color: #C2C2C2;
            }
            
            .input-lg {
                border-radius: 6px;
                font-size: 15px;
                height: 40px;
                line-height: 1.33;
                padding: 9px 15px；
            }
            </style>
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <!-- page start-->
                    <div class="row">
                        <div class="col-lg-12">
                            <section class="panel">
                                <header class="panel-heading">
                                    <div class="col-lg-12">
                                        <a class="btn btn-primary" style="float:right;" href="${BASE_PATH}/manage/pagecom/list.htm">返回</a>
                                    </div>
                                </header>
                                <div class="panel-body">
                                    <div class="adv-table">
                                        <div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                                            <table class="table table-striped table-advance table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>序号</th>
                                                        <th>变量名称</th>
                                                        <th>变量描述</th>
                                                        <th>变量类型</th>
                                                        <th>变量代码</th>
                                                        <th>变量值</th>
                                                        <th>创建者</th>
                                                        <th>创建时间</th>
                                                        <th>修改者</th>
                                                        <th>修改时间</th>
                                                        <th>操作</th>
                                                    </tr>
                                                </thead>
                                                <tbody role="alert" aria-live="polite" aria-relevant="all">
                                                    <#list pageComVarList as e>
                                                        <tr class="gradeA odd">
                                                            <td>${e.id}</td>
                                                            <td>
                                                                <#if e.name??>${e.name}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.desc??>${e.desc}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.type??>${e.type}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.code??>${e.code}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.pageComVal.pgComValue??>${e.pageComVal.pgComValue}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.pageComVal.createUser??>${e.pageComVal.createUser}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.pageComVal.createDate??>${e.pageComVal.createDate?datetime}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.pageComVal.changeUser??>${e.pageComVal.changeUser}</#if>
                                                            </td>
                                                            <td>
                                                                <#if e.pageComVal.changeDate??>${e.pageComVal.changeDate?datetime}</#if>
                                                            </td>
                                                            <td>
                                                                <!-- Icons -->
                                                                <a href="${BASE_PATH}/manage/pagecom/detail.htm?" title="详细">
                                                                    <button class="btn btn-primary btn-xs">
                                                                        <i class="icon-eye-open"></i>
                                                                    </button>
                                                                </a>
                                                                <a <#if e.pageComVal.id??> 
                                                                 href="${BASE_PATH}/manage/pagecom/updateVal.htm?pageComValId=${e.pageComVal.id}&pageComDefId=${pageComDefId}&pageComVarId=${e.id}" 
                                                                 <#else>
                                                                 href="${BASE_PATH}/manage/pagecom/updateVal.htm?pageComDefId=${pageComDefId}&pageComVarId=${e.id}"
                                                                </#if>
                                                                 title="设置变量">
                                                                    <button class="btn btn-primary btn-xs">
                                                                        <i class="icon-edit"></i>
                                                                    </button>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    </#list>
                                                </tbody>
                                            </table>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-2 control-label"></label>
                                                <button class="btn btn-danger" type="submit">修改</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </div>
                    </div>
                    <!-- page end-->
                </section>
            </section>
            <!--main content end-->
            <script type="text/javascript">
            </script>
            <#include "/manage/foot.ftl">
