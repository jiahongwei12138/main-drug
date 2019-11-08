<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>月生产计划</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->

<style>
/*table外边距*/
.layui-table, .layui-table-view {
	margin: 0px 0;
}
/*弹出层table外边距*/
.layui-table, .layui-table-view {
	margin: 0px;
	padding: 0px;
	margin-bottom: 0px;
}
</style>
</head>
<body>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	
	<div id="table2Div" style="display:none">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px;"></fieldset>
		<div class="layui-inline" style="padding-left:20px; padding-bottom:10px">
			<form  method="post" class="layui-form" layui-filter="example" id="myForm">
				<label width="120px" style="margin:0 5px 0 0px;font-size:13px;">药品选择</label>
			      <div class="layui-input-inline">
			        <select id="select" name="proId" lay-verify="required" lay-search=""></select>
			      </div>
				<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">输入生产数量</label>
				<div class="layui-input-inline">
					 <input type="text" name="number" id="number" lay-verify="number" 
					 placeholder="请输入" autocomplete="off" class="layui-input" />
				</div>
				<button lay-submit lay-filter="added" type="button" class="layui-btn">添加</button>
			</form>
 		</div>
		<table class="layui-hide" style="display: none" id="test2"
			lay-data="{id:'idTest'}" lay-filter="test2">
		</table>
	</div>
	
	<div id="table2Div2" style="display:none">
		<table class="layui-hide" style="display: none" id="test9"
			lay-data="{id:'idTest'}" lay-filter="test9">
		</table>
	</div>
	
	
	<!-- 制定人和制定时间 -->
	<div style="display: none;" id="nameAndTimeDiv">
		<form class="layui-form" lay-filter="formAuthority" id="formIdOne">
			<div class="layui-inline" style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">制定日期</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test1"
					 placeholder="yyyy-MM-dd" name="mAuditingDate">
				</div>
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">制定人员</label>
				<div class="layui-input-inline">
					<select name="mProposerId" lay-verify="" lay-search="" id="mProposerId">
					</select>
				</div>
				<div class="layui-input-inline" style="margin-top: 10px;">
					<label style="margin: 0 10px 0 20px; font-size: 13px;">计划描述</label>
					<div class="layui-input-inline" style="margin-left: -5px;">
						<textarea name="mPlanDetailDes" required lay-verify="required" cols="35px"
							rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- 审核人和审核时间 -->
	<div style="display: none;" id="nameAndTimeDiv2">
		<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">
			<div class="layui-inline"
				style="padding-left: 0px; margin-top: 20px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核日期</label>
				<div class="layui-input-block">
      			<input name="mAuditingDate" class="layui-input" id="test5" type="text" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date"/>
    		</div>
    		
    		
			</div>
			<div style="padding-left: 0px; margin-top: 15px;">
				<label width="120px" style="margin: 0 5px 0 20px; font-size: 13px;">审核人员</label>
				<div class="layui-input-inline">
					<select name="AuditorName" id="AuditorName" lay-verify="" lay-search=""></select>
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
	
	<div id="table2Div3" style="display:none">
		<table class="layui-hide" style="display: none" id="tests"
			lay-data="{id:'idTest'}" lay-filter="tests">
		</table>
	</div>


<script type="text/html" id="toolbarDemo">
  <div class="layui-inline" style="padding-left:20px;">
      <label width="120px" style="margin:0 5px 0 0px;font-size:13px;">请选择月份</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="test3" placeholder="yyyy-MM">
      </div>
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">请选择状态</label>
	<div class="layui-input-inline">
		<select name="city" lay-verify="">
  			<option value="">审核状态</option>
  			<option value="010">未审核</option>
  			<option value="021">审核未通过</option>
 			<option value="0571">审核通过</option>
		</select>  
	</div>
	<button type="button" class="layui-btn layui-btn-normal">查询</button>
  </div>

  <div class="layui-btn-container" style="margin-top:20px;padding-left:20px;">
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckData"><i class="layui-icon layui-icon-add-1"></i>制定月计划 </button>
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="isAll"><i class="layui-icon layui-icon-friends"></i>审核月计划</button>
    <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="getCheckLength"><i class="layui-icon layui-icon-add-1"></i>制定日计划</button>
  </div>
</script>
<script type="text/html" id="barDemo">
  	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
 	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="barDemo2">
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="manageMe">删除</a>
</script>
	
	
<script>
	layui.use([ 'table', 'laydate', 'element', 'form', 'layer','jquery'],
			function() {
				var layer = layui.layer;
				var element = layui.element;
				var table = layui.table;
				var laydate = layui.laydate;
				var form = layui.form;
				var $ = layui.jquery;
				table.render({
					elem : '#test',
					url : '${APP_PATH }/selectMonthPlan.do',
					toolbar : '#toolbarDemo',
					title : '用户数据表',
					cols : [ [ {
						type : 'checkbox',
						fixed : 'left'
					}, {
						field : 'mplanId',
						title : '月计划编号',
						unresize : true
					}, {
						field : 'mproposerName',
						title : '申请人',
						unresize : true
					}, {
						field : 'mapplyDate',
						title : '申请时间',
						unresize : true
					}, {
						field : 'mplanNumber',
						title : '计划完成总量',
						unresize : true
					}, {
						field : 'mrealityNumber',
						title : '实际完成总量',
						unresize : true
					}, {
						field : 'mstatus',
						title : '审核状态',
						unresize : true
					}, {
						field : 'mauditorName',
						title : '审核人',
						unresize : true
					}, {
						field : 'mauditingDate',
						title : '审核时间',
						unresize : true
					}, {
						fixed : 'right',
						title : '操作',
						width : 178,
						align : 'center',
						toolbar : '#barDemo',
						unresize : true
					} ] ],
					page : true
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
				//常规用法
				laydate.render({
					elem : '#test1'
				});

				//查询所有成品名
				$.ajax({
					type:"post",
				  		url:"${APP_PATH}/selectProduct.do",
				  		success:function(result){
				  			var deptment=result.data;
				  			var content='<option value=""></option>';
				  			$.each(deptment,function(index,item){
				  				content+='<option id="opt'+item.proId+'" value="'+item.proId+'">'+item.proName+'</option>';
						});
				  			$("#select").html(content);
				  			form.render('select'); //刷新select选择框渲染
				  		}
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
		    			$("#AuditorName").html(content);
		    			//刷新select选择框渲染
		    			form.render('AuditorName');
		    		}
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
		    			$("#mProposerId").html(content);
		    			form.render('mProposerId'); //刷新select选择框渲染
		    		}
				 });
				
				
				//工具栏事件
				table.on('toolbar(test)', function(obj) {
					var checkStatus = table.checkStatus(obj.config.id);
					switch (obj.event) {
					
					case 'getCheckData':
						form.on('submit(added)', function(obj){
				        	var obj=document.getElementById("select");
				        	var proName=obj.options[obj.selectedIndex].text;
				        	$.ajax({
					        	type:"post",
					    		url:"${APP_PATH}/addProductYzz.do?proName="+proName,
					        	data:$("#myForm").serialize(),
					    		success:function(data){
					                table.reload('test2');
					           }
					        });
						});
						
						table.on('tool(test2)', function(obj) {
			        		if (obj.event === 'manageMe') {
			        			var data = obj.data;
								var mpdId=data.mpdId;
								$.ajax({
									type:"post",
									url:"${APP_PATH}/deleteProduct.do?mpdId="+mpdId,
									success:function(result){
										table.reload('test2');
									}
								});
			        		}
			        	});
			        
					var index = layer.open({
						title : '制定计划详情',//标题
						type : 1,//样式
						shade : 0,
						offset : [ '5%', '15%' ],//设置位移
						btn : [ '确认', '取消' ],
						yes : function(index, layero) {
							$.ajax({
					        	type:"post",
					    		url:"${APP_PATH}/selectCancel.do",
					    		success:function(data){
					    			if(data){
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
												content : $('#nameAndTimeDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
												success : function(layero, index) {
													form.render();
												},
												btn : [ '确认', '取消' ],
												yes : function(layero) {
													//提交 
										        	$.ajax({
											        	type:"post",
											    		url:"${APP_PATH}/addMplans.do",
											        	data:$("#formIdOne").serialize(),
											    		success:function(data){
											    			
											           }
											        }); 
													layer.close(index);
													layer.close(index88);
													layer.msg('计划制定成功');
													table.reload('test2');
													table.reload('test');
												},
												btn2 : function(index, layero) {
													layer.close(index88);
												}
											});
										});
					    			}else{
					    				layer.msg("请添加需要生产的成品");
					    			}
					           }
					        });
							
						},
						btn2 : function(index, layero) {
							layer.close(index);
							//点击第一个取消删除刚刚添加的数据
							$.ajax({
					        	type:"post",
					    		url:"${APP_PATH}/deleteCancel.do",
					    		success:function(data){
					    			
					           }
					        });
						},
						area : [ '880px', '550px' ],
						content : $("#table2Div"),
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
						url : '${APP_PATH}/addProductYzz.do',
						toolbar : '#toolbarDemo2',
						totalRow : true,
						cols : [[{
							field : 'mpdId',
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
							field : 'number',
							title : '成品计划完成量',
							totalRow : true,
							unresize : true
						}, {
							align : 'center',
							toolbar : '#barDemo2',
							unresize : true
						}]]
					});
					break;
						
					case 'getCheckLength':
						var data = checkStatus.data;
						var mplanId=data[0].mplanId;
						if (data.length == 1) {
							//判断月计划审核状态
							if (data[0].mstatus == '已审核') {
								var index = layer.open({
									title : '制定计划详情',//标题
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
												content : $('#nameAndTimeDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
												success : function(layero, index) {
													form.render();
												},
												btn : [ '确认', '取消' ],
												yes : function(layero) {
													//提交 
										        	$.ajax({
											        	type:"post",
											    		url:"${APP_PATH}/adddPlan.do?mplanId="+mplanId,
											        	data:$("#formIdOne").serialize(),
											    		success:function(data){
											    			
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
								    		url:"${APP_PATH}/deleteCancelD.do",
								    		success:function(data){
								    			
								           }
								        });
									},
									area : [ '880px', '550px' ],
									content : $("#table2Div3"),
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
									url : '${APP_PATH}/selectAddDplanDetails.do?mplanId='+mplanId,
									toolbar : '#toolbarDemo2',
									defaultToolbar:[],
									totalRow : true,
									cols : [[{
										field : 'mpdId',
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
										field : 'number',
										title : '月计划完成量',
										unresize : true
									}, {
										field : 'mdetailsSurplus',
										title : '月计划剩余计划量',
										unresize : true
									}, {
										field : 'dplanQuantity',
										title : '输入日计划完成量',
										edit:true,
										unresize : true
									}]]
								});
								
								table.on('edit(tests)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
									var data=obj.data;
									var proId=data.proId;
									var mpdId=data.mpdId;
									var number=data.number;
									var mdetailsSurplus=data.mdetailsSurplus;
									var ed=obj.value; //得到修改后的值
									
						            if (isNaN(ed) || mdetailsSurplus < ed||ed<0) {
						                layer.msg('输入错误,或者剩余完成量不足', {anim: 6});
						                table.reload('tests');
						            } else {
						            	$.ajax({
											type:"post",
								    		url:"${APP_PATH}/selectJudgeDayProNum.do?mplanId="+mplanId,
								    		data:{
								    			proId:proId,
								    			mpdId:mpdId,
								    			number:number,
								    			mdetailsSurplus:mdetailsSurplus,
								    			ed:ed
								    		},
								    		success:function(data){
								    			
								           }
										}); 
						            }
							        
								});
							} else {
								layer.msg('该月计划未审核');
							}
						} else if (data.length > 1) {
							layer.msg('最多只能选择一条月计划');
						} else {
							layer.msg('请选择');
						}
						break;
						
					case 'isAll':
						var data = checkStatus.data;
						var mplanId=data[0].mplanId;
						
						
						
						if (data.length == 1) {
							//判断月计划审核状态
							if (data[0].mstatus == '未审核') {
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
											var obj=document.getElementById("AuditorName");
								        	var proName=obj.options[obj.selectedIndex].text;
											$.ajax({
									        	type:"post",
									    		url:"${APP_PATH}/updateAudit.do?mplanId="+mplanId+"&proName="+proName,
									        	data:$("#formIdOne2").serialize(),
									    		success:function(data){
									    			table.reload('test');
									    			layer.close(index);
													layer.close(index88);
									           }
									        });
											layer.close(index);
											layer.close(index88);
											layer.msg('计划审核成功');
										},
										btn2 : function(index, layero) {
											layer.close(index88);
										}
									});
								});
							} else {
								layer.msg('该月计划已审核');
							}
						} else if (data.length > 1) {
							layer.msg('最多只能审核一条月计划');
						} else{
							layer.msg('请选择一条要审核月计划');
						}
						break;
					}
					;
				});

				
				//监听工具条
				table.on('tool(test)', function(obj) {
					var data = obj.data;
					var mplanId=data.mplanId;
					if (obj.event === 'detail') {
					 layer.open({
						title : '计划详情',//标题
						type : 1,//样式
						shade : 0,
						offset : [ '5%', '15%' ],//设置位移
						area : [ '880px', '433px' ],
						content : $("#table2Div2"),
						success : function(layero) {
							var mask = $(".layui-layer-shade");
							mask.appendTo(layero.parent());
							//其中：layero是弹层的DOM对象
						},
						end : function() {
							$('[lay-id="test9"]').css("display", "none");
						}
					}); 
					table.render({
						elem : '#test9',
						url : '${APP_PATH}/queryMplanDetails.do?mplanId='+mplanId,
						totalRow : true,
						cols : [ [ {
							type : 'numbers'
						}, {
							field : 'proId',
							title : '药品编号',
							unresize : true
						}, {
							field : 'proName',
							title : '药品名称',
							unresize : true
						}, {
							field : 'number',
							title : '计划生产数量',
							totalRow : true,
							unresize : true
						} ] ]
					});

					} else if (obj.event === 'del') {
						layer.confirm('确认删除该计划吗？', function(index) {
							obj.del();
							$.ajax({
					        	type:"post",
					    		url:'${APP_PATH}/deleteMplan.do?mplanId='+mplanId,
					    		success:function(data){
					    			
					           }
					        }); 
							layer.close(index);
							table.reload('test2');
						});
					} else if (obj.event === 'edit') {
						if (data.mstatus == '已审核') { 
							layer.alert('当前订单已审核,无法修改', {
								icon : 2
							});
						} else if (data.mstatus == '未审核') {
						var index88 = layer.open({
							title : '修改计划详情',//标题
							type : 1,//样式
							shade : 0,
							offset : [ '5%', '15%' ],//设置位移
							area : [ '880px', '550px' ],
							content : $("#table2Div"),
							success : function(layero) {
								var mask = $(".layui-layer-shade");
								mask.appendTo(layero.parent());
								//其中：layero是弹层的DOM对象
							},
							btn : [ '确认', '恢复' ],
							yes : function(index, layero){
								layer.confirm('确定修改该计划？', function(index){
									$.ajax({
							        	type:"post",
							    		url:"${APP_PATH}/updateMPlan.do?mplanId="+mplanId,
							        	data:$("#myForm").serialize(),
							    		success:function(data){
							                layer.close(index88);
							                table.reload('test2');
											table.reload('test');
											layer.msg('已修改');
							           }
							        });
									
								});
							},
							btn2 : function(index, layero) {
								$.ajax({
						        	type:"post",
						    		url:"${APP_PATH}/delectRestoreMPlan.do?mplanId="+mplanId,
						    		success:function(data){
						                layer.close(index88);
						                table.reload('test2');
						           }
						        });
								layer.msg('已恢复');
							},
							end : function() {
								$('[lay-id="test2"]').css("display","none");
							}
						});
								
						form.on('submit(added)', function(obj){
				        	var obj=document.getElementById("select");
				        	var proName=obj.options[obj.selectedIndex].text;
				        	$.ajax({
					        	type:"post",
					    		url:"${APP_PATH}/updateMPlan.do?proName="+proName,
					        	data:$("#myForm").serialize(),
					    		success:function(data){
					                table.reload('test2');
					           }
					        });
						});
						
						table.on('tool(test2)', function(obj) {
			        		if (obj.event === 'manageMe') {
			        			var data = obj.data;
								var mpdId=data.mpdId;
								$.ajax({
									type:"post",
									url:"${APP_PATH}/deleteEditProduct.do?mpdId="+mpdId,
									success:function(result){
										table.reload('test2');
									}
								});
			        		}
			        	});
								
						table.render({
							elem : '#test2',
							url : '${APP_PATH}/queryMplanDetails.do?mplanId='+mplanId,
							toolbar : '#toolbarDemo2',
							totalRow : true,
							cols : [[{
								field : 'mpdId',
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
								field : 'number',
								title : '生产数量',
								totalRow : true,
								unresize : true
							}, {
								align : 'center',
								toolbar : '#barDemo2',
								unresize : true
							}]]
						});
					}
				}
		});
	});
</script>
</body>
</html>
