<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>生产补料管理</title>
		<link rel="stylesheet" href="../layui/css/layui.css">
		
	</head>
	<body class="layui-layout-body">
		<table class="layui-hide" id="test" lay-filter="test"></table>
		<script type="text/html" id="toolbarDemo">
		<div class="layui-inline">
	<button type="button" id="btn" class="layui-btn layui-btn-sm" lay-event="getCheckData">新增补料信息</button>
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
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

		<script src="../layui/layui.js" charset="utf-8"></script>

		<script>
	
	
layui.use(['table','form','laydate'], function(){
  var table = layui.table;
  var form = layui.form;
  var $ = layui.$;
  var laydate = layui.laydate;
    laydate.render({
    elem: '#test11'
    ,format: 'yyyy年MM月dd日'
  });
  table.render({
    elem: '#test'
    ,url:'../json/Produced.json'
    ,toolbar: '#toolbarDemo'
    ,title: '补料数据表'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'id', title:'补料单编号', fixed: 'left', unresize: true, sort: true}
      ,{field:'id2', title:'生产订单编号', edit: 'text'}
      ,{field:'time', title:'申请时间'}
	  ,{field:'state', title:'审核状态'}
	  ,{field:'state2', title:'出库状态', sort: true}
	  ,{field:'applicant', title:'申请人'}
	  ,{field:'type', title:'出库类型'}
	  ,{field:'auditor', title:'审核人'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
    ]]
    ,page: true
  });
  
    //监听提交
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        layer.open({
        type:1,
        title: '新增补料信息',
        area:['800px','75%'],
        content:$("#div")
        });
      break;
    };
  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
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
    }
  });
});
</script>
		<div id='div' style="display: none;">
			<form class="layui-form" action="" id="form">
				<div class="layui-form-item">
					<label class="layui-form-label">补料名称：</label>
					<div class="layui-input-block">
						<input type="text" name="title" required lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
					</div><br />
					<label class="layui-form-label">补料数量：</label>
					<div class="layui-input-block">
						<input type="text" name="number" required lay-verify="required" placeholder="请输入数量" autocomplete="off" class="layui-input">
					</div><br/>
					<label class="layui-form-label">处理人名称：</label>
					<div class="layui-input-block">
						<input type="text" name="number" required lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
					</div>
				<div class="layui-form-item">
					<div class="layui-inline">
					<label class="layui-form-label">请选择日期</label>
						<div class="layui-input-inline" style="margin-bottom:20px;">
							<input type="text" class="layui-input" required lay-verify="required" id="test11" placeholder="yyyy年MM月dd日">
						</div>
						<div class="layui-form-mid layui-word-aux">时间不能为过去！</div>
					<div class="layui-form-item" >
						<label class="layui-form-label">处理状态：</label>
						<div class="layui-input-block">
							<select name="state" lay-verify="required">
								<option value=""></option>
								<option value="已处理">已处理</option>
								<option value="未处理">未处理</option>
							</select>
						</div>
					</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
				</form>
			</div>
	</body>
</html>