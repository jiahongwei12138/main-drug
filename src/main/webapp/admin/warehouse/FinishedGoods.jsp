<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>成品入库审核</title>
<link rel="stylesheet" href="../layui/css/layui.css">
<script src="../layui/layui.js"></script>
<script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<div style="margin-top: 10px;margin-left: 5px">
		<form class="layui-form">
			<div class="layui-input-inline" style="margin-right: 20px;">
				<select id="InStoreState" name="InStoreState" layui-verify="" lay-filter="InStoreState" style="font-size:13px;">
					<option value="1" selected> 已入库 </option>
					<option value="2"> 未入库</option>
				</select> 
				
			</div>
			<div class="layui-input-inline">
				<select id="InStoreType" name="InStoreType" layui-verify="" lay-filter="InStoreType" style="font-size:13px;">
					<option value="1" selected> 生产质检入库 </option>
					<option value="2"> 退货质检入库</option>
				</select>
			</div>
			
		</form>
	</div>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<div style="display: none;" id="v1">
		<form class="layui-form" action="">
			<div class="layui-form-item">

				<div class="layui-inline">
					<label class="layui-form-label">审核人</label>
					<div class="layui-input-inline">
						<select name="city" lay-verify="">
							<option value="">审核人</option>
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
							<option value="021">成品入库1</option>
							<option value="0571">成品仓库2</option>
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



	<!-- <div style="display: none;" id="div3">
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
		<button type="button" class="layui-btn layui-btn-normal">提交</button>
	</div> -->
	
	<div id="div4" style="display: none;">
		<table class="layui-hide" id="layerTable" lay-filter="test"></table>
		<!-- <form class="layui-form" action="">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">入库编号</label>
					<div class="layui-input-inline"">
						<input type=" tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">入库主题</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">制单人</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">加工单位</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">货物名称</label>
					<div class="layui-input-inline">
						<input type="tel" name="phone" lay-verify="required|phone"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">货物数量</label>
					<div class="layui-input-inline">
						<input type="text" name="email" lay-verify="email"
							autocomplete="off" class="layui-input" disabled="disabled"
							value="">
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">货物批次</label>
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

				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">交货人</label>
						<div class="layui-input-inline">
							<input type="text" name="email" lay-verify="email"
								autocomplete="off" class="layui-input" disabled="disabled"
								value="">
						</div>
					</div>
					<div class="layui-inline">
						<label class="layui-form-label">验收人 </label>
						<div class="layui-input-inline">
							<input type="text" name="email" lay-verify="email"
								autocomplete="off" class="layui-input" disabled="disabled"
								value="">
						</div>
					</div>
				</div>
		</form> -->
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
				url : '${APP_PATH}/getMainProductInStorageInf.do?piSType=1&piSState=1',
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
					field : 'piSId',
					title : '隐藏Id列',
					hide : true
				},  {
					field : 'piSTypeName',
					title : '入库类型'
				}, {
					field : 'piSTime',
					title : '入库时间'
				},{
					field : 'whID',
					title : '仓库Id',
					hide : true
				}, {
					field : 'sname',
					title : '入库仓库'
				}, {
					field : 'piSState',
					title : '入库状态'
				}, {
					field : 'checkStates',
					title : '审核状态'
				},{
					field : 'empName',
					title : '审核人姓名'
				},{
					field : 'poOBoId',
					title : '生产成品质检/成品退货表Id',
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
			//监听下拉框 InStoreState InStoreType
			form.on('select(InStoreState)', function(data){
				  var piSState = data.value; //得到被选中的值
				  var piSType =$('#InStoreType').val();
				  tableIns.reload({
					  url:'${APP_PATH}/getMainProductInStorageInf.do',
					  where :{
						  piSState : piSState,
						  piSType : piSType
						  }
					});
				});
			
			form.on('select(InStoreType)', function(data){
				  var piSType = data.value; //得到被选中的值
				  var piSState =$('#InStoreState').val();
				  tableIns.reload({
					  url:'${APP_PATH}/getMainProductInStorageInf.do',
					  where :{
						  piSState : piSState,
						  piSType:piSType
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
					layer.open({
						type : 1,
						offset: 'auto',
						area: ['50%', '30%'],
						content : $('#div4')
					});
					var layerTable =table.render({
						elem : '#layerTable',
						url : '${APP_PATH}/getProductionOrderDetailsInf.do?poOBoId='+data.poOBoId+'&piSTypeName='+data.piSType,
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
							title : '主键',
							hide : true
						}, {
							field : 'poId',
							title : '成品生产订单id',
							hide : true
						}, {
							field : 'proId',
							title : '成品主键',
							hide : true
						},  {
							field : 'proName',
							title : '成品名称'
						},{
							field : 'proQuantity',
							title : '生产数量',
						}, {
							field : 'proPassQuantity',
							title : '通过数量'
						}, {
							field : 'percent',
							title : '合格率'
						} ] ],
						page : true
					});
				} else if (obj.event === 'shenhe') {
					if(data.checkStates=="已审核"){
						layer.msg('不能重复审核',{icon: 6});
						}else{
							layer.confirm('是否审核并入库', {icon: 3, title:'提示'}, function(index){
									  console.log(data);
									  $.ajax({
										  url:'${APP_PATH}/InProStorageCheck.do',
										  data:{
											  piSType : data.piSType,
											  poOBoId : data.poOBoId,
											  whID : data.whID,
											  piSId : data.piSId
											  },
										  success : function(data){
											  tableIns.reload();
											  }
										  })
									  layer.close(index);
								});
							}
					
					/* layer.open({
						type : 1,
						area : [ '500px', '300px' ],
						content : $('#div3')
					}); */
				}
			});
		});
	</script>

	<!-- <script>
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
	</script> -->
</body>
</html>