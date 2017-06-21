<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8" />
        <title>评估结果</title>
        <link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
        <link rel="stylesheet" href="/assets/css/shequyonghu.css" />
        <script src="/assets/js/jquery-1.8.0.min.js"></script>
        <script src="/assets/js/lhgcalendar.min.js"></script>
        <script src="/assets/js/pageNavigator.js"></script>
        
       
        <style>
            .margin{margin-left:3%}
            .a_1{padding:8px;margin:0px; text-decoration:none;}
            .a_li{padding-bottom: 0px;position: relative;top:5px;}
            .lcui_body{   left:190px;}
            table th{background-color: #48c1fa;height:25px;}
            .searchli table tr td{border-left: 1px solid #8ed7f8;height:25px;}
            
        </style>
    </head>
    <body>
    #parse("/common/masklayer.tpl")
        #if($!{sessionUser.getCateEnum()}=="USER")
             #parse("/common/head.tpl")
        #end
    <br/>
    
        <div class="wrapper">
            <div class="useractbox bodyline pad10" style="width:90%;float:right;">
                <div class="searchli">
                    <form action="/professional/vender/assess" method="post" name="searchForm">
                        #if($sessionUser.cateEnum.type == 4 || $sessionUser.cateEnum.type == 3)
                        <input type="hidden" name="userId" value="$userId" />
                        #end
                        <ul class="inpubox clearfix">
                            #if($sessionUser.cateEnum.type == 3|| $sessionUser.cateEnum.type == 4)
                         	<li><input class=" button_gm" type="button" onclick="javascripts:location.href='/professional/vender/service/assess?userId=${userId}'" value="新的评估"></li>
                            <li  class=" a_li"><a  target=”_blank” class=" a_1 button_gm" type="button" href="http://game.le-ho.cn/2015/main.html?userId=$userId&$idCo&

$commitName&$name&$sex&$age&$education" >认知能力评估</a></li>
                            <li  class=" a_li"><a  target=”_blank” class=" a_1 button_gm" type="button" href="http://game.le-ho.cn/2016?userId=$userId&sex=$sex" >认知训练

游戏</a></li>
                            <li  class=" a_li"><a  target=”_blank” class="a_1 button_gm" type="button" href="http://game.le-ho.cn/2016/questionnaire.html?userId=$userId" >

外部问卷评估</a></li>
                            <!--<li><a  target=”_blank” class="tb_edit button_gm" type="button" href="http://www.le-ho.cn:8085/game/main.html?&$idCo&$commitName&$name&

$sex&$age&$education" >$userId     游戏评估</a></li>-->
                            <li><input class="tb_edit button_gm" type="button" onclick="javascripts:location.href='/fitness/list?userId=${userId}'" value="体适能记录"></li>
                            #end
                        </ul><br>
                        <ul class="inpubox clearfix">
                            <li>
                                <label>选择日期：</label>
                                <input id="start" class="text150 timedate" type="text" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)"> <label>至</label> 

<input id="end" class="text150 timedate" type="text" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)">
                            </li>
                            <li><input class="button_add" type="submit" value="搜索"></li>
                        </ul>
                    </form><br><br><br>
                     <table  style="width:800px;">
                        <tr><th>编号</th><th>评估名称</th><th>评估结果</th><th>时间</th></tr>
                        #foreach ($record in $page.result)
                        #set($i = (($velocityCount + 1)+(${page.pageNo} - 1)*10))
                        
                        <tr class="ibtn addadver">
                            <td>$i</td>
                            <td ><a href="/professional/vender/assess/detail?recordId=${record.id}">${record.assessName}</a></td>
                            <td >#set($str=$record.conContent)
                                #if($str.length()>25)
                                   #set($str=$str.substring(0,25))
                                   $str
                                #else
                                   $str
                                #end
                            <td>$!date.format('yyyy-MM-dd',${record.createdAt})</td>
                        </tr>
                        #end
                        </table>
                    </div>
                    
                    #foreach ($record in $list)
                    <div class="pj_result_list">

                        <p class="pj_result_list_p1"><a href="/professional/vender/assess/detail?recordId=${record.id}">${record.assessName}</a></p><span 

class="pj_result_list_span">$!date.format('yyyy-MM-dd',${record.createdAt})</span>
                        <p class="pj_result_list_p2">${record.advice1}</p>
                    </div>
                    #end
                    #if($page.result.size()>0)
                        #parse("/common/page.tpl")
                    #end
                    
                    
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