<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8" />
        <title>评估结果</title>
        <link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
        <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
        <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
        <script src="$request.contextPath/assets/js/calendar.js"></script>
        <script src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
        <script src="/assets/js/pageNavigator.js"></script>
        <style>
        	.margin{margin-left:3%}
        </style>
    </head>
    <body>
    #parse("/common/masklayer.tpl")
		#if($!{sessionUser.getCateEnum()}=="USER")
			 #parse("/common/head.tpl")
		#end
	<br/>
	
        <div class="wrapper">
         #if($!{sessionUser.getCateEnum()}=="USER")
		 	<iframe id="userFrame"  width="20%" style="height:800px; margin-left:1%"src="/user/detail" frameborder="0" scrolling="no"></iframe>
            <div class="useractbox bodyline pad10" style="width:77%;float:right;">
		 #else
            <div class="useractbox bodyline pad10 margin" >
		 #end
                <div class="searchli">
                    <form action="/professional/vender/assess" method="post" name="searchForm">
	                    #if($sessionUser.cateEnum.type == 4 || $sessionUser.cateEnum.type == 3)
	                    <input type="hidden" name="userId" value="$userId" />
	                    #end
	                    <ul class="inpubox clearfix">
	                        <li>
	                            <label>选择日期：</label>
	                            <input id="start" class="text150 timedate" type="text" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)"> <label>至</label> <input id="end" class="text150 timedate" type="text" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)">
	                        </li>
	                        <li><input class="button_add" type="submit" value="搜索"></li>
	                        #if($sessionUser.cateEnum.type == 3|| $sessionUser.cateEnum.type == 4)
	                        <li><input class="tb_edit button_gm" type="button" onclick="javascripts:location.href='/professional/vender/service/assess?userId=${userId}'" value="新的评估"></li>
	                        <li><a  target=”_blank” class="tb_edit button_gm" type="button" href="http://game.le-ho.cn:8080/game/2015/index.html" >游戏评估</a></li>
	                        <li><input class="tb_edit button_gm" type="button" onclick="javascripts:location.href='/fitness/list?userId=${userId}'" value="体适能记录"></li>
	                        #end
	                        	               
	                    </ul>
                    </form>
                </div>
                <div class="pj_result">
                    
                    <div class="pj_result_list">
                        <table class="table100 usertable cen trclick">
                        <tr><th>编号</th><th>评估名称</th><th>评估结果</th><th>时间</th></tr>
                        #foreach ($record in $page.result)
                        #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
                        
                        <tr class="ibtn addadver">
		        			<td>$i</td>
		        			<td ><a href="/professional/vender/assess/detail?recordId=${record.id}">${record.assessName}</a></td>
		        			<td style="display: block;width: 524px;word-break: keep-all;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">
		        			${record.conContent}</td>
		        			<td>$!date.format('yyyy-MM-dd',${record.createdAt})</td>
		        		</tr>
                        #end
                        </table>
                    </div>
                    
                    #foreach ($record in $list)
                    <div class="pj_result_list">

                        <p class="pj_result_list_p1"><a href="/professional/vender/assess/detail?recordId=${record.id}">${record.assessName}</a></p><span class="pj_result_list_span">$!date.format('yyyy-MM-dd',${record.createdAt})</span>
                        <p class="pj_result_list_p2">${record.advice1}</p>
                    </div>
                    #end
                    #if($page.result.size()>0)
						#parse("/common/page.tpl")
					#end
                </div>                                                          
            </div>
            <div class="footer"></div>
        </div>
        <script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
        <script type="text/javascript">
            $(function () {
                $('.ibtn').click(function () {
                    var x = parent.document.getElementById('userFrame');
                    var start = document.getElementById('start').value;
                    var end = document.getElementById('end').value;
                    var userid  = $('#userFrame',window.parent.document).attr('userid');
                    x.src = "/professional/vender/assess?userId="+ userid +"&start=" + start + "&end=" + end;
                });

                $(".timedate").calendar({format: 'yyyy-MM-dd'});

                $('.actbox1 input').trigger('click');

                $(window.frames["__calendarIframe"].document).find('td').on('click', function () {
                    //alert($('.actbox1 input').val());
                });
            });
        </script>
    </body>
</html>