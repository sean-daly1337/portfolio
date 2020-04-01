<?php
defined('BASEPATH') OR exit('No direct script access allowed');
$this->load->view('header');
$this->load->helper('url');
$base = base_url() . index_page();
$img_base = base_url()."assets/images/products/";
?>
	<div class="list">
		<br><br>
		<h1 class="main"><center>Shopping Cart</h1>
		<br><br>

		<div class="row">
			<?php
			$total = 0;?>

			<div class="column" >
				<?php foreach($product_data as $row){?>
				<center><table>
						<tr>
							<td><?php echo anchor('Product/viewProduct/'.$row->produceCode, img(array('src'=>$img_base.'thumbs/'.$row->photo))); ?> </td>
						</tr>
						<tr>
							<td class="prod-desc"><?php echo $row->description;?></td>
						</tr>
						<tr>
							<td class="qtyLabel"><?php echo "Product Code: ". $row->produceCode;?></td>
						</tr>
						<tr>
							<td class="price"><?php echo "€". $row->bulkBuyPrice;?></td>
						</tr>
						<tr>
							<td><?php $quantity = $row->quantity;?>
								<form action="updateCartQty" method="post" >
									<?php echo '<input type="number" name="editQty" class="qty" value="'.$quantity.'" min="1" >' ?>
							</td>
						</tr>
						<tr>
							<td class="buy"><?php echo '<button id="submit" name="submitQty" class="edit" value="'.$row->produceCode.'">Update Qty</button>' ?></tr>
						</form>
						</tr>
						<tr>
							<td><button class="delete"><?php echo anchor('Product/removeProduct/'.$row->produceCode, 'Remove', 'onclick = "return checkRemove()"'); ?></button> </td>
						</tr>
					</table>
					<br><br>
					<?php
					$total = $total + $row->totalPrice; ?>
				<?php }?>
			</div>
			<div class="column1" >

				<center><table>
					<tr>
						<td><h1>Order Summary</h1></td>
					</tr>
					<tr>
						<td>Subtotal</td><td><?php echo  "€". $total?></td>
					</tr>
					<tr>
						<td>Shipping</td><td>€0.0</td>
					</tr>
					<tr>
						<td class="line"></td>
					</tr>
					<tr>
						<td>Subtotal</td><td><?php echo  "€". $total?></td>
					</tr>
				</table>
				</center>

			</div>
		</div>


		<br><br>
	</div>
<?php
$this->load->view('footer');
?>
