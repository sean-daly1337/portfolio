<?php include('header.php'); ?>
<?php
echo $reslt;
?>
<form action="" method="Post">
    <!-- Page Content -->
    <div class="container" style="padding-top:30px;padding-bottom:30px;">
      
    <div class="col-md-10 offset-md-1" align="center">  
      <!-- Intro Content -->
      <div class="row">
            <div class="col-md-6 offset-md-3">Login</div>
      </div><br>

      <div class="row">
            <div class="col-md-6 offset-md-3"><input type="email" name="emailadd" class="form-control" required placeholder="Email Address" ></div>
      </div><br>

      <div class="row">
            <div class="col-md-6 offset-md-3"><input type="password" name="password" class="form-control" placeholder="Password" required ></div>
      </div><br>
      <?php 
      
      if($_SESSION['message'] == 'error') { ?>
      <div class="row">
          <div class='col-md-4 offset-md-4 alert alert-danger'>
              User Not Found
          </div>
      </div>
      <?php 
          $_SESSION['message'] = '';
        } 
      ?>
      <div class="row">
            <div class="col-md-6 offset-md-3" align="center"><input type="submit" class="btn btn-submit" name="login" class="form-control" value=" Log In " ></div>
      </div><br>

      <div class="row">
            <div class="col-md-6 offset-md-3" align="center">Not signed up yet? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href='register.php'>Register</a></div>
      </div><br>

      
      <!-- /.row -->
      </div>


    </div>
  <!-- /.container -->
    </form>

<?php include('footer.php'); ?>