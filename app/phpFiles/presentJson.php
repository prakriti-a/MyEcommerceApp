<?php

// create connection
$connection = new mysqli("localhost", "root", "", "ecommerce");
// read data
$sqlCommand = $connection->prepare("select * from product_ecommerce where id=?");
$sqlCommand->bind_param("i", $_GET["id"]);
$sqlCommand->execute();

// present retrieved data as json
$result = $sqlCommand->get_result();
$rowOfData = $result->fetch_assoc();

echo json_encode($rowOfData);

// printing to browser
//echo $rowOfData["id"];
//echo $rowOfData["name"];
//echo $rowOfData["price"];

