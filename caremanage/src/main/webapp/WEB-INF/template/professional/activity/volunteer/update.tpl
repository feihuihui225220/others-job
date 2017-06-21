<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>志愿者,列表</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="/assets/css/yonghuguanli.css"/>
    <script src="/assets/js/pageNavigator.js"></script>
    <script src="/assets/js/wss.js"></script>
</head>
<body>
<div class="wrapper"></div>
<div style="margin-top: 10px;margin-left: 10px ;margin-right: 10px">
#if ($list_vo)
#foreach($e in $list_vo)
<div style="width:400px;margin: 0 auto;">
    <form class="form" method="post" action="/professional/volunteer/update" id="" name="add_volunteer" style="display: block;">
        <fieldset>
            <div class="form-group">
                <label>姓名</label>
                <input type="text" name=id value="$!{e.id}" style="display: none">
                <input type="text" class="form-control vo_post" placeholder="姓名" name="name" value="$!{e.name}">
            </div>
            <div class="form-group">
                <label>性别</label>
                <input type="text" class="form-control vo_post" placeholder="性别" name="sex" value="$!{e.sex}">
            </div>
            <div class="form-group">
                <label>年龄</label>
                <input type="text" class="form-control vo_post" placeholder="年龄" name="age" value="$!{e.age}">
            </div>
            <div class="form-group">
                <label>电话</label>
                <input type="text" class="form-control vo_post" placeholder="电话" name="contact" value="$!{e.contact}">
            </div>

            <div class="form-inline">
                <div class="btn-group">
                   <label>社区</label><br/>
                    <div class="btn-group">
                    	<select id="community" name="community"   style="height:35px; width:200%">
							#foreach ($o in $oCuntry)
							#if($e.community==$o.id)
							
							<option value="$o.id">$!o.name</option>
							#end
							#end
							#foreach ($o in $oCuntry)
								<option class="select_community" value="$!o.id">$!o.name</option>
							#end
						</select>
                </div><br/><br/><br/>
				<label>操作</label><br/>
                <div class="form-group">
                	
                    <button type="submit" class="btn btn-default button_add" id="vo_submit">确定</button>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-default button_delete" onclick="javascript:history.back();">取消</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
#end
#end
</div>
</body>
<script>
    $(document).ready(function(){
        $("#add_volunteer").on("click",function(){
            location.href="/professional/volunteer/gotoAdd";
        });

        $("a").on("click",function(){
            var table_id = $(this).parent().attr("data-list");
            $(this).attr("href","update/"+table_id);
        });

    });

    $("#dropdown").children().click(function () {
        $("#community").val($(this).children().text());
    });

    $("#vo_submit").on("click",function(){
        var value=0;
        $(".vo_post").each(function(){
            if(!$(this).val()){
                value++;
            }
        });
        if(value>0){
            alert("输入信息不完整");
            return false;
        }
        value=0;
    })
</script>
</html>