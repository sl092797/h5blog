<#assign menu="pagedef">
<#assign submenu="pagedef_list">
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
			<div class="col-lg-5">
				<section class="panel">
                          <header class="panel-heading">
                            	 网站结构
                          </header>
                          <div class="panel-body">
                              	<fieldset>
                                  <div class="form-group">
                                    <div id="tree"></div>
                                  </div>                                                                 
                                 
                                  <div class="form-group">
                                  	  <div class="col-lg-offset-3 col-xs-9">
                                      	<button class="btn btn-primary" type="button" onclick="addpage()">新增页面</button>
                                      </div>
                                  </div>
                              </form>
                          </div>
                      </section>
			</div>
			<div class="col-lg-7">
				<section class="panel">
					<div class="panel-body" id="update_panel">
						<header class="panel-heading">
			                                        修改页面信息    
			            </header>
					 	<form id="updatePage_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/pagedef/update.json">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-xs-3 control-label">页面名称</label>
                                      <div class="col-xs-9">
                                          <input type="text" style="font-size:15px;width: 200px;" class="form-control" name="name"
                                          	placeholder="页面名称" id="name" >
                                          </input>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-xs-3 control-label">页面描述</label>
                                      <div class="col-xs-9">
	                                      <input style="font-size:15px;width: 200px;"  class="form-control" name="desc" id="desc" placeholder="页面描述">
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-xs-3 control-label">页面关键字</label>
                                      <div class="col-xs-9">
	                                      <input style="font-size:15px;width: 200px;"  class="form-control" name="pageKey" id="pageKey" placeholder="用于生成URL">
                                      </div>
                                  </div>   
                                  <div class="form-group">
                                      <label class="col-xs-3 control-label">页面访问URL</label>
                                      <div class="col-xs-9">
	                                      <input style="font-size:15px;width: 200px;"  class="form-control" name="url" id="url" readonly placeholder="页面访问URL">
                                      </div>
                                  </div>                                                            
                                  <div class="form-group">
                                  	  <div class="col-lg-offset-3 col-xs-9">
                                  	  	<input type="hidden" id="id" name="id"/>
                                      	<button class="btn btn-primary update-button" type="submit" disabled="true">修改</button>
                                      	<a class="btn btn-primary update-button"  href="javascript:updateTpl()" disabled="true">修改页面模板</a>
                                      	<a class="btn btn-primary update-button"  href="javascript:deletePage()" disabled="true">删除页面</a>
                                      </div>
                                  </div>
                                 </fieldset>
                              </form>
                            </div>
                            <div class="panel-body" id="add_panel" style="display:none">
                            	<header class="panel-heading">
			                    	父页面：<span id="parentName"></span>       
			                    </header>
					 			<form id="addPage_form" method="post" class="form-horizontal" autocomplete="off" action="${BASE_PATH}/manage/pagedef/add.json">
                              	<fieldset>
                                  <div class="form-group">
                                      <label class="col-xs-3 control-label">页面名称</label>
                                      <div class="col-xs-9">
                                          <input type="text" style="font-size:15px;width: 200px;" class="form-control" name="add_name"
                                          	placeholder="页面名称" id="add_name" >
                                          </input>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label class="col-xs-3 control-label">页面描述</label>
                                      <div class="col-xs-9">
	                                      <input style="font-size:15px;width: 200px;"  class="form-control" name="add_desc" id="add_desc" placeholder="页面描述">
                                      </div>
                                  </div>
                                   <div class="form-group">
                                      <label class="col-xs-3 control-label">页面关键字</label>
                                      <div class="col-xs-9">
	                                      <input style="font-size:15px;width: 200px;"  class="form-control" name="add_pageKey" id="add_pageKey" placeholder="用于生成URL">
                                      </div>
                                  </div>   
                                  <div class="form-group">
                                  	  <div class="col-lg-offset-3 col-xs-9">
                                  	  <input type="hidden" id="parentId" name="parentId"/>
                                      <button class="btn btn-primary" type="submit">新增页面 </button>
                                      </div>
                                  </div>
                                 </fieldset>
                              </form>
                            </div>
				</section>
			</div>
			<link rel="stylesheet" type="text/css" href="${BASE_PATH}/static/manage/css/bootstrap-treeview.css?v=${config_v}" />
			<script src="${BASE_PATH}/static/manage/js/bootstrap-treeview.js?v=${config_v}"></script>
			<!-- page end-->
	</section>
</section>
<!--main content end-->
<script type="text/javascript">

$(function() {
	$.ajax({
	type: "post",
	dataType : 'json',
	url: "${BASE_PATH}/manage/pagedef/getTree.json",
	success : function(data) {
		buildTree(data);
		}
	});
	
	$('#updatePage_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("保存成功，将刷新页面", function() {
						window.location.reload();
						
					});
				}else{
					showErrors($('#updatePage_form'),data.errors);
				}
			}
		});
		
	$('#addPage_form').ajaxForm({
			dataType : 'json',
			success : function(data) {
				if (data.result) {
					bootbox.alert("新增成功，将进入选择模板页面", function() {
						window.location.href = "${BASE_PATH}/manage/pagedef/choosetpl/" + data.t.id +".htm";
						
					});
				}else{
					showErrors($('#addPage_form'),data.errors);
				}
			}
		});	

	function buildTree(pageData){
		var pageTree = [];
		var obj = {
	              id: pageData.id,
	              text: pageData.name,
	              url: pageData.url,
             	  desc: pageData.desc
	            };
	    if(pageData.child){
	      obj.nodes = [];
	      walkNode(pageData.child, obj.nodes);
	    }
		pageTree.push(obj);
		
		var options = {
          bootstrap2: false, 
          showTags: true,
          levels: 3,
          data: pageTree,
          onNodeSelected: function(event, node) {
              $("#id").val(node.id);
              $("#name").val(node.text);
              $("#desc").val(node.desc);
              $("#url").val(node.url);
              $("#pageKey").val(node.pageKey);
              $("#parentId").val(node.id);
              $("#parentName").text(node.text);
              $("#update_panel").show();
			  $("#add_panel").hide();
			  if(0 == node.id){
			  	$(".update-button").attr("disabled","disabled"); 
			  }else{
			  	$(".update-button").removeAttr("disabled"); 
			  }
            }
        };
		$('#tree').treeview(options);
	}
	
	function walkNode(nodes, data){
		if (!nodes) { return; }
		 $.each(nodes, function (id, node) {
		 	 var obj = {
              id: node.id,
              text: node.name,
              url: node.url,
              pageKey: node.pageKey,
              desc: node.desc
            };
            if(node.child){
            	obj.nodes = [];
            	walkNode(node.child, obj.nodes);
            }
            data.push(obj);
		 });
	}
});

function updateTpl(){
	var pageId = $("#id").val();
	window.location.href = "${BASE_PATH}/manage/pagedef/choosetpl/" + pageId +".htm";
}

function addpage(){
	$("#update_panel").hide();
	$("#add_panel").show();
}

function deletePage(){
	bootbox.confirm("是否要删除文件？", function(result) {
		if (result) {
			$.post("${BASE_PATH}/manage/pagedef/delete.json",
					{'id':$("#id").val()},
					function(data){
						if(data.result){
							window.location.reload();
				        }
					},
					"json");
			}
	});
}
</script>
<#include "/manage/foot.ftl">
