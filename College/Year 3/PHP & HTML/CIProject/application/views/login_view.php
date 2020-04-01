<?php
//sessions 2018
//new view for login
	$this->load->view('header'); 
	$this->load->helper('url');
	$base = base_url() . index_page();
	$img_base = base_url()."assets/images/";
?>
   <h1><center>Login Page</h1>
<br>
<container class = container;>
<form role ="form" method = "post" action="<?php echo site_url('Product/verify_login'); ?>">
	<div class="form-group row">
		<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
		<div class="col-sm-10">
			<input type="email" class="form-control" id="inputEmail3" name="email">
		</div>
	</div>
	<div class="form-group row">
		<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="inputPassword3" name="password">
		</div>
	</div>
	<fieldset class="form-group">

	</fieldset>
	<div class="form-group row">
		<div class="col-sm-2">Remember me</div>
		<div class="col-sm-10">
			<div class="form-check">
				<input class="form-check-input" type="checkbox" id="gridCheck1" name="remember">
				<label class="form-check-label" for="gridCheck1">
				</label>
			</div>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary">Login</button>
		</div>
	</div>
</form>
</container>

<?php //echo validation_errors();
//
//		echo form_open('Product/verify_login');
//
//		echo "Enter Username: ";
//		echo form_input('email');
//
//		echo "<br><br>";
//
//		echo "Enter Password: ";
//		echo form_password('password');
//
//		echo "<br><br>";
//
//		echo "Remember Me:  ";
//		echo form_checkbox('remember');
//
//		echo "<br><br>";
//
//		echo form_submit("Login", "Login!");
//	?>
<?php
	$this->load->view('footer'); 
?>
