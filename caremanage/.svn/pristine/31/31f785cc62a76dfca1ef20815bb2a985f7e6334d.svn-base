<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>巡诊记录</title>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/assets/js/top.js"></script>
	<script type="text/javascript" src="/assets/director/js/XZxunzhen.js"></script>
	<link href="/assets/director/style/xunzhenrecord.css" rel="stylesheet" type="text/css">
	<link href="/assets/director/style/XZxunzhen.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="/assets/director/style/print.css" media="print" />
	<style type="text/css">
		.Detail ul{ height: 470px; text-align: center;}
	 	.Detail ul li{height: 50px;line-height: 50px; }
	 	.Detail ul .lis{ height: 180px;}
	 	.commonTable tr .zcontents{max-width: 320px; min-width: 200px;}
	 	.commonTable tr .zcontent{max-width: 200px; min-width:80px;}
	 	.ul_left{position: relative;left: -54px;}
	 	.select_right{position: relative;right: -5px;}
	</style>
</head>

<body>
#parse("/common/masklayer.tpl")
  #parse("/common/dtop.tpl")
  #parse("/common/duser.tpl")
 <div class="main1">
  <div>
  <div class="contentPer">#parse("/common/dleft.tpl")</div>
    <div class="personInfo_right fl" style="float: left;">
    <div  class="Detail">
     <span class="fr close"></span>
    <form action="/rounds/record/add" method="post" onsubmit="return yz()">
    	<br>
    	<ul>
			<li class="ul_left">&nbsp;
			上门时间：<input class="shangmenInput" id="startTime" type="text" 
			name="startTimes"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
			</li>
			<li class="ul_left">&nbsp;
			离开时间：<input class="shangmenInput" id="endTime" type="text" 
			name="endTimes"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" >
				</li>
			<li class="ul_left">巡诊类型：&nbsp;<select name="type" class="shangmenInput select_right">
			  	<option value="入户巡诊">入户巡诊</option>
			  	<option value="电话巡诊">电话巡诊</option>
			  </select>
			<li class="lis">
			  <textarea rows="5" cols="40"  id="con" onBlur="fz()" placeholder="巡诊内容:"  ></textarea>
			 </li>
			<li>
			#set($user=$session.getAttribute("sessionUser"))
			<input type="hidden" name="content" id="content" />	
			<input type="hidden" name="userId" value="$dirUser.id" />
			<input type="submit" value="提交" class="shangmenInput btnBg"   >
			 <a href="#" class="btnBg btnBg1 cancel_all">取消</a>
			 </li>
		</ul>	
    </form>	
    </div>
    
      <div style="float:left;"> 
      <form action="/rounds/record/findAll" id="tijiao" method="post"  name='searchForm'>
       <label>日期:</label>
        #set($user=$session.getAttribute("sessionUser"))
        <input type="text" name="startTime" placeholder="开始时间" class="input1" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"value="$!date.format('yyyy-MM-dd HH:mm:ss',$!start)">
        <label class="zhi">至</label>
        <input type="text" name="endTime" placeholder="离开时间"class="input1" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" value="$!date.format('yyyy-MM-dd HH:mm:ss',$!end)">
        <input type="hidden" value="$!userId" id="userId" name="userId"/>      
        <select class="input1 xulie" name="esc">
          <option value="1" #if($!esc=='1') selected="selected" #end>按巡诊日期升序</option>
		  <option value="0" #if($!esc=='0') selected="selected" #end>按巡诊日期降序</option>
        </select>
        <a  onclick="submit()" class="btnBg">查询</a>
        <a  class="btnBg" id="dayin">打印</a>
        <button type="button" class="btnBg newXunzhen" id="newxunzhen">添加巡诊</button>
      </form>
      </div>
      
      <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="detail_chart_list">
        <tr>
          <th>日期</th>
          <th>巡诊类型</th>
          <th>巡诊内容</th>
          <th>到达时间</th>
          <th>离开时间</th>
          
        </tr>
        #if ($page)
        #foreach($p in $!page.result)
        <tr>
          <td class="zcontent">$!date.format('yyyy-MM-dd',$!p.createTime)</td>
          <td class="zcontent">$!{p.type}</td>
          <td class="zcontents" style="text-align: left;">
			  $!{p.content}</td>
          <td class="zcontent">$!date.format('yyyy-MM-dd hh:mm',$!p.startTime)</td>
          <td class="zcontent">$!date.format('yyyy-MM-dd hh:mm',$!p.endTime)</td>
          
        </tr>
        #end
        #end         
      </table>
      <div class="page fr">
        	#parse("/common/page.tpl")
      </div>
      
    </div>
  </div>
</div>


</body>
 <script type="text/javascript" src="/assets/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" src="/assets/js/jquery-1.8.0.min.js"></script> 
 <script type="text/javascript" src="/assets/js/jquery.jqprint-0.3.js"></script>
 <script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
 <script type="text/javascript">
   function submit(){
		 $("#tijiao").submit();
		
	}
  function yz(){
  	var start=$("#startTime").val();
  	var end=$("#endTime").val();
  	var content=$("#content").val();
  	if(start==""&&end==""&&content==""){
  		alert("请输入巡诊信息!");
  		return false;
  	}else{
  		if(start==""||start==null){
	  		alert("开试时间为空!");
	  		return false;
  		}
	  	if(end==""||end==null){
	  		alert("结束时间为空!");
	  		return false;
	  	}
	  	if(content==""||content==null){
	  		alert("会诊内容为空!");
	  		return false;
	  	}  	
  	}
  }
  function fz(){
  	var con=$("#con").val();
  	$("#content").val(con);
  }
  function del(){
   var r=confirm("确定要删除吗？");
	  if (r==true){
  		var pid=$("#pid").val();
  		location.href="/rounds/record/del?id="+pid;
	   }  	
  }
  
  	$(function(){
		$(".personInfo .personInfo_left .sidebar li a").eq(1).css("background-color","#22cde7").css("text-decoration","none").css("color","#fff");
  		$(".cancel_all").click(function(){
  			$(".Detail").hide();
  		});
  		$(".xulie").change(function(){
  			var userId=$("#userId").val();
  			var esc=$(this).val();
  			location.href = '/rounds/record/findAll?userId='+userId+'&esc='+esc;
  		});
  	
  		$(".display").hide();
  		$("#category").change(function(){
  		var parentId = $(this).val();
  		var h="";
  			$.ajax({
  				url:'/admin/getCategory/'+parentId,
  				type: "post",
  				success:function(data){
  					var category = eval('('+data+')');
	  					$.each(category,function(id,json){
  							h+="<li class='category' data-id="+json[0].id+" >"+json[0].name+"</li>";
  					});
  					console.info(h);
  					$("#www_zzjs_ne").empty();
  					$("#www_zzjs_ne").append(h);
  				}
  			});
  		});
  		$(".category").click(function(){
  			alert($(this).text());
  		});
  		
	  	$("#dayin").click(function(){
	  		$("#detail_chart_list").jqprint(); 
	    });	
	  	//获取是否显示标示
	  	var full_top;
	  	$(document).on('click','.pointer1',function() {
	  		if(full_top!=null){//判断是否是初次点击
	  			full_top.hide();
	  		}
	  		$(this).parent().parent().next().show();
	  		full_top=$(this).parent().parent().next();
	  		
	  	});
  	});
  
</script>
<!-- <script type="text/javascript">
	

var maxNum = 100, Len=0, Nums=document.getElementById("num");
var li = document.getElementById('www_zzjs_ne').getElementsByTagName('li');
 var code ="";
for(var i=li.length; i--; ){
  li[i].id = i;
  li[i].onclick = add;
}
$(document).on('click','.category',function() {
  code+= $(this).text() + ","; 
  var h = "<li>"+$(this).text()+"</li>";
  $("#rightul").append(h);
   console.info(code);
   $("#code").val(code);
 
	console.info($(this).attr("data-id"));
});
function add(id,name){
   code+= id + ","; 
  var h = "<li>"+id+name+"</li>";
  $("#rightul").append(h);
   console.info(code);
   $("#code").val(code);
}
function remove(){
  $("#_zzjs_net").innerHTML = "你最多可以选择五个！";
  var title = this.getAttribute("title");
  document.getElementById(title).style.display = "block";
  Nums.innerHTML = --Len;
  this.parentNode.removeChild(this);
};
</script>  -->
</html>
