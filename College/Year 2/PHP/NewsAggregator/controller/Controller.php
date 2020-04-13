<?php
include_once("model/Model.php");
class Controller {
	public $model;
	public function __construct()
    {
        $this->model = new Model();
    }
	
	public function invoke()
	{
		$reslt = $this->model->getlogin();     // this calls the getlogin() function of model class and stores the return value of this function into the result variable.
		if($reslt == 'login') {
			$users = $this->model->getAllUsers();
			if($_SESSION['wm_type_of_user'] == 'admin' )
				$this->show_users();
			else
				$this->show_categories();

		} else {
			include 'view/login.php';
		}
	}

	public function show_users(){
		$users = $this->model->getAllUsers();
		include 'view/users.php';
	}

	public function show_categories(){
		$categories = $this->model->getAllcategories();
		include 'view/categories.php';
	}

	public function show_articles($cid){
		$feed = $this->model->getFeedUrl($cid);
		include 'view/articles.php';
	}

	public function show_register()
	{
		include 'view/register.php';
	}

	public function register_user($first_name, $last_name,$emailadd,$gender, $city, $country, $password)
	{
		$this->model->registerUser($first_name, $last_name,$emailadd,$gender, $city, $country, $password);
	}	
}
?>