<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
     <link rel="stylesheet" href="/assets/newCss/nullTbalecom.css" />
    <link rel="stylesheet" href="$request.contextPath/assets/css/shequyonghu.css"/>
    <script src="$request.contextPath/assets/js/jquery-1.8.0.min.js"></script>
     <script src="$request.contextPath/assets/js/jquery.jqprint-0.3.js"></script>
    
     <style>
    	.underline tr td{
    		border-bottom:1px solid #666;
    	}
    	.gds_css{margin-left:8% !important;font-size:20px !important;width:85%;font-family:楷体 !important;}
    </style>
</head>
<body>
<input type="hidden" id="number1" value="$number"/>
	<div id="myPrintArea" style="margin-left:8%; width:85%; font-size:20px;font-family:楷体;" >
		#set($template = "$str")
		$template
	</div>
	<div>
		<br/><br/><br/><br/><br/>
		<button style="position: relative;left: 47%" id="dayin">打印</button>
	</div>
	<script defer="defer" type="text/javascript">
		$(function(){
			var number=$('#number1').val();
			$('#number').html(number);
		});
	 	$(document).ready(function(){
    		$("#dayin").click(function(){
    			
   	 			$("#myPrintArea").jqprint(); 
				
    		});
		});
	</script>
</body>
</html>