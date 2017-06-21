#set($pix="&nbsp;共${page.getTotalCount()}条记录")
#set($curPage="第${page.getPageNo()}/${page.getTotalPages()}页")
#set($prePage="<a href='javascript:pageNavigator(${page.getPrePage()});' style='cursor:pointer'>上一页</a>&nbsp;")
#set($nextPage="<a href='javascript:pageNavigator("+${page.getNextPage()}+");' style='cursor:pointer'>下一页</a>&nbsp;")
#set($firstPage="<a href='javascript:pageNavigator(1);' style='cursor:pointer'>首页</a>&nbsp;")
#set($lastPage="<a href='javascript:pageNavigator("+${page.getTotalPages()}+");' style='cursor:pointer'>末页</a>")
#if(${page.getTotalCount()}>0)
<span class="pagespan">
${pix}
${curPage}
#if($page.getPageNo()!=1)$prePage#end
#if($page.getPageNo()!=$page.getTotalPages())$nextPage#end
#if($page.getPageNo()!=1)$firstPage#end 
#if($page.getPageNo()!=$page.getTotalPages())$lastPage#end
</span>
#end