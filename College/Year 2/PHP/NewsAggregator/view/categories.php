<?php include('header.php'); 

  include('menu.php'); 
        
  if(!isset($_SESSION['wm_userid']) || empty($_SESSION['wm_userid'])) 
    header('Location: index.php');
   
    ?>

    <form action="" method="Post">
    <!-- Page Content -->
    <div class="container" style="padding-top:30px;padding-bottom:30px;">

    <div class="col-md-10 offset-md-1" align="center">  
      <!-- Intro Content -->
      <div class="row">
            <div class="col-md-6 offset-md-3"><h3>All Categories</h3></div>
      </div><br>

      

           
      <!-- /.row -->
      </div>


    </div>
  <!-- /.container -->
    </form>

    <?php
    
      print "<div class='col-md-12 offset-md-0'><table class='table table-bordered table-striped'>
      <tr>
        <th>Title</th>
        <th>Description</th>
        <th>All Article</th>
        
      </tr>";
      $eventid = $_POST['eventid'];
           
      foreach ( $categories as $row ) {
       $id = $row['id'];
        print "<tr>
          <td>".$row['title']."</td>
          <td>".$row['description']."</td>
          <td><a href='articles.php?cid=$id'>All Articles</a></td>
        </tr>";
      }
      print "</table></div>";
    

    ?>


<?php include('footer.php'); ?>