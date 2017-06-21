<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户首页-公用</title>
     <link rel="stylesheet" type="text/css" href="../../assets/director/style/common.css">
    <link rel="stylesheet" type="text/css" href="../../assets/director/style/common1.css">
</head>
#set ($sessionUser=$!{session.getAttribute("sessionUser")})
#set($ICUser=$!{session.getAttribute("ICUser")})
<body>
  <div class="personInfo clearfix">
    <div class="personInfo_left fl">
      <ul class="sidebar">
        <li>
          <a href="/ICareCourse/zCourse/list?userId=$!ICUser.id">个人课程定制</a>
        </li>
        <li>
          <a href="/active/CMUserPhotoList?rId=$!ICUser.id">个人线下活动照片</a>
        </li>
        <li>
          <a href="/userPhoto/list?rId=$!ICUser.id">个人上传照片记录</a>
        </li>
       
      </ul>
    </div>
  </div>
</body>

</html>
 