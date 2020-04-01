<?php
//sessions 2018
//new view for login
	$this->load->view('header'); 
	$this->load->helper('url');
	$base = base_url() . index_page();
	$img_base = base_url()."assets/images/";
?>

   <h1><center>Registration page</h1>



<div id="register">
<?php echo validation_errors();

		echo form_open('Product/register');

		if(!empty($_GET['message']))
		{
		$message = $_GET['message'];
		echo $message;
		}

		echo "Enter First Name: ";
		echo form_input('contactFirstName');

		echo "<br><br>";

		echo "Enter Last Name: ";
		echo form_input('contactLastName');

		echo "<br><br>";

		echo "Enter Phone Number: ";
		echo form_input('phone');

		echo "<br><br>";

		echo "Enter Email: ";
		echo form_input('email');

		echo "<br><br>";

		echo "Enter Password: ";
		echo form_password('password');

		echo "<br><br>";

		echo "Enter Confirmation Password: ";
		echo form_password('confirm_password');

		echo "<br><br>";

		echo "Enter Company Name: ";
		echo form_input('companyName');

		echo "<br><br>";

		echo "Enter Address Line 1: ";
		echo form_input('addressLine1');

		echo "<br><br>";

		echo "Enter Address Line 2: ";
		echo form_input('addressLine2');

		echo "<br><br>";

		echo "Enter City: ";
		echo form_input('city');

		echo "<br><br>";

		echo "Enter Country: ";
		echo form_input('country');

		echo "<br><br>";

		echo "Enter Postal Code: ";
		echo form_input('postalCode');

		echo "<br><br>";

		echo form_submit("Register", "Register!");
	?>
	</div>
<?php
	$this->load->view('footer'); 
?>
