<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>节目11</title>
<script src="$request.contextPath/assets/js/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<script src="/assets/js/bootstrap.min.js"></script>
<style>
	 a{color: black;}
	  body{background:#D9EBEB}
</style>
</head>
<body>
<br/>
 <button data-toggle="modal" data-target="#aaa" class="btn button_add">添加记录</button> 
 	<div>
 		<table class=" usertable cen table-hover">
 			<tr>
 				<th>服务记录</th>
 				<th>添加时间</th>
 				<th>添加人</th>
 				<th>操作</th>
 			</tr>
 			#foreach($n in $nServiceRecord)
 				<tr class="ibtn addadver">
		        			<td class="exhibition">$!{n.recordName}</td>
		        			<td class="exhibition">$!date.format('yyyy-MM-dd hh:mm:ss',$n.createdAt)</td>
		        			<td class="exhibition">$!{n.createdBy}</td>
		        			<td class="delete_td">
		        				<input type="hidden" value="$!{n.id}"/>
		        				<button  id=$!{n.id} class="delete button_delete">删除</button>
		        				<button   class="download button_gm">下载</button>
	        				</td>
		        		</tr>
 			#end
 		</table>
 	</div>  
 	<div id="aaa" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
	    <div class="modal-dialog">
			      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				          <h4 class="modal-title " id="myModalLabel">添加记录</h4>
				        </div>
				        <div class="modal-body">
			  			 <form role="form" id="addwordfrom" method="post" enctype="multipart/form-data" action="/professional/activity/addword">
										<input type="hidden" id="activityId" name="activityId"  value="$!activityId">
										<input type="hidden" id="pubdate" name="pubdate"  value="$!date.format('yyyy-MM-dd',$pubdate)"/>
										<div class="form-group">
										    <label>记录名称</label>
										    <input type="text" style="width:80%" class="form-control" name="recordName">
									  	</div>
										<div class="form-group">
										    <label>选择文件</label>
										   	<input type="file" style="width:80%" class="form-control" multiple name="pic" >
									  	</div> 
							</form>
				        </div>
					        <div class="modal-footer">
					          <button type="button" class="btn btn-default button_delete" style="float:right;margin-left:20px" data-dismiss="modal">取消</button>
					          <button type="button" class="btn btn-primary button_add" style="float:right" id="yes" onclick="addwordfrom()">确认</button>
					        </div>
			    		</div>
			</div>
		</div>
	</div>
<script>
	function addwordfrom(){
		$("#addwordfrom").submit();
	}
	$(function(){
		var activityId=$('#activityId').val();
		var pubdate=$('#pubdate').val();
		$('.exhibition').click(function(){
			//var id=$(this).siblings('.delete_td').find("input").val();
			//location.href="$request.contextPath/professional/activity/readWord?id="+id+"&activityId="+activityId+"&pubdate="+pubdate;
		});
		$('.delete').click(function(){
			location.href="$request.contextPath/professional/activity/deleteWord?id="+this.id+"&activityId="+activityId+"&pubdate="+pubdate;
		});
		$('.download').click(function(){
			var id=$(this).parent().find("input").val();
			location.href="$request.contextPath/professional/activity/download?id="+id+"&activityId="+activityId+"&pubdate="+pubdate;
		});
	});
</script>
</body>
</html>