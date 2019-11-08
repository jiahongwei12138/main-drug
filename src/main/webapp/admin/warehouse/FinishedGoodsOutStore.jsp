<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>成品出库审核</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<div style="margin-top: 10px;margin-left: 5px">
		<form class="layui-form"> <!-- OutStoreState OutStoreType -->
			<div class="layui-input-inline" style="margin-right: 20px;">
				<select id="OutStoreState" name="OutStoreState" layui-verify="" lay-filter="OutStoreState" style="font-size:13px;">
					<option value="1" selected> 已出库 </option>
					<option value="2"> 未出库</option>
				</select> 
				
			</div>
			<div class="layui-input-inline">
				<select id="OutStoreType" name="OutStoreType" layui-verify="" lay-filter="OutStoreType" style="font-size:13px;">
					<option value="1" selected> 销售出库 </option>
					<option value="2"> 定期清理出库</option>
				</select>
			</div>
			
		</form>
	</div>
	<table class="layui-hide" id="test" lay-filter="test"></table>

	
	<div id="div4" style="display: none;">
		<table class="layui-hide" id="layerTable" lay-filter="layerTable"></table>
	</div>
	<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit"> 详情 </a>
			<a class="layui-btn layui-btn-xs" lay-event="shenhe"> 审核 </a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"> 删除   </a>
</script>

	<script>
		layui.use(['table','form'], function() {
			var table = layui.table;
			var form = layui.form;
			var tableIns =table.render({
				elem : '#test',
				url : '${APP_PATH}/getMainProductOutStorageInf.do?OutStoreState=1&OutStoreType=1',
				defaulttoolbar : [],
				title : '用户数据表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					title : 'ID',
					fixed : 'left',
					unresize : true,
					type: 'numbers'
				},{
					field : 'posId',
					title : '隐藏Id列',
					hide : true
				},  {
					field : 'poSTypeName',
					title : '出库类型'
				}, {
					field : 'posTime',
					title : '出库时间'
				},{
					field : 'whID',
					title : '仓库Id',
					hide : true
				}, {
					field : 'sname',
					title : '出库仓库'
				}, {
					field : 'posState',
					title : '出库状态'
				}, {
					field : 'checkStates',
					title : '审核状态'
				},{
					field : 'empName',
					title : '审核人姓名'
				},{
					field : 'orderId',
					title : '销售订单Id',
					hide : true
				},{
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
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
						content : $('#v1')
					});
					break;
				}
				;
			});
			//监听下拉框 OutStoreState OutStoreType
			form.on('select(OutStoreState)', function(data){
				  var OutStoreState = data.value; //得到被选中的值
				  var OutStoreType =$('#OutStoreType').val();
				  tableIns.reload({
					  url:'${APP_PATH}/getMainProductOutStorageInf.do',
					  where :{
						  OutStoreState : OutStoreState,
						  OutStoreType : OutStoreType
						  }
					});
				});
			
			form.on('select(OutStoreType)', function(data){
				  var OutStoreType = data.value; //得到被选中的值
				  var OutStoreState =$('#OutStoreState').val();
				  tableIns.reload({
					  url:'${APP_PATH}/getMainProductOutStorageInf.do',
					  where :{
						  OutStoreState : OutStoreState,
						  OutStoreType : OutStoreType
						  }
					});
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
					console.log(data);
					layer.open({
						type : 1,
						offset: 'auto',
						area: ['50%', '30%'],
						content : $('#div4')
					});
					var layerTable =table.render({
						elem : '#layerTable',
						url : '${APP_PATH}/getMainSaleorderdetail.do?orderId='+data.orderId,
						defaulttoolbar : [],
						title : '用户数据表',
						cols : [ [ {
							field : 'Id',
							title : 'ID',
							fixed : 'left',
							unresize : true,
							type: 'numbers'
						},{
							field : 'podId',
							title : '成品Id主键',
							hide : true
						}, {
							field : 'proNum',
							title : '药品数量',
						}, {
							field : 'proPrice',
							title : '药品价格小计',
						},  {
							field : 'proName',
							title : '药品名称'
						}] ]
						
					});
				} else if (obj.event === 'shenhe') {
					if(data.checkStates=="已审核"){
						layer.msg('不能重复审核',{icon: 6});
						}else{
							layer.confirm('是否审核并出库', {icon: 3, title:'提示'}, function(index){
									  console.log(data);
									   $.ajax({
										  url:'${APP_PATH}/OutProStorageCheck.do',
										  data:{
											  posId : data.posId,
											  orderId : data.orderId,
											  whID : data.whID,
											  },
										  success : function(data){
											  tableIns.reload();
											  }
										  }) 
									  layer.close(index);
								});
							}
					
				}
			});
		});
	</script>

</body>
</html>