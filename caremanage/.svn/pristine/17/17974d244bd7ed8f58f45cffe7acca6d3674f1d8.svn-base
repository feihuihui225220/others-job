<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>管家列表</title>
#parse("/common/top.tpl")
<link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;">
<form action="/icare/managerInfo/add" method="post" enctype="multipart/form-data" >          	
            <div class="actboxlist">
                <div class="actbox8 ">
                
                    <table class="table100 usertable" >
                        <tr>
                        	<td>管家姓名：<input type="text" name="name" /></td>
                        </tr>
                         <tr>
                        	<td>管家格言：<input type="text" name="motto" ></td>
                        </tr>
                        <tr>
                        	<td>专业擅长：<input type="text" name="speciality" ></td>
                        </tr>
                        <tr>
                        	<td>管家详情：<input type="text" name="detail" ></td>
                        </tr>
                        <tr>
                        	<td>上传头像：<input type="file" name="pic" style="border: 1px solid #CCC;" /><br/>
                     
                        	</td>
                        </tr>
                        
                    </table>
                    <input type="submit" value="添加" class="btnBg"/>
                </div>
            </div>
            </form>
<table class="commonTable" style="width: 1000px;" id="spec">
	<tr>
		
		<th>管家姓名</th>
		<th>管家格言</th>
		<th>专业擅长</th>
		<th>管家详情</th>
		<th>操作</th>
	</tr>
	 #foreach ($u in $page.result)
	 <tr class="pointer1" >
		
		<td>$!u.name</td>
		<td>$!u.motto</td>
		<td>$!u.speciality</td>
		<td>$!u.detail</td>
		<td><a href="/icare/managerInfo/edit?id=$!{u.id}">编辑</a>
			<a href="/icare/managerInfo/delete?id=$!{u.id}">删除</a></td>
		</tr>
	#end
	
	</table>
	<div>
	 <div class="page fr">
				       	#parse("/common/page.tpl")
				      </div>
	</div>
</div>

</body>
<script type="text/javascript" src="../../assets/director/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/assets/js/country_1.js"></script>
 <script type="text/javascript" src="/assets/js/calendar.js"></script>
 <script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
 <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
<script type="text/javascript">
 $(function(){
 	$(".timedate").calendar({ format:'yyyy-MM-dd hh:mm:ss' });
 });
 
 function cutStr(len){
	    var obj=document.getElementById('spec').getElementsByTagName('td');
	    for (i=0;i<obj.length;i++){
	        obj[i].innerHTML=obj[i].innerHTML.substring(0,5)+'…';
	    }
	}
 </script>

</html>