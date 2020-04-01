<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');
class Product extends CI_Controller {
public function __construct(){
parent::__construct();
$this->load->model('ProductModel');
$this->load->helper('form');
$this->load->helper('html');
$this->load->helper('url');
$this->load->library('form_validation');



		$this->load->library('session');
}
function index() {
		//This checks if the user is already logged into the application
		if($this->session->userdata('logged_in'))
			//If the user is logged in -> Display the index page with secret content
			redirect('Product/home');
		else
			if(isset($_COOKIE['email']) && isset($_COOKIE['password']))
			{
				if($this->ProductModel->login($_COOKIE['email'], $_COOKIE['password']))
				{
					$result = $this->ProductModel->login($_COOKIE['email'], $_COOKIE['password']);
					if($result) 
					{
						$sess_array = array();
						foreach($result as $row) 
						{
							$sess_array = array(
								'email' => $row->email,
								'type' => $row->type,
							);
							$this->session->set_userdata('logged_in', $sess_array);	
							redirect('Product/home');
						}
					}
				}	
			}
			//If the user isn't logged in -> display login form to them
			$this->load->view('index');
	}



		function home() {
		//if the user is logged in
		if($this->session->userdata('logged_in')) {
			//Retrieves the session data
			$session_data = $this->session->userdata('logged_in');
			//Get the username from the session and put it in $data
			$data['email'] = $session_data['email'];
			//load index/home view with the username included in $data
			$this->load->view('index', $data);
		}
		else {
			//if no session, redirect to login page
			$this->load->view('login_view');
		}
	}



	public function checkUser()
	{
		if(!$this->session->userdata('logged_in'))
		{	
			header("Location: index");
		}
		else
		{
			$session_data = $this->session->userdata('logged_in');
			if($session_data['type']=='1')
			{
				header("Location: index");
			} 
		}
	}
	
	function verify_login() {
		//set the validation rules for the login form
		//This code ensures that both the username and password
		//Are trimmed of extra spaces at the beginning and end and	are required fields
		//The check_database function is also called
		//callback_ allows you to write your own form validation code
		$this->form_validation->set_rules('email', 'Email', 'trim|required');
		$this->form_validation->set_rules('password', 'Password', 'trim|required|callback_check_database');

		if($this->form_validation->run() == false) {
			//validation failed -> display login form
			$this->load->view('login_view');
		} else { 
			//validation passed (inc a call to check_database() via a callback) -> display secret content
			redirect('Product/home');
		}
	}

		// Check database for login details function
		function check_database($password) {
		//You will only get here if the form validation succeeded. Now it will validate the users details on the DB
		$email = $this->input->post('email');
		$password = $this->input->post('password');
		$remember = $this->input->post('remember');
	   //Query the DB
	   $result = $this->ProductModel->login($email, $password);
	   //if a valid user write their id & name to session data

		if($result) {
			$sess_array = array();
			foreach($result as $row) {
				$sess_array = array(
					'email' => $row->email,
					'type' => $row->type,
				);
				$this->session->set_userdata('logged_in', $sess_array);				
			}
			if(isset($_POST['remember']))
			{
				setrawcookie('email', $email, time() + (86400 * 30)); // 86400 = 1 day
				setrawcookie('password', $password, time() + (86400 * 30)); // 86400 = 1 day
			}
			
			//return true -> we have a valid user
			return true;
		}
		else {
			//return false ->we have an invalid user
			$this->form_validation->set_message('check_database', 'Invalid username or password');
			return false;
		}
	}

		// Logout user function
		function logout() {
		//unset the session data
		$this->session->unset_userdata('logged_in');
		//destroy the session
		$this->session->sess_destroy();
		//load the login page
		setrawcookie('email','', 1);
		setrawcookie('password','', 1);
		$this->load->view('index');
	}

	//Register user function
	function register()
    {
        $this->form_validation->set_rules('contactFirstName', 'First Name', 'required');
        $this->form_validation->set_rules('contactLastName', 'Last Name', 'required');
        $this->form_validation->set_rules('phone', 'Contact No', 'required');
        $this->form_validation->set_rules('email', 'Email', 'required');
        $this->form_validation->set_rules('password', 'Password', 'required');
		$this->form_validation->set_rules('confirm_password', 'Confirm Password', 'required');
		$this->form_validation->set_rules('addressLine1', 'Address Line 1', 'required');
		$this->form_validation->set_rules('addressLine2', 'Address Line 2', 'required');
		$this->form_validation->set_rules('city', 'City', 'required');
		$this->form_validation->set_rules('country', 'Country', 'required');
		$this->form_validation->set_rules('postalCode', 'Postal Code', 'required');
 
        if ($this->form_validation->run() == FALSE)
        {  
            $this->load->view('register');
        }
        else
        {
			$email = $this->input->post('email');
			$check = $this->ProductModel->auth_check($email);
	 
			if($check == true)
			{
				header("Location: $register?message=success");
			}
			else
			{
				$data = array(
               'contactFirstName' => $this->input->post('contactFirstName'),
               'contactLastName' => $this->input->post('contactLastName'),
               'phone' => $this->input->post('phone'),
               'email' => $this->input->post('email'),
               'password' => md5($this->input->post('password')),
			   'addressLine1' => $this->input->post('addressLine1'),
			   'addressLine2' => $this->input->post('addressLine2'),
			   'city' => $this->input->post('city'),
			   'country' => $this->input->post('country'),
			   'postalCode' => $this->input->post('postalCode'),
			   'type' => '1',
             );
   
            $check = $this->ProductModel->insert_user($data);
 
            if($check != false)
            {
				$sess_array = array();
				$sess_array = array(
					'email' => $this->input->post('email'),
					'type' => '1',
				);
				$this->session->set_userdata('logged_in', $sess_array);			
             }
			}
             $this->session->set_userdata($user);
 
             redirect('Product/index');
			
	
        }    
    }

	public function handleInsert(){
		if ($this->input->post('submitInsert')){
			$pathToFile = $this->uploadAndResizeFile();
			$this->createThumbnail($pathToFile);
				//set validation rules
				$this->form_validation->set_rules('produceCode', 'Produce Code', 'required');
				$this->form_validation->set_rules('description', 'Description', 'required');
				$this->form_validation->set_rules('productLine', 'Product Line', 'required');
				$this->form_validation->set_rules('supplier', 'Supplier', 'required');
				$this->form_validation->set_rules('quantityInStock', 'Quantity In Stock', 'required');
				$this->form_validation->set_rules('bulkBuyPrice', 'Bulk Buy Price', 'required');
				$this->form_validation->set_rules('bulkSalePrice', 'Bulk Sale Price', 'required');
				//get values from post
				$aProduct['produceCode'] = $this->input->post('produceCode');
				$aProduct['description'] = $this->input->post('description');
				$aProduct['productLine'] = $this->input->post('productLine');
				$aProduct['supplier'] = $this->input->post('supplier');
				$aProduct['quantityInStock'] = $this->input->post('quantityInStock');
				$aProduct['bulkBuyPrice'] = $this->input->post('bulkBuyPrice');
				$aProduct['bulkSalePrice'] = $this->input->post('bulkSalePrice');
				$aProduct['photo'] = $_FILES['userfile']['name'];
				//check if the form has passed validation
			if (!$this->form_validation->run()){
			//validation has failed, load the form again
			$this->load->view('insertProductView', $aProduct);
			return;
			}
			//check if insert is successful
			if ($this->ProductModel->insertProductModel($aProduct)) {
			$data['message']="The insert has been successful";
			}
			else {
			$data['message']="Uh oh ... problem on insert";
			}
			//load the view to display the message
			$this->load->view('displayMessageView', $data);
			return;
			}
				//produceCode,description,productLine,supplier,quantityInStock,bulkBuyPrice,bulkSalePrice,photo
				$aProduct['produceCode'] = "";
				$aProduct['description'] = "";
				$aProduct['productLine'] = "";
				$aProduct['supplier'] = "";
				$aProduct['quantityInStock'] = "";
				$aProduct['bulkBuyPrice'] = "";
				$aProduct['bulkSalePrice'] = "";
				//load the form
				$this->load->view('insertProductView', $aProduct);
				}

	public function listProducts()
	{
		$data['product_info']=$this->ProductModel->get_all_products();
		$this->load->view('productListView',$data);
	}


	public function searchProduct()
	{
		$search = $this->input->post('search');
		$data['product_info']= $this->ProductModel->get_search_products($search);
		$this->load->view('productShopView', $data);
	}

	public function cartView()
	{
		$session_data = $this->session->userdata('logged_in');
		$email = $session_data['email'];
		$data['product_data']= $this->ProductModel->get_cart_products($email);
		$this->load->view('cart_view', $data);
	}

	public function buyProduct()
	{
		$quantity = $this->input->post('quantity');
		$session_data = $this->session->userdata('logged_in');
		$email = $session_data['email'];
		$boughtProduct = $_POST['buy'];
		$quantityCheck = $this->ProductModel->check_quantity($boughtProduct,$quantity);
		if ($quantityCheck)
		{
			$data['product_data']= $this->ProductModel->buy_products($boughtProduct,$quantity,$email);
			$data['product_info']=$this->ProductModel->get_all_products();
			$this->load->view('productShopView',$data);
		}
		else
		{
			$data['message'] = "The quantity you are looking for is more then we currently have in stock!";
			$this->load->view('displayMessageView',$data);
		}
	}

	public function addToWishList()
	{
		$quantity = $this->input->post('quantity');
		$session_data = $this->session->userdata('logged_in');
		$email = $session_data['email'];
		$wishedProduct = $_POST['wish'];
		$quantityCheck = $this->ProductModel->check_quantity($wishedProduct,$quantity);
		if ($quantityCheck)
		{
			$data['product_data']= $this->ProductModel->wish_products($wishedProduct,$quantity,$email);
			$data['search_data']=$this->ProductModel->get_all_products();
			$this->load->view('search',$data);
		}
		else
		{
			$data['message'] = "The quantity you are looking for is more then we currently have in stock!";
			$this->load->view('displayMessageView',$data);
		}

	}

	public function updateCartQty()
	{
		$session_data = $this->session->userdata('logged_in');
		$email = $session_data['email'];
		$quantity = $this->input->post('editQty');
		$produceCode = $this->input->post('submitQty');
		$quantityCheck = $this->ProductModel->check_quantity($produceCode,$quantity);
		if ($quantityCheck)
		{
			$this->ProductModel->update_cart_products($produceCode,$quantity,$email);
			$this->cartView();
		}
		else
		{
			$data['message'] = "The quantity you are looking for is more then we currently have in stock!";
			$this->load->view('displayMessageView',$data);
		}

	}

	public function updateWishListQty()
	{
		$session_data = $this->session->userdata('logged_in');
		$email = $session_data['email'];
		$quantity = $this->input->post('editQty');
		$produceCode = $this->input->post('submitQty');
		$quantityCheck = $this->ProductModel->check_quantity($produceCode,$quantity);
		if ($quantityCheck)
		{
			$this->ProductModel->update_wishList_products($produceCode,$quantity,$email);
			$this->wishListView();
		}
		else
		{
			$data['message'] = "The quantity you are looking for is more then we currently have in stock!";
			$this->load->view('displayMessageView',$data);
		}

	}

	public function listShopProducts()
	{
		$data['product_info']=$this->ProductModel->get_all_products();
		$this->load->view('productShopView',$data);
	}

	function uploadAndResizeFile()
	{ //set config options for thumbnail creation
		$config['upload_path']='./assets/images/products/full/';
		$config['allowed_types']='gif|jpg|png';
		$config['max_size']='100';
		$config['max_width']='1024';
		$config['max_height']='768';
		$this->load->library('upload',$config);
	if (!$this->upload->do_upload())
		echo $this->upload->display_errors();
	else
		echo 'upload done<br>';
		$upload_data = $this->upload->data();
		$path = $upload_data['full_path'];
		$config['source_image']=$path;
		$config['maintain_ratio']='FALSE';
		$config['width']='180';
		$config['height']='200';
		$this->load->library('image_lib',$config);
	if (!$this->image_lib->resize())
		echo $this->image_lib->display_errors();
	else
		echo 'image resized<br>';
		$this->image_lib->clear();
		return $path;
	}

	function createThumbnail($path)
	{ //set config options for thumbnail creation
		$config['source_image']=$path;
		$config['new_image']='./assets/images/products/thumbs/';
		$config['maintain_ratio']='FALSE';
		$config['width']='42';
		$config['height']='42';
		//load library to do the resizing and thumbnail creation
		$this->image_lib->initialize($config);
		//call function resize in the image library to physiclly create the thumbnail
	if (!$this->image_lib->resize())
		echo $this->image_lib->display_errors();
	else
		echo 'thumbnail created<br>';
	}


	public function deleteProduct($produceCode)
    {	$deletedRows = $this->ProductModel->deleteProductModel($produceCode);
		if ($deletedRows > 0)
			$data['message'] = "$deletedRows product has been deleted";
		else
			$data['message'] = "There was an error deleting the author with an ID of $produceCode";
		$this->load->view('displayMessageView',$data);
    }
	public function viewProduct($produceCode)
    {	$data['view_data']= $this->ProductModel->drilldown($produceCode);
		$this->load->view('ProductView', $data);
    }
	public function editProduct($produceCode)
    {	$data['edit_data']= $this->ProductModel->drilldown($produceCode);
		$this->load->view('updateProductView', $data);
    }

	public function removeProduct($produceCode)
	{
		$deletedRows = $this->ProductModel->removeProductModel($produceCode);
		if ($deletedRows > 0)
			$data['message'] = "Your item has been removed";
		else
			$data['message'] = "There was an error removing the product with an ID of $produceCode";

		$this->load->view('displayMessageView',$data);


	}

	public function removeWishedProduct($produceCode)
	{
		$deletedRows = $this->ProductModel->removeWishedProductModel($produceCode);
		if ($deletedRows > 0)
			$data['message'] = "Your item has been removed";
		else
			$data['message'] = "There was an error removing the product with an ID of $produceCode";

		$this->load->view('displayMessageView',$data);

	}

	public function wishListView()
	{
		$session_data = $this->session->userdata('logged_in');
		$email = $session_data['email'];
		$data['product_data']= $this->ProductModel->get_wishList_products($email);
		$this->load->view('wishList_view', $data);
	}

	public function updateProduct($produceCode)
    {	$pathToFile = $this->uploadAndResizeFile();
		$this->createThumbnail($pathToFile);

		//set validation rules
		$this->form_validation->set_rules('produceCode', 'Produce Code', 'required');
		$this->form_validation->set_rules('description', 'Description', 'required');
		$this->form_validation->set_rules('productLine', 'Product Line', 'required');	
		$this->form_validation->set_rules('supplier', 'Supplier', 'required');
		$this->form_validation->set_rules('quantityInStock', 'Quantity In Stock', 'required');
		$this->form_validation->set_rules('bulkBuyPrice', 'Bulk Buy Price', 'required');	
		$this->form_validation->set_rules('bulkSalePrice', 'Bulk Sale Price', 'required');
	
		//get values from post
		$produceCode = $this->input->post('produceCode');
		$aProduct['description'] = $this->input->post('description');
		$aProduct['productLine'] = $this->input->post('productLine');
		$aProduct['supplier'] = $this->input->post('supplier');
		$aProduct['quantityInStock'] = $this->input->post('quantityInStock');
		$aProduct['bulkBuyPrice'] = $this->input->post('bulkBuyPrice');
		$aProduct['bulkSalePrice'] = $this->input->post('bulkSalePrice');
		$aProduct['photo'] = $_FILES['userfile']['name'];

		//check if the form has passed validation
		if (!$this->form_validation->run()){
			//validation has failed, load the form again
			$this->load->view('updateProductView', $aProduct);
			return;
		}
		//check if update is successful
		if ($this->ProductModel->updateProductModel($aProduct, $produceCode)) {
			redirect('product/listProducts');
		}
		else {
			$data['message']="Uh oh ... problem on update";
		}
    }
}
?>
