<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>权限管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="${APP_PATH }/layui/css/layui.css"  media="all">
  <script src="${APP_PATH }/layui/layui.js"></script>
  <script type="text/javascript" src="${APP_PATH }/js/jquery-3.4.1.min.js"></script>
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

 
<table class="layui-hide" id="test" lay-filter="test"></table>

	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container" style="padding-left:20px;">
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-add-1"></i>新增部门 </button>
  </div>
	
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
layui.use(['table','laydate','form','tree', 'util'], function(){
  var table = layui.table;
  var laydate = layui.laydate;
  var form = layui.form;
  var tree = layui.tree
  ,layer = layui.layer
  ,util = layui.util
  

  table.render({
    elem: '#test'
    ,url:'${APP_PATH}/queryAllDept.do'
    ,toolbar: '#toolbarDemo'
    ,title: '领料单'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'deptId', title:'部门编号', unresize:true}
      ,{field:'deptName', title:'部门名称',unresize:true}
      ,{field:'personNumber', title:'部门人数',unresize:true}
      ,{field:'deptDesc', title:'描述', unresize:true}
      ,{
		fixed: 'right', title:'操作',align:'center', toolbar: '#barDemo',unresize:true
      }
    ]]
    ,page: true
    ,limit:5
    ,limits:[5,10,20,30,40,50,60,70,80,90]
  });
  
  
//监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确认删除该部门吗', function(index){
    	  $.ajax({
				type:"post",
				url:"${APP_PATH}/deletDeptById.do",
				data:{
					"deptId":data.deptId
				},
				dateType:"text",
				success:function(result){
					if(result==false){
						layer.msg("删除失败", {time:3000, icon:5, shift:6});
					}else{
						layer.msg("删除成功", {time:3000, icon:1, shift:3});
						obj.del();
					}
					layer.close(index);
				}
			});
      });
    } else if(obj.event === 'edit'){
    	//formTest 即 class="layui-form" 所在元素对应的 lay-filter="" 对应的值
    	form.val("formAuthority", {
    	  "id": data.deptId // "name": "value"
    	  ,"name": data.deptName
    	  ,"des": data.deptDesc
    	})
    	
    	var index = layer.open({
			title : '编辑部门',//标题
			type : 1,//样式
			shade: 0,
			offset: ['15%', '35%'],//设置位移
			btn: ['确认', '取消'],
			yes: function(index, layero){
				var deptName=$("#deptName").val();
				var deptId=$("#deptId").val();
				var deptDesc=$("#deptDesc").val();
				$.ajax({
					type:"post",
					url:"${APP_PATH}/updateDeptById.do",
					data:{
						"deptName":deptName,
						"deptDesc":deptDesc,
						"deptId":deptId
					},
					dateType:"text",
					success:function(result){
						if(result==false){
							layer.msg("修改失败", {time:3000, icon:5, shift:6});
						}else{
							layer.msg("修改成功", {time:3000, icon:1, shift:3});
							table.reload('test')
						}
						layer.close(index);
					}
				});
			}
			,btn2: function(index, layero){
				  layer.close(index);
			},
			content :$("#branch"),
		});
    }
  });
  
  
//工具栏事件
	table.on('toolbar(test)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		switch (obj.event) {
		case 'getCheckData':
            $("#formIdOne")[0].reset();
			var index = layer.open({
				title : '新增部门',//标题
				type : 1,//样式
				shade: 0,
				offset: ['15%', '35%'],//设置位移
				btn: ['确认', '取消'],
				yes: function(index, layero){
					var deptName=$("#deptName").val();
					var deptDesc=$("#deptDesc").val();
					$.ajax({
						type:"post",
						url:"${APP_PATH}/addDept.do",
						data:{
							"deptName":deptName,
							"deptDesc":deptDesc
						},
						dateType:"text",
						success:function(result){
							if(result=='该部门已经存在'){
								layer.msg(result, {time:3000, icon:5, shift:6});
							}else{
								layer.msg(result, {time:3000, icon:1, shift:3});
								table.reload('test')
							}
						}
					});
					layer.close(index);
				}
				,btn2: function(index, layero){
					  layer.close(index);
				},
				
				content :$("#branch"),
			});
			break;
		};
	});
  
});
</script>


		<div class="site-text" style="margin: 5%; display: none" id="branch" target="test123">
		<form class="layui-form" lay-filter="formAuthority" id="formIdOne">
			<div class="layui-input-inline">
				<label style="margin:0 10px 0 20px;font-size:13px;">部门编号</label>
				<div class="layui-input-inline">
      				<input type="text" id="deptId" name="id" lay-verify="required" disabled placeholder="自动生成" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">部门名称</label>
				<div class="layui-input-inline">
      				<input type="text" name="name" id="deptName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">部门描述</label>
				<div class="layui-input-inline">
      				<textarea name="des" id="deptDesc" required lay-verify="required" cols="25px" placeholder="请输入部门描述" class="layui-textarea"></textarea>
    			</div>
			</div>
			</form>
		</div>

</body>
</html>