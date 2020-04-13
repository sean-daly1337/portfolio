<!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="index.html"></a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <?php
           //print $_SESSION['wm_userid'].'sdf';
              if(isset($_SESSION['wm_userid']) && $_SESSION['wm_userid']>0)
              {
                if($_SESSION['wm_type_of_user'] == 'admin')
                {
                  print '<li class="nav-item">
                <a class="nav-link" href="users.php">All Users</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="categories.php">All Categories</a>
                </li>
                                
                <li class="nav-item">
                <a class="nav-link" href="index.php">Logout</a>
                </li>';
                }

                if($_SESSION['wm_type_of_user'] == 'user')
                {
                  print '<li class="nav-item">
                <a class="nav-link" href="categories.php">All Categories</a>
                </li>
                                
                <li class="nav-item">
                <a class="nav-link" href="index.php">Logout</a>
                </li>';
                }
              }
            ?>

          </ul>
        </div>
      </div>
    </nav>