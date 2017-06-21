<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>查看客户信息</title>
#parse("/common/top.tpl")
<style>
	.img{width: 200px; height: 150px; margin-left: 10px;}
	.chec{height: 150px; line-height: 150px;}
	.checs{height: 50px; line-height: 50px;}
	.add{cursor: pointer;}
	.jian{cursor: pointer; color: red;font-weight: bolder;}
	
</style>
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICleft.tpl")
<div  style="margin: 0 auto;width: 800px;">
    	<form action="/userPhoto/editPhoto" method="post" enctype="multipart/form-data">
            <div class="actboxlist">
                <label class="btnBg">照片信息</label>
                <hr/>
                <div class="actbox8 ">
                <input type="hidden" name="id" id="pid" value="$!{Photo.id}">
                <input type="hidden" name="userId"  value="$!{Photo.userId}">
                    <table class="table100 usertable" style="width: 800px; height: 260px;">
                        <tr>
                        	<th style="width: 120px;">图片：</th>
                        	<td>
                        	<div class="checs">
                        		<input type="button" id="checkall" class="btnBg" style="width: 90px;" name="checkall" value="全选" />
                        		<input type="button" id="delcheckall" class="btnBg" style="width: 90px;" name="delcheckall" value="取消全选" />
                        		<input type="button" id="modify" class="btnBg" style="width: 90px;" value="编辑" />
                        		<input type="button" id="delete" class="btnBg" style="width: 90px;" value="删除" />
                        		<input type="button" id="save" class="btnBg add" style="width: 90px;" value="添加" />
                        	</div>
                        	<div id="img"></div>
                        	<input type="hidden" id="urls" value="$!Photo.photoUrl"/>
                        	</td>
                        </tr>
                    </table>
                </div>
            </div><input type="hidden" name="deleteUrl" id="deleteUrl"/>
            <input type="submit" value="保存" class="btnBg"/>
            <input type="button" onclick="window.history.go(-1)" value="取消" class="btnBg btnBg1"/>
        </form>
    </div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	//追加图片
	$("#save").click(function(){
			$("#img").append("<input type='file' name=pic style='border:1px solid #CCC;width: 170px;margin-bottom: 10px;' />&nbsp;&nbsp;<a class='jian'>--</a><br/>");
		});
	//删除
	
	$(document).on('click','.jian',function(){
		 $(this).prev().remove(); 
		 $(this).remove();
	});
	//循环显示图片
	var urls=$("#urls").val();
	var strs= new Array(); //定义一数组 
	if(urls!=""){
		strs=urls.split(",");
		for(var i=0;i<strs.length;i++){
	        if(strs!=""){
	           $("#img").append("<input name='checkname' class='chec' type='checkbox'/><img class='img' src='/gds/"+strs[i]+"' /><br/>");
	     	}
	     }
	}
	//全选/取消全选
	$("#checkall").click(function(){
		$(":checkbox").prop("checked",true); 
	}); 
	$("#delcheckall").click(function() { 
		$(":checkbox").prop("checked",false); 
	}); 
	/* //获取选中的项
	$(":checkbox:checked"); */
	//删除
	$("#delete").click(function(){
		var size=$(":checkbox:checked").length;
		var url= new Array();
		if (size>0) {
			for(var k= 0; k <size; k++) {
				var urls=$(":checkbox:checked").eq(k).next().attr("src");
				urls=urls.replace("/gds/","");
				url.push(urls);
			}
			var pid=$("#pid").val();
			 $.ajax({
		   		url:"/userPhoto/delete?id="+pid+"&url="+url,
		   		type:"get",
		   		//data:{"id":pid,"url":url+"bbbb"},
		   		success: function(result){
							var res = String($.trim(result)); 
							if(res=="OK"){ 
								alert("删除成功");
								window.location.reload();
							}else{ 
								alert("删除失败");
							} 
				} 
		   	});
		}else{
			alert("请至少选择一个进行删除！");
		}
	});
	//编辑
	$("#modify").click(function(){
		var url= new Array();
		var size=$(":checkbox:checked").length;
		if (size>0) {
			for(var j=0;j<size;j++){
				var urls=$(":checkbox:checked").eq(j).next().attr("src");
				urls=urls.replace("/","");
				url.push(urls);
				 $("#img").append("<input type='file' name=pic style='border:1px solid #CCC;width: 170px;margin-bottom: 10px;' /><br/>");
			}
			$("#deleteUrl").val(url);
		}else{
			alert("请至少选择一个进行编辑！");
		}
	});
	
	
});
</script>
</html>