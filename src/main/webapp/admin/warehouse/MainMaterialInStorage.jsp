<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>原料入库</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	
	<div id="div" style="display:none">
		<table class="layui-hide" id="templateTable" lay-filter="templateTable"></table>
	</div>

	<script type="text/html" id="toolbarDemo">
			<div class="layui-form-item">
       			<div class="layui-input-inline">
					<select name="inStoregState" id="inStoregState">
						<option value="">入库状态</option>
						<option value="未入库">未入库</option>
						<option value="已入库">已入库</option>
					</select>  
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<button class="layui-btn layui-btn-sm layui-btn-normal" id="search" style="font-size:13px;" lay-event="search">搜索</button>
					</div>
				</div>
			</div>
</script>

<script type="text/html" id="toolbarDemo1">
			<div class="layui-form-item">
       			<div class="layui-input-inline">
					<select name="detailsqualitystatus" id="detailsqualitystatus">
						<option value="">质检状态</option>
						<option value="质检通过">质检通过</option>
						<option value="质检未通过">质检未通过</option>
					</select>  
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<button class="layui-btn layui-btn-sm layui-btn-normal" id="search1" style="font-size:13px;" lay-event="search1">搜索</button>
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<input type="text" name="detailsName" id="detailsName" placeholder="原料名称" autocomplete="off" class="layui-input"> 
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<button class="layui-btn layui-btn-sm layui-btn-normal" id="search1" style="font-size:13px;" lay-event="search2">搜索</button>
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						<button class="layui-btn layui-btn-sm layui-btn-normal" id="audit" style="font-size:13px;margin-top:20px;" lay-event="audit">入库审核</button>
					</div>
				</div>
			</div>
</script>

<script type="text/html" id="barDemo">
	<a class="layui-btn layui-btn-xs" lay-event="shenhe">入库审核</a>
</script>

	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

	<script>
		layui.use('table', function() {
			var table = layui.table;
			table.render({
				elem : '#test',
				url : '${APP_PATH}/AllMainPurchasePlan.do',
				toolbar : '#toolbarDemo',
				title : '采购订单数据表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'planId',
					title : '采购ID',
				}, {
					field : 'planName',
					title : '计划名'
				},  {
					field : 'planTotalPrices',
					title : '预计采购金额'
				}, {
					field : 'planRealTotalPrices',
					title : '实际采购金额'
				}, {
					field : 'checkState',
					title : '财务审核状态'
				}, {
					field : 'inStoregState',
					title : '入库状态'
				}, {
					field : 'rawMaterialTheQualityStatus',
					title : '质检审核状态'
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo'
				} ] ],
				page : true,
				id : 'testTable'
			});

			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				var inStoregState = $("#inStoregState").val();
				switch (obj.event) {
				case 'search':
					table.reload('testTable', {
						page: {
							curr: 1
						},
						where: {
							inStoregState: inStoregState
						},
						url: '${APP_PATH}/AllMainPurchasePlan.do', 
						method: 'post'
					});
					break;
				};
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				if (obj.event === 'shenhe') {
					 particulars(data);
				}
			});

			//订单详情
			function particulars(data){
				alert(data.planId);
				layer.open({
					type: 1,
					title: '订单详情',
					area: ['1200px', '600px'], //宽高
					content: $('#div'),
					success: function(){
						table.render({
							elem: '#templateTable',
							id: 'testTable1',
							method: 'post', 
							url: '${APP_PATH}/getMainPurchaseDetails.do?planId='+data.planId, 
							toolbar : '#toolbarDemo1',
							page: true, //是否分页
							limit: 5, //每页显示的条数
							limits: [5, 10, 20], //每页条数的选择项，默认：[10,20,30]。
							cols: [
								[{
									type : 'checkbox',
									fixed : 'left'
								}, {
									field: 'detailsId', //字段名
									title: 'ID', //标题
									width: 50
								}, {
									field: 'detailsName', //字段名
									title: '原料名称', //标题
									unresize: true
								}, {
									field: 'detailsCategory', //字段名
									title: '原料分类', //标题
									unresize: true
								}, {
									field: 'detailsQuantity', //字段名
									title: '原料数量', //标题
									unresize: true
								}, {
									field: 'detailsUnitPrice', //字段名
									title: '原料单价', //标题
									unresize: true
								}, {
									field: 'detailsPrice', //字段名
									title: '原料小计', //标题
									unresize: true
								}, {
									field: 'detailsqualitystatus', //字段名
									title: '质检状态', //标题
									unresize: true
								}, {
									field: 'detailsQuantitys', //字段名
									title: '抽样数量', //标题
									unresize: true
								}, {
									field: 'detailsPassQuantity', //字段名
									title: '通过数量', //标题
									unresize: true
								}, {
									field: 'percent', //字段名
									title: '合格率', //标题
									unresize: true
								}]]
						});
	
						//监听头工具栏事件
						table.on('toolbar(templateTable)', function(obj) {
							var planId = data.planId;
							var detailsqualitystatus = $("#detailsqualitystatus").val();
							var detailsName = $("#detailsName").val();
							switch (obj.event) {
							case 'search1':
								table.reload('testTable1', {
									page: {
										curr: 1
									},
									where: {
										detailsqualitystatus: detailsqualitystatus,
										planId: planId
									},
									url: '${APP_PATH}/getDetailsqualitystatus.do', 
									method: 'post'
								});
								break;
							case 'search2':
								table.reload('testTable1', {
									page: {
										curr: 1
									},
									where: {
										detailsName: detailsName
									},
									url: '${APP_PATH}/getDetailsName.do', 
									method: 'post'
								});
								break;
							case 'audit':
								layer.open({
									type: 1,
									
									
								});
							break;
							};
						});

						//监听复选框事件
						 table.on('checkbox(templateTable)', function(obj) {
							 if(obj.type == 'all') {
								 // 复选框全选切换
								 console.log(obj.data);
								 alert(obj.data);
								 alert(obj.data.detailsId);
							 } else if(obj.type == 'one') {
								 // 单行复选框切换（当单行和全选同时 选中行数据解决采用行监听事件获取 ）
								 console.log(obj.data);
								 alert(obj.data);
								 alert(obj.data.detailsId);
							 }
						})
					}
				});
			};
		});
	</script>
</body>
</html>