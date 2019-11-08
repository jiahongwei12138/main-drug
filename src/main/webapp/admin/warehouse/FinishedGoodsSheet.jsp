<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>成品盘点</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<div style="margin-top: 10px;margin-left: 10px">
		<form class="layui-form" >
	     			<div class="layui-input-inline">
						<select id="checkS" name="checkS" lay-filter="checkS" layui-verify="">
							<option value="1" selected> 成品仓库1 </option>
							<option value="2"> 成品仓库2 </option>
						</select>  
					</div>
				</form>
	</div>

	<table class="layui-hide" id="test" lay-filter="test"></table>

	<div id="v3" style="display: none;">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">药物名称</label>
					<div class="layui-input-inline"">
						<input type=" tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">药物编号</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">药物类型</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">药物数量</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">药物单价</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入库部门</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">入库时间</label>
					<div class="layui-input-inline">
						<input type="text" name="number" lay-verify="required|number"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入库时间</label>
					<div class="layui-input-inline">
						<input type="text" name="number" lay-verify="required|number"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
			</div>
		</form>
	</div>

	

	<script type="text/html" id="toolbarDemo">
			<div class="layui-form-item">
				
			</div>
</script>

	<script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>



	<script>
		layui.use(['table','form','jquery'], function() {
			var table = layui.table;
			var form = layui.form;
			var $ = layui.jquery;
			var tableIns = table.render({
				elem : '#test',
				url : '${APP_PATH}/getProductStorageInf.do?whID=1',
				title : '用户数据表',
				defaultToolbar:[],
				toolbar:'#toolbarDemo',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'Id',
					title : '序号',
					fixed : 'left',
					type: 'numbers',
					width: '10%'
				}, {
					field : 'productSId',
					title : '隐藏列',
					fixed : 'left',
					unresize : true,
					hide: true
					
				}, {
					field : 'proName',
					title : '产品名'
				}, {
					field : 'productNumber',
					title : '库存量 '
				}, {
					field : 'whID',
					title : '仓库Id',
					hide: true
				},{
					field : 'sname',
					title : '入库仓库'
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
					layer.alert(JSON.stringify(data));
					break;
				}
				;
			});

			 form.on('select(checkS)', function(data){
				  var whId = data.value; //得到被选中的值
				  console.log(whId);
				  tableIns.reload({
					  url:'${APP_PATH}/getProductStorageInf.do?whID='+whId,
					});
				  /*var limit =  $(".layui-laypage-limits").find("option:selected").val() //分页数目
				  var page = $(".layui-laypage-em").next().html(); //当前页码值
				  console.log($(".layui-laypage-limits").find("option:selected").val());
				  console.log( $(".layui-laypage-em").next().html());
				  $.ajax({
						url:'${APP_PATH}/getProductStorageInf.do',
						data:{
							'whID' :  whId,
							'limit' : limit,
							'page' : page
							},
						success: function(dataInf){
							console.log(dataInf);
							tableIns.render(dataInf);
							}
					  }) */
				});    
			
				  
			/*  table.reload({
				  elem: '#demo' //指定原始表格元素选择器（推荐id选择器）
				  ,height: 315 //容器高度
				  ,cols: [{}] //设置表头
				  //,…… //更多参数参考右侧目录：基本参数选项
				}); */
			                         
			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				console.log(obj)
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						
						obj.del();
						layer.close(index);
						
					});
				} else if (obj.event === 'edit') {
					layer.open({
						type : 1,
						content : $('#v3')
					});
				}
			});
		});
	</script>

</body>
</html>

