<?php
defined('BASEPATH') OR exit('No direct script access allowed');
$this->load->view('header');
$this->load->helper('url');
$base = base_url() . index_page();
$img_base = base_url()."assets/images/products/";
?>
<div class="list">
<br><br>
<center><h1 class="main">List of Products</h1>
<br><br>



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
<td><?php echo anchor('product/editProduct/'.$row->produceCode, 'Update'); ?> </td>	
<td><?php echo anchor('product/deleteProduct/'.$row->produceCode, 'Delete', 'onclick = "return checkDelete()"'); ?> </td>
</tr> 
<?php }?>
 </table>
 <br><br>
</div>
<?php
$this->load->view('footer');
?>
