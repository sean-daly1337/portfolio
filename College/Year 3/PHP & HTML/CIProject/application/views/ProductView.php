<?php
	$this->load->view('header'); 
	$this->load->helper('url');
	$base = base_url() . index_page();
	$img_base = base_url()."assets/images/products/";
?>

<?php
foreach ($view_data as $row) {
	echo form_open();
	echo '</br></br>';

	echo 'Produce Code :';
	echo form_input('produceCode', $row->produceCode, 'readonly');

	echo '</br></br>Description :';
	echo form_input('description', $row->description, 'readonly');

	echo '</br></br>Product Line :';
	echo form_input('productLine', $row->productLine, 'readonly');

	echo '</br></br>Supplier :';
	echo form_input('supplier', $row->supplier, 'readonly');

	echo '</br></br>Quantity In Stock :';
	echo form_input('quantityInStock', $row->quantityInStock, 'readonly');

	echo '</br></br>Bulk Buy Price :';
	echo form_input('bulkBuyPrice', $row->bulkBuyPrice, 'readonly');

	echo '</br></br>Bulk Sale Price :';
	echo form_input('bulkSalePrice', $row->bulkSalePrice, 'readonly');

	echo '</br></br>';
	echo '<img src='. $img_base.'full/'.$row->photo.'>';

	echo '</br></br>';
	echo form_close();
}
?>


<?php
	$this->load->view('footer'); 
?>
