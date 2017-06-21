<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    <div class="body">
		<div class="body bodyline pad10">
			<div class="actboxlist">
                <div class="actbox1">
                   <form name="evaForm" action="/professional/vender/tab/eva/query" method="post" name="searchForm">
	                   <table class="table100 usertable cen trclick">
	                        <tr>
	                        	<th>姓名</th>
	                        	<th>身份证号</th>
	                        	<th>性别</th>
	                        	
	                        	<th>所在社区</th>
	                        </tr>
	                        #foreach($u in $page.result)
	                        <tr style="cursor:pointer;"  >
	                        	<td>${u.userName}</td>
	                        	<td>${u.userIdCard}</td>
	                        	<td>#if(${u.gender}==0) 女 #else 男 #end</td>
	                        	<td>${u.communityName}</td>
	                        	<input type="hidden" value="/professional/vender/user/detail/${u.userId}" target="_parent" />
	                        </tr>
	                        #end
	                    </table>
	                    #if($page.result.size()>0)
							#parse("/common/page.tpl")
						#end
	                 </form>
                </div>
            </div>
		</div>
    </div>
    <div class="footer"></div>
</div>
<div class="limitbox pad10 hide">
    <ul class="inpubox clearfix">
        <li><label>分类民称：</label><input class="text150" type="text" /></li>
        <li><label>描述：</label><textarea name="" id="" cols="30" rows="6"></textarea></li>
    </ul>
</div>
<div class="limitbox2 pad10 hide">
    <ul class="inpubox clearfix">
        <li><label>分类民称：</label><input class="text150" type="text" /></li>
    </ul>
</div>
<script type="text/javascript" src="js/layer.min.js"></script>
<script type="text/javascript" src="js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".clourstitle li").click(function(){
        var index = $(this).attr('index');
        $(this).addClass('on').siblings().removeClass('on');
        $(".actboxlist .actbox"+index).show().siblings().hide();
    });

    $('.actbox1 .btn').click(function () {
        $('.limitbox input').val('');
        $('.limitbox textarea').val('');
        $.layer({
            type : 1,
            title : '添加分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                $('.table_col3').append('<tr><td>'+$('.limitbox input').val()+'</td><td>'+$('.limitbox textarea').val()+'</td><td><span class="tb_edit">编 辑</span><span class="tb_remove">删 除</span></td></tr>')
                layer.close(index);
            },
            area : ['450px','270px'],
            page : {dom : '.limitbox'}
        });
    });

    $('.actbox1 .tb_edit').live('click', function () {
        var _this = $(this)
        $('.limitbox input').val($(this).parent().prev().prev().html());
        $('.limitbox textarea').val($(this).parent().prev().html());
        $.layer({
            type : 1,
            title : '编辑分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                $(_this).parent().prev().prev().html($('.limitbox input').val());
                $(_this).parent().prev().html($('.limitbox textarea').val());
                layer.close(index);
            },
            area : ['450px','270px'],
            page : {dom : '.limitbox'}
        });
    });

    $('.actbox2 .btn:eq(0)').click(function () {
        $('.limitbox2 input').val('');
        $.layer({
            type : 1,
            title : '添加分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                $('.table_col2:eq(0)').append('<tr><td>'+$('.limitbox2 input').val()+'</td><td><span class="tb_edit">编 辑</span><span class="tb_remove">删 除</span></td></tr>')
                layer.close(index);
            },
            area : ['300px','145px'],
            page : {dom : '.limitbox2'}
        });
    });

    $('.actbox2 .btn:eq(1)').click(function () {
        $('.limitbox2 input').val('');
        $.layer({
            type : 1,
            title : '添加分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                $('.table_col2:eq(1)').append('<tr><td>'+$('.limitbox2 input').val()+'</td><td><span class="tb_edit">编 辑</span><span class="tb_remove">删 除</span></td></tr>')
                layer.close(index);
            },
            area : ['300px','145px'],
            page : {dom : '.limitbox2'}
        });
    });


    $('.actbox2 .tb_edit').live('click', function () {
        var _this = $(this)
        $('.limitbox2 input').val($(this).parent().prev().html());
        $.layer({
            type : 1,
            title : '编辑分类',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                $(_this).parent().prev().html($('.limitbox2 input').val());
                layer.close(index);
            },
            area : ['300px','145px'],
            page : {dom : '.limitbox2'}
        });
    });

    $('.tb_remove').live('click', function () {
        var _this = $(this)
        $.layer({
            shade: [0],
            area: ['auto','auto'],
            dialog: {
                msg: '确定要删除吗？',
                btns: 2,                    
                type: 4,
                btn: ['删除','取消'],
                yes: function(){
                    $(_this).parent().parent().remove();
                    layer.msg('删除', 1, 1);
                }, no: function(){
                    //layer.msg('取消', 1, 13);
                }
            }
        });
    });
	function checkSelectAll(){
        var oAll = $(".checkbox") //全部可选
        ,
        bAllChecked = true //是否是全选状态默认true为全选,false为未选中
        ,
        iLen = oAll.length,addOnNums = 0;
        if (iLen == 0) bAllChecked = false;
        for (var _i = 0; _i < iLen; _i++) {
            if (!$(oAll[_i]).attr("checked")) {
                bAllChecked = false; 
            }else{
                ++addOnNums;
            }
        }
        if (bAllChecked) { //是否全选样式
            $(".checkall").attr("checked",true);
        } else {
            $(".checkall").attr("checked",false);
        }
    }
    $(".checkbox").on("click",function(){
        checkSelectAll();
    });
    $(".checkall").on("click",function(){
        if(!!$(this).attr('checked')){
            $(".checkbox").attr("checked",true);
        }else{
            $(".checkbox").attr("checked",false);
        }
    });
    $(".timedate").calendar({ format:'yyyy-MM-dd' });
});
</script>
</body>
</html>