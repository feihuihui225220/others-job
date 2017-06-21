<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户首页-公用</title>
     <link rel="stylesheet" type="text/css" href="../../assets/director/style/common.css">
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/common1.css">
</head>
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
<body>
  <div class="personInfo clearfix" style="float: left;">
    <div class="personInfo_left fl">
      <ul class="sidebar">
        <li>
          <a href="">评估量表管理</a>
        </li>
        <li>
          <a href="">管家功能设置</a>
        </li>
        <li>
          <a href="/active/listAllActive">线下活动</a>
        </li>
         <li>
          <a href="">巡诊</a>
        </li>
        <li>
          <a href="/customer/list">客户管理</a>
        </li>
        <li>
          <a href="">财务管理</a>
        </li>
        <li>
          <a href="">权限管理</a>
        </li>
         <li>
          <a href="">操作日志</a>
        </li>       
        <li>
          <a href="/icare/managerInfo/getList">管家列表</a>
        </li>
        <li>
          <a href="/icare/banner/getList">banner列表</a>
        </li>
        <li>
          <a href="/icare/notice/getList">消息列表</a>
        </li>
        <li>
          <a href="/icare/feedback/getList">反馈列表</a>
        </li>
        <li>
          <a href="/icare/vip/getList">vip说明</a>
        </li>
      </ul>
    </div>
  </div>
</body>

</html>
 