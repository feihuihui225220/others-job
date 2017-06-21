<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <link rel="stylesheet" href="/assets/newCss/wucha.css"/>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/common.css"/>
    <link rel="stylesheet" href="/assets/css/reg.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
	<script src="/assets/js/pageNavigator.js"></script>
     <style>
         .bodyposition{ margin-right:10%;margin-left:10%;}
         .tablediv{width: 70%;float:left;margin-left:5%;}
         .searchli{float:left;margin-left:5%;}
          .nav-pills>li.active>a, 
         .nav-pills>li.active>a:hover, 
         .nav-pills>li.active>a:focus{background-color:#4CEDF7 !important;}
         #rightIframe{border:0px;width:82%;height:600px;float:right;}
          body{background:#D9EBEB}
	</style>
</head>
<body>
<div class="">
    #parse("/common/head.tpl")
	   
	    <input  type="hidden"  id="voluntary" value="$!voluntarycount">
	    <input type="hidden"  id="default" value="$!count">
	    <input type="hidden"  id="pubdate" name="pubdate" value="$!date.format('yyyy-MM-dd',$!activity.pubdate)"/>
    <div class="bodyposition">
    	<div id="mainDiv">
		    <iframe id="rightIframe" src="/professional/activity/tiaozhuan?id=$!activity.id"  class="rightIframe"></iframe><br/>
		    <input type="hidden" id="activityId"  value="$!activity.id"/>
	    </div>
	   
    	<div>
		    <ul id="nav" class="nav nav-pills nav-stacked" style="float:left;width:15%;background:#12D4E0 ">
		        <li id="activity_plan" class="active"><a>活动计划</a></li>
		        <li id="activity_aged"><a>老人签到</a></li>
		        <li id="activity_voluntary"><a>志愿者签到</a></li>
		        <li id="activity_serve"><a>服务记录</a></li>
		        <li id="activity_album"><a>相册</a></li>
		    </ul>
	    </div>
     </div>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>

<script>
    $(function(){
			var id=$('#activityId').val();
			var pubdate=$('#pubdate').val();
    		$('#activity_plan').click(function(){
				$('#rightIframe').attr("src","/professional/activity/tiaozhuan?id="+id);
    		});
    		//判断
    		$('#activity_album').click(function(){
    			$('#rightIframe').attr("src","/professional/activity/activity_album?activityId="+id+" &pubdate="+pubdate);
    		});
			$('#activity_aged').click(function(){
				if($('#default').val()!=0){
					$('#rightIframe').attr("src","/professional/activity/activity_yiqian?id="+id+" &pubdate="+pubdate);
				}else{
				var idscount=0;
					$('#rightIframe').attr("src","/professional/activity/activity_aged?id="+id+" &communityId="+idscount);
				}
			});
    		
    		$('#activity_voluntary').click(function(){
    			if($('#voluntary').val()!=0){
    				$('#rightIframe').attr("src","/professional/activity/activityVoluntaryTwo?id="+id+" &pubdate="+pubdate);
    			}else{
					$('#rightIframe').attr("src","/professional/activity/activity_voluntary?id="+id+" &pubdate="+pubdate);
    			}
    		});
    		$('#activity_serve').click(function(){
				$('#rightIframe').attr("src","/professional/activity/activity_serve?id="+id+" &pubdate="+pubdate);
    		});
            $("#nav").children().click(function(){
                $(this).parent().children().attr("class","");
                $(this).attr("class","active");
            })
            
           $("#checkall").click(function(){ 
				if(this.checked){ 
					$("input[name='code']").each(function(){this.checked=true;}); 
				}else{ 
					$("input[name='code']").each(function(){this.checked=false;}); 
					} 
			   });
    });

</script>
</body>
</html>