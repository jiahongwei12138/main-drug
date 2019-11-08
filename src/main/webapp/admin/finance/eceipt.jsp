<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>总店销售单(总店收款)</title>
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
<script src="../layui/layui.js"></script>
<style type="text/css">

body {
	margin: 0 auto;
	width: 100%;
	height: 100%;
}
.demoTable {
	width: 100%;
	height: 50px;
	margin: 0px auto;
	line-height: 50px;
}
label{
	font-size: 13px;
}
</style>
</head>
<body>
<script>
	layui.use('laydate', function(){
	  var laydate = layui.laydate;
		//日期时间选择器
		  laydate.render({
		    elem: '#test5'
		    ,type: 'date'
		  });
	});
</script>
<div style="display: none" id="divTable">
	<table class="layui-hide" id="detailsTable" lay-filter="detailsTable"></table>
</div>

<table id="demo" lay-filter="test"></table>
<script>

	
	
	
		var table2 = null ;
		layui.use(['table','form','jquery'], function(){
			var table = layui.table, 
				form = layui.form;
				$ = layui.jquery;
			
			
			
		  //执行一个 table 实例
		 	table2 =  table.render({
		    elem: '#demo'
		    ,height:563
		    ,url:  '${APP_PATH}/querySaleOrder.do'//数据接口
		    ,title: '总店销售单'
		    ,page: true //开启分页
		    ,toolbar: '#toolbarDemo' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
		    ,totalRow: true //开启合计行
		    ,cols: [[ //表头
		    	{type:'checkbox',field: 'orderId', fixed: 'left'}
		        ,{field: 'orderNum', title: '订单编号', width:150, sort: true,unresize:true}
		        ,{field: 'payTime', title: '下单日期', unresize:true}
		        ,{field: 'getMoneyState', title: '收款状态', unresize:true}
		        ,{field: 'sendTime', title: '发货时间', unresize:true}
		        ,{field: 'receiveTime', title: '收货时间', unresize:true}
		        ,{field: 'checkState', title: '审核状态', unresize:true}
		        ,{field: 'outStoreState', title: '出库状态', unresize:true}
		        ,{field: 'bsfName', title: '分店名称', unresize:true}
		        ,{field: 'payrMoney', title: '付款金额', unresize:true}
		        ,{
		    		fixed: 'right', title:'操作',width:178, align:'center', toolbar: '#barDemo',unresize:true
		          }
		    ]]
		  });
		  $.ajax({
			  type:"post",
			  url:"${APP_PATH}/queryBranchStorefactsheet.do",
			  data:{
				"pactState":"已签订"  
			  },
			  success:function(result){
				  var dataArr=result.data;
				  var content='<option value="">请选择分店</option>';
				  $.each(dataArr,function(index,item){
					  content+='<option value="'+item.bsfName+'">'+item.bsfName+'</option>';
				  });    
				  $("#branchStore").html(content);
				  form.render('select')
				  console.log(content);
				  // console.log($("#branchStore"));
			  }
		  });
		 
		 	$(function() {
			 	//查询
		 		$("#seachTable").on("click",function(){
		 			//iframe层
		 			console.info("111");
		 			table2.reload({
		 				where : {
		 					flowerName:$("#name").val(),
		 				},
		 				page : {
		 					curr : 1
		 				}
		 			});
		 		});
		 	});
		 	 //头工具栏事件
		 	  table.on('toolbar(test)', function(obj){
		 	    var checkStatus = table.checkStatus(obj.config.id);
		 	    switch(obj.event){
		 	      case 'getCheckData':
		 	        var data = checkStatus.data;
		 	        console.log(data);
		 	        if(data.length==0){
		 	        	layer.msg("请选择要审核的订单", {time:3000, icon:2, shift:6});
		 	        }else if(data.length>1){
		 	        	layer.msg("请选择一条订单", {time:3000, icon:2, shift:6});
		 	        }else if(data[0].checkState=='已审核'){
		 	        	layer.msg("该订单已审核，请重新选择！", {time:3000, icon:2, shift:6});
		 	        }else{
		 	        	$.ajax({
		 	        		type:"post",
		 	        		url:"${APP_PATH}/checkOrder.do",
		 	        		data:{
		 	        			"orderId":data[0].orderId,
		 	        			"bpoId":data[0].bpoId
		 	        		},
		 	        		success:function(result){
		 	        			if(result==false){
									layer.msg("审核失败", {time:3000, icon:5, shift:6});
								}else{ 
									layer.msg("审核成功", {time:3000, icon:1, shift:3},function(){
										table.reload('demo');
									});
								}
		 	        		}
		 	        	});
		 	        }
		 	      break;
		 	      case 'searchOrder':
		 	    	  var payTime=$("#test5").val();
		 	    	  var branchStoreName=$("#branchStore").val();
		 	    	  var checkState=$("#checkState").val();
		 	    	  table.reload('demo', {
							url: '${APP_PATH}/querySaleOrder.do',
						  	where: { //设定异步数据接口的额外参数，任意设
						    	"payTime": payTime,
						    	"branchStoreName": branchStoreName,
						    	"checkState": checkState
						  	}
					  }); //只重载数据
		 	    	  break;
		 	    };
		 	  });
	 	//监听头工具栏事件
	 	  table.on('select', function(data){
	 		 console.log(data.elem);
	 		 console.log(data.value);
	 		 $('#audit').val(data.value);
	 		 console.log(data.othis);
	 		 var audit=$('#audit').val();
	 		 alert(audit);
	 	  });
	 	
		//监听操作
		table.on('tool(test)', function(obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			var data = obj.data; //获得当前行数据
			var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			var tr = obj.tr; //获得当前行 tr 的DOM对象
	
			if (layEvent === 'del') { //查看
				layer.confirm('真的删除行么',function(index) {
					$.ajax({
						type:"post",
						url:"${APP_PATH}/deleteSaleOrder.do",
						data:{
							"orderId":data.orderId
						},
						success:function(result){
							if(result==false){
								layer.msg("删除失败", {time:3000, icon:5, shift:6});
							}else{ 
								layer.msg("删除成功", {time:3000, icon:1, shift:3},function(){
									layer.close(index);
									table.reload('demo');
								});
							}
						}
						
					});
					/*obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
					layer.close(index);
					 //向服务端发送删除指令
					var url = "flowerServlet?action=delect";
					var data$ = {flowerId : data.flowerId};
					$.post(url,data$,function(obj) {
						layer.msg(obj.msg);//提示
						table2.reload(); //也是刷新父页面的
 					},"json"); */
				});
			} else if (layEvent === 'edit') { //编辑
				var data = obj.data;//行数据、
				//console.log(data);
				//iframe层
				layer.open({
					type : 1,
					title : '订单详情页面',//标题
					shadeClose : true,
					shade : 0.3,//背景阴影
					area : [ '50%', '60%' ],//大小
					content :$("#divTable"),
					success: function(layero, index){
						table.render({
							elem: '#detailsTable',
							url: '${APP_PATH}/querySaleOrderDetail.do?orderId='+data.orderId, //数据接口
							title: '用户表',
							totalRow: false, //开启合计行
							cols: [[ //表头
						    	/* {type:'checkbox',field: 'orderId', fixed: 'left'}
						        , */{field: 'proBatchNumber', title: '药品编号', width:150, sort: true,unresize:true}
						        ,{field: 'proName', title: '药品名称', unresize:true}
						        ,{field: 'retailPrice', title: '药品单价', unresize:true}
						        ,{field: 'proNum', title: '购买数量', unresize:true}
						        ,{field: 'proPrice', title: '价格小计', unresize:true}
						        /* ,{
						    		fixed: 'right', title:'操作',width:178, align:'center', toolbar: '#barDemo',unresize:true
						          } */
						    ]]
							});
						
					}
				});
			}
		});
		
	});
</script>

<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit" style="width:60px;height:30px;line-height:30px">查看订单</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" style="width:60px;height:30px;line-height:30px">删除</a>
</script>

 <script type="text/html" id="toolbarDemo">
<div class="layui-inline" style="margin-left:20px;">
					<label >下单日期：</label>
				<div class="layui-input-inline" style="margin-left:5px;">
					<input type="text"  class="layui-input" id="test5" placeholder="年--月--日 ">
				</div>
			</div>

	<div class="layui-inline" style="margin-left:20px;">
      <label >审核状态：</label>
      <div class="layui-input-inline" style="margin-left:5px;">
        <select id="checkState"  lay-search="required">
          <option value="">请选择</option>
          <option value="未审核">未审核</option>
		<option value="已审核">已审核</option>
        </select>
      </div>
    </div>	

 <div class="layui-inline" style="margin-left:20px;">
      <label >分店：</label>
      <div class="layui-input-inline" style="margin-left:5px;">
        <select id="branchStore" name="audit"  lay-search="required">
          
        </select>
      </div>
    </div>

		<div class="layui-inline" >
			<button class="layui-btn layui-btn-normal" lay-event="searchOrder">搜索</button>	
 	<button class="layui-btn layui-btn-normal" lay-event="getCheckData">审核</button>	
		</div>    

      </div>
    </div>
</script>
</body>
</html>