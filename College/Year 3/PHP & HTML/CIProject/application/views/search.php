<?php
defined('BASEPATH') OR exit('No direct script access allowed');
$this->load->view('header');
$this->load->helper('url');
$base = base_url() . index_page();
$img_base = base_url()."assets/images/products/";
?>

<div class="search-container">
	<form action="searchShopProduct" method="post">
		<input type="text" placeholder="Search.." name="search">
		<button type="submit">Search Product</button>
	</form>
</div>

<div class="list">
	<br><br>
	<h1 class="main">List of Products</h1>
	<br><br>
	<table>
		<tr>
			<th align="left" width="100">Product Code</th>
			<th align="left" width="100">Description</th>
			<th align="left" width="100">Product Line</th>
			<th align="left" width="100">Supplier</th>
			<th align="left" width="100">Quantity In Stock</th>
			<th align="left" width="100">Bulk Buy Price</th>
			<th align="left" width="100">Bulk Sale Price</th>
			<th align="left" width="100">Photo</th>
			<th align="left" width="100">Wish List</th>
			<th align="left" width="100">Cart</th>
		</tr>
		<?php foreach($search_data as $row){?>
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
