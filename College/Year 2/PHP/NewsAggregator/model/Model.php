<?php
session_start();

class Model {
	public $conn;

        // Function used for connecting the database 
	public function __construct($host = 'localhost', $username = 'mydatabase_admin', $password = 'Office365', $dbname = 'mydatabase')
    {
        $this->host = $host;
        $this->username = $username;
        $this->password = $password;
        $this->dbname = $dbname;
        $this->conn = mysqli_connect($host, $username, $password, $dbname);
    }

    // Function used for checking whether the login details are correct or incorrect resulting in the user being told if there email or password is correct or incorrect
	public function getlogin()
	{
	// here is some hardcoded values for the database
		if(isset($_REQUEST['emailadd']) && isset($_REQUEST['password']))
		{
			$emailadd = $_REQUEST['emailadd'];
			$password = $_REQUEST['password'];
			$password = md5($password);
			$result = mysqli_query($this->conn, "SELECT * FROM wm_users WHERE emailadd = '$emailadd' and password = '$password' ");
			if(mysqli_num_rows($result)>0)
	        {
	          $row = mysqli_fetch_object($result);
	          $_SESSION['wm_userid'] = $row->userid;
	          $_SESSION['wm_type_of_user'] = $row->type_of_user;
	          return 'login';
	        }
	        else
	        {
	        	return 'invalid user';	
	        	$_SESSION['message'] = 'error';
	          	header('Location: index.php');
	          	exit;
	        }

			
		}
	}

        // Function used to recieve all current registered users and displays it inside of the database
	public function getAllUsers(){
		$result = mysqli_query($this->conn, "SELECT * FROM wm_users WHERE type_of_user != 'admin' ");
		$row = mysqli_fetch_all($result,MYSQLI_ASSOC);
		return $row;
	}

        
        // Function used to recieve all current categories on the webpage and displays it inside of the database
	public function getAllcategories(){
		$result = mysqli_query($this->conn, "SELECT * FROM wm_categories ");
		$row = mysqli_fetch_all($result,MYSQLI_ASSOC);
		return $row;
	}

        // 
	public function getFeedUrl ($cid) {
            
      $sql = " SELECT * FROM wm_categories WHERE id = '$cid' ";
     
      $result = mysqli_query($this->conn, $sql);
      $row = mysqli_fetch_object($result);
      return $row->feed;
	}

        
        // Function used to save the details of registered user and saves it inside of the database
	public function registerUser($first_name, $last_name,$emailadd,$gender, $city, $country, $password)
	{
		$password = md5($password);
        $sql = "INSERT INTO wm_users (first_name, last_name, emailadd, gender, city, country, password) VALUES ('$first_name', '$last_name','$emailadd','$gender', '$city', '$country', '$password') ";
        mysqli_query($this->conn, $sql);
        sleep(4);
        header('Location: index.php');
	}

}
?>