<?php include('header.php'); ?>

    <body>

      
      <form action="" method="Post">
      <!-- Page Content -->
      <div class="container" style="padding-top:30px;padding-bottom:30px;">

      <div class="col-md-10 offset-md-1">  
        <!-- Intro Content -->
        <div class="row">
              <div class="col-md-2" align="right"><label style="padding-top:4px;">First Name</label></div>
              <div class="col-md-2"><input type="text" name="first_name" class="form-control" required ></div>
              <div class="col-md-2" align="right" ><label style="padding-top:4px;">Last Name</label></div>
              <div class="col-md-2"><input type="text" name="last_name" class="form-control" required ></div>
        </div><br>

        <div class="row">
              <div class="col-md-2" align="right"><label style="padding-top:4px;">Email</label></div>
              <div class="col-md-6"><input type="email" name="emailadd" class="form-control" required ></div>
        </div><br>

        <div class="row">
              <div class="col-md-2" align="right"><label style="padding-top:-1px;">Gender</label></div>
              <div class="col-md-6">
                  <input type="radio" name="gender" value="Male"  required >&nbsp;Male
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <input type="radio" name="gender" value="Female"  require >&nbsp;Female
              </div>
        </div><br>

        <div class="row">
              <div class="col-md-2" align="right"><label style="padding-top:4px;">City</label></div>
              <div class="col-md-2"><input type="text" name="city" class="form-control"  ></div>
              <div class="col-md-2" align="right" ><label style="padding-top:4px;">Country</label></div>
              <div class="col-md-2"><input type="text" name="country" class="form-control"  ></div>
        </div><br>

        <div class="row">
              <div class="col-md-2" align="right"><label style="padding-top:4px;">Password</label></div>
              <div class="col-md-6"><input type="password" name="password" class="form-control" required ></div>
        </div><br>

        <div class="row">
              <div class="col-md-2" align="right"></div>
              <div class="col-md-6" align="center"><input type="submit" class="btn btn-submit" name="btnRegister" class="form-control" value="Register" ></div>
        </div><br>

        <div class="row">
              <div class="col-md-8" align="center">Have an Account already? &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href='index.php'>Login</a></div>
        </div><br>

        
        <!-- /.row -->
        </div>


      </div>
    <!-- /.container -->
      </form>

    <?php include('footer.php'); ?>