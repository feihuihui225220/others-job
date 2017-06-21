<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户信息</title>
    <link rel="stylesheet" type="text/css" href="../assets/director/style/userFiling.css">
</head>

<body>

  #parse("/common/dtop.tpl")
    #parse("/common/duser.tpl")
<div class="main1">
  <div>
	<div class="contentPer">#parse("/common/dleft.tpl")</div>
    <div class="personInfo_right fl" style="float: left;">
      <div class="personInfo_righttop">
        <label>建档医生:</label>
        <label class="marginleft15">$!user.rUserDefault.doctor</label>
        <label class="marginleft75">建档护士:</label>
        <label class="marginleft15">$!user.rUserDefault.nurse</label>
        <label class="marginleft75">建档日期:</label>
        <label class="marginleft15">$!date.format('yyyy-MM-dd',$!user.createdAt)</label>
        <button type="button" class="btnBg btn button_delete" style="margin-left:200px;" onClick="javascript:window.history.go(-2)">返 回</button>
      </div>
      <div class="personInfo_rightbottom">
      	<div class="strong usertitle pad10">试题</div>
            <div class="ql">
            </div>
            <form name="form1" method="post" action="/director/assess/record/commit">
                <div class="admin_cate_opt">
                    <button class="btnBg1 btnBg  btn aa " id="commit"  type="button" style=" float:right;" disabled="disabled">提 交</button>
                    <span id="questions" style="float:right;"></span>
                    <span id="note" style="float:right;">未完成问题：</span>
                </div>
                <div class="bodyline pad10">
                    <p class="strong usertitle pad10">
                        结论
                    </p>
                    <p class="sum bb">
                        分数：<b>0</b>分
                    </p>
                    <p class="sum">
                        分集名称：<span></span>
                    </p>
                    <input type="hidden" name="assessId" value="145"/>
                    <input type="hidden" name="assessName" value="建档评估量表"/>
                    <input type="hidden" name="userId" value="$userId"/>
                    <input type="hidden" name="serviceId" value="${serviceId}"/>
                    <input type="hidden" name="conId" value="" id="aid" />
                    <input type="hidden" name="conContent" value="" id="acon" />
                    <input type="hidden" name="details" value="" id="detail" />
                    <p class="opt pad10 admin_cate_opt">
                        <button type="submit" id="sub1" class="btnBg btn button_btn button_gm" style="color:#999" disabled="disabled">完 成</button>
                        <button type="button" class="btnBg btn button_delete" onClick="javascript:window.history.go(-2)">返 回</button>
                    </p>
                </div>
            </form>
        </div>
      </div>
    </div>
  </div>
   </div>
</body>
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script>
    var option_names=[];//用于验证是否回答了全部问题
    var names_arr=[];
    $.ajax({
        url:        '/professional/assess/recordInfo?assessId=145',
        //url:        'http://10.1.11.92:8080/professional/assess/recordInfo?assessId=43',
        dataType:   'jsonp',
        jsonp:      'callback',
        success:    function (json) {
        	
            $('.ql').html('');
            if (json.code == 0) {
                if (json.data[0].type == 0) {
                    //console.log(json.data[0].qaList.length)
                    var arr = [];
                    var assessId = json.data[0].id;
                    var assessName = json.data[0].name;
                    var n=0;
                    for (var i=0; i<json.data[0].qaList.length; i++) {
                        (function (index) {
                            var str = '';
                          // alert(json.data[0].qaList[i].picture);
                            for (var j=0; j<json.data[0].qaList[index].answers.length; j++) {

                                var answers_j = json.data[0].qaList[index].answers[j];
                                
                                if(json.data[0].qaList[index].assessType==true){
                                    
                                    str += '<label class="i_height"><input class="input_add" type="radio"  data-poet="'+answers_j.content+'" value="'+answers_j.code+'" name=a'+json.data[0].qaList[index].id+' data-id="'+answers_j.id+'" data-value="'+answers_j.score+'"> '+answers_j.code+'<text class="text_delete"> '+answers_j.content+'</text></label><br>'
                                }else{
                                    str += '<label class="i_height"><input class="input_add" type="checkbox" data-poet="'+answers_j.content+'"  value="'+answers_j.code+'" name=a'+json.data[0].qaList[index].id+' data-id="'+answers_j.id+'" data-value="'+answers_j.score+'"> '+answers_j.code+'<text class="text_delete"> '+answers_j.content+'</text></label><br>'
                                }
                                //用于验证是否回答了全部问题
                                var name_exist=0;
                                option_names.forEach(function(e){
                                    if(e == json.data[0].qaList[index].id){
                                        name_exist++;
                                    }
                                });
                                if(name_exist==0){
                                    option_names[j] = json.data[0].qaList[index].id;
                                }
                                name_exist=0;
                            }
                            //用于验证是否回答了全部问题
                            option_names.forEach(function(e,i,array){
                                option_names[i]="a"+e;
                            });
							if(json.data[0].qaList[index].picture!=null&&json.data[0].qaList[index].picture!=""){
								$('.ql').append(
                                    '<div class="i_result_list" data-select='+(i+1)+' data-id="'+json.data[0].qaList[index].id+'">'+
                                    '<p class="strong mgb10" data-name="'+json.data[0].qaList[index].content+'">'+(i+1)+'.'+json.data[0].qaList[index].content+'</p><p><img  src="'+json.data[0].qaList[index].picture+'"></p>'+str+
                                    '</div>'
                            	)
							}else{
								$('.ql').append(
                                    '<div class="i_result_list" data-select='+(i+1)+' data-id="'+json.data[0].qaList[index].id+'">'+
                                    '<p class="strong mgb10" data-name="'+json.data[0].qaList[index].content+'">'+(i+1)+'.'+json.data[0].qaList[index].content+'</p>'+str+
                                    '</div>'
                            	)
							
							}
                            

                        })(i);
                        
                        $('.input_add').each(function(){
							
						});
                        $("#questions").append(i+1+",");
                        names_arr.push(0);
                        n++;
                    }

                    for (var j=0; j<json.data[0].cluList.length; j++) {
                        arr.push({lowerLimit: json.data[0].cluList[j].lowerLimit, upperLimit: json.data[0].cluList[j].upperLimit, content: json.data[0].cluList[j].content, id: json.data[0].cluList[j].id});
                        //console.log(arr);
                    }

                    $('.input_add').live('click', function () {
                        var num = 0;
                      
                        if($(this).next(".text_delete").html()==" 填写项"){
								$(this).parent().append($("<input class='sight_paymen' type='text'/>"));
								$(this).next(".text_delete").html(" ");
							}
                        
                        
                        $(this).parents('.i_result_list').attr('data-select');
                        $(this).parents('.ql').find('.i_result_list').each(function () {
//                     	 num+=1;
                        });
                        $(this).parents('.i_result_list').find('input').each(function (i, e) {
                            if (e.checked) {
                                num++;
                            }
                        });
                        var question_num = $(this).parents('.i_result_list').attr("data-select");
                        if (num > 0) {
                            question_num=question_num-1;
                            names_arr[question_num]++;
                            if(names_arr[question_num]==1){
                                question_num++;
                                $("#questions").text($("#questions").text().replace(question_num+",", ""));
                            }
                        } else {
                            $("#questions").append(question_num + ",");
                        }
						
						var question_1=$("#questions").text();
						var reg =  /[0-9]+/;
                        if(reg.test(question_1)){
                            $("#commit").attr("disabled","disabled");
                        }else{
                        	$("#commit").removeAttr("disabled");
                        	$("#commit").removeClass("btnBg1");
                        	$("#commit").css('color','#FFF')
                        }
                        num = 0;
                    });

                var detail = [];
                $('.aa').click(function () {
                	$('.sight_paymen').each(function(){
                	
                		$(this).parent().append($(this).val());
                		$(this).remove();
                	});
                
                    var num = 0, str = '';
                     var n= 0;
                    var result = [];
                    $('input').each(function () {//  $('input[type=radio]').each(function () {
                    	if($(this).val()=="A"){
                    		n=0;
                    	}
                        if($(this).prop('checked')) {
                         
                          	if(this.type=="checkbox"){
                         		if(n==0){
                         			 
                         			 num+=parseInt($(this).attr('data-value'));
                         			 n++;
                            		 result.push('{question_id:"'+$(this).parents('.i_result_list').attr('data-id')+'", question_name:"'+$(this).parents('.i_result_list').find('p').attr('data-name')+'",answer_id:"'+$(this).attr('data-id')+'", answer_name:"'+$(this).parent().text().substring(3)+'", code:"'+$(this).parent().text().substring(1,2)+'", score:"'+$(this).attr('data-value')+'"}');
                         			
                         		}else{
                         			
                         		 	num+=parseInt($(this).attr('data-value'));
                         			n++;
                         			result.push('{answer_id:"'+$(this).attr('data-id')+'",answer_name:"'+$(this).parent().text().substring(3)+'", code:"'+$(this).parent().text().substring(1,2)+'", score:"'+$(this).attr('data-value')+'"}');
                         		}
                        	}else{
                        			
                         			 num+=parseInt($(this).attr('data-value'));
                         			 
                         			 
                         			 n=0;
                           			 result.push('{question_id:"'+$(this).parents('.i_result_list').attr('data-id')+'", question_name:"'+$(this).parents('.i_result_list').find('p').attr('data-name')+'",answer_id:"'+$(this).attr('data-id')+'", answer_name:"'+$(this).parent().text().substring(3)+'", code:"'+$(this).parent().text().substring(1,2)+'", score:"'+$(this).attr('data-value')+'"}');
                         		} 
                         		
                     		
                         		
                         }
                    });
                    $('.bb b').html(num);
                    $(this).remove();
                    $('#note').text("已经提交。");
					$('#sub1').removeAttr("disabled");
                    for (var i=0; i<arr.length; i++) {
                        if (num>=arr[i].lowerLimit && num<=arr[i].upperLimit) {
                            $('.sum span').html(arr[i].content);
                            $('#aid').val(arr[i].id);
                            $('#acon').val(arr[i].content);
                        }
                    }
                    
                    detail.push('{assessId:"'+assessId+'",assessName:"'+assessName+'",result:['+result+'],conclusion:"'+$('#acon').val()+'"}');
                    console.log(detail)
                    $('#detail').val('['+detail+']');

                    $('.admin_cate_opt .btn').removeAttr('disabled').css('color', '#000');

                });


            }
        }
    }
});
		

</script>
</html>
