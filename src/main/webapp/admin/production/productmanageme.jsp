<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>成品管理</title>
<link rel="stylesheet" href="../layui/css/layui.css">

</head>
<body class="layui-layout-body">
	<table class="lFyui-hide" id="test" lay-filter="test"></table>
	<script type="text/html" id="toolbarDemo">
			<div class="layui-btn-container">
	<button type="button" id="btn" class="layui-btn layui-btn-sm" lay-event="getCheckData">新增成品信息</button>
	<button type="button" id="btn" class="layui-btn layui-btn-sm" lay-event="CheckProduct">质检成品</button>
  </div>
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
	<script src="../layui/layui.js" charset="utf-8"></script>
	<script>
		layui.use([ 'table', 'form', 'laydate' ], function() {
			var table = layui.table;
			var form = layui.form;
			var $ = layui.$;
			var laydate = layui.laydate;
			laydate.render({
				elem : '#test11',
				format : 'yyyy年MM月dd日'
			});
			table.render({
				elem : '#test',
				url : '${APP_PATH }/selectMainProductAll.do',
				toolbar : '#toolbarDemo',
				title : '成品管理表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'proId',
					title : 'ID',
					fixed : 'left',
					unresize : true,
					sort : true
				}, {
					field : 'proName',
					title : '成品名称',
					edit : 'text'
				}, {
					field : 'proPassQuantity',
					title : '成品数量',
					sort : true
				}, {
					field : 'dAuditingDate',
					title : '加入时间'
				}, {
					field : 'qualityStatus',
					title : '质检状态'
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo'
				} ] ],
				page : true
			});

			//监听提交
			form.on('submit(formDemo)', function(data) {
				layer.msg(JSON.stringify(data.field));

				return false;
			});

			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				var data = checkStatus.data;
				switch (obj.event) {
				case 'getCheckData':
					layer.open({
						type : 1,
						title : '新增成品信息',
						area : [ '600px', '60%' ],
						content : $("#div")
					});
					break;
				case 'CheckProduct':
					
					if (data.length == 1) {
						//判断月计划审核状态
						if (data[0].qualityStatus=='未质检') {
							var index2 = layer.confirm('你确认质检该药品？', {
								btn : [ '确认', '取消' ] //可以无限个按钮
								,
								btn2 : function(index, layero) {
									layer.close(index2);
								}
							}, function(layero) {
								layer.close(index2);
								var index88 = layer.open({
									type : 1,
									shade : 0.25,
									area : [ '400px', '350px' ],
									content : $('#nameAndTime'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
									success : function(layero, index) {
										form.render();
									},
									btn : [ '确认', '取消' ],
									yes : function(layero) {
										layer.close(index);
										layer.close(index88);
										layer.msg('审核成功');
									},
									btn2 : function(index, layero) {
										layer.close(index88);
									}
								});

							});
						} else {
							layer.msg('该药品已质检');
						}

					} else if (data.length > 1) {
						
						layer.msg('一次只能质检一个药品');
					} else {
						layer.msg('请选择一件要质检的药品');
					}
					break;

				}
				;
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				
				var data = obj.data;
				console.log(obj)
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						obj.del();
						
						$.ajax({
							type:"post",
							url:"${APP_PATH}/deleteMainProductById.do",
							data:{
								"proId":proId
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
					});
				} else if (obj.event === 'edit') {
					layer.prompt({
						formType : 2,
						value : data.email
					}, function(value, index) {
						obj.update({
							email : value
						});
						layer.close(index);
					});
				}
			});
		});
	</script>
	<!-- 质检人和质检时间 -->
	<div style="display: none;" id="nameAndTime">

		<form class="layui-form" lay-filter="formAuthority3" id="formIdOne3">

			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">质检日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test5"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">质检人员</label>
				<div class="layui-input-inline">
					<select name="city" lay-verify="" lay-search="">
						<option value="">质检人</option>
						<option value="010">张三</option>
						<option value="021">李四</option>
						<option value="0571">王五</option>
					</select>
				</div>
				<div class="layui-input-inline" style="margin-top: 10px;">
					<label style="margin: 0 10px 0 20px; font-size: 13px;">备注信息</label>
					<div class="layui-input-inline" style="margin-left: -5px;">
						<textarea name="des" required lay-verify="required" cols="35px"
							rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>

	<div id='div' style="display: none;">
		<br />
		<form class="layui-form" action="" id="form">
			<div class="layui-form-item">
				<label class="layui-form-label">成品名称：</label>
				<div class="layui-input-block">
					<input type="text" name="title" required lay-verify="required"
						placeholder="请输入名称" autocomplete="off" class="layui-input">
				</div>
				<br /> <label class="layui-form-label">成品数量：</label>
				<div class="layui-input-block">
					<input type="text" name="number" required lay-verify="required"
						placeholder="请输入数量" autocomplete="off" class="layui-input">
				</div>
				<br /> <label class="layui-form-label">质检人：</label>
				<div class="layui-input-block">
					<input type="text" name="number" required lay-verify="required"
						placeholder="请输入姓名" autocomplete="off" class="layui-input">
				</div>

				<div class="layui-form-item">
					<br /> <label class="layui-form-label">选择日期：</label>
					<div class="layui-input-inline" style="margin-bottom: 20px;">
						<input type="text" class="layui-input" required
							lay-verify="required" id="test11" placeholder="yyyy年MM月dd日">
					</div>
					<div class="layui-form-mid layui-word-aux">时间不能为过去！</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">处理状态：</label>
					<div class="layui-input-block">
						<select name="state" lay-verify="required">
							<option value="请选择"></option>
							<option value="已通过">已通过</option>
							<option value="未通过">未通过</option>
							<option value="未处理">未处理</option>
						</select>
					</div>
				</div>
				<br />
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</div>

		</form>
	</div>
</body>
</html>
