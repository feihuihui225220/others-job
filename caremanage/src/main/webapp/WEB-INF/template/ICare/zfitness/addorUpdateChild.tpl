<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>套餐管理</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
 <link href="/ueditor/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
 <script src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/lhgcalendar.min.js"></script>
<script src="/assets/js/pageNavigator.js"></script>
<script type="text/javascript" charset="utf-8" src="/ueditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/ueditor/umeditor.min.js"></script>
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
            <form id="addAndUpdate" action="" method="post">
                 <input type="hidden" class="FId" name="FId" value="$!zfit.FId"> 
                 <input type="hidden" class="parentId" name="parentId" value="$!zfit.parentId">
                 <label>问题:</label><input type="text" class="fName" autocomplete="off" name="FName" value="$!zfit.FName"> 
                 <label>单位:</label><input type="text" class="monad" autocomplete="off" name="monad" value="$!zfit.monad"> 
                 <label>课件说明:</label>
                 <script type="text/plain" id="myEditor" name="imgUrl" style="width:60%;height:60%; ">$!zfit.imgUrl</script>
                <script type="text/javascript">
                    //实例化编辑器
                    var um = UM.getEditor('myEditor');
                    function getContent() {
                        var arr = [];
                        arr.push(UM.getEditor('myEditor').getContent());
                        return arr.join("\n");
                    }
                </script>
            </form>    
            <input class="btn button_gm"  id="button_add" type="button"  value="编辑">
            <input class="btn button_delete" type="button" onclick="javascript:location.href='/ICareFitness/zfitness/operationChild?parentId='+$parentId";" value="取消">
    <div class="footer"></div>
</div>
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
    
    $('#button_add').click(function(){
        var fid=$('.FId').val();
        if(fid!=""){
            $("#addAndUpdate").attr("action","/ICareFitness/zfitness/update");
        }else{
            $("#addAndUpdate").attr("action","/ICareFitness/zfitness/insert");
        }
        $("#addAndUpdate").submit();
    });
    $('#button_add').click(function(){
       // 
    });
    
    $('#add_fit').click(function(){
        $("#addAndUpdate").submit();
    });
</script>
</body>
</html>