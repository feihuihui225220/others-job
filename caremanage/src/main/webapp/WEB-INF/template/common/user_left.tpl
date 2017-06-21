#set ($dirUser=$!{session.getAttribute("dirUser")})
<div class="side_nav fl">
 <ul>
   #if($sessionUser.super_)
  <li><a href="/director/user?userId=$dirUser.id"  target="_self">用户信息</a></li>
  <li><a href="/rounds/record/findAll">巡诊记录</a></li>
  <li><a href="/director/biochemistry?userId=$dirUser.id">生化指标</a></li>
  <li><a href="/director/health?userId=$dirUser.id">健康数据</a></li>
  <li><a href="/visit/planByUserId?userId=$dirUser.id" target="_self">巡诊计划</a></li>
   <li><a href="#" target="_self">会诊记录</a></li>
  <li><a href="#" target="_self">转诊记录</a></li>
  <li><a href="#" target="_self">治疗记录</a></li>
  #else
  <li><a href="#">用户信息</a></li>
  <li><a href="rounds/record/findAll">巡访记录</a></li>
  <li><a href="#">健康评估</a></li>
  <li><a href="#">用药指导</a></li>
  <li><a href="/director/biochemistry?userId=$dirUser.id">生化指标</a></li>
  <li><a href="/director/health?userId=$dirUser.id">健康数据</a></li>
  <li><a href="/visit/planByUserId?userId=$dirUser.id" target="_self">巡诊计划</a></li>
  <li><a href="#" target="_self">电话巡诊</a></li>
 </ul>
  #end
 </ul>
 </div>