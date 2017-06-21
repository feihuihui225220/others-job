<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/reg.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
<script src="$request.contextPath/assets/js/jquery.validate.js"></script>
<script type="text/javascript">
$().ready(function() {
 $("#knowledgeForm").validate({
    rules: {
   title: "required",
   keyword:"required",
   publisher:"required",
   content:"required",
   
  },
   messages: {
  title: "<span style='color:#f00;'>*请输入标题</span>",
   keyword:"<span style='color:#f00;'>*请输入关键字</span>",
   publisher:"<span style='color:#f00;'>*请输入发布人</span>",
   content:"<span style='color:#f00;'>*请输入知识内容</span>",
  }
    });
});
</script>
<style>
.tb td {text-align:left;padding:10px;vertical-align:middle;}
.tb td input {vertical-align:middle;margin:0;}
.tb .t_r {text-align:right;}
.limitbox3 .fix_ser .col1 {width:15%;}
.limitbox3 .fix_ser .col2 {width:30%;}
.limitbox3 .fix_ser .col3 {width:15%;}
.limitbox3 .fix_ser .col4 {width:30%;}
.tb table td, .tb table th {text-align:center;}
.tb table .col11 {width:5%;}
.tb table .col22 {width:35%;}
.tb table .col33 {width:60%;}
.tb label {display:inline-block;*display:inline;zoom:1;width:150px;margin-right:15px;line-height:2;}
</style>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <form method="post" action="editKnowledgeById" id="knowledgeForm" class="reg_area fix_pop" style="width:700px">
        <h2>编辑知识</h2>   
        <div class="limitbox limitbox3 pad10 ">
            <table class="tb table_col4 fix_ser tab_115">
                <col class="col1"/><col class="col2"/><col class="col3"/><col class="col4"/>
                #if($detail)
                <tr> 
                    <td class="t_r" >名称:</td>
                    <td><input name="title" value="$!{detail.title}"/></td>
                    <td class="t_r">关键字：</td>
                    <td><input name="keyword" value="$!{detail.keyword}"/></td>
                </tr>
                <tr>
                    <td class="t_r">发布人：</td>
                    <td><input name="publisher" value="$!{detail.publisher}"/></td>
                    <td class="t_r">分类：</td>      
                    <td>
                     #*   <select name="categoryId">  
                            <option value="${detail.categoryId}"  >
                            ${detail.categoryItem.itemName}</option> 
                        </select>        
                    *#
                    
                     #if($maplist)
                        <select name="categoryId">  
                        #foreach($m in $maplist.entrySet())   	
                            <option value="${m.value.id}"  
                            #if($!{m.value.id}==${detail.categoryId})selected=true#end>
                            ${m.value.itemName}</option> 
                        #end
                        </select>  
                    #end  
                    </td>
                    <input type="hidden" name="id" value="${detail.id}"/>
                     
                </tr>
                <tr>
                    <td class="t_r">内容：</td>
                    <td colspan="3"><textarea cols="62" rows="6" name="content" >$!{detail.content}</textarea></td>
 
                </tr>
                #end
            </table>
        </div>
        <p class="opt">
			<button class="btn button_delete" type="button" onclick='window.location.href="knowledgelist" '>取 消</button>
			<button type="submit" class="btn  button_gm">修 改</button>
		</p>
    </form>
    <div class="footer">

    </div>
</div>
</body>
</html>