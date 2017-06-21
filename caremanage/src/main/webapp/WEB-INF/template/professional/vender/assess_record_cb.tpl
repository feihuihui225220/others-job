<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>评估_组合题</title>
	#parse("/common/top.tpl")
	<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
	<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
	<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
	<style type="text/css">
		.ql>.fix_b2{
			display:none;
		}
		.ql>.fix_b2:nth-child(1){
			display:block;
		}
	</style>
</head>

<div class="wrapper">
    <div class="body">
        <div class="useractbox bodyline pad10">
		<div class="ql"></div>
        <div class="bodyline clearfix pad10 fstb">
          <table class="table100 usertable cen">
            <tr>
              <th>评估量表名称</th>
              <th><div id="u98">
                <div id="u98_rtf">
                  <p>分级名称</p>
                </div>
              </div></th>
            </tr>
          </table>
        </div><br>
        <div class="bodyline clearfix pad10 fsrad" style="display:none">
          <table class="table100 usertable cen">
            <tr>
              <th>评估量表名称</th>
              <th><div id="u98">
                <div id="u98_rtf">
                  <p>分级名称</p>
                </div>
              </div></th>
            </tr>
          </table>
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
         <button id="tijiao" type="submit" class="btn  button_gm" disabled="disabled" style="color:#999">完 成</button>
         <button type="button" class="btn button_gm" onClick="window.location='/professional/vender/user/detail/${record.userId}#2'">返 回</button>
    </p>
</form>
        
        
    </div>
    <div class="footer"></div>
</div>

<script>
$("#tijiao").click(function(){
	$("#tijiao").attr("disabled","disabled");
	$("#tijiao").css("color","#999");
	$(".sb").submit();
});

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
                                	if(json.data[0].assessVOs[index].qaList[m].answers[j].content!="填写项"){
                                	str += '<label class="i_height"><input class="input_add" type="radio" name=a'+json.data[0].assessVOs[index].qaList[m].id+' data-id="'+json.data[0].assessVOs[index].qaList[m].answers[j].id+'" data-value="'+json.data[0].assessVOs[index].qaList[m].answers[j].score+'"> '+json.data[0].assessVOs[index].qaList[m].answers[j].code+' '+json.data[0].assessVOs[index].qaList[m].answers[j].content+'</label><br>'
                                	}else{
                                	str += '<label class="i_height"><input class="input_add" type="radio" name=a'+json.data[0].assessVOs[index].qaList[m].id+' data-id="'+json.data[0].assessVOs[index].qaList[m].answers[j].id+'" data-value="'+json.data[0].assessVOs[index].qaList[m].answers[j].score+'"> '+json.data[0].assessVOs[index].qaList[m].answers[j].code+' <input class="findassess"></label><br>'
                                	}
                                }else{
                                	if(json.data[0].assessVOs[index].qaList[m].answers[j].content!="填写项"){
                                	str += '<label class="i_height"><input class="input_add checkboxa'+json.data[0].assessVOs[index].qaList[m].id+'" type="checkbox" name=a'+json.data[0].assessVOs[index].qaList[m].id+' data-id="'+json.data[0].assessVOs[index].qaList[m].answers[j].id+'" data-value="'+json.data[0].assessVOs[index].qaList[m].answers[j].score+'"> '+json.data[0].assessVOs[index].qaList[m].answers[j].code+' '+json.data[0].assessVOs[index].qaList[m].answers[j].content+'</label><br>'
                                	}else{
                                	str += '<label class="i_height"><input class="input_add checkboxa'+json.data[0].assessVOs[index].qaList[m].id+'" type="checkbox" name=a'+json.data[0].assessVOs[index].qaList[m].id+' data-id="'+json.data[0].assessVOs[index].qaList[m].answers[j].id+'" data-value="'+json.data[0].assessVOs[index].qaList[m].answers[j].score+'"> '+json.data[0].assessVOs[index].qaList[m].answers[j].code+' <input class="findassess"></label><br>'
                                	}
                                }
                           
                            }
                            str2 +=
                            '    <div class="strong usertitle pad10">试题</div>'+
                            '    <div class="i_result_list" data-select="0" data-id="'+json.data[0].assessVOs[index].qaList[m].id+'">'+
                            '        <p class="strong mgb10" data-name="'+json.data[0].assessVOs[index].qaList[m].content+'">'+json.data[0].assessVOs[index].qaList[m].content+'</p>'+str+
                            '    </div>';

                        }
                        $('.ql').append(
                            '<div class="bodyline clearfix pad10 fix_b2" style="margin-bottom:20px;">'+
                            '    <div class="strong usertitle pad10 h_txt"><h2>'+json.data[0].assessVOs[index].name+'</h2></div>'+str2+
                            '    <div class="admin_cate_opt"><button class="btn aa" disabled="disabled" style="color:#999" assess-id="'+json.data[0].assessVOs[index].id+'" assess-name="'+json.data[0].assessVOs[index].name+'">提 交</button></div>'+
                            '</div>'
                        )
                        $('.fstb table').append('<tr><td>'+json.data[0].assessVOs[index].name+'</td><td></td></tr>');
                    })(i);
                }

                for (var q=0; q<json.data[0].assessVOs.length; q++) {
                    arr[q] = [];
                    for (var j=0; j<json.data[0].assessVOs[q].cluList.length; j++) {
                        arr[q].push({lowerLimit: json.data[0].assessVOs[q].cluList[j].lowerLimit, upperLimit: json.data[0].assessVOs[q].cluList[j].upperLimit, content: json.data[0].assessVOs[q].cluList[j].content, id: json.data[0].assessVOs[q].cluList[j].id});
                    }
                }

                for (var p=0; p<json.data[0].cluList.length; p++) {
                    $('.sb').append('<input class="user_sel" type="hidden" name="user_sel" value="">');
                    $('.fsrad table').append('<tr><td>'+json.data[0].cluList[p].standard+'</td><td><label><input name=sel type=radio id='+json.data[0].cluList[p].id+'/> '+json.data[0].cluList[p].content+'</label></td></tr>');
                }

                $('input[type=checkbox]').live('click', function () {
                	var bool=false;
                	var id=$(this).attr('name');
                	$('.checkbox'+id).each(function(a,b){
            			if($(b).prop('checked') == true){
            				bool=true;
            			}
                	});
                	if(bool==false){
                		alert("多选题必须有一个是选中的");
                		$(this).prop('checked',true);
                	}
                  });
                $('input').live('click', function () {
                   var num = 0;
                  $(this).parents('.i_result_list').attr('data-select','1');
                  $(this).parents('.fix_b2').find('.i_result_list').each(function () {
                      if($(this).attr('data-select')==1){
                     	 num+=1;
                      }
                  });
	              if(num>= $(this).parents('.fix_b2').find('.i_result_list').length){
                      $(this).parents('.fix_b2').find('button').css('color', '#000').removeAttr('disabled');
                  }
                });
				$(".aa").click(function(){
					//console.log($(this).parent().parent());
					$(this).parent().parent().hide();
					$(this).parent().parent().next().show();
					$('html, body',parent.document).animate({scrollTop:0}, 500);
				});
				$(".findassess").focus(function(){
					$(this).parent().find(".input_add").attr("checked",true);
				});
                var detail = [];
               	var questId=0;
                $('.aa').live('click', function () {
                    var num = 0;
                    var result = [];
                    var assess___="";
                    //console.log($(this).parent().parent().index());
                    $(this).parent().parent().find('input').each(function () {
                        if($(this).prop('checked')) {
                            num+=parseInt($(this).attr('data-value'));
                           if($(this).next().val()!=undefined){
                        		result.push('{question_id:"'+$(this).parents('.i_result_list').attr('data-id')+'", question_name:"'+$(this).parents('.i_result_list').find('p').attr('data-name')+'",answer_id:"'+$(this).attr('data-id')+'", answer_name:"'+$(this).next().val()+'", code:"'+$(this).parent().text().substring(1,2)+'", score:"'+$(this).attr('data-value')+'"}');
                          		 $(this).parents('.i_result_list').find('p').attr('data-name',"");
                           }else{
                        	   result.push('{question_id:"'+$(this).parents('.i_result_list').attr('data-id')+'", question_name:"'+$(this).parents('.i_result_list').find('p').attr('data-name')+'",answer_id:"'+$(this).attr('data-id')+'", answer_name:"'+$(this).parent().text().substring(3)+'", code:"'+$(this).parent().text().substring(1,2)+'", score:"'+$(this).attr('data-value')+'"}');
                          		 $(this).parents('.i_result_list').find('p').attr('data-name',"");
                           }
                          	questId=$(this).parents('.i_result_list').attr('data-id');
                        }
                    });

                    for (var i=0; i<arr[$(this).parent().parent().index()].length; i++) {
                        if (num>=arr[$(this).parent().parent().index()][i].lowerLimit && num<=arr[$(this).parent().parent().index()][i].upperLimit) {
                            $('.fstb tr:eq('+($(this).parent().parent().index()+1)+')').find('td:eq(1)').html(arr[$(this).parent().parent().index()][i].content);
                            detail.push('{assessId:"'+$(this).attr('assess-id')+'",assessName:"'+$(this).attr('assess-name')+'",result:['+result+'],conclusion:"'+arr[$(this).parent().parent().index()][i].content+'"}');
                        }
                    }
                    
                    $('#detail').val('['+detail+']');
                    $(this).remove();

                    if ($('.aa').length == 0) {
                        $('.fsrad').show();
                        $('.sb').show();
                    }
                });

                $('.fsrad input').live('click', function () {
                    $('.sb input:eq(0)').val(parseInt($(this).attr('id')))
                    $('.sb input:eq(1)').val($(this).parents('td').text())
                    $('.admin_cate_opt .btn').removeAttr('disabled').css('color', '#000');
                });
                
                
            }
        }
    }
});



</script>

</body>
</html>