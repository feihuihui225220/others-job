$(function(){
	
	$('.add_class').click(function(){
		var id=$('#id_').val();
		if(id!="$nProgram.id"){
			location.href="/professional/fete/toAdd?id="+id;
		}else{
			alert("暂无课程分类！");
		}
			
	});
});

$(function(){
	$('.add_div').hide();
	$('.add_').click(function(){
		$('.add_div').toggle()
	})
	$('._quxiao').click(function(){
		location.href="/professional/fete";
		
	})
	//监听input value  获取专业老师信息
	parentId.oninput = function() {
		console.info(this);
		 var $title = $.trim(this.value);
		if($title!=""){
		$.ajax({
			url : "/professional/fete/SubjectTeacher?name=" + this.value,
			type : "get",
			success : function(json) {
				$('.n_tea').html("");
				var mjson = eval("(" + json + ")");
				var length = mjson.length;
				for (var i = 0; i < length; i++) {
					var li = $("<li  class='n_li'  date-id="
							+ mjson[i].id + ">"
							+ mjson[i].name + "</li>");
					$('.n_tea').append(li);
				}
			}
		});
		}else{
			$('.n_li').remove();
		}
	}
	//添加专业老师
	$('.n_tea').on('click','li',function(){
		var id=$(this).attr('date-id');
		var name=$(this).html();
		var div=$('<div class=div_1 date-id='+ id + '>'+name+'</div>');
		$('.n_teacher').append(div);
		$(this).remove();
		
		
	});
	
	$('.n_t1').on('click','li',function(){
		var id=$(this).attr('date-id');
		var name=$(this).html();
		var div=$('<div class="btn-default see_ add_first btn" date-id='+ id + '>'+name+'</div>');
		$('.r_teacher').append(div);
		$(this).remove();
		
	});
	
	$('.r_teacher').on('click','div',function(){
		//alert($('.see_').size());
		if($('.see_').size()>1){
			$(this).remove();
		}else{
			alert("专业老师人数不能小于1人！");
		}
			
	});
	$('.n_teacher').on('click','div',function(){
		$(this).remove();
	});
	
	$('#vo_submit').click(function(){
		var ids="";
		$div = $('.n_teacher').children('div');
		$div.each(function(){
			var id=$(this).attr("date-id");
			ids+=id;
			ids+=",";
		});
		if(ids.length!=0){
			ids=ids.substr(0,ids.length-1);
		}
		$('input[name="subjectTeacher"]').val(ids); 
		var programName = $('input[name="programName"]').val(); 
		var subjectTeacher = $('input[name="subjectTeacher"]').val(); 
		if(programName!=null&&programName!=""&&subjectTeacher!=null&&subjectTeacher!=""){
			$('#parentAdd').submit();
		}else{
			
			alert("请检查必填项是否正确！");
		}
		return false;
	})
	//查询分类下的所有节目
	$('.discipline ').bind('click',function(){
		var id=$(this).attr('date-id');
		location.href="/professional/fete/programSelect?id="+id;
	});
	//修改课程说明以及专业老师
	$('.dis_a2').click(function(e){
		  var id=$(this).attr('date-id');
		  location.href="/professional/fete/subUpdate?id="+id;
		  e.stopPropagation();//阻止冒泡
	});
	$('.success_1').click(function(){
		var id=$('#id_').val();
		var ids="";
		$div = $('.r_teacher').children('div');
		$div.each(function(){
			var id=$(this).attr("date-id");
			ids+=id;
			ids+=",";
		});
		if(ids.length!=0){
			ids=ids.substr(0,ids.length-1);
		}
		var text=getContent();
		$.ajax({
			url : "/professional/fete/parentUpdate?id=" + id+"&subjectTeacher="+ids+"&programDesc="+text,
			success : function(json) {
					alert(json);
			}
		});
	});
});

/**
 * <script type="text/javascript">
	*	//添加
	*	$(function(){
	*		$('#verify').click(function(){
	**		 var val1=$('#u31_input').val().replace(/\s+/g,"");
		*	 var val2=$('#u34_input').val().replace(/\s+/g,"");
		*	 if(val1!=""&&val2!=""){
		*		$('#from1').submit();								 
		**	}else{
			*	alert("请填写");
			*	return false;
	*		}
	*		});
	*	});
	*</script>
*/