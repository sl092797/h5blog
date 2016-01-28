<#assign menu="pageCom">
    <#assign submenu="add_pageComVar">
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
                                    添加变量
                                </header>
                                <div class="panel-body">
                                    <form id="add_pageComVar_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/pagecom/addVal.json">
                                        <fieldset>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-2 control-label">变量名称</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="name"  id="name">
                                                </div>
                                                <label class="col-sm-2 col-sm-2 control-label">变量描述</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="desc"  id="desc">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-2 control-label">变量代码</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="code"  id="code">
                                                </div>
                                                <label class="col-sm-2 col-sm-2 control-label">变量值</label>
                                                <div class="col-sm-4">
                                                    <input type="text" class="form-control" name="value"  id="value">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 col-sm-2 control-label"></label>
                                                <button class="btn btn-danger" type="submit">增加</button>
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
                $('#add_pageComVar_form').ajaxForm({
                    dataType: 'json',
                    success: function(data) {
                        if (data.result) {
                            bootbox.alert("保存成功", function() {
                                window.location.href = "${BASE_PATH}/manage/pagecom/list.htm";
                            });
                        } else {
                            showErrors($('#add_pageCom_form'), data.errors);
                        }
                    }
                });
            });
            </script>
            <#include "/manage/foot.ftl">
