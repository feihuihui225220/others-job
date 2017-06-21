<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>历史数据</title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/common.js"></script>
</head>
<body>

<div class="wrapper">
    <div class="body bodyline pad10">
        <div class="searchli">
            <ul class="inpubox clearfix">
                <Form name="Form＿name" method="post" action="/professional/service/history/query" >
				<input type="hidden" name="userId" value="${userId}" />
				<input type="hidden" name="page" value="1" />
				<input type="hidden" name="num" value="20" />
                <li><input class="text150 timedate" type="text" name="start" value="$!date.format('yyyy-MM-dd',$!dateCond.start)" /> 至 <input class="text150 timedate" type="text" name="end" value="$!date.format('yyyy-MM-dd',$!dateCond.end)"/></li>
                <li><input class="ibtn button_btn" type="submit" value="查询"></li>
            </Form>  
            </ul>
        </div>
        <div class="tablebox">
            <table class="table100 usertable cen">
                <tr>
                #foreach ($title in $datas[0].data.titles)
                	<th>${title}</th>
                #end
                </tr>
                
                #foreach ($data in $datas[0].data.values)
                <tr>
	                #foreach($d in $data)
	                <td>$d</td>
	                #end
                </tr>
	            #end
                </table>
        </div>
    </div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="../../assets/js/layer.min.js"></script>
<script type="text/javascript" src="../../assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".addadver").click(function(){
        $.layer({
            type : 1,
            title : '添加公告',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                layer.close(index);
            },
            area : ['603px','auto'],
            page : {dom : '.adverbox'}
        });
    });
    $(".addOption").on('click',function(){
        if($("#select_left option:selected").length>0){
            $("#select_left option:selected").each(function(){
                $("#select_right").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option");
                $(this).remove();　 
            });
        }else{
            alert("请选择要添加的字段");
        }
    });
    $(".delOption").on('click',function(){
        if($("#select_right option:selected").length>0){
            $("#select_right option:selected").each(function(){
                $("#select_left").append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option");
                $(this).remove();　 
            });
        }else{
            alert("请选择要删除的字段");
        }
    });
    //设置选中
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