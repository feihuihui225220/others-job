<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>vip介绍修改</title>
#parse("/common/top.tpl")
<link rel="stylesheet" type="text/css" href="../../assets/director/style/filing.css">
</head>
<body>
#parse("/common/head.tpl")
#parse("/ICare/ICmain.tpl")
<div class="wrapper" style="margin: 0 auto;width: 800px;">
<form action="/icare/vip/modify" method="post" enctype="multipart/form-data" >          	
            <div class="actboxlist">
                <input type="hidden" name="id"  value="$!list.id"/>
                <div class="actbox8 ">
                
                    <table class="table100 usertable" >
                        <tr>
                        	<td>上传图片：<input type="file" name="pic"  style="border: 1px solid #CCC;" /><br/>
                     
                        	</td>
                        </tr>
                        <tr>
                        	<td>服务名称：<input type="text" name="serviceName"  value="$!list.serviceName" style="width: 300px;height: 30px;"/></td>
                        </tr>
                         <tr>
                        	<td>服务流程：<textarea name="chargeInfo" style="width: 300px;height: 200px;">$!list.chargeInfo</textarea></td>
                        </tr>
                        <tr>
                        	<td>服务内容：<textarea  name="serviceDetail"  style="width: 300px;height: 200px;">$!list.serviceDetail</textarea></td>
                        </tr>
                        
                    </table>
                    <input type="submit" value="提交" class="btnBg" style=" margin-left: 200px;"/>
                </div>
            </div>
            </form>

	<div>
</div>

</body>
<script type="text/javascript" src="../../assets/director/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/assets/js/country_1.js"></script>
 <script type="text/javascript" src="/assets/js/calendar.js"></script>
 <script type="text/javascript" src="/assets/js/lhgcalendar.min.js"></script>
</html>