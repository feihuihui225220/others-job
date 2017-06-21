<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>分数型试题</title>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css"/>
    <link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css"/>
    <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
    #parse("/common/head.tpl")
    <form method="post" action="/professional/assess/qa/commit" enctype="multipart/form-data" class="reg_area fix_pop"
          style="width:800px">
        <h2>添加试题（输入项请在选项内容一栏写入 填写项）</h2>
        <input type="hidden" name="page" value="${page.page}"/>
        <input type="hidden" name="num" value="${page.num}"/>
        <input type="hidden" name="assessId" value="$!{assessId}"/>
        <input type="hidden" name="type" value="${type}"/>
        <input type="hidden" name="id" value="$!{assessQa.id}"/>

        <div class="limitbox limitbox3 pad10">
            <ul class="inpubox clearfix">
                <li><label>试题内容：</label><textarea cols="90" rows="5" name="content">$!{assessQa.content}</textarea></li>
                <li><label>图片上传：</label>
                    <input type="file" name="file" value=""/>
                    <span class="file_name"></span>
                </li>
            </ul>
            <div class="admin_cate_opt">
                <button class="btn btn2 button_gm" type="button" >增加选项</button>
                <div >多选<input type="checkbox" name="assessType"/></div>
            </div>
            <table class="tb table_col4">
                <col class="col1"/>
                <col class="col2"/>
                <col class="col2"/>
                <col class="col2"/>
                <col class="col4"/>
                <tr>
                    <th>序号</th>
                    <th>选项内容</th>
                    <th>选项分数</th>
                    <th>建议</th>
                    <th>操作</th>
                </tr>
                #if($assessQa)
                #set($i=1)
                #foreach ($answer in $assessQa.answers)
                <tr>
                    <td>${answer.code}</td>
                    <td><input type="text" name="answers[$!{velocityCount}].content" value="${answer.content}"/></td>
                    <td><input type="text" name="answers[$!{velocityCount}].score" value="${answer.score}"/></td>
                    <td><input type="text" name="answers[$!{velocityCount}].aconclusion" value="$!{answer.aconclusion}"/></td>
                    <td><span class="tb_remove2 button_delete">删除</span><input type="hidden" name="answers[$!{velocityCount}].code"
                                                                 value="${answer.code}"/></td>
                    <input type="hidden" name="answers[$!{velocityCount}].id" value="$!{answer.id}"/>
                </tr>
                #set($i=$i+1)
                #end
                #end
            </table>
        </div>
        <p class="opt">
            <input type="button" class="btn button_delete" onClick="javascripts:history.go(-1)" value="取 消"/>
            <button type="submit" class="btn  button_gm">添 加</button>
        </p>
    </form>
    <div class="footer">

    </div>
</div>

<script>

    $(function () {

        $('.btn2').click(function () {
            if ($('.table_col4 tr').length > 13) return;
            var i = $('.table_col4 tr').length - 1;
            $('.table_col4').append('<tr><td>' + 'ABCDEFGHIJKLM'.charAt($('.table_col4 tr').length - 1) + '</td><td><input name="answers[' + i + '].content" type="text" /></td><td><input name="answers[' + i + '].score" type="text" /></td><td><input name="answers[' + i + '].aconclusion" type="text" /></td><td><span class="tb_remove2 button_delete">删除</span><input name="answers[' + i + '].code" value=' + 'ABCDEFGHIJKLM'.charAt($('.table_col4 tr').length - 1) + ' type="hidden"/></td><input type="hidden" name="answers[' + i + '].id" value="0"/></tr>');

        });

        $('.tb_remove2').live('click', function () {
            $(this).parent().parent().remove();
            $('.table_col4 tr').find('td:eq(0)').each(function (index, domEle) {
                $(domEle).html('ABCDEFGHIJKLM'.charAt(index));
            });
            $('.table_col4 input').each(function (index, domEle) {
                switch (index % 5) {
                    case 0 :
                        $(this).attr('name', 'answers[' + ($(this).parent().parent().index() - 1) + '].content');
                        break;
                    case 1 :
                        $(this).attr('name', 'answers[' + ($(this).parent().parent().index() - 1) + '].score');
                        break;
                    case 2 :
                        $(this).attr('name', 'answers[' + ($(this).parent().parent().index() - 1) + '].aconclusion');
                        break;
                    case 3 :
                        console.log(($(this).parent().parent().index() - 1));
                        $(this).attr('name', 'answers[' + ($(this).parent().parent().index() - 1) + '].code');
                        $(this).attr('value', $(this).parent().parent().find('td:eq(0)').html());
                        break;
                    case 4 :
                        console.log(($(this).parent().parent().index() - 1));
                        $(this).attr('name', 'answers[' + ($(this).parent().index() - 1) + '].id');
                        //$(this).attr('value', $(this).parent().parent().find('td:eq(0)').html());
                        break;
                }
            });
        });

    });
</script>
</body>
</html>