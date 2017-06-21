<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>服务课程</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>

</style>
</head>
<body>
	
	<div class="wrapper">
		#parse("/common/head.tpl")
		#set($page = $page)
		<div id="see_program"  class="progaram_div">
			<br/>
			<button id="add_add" class="ibtn button_add" >添加</button>
			<table class="table table-bordered usertable trclick" > 
				<tr>
					<th>序号</th>			
					<th>节目名称</th>			
					<th>描述</th>			
					<th>添加时间</th>			
					<th>操作</th>			
				</tr>
			#set ($i=1)
			#foreach($npro in $page.result)
				<tr>
					<td class="examine" date-value="$!npro.fileUrl">$i</td>
					<td class="examine">$!npro.programName</td>
					<td class="examine" date-value="$!npro.descript">
						<div title="$!npro.programDesc" style="display:block; width:150px; word-break:keep-all;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">
						 $!npro.programDesc</div>
					</td>
					<td class="examine">$!date.format('yyyy-MM-dd HH:mm',$!npro.createdAt)</td>
					<td><button class="updata button_gm" name=$npro.id>编辑</button><button class="delete button_delete" name=$npro.id>删除</button></td>
					
				</tr>
			#set($i=$i+1)	
			#end
				<tr>
					<td colspan="5">
						<form action="/professional/fete" method="post" name="searchForm"></from>
						#parse("/common/page.tpl")
					</td>
				</tr>
			</table>
			
		</div>
		<div class="progaram_div_see progaram_div">
			<br/>
			<button class="ibtn button_delete" >返回</button>
			<table>
				<tr>
					<td>节目名称</td>
					<td id="name">hello节目</td>
				</tr>
				<tr>
					<td>添加时间 </td>
					<td id="time">hello时间</td>
				</tr>
				<tr>
					<td>节目描述</td>
					<td id="desc" style="width:800px;">hello内容</td>
				</tr>
			</table>
				<div>
				<div style="float:left;">
				<object type="application/x-shockwave-flash" data="/tools/vcastr3.swf" width="850" height="500" id="vcastr3">
					<param name="movie" value="/tools/vcastr3.swf" />
					<param name="allowFullScreen" value="true" />
					<param name="FlashVars" id="FlashVars"/>
				</object>
					<br/>
					<br/>
					<br/>
					<br/>
					<br/>
				
				
				</div>
				<div>
					<h3>注意事项</h3>
					<br/>
					<p class="notice"></p>
				</div>
				</div>
			
		</div>	
	</div>
	</div>
	
	<script type="text/javascript">
		$(function(){
			$('.progaram_div_see').hide();
			$('.examine').click(function(){
				var name=$(this).parent().find("td:eq(1)").text();
				var desc=$(this).parent().find("td:eq(2)").find('div').text();
				var descript=$(this).parent().find("td:eq(2)").attr("date-value");
								var time=$(this).parent().find("td:eq(3)").text();
				var src_url=$(this).parent().find("td:eq(0)").attr("date-value");
				$('.notice').html("&nbsp;&nbsp;&nbsp;&nbsp;"+descript);
				$('#time').text(time);
				$('#desc').text(desc);
				$('#name').text(name);
				$('#FlashVars').val("xml=  <vcastr> <channel> <item> <source>$request.contextPath"+src_url+"</source>  </item> </channel>  </vcastr>");
				$('.progaram_div_see').show();
				$('#see_program').hide();
			});
			$('#add_add').click(function(){
				location.href="/professional/fete/add_d";
			});
		});
		//添加
		$(function(){
			$('#verify').click(function(){
			 var val1=$('#u31_input').val().replace(/\s+/g,"");
			 var val2=$('#u34_input').val().replace(/\s+/g,"");
			 if(val1!=""&&val2!=""){
				$('#from1').submit();								 
			}else{
				alert("请填写");
				return false;
			}
			});
		});
		//-----------------------------------------修改/删除--------------------
		$(function(){
			$('.delete').live('click',function(){
				var gnl=confirm("你真的打算删除吗?");
				if (gnl==true){
					var value = $(this).attr("name"); 
					location.href="/professional/fete/delete?id="+value;
				}else{
					return  false;
				}
				
			});
			$('.updata').live('click',function(){
				var value = $(this).attr("name");
				location.href="/professional/fete/updata?id="+value;
			});
		});
	</script>
</body>
</html>