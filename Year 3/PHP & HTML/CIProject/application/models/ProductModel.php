<?php
defined('BASEPATH') OR exit('No direct script access allowed');
class ProductModel extends CI_Model {
 function __construct() {
 parent::__construct();
$this->load->database();
 }
 
	function get_all_products()
	{
		$this->db->select("produceCode,description,productLine,supplier,quantityInStock,bulkBuyPrice,bulkSalePrice,photo");
		$this->db->from('products');
		$query = $this->db->get();
		return $query->result();
	}

	function get_search_products($search) {
		$this->db->select("produceCode,description,productLine,supplier,quantityInStock,bulkBuyPrice,bulkSalePrice,photo");
		$this->db->from('products');
		$this->db->where("produceCode LIKE '%$search%' OR description LIKE '%$search%'");
		$query = $this->db->get();
		return $query->result();
 	}

	function get_cart_products($email)
	{
		$this->db->select("*");
		$this->db->from('shoppingcart');
		$this->db->join('products', 'shoppingcart.produceCode = products.produceCode');
		$this->db->where("email LIKE '$email'");
		$query = $this->db->get();
		return $query->result();
	}

	function update_cart_products($produceCode,$quantity,$email) {
		$query = $this->db->query("SELECT * FROM shoppingcart WHERE produceCode='$produceCode' AND email='$email'");
		if($query->num_rows() == 1)
		{
			$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$produceCode'");
			$row = $query->row();
			$totalPrice = $quantity * $row->bulkBuyPrice;

			$dataAdd = array(
				'produceCode' => $produceCode,
				'email' => $email,
				'quantity' => $quantity,
				'totalPrice' => $totalPrice
			);
			$this->db->where("produceCode LIKE '$produceCode' AND email LIKE '$email'");
			$this->db->update('shoppingcart',$dataAdd);

		}
		else
		{
			$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$produceCode'");
			$row = $query->row();
			$totalPrice = $quantity * $row->bulkBuyPrice;

			$dataAdd = array(
				'produceCode' => $boughtProduct,
				'email' => $email,
				'quantity' => $quantity,
				'totalPrice' => $totalPrice
			);
			$this->db->insert('shoppingcart',$dataAdd);
		}
		return $query->result();
	}

	function wish_products($wishedProduct,$quantity,$email)
	{
	$query = $this->db->query("SELECT * FROM wishlist WHERE produceCode='$wishedProduct' AND email='$email'");
	if ($query->num_rows() == 1) {
		$row = $query->row();
		$quantityDB = $row->quantity;
		$quantityDB = $quantityDB + $quantity;
		$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$wishedProduct'");
		$row = $query->row();
		$totalPrice = $quantityDB * $row->bulkBuyPrice;

		$dataAdd = array(
			'produceCode' => $wishedProduct,
			'email' => $email,
			'quantity' => $quantityDB,
			'totalPrice' => $totalPrice
		);
		$this->db->where("produceCode LIKE '$wishedProduct' AND email LIKE '$email'");
		$this->db->update('wishlist', $dataAdd);

	}
	else
	{
		$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$wishedProduct'");
		$row = $query->row();
		$totalPrice = $quantity * $row->bulkBuyPrice;

		$dataAdd = array(
			'produceCode' => $wishedProduct,
			'email' => $email,
			'quantity' => $quantity,
			'totalPrice' => $totalPrice,
		);
		$this->db->insert('wishlist', $dataAdd);
	}
}
	function update_wishList_products($produceCode, $quantity, $email)
	{
		$query = $this->db->query("SELECT * FROM wishlist WHERE produceCode='$produceCode' AND email='$email'");
		if ($query->num_rows() == 1) {
			$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$produceCode'");
			$row = $query->row();
			$totalPrice = $quantity * $row->bulkBuyPrice;

			$dataAdd = array(
				'produceCode' => $produceCode,
				'email' => $email,
				'quantity' => $quantity,
				'totalPrice' => $totalPrice
			);
			$this->db->where("produceCode LIKE '$produceCode' AND email LIKE '$email'");
			$this->db->update('wishlist', $dataAdd);

		} else {
			$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$produceCode'");
			$row = $query->row();
			$totalPrice = $quantity * $row->bulkBuyPrice;

			$dataAdd = array(
				'produceCode' => $boughtProduct,
				'email' => $email,
				'quantity' => $quantity,
				'totalPrice' => $totalPrice
			);
			$this->db->insert('wishlist', $dataAdd);
		}

		return $query->result();
	}


	function get_wishList_products($email)
	{
		$this->db->select("*");
		$this->db->from('wishlist');
		$this->db->join('products', 'wishlist.produceCode = products.produceCode');
		$this->db->where("email LIKE '$email'");
		$query = $this->db->get();
		return $query->result();
	}


	function buy_products($boughtProduct, $quantity, $email)
	{
		$query = $this->db->query("SELECT * FROM shoppingcart WHERE produceCode='$boughtProduct' AND email='$email'");
		if ($query->num_rows() == 1) {
			$row = $query->row();
			$quantityDB = $row->quantity;
			$quantityDB = $quantityDB + $quantity;
			$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$boughtProduct'");
			$row = $query->row();
			$totalPrice = $quantityDB * $row->bulkBuyPrice;

			$dataAdd = array(
				'produceCode' => $boughtProduct,
				'email' => $email,
				'quantity' => $quantityDB,
				'totalPrice' => $totalPrice
			);
			$this->db->where("produceCode LIKE '$boughtProduct' AND email LIKE '$email'");
			$this->db->update('shoppingcart', $dataAdd);

		}
		else
		{
			$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$boughtProduct'");
			$row = $query->row();
			$totalPrice = $quantity * $row->bulkBuyPrice;

			$dataAdd = array(
				'produceCode' => $boughtProduct,
				'email' => $email,
				'quantity' => $quantity,
				'totalPrice' => $totalPrice,
			);
			$this->db->insert('shoppingcart', $dataAdd);
		}

		return $query->result();
	}


	public function deleteProductModel($produceCode)
	{
		$this->db->where('produceCode', $produceCode);
		return $this->db->delete('products');
	}


	public function removeProductModel($produceCode)
	{
		$this->db->where('produceCode', $produceCode);
		return $this->db->delete('shoppingcart');
	}

	public function removeWishedProductModel($produceCode)
	{
		$this->db->where('produceCode', $produceCode);
		return $this->db->delete('wishlist');
	}

	function insertProductModel($product)
	{
		$this->db->insert('products', $product);
		if ($this->db->affected_rows() == 1) {
			return true;
		} else {
			return false;
		}
	}

	function updateProductModel($product, $produceCode)
	{
		$this->db->where('produceCode', $produceCode);
		return $this->db->update('products', $product);
	}


	public function drilldown($product)
	{
		$this->db->select("produceCode,description,productLine,supplier,quantityInStock,bulkBuyPrice,bulkSalePrice,photo");
		$this->db->from('products');
		$this->db->where('produceCode', $product);
		$query = $this->db->get();
		return $query->result();
	}

	public function auth_check($email)
	{
		$this->db->select('email');
		$this->db->from('customers');
		$this->db->where('email', $email);
		$this->db->limit(1);
		$query = $this->db->get();


		if ($query->num_rows() == 1)
			return true;
		else
			return false;
	}

	//Login function for selecting info from database
	function login($email, $password)
	{
		$this->db->select('customerNumber, email, password, type');
		$this->db->from('customers');
		$this->db->where('email', $email);
		$this->db->where('password', ($password));
		$this->db->limit(1);
		$query = $this->db->get();
		if ($query->num_rows() == 1)
			return $query->result();
		else
			return false;
	}

	public function insert_user($data)
	{
		var_dump($this->db->insert('customers', $data));
		exit();
		$insert = $this->db->insert('customers', $data);
		if ($this->db->affected_rows() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public function check_quantity($boughtProduct, $quantity)
	{
		$query = $this->db->query("SELECT * FROM products WHERE produceCode = '$boughtProduct' AND quantityInStock >= '$quantity'");
		if ($query->num_rows() == 1) {
			return true;
		} else {
			return false;
		}

	}

}
?>
