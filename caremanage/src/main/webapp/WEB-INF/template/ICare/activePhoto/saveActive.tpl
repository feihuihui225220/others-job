<!DOCTYPE HTML>
<html>
<head>
<title>CM添加照片</title>
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
</style>
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICleft.tpl")
<div  style="margin: 0 auto;width: 900px;">
            <div class="actboxlist">
                <label>添加信息(*为必填的)</label>
                <form action="/active/CMUserAddPhoto" method="post" enctype="multipart/form-data" onsubmit="return tijiao()">
                <hr/>
                <div class="actbox8 ">
                    <table class="commonTable" style="width: 700px; height: 260px;">
                        <tr><input type="hidden" name="id" value="$!active.id"/>
                        	<input type="hidden" name="userId" value="$!ICUser.id"/>
                        	
                        	<th>活动名称：</th>
                        	<td><input type="text" name="activeName" value="$!active.activeName" autocomplete="off" />*</td>
                        </tr>
                        <tr>
                        	<th>活动时间：</th>
                        	<td><input type="text" name="startTime" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!active.startTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete="off"/>
                        		- <input type="text" name="endTime" value="$!date.format('yyyy-MM-dd hh:mm:ss',$!active.endTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete="off"/>
                        		<input type="text" name="activeTime" value="$!active.activeTime" autocomplete="off"/> *
                        	</td>
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
                    	<textarea class="miaoshu" name="activeDesc" cols="60" rows="5"></textarea><br/>
                     <p class="th">活动照片：</p>
						<input type="file" class="miaoshu file" name="pic" />&nbsp;&nbsp;<a class="add">+</a>*<br/>
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
		$(".add").click(function(){
			$("#demo").append("<input type='file' class='miaoshu file' name='pic'/>&nbsp;&nbsp;<a class='jian'>--</a><br/>");
		});
		$(document).on('click','.jian',function(){
		 $(this).prev().remove(); 
		 $(this).remove();
	});
	});
	//删除
	
	
</script>
</html>