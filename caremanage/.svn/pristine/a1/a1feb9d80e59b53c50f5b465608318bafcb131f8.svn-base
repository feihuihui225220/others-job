<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>培训记录添加</title>
    #parse("/common/top.tpl")
    <script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/newCss/index.css" />
     <link rel="stylesheet" href="/assets/newCss/wenjuan.css"/>
    <style>
        a{color:black;}
        ._div{margin-left:30px;}   
    </style>
</head>
<style>
</style>
<body>
<div class="wrapper">
        #parse("/common/head.tpl")
        <div class="main">
            #parse("/common/providers.tpl")
            <div id="right" > 
                <div  id="text">
                    $nVolunteerAssess.detail
                </div>
                 <input type="button" name="back" class="fanhui button_fh" onclick="javascript:history.back(-1);" value="返回"/>
                <input type="button" class="tijiao button_tj" value="提交"/>
                <form action="/nVolunteerAssess/update" id="from_1" method="post">
                    <input type="hidden" id="detail" name="detail">
                    <input type="hidden"   name="id" value="$nVolunteerAssess.id">
                </form>
                <br/>
                <br/>
                <br/>
                <p class="title">下次活动时间：<br/> $!date.format('yyyy-MM-dd',$nextNActivityPlan.pubdate)</p>
                <br/>
                <p class="title">下次活动内容：<br/>$!nextNActivityPlan.planDesc</p>
            </div> 
             
        </div>  
</div> 
</body>
<script>
    $('.tijiao').click(function(){
        $('input[type="radio"]').each(function(){
            if($(this).prop('checked')){
                $(this).attr("checked","true");
            }else{
                $(this).removeAttr("checked");
            }
        });
        $('.form-control').text($('.form-control').val());
        $('#detail').val($('#text').html());
        $('#from_1').submit();
    });

</script>

</html>