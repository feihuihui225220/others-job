<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>首页banner</title>
#parse("/common/top.tpl")
<link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;">
<form action="/icare/banner/add" method="post" enctype="multipart/form-data" >          	
            <div class="actboxlist">
                
                <div class="actbox8 ">
                
                    <table class="table100 usertable" >
                        <tr>
                        	<td>图片名称：<input type="text" name="name" /></td>
                        </tr>
                         <tr>
                        	<td>图片链接：<input type="text" name="linkUrl" ></td>
                        </tr>
                        <tr>
                        	<td>上传图片：<input type="file" name="pic" style="border: 1px solid #CCC;" /><br/>
                     
                        	</td>
                        </tr>
                    </table>
                    <input type="submit" value="添加" class="btnBg"/>
                </div>
            </div>
            </form>
<table class="commonTable" style="width: 1000px;">
	<tr>
		
		<th>图片名称</th>
		<th>图片链接</th>
		<th>操作</th>
	</tr>
	
	 #foreach ($u in $list)
	 <tr class="pointer1" >
		
		<td>$!u.name</td>
		<td>$!u.linkUrl</td>
		<td><a href="/icare/banner/edit?id=$!{u.id}">编辑</a>
			<a href="/icare/banner/delete?id=$!{u.id}">删除</a></td>
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
 	$('.pointer1').click(function(){
		location.href=$(this).attr('date-href');
	});
 });
 </script>
 <script>
 $(".edit").click(function(){
     alert("3333");
     return false;
 });

 
 </script>
</html>