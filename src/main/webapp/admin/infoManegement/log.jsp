<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>日志管理</title>
<link rel="stylesheet" href="${APP_PATH }/layui/css/layui.css">
<script src="${APP_PATH }/layui/layui.js"></script>
<script type="text/javascript" src="${APP_PATH }/js/jquery-3.4.1.min.js"></script>     
</head>
<body>
	<table class="layui-hide" id="test" lay-filter="test"></table>
	<table class="layui-hide" id="test2" lay-filter="test2"></table>
	<table class="layui-hide" id="test3" lay-filter="test3"></table>

	<script type="text/html" id="toolbarDemo">
	<label width="120px" style="margin:0 5px 0 20px;font-size:13px;">操作时间：</label>
	<div class="layui-input-inline">
		<input type="text" name="joinTime" id="date1" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
		<input type="text" name="joinTime" id="date2" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">  
	</div>
	<button type="button" class="layui-btn" lay-event="getDateTime" layui-btn-normal">查询</button>
    <button class="layui-btn" lay-event="getCheckData">删除所选</button>
</script>
<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

	<script>
layui.use(['table','laydate','form'], function(){
  var table = layui.table;
  var laydate = layui.laydate;
  var form = layui.form;
  var laydate = layui.laydate;
//日期
  laydate.render({
    elem: '#date1'
  });
  laydate.render({
	elem: '#date2'
  });
  
  table.render({
    elem: '#test'
    ,url:'${APP_PATH}/queryLog.do'
    ,toolbar: '#toolbarDemo'
    ,title: '日志'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field:'logId', title:'日志编号',align:'center', unresize:true}
      ,{field:'empName', title:'操作人',align:'center',unresize:true}
      ,{field:'dateTimes', title:'操作时间',align:'center',unresize:true}
      ,{field:'notes', title:'日志内容', align:'center',unresize:true}
      ,{
		fixed: 'right', align:'center', toolbar: '#barDemo',unresize:true
      }
    ]]
    ,page: true
  });
  
  
  //监听工具条
  table.on('tool(test)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确认删除该日志', function(index){
    	  $.ajax({
				type:"post",
				url:"${APP_PATH}/deletLogById.do",
				data:{
					"logId":data.logId,
				},
				success:function(result){
					if(result==false){
						layer.msg("删除失败", {time:3000, icon:5, shift:6});
					}else{
						layer.msg("删除成功", {time:3000, icon:1, shift:3});
						obj.del();
					}
					layer.close(index);
				}
			});
      });
    }
  });
  
//头工具栏事件
  table.on('toolbar(test)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    switch(obj.event){
      case 'getCheckData':
        var data = checkStatus.data;
        var logIds=[];
        for(var i=0;i<data.length;i++){
        	logIds.push(data[i].logId);
        }
        if(logIds.length!=0){
        	$.ajax({
        		  type:"post",
        		  url:"${APP_PATH}/deleteBatchLogById.do",
        		  traditional:true,
        		  data:{
        			  "logIds":logIds
        		  },
        		  success:function(result){
        			  if(result==false){
	      				layer.msg("删除失败", {time:3000, icon:5, shift:6});
	      			  }else{
	      				layer.msg("删除成功", {time:3000, icon:1, shift:3},function(){
	      					table.reload('test')
	      				});
	      			  }
	        	  }
        	  });
        }else{
        	layer.msg("请选择要删除的数据！", {time:3000, icon:5, shift:6});
        }
        break;
      case 'getDateTime':
    	  var startTime=$("#date1").val();
    	  var endTime=$("#date2").val();
    	  table.reload('test', {
				url: '${APP_PATH}/queryLog.do'
			  	,where: { //设定异步数据接口的额外参数，任意设
			    	"startTime": startTime,
			    	"endTime": endTime
			  	}
			}); //只重载数据
    	  break;
    };
  });
  
  //下拉框选中
  form.on('select(selectFilter)', function(data){
	  if(data.value == '001'){
		  
	  }else if(data.value == '002'){
		  
	  }//得到被选中的值
	});      
  
});
</script>


</body>
</html>