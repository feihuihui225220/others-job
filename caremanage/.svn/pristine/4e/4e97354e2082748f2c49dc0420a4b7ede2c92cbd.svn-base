<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>套餐操作</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<style>
.input165{width: 165px; height: 30px;}
.select150{width: 165px;height: 200px;position: relative; left: 75px;}
.padding50{padding-left: 50px;padding-top: 50px;}
.a_color{color: red;font-size: 20px;}
</style>
<script>
    function publish(assessId, pageNo, pageSize, status) {
        if(status){
            window.open("/professional/assess/abolish?page=" + pageNo + "&num=" + pageSize + "&assessId=" + assessId, "_self");
        }else{
            window.open("/professional/assess/publish?page=" + pageNo + "&num=" + pageSize + "&assessId=" + assessId, "_self");
        }
    }
    
</script>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
  <div class="body bodyline padding50">
        <form action="/ICareCombo/combo/operate" method="post" name="searchForm" id="sear" encType="multipart/form-data">
                <input type="hidden" name="comboId"  value=$!zCombo.comboId>
                <input type="hidden" name="nprogramIds" id="nprogramIds">
                <label>套餐名称：</label><input class="input165" id="comboName" name="comboName" value="$!zCombo.comboName"><a class="a_color">*</a><br><br>
                <label>套餐封面：</label><input  name="pic" type="file"><br><br>
                <label>选择课程：</label>
                <select class="input165 selectParent">
                 #foreach($param in $nprop)  
                        <option #if($prentId==$!param.id) selected="selected" #end value=$!param.id>$!param.programName</option>
                 #end  
               </select><br><br>
               <select class="select1 select150" multiple="multiple" name="c" >
                 #foreach($param in $childrenlist) 
                   <option value=$!param.id>$!param.programName</option>
                 #end   
               </select>
               <select  class="select2 select150" multiple="multiple"  name="c">
                #if($!nProgram)
                 #foreach($param in $nProgram) 
                    <option value=$!param.id>$!param.programName</option>
                 #end   
                #end   
               </select><br><br><br>
               <label>适用年龄：</label><input name="forAge" value="$!zCombo.forAge"><br><br>
               <label>套餐效果：</label><textarea id="effect" name="effect" rows="10" cols="80">$!zCombo.effect</textarea><br><br>
               
               <label>套餐时间：</label><br>
               <div style="padding-left: 30px;padding-top: 20px;">
                            连续上课天数:<input id="attendClass" name="attendClass" value="$!zCombo.attendClass"><a class="a_color">*</a><br><br>
                            连续休息天数:<input id="finishClass" name="finishClass" value="$!zCombo.finishClass"><a class="a_color">*</a><br><br>
               </div> 
               <label>套餐售价:</label><input id="price" name="price" value="$!zCombo.price">元<a class="a_color">*</a><br><br>
               
               <div style="padding-left: 30px;padding-top: 20px;">
               <input class="button_gm btn" style="float: left;margin-right: 50px" type="button" value="保存"><input style="float: left;" class="button_delete btn" type="button" value="取消">
               </div>
               
        </form> 
  </div>
  <div class="footer"></div>
</div>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/calendar.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script>
$(function(){
    $(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '165px', height: '30px'});
    $('.tiaozhuan').change(function(){
       if($(this).attr('value')==1){
            location.href="/professional/assess";
        }else if($(this).attr('value')==2){
            location.href="/ICareCombo/combo/list";     
        }else{
            location.href="/ICareFitness/zfitness/insert";      
        }
    });
    
   option();
    
});

function option(){
     if($(".select2 option").length!=0){
        $(".select2 option").each(function(){
             var id=$(this).val();
             $(".select1 option").each(function(i,e){
                    var id1=$(e).val();
                    if(id1==id){
                        $(this).remove();
                    }          
            });
        });
    }

}
$(function(){
    $(".select1").dblclick(function(){
       $(".select2").append( $(".select1 option:selected"));
    });
    $(".select2").dblclick(function(){
       $(".select1").append( $(".select2 option:selected"));
    });
    
    $('.selectParent').change(function(){
        $.ajax({
                url: "/ICareCombo/combo/nprop?parentId=" + $(this).val(),
                success: function (mjon) {
                       $(".select1 option").remove();
                      var msg = eval("("+mjon+")"); 
                      for (var i = 0; i < msg.length; i++) {
                        major_tr = ("<option  class='mjson_class' value='" + msg[i].id + "'>" + msg[i].programName + "</option>")
                        $(".select1").append(major_tr);
                    }  
                option();
                }
        });
    });
    $('.button_gm').click(function(){
        var  nprogramIds="";
        var i=0;
        $(".select2 option").each(function(){
             if(i!=0){
                 nprogramIds+=",";
             }
             i++;
             var id=$(this).val();
             nprogramIds+=id;
        });
        if(nprogramIds!=""){
            $("#nprogramIds").val(nprogramIds);
        }else{
            alert("请选择至少一门课程！");
            return false;
        }
       var patten = /^-?\d+\.?\d{0,1}$/;
       var price=$("#price").val();
	   if(!patten.test(price)){  
	       alert("套餐价格格式不对！"); 
	       $("#price").val(""); 
	       return  false;  
	   }
       var attendClass=$("#attendClass").val();
	   if(!patten.test(attendClass)){ alert("连续上天次数为必填项且不能包含汉字！");return false; }
       var finishClass=$("#finishClass").val();
	   if(!patten.test(finishClass)){ alert("连续休息天数为必填项且不能包含汉字！");return false; }
       var comboName=$("#comboName").val();
	   if(comboName.replace(/(^\s*)|(\s*$)/g, "")==""){  
	       alert("套餐名称是必填项！")
	       return false;
	   }
       $("#sear").submit();
      
    });
    
});


</script>
</body>
</html>