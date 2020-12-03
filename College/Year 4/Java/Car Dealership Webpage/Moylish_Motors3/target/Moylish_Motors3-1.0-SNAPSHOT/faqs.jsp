<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    User userObj = (User) session.getAttribute("loggedInUser");
%>
<!DOCTYPE html>
<html lang="en">

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
                <% if (userObj == null) { %>
                <jsp:include page="shared/navbar.jsp" flush="true"/>
                <% } else { %>
                <jsp:include page = "shared/navbarLoggedIn.jsp" flush = "true" />
                <%}
                %>
            <!-- ends: .mainmenu-wrapper -->
            <div class="breadcrumb-wrapper content_above">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h1 class="page-title">FAQs</h1>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">All Listings</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ends: .breadcrumb-wrapper -->
        </section>
        <section class="faq-wrapper section-padding border-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Your Questions Answered</h2>
                            <p>You are not alone, We are here for you 24/7</p>
                        </div>
                    </div>
                    <!-- ends: .col-lg-12 -->
                    <div class="col-lg-12">
                        <div class="faq-contents">
                            <div class="atbd_content_module atbd_faqs_module">
                                <div class="atbd_content_module__tittle_area">
                                    <div class="atbd_area_title">
                                        <h4><span class="la la-question-circle"></span>Moylish Motors FAQ's</h4>
                                    </div>
                                </div>
                                <div class="atbdb_content_module_contents">
                                    <div class="atbdp-accordion">
                                        <div class="accordion-single selected">
                                            <h3 class="faq-title"><a href="#">How to open an account?</a></h3>
                                            <p class="ac-body" style="display: block;">
                                                Simply click on reigster, enter username, password and boom!! Your account is live, now sign in, update your profile and start purchasing.
                                            </p>
                                        </div>
                                        <div class="accordion-single">
                                            <h3 class="faq-title"><a href="#">How to purchase car?</a></h3>
                                            <p class="ac-body" style="display: none;">View cars, click on car details, select your dream car and purchase it or come to our office to examine the car and test car.</p>
                                        </div>
                                        <div class="accordion-single">
                                            <h3 class="faq-title"><a href="#">How to trade a car?</a></h3>
                                            <p class="ac-body" style="display: none;">Come to our office with your car, we will examine your car, select your future car and we'll trade it within minutes. Extra cost will be adjusted.</p>
                                        </div>
                                        <div class="accordion-single">
                                            <h3 class="faq-title"><a href="#">Is my data safe?</a></h3>
                                            <p class="ac-body" style="display: none;">Absolutely! Moylish Motors does not give any of it's data to any third party hence maintaining the privacy of users.</p>
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!-- ends: .atbd_content_module -->
                        </div>
                        <!-- ends: .faq-contents -->
                    </div>
                    <!-- ends: .col-lg-12 -->
                </div>
            </div>
        </section>
        <%@ include file ="shared/footer.jsp" %>   
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
        <script src="theme_assets/js/index.js"></script>
        <!-- endinject-->
    </body>

</html>