<#assign menu="pagetpl">
<#assign submenu="add_pagetpl">
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
                            	修改模板
                          </header>
                          <div class="panel-body">
                              <form id="update_pagetpl_form"  class="form-horizontal"  method="post" autocomplete="off" action="${BASE_PATH}/manage/pagetpl/update/${pageTpl.id}.json">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">模板名称</label>
                                      <div class="col-sm-10">
                                          <input type="text" style="font-size:15px;width: 600px;" class="form-control" name="name" value="${pageTpl.name}"
                                          	placeholder="模板名称" id="name" >
                                          </input>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">模板描述</label>
                                      <div class="col-sm-10">
	                                      <input style="font-size:15px;width: 600px;" value="${pageTpl.desc}"
	                                       class="form-control" name="desc" placeholder="模板描述">
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-sm-2 col-sm-2 control-label">模板路径</label>
                                      <div class="col-sm-10">
	                                      ${pageTpl.path}
                                      </div>
                                  </div>
                                  <div class="form-group">
                                  	  <div class="col-lg-offset-2 col-lg-10">
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
		$('#update_pagetpl_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
						
					});
				}else{
					showErrors($('#update_pagetpl_form'),data.errors);
				}
			}
		});
	});	
</script>
<#include "/manage/foot.ftl">