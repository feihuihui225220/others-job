<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>评估_组合题</title>
	#parse("/common/top.tpl")
    <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css"/>
	   
    <link rel="stylesheet" href="$request.contextPath/assets/css/common.css"/>
	<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
	<style>
		.b_left{float:left;}
		.hello{margin-right:50px;}
	</style>
</head>

<div class="wrapper">
  
    <div class="body">
<div class="ql"></div>
        <div class="bodyline clearfix pad10 fstb">
          <table class="table100 usertable cen">
            <tr style="background-color:#DFF0D8">
              <th>评估量表名称</th>
              <th><div id="u98">
                <div id="u98_rtf">
                  <p>分级名称</p>
                </div>
              </div></th>
            </tr>
          </table>
        </div><br>
        <div class="bodyline clearfix pad10 fsrad" >
        <div class="fsradchild">
        	<labe>评估结论</label><br/><br/>
        </div>
         
          	<br><br>等级变更依据<br>
          	1.有认知障碍/痴呆、精神疾病者，在原有能力级别上提高一个等级；<br>
			2.近30天内发生过2次及以上跌倒、噎食、自杀、走失，在原有能力级别上提高一个等级；<br>
			3.处于昏迷状态者，直接评定为重度失能；<br>
			4.若初步等级确定为“重度失能”，则不考虑上述1-3中各情况，等级不再提高。<br>    
        </div>

<form method="post" action="/professional/assess/record/commit" class="sb">
    <input type="hidden" name="conId" value="" id="id"/>
    <input type="hidden" name="conContent" value="" id="cont"/>
    <input type="hidden" name="details" value="" id="detail" />
    <input type="hidden" name="assessId" value="${record.assessId}"/>
    <input type="hidden" name="assessName" value="${record.assessName}"/>
    <input type="hidden" name="userId" value="${record.userId}"/>
    <input type="hidden" name="serviceId" value="${serviceId}"/>
    <p class="opt pad10 admin_cate_opt ">
         <button type="submit" class="btn  button_add" disabled="disabled" style="color:#999">完 成</button>
         <button type="button" class="btn button_fan" onClick="window.location='/professional/vender/user/detail/${record.userId}'">返 回</button><!--window.top.location.reload();-->
    </p>
</form>
        
        
    </div>
    <div class="footer"></div>
</div>

<script>

$.ajax({
    url:        '/professional/assess/recordInfo?assessId='+location.href.match(/\d+/g)[location.href.match(/\d+/g).length-1],
    //url:        'http://114.251.187.73:8080/professional/assess/recordInfo?assessId=45',
    dataType:   'jsonp',
    jsonp:      'callback',
    success:    function (json) {
        $('.ql').html('');
        if (json.code == 0) {
            if (json.data[0].type == 1) {
                //console.log(json.data[0].assessVOs[0].qaList.length)
                var arr = [];
                for (var i=0; i<json.data[0].assessVOs.length; i++) {
	                    (function (index) {
	                        var str2 = '';
		                        for (var m=0; m<json.data[0].assessVOs[index].qaList.length; m++) {
		                            	var str = '';
			                            for (var j=0; j<json.data[0].assessVOs[index].qaList[m].answers.length; j++) {
			                                if(json.data[0].assessVOs[index].qaList[m].assessType==true){
			                                	if(json.data[0].assessVOs[index].qaList[m].answers[j].content=="填写项"){
			                               	 		str += '<label class="i_height"><input type="radio" name=a'+json.data[0].assessVOs[index].qaList[m].id+' data-id="'+json.data[0].assessVOs[index].qaList[m].answers[j].id+'" data-value="'+json.data[0].assessVOs[index].qaList[m].answers[j].score+'"> '+json.data[0].assessVOs[index].qaList[m].answers[j].code+' '+'<input  class=sight_paymen type=text/></label><br>'
		                                		}else{
			                               	 	str += '<label class="i_height"><input type="radio" name=a'+json.data[0].assessVOs[index].qaList[m].id+' data-id="'+json.data[0].assessVOs[index].qaList[m].answers[j].id+'" data-value="'+json.data[0].assessVOs[index].qaList[m].answers[j].score+'"> '+json.data[0].assessVOs[index].qaList[m].answers[j].code+' '+json.data[0].assessVOs[index].qaList[m].answers[j].content+'</label><br>'
			                                	}
			                                }else{
			                                	if(json.data[0].assessVOs[index].qaList[m].answers[j].content=="填写项"){
			                               	 		str += '<label class="i_height"><input type="checkbox" name=a'+json.data[0].assessVOs[index].qaList[m].id+' value="'+json.data[0].assessVOs[index].qaList[m].answers[j].code+'" data-id="'+json.data[0].assessVOs[index].qaList[m].answers[j].id+'" data-value="'+json.data[0].assessVOs[index].qaList[m].answers[j].score+'"> '+json.data[0].assessVOs[index].qaList[m].answers[j].code+' '+'<input  class=sight_paymen type=text/></label><br>'
		                                		}else{
			                               	 	str += '<label class="i_height"><input type="checkbox" name=a'+json.data[0].assessVOs[index].qaList[m].id+' data-id="'+json.data[0].assessVOs[index].qaList[m].answers[j].id+'" value="'+json.data[0].assessVOs[index].qaList[m].answers[j].code+'" data-value="'+json.data[0].assessVOs[index].qaList[m].answers[j].score+'"> '+json.data[0].assessVOs[index].qaList[m].answers[j].code+' '+json.data[0].assessVOs[index].qaList[m].answers[j].content+'</label><br>'
			                                	}
			                                }
			                            }
			                            str2 +=
			                            '    <div  class="strong usertitle pad10 texts '+m+'">试题</div>'+
			                            '    <div class="i_result_list date_checked" date-checked="1" data-select="0" data-id="'+json.data[0].assessVOs[index].qaList[m].id+'">'+
			                            '        <p class="strong mgb10" data-name="'+json.data[0].assessVOs[index].qaList[m].content+'">'+json.data[0].assessVOs[index].qaList[m].content+'</p>'+str+
			                            '    </div>';
		                        }
		                        $('.ql').append(
		                            '<div class="bodyline clearfix pad10 fix_b2" date-num="0" style="margin-bottom:20px;">'+
		                            '    <div class="strong usertitle pad10 h_txt"><h2>'+json.data[0].assessVOs[index].name+'</h2></div>'+str2+
		                            '    <div class="admin_cate_opt"><button class=" button_add btn aa " disabled="disabled" style="color:#999" assess-id="'+json.data[0].assessVOs[index].id+'" assess-name="'+json.data[0].assessVOs[index].name+'">添 加</button></div>'+
		                            '</div>'
		                        )
	                      
	                        $('.fstb table').append('<tr><td>'+json.data[0].assessVOs[index].name+'</td><td></td></tr>');
	                    })(i);
                }
						$('.0').append("一");
                      	$('.1').append("二");
                      	$('.2').append("三");
                      	$('.3').append("四");
                      	$('.4').append("五");
                      	$('.5').append("六");
                      	$('.6').append("七");
                      	$('.7').append("八");
                      	$('.8').append("九");
                      	$('.9').append("十");
                for (var q=0; q<json.data[0].assessVOs.length; q++) {
                    arr[q] = [];
                    for (var j=0; j<json.data[0].assessVOs[q].cluList.length; j++) {
                        arr[q].push({lowerLimit: json.data[0].assessVOs[q].cluList[j].lowerLimit, upperLimit: json.data[0].assessVOs[q].cluList[j].upperLimit, content: json.data[0].assessVOs[q].cluList[j].content, id: json.data[0].assessVOs[q].cluList[j].id});
                    }
                }

                for (var p=0; p<json.data[0].cluList.length; p++) {
                    $('.sb').append('<input class="user_sel" type="hidden" name="user_sel" value="">');
                   
                    $('.fsradchild').append('<label class="hello"><input  name=sel type=radio id='+json.data[0].cluList[p].id+' value='+json.data[0].cluList[p].content+' class="input_add" /> '+json.data[0].cluList[p].content+'</label>');
                }
				
				
			
                $('input').live('click', function () {
                 	var num=0
                	if($(this).attr("type")=="radio"){
		               if($(this).parent().parent().attr("date-checked")==1){
		               	 	num=$(this).parent().parent().parent().attr("date-num");
		               	 	num++;
                     	  $(this).parent().parent().parent().attr("date-num",num);
		               }
		               
                   		$(this).parent().parent().attr("date-checked","0");
		               
                   }else if($(this).attr("type")=="checkbox"){
                   		if($(this).parent().parent().attr("date-checked")==1){
                     	  num=$(this).parent().parent().parent().attr("date-num");
                     	  num++;
                     	  $(this).parent().parent().parent().attr("date-num",num);
                   		}
                   		$(this).parent().parent().attr("date-checked","0");
                   }
                   num=$(this).parent().parent().parent().attr("date-num");
	              if(num>= $(this).parents('.fix_b2').find('.i_result_list').length){
                      $(this).parents('.fix_b2').find('button').css('color', '#000').removeAttr('disabled');
                  }
                });
                //社会参与
				var she;
                //感知觉与沟通
				var gan;
                //精神状况
				var jing;
                //日常生活活动
				var richang;
                var detail = [];
                $('.aa').live('click', function () {
                    $('.sight_paymen').each(function(){
                		$(this).val($(this).val().replace(/[ ]/g,"")); 
                		if($(this).val()!=""){
                			$(this).parent().append($(this).val());
                			$(this).remove();
                		}
                	});
                    var num = 0;
                    var result = [];
                   
                    //console.log($(this).parent().parent().index());
                    $(this).parent().parent().find('input[type=radio]').each(function () {
                        if($(this).prop('checked')) {
                            num+=parseInt($(this).attr('data-value'));
                            result.push('{question_id:"'+$(this).parents('.i_result_list').attr('data-id')+'", question_name:"'+$(this).parents('.i_result_list').find('p').attr('data-name')+'",answer_id:"'+$(this).attr('data-id')+'", answer_name:"'+$(this).parent().text().substring(3)+'", code:"'+$(this).parent().text().substring(1,2)+'", score:"'+$(this).attr('data-value')+'"}');
                        }
                    });
                    var n=1;
                    $(this).parent().parent().find('input[type=checkbox]').each(function () {
                        if($(this).val()=="A"){
                    		n=0;
                    	}
                        if($(this).prop('checked')) {
                        	if(n==0){
                         			 num+=parseInt($(this).attr('data-value'));
                         			 n++;
                            		 result.push('{question_id:"'+$(this).parents('.i_result_list').attr('data-id')+'", question_name:"'+$(this).parents('.i_result_list').find('p').attr('data-name')+'",answer_id:"'+$(this).attr('data-id')+'", answer_name:"'+$(this).parent().text().substring(3)+'", code:"'+$(this).parent().text().substring(1,2)+'", score:"'+$(this).attr('data-value')+'"}');
                         		}else{
                         		 	num+=parseInt($(this).attr('data-value'));
                         			n++;
                         			result.push('{answer_id:"'+$(this).attr('data-id')+'",answer_name:"'+$(this).parent().text().substring(3)+'", code:"'+$(this).parent().text().substring(1,2)+'", score:"'+$(this).attr('data-value')+'"}');
                         		}
                        }
                    });

                    for (var i=0; i<arr[$(this).parent().parent().index()].length; i++) {
                        if (num>=arr[$(this).parent().parent().index()][i].lowerLimit && num<=arr[$(this).parent().parent().index()][i].upperLimit) {
                            $('.fstb tr:eq('+($(this).parent().parent().index()+1)+')').find('td:eq(1)').html(arr[$(this).parent().parent().index()][i].content);
                            detail.push('{assessId:"'+$(this).attr('assess-id')+'",assessName:"'+$(this).attr('assess-name')+'",result:['+result+'],conclusion:"'+arr[$(this).parent().parent().index()][i].content+'"}');
                   			var content1=arr[$(this).parent().parent().index()][i].content;
                   			var name=$(this).attr('assess-name');
                   			if(name=="社会参与"){
                   				if(content1=="轻度受损"){
                   					she=1;
                   					}else if(content1=="能力完好"){
                   					she=0;
                   					}else if(content1=="中度受损"){
                   					she=6;
                   					}else if(content1=="重度受损"){
                   					she=20;
                   					}
                   			}else if(name=="感知觉与沟通"){
                   				if(content1=="轻度受损"){
                   					gan=2;
               					}else if(content1=="能力完好"){
                   					gan=0;
               					}else if(content1=="中度受损"){
                   					gan=6;
               					}else if(content1=="重度受损"){
                   					gan=20;
               					}
                   			}else if(name=="精神状态 "){
                   				if(content1=="轻度受损"){
                   					jing=2;
               					}else if(content1=="能力完好"){
                   					jing=0;
               					}else if(content1=="中度受损"){
                   					jing=6;
               					}else if(content1=="重度受损"){
                   					jing=20;
	                   			}
                   			}else if(name=="日常生活能力"){
                   				if(content1=="轻度受损"){
                   					richang=55;
                   					}else if(content1=="能力完好"){
                   					richang=0;
                   					}else if(content1=="中度受损"){
                   					richang=100;
                   					}else if(content1=="重度受损"){
                   					richang=120;
	                   			}
                   			}
                        }
                    }
                    
                    $('#detail').val('['+detail+']');
                    $(this).remove();
					
                    if ($('.aa').length == 0) {
                        $('.admin_cate_opt .btn').removeAttr('disabled').css('color', '#000');
                        $('.fsrad').show();
                        $('.sb').show();
                        $('.hello').each(function () {
                        	var dengji=richang+she+jing+gan;
							if(dengji<=1&&dengji>=0){
								if($(this).text()==" 能力完好"){
									$(this).find('input').attr('checked','true');
								}
							}else if(dengji<=60&&dengji>=2){
								if($(this).text()==" 轻度失能"){
									$(this).find('input').attr('checked','true');
								}
							}else if(dengji<=119&&dengji>=61){
								if($(this).text()==" 中度失能"){
									$(this).find('input').attr('checked','true');
								}
							}else if(dengji>=120){
								if($(this).text()==" 重度失能"){
									$(this).find('input').attr('checked','true');
								}
							}
						});
						add();
                    }
                });
				
                $('.fsradchild input').live('click', function () {
                    $('.sb input:eq(0)').val(parseInt($(this).attr('id')));
                    $('.sb input:eq(1)').val($(this).parents('label').text());
                    
                });
                
            }
        }
    }
});
function add(){
	var item = $('input[name=sel][checked]').attr('id');
	var val = $('input[name=sel][checked]').val();
	$('.sb input:eq(0)').val(item);
    $('.sb input:eq(1)').val(val);
}
$(function(){
	$('.hidden').hide();
})

</script>

</body>
</html>