<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>日生产计划</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

	<table class="layui-hide" id="test" lay-filter="test"></table>
	
	<div id="table2Div3" style="display:none">
		<table class="layui-hide" id="test2" lay-filter="test2"
			style="display: none;"></table>
	</div>
	
	<div id="table2Div4" style="display:none">
		<table class="layui-hide" style="display: none" id="tests"
			lay-data="{id:'idTest'}" lay-filter="tests">
		</table>
	</div>
	
	
	<div id="dibId" style="display:none">
		<table class="layui-hide" id="testSee" lay-filter="testSee"
			style="display: none;"></table>
	</div>
	

	<!-- 审核人和审核时间 -->
	<div style="display: none;" id="nameAndTimeDiv2">
		<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test5" name="dAuditingDate"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">员工</label>
				<div class="layui-input-inline">
					<select name="dAuditorName" id="dAuditorName" lay-verify="" lay-search=""></select>
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
	
	<!-- 添加生产订单 -->
	<div style="display: none;" id="nameAndTimeDiv3">
		<form class="layui-form" id="formIdOne3">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">制定日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test6" name="poData"
						placeholder="yyyy-MM-dd">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">制定员工</label>
				<div class="layui-input-inline">
					<select name="poProposerId" id="poProposerId" lay-verify="" lay-search=""></select>
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
	
	
	<script type="text/html" id="toolbarDemo">
		<div class="layui-input-inline">
		  <div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-friends"></i>审核日计划 </button>
		    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckLength"><i class="layui-icon layui-icon-add-1"></i>制定生产订单</button>
		  </div>
		</div>
		<div class="layui-input-inline" style="margin-top:10px;">
			<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">状态查询</label>
			<div class="layui-input-inline">
				<select name="city" lay-verify="">
		  			<option value="">审核状态</option>
		  			<option value="010" >未审核</option>
		  			<option value="021">审核未通过</option>
		 			<option value="0571">审核通过</option>
				</select>  
			</div>
		</div>
	</script>

	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
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
				elem : '#test1'
			});
			//年月选择器
			laydate.render({
				elem : '#test3',
				type : 'month'
			});
			//常规用法
			laydate.render({
				elem : '#test5'
			});
			laydate.render({
				elem : '#test6'
			});
			
			table.render({
				elem : '#test',
				url : '${APP_PATH}/selectDayPalnView.do',
				toolbar : '#toolbarDemo',
				title : '日生产计划',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'dplanId',
					title : '日生产计划编号',
					unresize : true
				}, {
					field : 'mplanId',
					title : '月生产计划编号',
					unresize : true
				}, {
					field : 'dapplyDate',
					title : '制定日期',
					unresize : true
				}, {
					field : 'dproposerName',
					title : '申请人',
					unresize : true
				},  {
					field : 'dstatus',
					title : '审核状态',
					unresize : true
				}, {
					field : 'dauditorName',
					title : '审核人',
					unresize : true
				}, {
					field : 'dauditingDate',
					title : '审核时间',
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
			
			
			//查询所有员工姓名
			$.ajax({
				type:"post",
	    		url:"${APP_PATH}/selectEmployee.do",
	    		success:function(result){
	    			var deptment=result.data;
	    			var content='<option value=""></option>';
	    			$.each(deptment,function(index,item){
	    				content+='<option id="opt'+item.empId+'" value="'+item.empId+'">'+item.empName+'</option>';
					});
	    			$("#poProposerId").html(content);
	    			//刷新select选择框渲染
	    			form.render('poProposerId');
	    		}
			 });
			
			//生产订单查询所有员工姓名
			$.ajax({
				type:"post",
	    		url:"${APP_PATH}/selectEmployee.do",
	    		success:function(result){
	    			var deptment=result.data;
	    			var content='<option value=""></option>';
	    			$.each(deptment,function(index,item){
	    				content+='<option id="opt'+item.empId+'" value="'+item.empName+'">'+item.empName+'</option>';
					});
	    			$("#dAuditorName").html(content);
	    			//刷新select选择框渲染
	    			form.render('dAuditorName');
	    		}
			 });

			//工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				var data = checkStatus.data;
				var dplanId=data[0].dplanId;
				
				switch (obj.event) {
				case 'getCheckData': //审核日计划
					if (data.length == 1) {
						//判断月计划审核状态
						if (data[0].dstatus == '未审核') {
							var index2 = layer.confirm('你确认审核该生产计划？', {
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
								    		url:"${APP_PATH}/updateDplanAudit.do?dplanId="+dplanId,
								        	data:$("#formIdOne2").serialize(),
								    		success:function(data){
								    			table.reload('test');
								           	}
								        });
										layer.close(index88);
										table.reload('test');
										layer.msg('计划审核成功');
									},
									btn2 : function(index, layero) {
										layer.close(index88);
									}
								});

							});
						} else {
							layer.msg('该日计划已审核');
						}

					} else if (data.length > 1) {
						layer.msg('最多只能审核一条日计划');
					} else {
						layer.msg('请选择一条要审核日计划');
					}
					break;
					
				//制定生产订单	
				case 'getCheckLength': 
					if (data.length == 1) {
						//判断日计划审核状态
						if (data[0].dstatus == '已审核') {
							var index = layer.open({
								title : '制定生产订单',//标题
								type : 1,//样式
								shade : 0,
								offset : [ '5%', '15%' ],//设置位移
								btn : [ '确认', '取消' ],
								yes : function(index, layero) {
									var index2 = layer.confirm('你确认制定该生产计划？', {
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
										    		url:"${APP_PATH}/addProductionOrder.do?dplanId="+dplanId,
										        	data:$("#formIdOne3").serialize(),
										    		success:function(data){
										    			layer.close(index);
														layer.close(index88);
										           }
										        }); 
												layer.close(index);
												layer.close(index88);
												layer.msg('计划制定成功');
												table.reload('tests');
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
							    		url:"${APP_PATH}/deleteCancelPo.do",
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
								url : '${APP_PATH}/selectAddpo.do?dplanId='+dplanId,
								cols : [[{
									field : 'dpdId',
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
									field : 'dplanQuantity',
									title : '日计划生产量',
									unresize : true
								}, {
									field : 'podsSurplus',
									title : '日计划剩余生产量 ',
									unresize : true
								}, {
									field : 'podsQuantity',
									title : '输入生产量',
									edit:true,
									unresize : true
								}]]
							});
							
							
							table.on('edit(tests)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
								var data=obj.data;
								var dpdId=data.dpdId;
								var proId=data.proId;
								var podsQuantity=data.podsQuantity;
								var podsSurplus=data.podsSurplus;
								var podsQuantity=obj.value; //得到修改后的值
								
								if(isNaN(podsQuantity)||podsQuantity<0){
									layer.msg('输入错误', {anim: 6});
					                table.reload('tests');
								}else{
					    			if(podsSurplus<podsQuantity){
					    				layer.msg('日计划剩余生产量'+(podsSurplus), {anim: 6});
					    				table.reload('tests');
					    			}else{
					    				$.ajax({
											type:"post",
								    		url:"${APP_PATH}/updatePodsQuantity.do?",
								    		data:{
								    			dpdId:dpdId,
								    			proId:proId,
								    			podsQuantity:podsQuantity
								    		},
								    		success:function(data){
								    			
								           }
										});
					    			}
								}
							});
							
						} else {
							layer.msg('该日计划未审核');
						}
					} else if (data.length > 1) {
						layer.msg('一次最多只能制定一条日计划');
					} else {
						layer.msg('请选择要制定订单的日计划');
					}
					break;
				}
				;
			});

			//监听工具条
			table.on('tool(test)', function(obj) {
				var data=obj.data;
				var dplanId=data.dplanId;
				var mplanId=data.mplanId;
				
				if (obj.event === 'detail') {
					layer.open({
						title : '计划详情',
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
						url : '${APP_PATH}/selectDplanDetails.do?dplanId='+dplanId,
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
							field : 'dplanQuantity',
							title : '日生产数量',
							totalRow : true,
							unresize : true
						}

						] ]
					});
				} else if (obj.event === 'del') {
					layer.confirm('确认删除该计划？', function(index) {
						$.ajax({
							type:"post",
							url:"${APP_PATH}/deleteDplan.do?dplanId="+dplanId+"&mplanId="+mplanId,
							success:function(data){
								
							}
						});
						layer.close(index);
						table.reload('test');
					});
					
				//修改 	
				} else if (obj.event === 'edit') {
					if (data.dstatus == '未审核') {
						var index = layer.open({
							title : '修改计划详情',//标题
							type : 1,//样式
							shade : 0,
							area : [ '880px', '550px' ],
							content : $("#table2Div3"),
							offset : [ '5%', '15%' ],//设置位移
							btn : [ '确认', '取消' ],
							yes : function(index, layero) {
								var index2 = layer.confirm('你确认修改该生产计划？', {
									btn : [ '确认', '取消' ], //可以无限个按钮
									btn2 : function(index, layero) {
										layer.close(index2);
									}
								}, function(layero) {
						        	$.ajax({
							        	type:"post",
							    		url:"${APP_PATH}/updateAffirmDplanDetails.do",
							    		data:{
							    			mplanId:mplanId,
							    			dplanId:dplanId
							    		},
							    		success:function(data){
							    			
							           }
							        }); 
									layer.close(index);
									layer.msg('修改成功');
									table.reload('test2');
									table.reload('test');
								});
							},
							btn2 : function(index, layero) {
								layer.close(index);
								//点击第一个取消删除刚刚添加的数据
								$.ajax({
						        	type:"post",
						    		url:"${APP_PATH}/updateDplanDetailsCancel.do?dplanId="+dplanId,
						    		success:function(data){
						    			layer.msg('已取消');
						           }
						        });
							},
							success : function(layero) {
								var mask = $(".layui-layer-shade");
								mask.appendTo(layero.parent());
							},
							end : function() {
								$('[lay-id="test2"]').css("display", "none");
							}
						});

						table.render({
							elem : '#test2',
							url : '${APP_PATH}/selectUpdateView.do?dplanId='+dplanId,
							totalRow : true,
							cols : [ [{
								field : 'dpdId',
								title : '日计划详情Id',
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
								field : 'dplanQuantity',
								title : '日计划生产数量',
								unresize : true
							}, {
								field : 'number',
								title : '修改日生产数量',
								unresize : true,
								edit : 'text'
							}]]
						});
						
						table.on('edit(test2)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
							var data=obj.data;
							var proId=data.proId;
							var dpdId=data.dpdId;
							var dplanQuantity=data.dplanQuantity;
							var ed=obj.value; //得到修改后的值
							
							if(isNaN(ed)||ed<0){
								layer.msg('输入错误', {anim: 6});
				                table.reload('test2');
							}else{
								$.ajax({
									type:"post",
						    		url:"${APP_PATH}/selectMplanDetailsProNum.do?mplanId="+mplanId,
						    		data:{
						    			proId:proId,
						    			dpdId:dpdId,
						    			dplanQuantity:dplanQuantity,
						    			ed:ed
						    		},
						    		success:function(result){
						    			if(result+dplanQuantity<ed){
						    				layer.msg('月计划剩余完成量'+(result+dplanQuantity), {anim: 6});
						    				table.reload('test2');
						    			}else{
						    				$.ajax({
												type:"post",
									    		url:"${APP_PATH}/updateDplanDetailsProNum.do?mplanId="+mplanId,
									    		data:{
									    			proId:proId,
									    			dpdId:dpdId,
									    			ed:ed
									    		},
									    		success:function(data){
									    			
									           }
						    				});
						    			}
						           }		
								});
							}
						});
					} else {
						layer.msg('该月计划已审核,不能再修改');
					}
				}
			});
		});
	</script>
</body>
</html>
