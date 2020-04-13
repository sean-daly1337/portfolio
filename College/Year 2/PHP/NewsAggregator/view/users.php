<?php include('header.php');

include('menu.php'); 
      
?>

    
    <!-- Page Content -->
    <div class="container" style="padding-top:30px;padding-bottom:30px;">

      <?php
      
      print "<div class='col-md-10 offset-md-1'><table class='table table-bordered table-striped'>
      <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email Address</th>
        <th>Gender</th>
        <th>City</th>
        <th>Country</th>
      </tr>";
      
      foreach($users as $row) {
        print "<tr>
          <td>".$row['first_name']."</td>
          <td>".$row['last_name']."</td>
          <td>".$row['emailadd']."</td>
          <td>".$row['gender']."</td>
          <td>".$row['city']."</td>
          <td>".$row['country']."</td>
        </tr>";
      }
      print "</table></div>";
    

    ?>
    

    </div>
    <!-- /.container -->
  
<?php include('footer.php');?>