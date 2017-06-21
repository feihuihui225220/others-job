<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>申请服务</title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
</head>
<body>

<div class="wrapper">
    #if($sessionUser.cateEnum.type==1)
       #parse("/common/head.tpl")
    #end
    <div class="useractbox bodyline pad10">
    <style>
    .dc_ul {overflow:hidden;height:auto;}
    .dc_list {margin-bottom:20px;}
    .actbox1 {height:auto;}
    </style>
        <ul class="clourstitle strong mgb10">
           #if($sessionUser.cateEnum.type==1)
	            <li index="1" class="rel on">推荐服务</li>
	            <li index="2" class="rel">全部服务</li>
	       #end
        </ul>
        <div class="actboxlist">
            <div class="actbox1">
                <div class="usedetail clearfix">
                    <div class="ggtext">
                        <ul class="dc_ul">
                            #if($services)
	                            #foreach($service in $services)
	                                <li class="dc_list" data-con="${service.content}" data-list="${service.standard}"><a href="#" ><img src="${service.picture}" onerror="this.src='/assets/css/img/people.png'" alt="未上传图片" class="dc_img" >${service.name}</a></li>
	                            #end
                            #end
                        </ul>
                    </div>
                </div>
            </div>
            <div class="actbox2 hide">
                <div class="usedetail clearfix">
                    <div class="ggtext">
                        <ul class="dc_ul">
                            #if($services)
                              #foreach($service in $services)
                                  <li class="dc_list" data-con="${service.content}" data-list="${service.standard}"><a href="#"><img src="${service.picture}" onerror="this.src='/assets/css/img/people.png'" alt="未上传图片" class="dc_img" >${service.name}</a></li>
                              #end
                            #end
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="footer"></div>
</div>

<div class="pop_show hide">
<style>
.pop_show {padding:20px;}
.pop_show h4 {margin-bottom:10px;}
.pop_show p {text-indent:2em;padding-bottom:15px;margin-bottom:15px;border-bottom:1px solid #ddd;}
.pop_show li {margin-bottom:10px;text-indent:2em;}

</style>
    <h4>服务内容：</h4>
    <p>一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十</p>
    <h4>质量标准：</h4>
    <ul>
        <li>一二三四五六七八九十</li>
        <li>一二三四五六七八九十</li>
        <li>一二三四五六七八九十</li>
        <li>一二三四五六七八九十</li>
    </ul>
</div>
<script type="text/javascript" src="js/layer.min.js"></script>
<script>

    $(".clourstitle li").click(function(){
        var index = $(this).attr('index');
        if (index != 1) {
            $('#__calendarPanel').css('display', 'none');
            $('#__calendarPanel').css('display', 'none');
            //$(window.frames["__calendarIframe"].document).find('form').css('display', 'none');
        } else {
            $('#__calendarIframe').css('display', 'block');
            $('#__calendarPanel').css('display', 'block');
            //$(window.frames["__calendarIframe"].document).find('form').css('display', 'block');
        }
        $(this).addClass('on').siblings().removeClass('on');
        $(".actboxlist .actbox"+index).show().siblings().hide();
    });

    $('.dc_list').on('click', function(){
        var _this = $(this);
        $('.pop_show p').html($(this).attr('data-con'));
        var arr = $(this).attr('data-list').split(';')
        $('.pop_show p').html($(this).attr('data-con'));
        $('.pop_show ul').html('');
        for (var i=0; i<arr.length; i++) {
            $('.pop_show ul').append('<li>'+arr[i]+'</li>')
        }
        $.layer({
            type : 1,
            title : $(_this).text(),
            offset:['150px' , ''],
            border : true,
            shadeClose:true,
            fadeIn: 300,
            btns: 0,
            btn: ['保存', '取消'],
            yes:function(index){
                console.log("保存",index);
                layer.close(index);
            },
            area : ['420px','auto'],
            page : {dom : '.pop_show'}
        });
    });

</script>
</body>
</html>