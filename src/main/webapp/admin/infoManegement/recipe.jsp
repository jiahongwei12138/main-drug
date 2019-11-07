<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>成品及配方管理</title>
  <link rel="stylesheet" href="${APP_PATH }/layui/css/layui.css">
  <script src="${APP_PATH }/layui/layui.js"></script>
  <script type="text/javascript" src="${APP_PATH }/js/jquery-3.4.1.min.js"></script>          
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>    
		<table class="layui-hide" id="demo" lay-filter="test"></table>
		<div style="display: none" id="divTable">
			<table class="layui-hide" id="detailsTable" lay-filter="detailsTable"></table>
		</div>

				<script type="text/html" id="toolbarDemo">
  					<div class="layui-btn-container" style="margin-top:10px;padding-left:20px;">
    					<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addWarehouse"><i class="layui-icon layui-icon-add-1"></i>新增药品</button>
    					<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="updateDetails"><i class="layui-icon layui-icon-add-1"></i>新增配方</button>
   					 	<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="removeWarehouse"><i class="layui-icon layui-icon-friends"></i>审核药品</button>
						<button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="capacityWarning"><i class="layui-icon layui-icon-friends"></i>审核配方</button>
  					</div>
	
				</script>
				
				<script type="text/html" id="toolbarDemo2">
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 0px;">
  <legend>添加原料配方</legend>
</fieldset>
	<label width="120px" style="margin:0 5px 0 0px;font-size:13px;">原料名</label>
      <div class="layui-input-inline">
       <select id="rawMaterialId"  lay-filter="deptCheck" name="rawMaterialId" lay-verify="">
		</select>
      </div>
	
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">净用量（g）</label>
	<div class="layui-input-inline">
		 <input type="text" id="realityDosage" name="realityDosage" lay-verify="number" placeholder="请输入" autocomplete="off" class="layui-input">
	</div>
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">单位（g）</label>
	<div class="layui-input-inline">
		 <input type="text" id="unit" name="unit" lay-verify="number" placeholder="请输入" autocomplete="off" class="layui-input">
	</div>
	<button type="button" lay-event="addRecipe" class="layui-btn layui-btn-normal">添加</button>
  </div>
</script>

		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="manageMe">管理药品</a>
			<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="manageAe">管理配方</a>
		</script>


		<script type="text/html" id="barDemo2">
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="deleteRecipe">删除</a>
		</script>
		<script>
			layui.use(['table', 'laydate', 'form'], function() {
				var table = layui.table; //表格
				var laydate = layui.laydate;
				var form = layui.form;
				laydate.render({
					elem: '#test5', //指定元素
				});
				laydate.render({
					elem: '#test66', //指定元素
				});
				//执行一个 table 实例
				table.render({
					elem: '#demo',
					url: '${APP_PATH}/queryProduct.do', //数据接口
					title: '药品表',
					toolbar: '#toolbarDemo', //开启工具栏
					totalRow: false, //开启合计行
					cols: [
						
						[ //表头
							{
								type: 'checkbox',
								field: 'proId',
								fixed: 'left',
							}, {
								field: 'proBatchNumber',
								title: '条码编号',
								unresize : true
							}, {
								field: 'proName',
								title: '药品名称',
								unresize : true
							}, {
								field: 'enlishName',
								title: '英文名称',
								unresize : true
							}, {
								field: 'proState',
								title: '药品审核',
								unresize : true
							}, {
								field: 'retailPrice',
								title: '出厂价',
								unresize : true
							}, {
								field: 'hqtName',
								title: '生产商',
								unresize : true
							},{
								field: 'hqtName',
								title: '配方名',
								unresize : true,
								templet: function(d){
							        return '<font>'+d.mainRecipe.recipeName+'</font>';
							    }
							},{
								field: 'hqtName',
								title: '配方审核',
								unresize : true,
								templet: function(d){
							        return '<font>'+d.mainRecipe.recipeState+'</font>';
							    }
							},{
								field: 'hqtName',
								title: '负责人',
								unresize : true,
								templet: function(d){
							        return '<font>'+d.mainRecipe.empName+'</font>';
							    }
							},{
								title: '操作',
								width : 178,
								align: 'center',
								toolbar: '#barDemo',
								unresize : true
							}
						]
					],page: true, //开启分页
				});

				//监听弹出层头部工具栏
				table.on('toolbar(test)', function(obj) {
					var checkStatus = table.checkStatus(obj.config.id);
					//获得选择的对象
					var data = checkStatus.data;
					switch (obj.event) {
						case 'addWarehouse':	//新增药品
							
							layer.open({
								title: '新增药品',
								type: 1, //Page层类型
								//area: ['500px', '520px'], //宽高
								closeBtn: 0,
								btn: ['确定', '关闭'], //可以无限个按钮
								yes: function(index, layero) {
									$.ajax({
										type:"post",
										url:"${APP_PATH}/addProduct.do",
										data:$("#formIdOne").serialize(),
										success:function(result){
											if(result==false){
												layer.msg("添加失败", {time:2000, icon:5, shift:6});
											}else{
												layer.msg("添加成功", {time:2000, icon:1, shift:3},function(){
													 layer.close(layer.index);
													 table.reload('demo'); 
												});
											}
										}
									});
									
									/* layer.close(index);
									//执行清空
									$("#warehouseOperator").empty();
									$("#storageWarehouse").empty();
									form.render("select");
									if(index > 0){
										//添加
										layer.msg('添加成功');
									} */
								},
								content: $("#addDetails"),
								/* success: function(layero, index){
									  form.render();
									  } */
							});
							break;
						case 'updateDetails':	//新增配方
						if(data.length == 1){
							$.ajax({
								type:"post",
								url:"${APP_PATH}/queryRawMaterial.do",
								success:function(result){
									var content='<option value="">请选择原材料</option>';
									$.each(result,function(index,item){
					    				content+='<option id="opt'+item.rawMaterialId+'" value="'+item.rawMaterialId+'">'+item.rawMaterialName+'</option>';
					    			});
					    			$("#rawMaterialId").html(content);
					    			//form.render('select'); 
								}
							});
							 //监听事件
							table.on('toolbar(detailsTable)', function(obj){
							  var checkStatus = table.checkStatus(obj.config.id);
							  switch(obj.event){
							    case 'addRecipe':
							      var rawMaterialId=$("#rawMaterialId").val();
							      var realityDosage=$("#realityDosage").val();
							      var unit=$("#unit").val();
							      $.ajax({
							    	  type:"post",
							    	  url:"${APP_PATH}/addRecipedetail.do",
							    	  data:{
							    		  "rawMaterialId":rawMaterialId,
							    		  "realityDosage":realityDosage,
							    				   "unit":unit,
							    	  },
							    	  success:function(result){
							    		    if(result==false){
												layer.msg("添加失败", {time:3000, icon:5, shift:6});
											}else{
												table.reload('detailsTable');
											}
							    	  }
							    	  
							      });
							    break;
							  };
							});
							table.render({
								elem: '#detailsTable',
								url: '${APP_PATH}/queryRecipedetail.do', //数据接口
								title: '用户表',
								totalRow: false, //开启合计行
								toolbar :"#toolbarDemo2",
								cols: [
									[ //表头
										{
											type: 'checkbox',
											field: 'reDetailId',
											fixed: 'left'
										}, {
											field: 'rawMaterialName',
											title: '原料名称',
											sort: true
										}, {
											field: 'realityDosage',
											title: '禁用量',
											sort: true,
										}, {
											field: 'unit',
											title: '单位',
											sort: true
										}, {
											title: '操作',
											align: 'center',
											toolbar: '#barDemo2'
										}
										]
									]
								});
							//监听工具条
							  table.on('tool(detailsTable)', function(obj){
							    var data = obj.data;
							   if(obj.event === 'deleteRecipe'){
								   layer.confirm('确认删除该原料吗？', function(index){
								    	  $.ajax({
												type:"post",
												url:"${APP_PATH}/deletRecipeById.do",
												data:{
													"reDetailId":data.reDetailId
												},
												success:function(result){
													if(result==false){
														layer.msg("删除失败", {time:3000, icon:5, shift:6});
													}else{
														layer.msg("删除成功", {time:3000, icon:1, shift:3});
														table.reload('detailsTable');
													}
												}
											});
							    });
							   }
							  });
								var index = layer.open({
									title: '新增原料配方',
									type: 1, //Page层类型
									area: ['880px', '550px'],
									closeBtn: 0,
									btn: ['确定', '关闭'], //可以无限个按钮
									content: $("#divTable"),
									yes: function(index, layero){
										var index2 = layer.confirm('你确认制定该配方？', {
											  btn: ['确认', '取消'] //可以无限个按钮
											  ,btn2: function(index, layero){
											    layer.close(index2);
											  }
											}, function(layero){
												layer.close(index2);
												console.log($("#empId"));
												$.ajax({
													type:"post",
													url:"${APP_PATH}/queryEmpIdAndName.do",
													success:function(result){
														var content='<option value="">制定人</option>';
														$.each(result,function(index,item){
										    				content+='<option id="opt'+item.empId+'" value="'+item.empId+'">'+item.empName+'</option>';
										    			});
										    			$("#empId").html(content);
										    			form.render('select');
													}
												});
												var index88 = layer.open({
													  type: 1,
													  shade: 0.25,
													  area: ['400px', '350px'],
													  content: $('#nameAndTimeDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
													  success: function(layero, index){
														  form.render();
														  },
													  btn: ['确认', '取消'],
													  yes: function(layero){
														  var proId=data[0].proId;
														  $.ajax({
															  type:"post",
															  url:"${APP_PATH}/addRecipe.do",
															  data:$("#formIdOne2").serialize()+"&proId="+proId,
															  success:function(result){
																  if(result==false){
																		layer.msg("制定失败", {time:3000, icon:5, shift:6});
																	}else{
																		layer.msg("制定成功", {time:3000, icon:1, shift:3});
																	}
																  table.reload('demo',{
																	  url:"${APP_PATH}/queryProduct.do"
																  });
																  layer.close(index);
																  layer.close(index88);
															  }
														  });
														  /* 
														  layer.msg('配方制定成功'); */
														}
													  ,btn2: function(index, layero){
															  layer.close(index88);
														}
												});
												
											});
									}
									,btn2: function(index, layero){
										//按钮【按钮二】的回调
										  layer.close(index);
										 //return false 开启该代码可禁止点击该按钮关闭
									}
								});
							}else if(data.length > 1){
								layer.msg('最多只能选择一件药品');
							}else{
								layer.msg('请选择要制定配方的药品');
							}
							break;
						case "removeWarehouse":	//审核药品
							if(data.length == 1){
								//判断月计划审核状态
								console.log(data);
								if(data[0].proState == '未审核'){
									var index2 = layer.confirm('你确认审核该药品？', {
										  btn: ['确认', '取消'] //可以无限个按钮
										  ,btn2: function(index, layero){
										    layer.close(index2);
										  }
										}, function(layero){
											$.ajax({
												type:"post",
												url:"${APP_PATH}/updateProStateById.do",
												data:{
													"proId":data[0].proId
												},
												success:function(result){
													if(result==false){
														layer.msg("药品审核失败", {time:2000, icon:5, shift:6});
													}else{
														layer.msg("药品审核成功", {time:2000, icon:1, shift:3},function(){
															layer.close(index2);
															table.reload('demo', {
																  url: '${APP_PATH}/queryProduct.do'
															});
														});
													}
												}
											});
											/* var index88 = layer.open({
												  type: 1,
												  shade: 0.25,
												  area: ['400px', '350px'],
												  content: $('#nameAndTimeDiv2'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
												  success: function(layero, index){
													  form.render();
													  },
												  btn: ['确认', '取消'],
												  yes: function(layero){
													  layer.close(index);
													  layer.close(index88);
													  layer.msg('审核成功');
													}
												  ,btn2: function(index, layero){
														  layer.close(index88);
													}
											}); */
											
										});
								}else{
									layer.msg('该药品已审核');
								}
								
							}else if(data.length >1){
								layer.msg('最多只能审核一件商品');
							}else {
								layer.msg('请选择一件商品');
							}
							break;
						case "capacityWarning":	//审核配方
							if(data.length == 1){
								//判断月计划审核状态
								if(data[0].mainRecipe.recipeState == '未审核'){
									var index2 = layer.confirm('你确认审核该配方？', {
										  btn: ['确认', '取消'] //可以无限个按钮
										  ,btn2: function(index, layero){
										    layer.close(index2);
										  }
										}, function(layero){
											$.ajax({
												type:"post",
												url:"${APP_PATH}/updateRecipeStateById.do",
												data:{
													"recipeId":data[0].mainRecipe.recipeId
												},
												success:function(result){
													if(result==false){
														layer.msg("配方审核失败", {time:2000, icon:5, shift:6});
													}else{
														layer.msg("配方审核成功", {time:2000, icon:1, shift:3},function(){
															layer.close(index2);
															table.reload('demo', {
																  url: '${APP_PATH}/queryProduct.do'
															});
														});
													}
												}
											});
											/* var index88 = layer.open({
												  type: 1,
												  shade: 0.25,
												  area: ['400px', '350px'],
												  content: $('#nameAndTimeDiv2'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
												  success: function(layero, index){
													  form.render();
													  },
												  btn: ['确认', '取消'],
												  yes: function(layero){
													  layer.close(index); 
													  layer.close(index88);
													  layer.msg('审核成功');
													}
												  ,btn2: function(index, layero){
														  layer.close(index88);
													} 
											});*/
											
										});
								}else{
									layer.msg('该配方已审核');
								}
								
							}else if(data.length >1){
								layer.msg('一次只能为一件药品审核配方');
							}else {
								layer.msg('请选择一件要审核配方的商品');
							}
							break;
						
					};
				});

				//监听查看详情事件
				table.on('tool(test)', function(obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
					var data = obj.data, //获得当前行数据
						layEvent = obj.event; //获得 lay-event 对应的值
						//管理药品
					if (layEvent === 'manageMe') {
						form.val("formAuthority", {
					    	  "proName": data.proName // "name": "value"
					    	  ,"enlishName": data.enlishName
					    	  ,"methodOfApplication": data.methodOfApplication
					    	  ,"expirationdate": data.expirationdate
					    	  ,"proForbidden": data.proForbidden
					    	  ,"proCure": data.proCure
					    	  ,"proBadness": data.proBadness
					    	  ,"retailPrice": data.retailPrice
					    	});
						
						var index = layer.open({
							title : '管理药品',//标题
							type : 1,//样式
							shade: 0,
							btn: ['确认', '取消'],
							yes: function(index, layero){
								layer.close(index);
								layer.msg('修改成功');
							}
							,btn2: function(index, layero){
								  layer.close(index);
							},
							content :$("#addDetails"),
						});
						
					}else if(layEvent === 'manageAe') {	//管理配方
						 $.ajax({
							type:"post",
							url:"${APP_PATH}/queryRawMaterial.do",
							success:function(result){
								var content='<option value="">请选择原材料</option>';
								$.each(result,function(index,item){
				    				content+='<option id="opt'+item.rawMaterialId+'" value="'+item.rawMaterialId+'">'+item.rawMaterialName+'</option>';
				    			});
				    			$("#rawMaterialId").html(content);
				    			//form.render('select'); 
							}
						});
						 //监听事件
							table.on('toolbar(detailsTable)', function(obj){
							  var checkStatus = table.checkStatus(obj.config.id);
							  switch(obj.event){
							    case 'addRecipe':
							      var rawMaterialId=$("#rawMaterialId").val();
							      var realityDosage=$("#realityDosage").val();
							      var unit=$("#unit").val();
							      $.ajax({
							    	  type:"post",
							    	  url:"${APP_PATH}/addRecipedetail.do",
							    	  data:{
							    		  "rawMaterialId":rawMaterialId,
							    		  "realityDosage":realityDosage,
							    				   "unit":unit,
							    				   "recipeId":data.mainRecipe.recipeId
							    	  },
							    	  success:function(result){
							    		    if(result==false){
												layer.msg("添加失败", {time:3000, icon:5, shift:6});
											}else{
												table.reload('detailsTable');
											}
							    	  }
							    	  
							      });
							    break;
							  };
							});
						 
						table.render({
							elem: '#detailsTable',
							url: '${APP_PATH}/queryRecipedetail.do?recipeId='+data.mainRecipe.recipeId, //数据接口
							title: '用户表',
							totalRow: true, //开启合计行
							toolbar :"#toolbarDemo2",
							cols: [
								[ //表头
									{
										type: 'checkbox',
										field: 'reDetailId',
										fixed: 'left'
									}, {
										field: 'rawMaterialName',
										title: '原料名称',
										sort: true
									}, {
										field: 'realityDosage',
										title: '禁用量',
										sort: true,
									}, {
										field: 'unit',
										title: '单位',
										sort: true
									}, {
										title: '操作',
										align: 'center',
										toolbar: '#barDemo2'
									}
									]
								]
						});
						
						
						
						layer.open({
							title: '原料配方',
							type: 1, //Page层类型
							area: ['1000px', '520px'], //宽高
							closeBtn: 0,
							btn: ['确定', '关闭'], //可以无限个按钮
							content: $("#divTable")
						});
					}
				});
			});
		</script>
		
		<div class="site-text" style="margin: 5%; display: none" id="addDetails" target="test123">
		<form class="layui-form" lay-filter="formAuthority" id="formIdOne">
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">药品名称</label>
				<div class="layui-input-inline">
      				<input type="text" name="proName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">英文名称</label>
				<div class="layui-input-inline">
      				<input type="text" name="enlishName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">用法用量</label>
				<div class="layui-input-inline">
      				<input type="text" name="methodOfApplication" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
    			</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">质保日期</label>
				<div class="layui-input-inline" style="width:193px">
					<select name="expirationdate" lay-verify="required" lay-search="">
          				<option value="">请选择</option>
          				<option value="三个月">三个月</option>
         			 	<option value="半年">半年</option>
          				<option value="一年">一年</option>
        			</select>
				</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">禁用描述</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input"  name="proForbidden" placeholder="请输入" >
				</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">功效描述</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input"  name="proCure" placeholder="请输入" >
				</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">不良反应</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" placeholder="请输入"  name="proBadness">
				</div>
			</div>
			<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">出厂价格</label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" placeholder="请输入"  name="retailPrice">
				</div>
			</div>
			</form>
		</div>


	
	<!-- 制定人和制定时间 -->
<div style="display:none;" id="nameAndTimeDiv" >

<form class="layui-form" lay-filter="formAuthority2" id="formIdOne2">	  
<div class="layui-inline" style="padding-left:0px;margin-top:20px;">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">制定配方</label>
	<div class="layui-input-inline">
		<input type="text" name="recipeName" class="layui-input" placeholder="请输入名称">
	</div>
</div>
<div class="layui-inline" style="padding-left:0px;margin-top:20px;">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">制定日期</label>
	<div class="layui-input-inline">
		<input type="text" name="createTime" class="layui-input" id="test66" placeholder="yyyy-MM-dd">
	</div>
</div>
<div style="padding-left:0px;margin-top:15px;">
<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">制定人员</label>
	<div class="layui-input-inline">
		<select name="empId" id="empId" lay-verify="" lay-search="">
  			
		</select>  
	</div>
<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">配方描述</label>
				<div class="layui-input-inline" style="margin-left:-5px;">
      				<textarea name="recipeDesc" required lay-verify="required" cols="35px" rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
    			</div>
			</div>	
</div>
</form>
 </div>	
 
 
 <!-- 审核人和审核时间 -->
<div style="display:none;" id="nameAndTimeDiv2" >

<form class="layui-form" lay-filter="formAuthority3" id="formIdOne3">	  

<div class="layui-inline" style="padding-left:0px;margin-top:20px;">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">审核日期</label>
	<div class="layui-input-inline">
		<input type="text" class="layui-input" id="test5" placeholder="yyyy-MM-dd">
	</div>
</div>
<div style="padding-left:0px;margin-top:15px;">
<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">审核人员</label>
	<div class="layui-input-inline">
		<select name="city"  lay-verify="" lay-search="">
  			<option value="">制定人</option>
  			<option value="010">张三</option>
  			<option value="021">李四</option>
 			<option value="0571">王五</option>
		</select>  
	</div>
<div class="layui-input-inline" style="margin-top:10px;">
				<label style="margin:0 10px 0 20px;font-size:13px;">备注信息</label>
				<div class="layui-input-inline" style="margin-left:-5px;">
      				<textarea name="des" required lay-verify="required" cols="35px" rows="4px" placeholder="请输入计划描述" class="layui-textarea"></textarea>
    			</div>
			</div>	
</div>
</form>
 </div>	
</body>
</html>