<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>志愿者,列表</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/newCss/ser_rec.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/common.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="/assets/newCss/index.css" />

</head>

<body>
    <div class="wrapper">
            #parse("/common/head.tpl")
            #if($!{sessionUser.isSuper_()}==true)
                <div class="main">
                #parse("/common/providers.tpl")
                <div id="right">
            #else
                <div class="courseMain">
                <div class="course">
        #end
            <label class="title_2 title_main">
            <a class="a_first" href="/nVolunteerAssess/palvelutietue">服务记录</a>
            </label><label class="title_2">|</label>
            <label class="title_2">
            <a class="a_first" href="/professional/volunteer/see_train">培训记录列表</a></label>
            <label class="title_2">|</label>
            <label class="title_2"><a class="a_first" href="/professional/volunteer/index">志愿者服务列表</a>
            </label>
           
            <form action="/nVolunteerAssess/palvelutietue" method="post" name="ser_rec" style="margin-top:-50px">
                    <label>按站点名称查询：</label>
                    <select name="siteId" id="name" class="select1" style="height: 25px;">
                        <option value="0">请选择</option>
                        #foreach($s in $sites)
                        <option value="$s.id" #if($siteId==$s.id) selected="selected" #end>$s.siteName</option>
                        #end
                    </select>
                
                    <label>按活动日期选择：</label>
                    <input type="text" name="data" class="timedate " style="height: 25px;" value="$!data"/>
                 
                    <label>按活动名称搜索：</label>
                    <input type="text" name="name" class="input2" style="height: 25px;" value="$!name"/>
                
                    <input type="submit" class="button_search" value="查询"/>
                
                    <input type="button" class="button_add"  value="新增服务记录"/>
                
            </ul>
            </form>
        <div id="hide">
        <br>
        <br>
        
            <ul class="site">
                <li class="close">
                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                </li>
                <li>
                    <label>请选择站点：</label>
                    <select name="site" id="site_" class="select2" style="height: 25px;">
                        <option value="0">请选择</option>
                        #foreach($s in $sites)
                        <option value="$s.id">$s.siteName</option>
                        #end
                    </select>
                </li>
                <li>
                    <label>按日期选择：</label>
                    <input type="text" id="date1" class="timedate" style="height: 25px;"/>
                </li>
                <li>
                    <input type="button" class="button_next"  value="下一步"/>
                </li>

            </ul>
            </div>
            <table class="table_tale1" style="margin-top: 10px;">
                <tbody>
                <tr class="_active">
                    <th class="col-lg-1">序号</th>
                    <th class="col-lg-2">活动名称</th>
                    <th class="col-lg-2">站点名称</th>
                    <th class="col-lg-2">活动日期</th>
                    <th class="col-lg-1">记录来源</th>
                    <th class="col-lg-1">操作</th>
                </tr>
                #foreach($nassess in $page.result)
                #set($num=$velocityCount)
                    #set($num=$num+1)
                    <tr class="#if($velocityCount%2==0)tr_two #else tr_first #end" data-id="85">
                        <td> $num</td>
                        <td> $nassess[3]</td>
                        <td>$nassess[4]</td>
                        <td> $!date.format('yyyy-MM-dd',$nassess[5])</td>
                        <td>$nassess[2]</td>
                        <td data-list="85">
                            <a href="/nVolunteerAssess/selectById?id=$nassess[0]&activity=$nassess[3]&date=$!date.format('yyyy-MM-dd',$nassess[5])">查看</a>
                        <a href="/nVolunteerAssess/ToUpdate?id=$nassess[0]">编辑</a>
                        </td>
                    </tr>
                #end
                </tbody>
            </table>
            #parse("/common/page.tpl")
    </div>
    </div>
    </div>
</div>
</body>
<script src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
 <script>

    $(".button_add").click(function() {
        var hide = $("#hide");
        hide.show();
    });
    $(".glyphicon-remove").click(function(){
        var hide = $("#hide");
        hide.hide();
    })
    $(function(){
     $(".timedate").calendar({ format:'yyyy-MM-dd' });
    });
    $('.button_next').click(function(){
          if($('#site_').val()==0||$('#date1').val()==""){
            alert("请选择站点或者时间");
            return false;
          }
          $.ajax({ 
            url: "/nVolunteerAssess/toChecksum?date="+$('#date1').val()+"&siteId="+$('#site_').val(),
            type: "get",
            success: function (json) {
                if(json==-1){
                    alert("当前活动已经填写量表！");
                }else if(json==0){
                    alert("当天此站点没有活动！");
                }else{
                    location.href="/nVolunteerAssess/toAdd?planId="+json;
                }
                }    
            });
    
    });
$(window).on('load', function() {
    $('btn-default1').remove();
    $('.btn-default2').remove();
    $('.btn-primary1').remove();
});
</script>
</html>