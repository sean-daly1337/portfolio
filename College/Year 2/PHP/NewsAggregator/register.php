<?php
include_once("controller/Controller.php");
$controller = new Controller();

if(isset($_POST['btnRegister'])){
	extract($_POST);
	$controller->register_user($first_name, $last_name,$emailadd,$gender, $city, $country, $password);

	print 'sadf';
} else {
	
	$controller->show_register();
}
?>