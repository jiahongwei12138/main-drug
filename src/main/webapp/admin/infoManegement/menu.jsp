<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${APP_PATH }/layui/css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
  <legend>菜单管理</legend>
</fieldset>
 
<div id="test9" class="demo-tree demo-tree-box" style="width: 100%; height: 300px; "></div>
        
<script src="${APP_PATH }/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
layui.use(['tree', 'util','jquery'], function(){
  var tree = layui.tree
  ,layer = layui.layer
  ,util = layui.util
  ,$ = layui.jquery
  
  
//加载树
	$.ajax({
		  type:"post",
		  url:"${APP_PATH}/queryModelTree.do",
		  dataType:"json",
		  success:function(result){
			//开启节点操作图标
			  tree.render({
			    elem: '#test9'
			    ,data: result
			    ,id: 'demoId1'
			    ,edit: [/* 'add',  */'update'/* , 'del' */] //操作节点的图标
			    ,operate: function(obj){
				    var type = obj.type; //得到操作类型：add、edit、del
				    var data = obj.data; //得到当前节点的数据
				    var elem = obj.elem; //得到当前节点元素
				    //Ajax 操作
				    var id = data.id; //得到节点索引
				    if(type === 'update'){ //修改节点
				      var modelName=elem.find('.layui-tree-txt').html(); //得到修改后的内容
				      var modelId=data.id;
				      $.ajax({
				    	  type:"post",
				    	  url:"${APP_PATH}/updateModelNameById.do",
				    	  data:{
				    		  "id":modelId,
				    		  "title":modelName
				    	  },
				    	  success:function(result){
					    		if(result==false){
									layer.msg("修改失败", {time:3000, icon:5, shift:6});
								}else{
									layer.msg("修改成功", {time:3000, icon:1, shift:3});
								}
				    	  }
				    	  
				      });
				    } 
				  }
			  });
		  }
	  });
	//其中：layero是弹层的DOM对象
  
});
</script>

</body>
</html>