<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>编辑客户信息</title>
#parse("/common/top.tpl")
<style type="text/css">
	.add{cursor: pointer;}
	.jian{cursor: pointer; color: red;font-weight: bolder;}
</style>
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICleft.tpl")
<div  style="margin: 0 auto;width: 800px;">
    <div>
    	<form action="/userPhoto/addPhoto" method="post" enctype="multipart/form-data">          	
            <div class="actboxlist">
                <label class="btnBg">照片信息</label>
                <hr/>
                <div class="actbox8 ">
                <input type="hidden" name="userId" value="$!ICUser.id" />
                <input type="hidden" name="id" value="$!{Photo.id}">
                    <table class="table100 usertable"  style="width: 800px; height: 260px;" >
                        <tr>
                        	<th>姓名：</th>
                        	<td><input type="text" name="createdBy" autocomplete="off"/></td>
                        </tr>
                         <tr>
                         	<th>图片名称：</th>
                        	<td><input type="text" name="photoName" autocomplete="off"/></td>
                        </tr>
                         <tr>
                         	<th>图片描述：</th>
                        	<td><textarea name="photoDesc" cols="40" rows="5"></textarea></td>
                        </tr>
                        <tr>
                        	<th>图片：</th>
                        	<td>
                        		<input type="file" name="pic"  style="border:1px solid #CCC; width: 170px; margin-bottom: 10px;"/><a class="add">+</a>
                     			 <div id="demo"></div>
                        	</td>
                        </tr>
                    </table>
                    <input type="submit" value="保存" class="btnBg save"/>
                     <input type="button" onclick="window.history.go(-1)" value="取消" class="btnBg1 btnBg save"/>
                </div>
            </div>
            </form>
        </div>
        
    </div>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$(".add").click(function(){
			$("#demo").append("<input type='file' name=pic style='border:1px solid #CCC;width: 170px;margin-bottom: 10px;' />&nbsp;&nbsp;<a class='jian'>--</a><br/>");
		});
		//删除
		$(document).on('click','.jian',function(){
		 $(this).prev().remove(); 
		 $(this).remove();
		});
	});
</script>
</html>