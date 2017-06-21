<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8" />
<title>老年人前端_公告政策</title>
#parse("/common/top.tpl")
<link rel="stylesheet" href="$request.contextPath/assets/css/common.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css" />
<link rel="stylesheet" href="$request.contextPath/assets/css/yonghuguanli.css" />
<script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
</head>
<body>

<div class="wrapper">
  #parse("/common/head.tpl")
    <div class="body">
        <div class="useractbox bodyline pad10" >
            <ul class="clourstitle strong mgb10">
                <li index="1" class="rel on"><a href="policylist" target="_self">政策</a></li>
                <li index="2" class="rel"><a href="noticelist" target="_self">公告</a></li>
            </ul>
            <div class="actboxlist">
                <div class="actbox1" style="height:100%">
                    <div class="pj_result nonelinePJ" >
                    #if($policylist)
                      #foreach($p in $policylist.result)
						<div class="pj_result_list">
							<p class="pj_result_list_p1"><a href="policydetail?id=$!{p.id}" target="_self">$!{p.title}</a></p>
                            <span class="pj_result_list_span">$!date.format('yyyy-MM-dd',$!{p.createdAt})</span>
						</div>
					#end
                  #end
					</div>
                </div>
            </div>
        </div>
        
    </div>
    <div class="footer"></div>
</div>


</body>
</html>