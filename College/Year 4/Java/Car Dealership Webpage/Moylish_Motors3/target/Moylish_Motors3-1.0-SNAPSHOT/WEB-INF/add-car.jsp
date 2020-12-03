<%@page import="Model.User"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <%
        User userObj = (User) session.getAttribute("loggedInUser");
        if (userObj == null) {
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "./index.jsp");
        } else if (userObj.getRoleId() != 1) {
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "./index.jsp");
        }
    %>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Moylish Motors </title>
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,600,700" rel="stylesheet">
        <!-- inject:css-->
        <link rel="stylesheet" href="vendor_assets/css/bootstrap/bootstrap.css">
        <link rel="stylesheet" href="vendor_assets/css/brands.css">
        <link rel="stylesheet" href="vendor_assets/css/fontawesome.min.css">
        <link rel="stylesheet" href="vendor_assets/css/jquery-ui.css">
        <link rel="stylesheet" href="vendor_assets/css/jquery.mCustomScrollbar.css">
        <link rel="stylesheet" href="vendor_assets/css/line-awesome.min.css">
        <link rel="stylesheet" href="vendor_assets/css/magnific-popup.css">
        <link rel="stylesheet" href="vendor_assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="vendor_assets/css/select2.min.css">
        <link rel="stylesheet" href="vendor_assets/css/slick.css">
        <link rel="stylesheet" href="style.css">
        <!-- endinject -->
        <link rel="icon" type="image/png" sizes="32x32" href="img/fevicon.png">
        <link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/line-awesome/1.3.0/css/line-awesome.min.css">
    </head>

    <body>
        <section class="header-breadcrumb bgimage overlay overlay--dark">
            <div class="bg_image_holder"><img src="img/breadcrumb1.jpg" alt=""></div>
                <%@ include file ="../shared/navbarLoggedIn.jsp" %>
            <!-- ends: .mainmenu-wrapper -->
            <div class="breadcrumb-wrapper content_above">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h1 class="page-title">Add Car</h1>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">All Car</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ends: .breadcrumb-wrapper -->
        </section>
        <section class="add-listing-wrapper border-bottom section-bg section-padding-strict">
            <div class="container">
                <form class="row" action="add-car.jsp" id="addNewCar" method="POST" enctype="multipart/form-data">
                    <div class="col-lg-10 offset-lg-1">
                        <div class="atbd_content_module">
                            <div class="atbd_content_module__tittle_area">
                                <div class="atbd_area_title">
                                    <h4><span class="la la-user"></span>Salesman Info</h4>
                                </div>
                            </div>
                            <div class="atbdb_content_module_contents">
                                <div class="row">
                                    <div class="form-group col-lg-8 col-md-8">
                                        <label for="title" class="form-label">Select Salesman</label>
                                        <div class="select-basic">
                                            <select class="form-control" name="salesmanUsername"  required>
                                                <option>Select salesman</option>
                                                <c:forEach items="${salesmen}" var="saleman">
                                                    <option value="${saleman.getUsername()}">${saleman.getUsername()} - ${saleman.getName()} - ${saleman.getPhone()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-4 col-md-4">
                                        <label for="title" class="form-label">If new user then add</label>
                                        <br>
                                        <button type="button"  class="btn btn-secondary" data-toggle="modal" data-target="#add_new_salesmman_modal">Add New Salesman</button>
                                    </div>
                                </div>
                            </div>
                            <!-- ends: .atbdb_content_module_contents -->
                        </div>
                        <!-- ends: .atbd_content_module -->
                    </div>



                    <div class="col-lg-10 offset-lg-1">
                        <div class="atbd_content_module">
                            <div class="atbd_content_module__tittle_area">
                                <div class="atbd_area_title">
                                    <h4><span class="la la-user"></span>Last Previous Owner</h4>
                                </div>
                            </div>
                            <div class="atbdb_content_module_contents">
                                <div class="row">
                                    <div class="form-group col-lg-8 col-md-8">
                                        <label for="title" class="form-label">Select Previous Owner</label>
                                        <div class="select-basic">
                                            <select class="form-control" name="previousOwnerUsername"  required>
                                                <option>Select User</option>
                                                <c:forEach items="${users}" var="user">
                                                    <option value="${user.getUsername()}">${user.getUsername()} - ${user.getName()} - ${user.getPhone()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-4 col-md-4">
                                        <label for="title" class="form-label">If new user then add</label>
                                        <br>
                                        <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#add_new_user_modal">Add New User</button>
                                    </div>
                                </div>
                            </div>
                            <!-- ends: .atbdb_content_module_contents -->
                        </div>
                        <!-- ends: .atbd_content_module -->
                    </div>
                    <div class="col-lg-10 offset-lg-1">
                        <div class="atbd_content_module">
                            <div class="atbd_content_module__tittle_area">
                                <div class="atbd_area_title">
                                    <h4><span class="la la-car"></span>Give Car Details</h4>
                                </div>
                            </div>
                            <div class="atbdb_content_module_contents">
                                <div class="row">
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Listing</label>
                                        <input type="number" name="listing"  class="form-control" placeholder="Enter Listing Number"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Registration</label>
                                        <input type="text" name="reg" class="form-control" placeholder="Enter Registration"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Year</label>
                                        <input type="text" name="year" class="form-control" placeholder="Enter Year"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Make</label>
                                        <input type="text" name="make" class="form-control" placeholder="Enter car company"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Model</label>
                                        <input type="text" name="model" class="form-control" placeholder="Enter car Model"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Color</label>
                                        <input type="text" name="color" class="form-control" placeholder="Enter car color"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="desc" class="form-label">Description</label>
                                        <textarea id="desc" name="description" rows="5" class="form-control" placeholder="Enter car description"></textarea>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Buy Price</label>
                                        <input type="number" name="buyPrice" id="buy-price" class="form-control" placeholder="Enter car price"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">List Price</label>
                                        <input type="number" name="listPrice" id="list-price" class="form-control" value="" placeholder="Calulated list price"  readonly>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Odometer (KPH)</label>
                                        <input type="text" name="odometer" class="form-control" placeholder="Enter car Odometer (KPH)"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">0-62 kph</label>
                                        <input type="text" name="kph" class="form-control" placeholder="Enter seconds"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Engine</label>
                                        <input type="text" name="engine" class="form-control" placeholder="Enter Engine"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Fuel</label>
                                        <div class="select-basic">
                                            <select class="form-control" name="fuel"  required>
                                                <option>Select Fuel Type</option>
                                                <option value="Petrol">Petrol</option>
                                                <option value="Diesel">Diesel</option>
                                                <option value="Hybrid">Hybrid</option>
                                                <option value="Electric">Electric</option>
                                                <option value="Gas">Gas</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Transmission</label>
                                        <div class="select-basic">
                                            <select class="form-control" name="transmission"  required>
                                                <option>Select Transmission</option>
                                                <option value="Automatic">Automatic</option>
                                                <option value="Manual">Manual</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Body</label>
                                        <input type="text" name="body" class="form-control" placeholder="Enter car body"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">

                                        <label for="title" class="form-label">Isofax</label>
                                        <div class="select-basic">
                                            <select class="form-control" name="isofax"  required>
                                                <option>Select Isofax</option>
                                                <option value="Yes">Yes</option>
                                                <option value="No">No</option>
                                            </select>
                                        </div>

                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Motor Tax</label>
                                        <input type="number" name="tax" class="form-control" placeholder="Enter Motor Tax"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Previous Owners</label>
                                        <input type="number" name="previousOwners" class="form-control" placeholder="Enter count of Previous Owners"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Full Service History</label>
                                        <div class="select-basic">
                                            <select class="form-control" name="serviceHistory"  required>
                                                <option>Full Service History</option>
                                                <option value="Yes">Yes</option>
                                                <option value="No">No</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Note</label>
                                        <input type="text" name="note" class="form-control" accept="image/*" placeholder="Enter Note (if any)"  required>
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label class="form-label">Upload Thumbnail Image</label>
                                        <input type="file" name="thumbnail" accept="image/*" >
                                    </div>
                                    <div class="form-group col-lg-6 col-md-6">
                                        <label for="title" class="form-label">Upload Images (Upload images at once)</label><br>
                                        <input type="file" name="images" accept="image/*"   multiple="muliple" required>
                                    </div>
                                    <!-- ends: .form-group -->
                                </div>
                            </div>
                            <!-- ends: .atbdb_content_module_contents -->
                        </div>
                        <!-- ends: .atbd_content_module -->
                    </div>

                    <div class="col-lg-10 offset-lg-1">
                        <div class="text-center card">
                            <button type="submit" class="btn btn-info">Add Car</button>
                        </div>
                    </div>

                </form>
            </div>
        </section>


        <div class="modal fade" id="add_new_user_modal" tabindex="-1" role="dialog" aria-labelledby="signup_modal_label" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="signup_modal_label"><i class="la la-lock"></i> Add New User</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="addUser" id="add_user_form" method="post">
                            <div class="form-group">
                                <input  type="text" name="username" class="form-control" placeholder="Username"  required>
                            </div> 
                            <div class="form-group">
                                <input type="text" name="name" class="form-control" placeholder="Name"  required>
                            </div> 
                            <div class="form-group">
                                <input type="email" name="email" class="form-control" placeholder="Email"  required>
                            </div> 
                            <div class="form-group">
                                <input type="password" name="password" id="user_password" class="form-control" placeholder="Password"  required>
                            </div> 
                            <div class="form-group">
                                <input type="password" class="form-control" id="user_confirm_password" placeholder="Confirm Password"  required>
                            </div> 
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="roleID" value="3"  required>
                            </div>
                            <div>
                                <span id='message'></span>
                            </div>
                            <button type="submit" class="btn btn-block btn-lg btn-gradient btn-gradient-two" id="submitBtnUser">Add User</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>


        <div class="modal fade" id="add_new_salesmman_modal" tabindex="-1" role="dialog" aria-labelledby="signup_modal_label" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="signup_modal_label"><i class="la la-lock"></i> Add New Salesman</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="addUser" id="add_salesman_form" method="post">
                            <div class="form-group">
                                <input  type="text" name="username" class="form-control" placeholder="Username"  required>
                            </div> 
                            <div class="form-group">
                                <input type="text" name="name" class="form-control" placeholder="Name"  required>
                            </div> 
                            <div class="form-group">
                                <input type="email" name="email" class="form-control" placeholder="Email"  required>
                            </div> 
                            <div class="form-group">
                                <input type="password" name="password" id="salesman_password" class="form-control" placeholder="Password"  required>
                            </div> 
                            <div class="form-group">
                                <input type="password" class="form-control" id="salesman_confirm_password" placeholder="Confirm Password"  required>
                            </div> 
                            <div class="form-group">
                                <input type="hidden" class="form-control" name="roleID" value="2"  required>
                            </div> 
                            <div>
                                <span id='message'></span>
                            </div>
                            <button type="submit" class="btn btn-block btn-lg btn-gradient btn-gradient-two" id="submitBtnSalesman">Add Salesman</button>
                        </form>

                    </div>
                </div>
            </div>
        </div>
        <%@ include file ="../shared/footer.jsp" %>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0C5etf1GVmL_ldVAichWwFFVcDfa1y_c"></script>
        <!-- inject:js-->
        <script src="vendor_assets/js/jquery/jquery-1.12.3.js"></script>
        <script src="vendor_assets/js/bootstrap/popper.js"></script>
        <script src="vendor_assets/js/bootstrap/bootstrap.min.js"></script>
        <script src="vendor_assets/js/jquery-ui.min.js"></script>
        <script src="vendor_assets/js/jquery.barrating.min.js"></script>
        <script src="vendor_assets/js/jquery.counterup.min.js"></script>
        <script src="vendor_assets/js/jquery.magnific-popup.min.js"></script>
        <script src="vendor_assets/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="vendor_assets/js/jquery.waypoints.min.js"></script>
        <script src="vendor_assets/js/masonry.pkgd.min.js"></script>
        <script src="vendor_assets/js/owl.carousel.min.js"></script>
        <script src="vendor_assets/js/select2.full.min.js"></script>
        <script src="vendor_assets/js/slick.min.js"></script>
        <script src="theme_assets/js/locator.js"></script>
        <script src="theme_assets/js/main.js"></script>
        <script src="theme_assets/js/map.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <script src="theme_assets/js/addCar.js"></script>
        <!-- endinject-->
    </body>

</html>