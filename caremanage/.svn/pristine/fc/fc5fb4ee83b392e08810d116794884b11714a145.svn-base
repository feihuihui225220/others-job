<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="author" content="angtian">
<title>站点具体内容</title> #parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/newCss/plan.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<script src="/assets/js/yui-min.js"></script>
<link rel="stylesheet" href="/assets/newCss/index.css" />
<style>
table tr td {
    height: 20px !important;
    width:15px !important;
}
.calendar-bounding-box{
    position: relative;
    width: 120px;!important;
    }
table{position: relative;left: 10px;top:-95px;}
.next-btn{position: relative;left: -50px;}
#calendar-yui_3_5_1_1_1482838783722_18{height:210px !important;}
.table_{position: relative;top: -360px;width:400px;}
body{background-color: white;}
</style>
</head>
<body>
      #parse("/common/head.tpl")
             #parse("/ICare/ICleft.tpl")
    <div style="position: relative;left: 300px;">
        <div id="J_Calendar" class="calendar" style="width:60%;height:80%"></div>
        <div style="float:right;position: relative;left:-450px;">
        <table class="table_">
            <tr>
                <th>课程名称</th>
                <th>时长</th>
                <th>删除</th>
            </tr>
            #foreach($z in $list)
                <tr>
                <td>$z.programName</td>
                <td>$z.programTime</th>
                <td><a href="#" class="delete_cour" date-id="$z.courseId">删除</a></td>
            </tr>
            #end
        </table>
        </div>
        <div  class="nprLisr"  style="position: relative;left: -50px;">
         <form id="from" action="/ICareCourse/zCourse/insert" method="post">
               <input type="button" class="add_npr" value="新增一条"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
               <input type="hidden"  name="userId" value="$userId">
               <input type="hidden" id="date" name="date" value="$date">
               <input type="hidden" id="nprIds" name="nprIds" >
               <input type="button" class="submit_from" value="提交">
        </form><br><br>
               <label>选择课程</label><select class="leixing">
                <option value="-1">==请选择==</option>
                #foreach($n in $npr)
                <option value="$n.id">$n.programName</option>
                #end
               </select>
               <select class="kecheng">
                <option value="0">==请选择==</option>
               </select><a class="delete_npr">删除</a>
        </div>
       
    </div>
    
    <div style="display: none">
        <select class="hidens leixing">
                <option value="-1">==请选择==</option>
                #foreach($n in $npr)
                <option value="$n.id">$n.programName</option>
                #end
               </select>
    </div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script>
    YUI({
        modules : {
            'trip-calendar' : {
                fullpath : '/assets/js/trip-calendar.js',
                type : 'js',
                requires : [ 'trip-calendar-css' ]
            },
            'trip-calendar-css' : {
                fullpath : '/assets/css/trip-calendar.css',
                type : 'css'
            }
        }
    }).use(
            'trip-calendar',
            function(Y) {

                /**
                 * 非弹出式日历实例
                 * 直接将日历插入到页面指定容器内
                 */
                var oCal = new Y.TripCalendar({
                    container : '#J_Calendar', //非弹出式日历时指定的容器（必选）
                    selectedDate : new Date
                //指定日历选择的日期
                });
                //日期点击事件
                oCal.on('dateclick', function() {
                    var selectedDate = this.get('selectedDate');
                    var userId=$("input[name='userId']").val();
                   location.href="/ICareCourse/zCourse/list?userId="+userId+"&date="+selectedDate;
                    $('#date').val(selectedDate);
                   // location.href="/professional/activity/DateList?pubdate="+ selectedDate;

                });
                Y.one('#J_Example').delegate('click', function(e) {
                    var oTarget = e.currentTarget;
                }, 'button', oCal);
            });
            
      $(function(){
        $(document).on('change','.leixing',function(){
            var mun=$(this);
            $.ajax({
                url: "/ICareCourse/zCourse/getNProgram?id=" + $(this).val(),
                success: function (mjon) {
                      var msg = eval("("+mjon+")"); 
                      mun.next().find('.mjson_class').remove();
                      for (var i = 0; i < msg.length; i++) {
                        mun.next().append("<option  class='mjson_class' value='" + msg[i].id + "'>" + msg[i].programName + "</option>")
                    }  
                }
        });
            
        });
      
        $('.add_npr').click(function(){
            $('.nprLisr').append("<br><br><label>选择课程</label>");
            $('.nprLisr').append($('.hidens:first').clone());
            $('.nprLisr').append('<select class="kecheng"><option value="0">==请选择==</option></select><a class="delete_npr">删除</a>');
        });
        $(document).on('click','.delete_npr',function(){
            $(this).prev('.kecheng').prev('.leixing').prev().prev().prev().remove();
            $(this).prev('.kecheng').prev('.leixing').prev().prev().remove();
            $(this).prev('.kecheng').prev('.leixing').prev().remove();
            $(this).prev('.kecheng').prev('.leixing').remove();
            $(this).prev('.kecheng').remove();
            $(this).remove();
        });
        $(".submit_from").click(function(){
            if($('#date').val()==""){
                var d=dateConvert(new Date());
                alert(d);
                $('#date').val(d);
            }
            var ids="";
            var i=0;
            $('.kecheng').each(function(){
                if($(this).val()!=0){
                 if(i!=0){
                  ids+=","  
                 }
                  ids+=$(this).val();
                  i=2;
                }
            });
            if(ids!=""){
                 $('#nprIds').val(ids);
                $('#from').submit();
            }else{
                alert("请选择课程！");
                return false;
            }
            
        });
        function dateConvert(dateParms){ 
		    // 对传入的时间参数进行判断
		    if(dateParms instanceof Date){
		        var datetime=dateParms;
		    }
		    //判断是否为字符串
		    if((typeof dateParms=="string")&&dateParms.constructor==String){
		        //将字符串日期转换为日期格式
		        var datetime= new Date(Date.parse(dateParms.replace(/-/g,   "/")));
		     
		    }
		    //获取年月日时分秒
		     var year = datetime.getFullYear();
		     var month = datetime.getMonth()+1; 
		     var date = datetime.getDate(); 
		     //月，日 0
		     if(month<10){
		      month = "0" + month;
		     }
		     if(date<10){
		      date = "0" + date;
		     }
		     //拼接日期格式【例如：yyyy-mm-dd】
		     var time = year+"-"+month+"-"+date; 
		      
		     //或者：其他格式等
		     //var time = year+"年"+month+"月"+date+"日"+hour+":"+minutes+":"+second; 
		     //返回处理结果
		     return time;
		    }
      });
      
      $('.delete_cour').click(function(){
        var id=$(this).attr("date-id");
        var userId=$("input[name='userId']").val();
        alert(userId);
        var con=confirm("是否删除？");///ICareCourse/userPhoto/delete
        if(con){
            location.href ="/ICareCourse/zCourse/remove?id="+id+"&userId="+userId;
        }
      });      
</script>
</html>
