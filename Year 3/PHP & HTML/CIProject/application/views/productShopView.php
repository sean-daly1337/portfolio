<?php
defined('BASEPATH') OR exit('No direct script access allowed');
$this->load->view('header');
$this->load->helper('url');
$base = base_url() . index_page();
$img_base = base_url()."assets/images/products/";
$img_cart = base_url()."assets/images/site/shopping-cart.jpg";
?>
<div class="list">
<br><br>
<h1 class="main"><center>List of Products</h1>
<br><br>


	<div class="search-container">
		<form action="searchProduct" method="post">
			<input type="text" placeholder="Search.." name="search">
			<button type="submit">Search Product</button>
		</form>
	</div>
<table>
<tr>
<th align="left">produceCode</th>
<th align="left">description</th>
<th align="left">productLine</th>
<th align="left">supplier</th>
<th align="left">quantityInStock</th>
<th align="left">bulkBuyPrice</th>
<th align="left">bulkSalePrice</th>
<th align="left" width="100">photo</th>
</tr>
<?php foreach($product_info as $row){?>
<tr>
<td><?php echo $row->produceCode;?></td>
<td><?php echo $row->description;?></td>
<td><?php echo $row->productLine;?></td>
<td><?php echo $row->supplier;?></td>
<td><?php echo $row->quantityInStock;?></td>
<td><?php echo $row->bulkBuyPrice;?></td>
<td><?php echo $row->bulkSalePrice;?></td>
	<td><?php echo anchor('product/viewProduct/'.$row->produceCode, img(array('src'=>$img_base.'thumbs/'.$row->photo))); ?> </td>
	<form name="ipladder" id="ipladder" method="post">
	</form>
	<form action="addToWishList" method="post" >
		<td class="qtyLabel">Quantity : <input type="number" class="qty" value="1" name="quantity" min="1" ></td>
		<td class="wish"><?php echo '<button id="submit" name="wish" class="wishbtn" value="'.$row->produceCode.'">Add to wishlist</button>' ?></td>
	</form>
	<form action="buyProduct" method="post" >
		<td class="qtyLabel">Quantity : <input type="number" class="qty" value="1" name="quantity" min="1" ></td>
		<td class="buy"><?php echo '<button id="submit" name="buy" class="buybtn" value="'.$row->produceCode.'" >Add to cart</button>' ?></tr>
	</form>
</tr> 
<?php }?>
 </table>
 <br><br>
</div>


<?php
$this->load->view('footer');
?>
