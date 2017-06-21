<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>服务</title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/bootstrap.min.css" />
<style>
/* .list_my {padding:20px 0 0 20px;/*width:1086px;*/overflow:hidden;margin:0 10px;}
.list_my li {float:left;width:320px;margin-right:30px;border:1px solid #ddd;padding:10px 0 0 10px;margin-bottom:20px;}
.list_my li h4 {background:#f2f2f2;border-bottom:1px solid #ddd;font-size:14px;height:26px;line-height:26px;margin-bottom:10px;padding-left:6px;width:304px;color:#299DCA;}
.list_my li a {color:#333;display:block;}
.list_my li a:hover {text-decoration:none;}
.list_my li div {float:left;width:90px;margin-right:5px;margin-bottom:10px;text-align:center;background:#f2f2f2;padding:5px;}
.list_my li div h5 {border-bottom:1px solid #ddd;text-align:left;margin:0;padding-bottom:3px;color:green;margin-bottom:3px;padding-left:5px;} */
.inpubox{padding:0;}
.searchli {border-bottom:1px solid #000;margin:0 0 20px 0;}
.rightbtn button{line-height:16px\0;}
.popover{color:#000000;}
.nopadding{padding: 0}
.progress-bar-default{background-color: #f5f5f5;height: 21px;}
.progress-bar{overflow: visible;}
</style>
</head>
<body>

#set($actparam = {'cg':{'label':'翻身','color':'#CCCCFF'},
									'back':{'label':'回床','color':'#00AA00'},
									'out':{'label':'离床','color':'#AA0000'},
									'sit':{'label':'做起','color':'#FF0000'},
									'side':{'label':'坐于床沿','color':'#008888'},
									'bed':{'label':'其他','color':'#9900FF'}
									})
<div class="wrapper">
		#if($sessionUser.cateEnum.type == 1)
    	#parse("/common/head.tpl")
    #end
   
    <div class="container-fluid">
    		 #if($sessionUser.cateEnum.type == 1||$sessionUser.cateEnum.type == 3)
        <div class="searchli">
            <ul class="inpubox clearfix">
                <li class="rightbtn pad10" style="float:right;"><button class="button_delete addEvidence" onclick="javascripts:location.href='#if($sessionUser.cateEnum.type == 1) /professional/service/myservices #else /professional/service/list?userId=$!userId #end'">返回</button></li>
            </ul>
            
        </div>
        #end
        	<div class="row" style="margin:20px 0 20px 0;">
        		<div class="col-sm-6 col-sm-offset-2">
	        		#foreach($item in $actparam.keySet())
	        			$actparam.get($item).get('label')&nbsp;<span style="color:$actparam.get($item).get('color');">●</span>
	        		#end
        		</div>
        	</div>
        	#foreach($data in $datas)
            <div class="row">
            	<div class="col-sm-1 col-sm-offset-1" title="$!date.format('yyyy-MM-dd',$data.date)">$!date.format('E',$data.date)</div>
            	<div class="col-sm-9">
            		<div class="progress">
            			#set($lastpercent = 0.0 )
            			#set($lastact = 'xx' )
            			#foreach($item in $data.data.values)
            			#set($currentpercent = $item[2] * 100)
            			#set($percent = $currentpercent - $lastpercent)
            			#set($lastpercent = $currentpercent)
                 		<div class="progress-bar #if($lastact=='out'||$foreach.index==0) progress-bar-default #else progress-bar-info #end" role="progressbar" aria-valuemax="100" aria-valuemin="0" style="width:$percent%">
                 			<span class="title" style="float: right;position:relative; margin-right:-5px;font-size: 16px;cursor:default;color:$actparam.get($item[1]).get('color');" data-content="$!date.format('HH:mm:ss',$item[0])" data-original-title="$actparam.get($item[1]).get('label')">●</span>
                 		</div> 
                 	#set($lastact = $item[1] )
                  #end
                  #set($leftpercent = 100 - $lastpercent)
                  <div class="progress-bar progress-bar-default" role="progressbar" aria-valuemax="100" aria-valuemin="0" style="width:$leftpercent%">
                			
               		</div> 
                </div>
            	</div>
            </div>
          #end
          	
          		
          		<div class="row">
          			<div class="col-sm-9 col-sm-offset-2">
          					<div class="col-sm-1 nopadding">
          					0:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					2:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					4:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					6:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					8:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					10:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					12:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					14:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					16:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					18:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					20:00
          					</div>
          					<div class="col-sm-1 nopadding">
          					22:00
          					</div>
          			</div>
          	</div>
          	<div class="row">
          		<div class="col-sm-3 col-sm-offset-2">
         				<ol class="breadcrumb" style="background-color: transparent;margin-top: 20px;">
                  <li><a>$!date.format('yyyy-MM-dd',$!datecond.start)</a></li>
                  <li><a>$!date.format('yyyy-MM-dd',$!datecond.end)</a></li>
                </ol>
         			</div>	
          		<div class="col-sm-6">	
          			<ul class="pager pull-right">
		           		<li><a href="/professional/service/diverseShow?userId=$!userId&serviceId=$!serviceId&stype=$!stype&start=$!date.format('yyyy-MM-dd',$!preweek.start)&end=$!date.format('yyyy-MM-dd',$!preweek.end)">&larr;上周</a></li>
		              <li><a href="/professional/service/diverseShow?userId=$!userId&serviceId=$!serviceId&stype=$!stype&start=$!date.format('yyyy-MM-dd',$!nextweek.start)&end=$!date.format('yyyy-MM-dd',$!nextweek.end)">下周&rarr;</a></li>
		            </ul>
          		</div>
          	</div>
    </div>
    
    <div class="footer"></div>
</div>
</body>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="$request.contextPath/assets/js/bootstrap.min.js"></script>
<script>
$(function(){
	$('.title').popover({placement:'auto',trigger:'hover',delay:{show:100,hide:100}});
});
</script>
</html>