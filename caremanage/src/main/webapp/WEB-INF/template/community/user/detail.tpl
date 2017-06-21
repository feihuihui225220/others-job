<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body">
        <div class="usermessbox bodyline pad10 mgb10 clearfix">
            <div class="umleft f_l clearfix">
                <div class="userpix pad10 f_l"><img src="/$!{user.head}" onerror="this.src='/assets/css/img/people.png'" alt="头像"/></div>
                <ul class="usermes1 f_l">
                    <li>姓名：<span class="strong">$!{user.name}</span></li>
                    <li>性别：<span class="strong">#if($!{user.gender}==0)女#else男#end</span></li>
                    <li>年龄：<span class="strong">$!{user.age}</span></li>
                    <li>手机：<span class="strong">$!{user.mobilePhone}</span></li>
                </ul>
                <ul class="usermes1 meswidth f_l">
                    <li>联系电话：<span class="strong">$!{user.contactPhone}</span></li>
                    <li>居住情况：<span class="strong">$!{categoryItems.get($!user.lifeCond).itemName}</span></li>
                    <li>社区名称：<span class="strong">$!{ocountry.fullNames[5]}</span></li>
                    <li style="padding-left:70px;position:relative;"><span style="position:absolute;left:0;">居住地址：</span><span class="strong">$!{user.addr}</span></li>
                </ul>
            </div>
            <div class="umright f_r">
                <ul class="clearfix">
                	#if($status)
                		#foreach($s in $status)
                			#if($foreach.index>0 && $foreach.index<=6)
                				<li>$s</li>
                			#end
                		#end
                	#end
                </ul>
            </div>
        </div>
        <div class="useractbox bodyline pad10">
            <ul class="clourstitle strong mgb10">
                <li index="1" class="rel on">办事信息</li>
                <li index="2" class="rel">基础信息</li>
                <li index="3" class="rel">特征信息</li>
                <li index="4" class="rel">联系人信息</li>
                <li index="5" class="rel">证据信息</li>
            </ul>
            <div class="actboxlist">
                <div class="actbox1">
                	<iframe src="/community/userpolicy/iframe/$!{user.id}" onload="iframeAutoSet(this)" frameborder="0" scrolling="no" width="100%"></iframe>
                </div>
                <div class="actbox2 hide">
                    <table class="table100 usertable cen">
                        <tr>
                        	<td>姓名：$!{user.name}</td>
                        	<td>婚姻状况：$!{categoryItems.get($!user.marry).itemName}</td>
                        	<td>街道名称：$!{ocountry.fullNames[4]}</td>
                        </tr>
                        <tr>
                        	<td>身份证号：$!{user.idCardNo}</td>
                        	<td>手机：$!{user.mobilePhone}</td>
                        	<td>社区名称：$!{ocountry.fullNames[5]}</td>
                        </tr>
                        <tr>
                        	<td>性别：#if($!{user.gender}==0)女#else男#end</td>
                        	<td>联系电话：$!{user.contactPhone}</td>
                        	<td>居住地址：$!{user.addr}</td>
                        </tr>
                        <tr>
                        	<td>出生日期：$!date.format('yyyy-MM-dd',$!user.birthday)</td>
                        	<td>政治面貌：$!{categoryItems.get($!user.political).itemName}</td>
                        	<td>居住情况：$!{categoryItems.get($!user.lifeCond).itemName}</td>
                        </tr>
                        <tr>
                        	<td>年龄：$!{user.age}</td>
                        	<td>文化程度：$!{categoryItems.get($!user.education).itemName}</td>
                        	<td>从业状况：$!{categoryItems.get($!user.jobCond).itemName}</td>
                       	</tr>
                        <tr>
                        	<td>宗教信仰：$!{categoryItems.get($!user.religion).itemName}</td>
                        	<td>民族：$!{categoryItems.get($!user.nation).itemName}</td>
                        	<td>经济来源：$!{categoryItems.get($!user.income).itemName}</td>
                        </tr>
                        <tr>
                        	<td>户口类型：$!{categoryItems.get($!user.hrType).itemName}</td>
                        	<td>省市名称：$!{ocountry.fullNames[1]}</td>
                        	<td>医疗保障：$!{categoryItems.get($!user.medical).itemName}</td>
                        </tr>
                        <tr>
                        	<td>户籍地址：$!{user.hrAddr}</td>
                        	<td>区县名称：$!{ocountry.fullNames[3]}</td>
                        	<td>楼宇：$!{user.building.name}</td>
                       	</tr>
                    </table>
                </div>
                <div class="actbox3 hide">
                    <table class="table100 usertable cen">
                        <tr>
                        	<td>三无：$!{categoryItems.get($!user.specia.three).itemName}</td>
                        	<td>失能：$!{categoryItems.get($!user.specia.disable).itemName}</td>
                        	<td>无保障：$!{categoryItems.get($!user.specia.noSecurity).itemName}</td>
                        </tr>
                        <tr>
                        	<td>孤寡：$!{categoryItems.get($!user.specia.lonely).itemName}</td>
                        	<td>低保：$!{categoryItems.get($!user.specia.lessIncome).itemName}</td>
                        	<td>空巢：$!{categoryItems.get($!user.specia.emptyNest).itemName}</td>
                        </tr>
                        <tr>
                        	<td>失独：$!{categoryItems.get($!user.specia.lostOnly).itemName}</td>
                        	<td>优抚：$!{categoryItems.get($!user.specia.specialCare).itemName}</td>
                        	<td>独居：$!{categoryItems.get($!user.specia.lifeLonely).itemName}</td>
                        </tr>
                    </table>
                </div>
                <div class="actbox4 hide">
                    <div class="rightbtn pad10">
                    	<button onclick="window.location.href='/community/user/addContact/$!{user.id}'" class="addContact button_btn">添加</button>
                    </div>
                    <table class="table100 usertable cen">
                    	<tr>
                    		<th>联系人</th><th>关系</th><th>联系方式</th>
                    	</tr>
                    	#if ($user.contacts)
			                #foreach ($contact in $user.contacts)
				        		<tr>
				        			<td data-id="$!{contact.idCardNo}" data-sex="#if($!{contact.gender}==0)女#else男#end" data-date="$!date.format('yyyy-MM-dd',$!{contact.birthday})" data-address="$!{contact.addr}">$!{contact.name}</td>
				        			<td>$!{categoryItems.get($!contact.relation).itemName}</td>
				        			<td>$!{contact.mobilePhone}</td>
				        		</tr>
			        		#end
		        		#end
                    </table>
                </div>
                <div class="actbox5 hide">
                    <div class="rightbtn pad10">
                    	<button onclick="window.location.href='/community/user/addCert/$!{user.id}'" class="button_btn">添加</button></div>
                    <table class="table100 usertable cen">
                        <tr><th>材料类型</th><th>材料编码</th><th>附件下载</th><th>操作</th></tr>
                        #if ($user.certs)
	                		#foreach ($cert in $user.certs)
		                        <tr class="evdeid_$!{cert.id}">
		                        	<td>$!{categoryItems.get($!cert.categoryId).itemName}</td>
		                        	<td>$!cert.number</td>
		                        	<td><a href="/common/download?path=$!cert.directory" target="_self">下载</a>
		                        	</td>
		                        	<td class="operate">
		                        		<!--<a href=""><input evdeid='1' class="editEvidence" type="button" value="编辑" /></a>-->
		                        		<input evdeid='$!{cert.id}' class="mgl5 delEvidence button_btn" type="button" value="删除">
		                        	</td>
		                        </tr>
                        	#end
        				#end
                    </table>
                </div>
            </div>
        </div>
        
    </div>
    <div class="footer"></div>
</div>
<div class="mask_contact pad10 hide">
    <ul class="inpubox clearfix">
        <li><label>姓名：</label><input class="text150" type="text" /></li>
        <li><label>身份证号：</label><input class="text150" type="text" /></li>
        <li><label>性别：</label><select class="select160" name="" id=""><option value="0">全部</option><option value="0">全部</option></select></li>
        <li><label>出生日期：</label><input class="text150 timedate" type="text" /></li>
        <li><label>手机：</label><input class="text150" type="text" /></li>
        <li><label>与用户关系：</label><input class="text150" type="text" /></li>
        <li class="w520"><label>居住地址：</label><input class="text150" type="text" /></li>
    </ul>
    <!--div class="centerbtn pad10"><button class="button_btn" type="submit">保存</button><button class="pad5 contact_closed">取消</button></div-->
</div>
<div class="mask_evidence pad10 hide">
    <ul class="inpubox clearfix">
        <li><label>材料类型：</label><select class="select160" name="" id=""><option value="0">全部</option><option value="0">全部</option></select></li>
        <div><button id="addfile">增加附件</button></div>
        <div class="iptdiv"><input type="file" name="file[]" class="ipt" /><a href="#" name="rmlink"> X </a></div>
    </ul>
    <!--div class="centerbtn pad10"><button class="button_btn" type="submit">保存</button><button class="pad5 contact_closed">取消</button></div-->
</div>
<div class="mask_user_detail pad10 hide">
<style>
.mask_user_detail .table_col6 col {width:auto;}
.mask_user_detail .table_col6 {width:760px;}
.mask_user_detail .table_col6 td {text-align:left;}
.mask_user_detail .table_col6 .t_r {text-align:right;}
</style>
    <table class="tb table_col6">
        <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/><col class="col5"/><col class="col6"/>
        <tr>
            <td class="t_r">姓名：</td>
            <td class="ed"></td>
            <td class="t_r">身份证：</td>
            <td class="ed"></td>
            <td class="t_r">性别：</td>
            <td class="ed"></td>
        </tr>
        <tr>
            <td class="t_r">出生日期：</td>
            <td class="ed"></td>
            <td class="t_r">手机：</td>
            <td class="ed"></td>
            <td class="t_r">与用户关系：</td>
            <td class="ed"></td>
        </tr>
        <tr>
            <td class="t_r">居住地址：</td>
            <td colspan="5" class="t_l" class="ed"></td>
        </tr>
    </table>
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".clourstitle li").click(function(){
        var index = $(this).attr('index');
        $(this).addClass('on').siblings().removeClass('on');
       	var actbox = $(".actboxlist .actbox"+index+" ");
        if(index==1){
        	if(actbox.find("iframe").length<=0){
        		actbox.html('<iframe src="/community/userpolicy/iframe/$!{user.id}" width="100%" onload="Javascript:iframeAutoSet(this)" height="300" frameborder="0" scrolling="no"></iframe>');
        	}
        }
        $(".actboxlist .actbox"+index).show().siblings().hide();
    });
    $('.addContact').on('click', function(){
        $.layer({
            type : 1,
            title : '添加联系人信息',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            zIndex:99,
            btns: 2,
            success:function(){
                $(".timedate").calendar({ format:'yyyy-MM-dd' });
            },
            btn: ['保存', '取消'],
            yes:function(index){
                //console.log("保存",index);
                layer.close(index);
            },
            area : ['603px','355px'],
            page : {dom : '.mask_contact'}
        });
    });
    $('.addEvidence').on('click', function(){
        $.layer({
            type : 1,
            title : '添加证据信息',
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
            page : {dom : '.mask_evidence'}
        });
    });
    $('.editEvidence').on('click', function(){
        var evdeid = $(this).attr("evdeid");
        //console.log('编辑id'+evdeid);
        $.layer({
            type : 1,
            title : '编辑证据信息',
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
            page : {dom : '.mask_evidence'}
        });
    });
    $(".delEvidence").click(function(){
        var evdeid = $(this).attr("evdeid");
        layer.confirm('是否确定删除该证据信息?', function(index){
			$.get("/community/user/removeCert/"+evdeid,function(result){
    			if(result=='success'){
	    			// 移除记录
	            	$('.evdeid_'+evdeid).remove();
    			}
  			});        	
            layer.close(index);
        }, function(index){
            //console.log(index);
        });
    });
    /*$(".contact_closed").on('click',function(){
        layer.close(layer.index);
    });*/
    // 用来绑定事件(使用unbind避免重复绑定)
    function bindListener(){
         $("a[name=rmlink]").unbind().click(function(){
             $(this).parent().remove(); 
             $(".xubox_main").height($(".xubox_main").height()-21);
         })
    }
    $("#addfile").click(function(){
        addfile();
    });
    function addfile(){ 
       $(".mask_evidence .inpubox").append('<div class="iptdiv"><input type="file" name="img[]" class="ipt" /><a href="#" name="rmlink"> X </a></div>');

    // 为新元素节点添加事件侦听器
       bindListener();
       $(".xubox_main").height($(".xubox_main").height()+21);
    } 
    $('.actbox4 tr td').on('click', function(){
        var par = $(this).parent();
        $('.mask_user_detail').find('.ed').html('');
        $('.mask_user_detail td:eq(1)').html($(par).find('td:eq(0)').html());
        $('.mask_user_detail td:eq(11)').html($(par).find('td:eq(1)').html());
        $('.mask_user_detail td:eq(9)').html($(par).find('td:eq(2)').html());
        $('.mask_user_detail td:eq(3)').html($(par).find('td:eq(0)').attr('data-id'));
        $('.mask_user_detail td:eq(5)').html($(par).find('td:eq(0)').attr('data-sex'));
        $('.mask_user_detail td:eq(7)').html($(par).find('td:eq(0)').attr('data-date'));
        $('.mask_user_detail td:eq(13)').html($(par).find('td:eq(0)').attr('data-address'));
        $.layer({
            type : 1,
            title : '联系人详细信息',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            zIndex:99,
            btns: 1,
            success:function(){
                //$(".timedate").calendar({ format:'yyyy-MM-dd' });
            },
            btn: ['确定'],
            yes:function(index){
                //console.log("保存",index);
                layer.close(index);
            },
            area : ['780px','210px'],
            page : {dom : '.mask_user_detail'}
        });
    });
});
</script>
</body>
</html>