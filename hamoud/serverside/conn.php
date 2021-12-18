<?php
// Create 4 variables to store these information
$server="localhost";
$username="id18141585_userhamoud";
$password="-SBK8ItC/Jg#Ey0w";
$database = "id18141585_bddhamoud";

// Create connection
$conn = new mysqli($server, $username, $password, $database);
// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}
?>
