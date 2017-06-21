<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>套餐管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
 <link href="/ueditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
 
<style>
.input165{width: 165px; height: 30px;}
.black_overlay {
    display: none;
    position: absolute;
    top: 0%;
    left: 0%;
    width: 100%;
    height: 100%;
    background-color: black;
    z-index: 1001;
    -moz-opacity: 0.8;
    opacity: .80;
    filter: alpha(opacity = 80);
}

.white_content {
    display: none;
    position: absolute;
    top: 25%;
    left: 22%;
    width: 50%;
    height: 50%;
    padding: 16px;
    background-color: white;
    z-index: 1002;
    overflow: auto;
}
.btn{float: left;margin-right: 20px;}
</style>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline">
        <div class="">
            <div class="admin_cate_opt">
                <select class="input165 tiaozhuan"> 
                    <option  value="3">体适能管理</option>
                    <option  value="2">套餐管理</option>
                    <option  value="1">评估量表管理</option>
                </select>
                <label><input class="btn button_gm" id="add_fit"   value="添 加" type="button"></label>
             </div>
            #if ($list)
               <table class="tb table_col1 tab_115">
                  <col class="col1"/><col class="col1"/><col class="col3"/><col class="col4"/>
                  <tr>
                      <th>体适能类型</th>
                      <th>单位</th>
                      <th>操作</th>
                  </tr>
                  #foreach ($vo in $list)
                  <tr>
                     <td>$!vo.FName</td>
                     <td>$!vo.monad</td>
                     <td style="padding-left: 5%;"><a href="#" class="add_fit" data-id="$!vo.FId" data-name="$!vo.FName"  data-monad="$!vo.monad"> 修改 </a>&nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="#" data-value="$!vo.FId" class="delete_"> 删除 </a></td>
                  </tr>
                  #end
              </table>
              #parse("/common/page.tpl")
           #end
        </div>
    </div>
     <script type="text/plain" id="myEditor" style="width:60%;height:60%; ">
                $!nProgram.programDesc
                </script>
                <script type="text/javascript">
                    //实例化编辑器
                    var um = UM.getEditor('myEditor');
                    function getContent() {
                        var arr = [];
                        arr.push(UM.getEditor('myEditor').getContent());
                        return arr.join("\n");
                    }
                </script>
    <div id="light" class="white_content">
            <form id="addAndUpdate" action="" enctype=multipart/form-data method="post" autocomplete="off">
                 <input type="hidden" class="FId" name="FId" value="$!fid"> 
                 <input type="hidden" class="parentId" name="parentId" value="$!parentId">
                 <label>问题:</label><input type="text" class="fName" autocomplete="off" name="FName" value="$!zfit.FName"> 
                 <label>单位:</label><input type="text" class="monad" autocomplete="off" name="monad" value="$!zfit.monad"> 
                 <label>上传图片:</label><input  multiple="true"  type="file" name="imgs"> 
            </form>    
               
        
        
        
        
            <input class="btn button_gm"  id="button_add" type="button"  value="编辑">
            <input class="btn button_delete" type="button" onclick="javascript:location.href='/ICareFitness/zfitness/operationChild?parentId='+$parentId";" value="取消">
        </div>
      <div id="fade" class="black_overlay">
            <div class="footer"></div>
      </div>
    <script>
    
    <div class="footer"></div>
</div>

<script src="/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/jquery-2.1.4.min.js"></script>
<script>
    $(function(){
        $(".timedate").calendar({format: 'yyyy-MM-dd'}).css({width: '165px', height: '30px'});
        $('.tiaozhuan').change(function(){
            if($(this).attr('value')==1){
                location.href="/professional/assess";
            }else if($(this).attr('value')==2){
                location.href="/ICareFitness/combo/list";      
            }else{
                location.href="/ICareFitness/zfitness/insert";     
            }
        });
        $('.delete_').click(function(){
            var r=confirm("确定要删除吗？");
            var id=$(this).attr("data-value");  
            location.href="/ICareFitness/zfitness/delete?fId="+id;
        });
       
    })
    
    $('.add_fit').click(function(){
         var id=$(this).attr("data-id");
        var name=$(this).attr("data-name");
        var monad=$(this).attr("data-monad");
        var parentId=$('.parentId').val();
        
       location.href="/ICareFitness/ZFitness/toAddAll?FName="+name+"&monad="+monad+"&FId="+id+"&parentId="+parentId;
    });
    $('#button_add').click(function(){
        $("#addAndUpdate").submit();
    });
    
    $('#add_fit').click(function(){
        var parentId=$('.parentId').val();
       location.href="/ICareFitness/ZFitness/toAddAll?parentId="+parentId;
    });
</script>
</body>
</html>