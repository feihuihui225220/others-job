<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Care Manager_服务商管理_详情页面</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/calendar.js"></script>
<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script src="$request.contextPath/assets/js/assets/js/common.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
#if($!{sessionUser.getCateEnum()}!="STREET")
<script>
	function addEva(){
		window.open('/professional/vender/tab/eva/add?venderId=' + ${venderId}, '_self');
	}
</script>
#end
<style>
	
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    <div class="body">
        <div class="useractbox bodyline pad10">
            <div class="actboxlist">
				<div class="actbox2">
                    <div class="searchli">
                    <form name="evaForm" action="/professional/vender/tab/eva/query" method="post" name="searchForm">
                    	<input type="hidden" name="venderId" value="${venderId}" />
                    	
						<ul class="inpubox clearfix">
							<li><label>日期：</label><input class="text150 timedate" type="text" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)"> 至 <input class="text150 timedate" type="text" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)"></li>
							<li><input class="ibtn button_gm" id="sbtn" type="button" value="搜索"></li>
					 </form>
					 		#if($!{sessionUser.getCateEnum()}!="STREET")
							<li class="rightbtn pad10" style="float:right;"><button type="button" class="button_gm addEvidence" onclick="addEva()">添加评价</button></li>
							#end
						</ul>
					</div>
					<div class="pj_result">
						#foreach($eva in $page.result)
						<div class="pj_result_list divclick">
							<p class="pj_result_list_p1">$!date.format('yyyy-MM-dd',$!eva.startTime) -- $!date.format('yyyy-MM-dd',$!eva.endTime)</p>
							<p class="pj_result_list_p2">${eva.evaluation}</p>
							<input type="hidden" value="/professional/vender/tab/eva/${eva.venderId}/${eva.id}"/>
						</div>
						#end
						#if($page.result.size()>0)
							#parse("/common/page.tpl")
						#end
					</div>
                </div>    
            </div>
        </div>
    </div>
    <div class="footer"></div>
</div>
		<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
		<script type="text/javascript">
		$(function(){
		    $(".clourstitle li").click(function(){
		        var index = $(this).attr('index');
		        if (index != 1) {
		            $('#__calendarPanel').css('display', 'none');
		            $('#__calendarPanel').css('display', 'none');
		            //$(window.frames["__calendarIframe"].document).find('form').css('display', 'none');
		        } else {
		            $('#__calendarIframe').css('display', 'block');
		            $('#__calendarPanel').css('display', 'block');
		        }
		        $(this).addClass('on').siblings().removeClass('on');
		        $(".actboxlist .actbox"+index).show().siblings().hide();
		    });
		
		    $(".timedate").calendar({ format:'yyyy-MM-dd' });
		
		    $('.actbox1 input').trigger('click');
		
		    $(window.frames["__calendarIframe"].document).find('td').on('click', function () {
		        //alert($('.actbox1 input').val())
		    });
		    
		    $("#sbtn").click(function(){
				var b = $("input[name='start']").attr("value");
				var e = $("input[name='end']").attr("value");
				if(b == '' || e == ''){
					alert("请选择时间范围!");
					return false;
				}else if(b > e) {
					alert("开始时间不能大于结束结束时间!");
					return false;
				}
				$("form[name='evaForm']").submit();
		    });
		    
		    $(".pj_result>div").click(function(){
				location.href = $(this).find("input").attr("value");
		    });
		    //$(window).unload(function(){
		    	//window.parent.location.reload();
		    //});

		});
		</script>
</body>
</html>