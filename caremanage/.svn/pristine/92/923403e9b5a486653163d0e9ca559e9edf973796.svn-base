<!DOCTYPE html>
<html>
  <head>
    <title>countlist.tpl</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head> 
  <body>
  #parse("/common/dtop.tpl")
  #parse("/common/dmain.tpl")
<div style=" margin-left: 220px;">
    <div id="container" style="min-width:400px;height:400px"></div>
    <div id="container2" style="min-width:400px;height:400px"></div>
    <div id="container3" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
    <div id="san">
             <table id="datatable" >
             <thead>
               <tr>
                <th></th>
                <th>上门巡诊</th>
                <th>电话巡诊</th>
               </tr>
             </thead>
    
             <tbody>
            
             #foreach ($u in $round)
              #set($i=$u.groups+"组")
              <tr>
              <th>$i</th>
              <td>$!u.ruhu</td>
              <td>$!u.phone</td>
              </tr>
              
              #end
              
        
             </tbody>
        </table>
    </div>    
    <div id="container4" style="min-width:400px;height:400px"></div>
    <div id="container5" style="min-width:400px;height:400px"></div>
    
  </div>	  
    <script src="../../../../assets/director/js/jquery-1.12.4.min.js"></script>
   <script type="text/javascript" src="../../../../assets/director/js/highcharts.js"></script>
   <script src="../../../../assets/director/js/exporting.js"></script>
   <script src="../../../../assets/director/js/datas.js"></script>
   
   <script type="text/javascript">
   $(function () {
	    $('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '当前累计人数($sum1)'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            type: 'category',
	            labels: {
	                rotation: -45,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '社区人数 '
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: '社区人数: <b>{point.y:.1f} </b>'
	        },
	        series: [{
	            name: 'Population',
	            data: [
                    #foreach ($u in $user)
	                ['$!u.get(1)', $!u.get(0)],
	                #end          
	            ],
	            dataLabels: {
	                enabled: true,
	                rotation: -90,
	                color: '#FFFFFF',
	                align: 'right',
	                format: '{point.y:.1f}', // one decimal
	                y: 10, // 10 pixels down from the top
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        }]
	    });
	});
    </script>
    <script type="text/javascript">
   $(function () {
	    $('#container2').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '本月新增人数($sum2)'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            type: 'category',
	            labels: {
	                rotation: -45,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '社区人数'
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: '社区人数: <b>{point.y:.1f} </b>'
	        },
	        series: [{
	            name: 'Population',
	            data: [
                    #foreach ($u in $users)
	                ['$!u.get(1)', $!u.get(0)],
	                #end          
	            ],
	            dataLabels: {
	                enabled: true,
	                rotation: -90,
	                color: '#FFFFFF',
	                align: 'right',
	                format: '{point.y:.1f}', // one decimal
	                y: 10, // 10 pixels down from the top
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        }]
	    });
	});
    </script>
    <script type="text/javascript">
  
    $(function () {
    	document.getElementById("san").style.display="none";
        $('#container3').highcharts({
            data: {
                table: 'datatable'
                
            },
            plotOptions: {
                column: {
                   
                    pointWidth: 30
                }
            },
            chart: {
                type: 'column'
            },
            title: {
                text: '巡诊统计($sum3)'
            },
            yAxis: {
                allowDecimals: false,
                title: {
                    text: '巡诊统计'
                }
            },
            tooltip: {
               
            }
        });
    });
    console.log();
    </script>
     <script type="text/javascript">
   $(function () {
	    $('#container4').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '转诊人数($sum4)'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            type: 'category',
	            labels: {
	                rotation: -45,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '转诊人数'
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: '转诊人数: <b>{point.y:.1f} </b>'
	        },
	        series: [{
	            name: 'Population',
	            data: [
                    #foreach ($u in $transfer)
	                [
	                '$!u.get(2)', $!u.get(0)],
	                #end          
	            ],
	            dataLabels: {
	                enabled: true,
	                rotation: -90,
	                color: '#FFFFFF',
	                align: 'right',
	                format: '{point.y:.1f}', // one decimal
	                y: 10, // 10 pixels down from the top
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        }]
	    });
	});
    </script>
     <script type="text/javascript">
   $(function () {
	    $('#container5').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '会诊人数($sum5)'
	        },
	        subtitle: {
	            text: ''
	        },
	        xAxis: {
	            type: 'category',
	            labels: {
	                rotation: -45,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '会诊人数'
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: '会诊人数: <b>{point.y:.1f} </b>'
	        },
	        series: [{
	            name: 'Population',
	            data: [
                    #foreach ($u in $consul)
	                [
	                '$!u.get(1)', $!u.get(0)],
	                #end          
	            ],
	            dataLabels: {
	                enabled: true,
	                rotation: -90,
	                color: '#FFFFFF',
	                align: 'right',
	                format: '{point.y:.1f}', // one decimal
	                y: 10, // 10 pixels down from the top
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif'
	                }
	            }
	        }]
	    });
	});
    </script>
 <script type="text/javascript">
$(function(){
$(".main .main_left .sidebar li a").eq(0).css("border-left","4px solid #008fa4").css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
		
});
</script>  
  </body>

</html>
