<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户首页-公用</title>
</head>
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
<body>
  <div class="personInfo clearfix">
    <div class="personInfo_left fl">
      <ul class="sidebar">
        <li>
          <a href="/director/user?userId=$dirUser.id">用户信息</a>
        </li>
        <li>
          <a href="/rounds/record/findAll?userId=$dirUser.id&esc=0">巡诊记录</a>
        </li>
        <li>
          <a href="/director/biochemistry?userId=$dirUser.id">生化指标</a>
        </li>
        <li>
          <a href="/director/service/list?userId=$dirUser.id">健康数据</a>
        </li>
        <li>
          <a href="/visit/planByUserId?userId=$dirUser.id" target="_self">巡诊计划</a>
        </li>
        <li>
          <a href="/consu/pageResult?userId=$dirUser.id" target="_self">会诊记录</a>
        </li>
        <li>
          <a href="/director/HTransfer?userId=$dirUser.id" target="_self">转诊记录</a>
        </li>
        <li>
          <a href="/director/htreatuser/page?userId=$dirUser.id" target="_self">治疗记录</a>
        </li>
      </ul>
    </div>
  </div>
</body>

</html>

 