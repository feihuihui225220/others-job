/** 格式化输入字符串**/
//用法: "hello{0}".format('world')；返回'hello world'
String.prototype.format= function(){
    var args = arguments;
    return this.replace(/\{(\d+)\}/g,
    		function(s,i){
    			return args[i];
    		});
};

/** 获取字符宽度 */
String.prototype.getWidth = function(fontSize)  
{  
    var span = document.getElementById("__getwidth");  
    if (span == null) {  
        span = document.createElement("span");  
        span.id = "__getwidth";  
        document.body.appendChild(span);  
        span.style.visibility = "hidden";  
        span.style.whiteSpace = "nowrap";  
    }  
    span.innerText = this;  
    span.style.fontSize = fontSize + "px";  
  
    return span.offsetWidth;  
};
$(document).ready(function() {
	// 点击行内隐藏域跳转value
	$('.trclick tr').live('click', function(event) {
		// 阻止INPUT标签的跳转,以免被刷新
		if (event.target.tagName == "INPUT") {
			return;
		}
		// 获取target属性，判断是否跳转父窗口
		var target = $(this).find('input[type="hidden"]').attr("target");
		var url = $(this).find('input[type="hidden"]').val();
		if (url != undefined) {
			if (target == "_parent") {
				window.parent.location = url;
			} else {
				window.location.href = url;
			}
		}
	});
	/*
	 * iframe 自适应高度
	 */
	$('iframe').load(function(){
		iframeAutoSet(this);
	});
	
	// 控制页签
	$(function(){
		var anchor = location.hash;
		if(anchor!=""){
			var index = anchor.replace("#", "");
			$(".clourstitle li[index="+index+"]").click();
		}
	});
	// 设置页签锚记
	$(".clourstitle li").click(function(){
		var index = $(this).attr("index");
		location.hash = "#"+index;
	});
	//删除
	$('.tb_remove').live('click', function () {
        var _this = $(this);
        url = _this.attr('td_url');
        if(url!=''){
	        layer.confirm('确定删除吗？',function(index){
	            location.href = url;
	        });
	    }
    });
	
	// 查找TD下指定class属性添加标签样式自动隐藏超出框度的字符
	/*function ellipsis(){
		if($("tr .ellipsis").length>0){
			$("tr .ellipsis").each(function() {
				//var widthDef = "180px";
				// 获取当前元素字号
				var fontpx = $(this).css("font-size");
				var fontSize = fontpx.substring(0,fontpx.length-2);
				// 计算列默认宽度减"..."的宽度
				var widthDef = this.offsetWidth - "...".getWidth(fontSize);
				var div = document.createElement("div");
				// 获取表格文本
				var txt = $(this).text();
				// 设置提示文本
				$(this).attr("title",txt);
				// 指定宽度
				if(typeof($(this).attr("width")) != "undefined"){
					widthDef = $(this).attr("width");
				}
				$(div).css({"width":widthDef,"overflow":"hidden","-o-text-overflow":"ellipsis","text-overflow":"ellipsis","white-space":"nowrap"});
				$(this).html($(div).html(txt));
			});
		}
	}
	ellipsis();*/
	//
	function hiddentext(){
		//debugger
		var hiddentr = $(".hiddentext");
		//debugger;
		var hiddenlen = hiddentr.length;
		for(var i=0;i<hiddenlen;i++){
			var html = $(hiddentr[i]).text();
			$(hiddentr[i]).attr('title',html);
			$(hiddentr[i]).html('<div><span>'+html+'</span></div>');
			//debugger;
			var hiddendiv = $(hiddentr[i]).find('div');
			//debugger;
			var hiddenchild = $(hiddentr[i]).find('span');
			//console.log(hiddendiv[0].offsetHeight,hiddenchild[0].offsetHeight);
			var fontpx = hiddenchild.css("font-size");
			var fontSize = fontpx.substring(0,fontpx.length-2);
			//debugger
			if(hiddendiv[0].offsetHeight<hiddenchild[0].offsetHeight){
				$(hiddendiv[i]).addClass('addhidden').css({'padding-right':"...".getWidth(fontSize)});
				var str = $(hiddentr[i]).attr('title');
				var strlen = str.length;
				for(var j=0;j<strlen;j++){
					swidth = str.substr(0,j).getWidth(fontSize);
					//console.log(hiddendiv[0].offsetWidth,swidth);
					if(hiddendiv[0].offsetWidth>swidth){
						//console.log(str.substr(0,j-1));
						hiddenchild.html(str.substr(0,j-1)+'...');
						//continue;
						//break;
					}
				}

				//debugger;
				//console.log('隐藏')
			}else{
				$(hiddendiv[i]).removeClass('addhidden').css({'padding-right':0});
			}
		}
	}
	hiddentext();
	$(window).resize(function(){
		//console.log('resize');
		// 方法1
		//ellipsis();
		// 方法2
		hiddentext();
	});
	
	$(".importdata").click(function(){
        $.layer({
            type : 1,
            title : '导出',
            offset:['150px' , ''],
            border : false,
            shadeClose:true,
            fadeIn: 300,
            btns: 2,
            btn: ['导出', '取消'],
            yes:function(index){
                $("#exportForm").submit();
                layer.close(index);
            },
            area : ['603px','400px'],
            page : {dom : '.importbox'}
        });
    });
    $(".addOption").on('click',function(){
        if($("#select_left option:selected").length>0){
            $("#select_left option:selected").each(function(){
                $("#select_right").append("<option selected readonly='true' value='"+$(this).attr("name")+"' name='"+$(this).attr("name")+"'>"+$(this).text()+"</option>");
                var val = $(this).attr("value");
                val = val==""||val==undefined?$(this).val():val;
                $("#exportForm").append("<input type='hidden' name='"+$(this).attr("name")+"' value='"+val+"'>");
                $(this).remove();
            });
        }else{
            alert("请选择要添加的字段");
        }
    });
    $(".delOption").on('click',function(){
        if($("#select_right option:selected").length>0){
            $("#select_right option:selected").each(function(){
                $("#select_left").append("<option value='"+$(this).val()+"' name='"+$(this).attr("name")+"'>"+$(this).text()+"</option");
                $("input[name='"+$(this).attr("name")+"']").remove();
                $(this).remove();
            });
        }else{
            alert("请选择要删除的字段");
        }
    });
    
    //IE也能用textarea 
    $(function() {
		$("textarea[maxlength]").keyup(function() {
			var area = $(this);
			var max = parseInt(area.attr("maxlength"), 10); //获取maxlength的值 
			if (max > 0) {
				if (area.val().length > max) { //textarea的文本长度大于maxlength 
					area.val(area.val().substr(0, max)); //截断textarea的文本重新赋值 
				}
			}
		});
		//复制的字符处理问题 
		$("textarea[maxlength]").blur(function() {
			var area = $(this);
			var max = parseInt(area.attr("maxlength"), 10); //获取maxlength的值 
			if (max > 0) {
				if (area.val().length > max) { //textarea的文本长度大于maxlength 
					area.val(area.val().substr(0, max)); //截断textarea的文本重新赋值 
				}
			}
		});
	});
    
});

// js动态生成的iframe无法绑定load只能直接调用
function iframeAutoSet(iframeObj){
	// 设置默认最小高度
	var defMinHeight = "300";
	var height;
	var win = iframeObj;
	if (document.getElementById) {
		if (win && !window.opera) {
			if (win.contentDocument && win.contentDocument.body.offsetHeight){}
				height = win.contentDocument.body.offsetHeight;
				win.height = height>defMinHeight?height:defMinHeight;
			}else if (win.Document && win.Document.body.scrollHeight){
				height = win.Document.body.scrollHeight;
				win.height = height>defMinHeight?height:defMinHeight;
			}
		}
	/*
	var height = (iframeObj.Document?iframeObj.Document.body.scrollHeight:iframeObj.contentDocument.body.offsetHeight+30);
	height = height>defMinHeight?height:defMinHeight;
	setTimeout(function(){if(!iframeObj) return;iframeObj.height=height;},200);*/  
}

function isCardNo(card){  
   // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X  
   var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;  
   if(reg.test(card) === false){  
       alert("身份证输入不合法");  
       return  false;  
   }
   return true;
}


$.cascadeselect=function(param){
	$.ajax({
	   type: 'POST',
	   url: param.url ,
	   data: param.data ,
	   cache:false,
	   async :false,
	   dataType:'jsonp',
       json:'callback',
       success:function (json) {
           if (json.code == 0) {
        	   var options="<option value='"+param.defaultval+"'>"+param.defaultopt+"</option>";
               for (var i=0; i<json.data.length; i++) {
            	   options+="<option value='"+json.data[i].id+"'>"+json.data[i].name+"</option>";
               }
               $(param.id).html(options);
           }
       }
	});
}
//绑定级联选单
jQuery.fn.bindcascade=function(param){
	$(this).change(function(){
		param.data={vendorId:$("#vendorId").val(),serviceId:$(this).children('option:selected').val()};
		$.cascadeselect(param);
	});
}