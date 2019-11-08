<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>成品管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>


</head>
<body class="layui-layout-body">
	<table class="lFyui-hide" id="test" lay-filter="test"></table>
	
	<div id="dibId" style="display:none">
		<table class="layui-hide" id="testSee" lay-filter="testSee"
			style="display: none;"></table>
	</div>

	<!-- 审核人和审核时间 -->
	<div style="display: none;" id="nameAndTimeDiv2">
		<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">质检日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test5" name="qsData"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">质检员工</label>
				<div class="layui-input-inline">
					<select name="qualityInspector" id="qualityInspector" lay-verify=""
						lay-search=""></select>
				</div>

				<div class="layui-input-inline" style="margin-top: 10px;">
					<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核状态</label>
					<div class="layui-input-inline" style="margin-left: -3px;">
						<select name="qualitystatus" id="qualitystatus"
							lay-verify="required" lay-search="">
							<option value="">请选择</option>
							<option value="已通过">已通过</option>
							<option value="未通过">未通过</option>
						</select>
					</div>
				</div>

				<div class="layui-input-inline" style="margin-top: 10px;">
					<label style="margin: 0 10px 0 20px; font-size: 13px;">备注信息</label>
					<div class="layui-input-inline" style="margin-left: -5px;">
						<textarea name="visibles" required lay-verify="required"
							cols="35px" rows="4px" placeholder="请输入计划描述"
							class="layui-textarea"></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script type="text/html" id="toolbarDemo">
		<div class="layui-btn-container">
			<button class="layui-btn layui-btn-sm layui-btn-normal"
				lay-event="getCheckData"><i class="layui-icon layui-icon-find-fill"></i>成品质检</button>
		</div>
	</script>
	
	<script type="text/html" id="barDemo">
		<a class="layui-btn layui-btn-xs" lay-event="see">查看</a>
		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	
	<script>
		layui.use([ 'table', 'form', 'laydate' ], function() {
			var table = layui.table;
			var form = layui.form;
			var $ = layui.$;
			var laydate = layui.laydate;
			
			//审核查询所有员工姓名
			$.ajax({
				type:"post",
	    		url:"${APP_PATH}/selectEmployee.do",
	    		success:function(result){
	    			var deptment=result.data;
	    			var content='<option value=""></option>';
	    			$.each(deptment,function(index,item){
	    				content+='<option id="opt'+item.empId+'" value="'+item.empName+'">'+item.empName+'</option>';
					});
	    			$("#qualityInspector").html(content);
	    			//刷新select选择框渲染
	    			form.render('qualityInspector');
	    		}
			 });
			
			laydate.render({
				elem : '#test5'
			});
			
			table.render({
				elem : '#test',
				url : '${APP_PATH}/selectProductionQualityView.do',
				toolbar : '#toolbarDemo',
				title : '成品质检表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'pqId',
					title : 'ID',
					fixed : 'left',
					unresize : true,
					width:150,
					sort : true
				}, {
					field : 'poId',
					title : '生产订单ID'
				}, {
					field : 'poPracticalQuantity',
					title : '成品总量',
					sort : true
				}, {
					field : 'createDate',
					title : '加入时间'
				}, {
					field : 'qualitystatus',
					title : '质检状态'
				}, {
					field : 'qualityInspector',
					title : '质检员'
				}, {
					fixed : 'right',
					title : '操作',
					align : 'center',
					toolbar : '#barDemo'
				} ] ],
				page : true
			});


			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				var data = checkStatus.data;
				var pqId=data[0].pqId;
				
				switch (obj.event) {
				case 'getCheckData':
					if (data.length == 1) {
						//判断订单审核状态
						if (data[0].qualitystatus == '未质检') {
							var index2 = layer.confirm('你确认质检该订单？', {
								btn : [ '确认', '取消' ], //可以无限个按钮
								btn2 : function(index, layero) {
									layer.close(index2);
								}
							}, function(layero) {
								layer.close(index2);
								var index88 = layer.open({
									type : 1,
									shade : 0.25,
									area : [ '400px', '450px' ],
									content : $('#nameAndTimeDiv2'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
									success : function(layero, index) {
										form.render();
									},
									btn : [ '确认', '取消' ],
									yes : function(layero) {
										$.ajax({
								        	type:"post",
								    		url:"${APP_PATH}/updateProductionQuality.do?pqId="+pqId,
								        	data:$("#formIdOne2").serialize(),
								    		success:function(data){
								    			table.reload('test');
								           	}
								        });
										layer.close(index88);
										table.reload('test');
										layer.msg('质检成功');
									},
									btn2 : function(index, layero) {
										layer.close(index88);
									}
								});

							});
						} else {
							layer.msg('该订单已质检');
						}
					} else if (data.length > 1) {
						layer.msg('最多只能质检一个订单');
					} else {
						layer.msg('请选择要质检的订单');
					}
					break;
				}
				;
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				var pqId=data.pqId;
				
				//console.log(obj)
				if (obj.event === 'del') {
					layer.confirm('确认删除?', function(index) {
						$.ajax({
				        	type:"post",
				    		url:"${APP_PATH}/deleteProductionQuality.do?pqId="+pqId,
				    		success:function(data){
				    			table.reload('test');
				           	}
				        });
						table.reload('test');
						layer.close(index);
						layer.msg('删除成功');
					});
				} else if (obj.event === 'see') {
					layer.open({
						title : '生产成品详情',
						type : 1,
						shadeClose : true,
						area : [ '700px', '460px' ],//大小
						content : $("#dibId"),
						end : function() {
							$('[lay-id="testSee"]').css("display", "none");
						}
					});
					table.render({
						elem : '#testSee',
						url : '${APP_PATH}/selectProqualitydetails.do?pqId='+pqId,
						totalRow : true,
						cols : [ [ {
							type : 'numbers',
							totalRowText : '合计'
						}, {
							field : 'pqdId',
							title : '质检详情ID',
							unresize : true
						}, {
							field : 'proId',
							title : '药品编号',
							unresize : true
						}, {
							field : 'proName',
							title : '药品名称',
							unresize : true
						}, {
							field : 'proQuantity',
							title : '完成数量',
							totalRow : true,
							unresize : true
						}]]
					});
				}
			});
		});
	</script>
</body>
</html>