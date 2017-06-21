 <!--
 
 <br>
 <br>
  
    #if($!{sessionUser.isSuper_()}==true)
	    #if($sessionUser.cateEnum.type==4)
	   	 <div class="sidebar fl">
		    <a href="/professional/feature?theme=1&classify=111&exhibition='three'" id="todaytask1" class="todaytask ">家庭情况</a>
		    <a href="/professional/feature?theme=2&classify=114&exhibition='lonely'" id="todaytask2">生活质量</a>
		    <a href="/professional/feature?theme=3&classify=112&exhibition='disable'">自理能力</a>
		</div>
	   	#end
   	#else
   	<ul class="nav1">
   		<li><a class="a_Special_4"  href="/professional/scaleScreen">结论筛查</a></li>
   </ul>
    #end
   -->
	 <br>
	 <br>
	   #if($!{sessionUser.isSuper_()}==true)
		    #if($sessionUser.cateEnum.type==4)
		   	 <div class="sidebar fl">
		    	<a href="/professional/site/sitemanage" id="todaytask1" class="todaytask ">站点评估</a>
		    	<a href="/permission/users" id="todaytask2">员工管理</a>
		    	<a href="/professional/material/select">物料管理</a>
			</div>
	    	#end
	    	#if($sessionUser.cateEnum.type==3)
   			<ul class="nav1">
	   			<li><a class="a_Special_4"  href="/professional/scaleScreen">结论筛查</a></li> <br><br>
   				<li><a class="a_Special_4"  href="/assess/lookOver">量表分析</a></li><br><br>
   				<li><a class="a_Special_4"  href="/gamet/assessgds/togame">游戏结论</a></li>
   			</ul>
	  		#end
	   #end