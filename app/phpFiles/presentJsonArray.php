<?php

// create connection
$connection = new mysqli("localhost", "root", "", "ecommerce");
// read data
$sqlCommand = $connection->prepare("select * from product_ecommerce"); 
// get all objects, so no need to bind parameters

$sqlCommand->execute();

// present retrieved data as json array
$result = $sqlCommand->get_result();
$products = array();

while ($row = $result->fetch_assoc()) {
    // add products to array one by one
    array_push($products, $row); // pushes row to products
}

echo json_encode($products);