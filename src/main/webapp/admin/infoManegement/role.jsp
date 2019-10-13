<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
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
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-add-1"></i>新增角色 </button>
  </div>
	
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">管理权限</a>
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
//模拟数据
  ,data = [{
    title: 'ALL'
    ,id: 2
    ,spread: true
    ,children: [{
      title: '系统信息管理'
      ,id: 5
      ,spread: true
      ,children: [{
        title: '员工管理'
        ,id: 11
        ,spread: true
        ,children: [{
            title: '新增'
            ,id: 11
          },{
        	  title:'删除'
        	  ,id:22
          }]
      },{
          title: '部门管理'
              ,id: 11
              ,spread: true
              ,children: [{
                  title: '新增'
                  ,id: 11
                },{
              	  title:'删除'
              	  ,id:22
                }]
            }]
    },{
        title: '采购管理'
            ,id: 5
            ,spread: true
            ,children: [{
              title: '采购申请'
              ,id: 11
              ,spread: true
              ,children: [{
                  title: '新增'
                  ,id: 11
                },{
              	  title:'删除'
              	  ,id:22
                }]
            },{
                title: '采购计划'
                    ,id: 11
                    ,spread: true
                    ,children: [{
                        title: '新增'
                        ,id: 11
                      },{
                    	  title:'删除'
                    	  ,id:22
                      }]
                  }]
          }]
  }]
  
  
	//基本演示
  tree.render({
    elem: '#test12'
    ,data: data
    ,showCheckbox: true  //是否显示复选框
    ,id: 'demoId1'
    ,isJump: true //是否允许点击节点时弹出新窗口跳转
    ,click: function(obj){
      var data = obj.data;  //获取当前点击的节点数据
      layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
    }
  });
  table.render({
    elem: '#test'
    ,url:'${APP_PATH}/queryAllRole.do'
    ,toolbar: '#toolbarDemo'
    ,title: '领料单'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'roleId', title:'角色编号', unresize:true}
      ,{field:'roleName', title:'角色名称',unresize:true}
      ,{field:'dept', title:'所属部门',unresize:true
		,templet: function(d){
        return '<span>'+ d.dept.deptName +'</span>';
      }}
      ,{field:'roleDesc', title:'角色描述', unresize:true}
      ,{
		fixed: 'right', align:'center', toolbar: '#barDemo',unresize:true
      }
    ]]
    ,page: true
    ,limits:[5,10,20,30,40,50,60,70,80,90]
  });
  
  
//监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
    	layer.open({
			title : '权限管理',//标题
			type : 1,//样式
			shade: 0,
			area: ['350px', '500px'],
			content :$("#test12"),
			
			success : function(layero) {
				var mask = $(".layui-layer-shade");
				mask.appendTo(layero.parent());
				//其中：layero是弹层的DOM对象
			},
			end : function() {
				
			}
		});
		
		
	} else if(obj.event === 'del'){
      layer.confirm('确认删除该角色吗', function(index){
    	  $.ajax({
				type:"post",
				url:"${APP_PATH}/deletRoleById.do",
				data:{
					"roleId":data.roleId
				},
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
		$("#opt"+data.deptId).prop("selected",true);
    	//console.log(data);
    	//formTest 即 class="layui-form" 所在元素对应的 lay-filter="" 对应的值
    	form.val("formAuthority", {
    	  "roleId": data.roleId // "name": "value"
    	  ,"roleName": data.roleName
    	  ,"roleDesc": data.roleDesc
    	})
    	
    	var index = layer.open({
			title : '编辑角色',//标题
			type : 1,//样式
			shade: 0,
			offset: ['15%', '35%'],//设置位移
			btn: ['确认', '取消'],
			yes: function(index, layero){
				$.ajax({
					type:"post",
					url:"${APP_PATH}/updateRoleById.do",
					data:$("#formIdOne").serialize()+"&roleId="+$("#roleId").val(),
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
  
  $.ajax({
		type:"post",
		url:"${APP_PATH}/queryDeptGiveOption.do",
		success:function(result){
			var data=result.data;
			var content='<option value=""></option>';
			$.each(data,function(index,item){
				content+='<option id="opt'+item.deptId+'" value="'+item.deptId+'">'+item.deptName+'</option>';
			});
			$("#deptId").html(content);
			//form.render('select'); 
		}
	});
//工具栏事件
	table.on('toolbar(test)', function(obj) {
		var checkStatus = table.checkStatus(obj.config.id);
		
		switch (obj.event) {
		case 'getCheckData':
            $("#formIdOne")[0].reset();
			var index = layer.open({
				title : '新增角色',//标题
				type : 1,//样式
				shade: 0,
				offset: ['15%', '35%'],//设置位移
				btn: ['确认', '取消'],
				yes: function(index, layero){
					var roleName=$("#roleName").val();
					var deptId=$("#deptId").val();
					if(roleName.trim()==""){
						layer.msg("请输入名称！", {time:3000, icon:5, shift:6});
					}else if(deptId==""){
						layer.msg("请选择部门！", {time:3000, icon:5, shift:6});
					}else{
						$.ajax({
							type:"post",
							url:"${APP_PATH}/addRole.do",
							data:$("#formIdOne").serialize(),
							success:function(result){
								if(result=='该角色已经存在'){
									layer.msg(result, {time:3000, icon:5, shift:6});
								}else{
									layer.msg(result, {time:3000, icon:1, shift:3});
									table.reload('test')
								}
							}
						});
					}
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

		<div id="test12" class="demo-tree-more" style="display:none;"></div>

		<div class="site-text" style="margin: 5%; display: none" id="branch" target="test123">
		<form class="layui-form" lay-filter="formAuthority" id="formIdOne">
			<div class="layui-input-inline">
				<label style="margin:0 10px 0 20px;font-size:13px;">角色编号</label>
				<div class="layui-input-inline">
      				 <input type="text" name="roleId" id="roleId" lay-verify="required" disabled placeholder="自动生成" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">角色名称</label>
				<div class="layui-input-inline">
      				<input type="text" name="roleName" id="roleName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
    			<label style="margin:0 10px 0 20px;font-size:13px;">分配部门</label>
			    <div class="layui-input-inline" style="width: 192px;">
				    <select name="deptId" lay-verify="required" id="deptId" lay-search>
				        
					</select>
			    </div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">角色描述：</label>
				<div class="layui-input-inline">
      				<textarea name="roleDesc" required lay-verify="required" cols="25px" placeholder="请输入角色描述" class="layui-textarea"></textarea>
    			</div>
			</div>
			</form>
		</div>

</body>
</html>