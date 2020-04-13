<?php
include('header.php'); 

  include('menu.php'); 
        
  if(!isset($_SESSION['wm_userid']) || empty($_SESSION['wm_userid'])) 
    header('Location: index.php');
  include('config.php');

  
    ?>
    <?php
    
    
//print_r($xml->channel);


    
    if(!empty($_GET['cid']))
    {
      
     
      $myXMLData = file_get_contents($feed);    
    $xml=simplexml_load_string($myXMLData) or die("Error: Cannot create object");
    
      print "<table class='table table-bordered table-striped'>
  <tr><th>Title</th>
        <th>Description</th>
        <th>Publish Date</th></tr>";
 
      foreach($xml->channel->item as $row)
      {
        print "<tr>
          <td><a href='$row->link' target='_blank'>$row->title</a></td>
          <td>$row->description</td>
          <td>$row->pubDate</td>
        </tr>";
      }

      print "</table>";
    }

    ?>

    <?php include('footer.php'); ?>