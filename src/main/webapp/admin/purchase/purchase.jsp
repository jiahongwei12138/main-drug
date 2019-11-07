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
  <title>采购订单</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="layui/css/layui.css"  media="all">
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>          
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
 <div style="display: none;" id="purchaseOrderDetails">
 	<table class="layui-hide" id="demo" lay-filter="demo"></table>
 </div>
 
 
<table class="layui-hida" id="test" lay-filter="test"></table>


<iframe id="updatePurchase" src="admin/purchase/updatePurchase.jsp" style="display: none;" frameborder="0" width="1000px;" height="500px"></iframe>
 
 
 <!-- 质检审核 -->
<div id="planState" style="display: none;">
	
	<form class="layui-form" lay-filter="dataform3" id="dataform3" method="post">
	<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购计划id：</label>
    <div class="layui-input-block">
      <input name="planId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
    </div>
    
    <div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购月计划id：</label>
    <div class="layui-input-block">
      <input name="majorPlanId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
	</div>
	
	<label class="layui-form-label" style="font-size:13px;">质检审核状态</label>
   			<div class="layui-input-block">
      			<select name="rawMaterialTheQualityStatus" lay-filter="aihao">
        			<option value="通过">通过</option>
        			<option value="未通过">未通过</option>
      			</select>
    		</div>
    		<div class="layui-form-item">
   			 <div class="layui-input-block">
   			   <button class="layui-btn" lay-filter=demo2 lay-submit="">立即提交</button>
   			 </div>
  			</div>
	</form>
</div>

<!-- 详情质检审核 -->
<div id="planDetailsState" style="display: none;">
	
	<form class="layui-form" lay-filter="dataform5" id="dataform5" method="post">
	<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购计划id：</label>
    <div class="layui-input-block">
      <input name="planId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
    </div>
    
    <div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购月计划id：</label>
    <div class="layui-input-block">
      <input name="detailsReservedOne" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
	</div>
	
	<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购计划详情id：</label>
    <div class="layui-input-block">
      <input name="detailsId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
	</div>
	
	<label class="layui-form-label" style="font-size:13px;">质检审核状态</label>
   			<div class="layui-input-block">
      			<select name="detailSqualityStatus" lay-filter="aihao">
        			<option value="通过">通过</option>
        			<option value="未通过">未通过</option>
      			</select>
    		</div>
    		<div class="layui-form-item">
   			 <div class="layui-input-block">
   			   <button class="layui-btn" lay-filter=demo3 lay-submit="">立即提交</button>
   			 </div>
  			</div>
	</form>
</div>

<!-- 添加供应商ID -->
<div id="addSupplier" style="display: none;">
	
	<form class="layui-form" lay-filter="dataform4" id="dataform4" method="post">
	<div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购计划id：</label>
    <div class="layui-input-block">
      <input name="planId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
    </div>
    
    <div class="layui-form-item" style="display: none;">
    <label class="layui-form-label" style="font-size:13px;">采购月计划id：</label>
    <div class="layui-input-block">
      <input name="majorPlanId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
	</div>
	
	<div class="layui-form-item">
	<label class="layui-form-label" style="font-size:13px;">供应商ID</label>
    <div class="layui-input-block">
      <input name="supplierId" class="layui-input" type="text" placeholder="请输入" autocomplete="off" lay-verify="required ">
    </div>
    </div>
    		
    		<div class="layui-form-item">
   			 <div class="layui-input-block">
   			   <button class="layui-btn" lay-filter=demo2 lay-submit="">立即提交</button>
   			 </div>
  			</div>
	</form>
</div>
 
<script id="barDemo" type="text/html">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">添加供应商ID</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="state">质检审核</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">退货</a>
  
</script>

<script id="barDemo2" type="text/html">
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="state2">质检审核</a>
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
	  
	  tableIns=table.render({
    elem: '#test'
    ,url:'getPurchasePlanOrder.do'
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
      {field:'planId', title:'采购订单号'}
      ,{field:'majorPlanId', title:'采购月计划编号'}
      ,{field:'planName', title:'订单名'}
      ,{field:'planSubmissionTime', title:'下单时间'}
      ,{field:'createName', title:'采购人'}
      ,{field:'supplierId', title:'供货商ID'}
      ,{field:'planRealTotalPrices', title:'采购金额'}
      ,{field:'checkState', title:'付款状态'}
      ,{field:'inStoregState', title:'入库状态'}
      ,{field:'rawMaterialTheQualityStatus', title:'质检状态'}
      ,{fixed: 'right', title:'操作', toolbar: '#barDemo',width:240}
    ]]
    ,page: true
  });
  
  //头工具栏事件
  table.on('edit(test)', function(obj){
	  console.log(obj.value); 
	  alert(obj.value);
  });
  
//监听行工具事件
  table.on('tool(test)', function(obj){
    var data = obj.data;
    //console.log(obj)
    if(obj.event === 'del'){
      layer.confirm('确认退货吗', function(index){
        obj.del();
        layer.close(index);
      });
    }else if(obj.event==='edit'){
    	
    	var layer = layui.layer;
    	tanOne=layer.open({
	    	type: 1, 
	    	title:'添加供应商',
	    	area: ['300px', '200px'],
	    	offset: ['00px', '50px'],
	    	content: $('#addSupplier'), //这里content是一个普通的String
	    	success:function(index){
				  form.val("dataform4",data);
				  urls="updatePurchasePlanSupplier.do";
			  }
	    });
    } else if(obj.event === 'state'){
    	var layer = layui.layer;
    	tanOne=layer.open({
		  	type: 1, 
		  	title:'质检审核',
		  	area: ['300px', '200px'],
		  	offset: ['0px', '50px'],
			content: $('#planState'),
			success:function(index){
				  form.val("dataform3",data);
				  urls="updatePurchasePlanStateOrder.do";
			  }
			});
    }
  });
  
  
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
				if(urls== 'updatePurchasePlanSupplier.do'){
				if(data== '1'){
					layer.msg("添加供应商成功", {icon: 6});
				}else{
					layer.msg("操作失败", {icon: 6});
				}
				}else if(urls== 'updatePurchasePlanStateOrder.do'){
					if(data== '1'){
						layer.msg("质检操作成功", {icon: 6});
					}else{
						layer.msg("操作失败", {icon: 6});
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
	    var data=obj.data.majorPlanId;
	    var data2=obj.data.planId;
	    $.ajax({
    		type:"post",
    		url:'setPurchaseDetailsSession.do',
    		data:"majorPlanId="+data+"&planId="+data2,
    		success:function(){
    			
    		}
    	 })
	    layer.open({
	    	type: 1, 
	    	title:'详细信息',
	    	area: ['1000px', '500px'],
	    	offset: ['00px', '50px'],
	    	content: $('#purchaseOrderDetails'), //这里content是一个普通的String
	    	success:function(layero, index){
    			plans();
    		}
	    });

	});
  
  function plans(){
	  
	  layui.use(['table','form', 'layedit', 'laydate','layer'], function(){
		  var table = layui.table;
		  var form = layui.form
		  ,layer = layui.layer
		  ,layedit = layui.layedit
		  ,laydate = layui.laydate;
		  var urls;
		  var tanOne;
		  var tableIns;
		  
		  
		  tableIns=table.render({
		    elem: '#demo'
		    ,url:'getPurchaseDetails.do'
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
		      {fixed: 'left'}
		      ,{field:'detailsId', title:'ID'}
		      ,{field:'detailsName', title:'原材料名称'}
		      ,{field:'detailsQuantity', title:'原材料数量'}
		      ,{field:'detailsCategory', title:'单位'}
		      ,{field:'detailsUnitPrice', title:'原材料单价'}
		      ,{field:'detailsPrice', title:'原材料小计'}
		      ,{field:'planId', title:'采购单ID'}
		      ,{field:'detailsReservedOne', title:'采购月计划ID'}
		      ,{field:'detailSqualityStatus', title:'质检状态'}
		      ,{fixed: 'right', title:'操作', toolbar: '#barDemo2'}
		    ]]
		    ,page: true
		  });
		  
		//监听行工具事件
		  table.on('tool(demo)', function(obj){
		    var data = obj.data;
		    var detailsId = data.detailsId
		    var majorPlanId = data.majorPlanId;
		    //console.log(obj)
		    if(obj.event === 'state2'){
		    	tanOne=layer.open({
				  	type: 1, 
				  	title:'质检审核',
				  	area: ['500px', '300px'],
					content: $('#planDetailsState'),
					success:function(index){
						  form.val("dataform5",data);
						  urls="updatePurchaseDetailsOrderState.do";
					  }
					});
		    } 
		    
		  });
		  //提交数据
		  form.on("submit(demo3)",function(obj){
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
						if(urls== 'updatePurchaseDetailsOrderState.do'){
						if(data== '1'){
							layer.msg("质检审核成功,下次进入生效", {icon: 6});
						}else{
							layer.msg("添加失败", {icon: 6});
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
  
//-----

});



</script>




<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //常规用法
  laydate.render({
    elem: '#test1'
  });
  
  //国际版
  laydate.render({
    elem: '#test1-1'
    ,lang: 'en'
  });
  
  //年选择器
  laydate.render({
    elem: '#test2'
    ,type: 'year'
  });
  
  //年月选择器
  laydate.render({
    elem: '#test3'
    ,type: 'month'
  });
  
  //时间选择器
  laydate.render({
    elem: '#test4'
    ,type: 'time'
  });
  
  //日期时间选择器
  laydate.render({
    elem: '#test5'
    ,type: 'datetime'
  });
  
  //日期范围
  laydate.render({
    elem: '#test6'
    ,range: true
  });
  
  //年范围
  laydate.render({
    elem: '#test7'
    ,type: 'year'
    ,range: true
  });
  
  //年月范围
  laydate.render({
    elem: '#test8'
    ,type: 'month'
    ,range: true
  });
  
  //时间范围
  laydate.render({
    elem: '#test9'
    ,type: 'time'
    ,range: true
  });
  
  //日期时间范围
  laydate.render({
    elem: '#test10'
    ,type: 'datetime'
    ,range: true
  });
  
  //自定义格式
  laydate.render({
    elem: '#test11'
    ,format: 'yyyy年MM月dd日'
  });
  laydate.render({
    elem: '#test12'
    ,format: 'dd/MM/yyyy'
  });
  laydate.render({
    elem: '#test13'
    ,format: 'yyyyMMdd'
  });
  laydate.render({
    elem: '#test14'
    ,type: 'time'
    ,format: 'H点m分'
  });
  laydate.render({
    elem: '#test15'
    ,type: 'month'
    ,range: '~'
    ,format: 'yyyy-MM'
  });
  laydate.render({
    elem: '#test16'
    ,type: 'datetime'
    ,range: '到'
    ,format: 'yyyy年M月d日H时m分s秒'
  });
  
  //开启公历节日
  laydate.render({
    elem: '#test17'
    ,calendar: true
  });
  
  //自定义重要日
  laydate.render({
    elem: '#test18'
    ,mark: {
      '0-10-14': '生日'
      ,'0-12-31': '跨年' //每年的日期
      ,'0-0-10': '工资' //每月某天
      ,'0-0-15': '月中'
      ,'2017-8-15': '' //如果为空字符，则默认显示数字+徽章
      ,'2099-10-14': '呵呵'
    }
    ,done: function(value, date){
      if(date.year === 2017 && date.month === 8 && date.date === 15){ //点击2017年8月15日，弹出提示语
        layer.msg('这一天是：中国人民抗日战争胜利72周年');
      }
    }
  });
  
  //限定可选日期
  var ins22 = laydate.render({
    elem: '#test-limit1'
    ,min: '2016-10-14'
    ,max: '2080-10-14'
    ,ready: function(){
      ins22.hint('日期可选值设定在 <br> 2016-10-14 到 2080-10-14');
    }
  });
  
  //前后若干天可选，这里以7天为例
  laydate.render({
    elem: '#test-limit2'
    ,min: -7
    ,max: 7
  });
  
  //限定可选时间
  laydate.render({
    elem: '#test-limit3'
    ,type: 'time'
    ,min: '09:30:00'
    ,max: '17:30:00'
    ,btns: ['clear', 'confirm']
  });
  
  //同时绑定多个
  lay('.test-item').each(function(){
    laydate.render({
      elem: this
      ,trigger: 'click'
    });
  });
  
  //初始赋值
  laydate.render({
    elem: '#test19'
    ,value: '1989-10-14'
    ,isInitValue: true
  });
  
  //选中后的回调
  laydate.render({
    elem: '#test20'
    ,done: function(value, date){
      layer.alert('你选择的日期是：' + value + '<br>获得的对象是' + JSON.stringify(date));
    }
  });
  
  //日期切换的回调
  laydate.render({
    elem: '#test21'
    ,change: function(value, date){
      layer.msg('你选择的日期是：' + value + '<br><br>获得的对象是' + JSON.stringify(date));
    }
  });
  //不出现底部栏
  laydate.render({
    elem: '#test22'
    ,showBottom: false
  });
  
  //只出现确定按钮
  laydate.render({
    elem: '#test23'
    ,btns: ['confirm']
  });
  
  //自定义事件
  laydate.render({
    elem: '#test24'
    ,trigger: 'mousedown'
  });
  
  //点我触发
  laydate.render({
    elem: '#test25'
    ,eventElem: '#test25-1'
    ,trigger: 'click'
  });
  
  //双击我触发
  lay('#test26-1').on('dblclick', function(){
    laydate.render({
      elem: '#test26'
      ,show: true
      ,closeStop: '#test26-1'
    });
  });
  
  //日期只读
  laydate.render({
    elem: '#test27'
    ,trigger: 'click'
  });
  
  //非input元素
  laydate.render({
    elem: '#test28'
  });
  
  //墨绿主题
  laydate.render({
    elem: '#test29'
    ,theme: 'molv'
  });
  
  //自定义颜色
  laydate.render({
    elem: '#test30'
    ,theme: '#393D49'
  });
  
  //格子主题
  laydate.render({
    elem: '#test31'
    ,theme: 'grid'
  });
  
  
  //直接嵌套显示
  laydate.render({
    elem: '#test-n1'
    ,position: 'static'
  });
  laydate.render({
    elem: '#test-n2'
    ,position: 'static'
    ,lang: 'en'
  });
  laydate.render({
    elem: '#test-n3'
    ,type: 'month'
    ,position: 'static'
  });
  laydate.render({
    elem: '#test-n4'
    ,type: 'time'
    ,position: 'static'
  });
});
</script>

</body>
</html>