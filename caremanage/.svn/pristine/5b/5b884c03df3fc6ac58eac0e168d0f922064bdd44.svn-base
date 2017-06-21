<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>用户管理</title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<style>
/*.fix_body .f_l{width:35%;}
.fix_body .f_r{width:63%;}*/
#tree_show{padding:10px;}
#tree{padding:20px;}
#tree li{padding-left:1em;}
#tree ul.treeul>li{padding-left:0;}
#tb_pop{position:static;width:auto;left:auto;top:auto;border:none;}
</style>
</head>
<body>

<div class="wrapper">
     #parse("/common/head.tpl")
   <div class="body fix_body">
        <div class="f_l">
            <div id="tree">
                <h2>全国</h2>
                <ul class="treeul"></ul>
            </div>
        </div>
        <div class="f_r">
            <div id="tree_show">
                <div class="btn_box"><button class="btn add button_gm" type="button" area-id="0">添 加</button></div>
                <table class="tb table_col3">
                    <col class="col1"/><col class="col2"/><col class="col3"/>
                    <tr><th width="60">序号</th><th>名称</th><th width="200">操作</th></tr>
                </table>
            </div>
        </div>
    </div>
    <div class="footer">
        
    </div>
</div>
<div class="layerbox"></div>
<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
<script>
$(function(){
    //左侧高度
    var scrollHeigth = $(window).height()-$('.header').height()-20;
    $('.f_l').css('height', scrollHeigth);
    $('.f_r').css('height', scrollHeigth);
    //首先渲染左侧树
    $.ajax({
        url     :   '/community/getCountrys/0',
        dataType:   'jsonp',
        jsonp   :   'callback',
        success :   function (json) {
                       var arr = [];
                       //debugger
                       if (json.code == 0) {
                           $('#tree>ul').html('');
                           for (var i=0; i<json.data.length; i++) {
                               (function (index) {
                                    $.ajax({
                                        url     :   '/community/getCountrys/'+json.data[index].id,
                                        dataType:   'jsonp',
                                        jsonp   :   'callback',
                                        success :   function (jsonIn) {
                                            //console.log(jsonIn);
                                            //$('#tree>ul').append('<li data-id='+json.data[index].id+'><s></s><span>'+json.data[index].name+'</span></li>');
                                            if(jsonIn.data.length==0){
                                                arr.push('<li data-id='+json.data[index].id+'><span class="span1em">'+json.data[index].name+'</span></li>');
                                            }else{
                                                arr.push('<li data-id='+json.data[index].id+'><s></s><span>'+json.data[index].name+'</span></li>');
                                            }
                                            
                                        }
                                   });
                               })(i);
                           }
                       }
                        var timer = setInterval(function () {
                            if (arr.length == json.data.length) {
                                clearInterval(timer);
                               arr.sort(function (a, b) {
                                    return a.match(/\d+/)[0] - b.match(/\d+/)[0];
                                });
                                for (var i=0; i<arr.length; i++) {
                                    $('#tree>ul').append(arr[i]);
                                }
                                $('.table_col3').html('<col class="col1"/><col class="col2"/><col class="col3"/><tr><th width="60">序号</th><th>名称</th><th width="200">操作</th></tr>');
                                $('#tree>ul>li').each(function (index,domEle) {
                                    $('#tree_show').find('.table_col3').append('<tr data-id='+$(domEle).attr('data-id')+'><td>'+(index+1)+'</td><td>'+$(domEle).find('span').html()+'</td><td><span class="tb_edit button_gm">编 辑</span><span data-id='+$(domEle).attr('data-id')+' class="tb_remove button_delete">   删 除</span></td></</tr>');
                                });
                            }
                        }, 20);
                    }
    });



    var aTrackAct = [];//用数组存每一层的位置
    var aTrackSTag = [];//用数组存每一层的展开按钮

    //左侧树结构开始
    //如果到了最后一层，删除s标签
    $('#tree li s').filter(function (index) {
        return $(this).parent().children().length == 2;
    }).remove();
    //如果到了最后一层，让没有s元素的li和有s元素的li对齐
    $('#tree li span').filter(function (index) {
        return $(this).parent().children().length == 1;
    }).css('paddingLeft', '18px');

    //点击文字让当前激活，其他恢复状态
    //todu,添加ajax后，让他自动激活
    $('#tree li span').live('click', function () {
        //console.log('#tree li span');
        $('#tree li span').removeClass('act');
        $(this).addClass('act');

        aTrackAct = [];
        $(this).parents('li').each(function () {
            aTrackAct.push($(this).index());
        });
        aTrackAct.reverse();
        $(".btn_box .btn").attr("area-id",$(this).parent().attr("data-id"));
        if (aTrackAct.length<5) {
            $('#tree_show').show();
        } else {
            $('#tree_show').hide();
        }

        //console.log(aTrackAct)
        //左侧树和右侧表格关联
        if ($(this).parent().children().length == 3) {//如果不是最后一级
            $('.table_col3').html('<col class="col1"/><col class="col2"/><col class="col3"/><tr><th>序号</th><th>名称</th><th>操作</th></tr>');
            $(this).next().children().each(function (index,domEle) {
                $('#tree_show').find('.table_col3').append('<tr data-id='+$(domEle).attr('data-id')+'><td>'+(index+1)+'</td><td>'+$(domEle).find('span').html()+'</td><td><span class="tb_edit button_gm">编 辑</span><span data-id='+$(domEle).attr('data-id')+' class="tb_remove button_delete">删 除</span></td></</tr>');
            });
        } else {
            $('.table_col3').html('<col class="col1"/><col class="col2"/><col class="col3"/><tr><th>序号</th><th>名称</th><th>操作</th></tr>');
        }
    });

    //点击加减图标控制展开
    $('#tree li s').live('click', function () {
        clearInterval(timer);//下面用定时器获判断子集是不是加载完，好展开，这里清空防止连续点击
        var _this = $(this);//为下面定时器

        aTrackSTag = [];
        $(this).parents('li').each(function () {
            aTrackSTag.push($(this).index());
        });
        aTrackSTag.reverse();

        if($(this).hasClass('on')) {
            $(this).removeClass('on');
            if ($(_this).next().next().get(0).tagName == 'UL') {
                $($(_this).next().next().get(0)).remove();//加了ajax要删除
            }
        } else {
            $(this).addClass('on');
            $.ajax({
                url     :    '/community/getCountrys/'+$(this).parent().attr('data-id'),
                dataType:   'jsonp',
                jsonp   :   'callback',
                success :   function (json) {
                    if (json.code == 0) {
                        switch (aTrackSTag.length) {
                            case 1 :
                                var str = '';
                                if (json.data.length > 0) {
                                    for (var i=0; i<json.data.length; i++) {
                                        str += '<li data-id='+json.data[i].id+'><s></s><span>'+json.data[i].name+'</span></li>';
                                    }
                                } else {
                                    for (var i=0; i<json.data.length; i++) {
                                        str += '<li data-id='+json.data[i].id+'><span>'+json.data[i].name+'</span></li>';
                                    }
                                }

                                $('#tree>ul>li:eq('+aTrackSTag[0]+')').append('<ul>'+str+'</ul>');
                                break;
                            case 2 :
                                var str = '';
                                if (json.data.length > 0) {
                                    for (var i=0; i<json.data.length; i++) {
                                        str += '<li data-id='+json.data[i].id+'><s></s><span>'+json.data[i].name+'</span></li>';
                                    }
                                }else{
                                    for (var i=0; i<json.data.length; i++) {
                                        str += '<li data-id='+json.data[i].id+'><span>'+json.data[i].name+'</span></li>';
                                    }
                                }
                                $('#tree>ul>li:eq('+aTrackSTag[0]+')>ul>li:eq('+aTrackSTag[1]+')').append('<ul>'+str+'</ul>');
                                break;
                            case 3 :
                                var str = '';
                                if (json.data.length > 0) {
                                    for (var i=0; i<json.data.length; i++) {
                                        str+='<li data-id='+json.data[i].id+'><s></s><span>'+json.data[i].name+'</span></li>';
                                    }
                                }else{
                                    for (var i=0; i<json.data.length; i++) {
                                        str+='<li data-id='+json.data[i].id+'><span>'+json.data[i].name+'</span></li>';
                                    }
                                }
                                $('#tree>ul>li:eq('+aTrackSTag[0]+')>ul>li:eq('+aTrackSTag[1]+')>ul>li:eq('+aTrackSTag[2]+')').append('<ul>'+str+'</ul>');
                                break;
                            case 4 :
                                var str = '';
                                if (json.data.length > 0) {
                                    for (var i=0; i<json.data.length; i++) {
                                        str+='<li data-id='+json.data[i].id+'><s></s><span>'+json.data[i].name+'</span></li>';
                                    }
                                }else{
                                    for (var i=0; i<json.data.length; i++) {
                                        str+='<li data-id='+json.data[i].id+'><span>'+json.data[i].name+'</span></li>';
                                    }
                                }
                                $('#tree>ul>li:eq('+aTrackSTag[0]+')>ul>li:eq('+aTrackSTag[1]+')>ul>li:eq('+aTrackSTag[2]+')>ul>li:eq('+aTrackSTag[3]+')').append('<ul>'+str+'</ul>');
                                break;
                        }
                        for (var i=0; i<json.data.length; i++) {
                            (function (index,index_j) {
                                $.ajax({
                                    url     :   '/community/getCountrys/'+json.data[index].id,
                                    dataType:   'jsonp',
                                    jsonp   :   'callback',
                                    success :   function (jsonIn) {
                                        if (jsonIn.data.length <= 0) {
                                            $('li[data-id='+index_j+'] s').remove();
                                        }
                                    }
                               });
                            })(i,json.data[i].id);
                        }
                        //点击展开加号点击展示右侧列表
                        $(_this).next('span').click();
                    }
                }
            });
            //定时器判断加载完毕，起循环ajax回调的作用
            var timer = setInterval(function () {
                if ($(_this).next().next().get(0) && $(_this).next().next().get(0).tagName == 'UL') {
                    clearInterval(timer);
                    $(_this).next().next().css('display', 'block');
                }
            }, 20);
            
        }
    });
    //左侧树结构结束


    //开始右侧内容，右侧table根据左侧树结构渲染
    function tableRight() {
        $('.table_col3').html('<tr><th>序号</th><th>名称</th><th>操作</th></tr>');
        $('#tree>ul>li').each(function (index, domEle) {
            $('.table_col3').append('<tr><td>'+(index+1)+'</td><td>'+$(domEle).find('span').html()+'</td><td><span class="tb_edit button_gm">编 辑</span><span class="tb_remove button_delete">删 除</span></td></</tr>')
        });
    }
    tableRight();

    //左侧s标签点击，弹窗值清空
    function leftAddClass() {
        tableRight();
        $('#tb_pop input').val('');
        $('#tb_pop').remove();
        $('#tree .act').trigger('click');
        $('#tree .act').prev().addClass('on');
        $('#tree .act').next().css('display', 'block');
    }

    //右侧添加按钮
    $('#tree_show .btn').live('click', function () {
        var config = {
            type : 1,
            //title: false,
            offset:['150px' , ''],
            border : false,
            shadeClose:false,
            fadeIn: 300,
            yes:function(index){
            },
            area : ['300px','auto'],
            page : {dom : '.layerbox'}
        };

        if (aTrackAct.length < 5) {
            
            $('#tree_show table:eq(0)').show();
            $('.layerbox').html(tbPopstr);
            switch ($('#tree .act').parents('ul').length) {//根据多少个父级ul，判断显示文本
                case 1 :
                    $('#tb_pop b').html('市 名称');
                    //config.title = '市 名称';
                    break;
                case 2 :
                    $('#tb_pop b').html('区名称');
                    //config.title = '区名称';
                    break;
                case 3 :
                    $('#tb_pop b').html('街道 名称');
                    //config.title = '街道 名称';
                    break;
                case 4 :
                    $('#tb_pop b').html('社区 名称');
                    //config.title = '社区 名称';
                    break;
            }
            
        } 
        var areaid = $(this).attr("area-id");
        $.layer(config);
        $('#tb_pop input[name="parentId"],#tb_pop input[name="communityIds"]').val(areaid);
       
        $('.layerbox #tb_pop').find('.tb_edit1').unbind('click');
        $('.layerbox #tb_pop').find('.tb_edit1').click(function () {
            
            $('.layerbox #tb_pop').find('input:eq(2)').val(aTrackAct.length);
            var parentId = $("#form_edit1 input[name='parentId']").val();
            $.ajax({
                type:'post',
                url:'/community/country/saveOrUpdate',
                data:$("#form_edit1").serialize(),
                dataType:'json',
                success:function(data){
                    
                    if(data.code==0){
                        if ($('#tb_pop input:eq(0)').val()) {//弹窗必须输入文本
                            if ($('#tree .act').length) {//判断如果不是省级
                                
                                if($('#tree .act').prev('s').length==0){
                                    $('#tree .act').css('paddingLeft', 0).parent().append('<ul><li data-id="'+data.data[0].id+'"><span>'+$('#tb_pop input:eq(0)').val()+'</span></li></ul>');
                                    $('#tree .act').parent('li').removeAttr('style');
                                    $('#tree .act').before('<s></s>');
                                    $('#tree .act').prev().trigger('click');
                                }else if($('#tree .act').prev('s').hasClass('on')){
                                    $('#tree .act').next('ul').append('<li data-id="'+data.data[0].id+'"><span>'+$('#tb_pop input:eq(0)').val()+'</span></li>');
                                }else{

                                }
                                $(".act").click();
                                
                            } else {//如果是省级
                                $('#tree>ul').append('<li><span class="span1em">'+$('#tb_pop input:eq(0)').val()+'</span></li>');
                                $("#tree_show .table_col3").append('<tr data-id="'+data.data[0].id+'"><td>'+$('.treeul>li').length+'</td><td>'+data.data[0].name+'</td><td><span class="tb_edit button_gm">编 辑</span><span data-id="'+data.data[0].id+'" class="tb_remove button_delete">删 除</span></td></tr>');
                            }
                        } else {
                            layer.alert('添加失败');
                        }
                    }else{
                        layer.alert(data.message);
                    }
                },
                error:function(){
                    //location.reload();
                }
            });
            layer.closeAll();
        });

        $('.layerbox #tb_pop').find('.tb_edit3').unbind('click');
      
    });

    //弹窗取消按钮
    $('#tb_pop .tb_remove').live('click', function () {
        layer.closeAll();
        $('#tb_pop').remove();
    });

    //右侧表格编辑
    $('#tree_show table .tb_edit').live('click', function () {
        var config = {
            type : 1,
            //title: false,
            offset:['150px' , ''],
            border : false,
            shadeClose:false,
            fadeIn: 300,
            yes:function(index){
                //console.log(index);
            },
            area : ['300px','auto'],
            page : {dom : '.layerbox'}
        };
        var _this = $(this)
        if (aTrackAct.length < 5) {
          
            $('.layerbox').html(tbPop2str);
            //debugger
            $('.layerbox #tb_pop').find('input[name="name"]').val($(this).parent().prev().html());
            $('.layerbox #tb_pop').find('input[name="id"]').val($(this).parent().parent().attr('data-id'));
        } 
       
        $.layer(config);

        

        $('.layerbox #tb_pop').find('.tb_edit2').unbind('click');
        $('.layerbox #tb_pop').find('.tb_edit2').click(function () {
           
           $('.layerbox #tb_pop').find('input:eq(1)').attr('value', $('#tree .act').next().find('li:eq('+($(_this).parent().parent().index()-1)+')').attr('data-id'));
          
            $.ajax({
                type:'post',
                url:'/community/country/saveOrUpdate',
                data:$("#form_edit2").serialize(),
                dataType:'json',
                success:function(data){
                    
                    if(data.code==0){
                        if ($('#tree .act').length) {
                            switch (aTrackAct.length) {
                                case 1 :
                                    $('#tree>ul>li:eq('+aTrackAct[0]+')>ul>li:eq('+($(_this).parent().parent().index()-1)+')>span').html($('.layerbox #tb_pop').find('input').val());
                                    break;
                                case 2 :
                                    $('#tree>ul>li:eq('+aTrackAct[0]+')>ul>li:eq('+aTrackAct[1]+')>ul>li:eq('+($(_this).parent().parent().index()-1)+')>span').html($('.layerbox #tb_pop').find('input').val());
                                    break;
                                case 3 :
                                    $('#tree>ul>li:eq('+aTrackAct[0]+')>ul>li:eq('+aTrackAct[1]+')>ul>li:eq('+aTrackAct[2]+')>ul>li:eq('+($(_this).parent().parent().index()-1)+')>span').html($('.layerbox #tb_pop').find('input').val());
                                    break;
                                case 4 :
                                    $('#tree>ul>li:eq('+aTrackAct[0]+')>ul>li:eq('+aTrackAct[1]+')>ul>li:eq('+aTrackAct[2]+')>ul>li:eq('+aTrackAct[3]+')>ul>li:eq('+($(_this).parent().parent().index()-1)+')>span').html($('.layerbox #tb_pop').find('input').val());
                                    break;
                            }
                        } else {
                            $('#tree>ul>li:eq('+($(_this).parent().parent().index()-1)+')>span').html($('.layerbox #tb_pop').find('input').val());
                        }
                        $('tr[data-id='+data.data[0].id+']').find('td:eq(1)').html(data.data[0].name);
                    }else{
                        layer.alert(data.message);
                    }
                }
            });
            layer.closeAll();
        });

        $('.layerbox #tb_pop').find('.tb_edit4').unbind('click');
        $('.layerbox #tb_pop').find('.tb_edit4').click(function () {
            
            layer.closeAll();
            var form_params = $("#form_edit4").serialize();
            $.ajax({
                type:'post',
                url:'/care/communityUser/saveOrUpdate',
                data:$("#form_edit4").serialize(),
                dataType:'json',
                success:function(data){
                    
                    if(data.code==0){
                        $(_this).parent().parent().find('td:eq(1)').html($('.layerbox #tb_pop').find('input:eq(0)').val());
                        $(_this).parent().parent().find('td:eq(3)').html($('.layerbox #tb_pop').find('input:eq(2)').val());
                        $(_this).parent().parent().find('td:eq(4)').html($('.layerbox #tb_pop').find('input:eq(3)').val());
                        $(_this).parent().parent().find('td:eq(5)').html($('.layerbox #tb_pop').find('input:eq(4)').val());
                        $(_this).parent().parent().find('td:eq(6)').html($('.layerbox #tb_pop').find('input:eq(5)').val());
                        $(_this).parent().parent().find('td:eq(2)').html($('.layerbox #tb_pop').find('select:eq(0)').find("option:selected").text());
                        $(_this).parent().parent().find('td:eq(7)').find('span').attr('data-gender',$('.layerbox #tb_pop').find('select:eq(0)').find("option:selected").val());
                        layer.alert('编辑成功');
                    }else{
                        layer.alert('编辑失败');
                    }
                },
                error:function(e){
                    layer.alert('编辑失败');
                }
            })
        });
    });

    //右侧表格删除
    $('#tree_show table .tb_remove').live('click', function () {
        var _this = this;
        if (aTrackAct.length < 5) {
           
            layer.confirm('确定删除吗？',function(index){
                layer.close(index);
                $.ajax({
                    type:'post',
                    url:'/community/country/saveOrUpdate',
                    data:'available=0&id='+$(_this).attr('data-id'),
                    dataType:'json',
                    success:function(data){
                        //debugger;
                        if(data.code==0){
                            switch (aTrackAct.length) {
                                case 0 :
                                    $('#tree>ul>li:eq('+($(_this).parent().parent().index()-1)+')').remove();
                                    break;
                                case 1 :
                                    $('#tree>ul>li:eq('+aTrackAct[0]+')>ul>li:eq('+($(_this).parent().parent().index()-1)+')').remove();
                                    break;
                                case 2 :
                                    $('#tree>ul>li:eq('+aTrackAct[0]+')>ul>li:eq('+aTrackAct[1]+')>ul>li:eq('+($(_this).parent().parent().index()-1)+')').remove();
                                    break;
                                case 3 :
                                    $('#tree>ul>li:eq('+aTrackAct[0]+')>ul>li:eq('+aTrackAct[1]+')>ul>li:eq('+aTrackAct[2]+')>ul>li:eq('+($(_this).parent().parent().index()-1)+')').remove();
                                    break;
                                case 4 :
                                    $('#tree>ul>li:eq('+aTrackAct[0]+')>ul>li:eq('+aTrackAct[1]+')>ul>li:eq('+aTrackAct[2]+')>ul>li:eq('+aTrackAct[3]+')>ul>li:eq('+($(_this).parent().parent().index()-1)+')').remove();
                                    break;
                            }
                            $("tr[data-id="+$(_this).attr('data-id')+"],li[data-id="+$(_this).attr('data-id')+"]").remove();
                            layer.alert("删除成功",9);
                        }else{
                            layer.alert("删除失败");
                        }
                    },
                    error:function(e){

                    }
                });
            });
        } 
    });
    var tbPopstr = '<div id="tb_pop"><form id="form_edit1" method="post" action="/community/country/saveOrUpdate" ><b>省（直辖市） 名称</b>：<input type="text" name="name" value=""/><p><span class="tb_edit tb_edit1">确 定</span><span class="tb_remove">取 消</span></p><input type="hidden" name="parentId" value="" /><input type="hidden" name="type" value="" /></form></div>';
    var tbPop = $(tbPopstr);
    var tbPop2str = '<div id="tb_pop"><form id="form_edit2" method="post" action="/community/country/saveOrUpdate" ><b>省（直辖市） 名称</b>：<input type="text" name="name" value="" /><p><span class="tb_edit tb_edit2">确 定</span><span class="tb_remove">取 消</span></p><input type="hidden" name="id" value="" /></form></div>';
    var tbPop2 = $(tbPop2str);
   
    $('body').delegate(".autocomplete",'click',function(){
        $(this).hide().next('input').show().focus();
    });
});

</script>
</body>
</html>