<?php
$this->load->helper('url'); 
$cssbase = base_url()."assets/css/";
$jsbase = base_url()."assets/javascript/";
$img_base = base_url()."assets/images/";
$base = base_url() . index_page();
?>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Moylish Market</title>
<link href="<?php echo $cssbase . "style.css"?>" rel="stylesheet" type="text/css" media="all" />
<script src="<?php echo $jsbase."common.js"?>"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<header>

<center><img class="center-image" src="<?php echo $img_base . "site/logo.jpg" ?>" width="400" height="200" />
<div class="myDiv">


	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">Moylish Market</a>
			</div>
			<ul class="nav navbar-nav">
				<?php $session_data = $this->session->userdata('logged_in'); ?>
				<?php if($session_data['type']=='1'): ?>
					<li class="">
					</li>
					<li><a href="<?php echo site_url('Product/index') ?>">Home</a></li>
					<li><a href="<?php echo site_url('Product/listShopProducts') ?>">List</a></li>
					<li><a href="<?php echo site_url('Product/cartView') ?>">Shopping Cart</a></li>
					<li><a href="<?php echo site_url('Product/wishListView') ?>">Wish List</a></li>
					<li><a href="<?php echo site_url('Product/logout') ?>">Logout</a></li>

				<?php elseif($session_data['type']=='2'): ?>
					<li><a href="<?php echo site_url('Product/index') ?>">Home</a></li>
					<li><a href="<?php echo site_url('Product/listProducts') ?>">List</a></li>

					<li><a href="<?php echo site_url('Product/handleInsert') ?>">Insert</a></li>
					<li><a href="<?php echo site_url('Product/logout') ?>">Logout</a></li>

				<?php else: ?>
					<li><a href="<?php echo site_url('Product/index') ?>">Home</a></li>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="<?php echo site_url('Product/listShopProducts') ?>">List</a></li>
						<li><a href="<?php echo site_url('Product/verify_login') ?>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						<li><a href="<?php echo site_url('Product/register') ?>"><span class="glyphicon glyphicon-user"></span> Register</a></li>
					</ul>
				<?php endif ?>

			</ul>
		</div>
	</nav>

<nav>
<ul>
<?php

?>
 </ul>
</nav>
</div>


</header>
