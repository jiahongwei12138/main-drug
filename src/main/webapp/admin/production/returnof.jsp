<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>生产退料管理</title>
<link rel="stylesheet" href="${APP_PATH }/layui/css/layui.css">
<script src="${APP_PATH }/layui/layui.js"></script>

</head>
<body class="layui-layout-body">
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<script type="text/html" id="toolbarDemo">
			  <div class="layui-inline">
<button type="button" id="btn" class="layui-btn layui-btn-sm" lay-event="getCheckData">审核退料单</button>
    <div class="layui-inline">
      <label class="layui-form-label" style="width:130px">选择审核状态：</label>
      <div class="layui-input-inline">
        <select name="modules" lay-verify="required" lay-search="">
          <option value="">直接选择或搜索选择</option>
          <option value="1">已审核</option>
          <option value="2">未审核</option>
        </select>
      </div>
    </div>
    </div>
</script>

	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

	<script src="${APP_PATH }/layui/layui.js" charset="utf-8"></script>

	<script>
	
	
layui.use(['table','form'], function(){
  var table = layui.table;
  var form = layui.form;
  var $ = layui.$;
  table.render({
    elem: '#test'
    ,url:'${APP_PATH }/selectReturnOfAll.do'
    ,toolbar: '#toolbarDemo'
    ,title: '退料数据表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'returnOfId', title:'退料单编号', fixed: 'left', unresize: true, sort: true}
      ,{field:'poId', title:'生产订单编号', edit: 'text'}
      ,{field:'applydate', title:'申请时间'}
	  ,{field:'status', title:'审核状态'}
	  ,{field:'insrock', title:'入库状态', sort: true}
	  ,{field:'empName', title:'申请人'}
	  ,{field:'auditorName', title:'审核人'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
    ]]
    ,page:true
  });
  
    //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    var data = checkStatus.data;
   
    switch(obj.event){
      
      case 'getCheckData':
  		if (data.length == 1) {
  			//判断月计划审核状态
  			if (data[0].status=='未审核') {
  				var index2 = layer.confirm('你确认审核该退料？', {
  					 
  					btn : [ '确认', '取消' ] //可以无限个按钮
  					,
  					yes : function(layero) {
  						$.ajax({
  							type:"post",
  							url:"${APP_PATH}/checkReturnOfStatus.do",
  							data:{
  								"returnOfId":data[0].returnOfId
  							},
  							dateType:"text",
  							success:function(result){
  								if(result==false){
  									layer.msg("审核失败", {time:3000, icon:5, shift:6});
  								}else{
  									layer.msg("审核成功", {time:3000, icon:1, shift:3});
  									table.reload('test')
  								}
  								layer.close(index2);
  							}
  						});
  					},
  					btn2 : function(index, layero) {
  						layer.close(index2);
  					}
  				}
  				);
  			} else {
  				layer.msg('该退料已审核');
  			}

  		} else if (data.length > 1) {
  			
  			layer.msg('一次只能审核一个退料');
  		} else {
  			layer.msg('请选择一件要审核的退料');
  			
  		}
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    console.log(obj)
    
    if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						obj.del();
						
						$.ajax({
							type:"post",
							url:"${APP_PATH}/deleteReturnOfById.do",
							data:{
								"returnOfId":data.returnOfId
							},
							dateType:"text",
							success:function(result){
								if(result==false){
									layer.msg("删除失败", {time:3000, icon:5, shift:6});
								}else{
									layer.msg("删除成功", {time:3000, icon:1, shift:3});
									table.reload('test')
								}
								layer.close(index);
							}
						});
					});
				} 
   /*  if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.prompt({
        formType: 2
        ,value: data.email
      }, function(value, index){
        obj.update({
          email: value
        });
        layer.close(index);
      });
    } */
  });
});
</script>
</body>
</html>
