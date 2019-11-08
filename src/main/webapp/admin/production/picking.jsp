<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>生产领料</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

	<table class="layui-hide" id="test" lay-filter="test"></table>
	<div id="table2Div">
		<table class="layui-hide" id="test2" style="display: none;"></table>
	</div>
	
	<!-- 审核人和审核时间 -->
	<div style="display: none;" id="nameAndTimeDiv2">
		<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test5" name="auditingdate"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核人员</label>
				<div class="layui-input-inline">
					<select name="auditorName" id="auditorName" lay-verify="" lay-search="" ></select>
				</div>
				<div class="layui-input-inline" style="margin-top: 10px;">
					<label style="margin: 0 10px 0 20px; font-size: 13px;">备注信息</label>
					<div class="layui-input-inline" style="margin-left: -5px;">
						<textarea name="materialDes" required lay-verify="required" cols="35px"
							rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>

	<script type="text/html" id="toolbarDemo">
		<div class="layui-input-inline">
		  <div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
		    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-friends"></i>审核领料单 </button>
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckSign"><i class="layui-icon layui-icon-ok"></i>原料签收</button>
		  </div>
		</div>
	</script>

	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

	<script>
		layui.use([ 'table', 'laydate', 'form', 'layer' ], function() {
			var $ = layui.jquery, layer = layui.layer; //独立版的layer无需执行这一句
			var table = layui.table;
			var laydate = layui.laydate;
			var form = layui.form;
			//常规用法
			laydate.render({
				elem : '#test5'
			});
			//年月选择器
			laydate.render({
				elem : '#test3',
				type : 'month'
			});
			
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
	    			$("#auditorName").html(content);
	    			//刷新select选择框渲染
	    			form.render('auditorName');
	    		}
			 });
			

			table.render({
				elem : '#test',
				url : '${APP_PATH}/selectMaterialOrderView.do',
				toolbar : '#toolbarDemo',
				title : '领料单',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'moId',
					title : '领料单号',
					unresize : true
				}, {
					field : 'poId',
					title : '生产订单号',
					unresize : true
				}, {
					field : 'proposerName',
					title : '负责人',
					unresize : true
				}, {
					field : 'applydate',
					title : '生成时间',
					unresize : true
				}, {
					field : 'auditorName', 
					title : '审核人',
					unresize : true
				}, {
					field : 'status',
					title : '审核状态',
					unresize : true
				}, {
					field : 'outStock',
					title : '出库状态',
					unresize : true
				},{
					field : 'signfor',
					title : '签收状态',
					unresize : true
				},{
					fixed : 'right',
					width : 178,
					align : 'center',
					toolbar : '#barDemo',
					unresize : true
				} ] ],
				page : true
			});

			//工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				var data = checkStatus.data;
				var moId=data[0].moId;
				var poId=data[0].poId;
				
				switch (obj.event) {
				case 'getCheckData':
					if (data.length == 1) {
						//判断订单审核状态
						if (data[0].status == '未审核') {
							var index2 = layer.confirm('你确认审核该领料单？', {
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
								    		url:"${APP_PATH}/updateMaterialOrderStatus.do?moId="+moId,
								    		data:$("#formIdOne2").serialize(),		
								    		success:function(data){
								    			table.reload('test');
								           	}
								        });
										layer.close(index88);
										table.reload('test');
										layer.msg('领料单审核成功');
									},
									btn2 : function(index, layero) {
										layer.close(index88);
									}
								});

							});
						} else {
							layer.msg('该订单已审核');
						}
					} else if (data.length > 1) {
						layer.msg('只能选择一条记录');
					} else {
						layer.msg('请选择');
					}

					break;
				//签收原料
				case 'getCheckSign':
					if (data.length == 1) {
						//判断领料订单状态
						if (data[0].outStock == '已出库' && data[0].signfor == '未签收'&&data[0].status=='已审核') {
							var index2 = layer.confirm('确定签收该领料订单？', {
								btn : [ '确认', '取消' ], //可以无限个按钮
								btn2 : function(index, layero) {
									layer.close(index2);
								}
							}, function(layero) {
								$.ajax({
						        	type:"post",
						    		url:"${APP_PATH}/updateMoSignfor.do?moId="+moId+"&poId="+poId,
						    		success:function(data){
						    			table.reload('test');
						           	}
						        });
								layer.close(index2);
								table.reload('test');
								layer.msg('已签收');
							});
						} else {
							layer.msg('请确保订单状态为已审核已出库且未签收');
						}
					} else if (data.length > 1) {
						layer.msg('只能选择一条记录');
					} else {
						layer.msg('请选择');
					}
					break;
				};
			});

			//监听工具条
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				var moId = data.moId;
				if (obj.event === 'detail') {
					layer.open({
						title : '领料详情',
						type : 1,
						area : [ '660px', '415px' ],//大小
						content : $("#table2Div"),
						end : function() {
							$('[lay-id="test2"]').css("display", "none");
						}
					});
					table.render({
						elem : '#test2',
						url : '${APP_PATH}/selectMorDetails.do?moId='+moId,
						cols : 
						[[{
							field : 'rawMaterialId',
							title : '原料编号',
							unresize : true
						}, {
							field : 'rawMaterialName',
							title : '原料名称',
							unresize : true
						}, {
							field : 'weight',
							title : '所需数量（kg）',
							unresize : true
						}]]
					});
				} else if (obj.event === 'del') {
					layer.confirm('确认删除？', function(index) {
						$.ajax({
				        	type:"post",
				    		url:"${APP_PATH}/deleteMaterialOrder.do?moId="+moId,
				    		success:function(data){
				    			table.reload('test');
				           	}
				        });
						layer.close(index);
						table.reload('test');
					});
				}
			});
		});
	</script>
</body>
</html>