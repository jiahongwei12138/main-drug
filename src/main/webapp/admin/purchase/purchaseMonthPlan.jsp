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
  <title>采购计划列表</title>
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

<!-- 采购计划增加 -->
<div id="addPlan" style="display: none;">
<h2 align="center"><b>采购计划</b></h2>
<form class="layui-form" lay-filter="dataform" id="dataform" method="post">
  <table class="layui-table">
  	<tr>
  	<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购计划id：</label>
    <div class="layui-input-block">
      <input name="majorPlanId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
    
  	</div>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">采购制定人编号</label>
   			<div class="layui-input-block">
      			<input name="createName" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
		</td>
		
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">预计金额</label>
    			<div class="layui-input-block">
      				<input name="majorPlanTotalPrices" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    			</div>
    	</td>
    	<td>
    		<label class="layui-form-label" style="font-size:13px;">采购计划类型</label>
   			<div class="layui-input-block">
      			<select name="interest" lay-filter="aihao">
        			<option value="1">月计划</option>
      			</select>
    		</div>
    	</td>
  	</tr>
  	<tr>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">计划制定时间</label>
   			<div class="layui-input-block">
      			<input name="majorPlanSubmissionTime" class="layui-input" id="date" type="text" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date"/>
    		</div>
  		</td>
  		<td>
  			<label class="layui-form-label" style="font-size:13px;">计划名</label>
   			<div class="layui-input-block">
      			<input name="majorPlanName" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
  		</td>
  		<td>
   			<div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-filter=demo1 lay-submit="">立即提交</button>
      <button class="layui-btn layui-btn-primary" type="reset">重置</button>
    </div>
  	</div>
  		</td>
  	</tr>
  </table>
</form>
</div>

<!-- 采购月计划详情 -->
<div id="addPlan2" style="display: none;">
<h2 align="center"><b>采购计划</b></h2>
<form class="layui-form" lay-filter="dataform2" id="dataform2" method="post">

  	<div style="display:none">
  	<label class="layui-form-label" style="font-size:13px;">月计划详情：</label>
    <div class="layui-input-block">
      <input name="detailsId" class="layui-input" type="text" placeholder="" autocomplete="off" lay-verify="required ">
    </div>
  	</div>
  	
    <label class="layui-form-label" style="font-size:13px;">月计划编号：</label>
    <div class="layui-input-block">
      <input name="majorPlanId" class="layui-input" type="text" placeholder="" autocomplete="off" lay-verify="required ">
    </div>
  			
  			<label class="layui-form-label" style="font-size:13px;">原材料名称</label>
   			<div class="layui-input-block">
      			<input name="detailsName" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
    		
  			<label class="layui-form-label" style="font-size:13px;">计划采购量</label>
    			<div class="layui-input-block">
      				<input name="detailsQuantity" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    			</div>
    			
  			<label class="layui-form-label" style="font-size:13px;">实际采购量</label>
    			<div class="layui-input-block">
      				<input name="detailsRealQuantity" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    			</div>
    			
  			<label class="layui-form-label" style="font-size:13px;">原材料单位</label>
   			<div class="layui-input-block">
      			<input name="unit" class="layui-input" type="text" autocomplete="off" lay-verify="title">
    		</div>
    		
   			<div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-filter=demo2 lay-submit="">立即提交</button>
      <button class="layui-btn layui-btn-primary" type="reset">重置</button>
    </div>
  	</div>
</form>
</div>

 
<table class="layui-hida" id="test" lay-filter="test"></table>


<iframe id="addPurchasePlan" src="admin/purchase/addPurchasePlan.jsp" style="display: none;" frameborder="0" width="1000px;" height="500px" ></iframe>




<script id="toolbarDemo" type="text/html">
	<div class="layui-inline">
		<button class="layui-btn layui-btn-sm" lay-event="select"><i class="layui-icon layui-icon-search"></i>查询</button>
		<button class="layui-btn layui-btn-sm" lay-event="add"><i class="layui-icon layui-icon-add-1"></i>新增</button>
	<div>
		
</script>
 
<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
              
          
<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 --> 
 
<script>

layui.use(['table','form', 'layedit', 'laydate','layer'], function(){
  var table = layui.table;
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  var urls;
  var tanOne;
  var tableIns;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  
  tableIns=table.render({
    elem: '#test'
    ,url:'getMajorPlanInfo.do'
    ,toolbar: '#toolbarDemo'
    /* ,title: '用户数据表'
    	,parseData:function(res){
        	console.log(res);
        	return{
        		code: 0, //解析接口状态
        		msg:"", //解析提示文本
        		count: 1000, //解析数据长度
        		data: res //解析数据列表
        	}
        } */
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'majorPlanId', title:'计划ID'}
      ,{field:'majorPlanName', title:'计划名'}
      ,{field:'majorPlanSubmissionTime', title:'提交时间' }
      ,{field:'majorPlanTotalPrices', title:'预计金额(万)'}
      ,{field:'majorPlanRealTotalPrices', title:'实际金额(万)'}
      ,{field:'empName', title:'制定人'}
      ,{field:'createName', title:'制定人编号'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
    ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'add':
    	  var layer = layui.layer;
    	  tanOne=layer.open({
  	    	type: 1, 
  	    	title:'详细信息',
  	    	offset: ['0px', '50px'],
  	    	area: ['auto', 'auto'],
  	    	content: $('#addPlan'), //这里content是一个普通的String
  	    	success:function(index){
					urls="insertMajorPlan.do";
				 //清空表单数据
				 $("#dataform")[0].reset();								  
			 }
    	  });
    	  break;
      case 'select':
    	  
    	  alert("zz");
    	  break;
    };
  });
  
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
				if(urls== 'insertMajorPlan.do'){
				if(data== '1'){
					layer.msg("添加成功", {icon: 6});
				}else{
					layer.msg("添加失败", {icon: 6});
				}
				}else if(urls== 'updateMajorPlan.do'){
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
  
  
  //监听行工具事件
  table.on('tool(test)', function(obj){
	  var data = obj.data;
	  var supId = data.majorPlanId;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
    	  obj.del();
          layer.close(index);
      });
    } else if(obj.event === 'edit'){
    	
	    tanOne=layer.open({
		  	type: 1, 
		  	title:'修改',
		  	area: ['auto', 'auto'],
		  	offset: ['0px', '50px'],
			content: $('#addPlan'),
			success:function(index){
				  form.val("dataform",data);
				  urls="updateMajorPlan.do";
			  }
			});
    }
  });
  
	
	table.on('rowDouble(test)', function(obj){
	    var layer = layui.layer;
	    var data=obj.data.majorPlanId;
	    $.ajax({
    		type:"post",
    		url:'setPurchaseMajorPlanDetailsSession.do',
    		data:"majorPlanId="+data,
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
		  tableIns=table.reload('idTest', {
	   url: 'PurchaseMajorPlanDetails.do'
	  ,toolbar: '#toolbarDemo'
	  ,title: '采购月计划详情'
	  ,cols: [[
	      {fixed: 'left',width:20}
	      ,{field:'detailsId', title:'ID',sort: true}
	      ,{field:'detailsName', title:'原材料名称'}
	      ,{field:'detailsQuantity', title:'原材料计划采购数量'}
	      ,{field:'detailsRealQuantity', title:'原材料实际采购数量'}
	      ,{field:'unit', title:'单位'}
	      ,{field:'majorPlanId', title:'月计划ID'}
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
  				content: $('#addPlan2'), 
  				success:function(index){
  					urls="setInsertMajorPlanDetails.do";
  					//清空表单数据 
					 $("#dataform2")[0].reset();								  
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
    var detailsId = data.detailsId
    var majorPlanId = data.majorPlanId;
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
			content: $('#addPlan2'),
			success:function(index){
				  form.val("dataform2",data);
				  urls="updateMajorPlanDetails.do";
			  }
			});
    } 
    
  });
  //提交数据
  form.on("submit(demo2)",function(obj){
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
				if(urls== 'setInsertMajorPlanDetails.do'){
				if(data== '1'){
					layer.msg("添加成功", {icon: 6});
				}else{
					layer.msg("添加失败", {icon: 6});
				}
				}else if(urls== 'updateMajorPlanDetails.do'){
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
  
  //--
});



</script>

</body>
</html>