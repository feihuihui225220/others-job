<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
     <link rel="stylesheet" href="/assets/newCss/nullTbalecom.css" />
    <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css"/>
    <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
     <script src="$request.contextPath/assets/js/jquery.jqprint-0.3.js"></script>
      <style>
    	.underline tr td{
    		border-bottom:1px solid #666;
    	}
    	#class_lht{width:92%;margin-left:80px;}
    	.table{border: 1px solid black;}
    	.tab_table{width:100%;border: 1px solid black;}
    	.gds_css{ font-size:20px;width:85%;font-family:宋体!importent;}
    	//.gds_css{margin-left:8%;font-size:20px!important;width:85%;font-family:楷体!important;}
    </style>
</head>
<body>
<div class="wrapper"  >
		<div align="right" style="margin-bottom:30px; padding-left:110px;">
			     	<br/>
			<button class="ibtn button_add" style="margin-right: 70%;float:left;" onclick="javascripts:location.href='/professional/bao_gao_add?userId=${userId}'">添加报告</button>
			<button class="ibtn button_add" id="shangchuans"  >上传文件</button>
			<button class="ibtn button_add" id="shangchuan" style="margin-right: 70%; float:left; margin-left:100px; margin-top:-25px;"onclick="javascripts:location.href='/professional/assessgds?userId=${userId}'" >体检报告</button>
			<button class="ibtn button_add" data-userId="${userId}" id="assess" style="margin-right: 70%; float:left; margin-left:200px; margin-top:-25px;">量表分析</button>
		</div>
     	<br/>
	    <table id="table" class="table   trclick" style="width: 800px;position: relative;left: 10%" >
	        <tr>
	            <th style="width:12%">报告名称</th>
	            <th>报告日期</th>
	            <th>报告类型</th>
	            <th>报告来源</th>
	            <th>负责人</th>
	            <th style="width:12%"></th>
	            <th style="width:12%"></th>
	            <th style="width:12%"></th>
	        </tr>
	    </table>
</div>
<div id="myPrintArea" style="margin-left:8%;font-size:20px;width:85%;font-family:楷体;">
</div>
<div id="mima" style="width:440px;display:none; height:300px;z-index:10; position: absolute;
  left: 30%; top:10px; background-color:#87cefa; TEXT-ALIGN: center;" >
	<form action="/professional/vender/saveShangchuanBaoGao" method="post" onsubmit="return checkForm()" enctype="multipart/form-data">
	<table style="margin:0 auto; margin-top:10%;height:200px; width:380px;background-color:#e3f6fe; border:0;">	
		<h2>添加报告</h2>
		<tr style="border:0">
			<td>报告名称：</td><input type="hidden" value="${userId}" name="userId">
			<td><input type="text" name="reportName" id="reportName" /></td>
		</tr>
		<tr>
			<td>上传文件：</td>
			<td><input type="file" name="file" id="fd" style="border:1px solid black; width:170px; height:21px;" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="提交" style="width:80px;">
			<input type="button" id="close" value="取消" style="width:80px;"></td>
		</tr>
	</table> </form>
</div>
<script type="text/javascript">
	$(function(){
		$("#shangchuans").click(function(){
			$("#mima").show();
		})
		$("#close").click(function(){
			$("#mima").hide();
		})
		
		$.ajax({  
                url:"/UpReport/service/refer?userId="+${userId},  
                type:"post",          
                success:function(jsonlist){ 
                	var report=eval("("+jsonlist+")");
                	for(var i=0;i<report.list.length;i++){
                	 var time =	parseInt(report.list[i].dateTime);
                		var createdAt1 = new Date(time);
						var moth = createdAt1.getMonth()+1
						createdData=createdAt1.getFullYear()+"-"+moth+"-"+createdAt1.getDate();
						if(report.list[i].reportSource!=null){
							if(report.list[i].operate=='1'){
								var td=$("<tr class='tr_re'>"+"<td class='check'>"+
								"<input type='hidden' class='url' value='"+report.list[i].url+"' name='"+report.list[i].number+"'>"+
								"<input type='hidden' class='url' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+
								report.list[i].reportName+"</td>"+
								"<td class='check'>"+createdData+"</td>"+
								"<td class='check'>"+report.list[i].reportType+"</td>"+
								"<td class='check'>"+report.list[i].reportSource+"</td>"+
								"<td class='check'>"+report.list[i].principal+"</td>"+"<td>"+
								"<input type='button' style='float:left' class='ibtn button_add' value='删除'/>"+
								"</td>"+"<td>"+"<input type='button' style='float:right' class='down button_add' value='下载'/>"+
								"</td><td></td>"+"</tr>")
							}else{
                				var td=$("<tr class='tr_re'>"+"<td class='check'>"+"<input type='hidden' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+report.list[i].reportName+"</td>"+"<td class='check'>"+createdData+"</td>"+"<td class='check'>"+report.list[i].reportType+"</td>"+"<td class='check'>"+report.list[i].reportSource+"</td>"+"<td class='check'>"+report.list[i].principal+"</td>"+"<td>"+"<input type='button' style='float:left' class='ibtn button_add' value='删除'/>"+"</td>"+"<td>"+"<input type='button' style='float:right' class='stamp button_add' value='打印'/>"+"</td><td><input type='button' style='float:right' class='stamp button_add yulan' value='预览'/>"+"</td>"+"</tr>")
							}
							$('#table').append(td);
						}else{
							if(report.list[i].operate=='1'){
                				var td=$("<tr class='tr_re'>"+
                				"<td class='check'>"+
                				"<input type='hidden' value='"+report.list[i].url+"' name='"+report.list[i].number+"'>"+
                				"<input type='hidden' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+
                				report.list[i].reportName+"</td>"+"<td class='check'>"+createdData+"</td>"+
                				"<td class='check'>"+report.list[i].reportType+"</td>"+"<td class='check'></td>"+
                				"<td class='check'>"+report.list[i].principal+"</td>"+
                				"<td>"+"<input type='button' style='float:left' class='ibtn button_add' value='删除'/>"+
                				"</td>"+"<td>"+"<input type='button' style='float:right' class='down button_add' value='下载'>"+
                				"</td><td></td>"+"</tr>")
							}else{
								var td=$("<tr class='tr_re'>"+"<td class='check'>"+"<input type='hidden' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+report.list[i].reportName+"</td>"+"<td class='check'>"+createdData+"</td>"+"<td class='check'>"+report.list[i].reportType+"</td>"+"<td class='check'></td>"+"<td class='check'>"+report.list[i].principal+"</td>"+"<td>"+"<input type='button' style='float:left' class='ibtn button_add' value='删除'/>"+"</td>"+"<td>"+"<input type='button' style='float:right' class='stamp button_add' value='打印'>"+"</td><td><input type='button' style='float:right' class='stamp button_add yulan' value='预览'/>"+"</td>"+"</tr>")
							}
							$('#table').append(td);
						}								
                	}
                	
                }  
            });  
            $('.down').live('click', function(){
            	var url=$(this).parent().parent().find("input:first").val();
            	location.href="/"+url;
            });
         /*$('.check').live('click', function(){
         	var dateTime=$(this).parent().find("input").val();
         	alert(dateTime);
         	location.href="/UpReport/service/check?dateTime="+dateTime;
         }); */
         /**/
          $('.yulan').live('click', function(){
         	var dateTime=$(this).parent().parent().find("input").val();
         	location.href="/UpReport/service/check?dateTime="+dateTime;
         });  
         $('#table tr td .ibtn').live('click',function(){
         	var url=$(this).parent().parent().find("input:eq(2)").val();
         	var dateTime;
         	if(url=="打印"){
         		dateTime=$(this).parent().parent().find("input:eq(0)").val();
         	}else{
         		dateTime=$(this).parent().parent().find("input:eq(1)").val();
         	}
         	$('.tr_re').remove();
         	$.ajax({  
                url:"/UpReport/service/delete?dateTime="+dateTime+"&userId="+${userId}, 
                type:"post",          
                success:function(jsonlist){ 
                	$.ajax({  
			                url:"/UpReport/service/refer?userId="+${userId},  
			                type:"post",          
			                success:function(jsonlist){ 
			                	var report=eval("("+jsonlist+")");
			                	for(var i=0;i<report.list.length;i++){
			                	 var time =	parseInt(report.list[i].dateTime);
			                		var createdAt1 = new Date(time);
									var moth = createdAt1.getMonth()+1
									createdData=createdAt1.getFullYear()+"-"+moth+"-"+createdAt1.getDate();
									if(report.list[i].reportSource!=null){
			                			/*var td=$("<tr class='tr_re'>"+"<td class='check'>"+"<input type='hidden' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+report.list[i].reportName+"</td>"+"<td class='check'>"+createdData+"</td>"+"<td class='check'>"+report.list[i].reportType+"</td>"+"<td class='check'>"+report.list[i].reportSource+"</td>"+"<td class='check'>"+report.list[i].principal+"</td>"+"<td>"+"<input type='button' style='float:left' class='ibtn button_gm' value='删除'/>"+"</td>"+"<td>"+"<input type='button' style='float:right' class='stamp button_gm' value='打印'/>"+"</td>"+"</tr>")*/
										if(report.list[i].operate=='1'){
												var td=$("<tr class='tr_re'>"+"<td class='check'>"+
												"<input type='hidden' class='url' value='"+report.list[i].url+"' name='"+report.list[i].number+"'>"+
												"<input type='hidden' class='url' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+
												report.list[i].reportName+"</td>"+
												"<td class='check'>"+createdData+"</td>"+
												"<td class='check'>"+report.list[i].reportType+"</td>"+
												"<td class='check'>"+report.list[i].reportSource+"</td>"+
												"<td class='check'>"+report.list[i].principal+"</td>"+"<td>"+
												"<input type='button' style='float:left' class='ibtn button_add' value='删除'/>"+
												"</td>"+"<td>"+"<input type='button' style='float:right' class='down button_add' value='下载'/>"+
												"</td><td></td>"+"</tr>")
											}else{
				                				var td=$("<tr class='tr_re'>"+"<td class='check'>"+"<input type='hidden' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+report.list[i].reportName+"</td>"+"<td class='check'>"+createdData+"</td>"+"<td class='check'>"+report.list[i].reportType+"</td>"+"<td class='check'>"+report.list[i].reportSource+"</td>"+"<td class='check'>"+report.list[i].principal+"</td>"+"<td>"+"<input type='button' style='float:left' class='ibtn button_add' value='删除'/>"+"</td>"+"<td>"+"<input type='button' style='float:right' class='stamp button_add' value='打印'/>"+"</td><td><input type='button' style='float:right' class='stamp button_add yulan' value='预览'/>"+"</td>"+"</tr>")
											}
										$('#table').append(td);
									}else{
			                			/*var td=$("<tr class='tr_re'>"+"<td class='check'>"+"<input type='hidden' value='"+report.list[i].dateTime+"'  name='"+report.list[i].number+"'>"+report.list[i].reportName+"</td>"+"<td class='check'>"+createdData+"</td>"+"<td class='check'>"+report.list[i].reportType+"</td>"+"<td class='check'></td>"+"<td class='check'>"+report.list[i].principal+"</td>"+"<td>"+"<input type='button' style='float:left' class='ibtn button_gm' value='删除'/>"+"</td>"+"<td>"+"<input type='button' style='float:right' class='stamp button_gm' value='打印'>"+"</td>"+"</tr>")
										*/
										if(report.list[i].operate=='1'){
				                				var td=$("<tr class='tr_re'>"+
				                				"<td class='check'>"+
				                				"<input type='hidden' value='"+report.list[i].url+"' name='"+report.list[i].number+"'>"+
				                				"<input type='hidden' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+
				                				report.list[i].reportName+"</td>"+"<td class='check'>"+createdData+"</td>"+
				                				"<td class='check'>"+report.list[i].reportType+"</td>"+"<td class='check'></td>"+
				                				"<td class='check'>"+report.list[i].principal+"</td>"+
				                				"<td>"+"<input type='button' style='float:left' class='ibtn button_add' value='删除'/>"+
				                				"</td>"+"<td>"+"<input type='button' style='float:right' class='down button_add' value='下载'>"+
				                				"</td><td></td>"+"</tr>")
											}else{
												var td=$("<tr class='tr_re'>"+"<td class='check'>"+"<input type='hidden' value='"+report.list[i].dateTime+"' name='"+report.list[i].number+"'>"+report.list[i].reportName+"</td>"+"<td class='check'>"+createdData+"</td>"+"<td class='check'>"+report.list[i].reportType+"</td>"+"<td class='check'></td>"+"<td class='check'>"+report.list[i].principal+"</td>"+"<td>"+"<input type='button' style='float:left' class='ibtn button_add' value='删除'/>"+"</td>"+"<td>"+"<input type='button' style='float:right' class='stamp button_add' value='打印'>"+"</td>"+"</tr>")
											}
										$('#table').append(td);
									}								
			                	}
			                	
			                }  
			            });  
                }  
            });  
         	
         	//window.location.href="/UpReport/service/delete?dateTime="+dateTime+"&userId="+${userId};
         	$('.tr_re').remove;
         	
         });
         var number="";   
         $('#table tr td .stamp').live('click',function(){
         	var dateTime=$(this).parent().parent().find("input").val();
         	number=$(this).parent().parent().find("input").attr("name");
         	 $.ajax({
                   url: "/UpReport/service/check_stamp?dateTime="+dateTime,
                   type: "post",
                   dataType:"text",
                   success: function (mjson) {
	                   $('#myPrintArea').append(mjson);
	                   var number1="编号："+number;
	                   $('#number').html(number1)
	                   //alert($('#number').html());
	                   $('.tab_table').addClass('table');
						print();
                  }
                });
         })   
	});
	function print(){
		$("#myPrintArea").jqprint(); 
		$("#myPrintArea").html("");
	}
	function checkForm(){
		var name=$("#reportName").val();
		var fd=$("#fd").val();
		if(name==""){
			alert("报告名称不能为空");
			return false;
		}
		if(fd==""){
			alert("上传文件不能为空");
			return false;
		}
		
	}
	$('#assess').click(function(){
		var userId=$(this).attr('data-userId');
		location.href="/muerIntervene/charts?userId="+userId;
	});
</script>
</body>
</html>