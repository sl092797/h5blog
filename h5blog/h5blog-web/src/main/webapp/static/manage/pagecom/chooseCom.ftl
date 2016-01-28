<#assign menu="com_list">
    <#assign submenu="com_list">
        <#include "/manage/head.ftl">
            <style type="text/css">
            .pagination {
                border-radius: 4px;
                display: inline-block;
                margin: 0;
                padding-left: 0;
            }
            </style>
            <!--main content start-->
            <section id="main-content">
                <section class="wrapper">
                    <!-- page start-->
                    <section class="panel">
                        <header class="panel-heading">
                            模板列表
                        </header>
                        <div class="panel-body">
                            <div class="adv-table">
                                <div role="grid" class="dataTables_wrapper" id="hidden-table-info_wrapper">
                                    <table class="table table-striped table-advance table-hover">
                                        <thead>
                                            <tr>
                                                <th>序号</th>
                                                <th>组件名称</th>
                                                <th>组件描述</th>
                                                <th>组件类型</th>
                                                <th>组件上下文</th>
                                                <th>组件模板路径</th>
                                                <th>修改者</th>
                                                <th>修改时间</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody role="alert" aria-live="polite" aria-relevant="all">
                                            <#list pageCom as e>
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
                                                        <#if e.context??>${e.context}</#if>
                                                    </td>
                                                    <td>
                                                        <#if e.ftlPath??>${e.ftlPath}</#if>
                                                    </td>
                                                    <td>
                                                        <#if e.changeUser??>${e.changeUser}</#if>
                                                    </td>
                                                    <td>
                                                        <#if e.changeDate??>${e.changeDate?datetime}</#if>
                                                    </td>
                                                    <td>
                                                        <!-- Icons -->
                                                        <a href="${BASE_PATH}/manage/pagecom/updateCom.htm?pageComId=${e.id}" title="修改组件模板">
                                                            <button class="btn btn-primary btn-xs">
                                                                <i class="icon-eye-open"></i>
                                                            </button>
                                                        </a>
                                                        <a href="javascript:addComDef(${e.id})" title="选择使用此模板">
                                                            <button class="btn btn-primary btn-xs">
                                                                <i class="icon-edit"></i>
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
                            </div>
                        </div>
                    </section>
                    <!-- page end-->
                </section>
            </section>
            <!--main content end-->
            <script type="text/javascript">
                function addComDef(pageComId){
                    if(pageComId == 2){
                        window.location.href="${BASE_PATH}/manage/article/add.htm";
                    }else{
                        window.location.href="${BASE_PATH}/manage/pagecom/add.htm?pageComId="+pageComId;
                    }
                }
            </script>
            <#include "/manage/foot.ftl">
