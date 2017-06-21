$(function() {
	var TokinagaZ = 0;

	// $.cookie("ID", 2016);
	var week = 0;
	// 全选与取消
	$('.first_').click(function() {
		var chec = $('#cjeck').prop('checked');
		if (chec == false) {
			$('#cjeck').prop('checked', true);
			$('.cjeck').prop('checked', true);
		} else {
			$('#cjeck').prop('checked', false);
			$('.cjeck').prop('checked', false);

		}

	});

	// 全选
	$('.checketx').click(function() {
		var chec = $('.checket1').prop('checked');
		if (chec == false) {
			// $(this).prop('checked',true);
			$('.checket2').prop('checked', false);
		} else {
			// $(this).prop('checked',false);
			$('.checket2').prop('checked', true);

		}
	});

	$('.missionTOAdd_').click(function() {
		$('#missiont').submit();

	});

	$('.submit_mission').click(
			function() {

				if ($('.checket2:checked').length != 0) {
					var i = 0;
					var time1 = 0;
					$('.checket2:checked').each(
							function() {
								var programId = $(this).next('.programId')
										.val();
								$(this).next('.programId').attr("name",
										'program[' + i + '].progranId');
								$(this).nextAll('.programNmae').attr("name",
										'program[' + i + '].progranName');
								$(this).nextAll('.programTime').attr("name",
										'program[' + i + '].duration');
								var programNmae = $(this).nextAll(
										'.programNmae').val();
								var programTime = $(this).nextAll(
										'.programTime').val();
								var reg = /\d+/g;
								var ms = programTime.match(reg);
								var time = ms.join(',');
								time1 += time;
								$(this).nextAll('.programTime').val(time);

								i++;
							});
					var times = $('#_times').val();
					var times1 = $('#_times1').val();
					if (times1 < times + time1) {
						alert("选取时间超过预期时间，请重新选择！");
					} else {
						$('#missionAdd').submit();
					}
				} else {
					alert("请选择课程！");
					return false;
				}
			});

	$('.div_cs').click(function() {
		if ($(this).attr('date-id') == 1) {
			$(this).attr('date-id', '2');
			$(this).val("▲");
		} else {
			$(this).attr('date-id', '1');
			$(this).val("▼");
		}
		$(this).parent().parent().next().toggle();
	});
	$('.add_plan').click(function() {
		location.href = "/professional/activity/toAdd";
	});

	// 节假日等特殊情况说明，未举办缘由显示备注。
	$('#checkes').click(function() {

		if ($('#remark').prop('disabled') == true) {
			$('#remark').prop('disabled', false);
		} else {
			$('#remark').prop('disabled', true);

		}

	});
	$('select').change(
			function() {
				var Tokinaga1 = (Number($('.time_1').val())) * 60
						+ Number($('.min_1').val())
				var Tokinaga2 = (Number($('.time_2').val())) * 60
						+ Number($('.min_2').val())
				var Tokinaga = Math.abs(Tokinaga2 - Tokinaga1);
				$('#min').val(Tokinaga);
			});
	var stite = [];
	var stiteId = [];
	$('.add_one')
			.click(
					function() {
						var m=dateCompare($('.start').val(),$('.end').val());
						if(m!=1){
							return false;
						}
						var sites = $('.selectpicker').val();// 站点id
						var main_1 = "";
						var main_2 = "";
						if ($('.min_1').val().length == 1) {
							var Tokinaga1 = $('.time_1').val() + ":0"
									+ $('.min_1').val() + "-";
						} else {
							var Tokinaga1 = $('.time_1').val() + ":"
									+ $('.min_1').val() + "-";
						}
						if ($('.min_2').val().length == 1) {
							var Tokinaga2 = $('.time_2').val() + ":0"
									+ $('.min_2').val();
						} else {
							var Tokinaga2 = $('.time_2').val() + ":"
									+ $('.min_2').val();
						}
						var time = Tokinaga1 + Tokinaga2// 时间
						var Tokinaga = $('#min').val();
						TokinagaZ = Tokinaga;
						var start = $('.start').val();// 本次活动时间起止时间
						var end = $('.end').val();
						var remark = $('#remark').val();
						if (sites == "" || time == "" || Tokinaga == ""
								|| start == "" || end == "") {
							alert("输入不正确，请检查！");
							return false;
						}
						var str = "siteIds=" + sites + "&planTime=" + time
								+ "&planMin=" + Tokinaga + "&start=" + start
								+ "&end=" + end + "&remark=" + remark;
						if (sites != "" && start != "" && end != "") {
							$
									.ajax({
										url : "/professional/activity/addone?"
												+ str,
										success : function(json) {

											$('.div_one').hide();
											$('.div_two').show();
											$('.lable1')
													.removeClass("lable_c2")
													.addClass("lable_c1");
											$('.lable2')
													.removeClass("lable_c1")
													.addClass("lable_c2");
											var voList = eval("(" + json + ")");
											week = voList[0].week;
											$('.weeks').html("共" + week + "周");
											for (var i = 0; i < voList.length; i++) {
												stite.push(voList[i].siteName);
												stiteId.push(voList[i].id);
												var tr = $('<tr class="tab_tr" date-value='
														+ voList[i].id
														+ '> <td>'
														+ voList[i].siteName
														+ '</td> <td><label><input class="w_1" type=checkbox value="星期一"></label>星期一</td> <td><label><input class="w_2" type=checkbox value="星期二">星期二</label></td> <td><label><input class="w_3" type=checkbox value="星期三">星期三</label></td> <td><label><input class="w_4" type=checkbox value="星期四">星期四</label></td> <td><label><input class="w_5" type=checkbox value="星期五">星期五</label></td> <td><label><input class="w_6" type=checkbox value="星期六">星期六</label></td> <td><label><input class="w_7" type=checkbox value="星期日">星期日</label></td> </tr>');
												$('.div_two table').append(tr);
											}
											if(voList[0].weeks!=""){
											//alert(voList[0].weeks);
											var weeks=voList[0].weeks;
											var weekss=weeks.substring(0,weeks.length-1);
											var weearr=weekss.split(",");
											for(var i=1;i<8;i++){
												$('.w_'+i).prop("disabled",true);
											}
											for(var i=0;i<weearr.length;i++){
												$('.w_'+weearr[i]).prop("disabled",false);
											}
										}
										}
									});

						}
					});

	$('.add_two')
			.click(
					function() {

						var bool = true;
						var weeks_ = "";
						$('.tab_tr').each(function() {
							var id = $(this).attr('date-value');
							var arr = [];
							weeks_ += id;
							weeks_ += ",";
							$(this).find('input:checked').each(function() {
								var checkTime = $(this).val();
								arr.push(checkTime);
							});
							if (arr.length == 0) {
								bool = false;
							}
							weeks_ += arr.join("|");
							weeks_ += ";"
							$.cookie(id, arr);
						})
						if (bool == false) {
							alert("每个站点至少选择一天！");
							return false;
						}
						if (weeks_.length > 1) {
							weeks_.substring(0, weeks_.length - 1);
						}
					//	alert("xxx2")
						$.ajax({
									url : "/professional/activity/addTwo?week="+ weeks_,
									success : function(json) {
										var voList = eval("(" + json + ")");
										var i = parseInt(week / 2);
										if (week == 1 || week == 2) {
											$('.add_three').val("提交");
										}
										$('.TokinagaZ').html("总时长为："+ TokinagaZ+ "分钟");
										for (var m = 0; m < i; m++) {
											var table = $('<table id='
													+ m
													+ ' class="table _tale1 _tabPlan1 _tabPlan rt_two"><tr class="_active"><th >日期安排</th><th colspan="4"><input class="_weeks1" type="hidden" value='
													+ (m + 1)
													+ '>第'
													+ (m + 1)
													+ '周</th><th colspan="4"><input class="_weeks2" type="hidden" value='
													+ (m + 2)
													+ '>第'
													+ (m + 2)
													+ '周</th></tr><tr class=" tr_one"><td style="width:80px;">站点名称</td><td class="tb_cal">课程名称</td><td class="tb_cal">专业老师</td><td class="tb_cal">印象标签</td><td class="tb_cal">活动时长</td><td class="tb_cal">课程名称</td><td class="tb_cal">专业老师</td><td class="tb_cal">印象标签</td><td class="tb_cal">活动时长</td></tr></table>')
											$('._div_three').append(table);
										}
										var length = $('._tabPlan').length;
										if (week % 2 == 1) {
											var table1 = $('<table id='
													+ length
													+ ' class="table _tale1  _tabPlan2 _tabPlan rt_one"><tr class="_active"><th style="width:90px;">日期安排</th><th colspan="4"><input class="_weeks1" type="hidden" value='
													+ (m + 1)
													+ '>第'
													+ week
													+ '周</th></tr><tr class=" tr_one"><td style="width:80px;">站点名称</td><td class="tb_cal">课程名称</td><td class="tb_cal">专业老师</td><td class="tb_cal">印象标签</td><td class="tb_cal">活动时长</td></tr></table>')
											$('._div_three').append(table1);

										}
										// 添加专业老师及课程
										//alert("xxxxx1")
										for (var i = 0; i < stite.length; i++) {
											var weeks_da = $.cookie(stiteId[i] .toString());

											var tr = $('<tr class="tr_1"><td>'
													+ stite[i]
													+ '</td><td class="ta_col" colspan="4"><input type="hidden" class="xingqi" value='
													+ weeks_da
													+ '><input class=nProgramVOSiteId   type="hidden" value='
													+ stiteId[i]
													+ '></td> <td class="ta_col" colspan="4"><input type="hidden" class="xingqi" value='
													+ weeks_da
													+ '><input class=nProgramVOSiteId  type="hidden"  value='
													+ stiteId[i]
													+ '></td> </tr>')
											$('._tabPlan1').append(tr);
											if (week % 2 == 1) {
												var weeks_da = $
														.cookie(stiteId[i]
																.toString());
												var tr1 = $('<tr class="tr_1"><td>'
														+ stite[i]
														+ '</td><td class="ta_col" colspan="4"><input type="hidden" class="xingqi" value='
														+ weeks_da
														+ '><input class=nProgramVOSiteId  type="hidden"  value='
														+ stiteId[i]
														+ '></td> </tr>')
												$('._tabPlan2').append(tr1);
											}
										}
										$('.ta_col')
												.each(
														function() {
															var select = $('<div class="lable_cope"><lable><select class="select1" style="width:80px;"><option value="0">-请选择-</option></select></lable> <lable><select class="select2" style="width:80px;"><option value="0">-请选择-</option></select></lable> <lable><select class="select3" style="width:80px;"><option  value="0">-请选择-</option></select></lable> <lable class="right_lable"><input class="min" style="width:30px; " value='
																	+ TokinagaZ
																	+ '>min <a class="jia"> + </a><a class="jian"> - </a></lable></div>');
															$(this).append(
																	select);
														});
										$('.select1')
												.each(
														function() {
															for (var i = 0; i < voList.length; i++) {
																var option = $('<option value='
																		+ voList[i].id
																		+ '>'
																		+ voList[i].programName
																		+ '</option>');
																$(this).append(
																		option);
															}
														});

										$('#' + 0).show();
									}
								});
						$('.div_two').hide();
						$('.div_three').show();

						$('.lable2').removeClass("lable_c2").addClass(
								"lable_c1");
						$('.label3').addClass("lable_c2");

					});

	$(document)
			.on(
					'click',
					'.jia',
					function() {
						var tr = $(this).parent().parent().clone();
						$(this).parent().parent().parent().append(tr);
						$('.select1')
								.each(
										function() {
											if ($(this).val() == "0") {
												$(this).parent().nextAll()
														.find('select').empty();
												var option = $('<option value="0">-请选择--</option>');
												$(this).parent().nextAll()
														.find('select').append(
																option);
											}

										});
						var minveg = $(this).parent().parent().parent()
								.children("div").find('input');
						var minveglength = $(this).parent().parent().parent()
								.children("div").find('input').length;
						var minv = TokinagaZ / minveglength;
						if (minv < 10) {
							alert("课程长度不能小于10分钟！");
							return false;
						}
						$(minveg).each(function() {
							$(this).val(minv);
						});
					});
	$(document)
			.on(
					'click',
					'.jian',
					function() {
						var minveg = $(this).parent().parent().parent()
								.children("div").find('input');
						var minveglength = $(this).parent().parent().parent()
								.children("div").find('input').length - 1;
						if (minveglength == 0) {
							minveglength = 1;
						}
						var minv = TokinagaZ / minveglength;
						$(minveg).each(function() {
							$(this).val(minv);
						});
						if ($(this).parent().parent().parent().find('div').length != 1) {
							var tr = $(this).parent().parent().remove();
						}

					});
	$(document).on(
			'change',
			'.min',
			function() {
				var min1 = $(this).val();
				if (min1 < 10) {
					alert("课程时长不能小于10分钟")
				}
				var mins = $(this).parent().parent().prevAll("div").find(
						'input');
				var min2 = 0;
				$(mins).each(function() {
					min2 += parseInt($(this).val(), 10);
					;
				});
				var mins1 = $(this).parent().parent().nextAll("div").find(
						'input');
				var minslength = $(this).parent().parent().nextAll("div").find(
						'input').length + 1;

				if (minslength == 1 && (TokinagaZ - min2) <= min1) {
					$(this).val(TokinagaZ - min2);
					return false;
				} else if (minslength == 1 && (TokinagaZ - min2) > min1) {
					return false;
				}
				var houtiemq = (TokinagaZ - min2) / (minslength - 1);
				if (TokinagaZ < (min1 + min2) || houtiem < 10) {
					alert("课程时长过大，超过限制，请重新输入！");
					var houtiem = (TokinagaZ - min2) / minslength;
					$(this).val(houtiem);
					$(mins1).each(function() {
						$(this).val(houtiem);
					});
				} else {
					$(mins1).each(function() {
						$(this).val(houtiemq);
					});
				}
			});
	$(document).on(
			'change',
			'.select1',
			function() {
				var selecte2 = $(this).parent().next().find('.select2');
				var selecte3 = $(this).parent().next().next().find('.select3');
				selecte2.html($('<option>-请选择-</option>'));
				selecte3.html($('<option>-请选择-</option>'));
				$.ajax({
					url : "/professional/fete/plan?id=" + $(this).val(),
					success : function(json) {
						var voList = eval("(" + json + ")");
						for (var i = 0; i < voList.keyword.length; i++) {
							if(voList.keyword[i].replace(/(^\s+)|(\s+$)/g,"")!=""){
								var option = $('<option>' + voList.keyword[i]
								+ '</option>');
								selecte3.append(option);
							}
						}
						var porp = voList.teacher
						for ( var prop in voList.teacher) {
							var option = $('<option value=' + prop + '>'
									+ voList.teacher[prop] + '</option>');
							selecte2.append(option);
						}

					}
				});

			});
	var hi = 0;
	$('.add_three')
			.click(
					function() {
						// $('#'+hi).hide();
						var select2_td1 = [];
						var select2_td2 = [];
						$('#' + hi).find('.tr_1').each(
								function() {
									$(this).children('td').eq(1).find(
											'.select2').each(function() {
										select2_td1.push($(this).val());
									});
									$(this).children('td').eq(2).find(
											'.select2').each(function() {
										select2_td2.push($(this).val());
									});
								});
						if (mm(select2_td1) != true && mm(select2_td2) != true
								&& $.inArray("0", select2_td1) == -1
								&& $.inArray("0", select2_td2) == -1) {

							if ($('._tabPlan').length == (hi + 1) || week == 1) {
								// 提交数据到后台;
								// xingqi //星期 //站点Id //课件分类 //专业老师 //关键字 标签
								var s1 = 0;
								var s2 = 0;
								$('.xingqi').each(
										function() {
											var name = "nActivityPlanVO[" + s1
													+ "].weeks";
											$(this).attr('name', name);
											s1++;
										});
								$('.nProgramVOSiteId')
										.each(
												function() {
													$(this)
															.attr(
																	'name',
																	'nActivityPlanVO['
																			+ s2
																			+ '].siteId');
													var _we = 0;
													if (s2 % 2 == 0) {
														_we = $(this).closest(
																'table').find(
																'._weeks1')
																.val();
													} else {

														_we = $(this).closest(
																'table').find(
																'._weeks2')
																.val();
														if (isNaN(_we) == true) {
															_we = $(this)
																	.closest(
																			'table')
																	.find(
																			'._weeks1')
																	.val();
														}
													}
													$(this)
															.parent()
															.append(
																	$('<input type="hidden"  name=nActivityPlanVO['
																			+ s2
																			+ '].weeksId value='
																			+ _we
																			+ '>'));
													var s3 = 0;
													$(this)
															.parent()
															.find('.select1')
															.each(
																	function() {
																		$(this)
																				.attr(
																						'name',
																						'nActivityPlanVO['
																								+ s2
																								+ '].coursevo['
																								+ s3
																								+ '].CourseType');
																		s3++;

																	});
													var s4 = 0;
													$(this)
															.parent()
															.find('.select2')
															.each(
																	function() {
																		$(this)
																				.attr(
																						'name',
																						'nActivityPlanVO['
																								+ s2
																								+ '].coursevo['
																								+ s4
																								+ '].employeeId');
																		s4++;

																	});
													var s5 = 0;
													$(this)
															.parent()
															.find('.select3')
															.each(
																	function() {
																		$(this)
																				.attr(
																						'name',
																						'nActivityPlanVO['
																								+ s2
																								+ '].coursevo['
																								+ s5
																								+ '].keyword');
																		s5++;

																	});
													var s6 = 0;
													$(this)
															.parent()
															.find('.min')
															.each(
																	function() {
																		$(this)
																				.attr(
																						'name',
																						'nActivityPlanVO['
																								+ s2
																								+ '].coursevo['
																								+ s6
																								+ '].min');
																		s6++;
																	});
													s2++;
												});

								$('#addActivity').submit();
							} else {
								$('#' + hi).hide();
								hi++;
								$('#' + hi).show();
							}

						} else {
							alert("请查看专业老师选择情况");
						}
						if ((hi + 1) == $('._tabPlan').length) {
							$('.add_three').val("提交");
						}

					});

	$(".deluser").click(
			function() {
				var userid = $(this).attr("date-id");
				layer.confirm('是否确定删除该活动?', function(index) {
					$.get("/professional/activity/delete?id=" + userid,
							function(result) {
								if (result == 'success') {
									// 移除记录
									$('.userid_' + userid).remove();
								}
							});
					layer.close(index);
				}, function(index) {
					// console.log(index);
				});
			});// 
	$('.update_plan').click(function() {
		var id = $(this).attr('date-id');
		// alert(id);
		location.href = "/professional/activity/update?id=" + id;
	});
	$('.select').click(function() {
		$("#activity").submit();
	});

});
function mm(a) {
	return /(\x0f[^\x0f]+)\x0f[\s\S]*\1/.test("\x0f" + a.join("\x0f\x0f")
			+ "\x0f");
}
$(function() {

	$(document).on(
			'click',
			'.li_',
			function() {
				for(var i=0;i<$('.yuangong>input').length;i++){
					if($('.yuangong>input').eq(i).attr("date-id")==$(this).attr("date-id")){
						alert("不能重复选择工作人员");
						return false;
					}
				}
				$('.yuangong').append(
						'<input  type="button" class="btn-default add_first btn daa-y" date-id='
								+ $(this).attr("date-id") + ' value='
								+ $(this).text() + '>');
				$(this).remove();
			});
	$(document).on('click', '.daa-y', function() {
		$(this).remove();
	});
	$('.quxiao').click(function() {
		$('#suspension_add').html("");
		$('#employeeId').val("");
	});

	$('.addup').click(function() {
		if($("[name='planName']").val()==""){
			alert("活动主题不能为空");
			return false;
		}
		if($("[name='planPlace']").val()==""){
			alert("活动地点不能为空");
			return false;
		}
		if($("[name='planDesc']").val()==""){
			alert("活动目的不能为空");
			return false;
		}
		if($(".yuangong>input").length==0){
			alert("工作人员不能为空");
			return false;
		}
		if(!$("._nVolunteer").is(':checked')){
			alert("志愿者最少选择一个");
			return false;
		}
		var yuangong = "";
		$('.daa-y').each(function() {
			yuangong += $(this).attr("date-id");
			yuangong += ",";
		});
		if (yuangong.length > 1) {
			yuangong = yuangong.substring(0, yuangong.length - 1);
		}
		var nVolunteer = "";
		$('._nVolunteer:checked').each(function() {
			nVolunteer += $(this).val();
			nVolunteer += ",";
		});
		if (nVolunteer.length > 1) {
			nVolunteer = nVolunteer.substring(0, nVolunteer.length - 1);
		}
		$('#volunteerId').val(nVolunteer);
		$('#_employeeId').val(yuangong);
		$('#searchForm').submit();
	});

	$(".delplan").click(
			function() {
				var userid = $(this).attr("date-id");
				layer.confirm('是否确定删除该员工?', function(index) {
					$.get("/professional/activity/delplan?id=" + userid,
							function(result) {
								if (result == 'success') {
									// 移除记录
									$('.userid_' + userid).remove();
								}
							});
					layer.close(index);
				}, function(index) {
					// console.log(index);
				});
			});// 

});
$(window).on('load', function() {
	var str = $('#sit').val();
	if (str != undefined) {
		var arr = str.split(',');
		$('.selectpicker').selectpicker('val', arr);
	}
});
$(window).on(
		'load',
		function() {
			employeeId.oninput = function() {
				if (this.value != "") {
					$.ajax({
						url : "/professional/activity/yuangong?name="
								+ this.value,
						type : "get",
						success : function(nVolunteer) {
							$('#suspension_add').html("");
							var mjson = eval("(" + nVolunteer + ")");
							// var panduan_add=0;
							for (var i = 0; i < mjson.length; i++) {
								var li = $("<li class='li_' date-id="
										+ mjson[i][0] + ">" + mjson[i][1]
										+ "</li>");
								$('#suspension_add').append(li);
							}
						}
					});
				}else {
					$('#suspension_add').html("");
				}
			}
		});
function dateCompare(startdate,enddate){   
    
    var arr=startdate.split("-");    
    var starttime=new Date(arr[0],arr[1],arr[2]);    
    var starttimes=starttime.getTime();   
    var arrs=enddate.split("-");    
    var lktime=new Date(arrs[0],arrs[1],arrs[2]);    
    var lktimes=lktime.getTime();   
    if(starttimes>=lktimes){   
        alert("错误的时间，起始时间不能大于等于终止时间！");
        return 0;   
    }else{  
        return 1;   
    }  
}

