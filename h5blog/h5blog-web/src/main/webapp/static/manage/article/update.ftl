<#assign menu="article">
<#assign submenu="update_article">
<#include "/manage/head.ftl">
<!--main content start-->
<style type="text/css">

</style>
<section id="main-content">
	<section class="wrapper">
		<!-- page start-->
		<form id="update_article_form" class="form-horizontal" action="${BASE_PATH}/manage/article/update.json"  autocomplete="off"  method="post"
			enctype="multipart/form-data">
			<fieldset>
		<div class="row">
			<input type="hidden" name="articleId" value="${articleId}">
			<div class="col-lg-12">
				<section class="panel">
					<header class="panel-heading"> 
						修改文章
					</header>
					<div class="panel-body">
	                     
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">标题</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;width: 300px;" class="form-control" name="title"
                              	placeholder="文章标题" id="name" value="${title}">
                              </input>
                          </div>
                        </div>
                       
						<div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">摘要</label>
                          <div class="col-sm-10">
                              <input type="text" style="font-size:15px;" class="form-control" name="summary"
                              	placeholder="摘要" id="name" value="${summary}">
                              </input>
                          </div>
                        </div>                                               
						<div class="form-group">
                              <label class="col-sm-2 col-sm-2 control-label">内容</label>
                              <div class="col-sm-10">
                                  <script id="content" name="content" type="text/plain"
										style="width: 100%; height: 600px;">${content}</script>
								  <script type="text/javascript">
									var contentEditor;
									$(function() {
										contentEditor = UE.getEditor('content');
									});
								  </script>
                              </div>
                        </div>
                        <div class="form-group">
                          <label class="col-sm-2 col-sm-2 control-label">发布时间</label>
                          <div class="col-sm-10">
                              <input type="text" data-link-format="yyyy-mm-dd" data-date-format="yyyy-MM-dd" style="font-size:15px;" class="js_create_time" name="publishtime"
                              	placeholder="发布时间" id="createTime" value="${publishtime}" >
                              </input>
                          </div>
                        </div>    
                        <div class="form-group">
                      	  <div class="col-lg-offset-2 col-lg-10">
                          <button class="btn btn-shadow btn-primary" type="submit">发布</button>
                          </div>
                      </div>
					</div>
				</section>
				<!-- section class="panel">
					<header class="panel-heading"> 附件 </header>
					<div class="panel-body">
						<div id="attachment"></div>
						<button id="file_upload"  class="btn btn-shadow btn-info" type="button"><i class="icon-cloud-upload"></i> 添加附件</button>
					</div>
				</section -->					
			</div>
		</div>
		</fieldset>
		</form>
		<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">
$(function(){
	$('#update_article_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
						
					});
				}else{
					showErrors($('#add_article_form'),data.errors);
				}
			}
		});
});
</script>
<#include "/manage/foot.ftl">
