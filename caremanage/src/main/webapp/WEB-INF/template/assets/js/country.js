/**
 * 功能描述：<br>
 * 城市级联js
 * @author guoyongxiang
 */
$(document).ready(function() {
	//========初始化分类========
	//console.log("init...");
	var url="/community/getCountrys/";
	
	// --------全局默认显示-------
	// 默认格式 '{0}' 为自定义方法，用于替换指定字符串
	var defFmt = "<option value=\'-1\'>={0}=</option>";
	// 可设置某些ID的默认显示文本
	var nameMapping = {
			"defTxt"	:defFmt.format('请选择'),// 默认选项
			"province"	:defFmt.format('省级区划'),
			"city"		:defFmt.format('市级区划'),
			"region"	:defFmt.format('区、县级区划'),
			"street"	:defFmt.format('街道'),
			"community"	:defFmt.format('社区')
	};
	
	// 定义初始化时自动加载的第一个下拉列表的ID
	var frist = $("#province");
	// 初始查询ID = 0
	if(frist.val()==0){
		callCountry(true, frist);
	}
	
	//=====================
	// province	city region	street
	// 切换省市区,绑定所有指定class的下拉列表change事件
	$("select[class='ocountry']").change(function() {
		callCountry(false, this);
	});
	
	
	/**
	 * 调用数据接口
	 * @param top 是否为顶级列表(初始化使用,用户控制数据是填充本元素还是子元素)
	 * @param obj 当前元素
	 */
	function callCountry(top, obj){
		var pid = $(obj).val();
		var nextId = $(obj).attr("next");
		if(pid !="" && pid != -1){
			$.post(url+pid, function(data){
				// 列表项填充
				setNode(top, obj, data.data, nextId);
			}, "json"); 
		}else{
			// 选中默认值重置所有子节点
			cleanNext(nextId);
		}
	}
	
	
	/**
	 * 填充当前节点并设置子节点
	 * @param top		是否为顶级列表
	 * @param obj		当前操作对象
	 * @param data		数据列表json返回
	 * @param nextId	下级元素ID
	 */
	function setNode(top, obj, data, nextId){
		var id = "";
		if(top){
			id = $(obj).attr("id");
		}else{
			id = nextId;
		}	
		$("#"+id).empty();// 移除子节点
		var defText = nameMapping[id];
		if(defText==undefined){
			defText = nameMapping.defTxt;
		}
		$(defText).appendTo("#"+id);   //添加一个默认项
		cleanNext(nextId); // 清空下级列表
		
		$.each(data, function(key, val) {
			// 将返回来的项添加到下拉菜单中
			$("<option value=\""+val.id+"\">"+val.name+"</option>").appendTo("#"+id);
		});
	}
	
	/**
	 * 重置下级列表为默认值
	 */
	function cleanNext(nextId){
		while (nextId!="" && nextId!=undefined){
			$("#"+nextId).empty();// 移除子节点
			var defText = nameMapping[nextId];
			if(defText==undefined){
				defText = nameMapping.defTxt;
			}
			$(defText).appendTo("#"+nextId);
			nextId = $("#"+nextId).attr("next");
		}
	}
});


/** 格式化输入字符串**/
//用法: "hello{0}".format('world')；返回'hello world'
String.prototype.format= function(){
  var args = arguments;
  return this.replace(/\{(\d+)\}/g,
  		function(s,i){
  			return args[i];
  		});
};
