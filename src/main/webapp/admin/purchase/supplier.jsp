<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>供应商管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>          
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>

<body>

 <div style="display: none;" id="material">
 	<table class="layui-table" id="demo" lay-filter="demo" lay-data="{id: 'idTest'}"></table>
 </div>
 
<table class="layui-table" id="test" lay-filter="test"></table>

<!-- 新增 -->
<div id="div" style="display: none;">
 	<form class="layui-form"  lay-filter="dataform" id="dataform" method="post">
  <!-- 新增供应商 -->
  <div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">供应商名称：</label>
    <div class="layui-input-block">
      <input name="supplierId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">供应商名称：</label>
    <div class="layui-input-block">
      <input name="supplierName" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">供应商代码：</label>
    <div class="layui-input-block">
      <input name="supplierNumber" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required" lay-reqtext="设置提示文字">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">供应商地址：</label>
    <div class="layui-input-block">
      <input name="supplierSite" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">联系方式：</label>
    <div class="layui-input-block">
      <input name="supplierContact" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">供应商类型：</label>
    <div class="layui-input-block">
      <select name="supplierClassify" lay-filter="aihao">
        <option value="原材料" selected="">原材料</option>
        <option value="其他">其他</option>
      </select>
    </div>
  </div>
  
  <label class="layui-form-label" style="font-size:13px;">加入时间：</label>
		<div class="layui-input-block">
  		<input name="createTime" class="layui-input" id="date1" type="text" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date"/>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>
      <button class="layui-btn layui-btn-primary" type="reset">重置</button>
    </div>
  </div>
</form>
 </div>

<!-- 供应商详情增加 -->
 <div id="div2" style="display: none;">
 	<form class="layui-form"  lay-filter="dataformOff" id="dataformOff" method="post">
 <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">供应商ID：</label>
    <div class="layui-input-block">
      <input name="supplierId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>
 
  <div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">原材料ID：</label>
    <div class="layui-input-block">
      <input name="offerId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">材料名称：</label>
    <div class="layui-input-block">
      <input name="offerName" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>

  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">材料价格：</label>
    <div class="layui-input-block">
      <input name="offerPrice" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size:13px;">材料产地：</label>
    <div class="layui-input-block">
      <input name="offerPlaceOfOrigin" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
  </div>
  
  <label class="layui-form-label" style="font-size:13px;">材料单位：</label>
		<div class="layui-input-block">
  		<input name="offerRemark" class="layui-input" type="text" autocomplete="off" lay-verify="required"/>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-filter="demo2" lay-submit="">立即提交</button>
      <button class="layui-btn layui-btn-primary" type="reset">重置</button>
    </div>
  </div>
</form>
 </div>
 
 <!-- 模糊查询 -->
<script id="toolbarDemo" type="text/html">
  <div clamo'huss="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i>新增</button>
	<input type="text" placeholder="请输入供应商姓名" class="layui-text" name="moName" id="moName" style="width:150px;height:30px;">
	<button class="layui-btn layui-btn-sm" lay-event="select"><i class="layui-icon layui-icon-search"></i>搜索</button>
  </div>
</script>
 
<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script id="supDetail" type="text/html">
  <a class="layui-btn layui-btn-xs" lay-event="see">供应商详情</a>
</script>
     
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>
layui.use(['table','form','laydate','element','jquery','layer'], function(){
	  var $ = layui.jquery;
	  var table = layui.table;
	  var form = layui.form;
	  var laydate = layui.laydate;
	  var element = layui.element;
	  var layer=layui.layer;
	  var tanOne;
	  var tableIns;
	  var urls;
  
 tableIns=table.render({
    elem: '#test'
    ,url:'getSupplierAllInfo.do'
    ,toolbar: '#toolbarDemo'
    ,title: '用户数据表'
    /* ,parseData:function(res){
    	console.log(res);
    	return{
    		code: 0, //解析接口状态
    		msg:"", //解析提示文本
    		count: 1000, //解析数据长度
    		data: res //解析数据列表
    	}
    } */
    ,cols: [[
      {type: 'checkbox'}
      ,{field:'supplierId', title:'ID', width:'5%',  sort: true}
      ,{field:'supplierName', title:'供应商名称'}
      ,{field:'supplierNumber', title:'供应商代码'}
      ,{field:'supplierSite', title:'供应商地址', width:'20%'}
      ,{field:'supplierContact', title:'供应商联系电话' }
      ,{field:'supplierClassify', title:'供应商类型' }
      ,{field:'createTime', title:'加入时间', }
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo',width:'10%'}
    ]] 
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
    	case 'add':
    		tanOne=layer.open({
  		  		type: 1, 
  		  		title:'新增',
  		  		area: ['500px', ''],
  				content: $('#div'), 
  				success:function(index){
  					urls="addSupplierNewInfo.do";
					 //清空表单数据
					 $("#dataform")[0].reset();								  
				 }
  				});
  	  		break;
    	case 'select':
    		
      	  break;
      	  
    };
  });
  
  
  
  laydate.render({
	    elem: '#date1'
	  });
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    var supId = data.supplierId;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
        $.ajax({
    		type:"post",
    		url:'deleteSupplier.do',
    		data:"supplierId="+supId,
    		success:function(){
    			tableIns.reload();
    		}
    	 })
      });
    } else if(obj.event === 'edit'){
    	tanOne=layer.open({
		  	type: 1, 
		  	title:'修改',
		  	area: ['500px', ''],
			content: $('#div'),
			success:function(index){
				  form.val("dataform",data);
				  urls="updateSupplierInfo.do";
			  }
			});
    } 
  });
  //提交数据
  form.on("submit(demo1)",function(obj){
		 //序列化表单数据
		//layui.msg(JSON.Stringify(data.field));
		 var params=obj.field;
		 $.ajax({
			type: "post",
			url: urls,
			data: params,
			dataType:"JSON",
			success:function(data){
				//关闭弹出层
				layer.close(tanOne);
				//刷新数据表格
				tableIns.reload();
				if(urls== 'addSupplierNewInfo.do'){
				if(data== '1'){
					layer.msg("添加成功", {icon: 6});
				}else{
					layer.msg("添加失败", {icon: 6});
				}
				}else if(urls== 'updateSupplierInfo.do'){
					if(data== '1'){
						layer.msg("修改成功", {icon: 6});
					}else{
						layer.msg("修改失败", {icon: 6});
					}
				}
			}
		 });
		 return false; //阻止表单跳转
		 /* $.post(url,params,function(data){
			//关闭弹出层
			layer.close(tanIndex);
			//刷新数据表格
			tableIns.reload();
			
		 }); */
	 })
  
  table.on('rowDouble(test)', function(obj){
	    var layer = layui.layer;
	    var data=obj.data.supplierId;
	    $.ajax({
    		type:"post",
    		url:'setSupplierSession.do',
    		data:"supplierId="+data,
    		success:function(){
    			
    		}
    	 })
	    layer.open({
	    	type: 1, 
	    	title:'详细信息',
	    	offset: ['0px', '50px'],
	    	area: ['1000px', '500px'],
	    	content: $('#material'), //这里content是一个普通的String
	    	success: function(layero, index){
	    		       sup();
	    		  }
	    });

	});

	  function sup(){
		  layui.use(['table','form','laydate','element','jquery','layer'], function(){
			  var $ = layui.jquery;
			  var table = layui.table;
			  var form = layui.form;
			  var laydate = layui.laydate;
			  var element = layui.element;
			  var layer=layui.layer;
			  var tanOne;
			  var tableIns;
			  var urls;
			  table.reload('idTest', {
		   url: 'getSupplierOfferAllInfo.do'
		  ,toolbar: '#toolbarDemo'
		  ,title: '供应商详情'
		  ,cols: [[
		      {fixed: 'left',width:20}
		      ,{field:'offerId', title:'ID',sort: true}
		      ,{field:'offerName', title:'原材料名称'}
		      ,{field:'offerPrice', title:'原材料价格'}
		      ,{field:'offerRemark', title:'单位'}
		      ,{field:'offerPlaceOfOrigin', title:'原材料产地'}
		      ,{field:'supplierId', title:'供应商ID'}
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
		    ]]
		});
	  	
	//详情
	  table.on('toolbar(demo)', function(obj){
	    var checkStatus = table.checkStatus(obj.config.id);
	    switch(obj.event){
	    	case 'add':
	    		tanOne=layer.open({
	  		  		type: 1, 
	  		  		title:'详情新增',
	  		  		area: ['500px', ''],
	  				content: $('#div2'), 
	  				success:function(index){
	  					urls="addSupplierOfferInfo.do";
	  					alert(urls); 
	  					//清空表单数据 
						 $("#dataformOff")[0].reset();								  
					 }
	  				});
	  	  		break;
	    	case 'select':
	    		
	      	  break;
	      	  
	    		};
	  		});
	  
			
	//监听行工具事件
	  table.on('tool(demo)', function(obj){
	    var data = obj.data;
	    var supId = data.supplierId
	    var offerId = data.offerId;
	    //console.log(obj)
	    if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        obj.del();
	        layer.close(index);
	        $.ajax({
	    		type:"post",
	    		url:'deleteSupplierOffer.do',
	    		data:"offerId="+supId+"&offerId="+offerId,
	    		success:function(){
	    			tableIns.reload();
	    		}
	    	 })
	      });
	    } else if(obj.event === 'edit'){
	    	tanOne=layer.open({
			  	type: 1, 
			  	title:'修改',
			  	area: ['500px', ''],
				content: $('#div2'),
				success:function(index){
					  form.val("dataformOff",data);
					  urls="updateSupplierOffer.do";
				  }
				});
	    } 
	    /* else if(obj.event === 'offerAdd'){
	    	tanOne=layer.open({
			  	type: 1, 
			  	title:'增加',
			  	area: ['500px', ''],
				content: $('#div2'),
				success:function(index){
					  form.val("dataformOff",data);
					  urls="updateSupplierOffer.do";
				  }
				});
	    } */
	  });
	  //提交数据
	  form.on("submit(demo2)",function(obj){
			 //序列化表单数据
			//layui.msg(JSON.Stringify(data.field));
			 var params=obj.field;
			 alert(urls);
			 $.ajax({
				type: "post",
				url: urls,
				data: params,
				dataType:"JSON",
				success:function(data){
					//关闭弹出层
					layer.close(tanOne);
					//刷新数据表格
					tableIns.reload();
					if(urls== 'addSupplierOfferInfo.do'){
					if(data== '1'){
						layer.msg("添加成功", {icon: 6});
					}else{
						layer.msg("添加失败", {icon: 6});
					}
					}else if(urls== 'updateSupplierOffer.do'){
						if(data== '1'){
							layer.msg("修改成功，下次进入生效", {icon: 6});
						}else{
							layer.msg("修改失败", {icon: 6});
						}
					}
				}
			 });
			 return false; //阻止表单跳转
			 /* $.post(url,params,function(data){
				//关闭弹出层
				layer.close(tanIndex);
				//刷新数据表格
				tableIns.reload();
				
			 }); */
		 }); 
			
		});
		  
	  }
	 //
	  
	});
</script>

</body>
</html>