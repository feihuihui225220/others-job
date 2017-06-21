$(function(){
	$('#province').change(function(){
		var province=$(this).val();
		$('.option2').remove();
		$('.option3').remove();
		$('.option4').remove();
		$('.option5').remove();
		$.ajax({
				type:'post',
                url:"/community/getCountry/"+province,
                dataType:'json',
                success:function(data){
                	for(var i=0;i<data.countrys.length;i++){
                		var option=$('<option class="option2" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
                		$('#city').append(option);
                	}
                }
			});
		//("#select1").val();
		
	});
	$('#city').change(function(){
		var province=$(this).val();
		$('.option3').remove();
		$('.option4').remove();
		$('.option5').remove();
		$.ajax({
				type:'post',
                url:"/community/getCountry/"+province,
                dataType:'json',
                success:function(data){
                	for(var i=0;i<data.countrys.length;i++){
                		var option=$('<option class="option3" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
                		$('#region').append(option);
                	}
                }
			});
	});
	$('#region').change(function(){
		var province=$(this).val();
		$('.option4').remove();
		$('.option5').remove();
		$.ajax({
				type:'post',
                url:"/community/getCountry/"+province,
                dataType:'json',
                success:function(data){
                	for(var i=0;i<data.countrys.length;i++){
                		var option=$('<option class="option4" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
                		$('#street').append(option);
                	}
                }
			});
	});
	$('#street').change(function(){
		var province=$(this).val();
		$('.option5').remove();
		$.ajax({
				type:'post',
                url:"/community/getCountry/"+province,
                dataType:'json',
                success:function(data){
                	for(var i=0;i<data.countrys.length;i++){
                		var option=$('<option class="option5" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
                		$('#community').append(option);
                	}
                }
			});
	});
});

	$(function(){
		$.ajax({
				type:'post',
                url:"/community/getCountry/0",
                dataType:'json',
                success:function(data){
                	for(var i=0;i<data.countrys.length;i++){
                		var option=$('<option class="option1" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
                		$('#province').append(option);
                	}
                	$('.option1').each(function () {
					    var $option = $(this);
					    var value = $option.val();
					    //alert('显示的是' + html + '\n值是' + value);
					    if(value==1){
					    	$(this).attr("selected",true)
					    }
					});
                }
			});
			$.ajax({
				type:'post',
                url:"/community/getCountry/1",
                dataType:'json',
                success:function(data){
                	for(var i=0;i<data.countrys.length;i++){
                		var option=$('<option class="option2" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
                		$('#city').append(option);
                	}
                	$('.option2').each(function () {
					    var $option1 = $(this);
					    var value1 = $option1.val();
					    var html = $option1.html();
					    if(value1==35){
					    	$(this).attr("selected",true)
					    }
					});
                }
			});
			$.ajax({
				type:'post',
                url:"/community/getCountry/35",
                dataType:'json',
                success:function(data){
                	for(var i=0;i<data.countrys.length;i++){
                		var option=$('<option class="option3" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
                		$('#region').append(option);
                	}
                }
			});	
	});
	
//---------------------------------------------------------------------------------------------------------------------------------------------------
	
	$(function(){
		$('#province_1').change(function(){
			var province=$(this).val();
			$('.option2_').remove();
			$('.option3_').remove();
			$('.option4_').remove();
			$('.option5_').remove();
			$.ajax({
					type:'post',
	                url:"/community/getCountry/"+province,
	                dataType:'json',
	                success:function(data){
	                	for(var i=0;i<data.countrys.length;i++){
	                		var option=$('<option class="option2_" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
	                		$('#city_1').append(option);
	                	}
	                }
				});
			//("#select1").val();
			
		});
		$('#city_1').change(function(){
			var province=$(this).val();
			$('.option3_').remove();
			$('.option4_').remove();
			$('.option5_').remove();
			$.ajax({
					type:'post',
	                url:"/community/getCountry/"+province,
	                dataType:'json',
	                success:function(data){
	                	for(var i=0;i<data.countrys.length;i++){
	                		var option=$('<option class="option3_" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
	                		$('#region_1').append(option);
	                	}
	                }
				});
		});
		$('#region_1').change(function(){
			var province=$(this).val();
			$('.option4_').remove();
			$('.option5_').remove();
			$.ajax({
					type:'post',
	                url:"/community/getCountry/"+province,
	                dataType:'json',
	                success:function(data){
	                	for(var i=0;i<data.countrys.length;i++){
	                		var option=$('<option class="option4_" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
	                		$('#street_1').append(option);
	                	}
	                }
				});
		});
		$('#street_1').change(function(){
			var province=$(this).val();
			$('.option5_').remove();
			$.ajax({
					type:'post',
	                url:"/community/getCountry/"+province,
	                dataType:'json',
	                success:function(data){
	                	for(var i=0;i<data.countrys.length;i++){
	                		var option=$('<option class="option5_" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
	                		$('#community_1').append(option);
	                	}
	                }
				});
		});
	});


		$(function(){
			$.ajax({
					type:'post',
	                url:"/community/getCountry/0",
	                dataType:'json',
	                success:function(data){
	                	for(var i=0;i<data.countrys.length;i++){
	                		var option=$('<option class="option1_" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
	                		$('#province_1').append(option);
	                	}
	                	$('.option1').each(function () {
						    var $option = $(this);
						    var value = $option.val();
						    //alert('显示的是' + html + '\n值是' + value);
						    if(value==1){
						    	$(this).attr("selected",true)
						    }
						});
	                }
				});
				$.ajax({
					type:'post',
	                url:"/community/getCountry/1",
	                dataType:'json',
	                success:function(data){
	                	for(var i=0;i<data.countrys.length;i++){
	                		var option=$('<option class="option2_" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
	                		$('#city_1').append(option);
	                	}
	                	$('.option2').each(function () {
						    var $option1 = $(this);
						    var value1 = $option1.val();
						    var html = $option1.html();
						    if(value1==35){
						    	$(this).attr("selected",true)
						    }
						});
	                }
				});
				$.ajax({
					type:'post',
	                url:"/community/getCountry/35",
	                dataType:'json',
	                success:function(data){
	                	for(var i=0;i<data.countrys.length;i++){
	                		var option=$('<option class="option3_" value="'+data.countrys[i].id+'">'+data.countrys[i].name+'</option>');
	                		$('#region_1').append(option);
	                	}
	                }
				});	
		});