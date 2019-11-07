<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>分店销量报表</title>
    <!--引入echarts.js-->
    <script src="${APP_PATH }/js/echarts.js"></script>
    <script src="${APP_PATH }/js/jquery-3.4.1.min.js"></script>
</head>
<body>
    <!--为ECharts准备一个具备大小（宽高）的Dom-->
    <div id = "main" style = "width:600px;height:400px;margin-left: 150px;margin-top: 70px;"></div>
    <script type = "text/javascript">
        //基于准备好的dom，初始化echarts实例
        var myChar = echarts.init(document.getElementById('main'));
 
        $.ajax({
        	type:"post",
        	url:"${APP_PATH}/querySaleReport.do",
        	success:function(result){
        		// 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '分店销售报表'
                    },
                    tooltip: {},
                    legend: {
                        data:['销量订单量']
                        ,itemGap:20
                    },
                    xAxis: {
                    	 name: '时间',
                        data: result.monthList
                    },
                    yAxis: {
                    	name: '销量订单量'
                    	},
                    series: [{
                        name: '销量订单量',
                        type: 'bar',
                        barGap:'20%',
                        data: result.orderNumList
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChar.setOption(option);
        	}
        });
         
    </script>
 
</body>
</html>