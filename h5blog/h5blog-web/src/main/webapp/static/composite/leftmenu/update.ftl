<#assign menu="com_list">
<#assign submenu="update_leftmenu">
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
                            	 添加菜单
                          </header>
                          <div class="panel-body">
                              <form id="updateMenu_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/leftmenu/update.json">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">菜单名称</label>
                                      <div class="col-sm-10">
                                          <input type="text" style="font-size:15px;width: 600px;" class="form-control" name="name"
                                          	placeholder="菜单名称" id="name" value="${leftMenu.name}">
                                          </input>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">菜单URL</label>
                                      <div class="col-sm-10">
	                                      <input style="font-size:15px;width: 600px;" value="${leftMenu.url}"
	                                       class="form-control" name="url" placeholder="菜单URL" id="url">
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">菜单顺序</label>
                                      <div class="col-sm-10">
	                                      <input style="font-size:15px;width: 600px;" value="${leftMenu.order}"
	                                       class="form-control" name="order" placeholder="菜单顺序">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">系统关键字</label>
                                      <div class="col-sm-10">
	                                      <input style="font-size:15px;width: 600px;" value="${leftMenu.key}"
	                                       class="form-control" name="key" placeholder="系统关键字" id="key">
                                      </div>
                                  </div>
                                  <div class="form-group">
                                  	  <div class="col-lg-offset-2 col-lg-10">
                                  	  <input type="hidden" name="id" id="id" value="${leftMenu.id}">
                                      <button class="btn btn-danger" type="submit">保存</button>
                                      </div>
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
		$('#updateMenu_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						 window.location.href = "${BASE_PATH}/manage/leftmenu/list.htm";
						
					});
				}else{
					showErrors($('#updateMenu_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/manage/foot.ftl">