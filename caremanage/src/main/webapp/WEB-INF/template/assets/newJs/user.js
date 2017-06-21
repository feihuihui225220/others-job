$(function() {
	// 搜索查看站点（模糊查询）
	search.oninput = function() {
		console.info(this);
		$.ajax({
			url : "/permission/seesite?name=" + this.value,
			type : "get",
			success : function(json) {
				$('#suspension_add').html("");
				var mjson = eval("(" + json + ")");
				var length = mjson.mVenderSite.length;
				for (var i = 0; i < length; i++) {
					var li = $("<li  class='site_ids'  date-value="
							+ mjson.mVenderSite[i].id + ">"
							+ mjson.mVenderSite[i].siteName + "</li>");
					$('#suspension_add').append(li);
				}
			}
		});
	}
	// 搜索查看站点（模糊查询）-编辑
	search_.oninput = function() {
		console.info(this);
		$.ajax({
			url : "/permission/seesite?name=" + this.value,
			type : "get",
			success : function(json) {
				$('#suspension_update').html("");
				var mjson = eval("(" + json + ")");
				var length = mjson.mVenderSite.length;
				for (var i = 0; i < length; i++) {
					var li = $("<li  class='site_ids'  date-value="
							+ mjson.mVenderSite[i].id + ">"
							+ mjson.mVenderSite[i].siteName + "</li>");
					$('#suspension_update').append(li);
				}
			}
		});
	}
	// 搜索后增加用户站点
	$('#suspension_add ').on(
			'click',
			'li',
			function() {
				var id = $(this).attr("date-value");
				var name = $(this).html();
				$('#see_siteName').append(
						'<div class="_add_div_module div_module" date-value='
								+ id + '>' + name + '</div>');
				$(this).remove();
			});
	$('#suspension_update ').on(
			'click',
			'li',
			function() {
				var id = $(this).attr("date-value");
				var name = $(this).html();
				$('#_update_see_siteName').append(
						'<div class="_update_div_module div_module" date-value='
								+ id + '>' + name + '</div>');
				$(this).remove();
			});
	$(".add_first_1").click(function() {
		$(".plan_").toggle();
	});
	$(".add_first_2").click(function() {
		$(".plan_addRoles").toggle();
	});

});
$(function() {
	$(".deluser").click(function() {
		var userid = $(this).attr("userid");
		layer.confirm('是否确定删除该员工?', function(index) {
			$.get("/permission/removeUser/" + userid, function(result) {
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
	$(".delsite").click(
			function() {
				var mid = $(this).attr("mid");
				layer.confirm('是否确定删除站点信息?', function(index) {
					$.get("/professional/vender/site/delete?id=" + mid,
							function(result) {
								if (result == 'success') {
									// 移除记录
									$('.mid_' + mid).remove();
								}
							});
					layer.close(index);
				}, function(index) {
					// console.log(index);
				});
			});
});
$(function() {
	//取消
	$(".delete").click(function(){
		$(".site_ids").remove();
		$(".sousuo").val("");
	})
	// 试一试显示隐藏
	var num = $('.div_1').length;
	$('.div_1').hide();
	$('.1').show();
	var i = 1;
	if (num != 1) {
		i = 2;
	}
	$('.huanyihuan').click(function() {
		$('.div_1').hide();
		$("." + i).show();
		var j = i - 1;
		i++;
		if (i == num + 1) {
			i = 1;
		}
	})
	// 增加展示站点
	$('._div_mdule_site').click(
			function() {
				var id = $(this).attr("date-value");
				var name = $(this).html();
				$('#see_siteName').append(
						'<div class="_add_div_module div_module" date-value='
								+ id + '>' + name + '</div>');
				$(this).hide();
			});
	// 增加展示站点
	$('._div_module_site').click(
			function() {
				var id = $(this).attr("date-value");
				var name = $(this).html();
				$('#_update_see_siteName').append(
						'<div class="_update_div_module_ div_module" date-value='
								+ id + '>' + name + '</div>');
				$(this).hide();
			});
	// 添加员工增加绑定事件
	$('._user_add').click(function() {
		var value = "";
		$('._add_div_module').each(function() {
			value += $(this).attr("date-value");
			value += ",";
		});
		$('#_sites').val(value);
		var pw_zz=/^\w{6,15}$/;
		var name_zz = /^[\u4e00-\u9fa5a-z]+$/gi;//只能输入汉字和英文字母
		var name_val=$('[name="name"]').val();
		var pw_val=$('[name="password"]').val();
		var phone_val=$('[name="contactPhone"]').val();
		var check_check=$('[name="roleIds"]');
		var site_length=$("#see_siteName").find("div").length;
		if(name_val==""){
			alert("姓名不能为空");
			return false;
		}
		if(!name_zz.test(name_val)){
			alert("用户名中不能包含特殊字符，只能输入汉字或者英文字母");
			return false;
		}
		if(pw_val==""){
			alert("密码不能为空")
			return false;
		}
		if(!pw_zz.test(pw_val)){
			alert("登录密码不能低于6位，大于15位且不能有特殊字符!");
			return false;
		}
		if(phone_val==""){
			alert("联系电话不能为空!");
			return false;
		}
		var ps=/^0?1[3|4|5|8][0-9]\d{8}$/;
		   if(!ps.test(phone_val)){
			alert("联系电话号码格式不对!");
			return false;
		 }
		if(!check_check.is(':checked')){
			alert("必须选择角色");
			return false;
		}
		if(!check_check.is(':checked')){
			alert("必须选择角色");
			return false;
		}
		if(site_length==0){
			alert("必须选择站点");			
 
			return false;
		}
		$("form[name='addUser']").submit();
	})
	$('._user_update').click(function() {
		var value = "";
		$('._update_div_module_').each(function() {
			value += $(this).attr("date-value");
			value += ",";
		});
		$('#sites_u').val(value);
		var pw_zz=/^\w{6,15}$/;
		var name_zz = /^[\u4e00-\u9fa5a-z]+$/gi;//只能输入汉字和英文字母
		var name_val=$('#name_').val();
		var pw_val=$('#password_').val();
		var phone_val=$('#contactPhone_').val();
		var check_check=$('[name="roleIds"]');
		var site_length=$("#_update_see_siteName").find("div").length;
 
		if(name_val==""){
			alert("姓名不能为空");
			return false;
		}
		if(!name_zz.test(name_val)){
			alert("用户名中不能包含特殊字符，只能输入汉字或者英文字母");
			return false;
		}
		if(!pw_zz.test(pw_val)){
			if(!pw_val==""){
				alert("登录密码不能低于6位，大于15位且不能有特殊字符!");
				return false;			
			}
		}
		if(phone_val==""){
			alert("联系电话不能为空!");
			return false;
		}
		var ps=/^0?1[3|4|5|8][0-9]\d{8}$/;
		   if(!ps.test(phone_val)){
			alert("联系电话号码格式不对!");
			return false;
		 }
		if(!check_check.is(':checked')){
			alert("必须选择角色");
			return false;
		}
		if(!check_check.is(':checked')){
			alert("必须选择角色");
			return false;
		}
		if(site_length==0){
			alert("必须选择站点");
			return false;
		}
		$("form[name='updateUser']").submit();

	})
	$('._user_roles').click(function() {
		var namejs=$('#addjs_name').val();
		var quanxianjs=$("[name='resIds']");
		if(namejs==""){
			alert("名称不能为空");
			return false;
		}
		if(!quanxianjs.is(':checked')){
			alert("必须选择权限");
			return false;
		}
		$("form[name='addRoles']").submit();

	})
	$('._update_roles').click(function() {
		var up_namejs=$('#name_roles').val();
		var quanxianjs=$("[name='resIds']");
		if(up_namejs==""){
			alert("名称不能为空");
			return false;
		}
		if(!quanxianjs.is(':checked')){
			alert("必须选择权限");
			return false;
		}
		$("form[name='UpdateRoles']").submit();
		
	})
});
$(function() {
	$(".plan_").hide();
	$(".plan_addRoles").hide();
	// 点击任意一处下拉div隐藏 有bug
	/*
	 * $(document).bind("click",function(e){ var target = $(e.target);
	 * if(target.closest(".plan_css").length == 0 ){ $(".plan_").hide(); } })
	 */
});
$(function() {
	$(".addulimit").click(function() {
		$.layer({
			type : 1,
			title : '添加角色',
			offset : [ '150px', '' ],
			border : false,
			shadeClose : true,
			fadeIn : 300,
			btns : 2,
			btn : [ '保存', '取消' ],
			yes : function(index) {
				// console.log("保存",index);
				layer.close(index);
			},
			area : [ '450px', '270px' ],
			page : {
				dom : '.limitbox'
			}
		});
	});
	$(".editulimit").click(function() {
		var limitid = $(this).attr("limitid");
		// console.log('编辑id'+limitid);
		$.layer({
			type : 1,
			title : '编辑角色',
			offset : [ '150px', '' ],
			border : false,
			shadeClose : true,
			fadeIn : 300,
			btns : 2,
			btn : [ '保存', '取消' ],
			yes : function(index) {
				// console.log("保存",index);
				layer.close(index);
			},
			area : [ '450px', '270px' ],
			page : {
				dom : '.limitbox'
			}
		});
	});
	$(".delulimit").click(function(event) {
		// 阻止事件向上冒泡
		// event.stopPropagation();
		var limitid = $(this).attr("limitid");
		layer.confirm('是否确定删除该角色?', function(index) {
			$.get("/permission/removeRole/" + limitid, function(result) {
				if (result == 'success') {
					// 移除记录
					$('.limitid_' + limitid).remove();
					layer.close(index);
					// 没有记录时置灰操作按钮
					if ($(".tablebox").find("tr").length > 1) {
						// 被选中的记录删除后刷新页面到第一条
						if ($role.id == limitid) {
							window.location.href = "/permission/roles";
						} else {
							// 有记录恢复按钮可用
							$(".centerbtn button").removeAttr("disabled");
						}
					} else {
						$(".centerbtn button").attr("disabled", "true");
					}
				}
			});
		}, function(index) {
			// console.log(index);
		});
	});
});
$(function() {
	$('._see_user').click(function() {
		
		$('.see_siteName').html("");
		var id = $(this).attr('date-id');
		var name = $(this).attr('date-name');
		var contactphone = $(this).attr('date-contactphone');
		$('#id_').val(id);
		$('#name_').val(name);
		$('#contactPhone_').val(contactphone);
		$.ajax({
				url : "/permission/site/updateUser?id="
						+ id,
				type : "get",
				success : function(json) {
					var mjson = eval("(" + json + ")");
					var length = mjson.aRoleVO.length;
					var lengthSite = mjson.mVenderSite.length;
					// 获取用户角色
					for (var i = 0; i < length; i++) {
						$('._roleIds').each(function() {
							if ($(this).val() == mjson.aRoleVO[i].id) {
								$(this).attr('checked',true);
							}
						});
					}
					// 获取站点
					for (var i = 0; i < lengthSite; i++) {

						$('#_update_see_siteName').append('<div class="_update_div_module_ div_module" date-value='+ mjson.mVenderSite[i].id+ '>'+ mjson.mVenderSite[i].siteName+ '</div>');
						$('._div_module_site').each(function() {
							if ($(this).attr('date-value') == mjson.mVenderSite[i].id) {
								$(this).hide();
							}

						});

					}

				}
			});

	});
	$('.see_siteName').on('click', 'div', function() {
		var id = $(this).attr('date-value');
		var id = $(this).attr('date-value');

		$('._div_module_site').each(function() {
			if ($(this).attr('date-value') == id) {
				$(this).show();
			}
		});

		$(this).remove();
	});

});
