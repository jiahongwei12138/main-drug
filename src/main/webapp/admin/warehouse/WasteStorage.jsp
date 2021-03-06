<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>layui</title>
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
	<div id="v6" style="display: none;">
		<form class="layui-form" action="">
			<div class="layui-form-item">

				<div class="layui-inline">
					<label class="layui-form-label">审核人</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
							<option value="">审核人</option>
							<option value="010" selected></option>
							<option value="021">张三</option>
							<option value="0571">李四</option>
						</select>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">审核</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
							<option value="">审核</option>
							<option value="021">通过</option>
							<option value="0571">未通过</option>
						</select>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">入库仓库</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
							<option value="">仓库选择</option>
							<option value="021">废弃入库1</option>
							<option value="0571">废弃仓库2</option>
						</select>
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">入库时间</label>
					<div class="layui-input-inline">
						<input type="text" name="date" id="date" lay-verify="date"
							placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-inline">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-inline"">
						<input type=" tel" name="phone" lay-verify="required"
							autocomplete="off" class="layui-input">
					</div>
				</div>

			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>


	<div style="display: none;" id="div13">
		<select name="city" lay-verify="">
			<option value="010" selected>审核中</option>
			<option value="021">审核通过</option>
			<option value="0571">审核没有通过</option>
		</select>
		<button type="button" class="layui-btn layui-btn-normal">提交</button>
	</div>

	<div style="display: none;" id="div14">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">入库编号</label>
					<div class="layui-input-inline"">
						<input type=" tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input" placeholder="保存后自动添加"
							disabled="disabled">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入库主题</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">制单人</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>



			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">货物名称</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">货物数量</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">采购员 </label>
					<div class="layui-input-inline">
						<input type="text" name="number" lay-verify="required|number"
							autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">货物金额</label>
					<div class="layui-input-inline">
						<input type="text" name="number" lay-verify="required|number"
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入库时间</label>
					<div class="layui-input-inline">
						<input type="text" name="date" id="date" lay-verify="date"
							placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">供应商</label>
					<div class="layui-input-inline">
						<input type="tel" name="url" lay-verify="url" autocomplete="off"
							class="layui-input" disabled="disabled">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">采购部门</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">交货人</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">验收人 </label>
					<div class="layui-input-inline">
						<input type="text" name="number" lay-verify="required|number"
							autocomplete="off" class="layui-input">
					</div>
				</div>
			</div>
		</form>

	</div>


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
						  <a href="http://www.layui.com" class="layui-btn layui-btn-sm layui-btn-normal">搜索</a>
					</div>
	 			</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" name="title" required lay-verify="required" placeholder="请输入订单编号" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <a href="http://www.layui.com"class="layui-btn layui-btn-sm layui-btn-normal">搜索</a>
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						   <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData" >入库审核</button>
					</div>
				</div>
			</div>
</script>

	<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">详情</a>
			<a class="layui-btn layui-btn-xs" lay-event="shenhe">审核</a>
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
					field : 'Id',
					title : 'ID'
				}, {
					field : 'Serial',
					title : '入库编号'
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
				case 'getCheckData':
					var data = checkStatus.data;
					layer.open({
						type : 1,
						content : $('#v6')
					});
					break;
				}
				;
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
				} else if (obj.event === 'shenhe') {
					layer.open({
						type : 1,
						area : [ '500px', '300px' ],
						content : $('#div13')
					});
				}
			});
		});
	</script>


	<script>
		layui
				.use(
						[ 'form', 'layedit', 'laydate' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

							//日期
							laydate.render({
								elem : '#date'
							});
							laydate.render({
								elem : '#date1'
							});

							//创建一个编辑器
							var editIndex = layedit.build('LAY_demo_editor');

							//自定义验证规则
							form.verify({
								title : function(value) {
									if (value.length < 5) {
										return '标题至少得5个字符啊';
									}
								},
								pass : [ /^[\S]{6,12}$/, '密码必须6到12位，且不能出现空格' ],
								content : function(value) {
									layedit.sync(editIndex);
								}
							});

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
