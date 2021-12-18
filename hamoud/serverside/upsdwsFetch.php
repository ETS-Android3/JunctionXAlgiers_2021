<?php
define('HOST','localhost');
define('USER','id18141585_userhamoud');
define('PASS','-SBK8ItC/Jg#Ey0w');
define('DB','id18141585_bddhamoud');


$con = mysqli_connect(HOST,USER,PASS,DB);

$sql = "select * from products";

$res = mysqli_query($con,$sql);

$result = array();

while($row = mysqli_fetch_array($res)){
array_push($result,array('ups'=>$row[4],
'dws'=>$row[5],

));
}

echo json_encode(array("result"=>$result));

mysqli_close($con);

?>