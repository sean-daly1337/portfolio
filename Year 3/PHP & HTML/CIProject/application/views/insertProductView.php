<?php
$this->load->view('header');
$this->load->helper('url');
$base = base_url() . index_page();
$img_base = base_url()."assets/images/";
?>
<center><table>
<?php echo form_open_multipart('product/handleInsert');
echo 'Enter Produce Code :';
echo form_input('produceCode', $produceCode);
echo '</br></br>Enter Description :';
echo form_input('description', $description);
echo '</br></br>Enter Product Line :';
echo form_input('productLine', $productLine);
echo '</br></br>Enter Supplier :';
echo form_input('supplier', $supplier);
echo '</br></br>Enter Quantity In Stock :';
echo form_input('quantityInStock', $quantityInStock);
echo '</br></br>Enter Bulk Buy Price :';
echo form_input('bulkBuyPrice', $bulkBuyPrice);
echo '</br></br>Enter Bulk Sale Price :';
echo form_input('bulkSalePrice', $bulkSalePrice);
echo '</br></br>Select File for Upload :';
echo form_upload('userfile');
echo form_submit('submitInsert', "Submit!");
echo form_close();
echo validation_errors();
?>
</table></center>

<?php
$this->load->view('footer');
?>
