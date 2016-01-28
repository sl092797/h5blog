 $(function() {
     $("tbody").sortable({
         items: "> tr",
         appendTo: "parent",
         helper: "clone"
     }).disableSelection();
     $('#add_catlog_form').ajaxForm({
         dataType: 'json',
         success: function(data) {
             if (data.result) {
                 buildTree();
                 $('#ADD_CATLOG').modal('hide');
             } else {
                 for (var i in data.errors) {
                     bootbox.alert(data.errors[i]);
                 }
             }
         },
         error: function(data) {
             console.log(data);
         }
     });

     $('#update_catlog_form').ajaxForm({
         dataType: 'json',
         success: function(data) {
             if (data.result) {
                 buildTree();
                 $('#UPDATE_CATLOG').modal('hide');
             } else {
                 for (var i in data.errors) {
                     bootbox.alert(data.errors[i]);
                 }
             }
         },
         error: function(data) {
             console.log(data);
         }
     });

     $('#update_pageComDef_form').ajaxForm({
         dataType: 'json',
         success: function(data) {
             if (data.result) {
                 refreshRightForm($("#catlogId").val());
                 $('#UPDATE_PAGECOMDEF').modal('hide');
             } else {
                 for (var i in data.errors) {
                     bootbox.alert(data.errors[i]);
                 }
             }
         },
         error: function(data) {
             console.log(data);
         }
     });

     buildTree();


 });

 function buildTree() {
     $.ajax({
         type: "post",
         dataType: 'json',
         url: CONTEXT + "/manage/catlog/getTree.json?type=pagecom",
         success: function(data) {
             var catlogTree = [];
             var obj = {
                 id: data.id,
                 text: data.name,
             };
             if (data.child) {
                 obj.nodes = [];
                 walkNode(data.child, obj.nodes);
             }
             catlogTree.push(obj);

             var options = {
                 bootstrap2: false,
                 showTags: true,
                 levels: 3,
                 data: catlogTree,
                 onNodeSelected: function(event, node) {
                     $("#parentId").val(node.id);
                     $("#uid").val(node.id);
                     $("#catlogId").val(node.id);
                     $("#uname").attr("placeholder", node.text);
                     refreshRightForm(node.id);
                 },
                 onRenderCallback:treeDroppable
             };
             console.log(options);
             $('#tree').treeview(options);
         }
     });
 }

 function treeDroppable(){
    $("#tree>ul>li").droppable({
         hoverClass: "drophover",
         tolerance: "pointer",
         drop: function(e, ui) {
            var catlogId = $(e.target).data('dataid');
            var pageComDefId = $(ui.draggable[0]).data('dataid');
            changeCatlog(pageComDefId,catlogId);
            $(ui.draggable[0]).remove();
         }
     });
 }

 function changeCatlog(pid,cid){
     bootbox.confirm("是否要移动目录？", function(result) {
         if (result) {
             $.post(CONTEXT + "/manage/pagecom/changeCatlog.json", {
                     'pid': pid,
                     'cid': cid
                 },
                 function(data) {
                     if (data.result) {
                     } else {
                         for (var i in data.errors) {
                             bootbox.alert(data.errors[i]);
                         }
                     }
                 },
                 "json");
         }
     });
 }

 function walkNode(childs, nodes) {
     if (!childs) {
         return;
     }
     $.each(childs, function(index, child) {
         var obj = {
             id: child.id,
             text: child.name,
         };
         if (child.child) {
             obj.nodes = [];
             walkNode(child.child, obj.nodes);
         }
         nodes.push(obj);
     });
 }

 function refreshRightForm(catlogId) {
     $.ajax({
         type: "post",
         dataType: 'json',
         data: {
             'catlogId': catlogId==""?0:catlogId
         },
         url: CONTEXT + "/manage/pagecom/listPageDefByCatlog.json",
         success: function(data) {
             console.log(data);
             var htmlstr = "";
             for (var i in data) {
                 htmlstr += "<tr class='gradeA odd' data-dataid='"+data[i]['id']+"'>";
                 htmlstr += "<td>" + data[i]['desc'] + "</td>";
                 htmlstr += "<td>" + data[i]['pageCom']['desc'] + "</td>";
                 htmlstr += "<td>" + data[i]['pageCom']['type'] + "</td>";
                 htmlstr += "<td>" + data[i]['aval'] + "</td>";
                 htmlstr += "<td>" +
                     "<a href='javascript:editPageComDef(" + data[i]['id'] + ")' title='编辑'>" +
                     "<button class='btn btn-primary btn-xs'>" +
                     "<i class='icon-edit'></i>" +
                     "</button>" +
                     "</a>";
                 htmlstr +=
                     "<a href='" + CONTEXT + "/manage/pagecom/update.htm?pageComDefId=" + data[i]['id'] + "' title='设置' style='margin-left:0.5em;'>" +
                     "<button class='btn btn-primary btn-xs'>" +
                     "<i class='icon-cog'></i>" +
                     "</button>" +
                     "</a></td></tr>";
             }
             $("#tbody").html(htmlstr);
         }
     });
 }

 function addcatlog() {
     $('#ADD_CATLOG').modal('show');
 }

 function updatecatlog() {
     $('#UPDATE_CATLOG').modal('show');
 }

 function deletecatlog() {
     bootbox.confirm("是否要删除目录？", function(result) {
         if (result) {
             $.post(CONTEXT + "/manage/pagecom/delete.json", {
                     'id': $("#catlogId").val()
                 },
                 function(data) {
                     if (data.result) {
                         buildTree();
                     } else {
                         for (var i in data.errors) {
                             bootbox.alert(data.errors[i]);
                         }
                     }
                 },
                 "json");
         }
     });
 }

 function listUnsorted(){
    refreshRightForm(null);
 }

 function editPageComDef(id){
    $('#UPDATE_PAGECOMDEF').modal('show');
    $("#upid").val(id);
 }

function updateVal(pageComDefId,pageComId){
    if(pageComId == 2){
        window.location.href=CONTEXT+"/manage/article/update.htm?articleId="+pageComDefId;
    }else{
        window.location.href=CONTEXT+"/manage/pagecom/update.htm?pageComDefId="+pageComDefId;
    }
}