<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
		<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
		<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
		<script src="$request.contextPath/assets/js/calendar.js"></script>
		<script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
		<script src="/assets/js/pageNavigator.js"></script>
	</head>
	
	<body>
		 #if($!{sessionUser.getCateEnum()}=="USER")
		 #parse("/common/head.tpl")
		 #end
		
		<div class="wrapper">
    	<!--<div class="body">-->
        #if($!{sessionUser.getCateEnum()}=="USER")
		 	<iframe id="userFrame"  width="20%" style="height:800px; margin-left:1%"src="/user/detail" frameborder="0" scrolling="no"></iframe>
			<div class="useractbox bodyline pad10" style="width:75%;float:right;" height=800px;>
		 #else
        	<div class="useractbox bodyline pad10">
		#end	
			<div class="searchli">
			<form action="/professional/state/query" method="post">
			<input type="hidden" name="userId" value="${userId}" />
				<ul class="inpubox clearfix">
					<li><label>日期：</label><input class="text150 timedate" type="text" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)"/> <label>至</label> <input class="text150 timedate" type="text" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)"/></li>
					<li><input class="button_add" type="submit" value="搜索"></li>
					#if($sessionUser.cateEnum.type==4)
					   <li><input class="ibtn button_add" type="button" onclick="javascripts:location.href='/professional/state/add?userId=${userId}'" value="新增"/></li>
					#end
				</ul>
			</div>
             #if($states && $states.results)
				<table class="table100 usertable cen">
					#foreach($title in $states.titles)
						<th>${title}</th>
					#end
					#foreach($_states in $page.result)
						<tr>
							#foreach($state in $_states)
								<td>$!{state}</td>
							#end
						</tr>	
					#end
				</table>	
				#if($page.result.size()>0)
					#parse("/common/page.tpl")
				#end
			#end
        	</div>
    	<!--</div>-->
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
		});
		</script>
	</body>
</html>