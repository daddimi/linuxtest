<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#container{
	width:500px;
	height:400px;
	border:2px solid red;
}
</style>

<script>
function display(y){
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: '지하철 이용승객 2020.09.29'
	    },
	    subtitle: {
	        text: 'Click the columns to view versions. Source: <a href="http://statcounter.com" target="_blank">statcounter.com</a>'
	    },
	    accessibility: {
	        announceNewData: {
	            enabled: true
	        }
	    },
	    xAxis: {
	        type: 'category'
	    },
	    yAxis: {
	        title: {
	            text: '(단위:)'
	        }

	    },
	    legend: {
	        enabled: false
	    },
	    plotOptions: {
	        series: {
	            borderWidth: 0,
	            dataLabels: {
	                enabled: true,
	                format: '{point.y}'
	            }
	        }
	    },

	    tooltip: {
	        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
	        pointFormat: '<span style="color:{point.color}">{point.name}{point.y}</span>'
	    },

	    series:  [{
	    	name: "지하철",
    	    colorByPoint: true,
     	    data: y
    	          
	}]
	    
	});
	};
	
	

function getData(){
	$.ajax({
		url:'getdata4.mc',
		success:function(y) {
			display(y)
		},
		error:function(){
		
		}
	});
	
	//display();
};

$(document).ready(function(){
	getData();
});
</script>

<h1>Chart3</h1>
<div id="container">

</div>