<?php
// this sproject should be saved in xampp/htdocs to run on localhost

// create mysqli obj -> server/host address, username, password, db name
$connection = new mysqli("localhost", "root", "", "ecommerce");

// to call a methode use '->'
$sqlCommand = $connection->prepare("insert into product_ecommerce values (?, ?, ?)");
    // bind parameters with sql cmd
$sqlCommand->bind_param("isi",$_GET["id"],$_GET["name"],$_GET["price"]); // isi -> int string int: dt type of params
$sqlCommand->execute();





/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

