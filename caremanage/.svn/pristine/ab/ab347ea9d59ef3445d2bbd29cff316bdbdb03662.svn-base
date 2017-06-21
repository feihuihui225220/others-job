<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>Care Manager_责任管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/pageNavigator.js"></script>
<script type="text/javascript" src="/assets/js/top.js"></script>
</head>
<style>
</style>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10">
        <div class="usedetail clearfix">
        	<form action="/care/dutyUsers" method="post" name="searchForm">
			<table class="table100 usertable  ">
                <tr><th>员工姓名</th><th>社区名称</th><th>责任管理</th></tr>
				#if ($page)
	                #foreach ($u in $page.result)
                		<tr class="limitid_$!u.id">
							<td title="$!u.id">$!u.name</td>
							<td>
								#if ($ocountryMap.get($!u.id) && $ocountryMap.get($!u.id).size()>0)
									#foreach ($comt in $ocountryMap.get($!u.id))
										#if ($velocityCount==0)
											$comt.name
										#end
									#end
								#else
									-
								#end
							</td>
							<td><span class="tb_edit button_guan" limitid="$!u.id" style="text-align:left;">管 理>></span></td>
						</tr>
					#end
				#end
            </table>
            #parse("/common/page.tpl")
            </form>
        </div>
    </div>
    <div class="footer"></div>
</div>
<style type="text/css">
.xubox_page{bottom:42px;overflow-y:auto;right:0;left:0;}
</style>
<div class="limitbox pad10 hide">
    <ul class="inpubox clearfix">
    	#if ($ocountrys)
	    	#foreach ($cmmt in $ocountrys)
        		<li><input type="checkbox" id="cmmt_$!cmmt.id" name="communityIds" value="$!cmmt.id"/><label id="cmmtName_$!cmmt.id" style="display:inline-block;width:auto;">$!cmmt.name</label></li>
        	#end
        #end
    </ul>
</div>
<script type="text/javascript" src="/assets/js/layer.min.js"></script>
<script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
<script type="text/javascript">
$(function(){
    $(".tb_edit").click(function(){
        var limitid = $(this).attr("limitid");
        //console.log('编辑id'+limitid);
		$.ajax({
			type:'get',
			dataType:'json',
			url:'/care/modify/'+limitid,
			success:function(data){
				// 清除多选框
				$("input[name='communityIds']").removeAttr("checked");
				// 重设选中值
				for(i=0;i<data.length;i++){
					var checkbox = $("#cmmt_"+data[i]);
					if(checkbox){
						$(checkbox).attr("checked","true");
					}
				}
		    		
				$.layer({
		            type : 1,
		            title : '分配社区',
		            offset:['150px' , ''],
		            border : false,
		            shadeClose:true,
		            fadeIn: 300,
		            btns: 2,
		            btn: ['保存', '取消'],
		            yes:function(index){
		                //console.log("保存",index);
		                layer.close(index);
		                // 组装选中值
						var str="";
						$("input[name='communityIds']:checked").each(function(){ 
							str += ","+$(this).val() 
						});
						var checkedIds = str.substring(1);
						// 获取第一个选中值作为回显使用
						var first = checkedIds.split(",")[0];
						$.post("/care/modifyDutyCommunity/"+limitid, {communityIds:checkedIds});
						// 回显页面
						var cmmtName = $("#cmmtName_"+first).html();
						var text = $(".limitid_"+limitid).find('td:eq(1)');
						if(first==""){
							$(text).html("-");
						}else{
							$(text).html(cmmtName);
						}
		            },
		            area : ['450px','270px'],
		            page : {dom : '.limitbox'}
		        });
			}
		});
        
    });
});
</script>
</body>
</html>