<!DOCTYPE HTML>
<html>
<head>
<title>CM编辑照片</title>
#parse("/common/top.tpl")
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<style>
 	.commonTable tr td input{ height: 25px; line-height: 25px;}
 	.commonTable tr th{width: 200px;}
 	.th{background-color: #def2f5;  line-height: 38px;height: 38px;
 		text-align: center; font-weight:bolder; width: 158px;margin-left: 3px;}
 		.add{cursor: pointer;}
 		.miaoshu{margin-left: 60px;}
 		.file{border:1px solid #CCC;width: 170px;margin-bottom: 10px;}
 		.jian{cursor: pointer; color: red;font-weight: bolder;}
 		.img{width: 200px; height: 150px; margin-left: 10px;}
 		.chec{margin-left: 60px;}
 		#demo{height: auto;  margin-top: 20px;}
</style>
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICleft.tpl")
<div  style="margin: 0 auto;width: 800px;">
            <div class="actboxlist">
                <label>编辑信息</label>
                <form action="/active/CMUserModifyPhoto" method="post" enctype="multipart/form-data" onsubmit="return tijiao()">
                <hr/>
                <div class="actbox8 ">
                    <table class="commonTable" style="width: 700px; height: 260px;">
                        <tr><input type="hidden" name="id" id="pid" value="$!active.id"/>
                        	<input type="hidden" name="userId" value="$!ICUser.id"/>
                        	
                        	<th>活动名称：</th>
                        	<td><input type="text" name="activeName" value="$!active.activeName" autocomplete="off" /></td>
                        </tr>
                        <tr>
                        	<th>活动时间：</th>
                        	<td>
                        		<input type="text" name="startTime" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!active.startTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete="off"/>
                        		<input type="text" name="endTime" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!active.endTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete="off"/>
                        		<input type="text" name="activeTime" value="$!active.activeTime" autocomplete="off"/></td>
                        </tr>
                        
                        <tr>
                        	<th>阅读人数：</th>
                        	<td><input type="text" name="activerReadings" value="$!active.activerReadings" autocomplete="off"/></td>
                        </tr>
                        <tr>
                        	<th>联系人：</th>
                        	<td><input type="text" name="activeLxr" value="$!active.activeLxr" autocomplete="off"/></td>
                        </tr>
                        <tr>
                        	<th>联系电话： </th>
                        	<td><input type="text" name="activePhone" value="$!active.activePhone" autocomplete="off"/></td>
                        </tr>
                    </table>
                    <p class="th">活动描述：</p>
                    	<textarea class="miaoshu" name="activeDesc" cols="60" rows="5">$!active.activeDesc</textarea><br/>
                     <p class="th">活动照片：</p>
                     <input type="button" id="checkall" class="btnBg" style="width: 60px;" name="checkall" value="全选" />
                        		<input type="button" id="delcheckall" class="btnBg" style="width: 90px;" name="delcheckall" value="取消全选" />
                        		<input type="button" id="modify" class="btnBg" style="width: 60px;" value="编辑" />
                        		<input type="button" id="delete" class="btnBg" style="width: 60px;" value="删除" />
                        		<input type="button" id="save" class="btnBg add" style="width: 60px;" value="添加" />
						<input type="hidden" id="urls" value="$!active.activePoster"/>
					 <div id="demo"></div>
                     <input type="submit" value="保存" class="btnBg" /> 
                     <input type="button" onclick="window.history.back()" value="取消" class="btnBg btnBg1" />     
                </div>
               </form>
               
            </div>
    </div>
</body>
<script type="text/javascript" src="/assets/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//添加
		$(".add").click(function(){
			$("#demo").append("<input type='file' class='miaoshu file' name='pic'/>&nbsp;&nbsp;<a class='jian'>--</a><br/>");
		});
		//删除
		$(document).on('click','.jian',function(){
		 $(this).prev().remove(); 
		 $(this).remove();
		});
		//循环显示图片
		var urls=$("#urls").val();
		var strs= new Array(); //定义一数组
		if(urls!=""){
			strs=urls.split(",");
			for(var i=0;i<strs.length;i++){
				if(strs[i]!=""){
					$("#demo").append("<input name='checkname' class='chec' type='checkbox'/><img class='img' src='/gds/"+strs[i]+"' /><br/>");
				}
		     }
		}
		 //全选/取消全选
		$("#checkall").click(function(){
			$(":checkbox").prop("checked",true); 
		}); 
		$("#delcheckall").click(function() { 
			$(":checkbox").prop("checked",false); 
		}); 
		
			//删除
	$("#delete").click(function(){
		var size=$(":checkbox:checked").length;
		var url= new Array();
		if (size>0) {
			for(var k= 0; k <size; k++) {
				var urls=$(":checkbox:checked").eq(k).next().attr("src");
				urls=urls.replace("/gds/","");
				url.push(urls);
			}
			var pid=$("#pid").val();
			 $.ajax({
		   		url:"/active/CMdelete?id="+pid+"&url="+url,
		   		type:"get",
		   		//data:{"id":pid,"url":url+"bbbb"},
		   		success: function(result){
							var res = String($.trim(result)); 
							if(res=="OK"){ 
								alert("删除成功");
								window.location.reload();
							}else{ 
								alert("删除失败");
							} 
				} 
		   	});
		}else{
			alert("请至少选择一个进行删除！");
		}
	});
	//编辑
	$("#modify").click(function(){
		var url= new Array();
		var size=$(":checkbox:checked").length;
		if (size>0) {
			for(var j=0;j<size;j++){
				var urls=$(":checkbox:checked").eq(j).next().attr("src");
				urls=urls.replace("/","");
				url.push(urls);
				 $("#img").append("<input type='file' name=pic style='border:1px solid #CCC;width: 170px;margin-bottom: 10px;' /><br/>");
			}
			$("#deleteUrl").val(url);
		}else{
			alert("请至少选择一个进行编辑！");
		}
	});
});
		
	
</script>
</html>