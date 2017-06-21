<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>社区用户_汇总</title>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usertitle strong">公共服务汇总</div>
        <div class="searchli">
        	<form action="search" method="get" name="searchForm">
            <ul class="inpubox clearfix">
                <li><label>政策分类：</label>
                	<select class="select160" name="categotyId" id="ptype">
                		<option value="0">全部</option>
                		#foreach($category in $catMap.entrySet())
                			<option value="${category.value.id}" #if($searchVo.categotyId==$category.value.id)selected="selected"#end>${category.value.itemName}</option>
                		#end
                	</select></li>
                <li><label>政策名称：</label><select class="select160" name="policyId" id="title"><option value="0">全部</option></select></li>
                <li><label>姓名：</label><input class="text150" type="text" name="username" value="$!{searchVo.username}"/></li>
                <li><label>身份证号：</label><input class="text150" type="text" name="cardnum" value="$!{searchVo.cardnum}"/></li>
                <li><label>办理状态：</label>
                <select class="select160" name="state">
               		<option value="0" #if($searchVo.state==0)selected="selected"#end>全部</option>
                	<option value="1" #if($searchVo.state==1)selected="selected"#end>办理</option>
                	<option value="2" #if($searchVo.state==2)selected="selected"#end>材料不全</option>
                	<option value="3" #if($searchVo.state==3)selected="selected"#end>不办理</option>
                	<option value="4" #if($searchVo.state==4)selected="selected"#end>已办理</option>
                	<option value="5" #if($searchVo.state==5)selected="selected"#end>已领取</option>
                	<option value="6" #if($searchVo.state==6)selected="selected"#end>系统默认办理</option>
                </select></li>
                <li><label>日期：</label><input class="text150 timedate" type="text" value="$!{searchVo.start}" name="start"/> 至 <input class="text150 timedate" type="text" value="$!{searchVo.end}" name="end"/></li>
                #if($communitys)
                <li>
				        	<label>所属社区：</label>
				        	<select class="select160" name="communityId">
				        		<option value="">全部社区</option>
				        		#foreach($item in $communitys)
				        		<option value="$!item.id" #if($!{communityId}==$!item.id)selected=true#end>$!item.name</option>
				        		#end
				        	</select>
				        </li>
				        #end
            </ul>
             <ul class="inpubox clearfix">
            		<li><input class="ibtn button_btn" type="submit" value="查询"></li>
                <li><input class="ibtn button_btn importdata" type="button" value="导出"></li>
             </ul>
            </form>
        </div>
        #if ($page)
        <div class="tablebox">
            <table class="table100 usertable cen">
                <tr><th><input class="checkall" type="checkbox" value=""></th><th>姓名</th><th>身份证号</th><th>政策类型</th><th>政策名称</th><th>联系电话</th><th>办理状态</th><th>办理时间</th><th>领取时间</th></tr>
                #foreach ($upolicy in $page.result)
                <tr><td><input class="checkbox" type="checkbox" name="selectbox" value="${upolicy.id}" status="${upolicy.state}" #if($upolicy.state!=4)disabled#end></td><td>$!{upolicy.user.name}</td><td>$!{upolicy.user.idCardNo}</td><td>${upolicy.policy.category.itemName}</td><td>$!{upolicy.policy.title}</td><td>$!{upolicy.user.contactPhone}</td><td>$statearr.get(${upolicy.state})</td><td>$!date.format('yyyy-MM-dd',${upolicy.handleTime})</td><td>$!date.format('yyyy-MM-dd',${upolicy.receiveTime})</td></tr>
                #end
            </table>
            #parse("/common/page.tpl")
        </div>
        #end
    </div>
    <div class="footer"></div>
</div>
<div class="importbox pad10 hide">
    <div class="selectbox clearfix">
        <div class="left f_l">
            <select class="selectmultiple" name="" id="select_left" multiple="multiple" size="1">
                <option value="1" name="usName">姓名</option>
                <option value="1" name="usCardNo">身份证号</option>
                <option value="1" name="plType">政策类型</option>
                <option value="1" name="plName">政策名称</option>
                <option value="1" name="usPhone">联系电话</option>
                <option value="1" name="upState">办理状态</option>
                <option value="1" name="handleTime">办理时间</option>
                <option value="1" name="receiveTime">领取时间</option>
            </select>
        </div>
        <div class="mid f_l"><button class="addOption">添加</button><button class="delOption">删除</button></div>
        <div class="right f_l">
        	<form action="export" id="exportForm" method="get">
	        	<input type="hidden" name="categotyId" value="#if(!$searchVo)0#else$!{searchVo.categotyId}#end">
	        	<input type="hidden" name="policyId" value="#if(!$searchVo)0#else$!{searchVo.policyId}#end">
	        	<input type="hidden" name="username" value="$!{searchVo.username}">
	        	<input type="hidden" name="cardnum" value="$!{searchVo.cardnum}">
	        	<input type="hidden" name="state" value="#if(!$searchVo)0#else$!{searchVo.state}#end">
	        	<input type="hidden" name="start" value="$!{searchVo.start}">
	        	<input type="hidden" name="end" value="$!{searchVo.end}">
            <select class="selectmultiple" name="" id="select_right" multiple="multiple" size="1"></select>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="$request.contextPath/assets/js/layer.min.js"></script>
<script type="text/javascript" src="$request.contextPath/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#rcvbtn").click(function(){
	  var succount = 0;
		$("input[name='selectbox']:checked").each(function(){
			if($(this).attr("status")=="4"){
				 $ .ajax({
				 				async:false,
			       		type: "post",
			       		data:{id:$(this).attr("value")},
						url: "receive",
						success: function(data){
							if("done"==data){
								succount++;
							}
						}
			   });
			}
		});
		if(succount>0){
			alert("成功领取");
			location.reload(true);
		}
		
	});
	//级联菜单
	var type = {"0":"<option value='0'>全部</option>",#foreach($pMap in $policyMap.entrySet())"${pMap.key}":"<option value='0'>全部</option>#foreach($pcategoty in $pMap.value)<option value='${pcategoty.id}'>${pcategoty.title}</option>#end",#end};
	$("#ptype").change(function(){
		var key = $(this).val();
		$("#title").html(type[key]);
	});
    $(".importdata").click(function(){
        $.layer({
            type : 1,
            title : '导出',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['导出', '取消'],
            yes:function(index){
                $("#exportForm").submit();
                layer.close(index);
            },
            area : ['603px','400px'],
            page : {dom : '.importbox'}
        });
    });
    $(".addOption").on('click',function(){
        if($("#select_left option:selected").length>0){
            $("#select_left option:selected").each(function(){
                $("#select_right").append("<option value='"+$(this).val()+"' name='"+$(this).attr("name")+"'>"+$(this).text()+"</option>");
                $("#exportForm").append("<input type='hidden' name='"+$(this).attr("name")+"' value='1'>");
                $(this).remove();　 
            });
        }else{
            alert("请选择要添加的字段");
        }
    });
    $(".delOption").on('click',function(){
        if($("#select_right option:selected").length>0){
            $("#select_right option:selected").each(function(){
                $("#select_left").append("<option value='"+$(this).val()+"' name='"+$(this).attr("name")+"'>"+$(this).text()+"</option");
                $("input[name='"+$(this).attr("name")+"']").remove();
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