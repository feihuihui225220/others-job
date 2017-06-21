<!DOCTYPE HTML>
<html>
<head>
<title>编辑活动</title>
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
<div  style="margin: 0 auto;width: 1000px;">
            <div class="actboxlist">
                <label>编辑信息</label>
                <form action="/active/modifyActive" method="post" enctype="multipart/form-data">
                <hr/>
                <div class="actbox8 ">
                    <table class="commonTable" style="width:700px; height: 260px;">
                        <tr><input type="hidden" name="id" value="$!active.id"/>
                        	<th>活动名称：</th>
                        	<td><input type="text" name="activeName" value="$!active.activeName" /></td>
                        	<td rowspan="6"><img src="/$!active.activePoster" width="150" height="200" /></td>
                        </tr>
                        <tr>
                        	<th>活动时间：</th>
                        	<td><input type="text" name="stTime" placeholder="开始时间"  value="$!date.format('yyyy-MM-dd hh:mm:ss',$!active.startTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete='off'/>
		   						- <input type="text" name="endTime"  placeholder="结束时间"  value="$!date.format('yyyy-MM-dd hh:mm:ss',$!active.endTime)" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" autocomplete='off'/>
                        		<input type="text" name="activeTime" id="activeTime" value="$!active.activeTime"/></td>
                        </tr>
                         <tr>
                        	<th>宣传海报：</th>
                        	<td><input type="file" name="pic" style="border:1px solid #CCC; width: 170px;" /></td>
                        </tr>
                        <tr>
                        	<th>阅读人数：</th>
                        	<td><input type="text" name="activerReadings" value="$!active.activerReadings"/></td>
                        </tr>
                        <tr>
                        	<th>联系人：</th>
                        	<td><input type="text" name="activeLxr" value="$!active.activeLxr"/></td>
                        </tr>
                        <tr>
                        	<th>联系电话： </th>
                        	<td><input type="text" name="activePhone" value="$!active.activePhone"/></td>
                        </tr>
                    </table>                    
                    <label style="background-color: #def2f5;width: 150px;line-height: 38px;height: 38px;">活动描述：</label>
					 <script type="text/plain" id="myEditor" name="activeDesc" style="width:60%;height:60%;">
							#if($active.activeDesc)
									 $!active.activeDesc 
							#else
									<p>这里我可以写一些输入提示</p>
							#end
					</script>
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
</html>