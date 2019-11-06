<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>原料库存</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

	<table class="layui-hide" id="test" lay-filter="test"></table>
	

	<script type="text/html" id="toolbarDemo">
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<select name="city" lay-verify="">
						<option value="">审核状态</option>
						<option value="010" selected>未审核</option>
						<option value="021">审核未通过</option>
						<option value="0571">审核通过</option>
					</select>  
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<button class="layui-btn layui-btn-sm layui-btn-normal" id="search" style="font-size:13px;" lay-event="search1">搜索</button>
					</div>
	 			</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" name="title" required lay-verify="required" placeholder="请输入订单编号" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<button class="layui-btn layui-btn-sm layui-btn-normal" id="search" style="font-size:13px;" lay-event="search2">搜索</button>
					</div>
				</div>
			</div>
</script>

	<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


	<script src="../layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

	<script>
		layui.use('table', function() {
			var table = layui.table;

			table.render({
				elem : '#test',
				url : '../json/FinishedGoods.json',
				toolbar : '#toolbarDemo',
				title : '用户数据表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'ID',
					title : 'ID',
				}, {
					field : 'Serial',
					title : '入库编号'
				}, {
					field : 'Quantity',
					title : '货物类型'
				}, {
					field : 'Quantity',
					title : '货物类型'
				}, {
					field : 'Serial',
					title : '货物数量'
				}, {
					field : 'Time',
					title : '订单生成时间'
				}, {
					field : 'examine',
					title : '审核状态'
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo'
				} ] ],
				page : true
			});

			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
				case 'search1':
					var data = checkStatus.data;
					layer.open({
						type : 1,
						content : $('#v6')
					});
					break;
				case 'search2':
					layer.open({
						type : 1,
						content : $('#v6')
					});
				};
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				//console.log(obj)
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						obj.del();
						layer.close(index);
					});
				} else if (obj.event === 'edit') {
					layer.open({
						type : 1,
						content : $('#div14')
					});
				}
			});
		});
	</script>


	<script>
		layui.use(
						[ 'form', 'layedit', 'laydate' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

							//监听指定开关
							form.on('switch(switchTest)', function(data) {
								layer.msg('开关checked：'
										+ (this.checked ? 'true' : 'false'), {
									offset : '6px'
								});
								layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF',
										data.othis)
							});

							//监听提交
							form.on('submit(demo1)', function(data) {
								layer.alert(JSON.stringify(data.field), {
									title : '最终的提交信息'
								})
								return false;
							});

						});
	</script>


</body>
</html>
