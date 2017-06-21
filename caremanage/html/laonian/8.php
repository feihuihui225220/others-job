<?php

header('Content-type: application/json');

$callback = $_GET ['callback'];
$value = $_GET['name'];


$json = '{"code":0,"message":"成功","data":[{"id":1,"time":"2014-10-17 09:18","name":"张三","tel":"13333333333","address":"北京","name2":"紧急联系人名字","tel2":"紧急联系电话","type":"警报类型1","service":"服务1","content":"警报内容1"}]}';



echo $callback . "(" . $json . ")";

?>