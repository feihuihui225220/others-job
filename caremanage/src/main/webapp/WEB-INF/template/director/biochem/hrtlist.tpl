<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>生化指标</title>
    <link rel="stylesheet" type="text/css" href="/assets/director/style/xunzhenrecord.css">
	<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="/assets/js/pageNavigator.js"></script>
	<style type="text/css">
		.personInfo_right{width: 100% !important; margin: 0px !important;}
		.main1{ margin: 0 !important;}
	</style>
</head>

<body>

#parse("/common/dtop.tpl")
<div class="main1">
<input type="hidden" class="userId" value="$dirUser.id">
  <div>
    <div class="personInfo_right fl" style="float: left;">
	      <div><a href="/director/biochemistry?userId=$dirUser.id"  class="btnBg">返回</a></div>
	  <table width="100%" border="0" cellspacing="0" cellpadding="7" class="commonTable" id="dayin">
	    <tr>
	    <th>日期</th>
		<th>白细胞</th>
		<th>中性粒细胞</th>
		<th>嗜酸性粒细胞 </th>
		<th>嗜碱性粒细胞</th>
		<th>单核细胞</th>
		<th>淋巴细胞 </th>
		<th>红细胞 </th>
		<th>血红蛋白</th>
		<th>血小板</th>
		<th>红细胞沉降率</th>
	 </tr>
	 #foreach($li in $list)
		<tr class="userid_2020">
		<input type="hidden" class="id" value="$li.id">
		<td > $li.changeTime</td>
		<td name="whiteBloodCell"> $li.whiteBloodCell</td>
		<td name="neutrophilicGranulocyte"> $li.neutrophilicGranulocyte</td>
		<td name="eosinophileGranulocyte"> $li.eosinophileGranulocyte  </td>
		<td name="basophileGranulocyte"> $li.basophileGranulocyte</td>
		<td name="monocyte">$li.monocyte</td>
		<td name="lymphocyte">$li.lymphocyte</td>
		<td name="redBloodCell">$li.redBloodCell</td>
		<td name="hemoglobin">$li.hemoglobin</td>
		<td name="platelet">$li.platelet</td>
		<td name="esr">$li.esr</td>
		</tr>
		#end
	 </table>
	      
		      <div class="page fr">
		       	#parse("/common/page.tpl")
		      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="/assets/js/jquery-2.1.4.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/bio-edit.js"></script>
</html>
