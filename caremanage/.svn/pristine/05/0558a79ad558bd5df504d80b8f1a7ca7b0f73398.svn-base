<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" href="/assets/css/common.css" />
<link rel="stylesheet" href="/assets/css/reg.css" />
<link rel="stylesheet" href="/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="/assets/css/yonghuguanli.css" />
<script src="/assets/js/jquery-1.8.0.min.js"></script>
<script src="/assets/js/country.js"></script>
<style>
.inpubox li {width:290px;}
.mask_contact {padding-top:20px;}
.mask_contact table {width:72%;margin-left:112px;}
.mask_contact table a {color:#333;}
.mask_contact .inpubox li.w520 {width:640px;height: auto;}
.col2 {width:6em;}
.fix_car {padding-left:112px;margin-bottom:15px;}
</style>
</head>
<body>

<div class="wrapper">
   #parse("/common/head.tpl")
    <form method="post" id="form" action="/care/user/saveOrUpdate" class="reg_area fix_pop" style="width:960px" >
     <input type="hidden" name="id" value="$!{careUser.id}"/>
      <input type="hidden" name="userCategory" value="3"/>
        <h2>添加管理员</h2>
        <div class="mask_contact pad10">
            <h4>基本信息</h4>
            <ul class="inpubox clearfix">
                <li><label>名称：</label>
                <input class="text150" type="text" name="nickname" value="$!{careUser.nickname}"/></li>
                <li>
                <label>管理员账号：</label>
                <input class="text150" type="text" name="name" value="$!{careUser.name}" #if($careUser.id)readonly="readonly"#end/>                
                </li>
                 <li>
                <label>管理员密码：</label>
                <input class="text150" type="password" name="password" />                
                </li>
                <li class="w520"><label>简介：</label>
                <textarea cols="62" rows="8" name="descr">$!{careUser.descr}</textarea></li>
            </ul>
        </div>
        <p class="opt t_r">
			<button class="button_delete"  type="reset" type="button" onclick="javascript:history.back()" >取 消</button>
			<button class="button_gm" onClick="submit()" class="btn button_btn">#if($careUser.id)修改#else添 加#end</button>
        </p>
        </form>
        <div class="reg_area" style="width:960px">
        <div class="mask_contact pad10" style="width:960px;margin:0 auto;">
            <h4>街道信息</h4>
            <table class="table100 usertable cen">
                <col class="col1"/><col class="col2"/>
                <tr>
                    <th>街道名称</th>
                    <th>操作</th>
                </tr>
                #foreach ($country in $careUser.oCountry)
                <tr>
                    <td>${country.name}</td>
                    <td>
                    <a href="/care/user/removeCountry?id=${careUser.id}&countrys=#foreach($sub in $country.subOCountry)$sub.id,#end">取消绑定</a>
                    </td>
                </tr>
                #end
            </table>
          
        </div>
      <!--  <div class="table100 usertable cen">
			<iframe src="/care/user/street?uid=$!{careUser.id}"  width="100%"  frameborder="0"  ></iframe>
        </div>
      -->
      <form method="post" action="/care/user/searchStreet" class="fix_pop" style="width:980px">
      <input type="hidden" name="uid" value="$!{careUser.id}"/>
        <div  class="mask_contact pad10">
            <h4>绑定街道</h4>
            <div class="fix_car">
            		<select class='ocountry' id="province" next="city">
	                	<option value="0">=请选择=</option>
	                </select>
	                    <select class='ocountry' id="city" next="region">
	                    <option value="-1">=请选择=</option>
	                </select>
	                <select class='ocountry' id="region" next="street" name="countryId">
	                    <option value="-1">=请选择=</option>
	                </select>
	                     
	                     
               <button type="submit" class="button_gm">搜索</button>
            </div>
            <table class="table100 usertable cen">
                <col class="col1"/><col class="col2"/>
                
                <tr>
                    <th>街道名称</th>
                    <th>操作</th>
                </tr>
                  #foreach ($street in $country)
                <tr>
                    <td>${street.name}</td>
                    <td><a href="/care/user/addCountry?uid=$!{careUser.id}&countryId=#foreach($sub in $street.subOCountry)$sub.id,#end">绑定</a></td>
                </tr>
                #end 
            </table>
        </div>
        </from>
        </div>
  
    <div class="footer">
        
    </div>
</div>
<script >
 function submit(){
 document.getElementById('form').submit();
} 
</body>
</html>