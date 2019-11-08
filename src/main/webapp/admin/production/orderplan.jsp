<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>生产订单</title>
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
	<table class="layui-hide" id="test2" style="display: none;"></table>
	
		<div id="table2Div4" style="display:none">
		<table class="layui-hide" style="display: none" id="tests"
			lay-data="{id:'idTest'}" lay-filter="tests">
		</table>
	</div>

	<!-- 审核人和审核时间 -->
	<div style="display: none;" id="nameAndTimeDiv2">
		<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test5" name="poAuditingDate"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核员工</label>
				<div class="layui-input-inline">
					<select name="poAuditorName" id="poAuditorName" lay-verify="" lay-search=""></select>
				</div>
				<div class="layui-input-inline" style="margin-top: 10px;">
					<label style="margin: 0 10px 0 20px; font-size: 13px;">备注信息</label>
					<div class="layui-input-inline" style="margin-left: -5px;">
						<textarea name="poplanDetailDes" required lay-verify="required" cols="35px"
							rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>
	
	<!-- 生成领料 -->
	<div style="display: none;" id="nameAndTimeDiv3">
		<form class="layui-form" lay-filter="formAuthority3" id="formIdOne3">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test6" name="applydate"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">员工</label>
				<div class="layui-input-inline">
					<select name="proposerId" id="proposerId" lay-verify="" lay-search=""></select>
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
	
	<div id="dibId" style="display:none">
		<table class="layui-hide" id="testSee" lay-filter="testSee"
			style="display: none;"></table>
	</div>

	<script type="text/html" id="toolbarDemo">
		<div class="layui-input-inline">
		  <div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
		    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-friends"></i>审核生产订单 </button>
		    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckLength"><i class="layui-icon layui-icon-add-1"></i>生成领料单</button>
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="begin"><i class="layui-icon layui-icon-util"></i>开始生产</button>
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="over"><i class="layui-icon layui-icon-template-1"></i>结束生产</button>

		  </div>
		</div>
	</script>

	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>

	<script>
		layui.use([  'table', 'laydate', 'element', 'form', 'layer','jquery' ], 
		function() {
			var layer = layui.layer;
			var element = layui.element;
			var table = layui.table;
			var laydate = layui.laydate;
			var form = layui.form;
			var $ = layui.jquery;
			//常规用法
			laydate.render({
				elem : '#test5'
			});
			
			//常规用法
			laydate.render({
				elem : '#test6'
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
	    			$("#poAuditorName").html(content);
	    			//刷新select选择框渲染
	    			form.render('poAuditorName');
	    		}
			 });
			
			//生成领料查询所有员工姓名
			$.ajax({
				type:"post",
	    		url:"${APP_PATH}/selectEmployee.do",
	    		success:function(result){
	    			var deptment=result.data;
	    			var content='<option value=""></option>';
	    			$.each(deptment,function(index,item){
	    				content+='<option id="opt'+item.empId+'" value="'+item.empId+'">'+item.empName+'</option>';
					});
	    			$("#proposerId").html(content);
	    			//刷新select选择框渲染
	    			form.render('proposerId');
	    		}
			 });
			
			table.render({
				elem : '#test',
				url : '${APP_PATH}/selectProductionOrderView.do',
				toolbar : '#toolbarDemo',
				title : '生产订单',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'center'
				}, {
					field : 'poId',
					title : '生产订单号',
					unresize : true
				}, {
					field : 'dplanId',
					title : '日计划单号',
					unresize : true
				}, {
					field : 'poQuantity',
					title : '生产总数量',
					unresize : true
				},{
					field : 'poPracticalQuantity',
					title : '完成量',
					unresize : true
				}, {
					field : 'poProposerName',
					title : '负责人',
					unresize : true
				}, {
					field : 'poData',
					title : '订单生成时间',
					unresize : true
				}, {
					field : 'poState',
					title : '生产状态',
					unresize : true
				}, {
					field : 'poMaterialState',
					title : '领料状态',
					unresize : true
				}, {
					field : 'poStatus',
					title : '审核状态',
					unresize : true
				}, {
					fixed : 'right',
					width : 145,
					align : 'center',
					toolbar : '#barDemo',
					unresize : true
				} ] ],
				page : true
			});

			//监听工具条
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				var poId = data.poId;
				
				if (obj.event === 'detail') {
					layer.open({
						title : '生产订单详情',
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
						url : '${APP_PATH}/selectproductionOrderDetails.do?poId='+poId,
						totalRow : true,
						cols : [ [ {
							type : 'numbers',
							totalRowText : '合计'
						}, {
							field : 'proId',
							title : '药品编号',
							unresize : true
						}, {
							field : 'proName',
							title : '药品名称',
							unresize : true
						}, {
							field : 'podsQuantity',
							title : '订单数量',
							totalRow : true,
							unresize : true
						}, {
							field : 'podsPracticalQuantity',
							title : '完成量',
							totalRow : true,
							unresize : true
						}]]
					});
				} else if (obj.event === 'del') {
					layer.confirm('确认删除该计划？', function(index) {
						$.ajax({
							type:"post",
							url:"${APP_PATH}/deleteProductionOrder.do",
							data:{
								poId:poId
							},
							success:function(data){
								table.reload('test');
							}
						});
						layer.close(index);
						table.reload('test');
						layer.msg('删除成功');
					});
				}
			});
			
			
			
			//工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				var data = checkStatus.data;
				var poId=data[0].poId;
				var dplanId=data[0].dplanId;
				switch (obj.event) {
				case 'getCheckData':
					if (data.length == 1) {
						//判断订单审核状态
						if (data[0].poStatus == '未审核') {
							var index2 = layer.confirm('你确认审核该生产订单？', {
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
								    		url:"${APP_PATH}/updatePoStatus.do?poId="+poId,
								        	data:$("#formIdOne2").serialize(),
								    		success:function(data){
								    			table.reload('test');
								           	}
								        });
										layer.close(index88);
										table.reload('test');
										layer.msg('订单审核成功');
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
						layer.msg('最多只能审核一个订单');
					} else {
						layer.msg('请选择要审核的订单');
					}
					break;
				case 'getCheckLength': //生成领料单
					if (data.length == 1) {
						//判断日计划审核状态
						if (data[0].poMaterialState == '未申请'&&data[0].poStatus=='已审核') {
							var index2 = layer.confirm('你确认为该订单生成领料订单？', {
								btn : [ '确认', '取消' ], //可以无限个按钮
								btn2 : function(index, layero) {
									layer.close(index2);
								}
							}, function(layero) {
								layer.close(index2);
								var index88 = layer.open({
									title : '生成领料单',//标题
									type : 1,
									shade : 0.25,
									area : [ '400px', '450px' ],
									content : $('#nameAndTimeDiv3'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
									success : function(layero, index) {
										form.render();
									},
									btn : [ '确认', '取消' ],
									yes : function(layero) {
										//提交 
							        	$.ajax({
								        	type:"post",
								    		url:"${APP_PATH}/addMaterialOrder.do?poId="+poId,
								    		data:$("#formIdOne3").serialize(),		
								    		success:function(data){
								    			table.reload('test');
								           	}
								        });
										layer.close(index88);
										table.reload('test');
										layer.msg('领料订单生成成功');
									},
									btn2 : function(index, layero) {
										layer.close(index88);
									}
								});

							});
						} else {
							layer.msg('该生产订单可能未审核或已申请');
						}
					} else if (data.length > 1) {
						layer.msg('一次只能为一个订单生产领料单');
					} else {
						layer.msg('请选择要生成领料单的生产订单');
					}
					break;
				//开始生产
				case 'begin':
					if (data.length == 1) {
						//判断日计划审核状态
						if (data[0].poMaterialState == '已签收' && data[0].poState=='未生产') {
							var index2 = layer.confirm('确认开始生产该订单？', {
								btn : [ '确认', '取消' ], //可以无限个按钮
								btn2 : function(index, layero) {
									layer.close(index2);
								}
							}, function(layero) {
								//开始生产
								$.ajax({
						        	type:"post",
						    		url:"${APP_PATH}/updatePoState.do?poId="+poId,
						    		success:function(data){
						    			table.reload('test');
						           	}
						        });
								layer.close(index2);
								table.reload('test');
								layer.msg('该订单已开始生产');
							});
						} else {
							layer.msg('请确认该订单状态为已签收且未生产');
						}

					} else if (data.length > 1) {
						layer.msg('一次只能生产一个订单');
					} else {
						layer.msg('请选择');
					}
					break;
					
				//结束生产
				case 'over':
					if (data.length == 1) {
						if (data[0].poState=='生产中') {
							var index = layer.open({
								title : '制定生产订单',//标题
								type : 1,//样式
								shade : 0,
								offset : [ '5%', '15%' ],//设置位移
								btn : [ '确认', '取消' ],
								yes : function(index, layero) {
									var index2 = layer.confirm('确认结束生产？', {
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
											content : $('#nameAndTimeDiv3'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
											success : function(layero, index) {
												form.render();
											},
											btn : [ '确认', '取消' ],
											yes : function(layero) {
												//提交 
									        	 $.ajax({
										        	type:"post",
										    		url:"${APP_PATH}/addProductionQuality.do?poId="+poId+"&dplanId="+dplanId,
										        	data:$("#formIdOne3").serialize(),
										    		success:function(data){
										    			layer.close(index);
														layer.close(index88);
										           }
										        });  
												layer.close(index);
												layer.close(index88);
												layer.msg('生产结束');
												table.reload('test');
											},
											btn2 : function(index, layero) {
												layer.close(index88);
											}
										});
									});
								},
								btn2 : function(index, layero) {
									layer.close(index);
									//点击第一个取消删除刚刚添加的数据
									$.ajax({
							        	type:"post",
							    		url:"${APP_PATH}/deleteCancelOver.do?poId="+poId,
							    		success:function(data){
							    			layer.msg('已取消');
							           }
							        });
								},
								area : [ '880px', '550px' ],
								content : $("#table2Div4"),
								success : function(layero) {
									var mask = $(".layui-layer-shade");
									mask.appendTo(layero.parent());
								},
								end : function() {
									$('[lay-id="tests"]').css("display", "none");
								}
							});

							table.render({
								elem : '#tests',
								url : '${APP_PATH}/selectOvrePo.do?poId='+poId,
								cols : [[{
									field : 'podId',
									title : '详情ID',
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
									field : 'podsQuantity',
									title : '生产订单量',
									unresize : true
								},{
									field : 'podsPracticalQuantity',
									title : '输入完成量',
									edit:true,
									unresize : true
								}]]
							});
							
							
							table.on('edit(tests)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
								var data=obj.data;
								var podId=data.podId;
								var proId=data.proId;
								var podsQuantity=data.podsQuantity;
								var podsPracticalQuantity=obj.value; //得到修改后的值
								
								if(isNaN(podsQuantity)||podsQuantity<0){
									layer.msg('输入错误', {anim: 6});
					                table.reload('tests');
								}else{
					    			if(podsQuantity<podsPracticalQuantity){
					    				layer.msg('生产订单数量'+podsQuantity, {anim: 6});
					    				table.reload('tests');
					    			}else{
					    				$.ajax({
											type:"post",
								    		url:"${APP_PATH}/updateAccomplishNum.do",
								    		data:{
								    			podId:podId,
								    			proId:proId,
								    			podsQuantity:podsQuantity,
								    			podsPracticalQuantity:podsPracticalQuantity
								    		},
								    		success:function(data){
								    			
								           }
										});
					    			}
								}
							});
						}else{
							layer.msg('该订单还未开始生产或者生产已经结束');
						}
					}else if (data.length > 1){
						layer.msg('一次只能结束生产一个订单');
					}else{
						layer.msg('请选择');
					}
					break;
				};
			});
		});
	</script>
</body>
</html>