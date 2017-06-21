<?php

header('Content-type: application/json');

$callback = $_GET ['callback'];
$value = $_GET['name'];


$json = '{"code":0,"message":"成功","data":[{"id":1,"name":"张三","tel":"13333333333","uid":"身份证号1","sex":"男","age":"66"},{"id":1,"name":"张三","tel":"13333333333","uid":"身份证号2","sex":"男","age":"66"},{"id":1,"name":"张三","tel":"13333333333","uid":"身份证号5","sex":"男","age":"66"},{"id":1,"name":"张三","tel":"13333333333","uid":"身份证号3","sex":"男","age":"66"},{"id":1,"name":"张三","tel":"13333333333","uid":"身份证号6","sex":"男","age":"66"},{"id":1,"name":"张三","tel":"13333333333","uid":"身份证号4","sex":"男","age":"66"},{"id":1,"name":"张三","tel":"13333333333","uid":"身份证号11","sex":"男","age":"66"},{"id":1,"name":"张三","tel":"13333333333","uid":"身份证号31","sex":"男","age":"66"},]}';



echo $callback . "(" . $json . ")";

?>