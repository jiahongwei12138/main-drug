<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>仓库类型</title>
<link rel="stylesheet" href="${APP_PATH }/layui/css/layui.css">
<script src="${APP_PATH }/layui/layui.js"></script>
<script type="text/javascript" src="${APP_PATH }/js/jquery-3.4.1.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
	<!-- 表单 -->
	<table class="layui-hide" id="test" lay-filter="test"></table>
	
	<!-- 弹出框 -->
	<div id="div" style="display: none;">
		<form class="layui-form" lay-filter="storage" id="storage" method="post">
			<div class="layui-form-item">
				<div class="layui-inline" style="display:none">
					<label class="layui-form-label" >仓库ID</label>
					<div class="layui-input-inline">
						<input type="text" name="storageId" id="storageId" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">仓库名称</label>
					<div class="layui-input-inline">
						<input type="text" name="sname" id="sname"
						placeholder="仓库名称" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">仓库类型</label>
					<div class="layui-input-inline">
						<select name="storageType" id="storageType" >
							<option value="">选择仓库</option>
							<option value="原料仓库">原料仓库</option>
							<option value="成品仓库">成品仓库</option>
							<option value="废料仓库">废料仓库</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-inline">
						<input type="text" name="createTime" id="createTime"
						class="layui-input" placeholder="创建时间">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">仓库状态</label>
					<div class="layui-input-inline">
						<input type="text" name="storageState" id="storageState"
						placeholder="仓库状态" class="layui-input">
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">仓库地址</label>
					<div class="layui-input-inline">
						<input type="text" name="storageAddr" id="storageAddr"
						placeholder="仓库地址" class="layui-input">
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button type="submit" class="layui-btn" lay-submit lay-filter="storagesubmit">提交</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>

<!-- 头工具 -->
<script type="text/html" id="toolbarDemo">
			<div class="layui-form-item">
				<div class="layui-input-inline">
					<select name="storageType" id="storageType" style="font-size:13px;">
						<option value="">仓库类型</option>
						<option value="原料仓库">原料仓库</option>
						<option value="成品仓库">成品仓库</option>
						<option value="废料仓库">废料仓库</option>
					</select>  
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <button class="layui-btn layui-btn-sm layui-btn-normal" id="search" style="font-size:13px;" lay-event="search">搜索</button>
					</div>
				</div>
				<div class="layui-inline">
					<div class="layui-input-inline">
						  <button class="layui-btn layui-btn-sm layui-btn-normal" style="font-size:13px;" lay-event="getCheckData"> 创建仓库</button>
					</div>
				</div>
			</div>
</script>

<!-- 行工具 -->
<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
		layui.use(
					[ 'table', 'form', 'layer', 'layedit', 'laydate', 'jquery' ],
					function() {
					var table = layui.table, $ = layui.jquery, form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

					//日期
					laydate.render({
						elem : '#createTime'
					});
					
					var tableIndex=table.render({
						elem : '#test',
						method:'post',
						url : '${APP_PATH}/AllMainStorage.do',
						toolbar : '#toolbarDemo',
						title : '仓库类型表',
						cols : [ [ {
							type : 'checkbox',
							fixed : 'left'
						},{
							field : 'storageId',
							title : '仓库Id'
						}, {
							field : 'sname',
							title : '仓库名称'
						}, {
							field : 'storageType',
							title : '仓库类型'
						}, {
							field : 'createTime',
							title : '仓库生成时间'
						}, {
							field : 'storageState',
							title : '仓库状态',
						}, {
							field : 'storageAddr',
							title : '仓库地址'
						}, {
							field : 'right',
							title : '操作',
							toolbar : '#barDemo'
						}  ] ],
						page : true
						,id: 'testReload' 
				});


				//头工具栏事件
				table.on('toolbar(test)', function(obj) {
					var checkStatus = table.checkStatus(obj.config.id);
					var storageType = $("#storageType").val();
					switch (obj.event) {
					case 'search':
						table.reload('testReload', {
			                page: {
			                    curr: 1 //重新从第 1 页开始
			                }
			                , where: {//这里传参  向后台
			                	storageType: storageType
			                    //可传多个参数到后台...  ，分隔
			                }
			                , url: '${APP_PATH}/vagueMainStorage.do'   //后台做模糊搜索接口路径
			                , method: 'post'
			            }); 
						break;
					case 'getCheckData':
						var data = checkStatus.data;
						layer.open({
							type : 1,
							skin:'layui-layer-molv',//skin - 样式类名
							content : $('#div')
						});
						break;
					};
				});

				//监听行工具事件
				table.on('tool(test)', function(obj) {
					var data = obj.data, //获得当前行数据
				      layEvent = obj.event; //获得 lay-event 对应的值
					if (layEvent === 'del') {
						layer.confirm('真的删除行么', function(index) {
							 $.ajax({
			                        url:'${APP_PATH}/delMainStorage.do',
			                        type:'post',
			                        data:{'id':data.storageId},//向服务端发送删除的id
			                        success:function(success){
			                            if(success == 1){
			                                //layer.close(index);
			                               	//console.log(index);
			                                layer.msg("删除成功",{icon:1});
			                                location.reload();
			                            }else{
			                                layer.msg("删除失败",{icon:5});
			                                location.reload();
			                            }
			                        }
			                  });
						});
					} else if (obj.event === 'edit') {
						 layer.open({
							type:1,  //设置类型 默认为0  1 页面层div 2 iframe层
							title:'修改信息',  //标题
							content:$("#div"),//内容  type=0 的内容
							skin:'layui-layer-molv',//skin - 样式类名
							area:['340px','400px'],  //area - 宽高
							success:function(index){
								//给表单赋值
								form.val("storage",data);
							}
						});	

						
					    }
					})
			
			    form.on('submit(storagesubmit)', function(data){
				    var urls = "";
				    if(data.field.storageId != null && data.field.storageId != ""){
						urls = "${APP_PATH}/editMainStorage.do";
					}else{
						urls = '${APP_PATH}/newStorage.do';
					}
					 	$.ajax({
							url: urls,
							type: "POST",
							data: $("#storage").serialize(),//这个是传给后台的值   序列化 */
							success: function(back){
								 if(back == 1){ 
									layer.close(index);
									//更新前台显示的值
									obj.update({
										loan_limit: value
									});
									layer.msg("修改成功", {icon: 6});
								}else{
									layer.msg("修改失败", {icon: 5});
								} 
							}
	 
						});
					 	//return false; 
					})  
		});

	</script>
</body>
</html>