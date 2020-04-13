<?php
include_once("controller/Controller.php");
$controller = new Controller();
$controller->show_articles($_REQUEST['cid']);
?>