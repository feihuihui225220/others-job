<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>套餐管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<style>
.input165{width: 165px; height: 30px;}
</style>
</head>
<body>
#parse("/common/masklayer.tpl")
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
            <form action="/ICareCombo/combo/list" method="post" name="searchForm">
                <select class="input165 tiaozhuan"> 
                    <option  value="2">套餐管理</option>
                    <option  value="1">评估量表管理</option>
                    <option  value="3">体适能管理</option>
                </select>
                <label>套餐名称:</label><input class="input165" name="zName" value="$!zName">
                <label>添加时间:</label><input class="timedate" name="start" value=$!date.format('yyyy-MM-dd',$dateVO.start)>-<input class="timedate" name="end" value=$!date.format('yyyy-MM-dd',$dateVO.end)>
                <label><button class="btn button_gm" style="position: relative;left: -230px;"> 查询</button><input class="btn button_gm" onclick="javascripts:location.href='/ICareCombo/combo/toOperate'" value="添 加" type="button"></label>
                
            </form>
             </div>
            #if ($page)
               <table class="tb table_col4 tab_115">
                  <col class="col1"/><col class="col1"/><col class="col3"/><col class="col4"/>
                  <tr>
                      <th>套餐名称</th>
                      <th>套餐价格</th>
                      <th>套餐原价</th>
                      <th>适用年龄</th>
                      <th>操作</th>
                  </tr>
                  #foreach ($cob in $page.result)
                  <tr>
                     <td>$!cob.comboName</td>
                     <td>$!cob.price</td>
                     <td>$!cob.originalPrice</td>
                     <td>$!cob.forAge</td>
                     <td style="padding-left: 5%;"><a href="/ICareCombo/combo/toOperate?id=$!cob.comboId"> 修改 </a>&nbsp;&nbsp;<a class="putaway $!cob.comboId" data-value="$!cob.comboId" href="#">#if($!cob.putaway)下#else上#end架</a>&nbsp;&nbsp;
                     <a href="#" data-value="$!cob.comboId" class="delete_"> 删除 </a></td>
                  </tr>
                  #end
              </table>
              #parse("/common/page.tpl")
           #end
        </div>
    </div>
    <div class="footer"></div>
</div>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
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
        
        
       
        
        $('.putaway').click(function(){
              var success=$(this).attr("data-value");
             $.ajax({
                url: "/ICareCombo/combo/putaway?id=" + $(this).attr("data-value"),
                success: function (mjon) {
                    alert(mjon);
                   if(mjon=="成功"){
                       if($("."+success).html()=="上架"){
                            $("."+success).html("下架");
		                }else{
		                    $("."+success).html("上架");
		                }
		           }
                }
            });
        });
        
        $('.delete_').click(function(){
            var r=confirm("确定要删除吗？");
            var id=$(this).attr("data-value");  
            location.href="/ICareCombo/combo/remove?id="+id;
        });
       
    })
</script>
</body>
</html>