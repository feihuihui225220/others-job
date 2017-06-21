<!DOCTYPE HTML>
<html>
<head>
<title>添加活动</title>
#parse("/common/top.tpl")
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<link href="/ueditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" charset="utf-8" src="/ueditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/ueditor/umeditor.min.js"></script>
<style>
 	.commonTable tr td input{ height: 25px; line-height: 25px;}
 	.commonTable tr th{ width: 200px;}
</style>
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div  style="margin: 0 auto;width: 1000px; float: left; margin-left: 100px;">
            <div class="actboxlist">
                <label>添加信息</label>
                <form action="/active/saveActive" method="post" enctype="multipart/form-data" onsubmit="return sub()">
                <hr/>
                <div class="actbox8 ">
                    <table class="commonTable" style="width:700px; height: 260px;">
                        <tr><input type="hidden" name="id" value="$!active.id"/>
                        	<th>活动名称：</th>
                        	<td><input type="text" name="activeName" id="activeName" value="$!active.activeName" autocomplete='off' /></td>
                        </tr>
                        <tr>
                        	<th>活动时间：</th>
                        	<td><input type="text" name="stTime" id="stTime" placeholder="开始时间" value="$!date.format('yyyy-MM-dd 

hh:mm:ss',$!startTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete='off'/>
		   						-<input type="text" name="endTime" id="endTime"  placeholder="结束时间"  

value="$!date.format('yyyy-MM-dd hh:mm:ss',$!endTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete='off'/>
                        		<input type="text" name="activeTime" id="activeTime" value="$!active.activeTime"/></td>
                        </tr>
                         <tr>
                        	<th>宣传海报：</th>
                        	<td><input type="file" name="pics" id="file" style="border:1px solid #CCC; width: 170px;"  

autocomplete='off'/></td>
                        </tr>
                        <tr>
                        	<th>阅读人数：</th>
                        	<td><input type="text" name="activerReadings" id="activerReadings" value="$!active.activerReadings"  

autocomplete='off'/></td>
                        </tr>
                        <tr>
                        	<th>联系人：</th>
                        	<td><input type="text" name="activeLxr" id="activeLxr" value="$!active.activeLxr"  autocomplete='off'/></td>
                        </tr>
                        <tr>
                        	<th>联系电话： </th>
                        	<td><input type="text" name="activePhone" id="activePhone" value="$!active.activePhone"  autocomplete='off'/></td>
                        </tr>
                    </table>
                     <label style="background-color: #def2f5;width: 150px;line-height: 38px;height: 38px;">活动描述：</label>
					  <script type="text/plain" id="myEditor" name="activeDesc" style="width:60%;height:60%;"></script>
	                <script type="text/javascript">
	                    //实例化编辑器
	                    var um = UM.getEditor('myEditor');
	                    function getContent() {
	                        var arr = [];
	                        arr.push(UM.getEditor('myEditor').getContent());
	                        return arr.join("\n");
	                    }
	                </script>
                     <input type="submit" value="保存" class="btnBg " /> 
                     <input type="button" onclick="window.history.back()" value="取消" class="btnBg btnBg1" />     
                </div>
               </form>
               
            </div>
    </div>
</body>
<script type="text/javascript" src="/assets/js/My97DatePicker/WdatePicker.js"></script>
<script>
		function sub(){
			var activeName=$("#activeName").val();
			var stTime=$("#stTime").val();
			var endTime=$("#endTime").val();
			var file=$("#file").val();
			var activerReadings=$("#activerReadings").val(); 
			var activeLxr=$("#activeLxr").val(); 
			var activePhone=$("#activePhone").val(); 
			if(activeName==""){
				alert("活动名称不能为空！");
				return false;
			}
			if(stTime==""){
				alert("活动开始时间不能为空！");
				return false;
			}
			if(endTime==""){
				alert("活动结束不能为空！");
				return false;
			}
			if(file==""){
				alert("活动宣传海报不能为空！");
				return false;
			}
			if(activerReadings==""){
				alert("活动阅读量不能为空！");
				return false;
			}
			if(activeLxr==""){
				alert("活动联系人不能为空！");
				return false;
			}
			if(activePhone==""){
				alert("活动电话不能为空！");
				return false;
			}
			return true;
		};
	
</script>
</html>