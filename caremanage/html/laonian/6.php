<?php

header('Content-type: application/json');

$callback = $_GET ['callback'];
$value = $_GET['name'];


$json = '{"code":0,"message":"成功","data":[{"id":1,"time":"2014-10-17 09:18","name":"张三","tel":"13333333333","address":"北京","status":"已完成","price":"111","stime":"2014-10-17 10:21","order":[{"name":"蔡明1","num":"1"},{"name":"蔡明2","num":"11"}],"server":"李四"}]}';



echo $callback . "(" . $json . ")";

?>