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
                            <h1 class="page-title">Contact Us</h1>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Contact Us</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ends: .breadcrumb-wrapper -->
        </section>
        <section class="contact-area section-bg p-top-100 p-bottom-70">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="widget atbd_widget widget-card contact-block">
                            <div class="atbd_widget_title">
                                <h4><span class="la la-envelope"></span> Contact Form</h4>
                            </div>
                            <!-- ends: .atbd_widget_title -->
                            <div class="atbdp-widget-listing-contact contact-form">
                                <form id="atbdp-contact-form" class="form-vertical" role="form">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="atbdp-contact-name" placeholder="Name" required="">
                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control" id="atbdp-contact-email" placeholder="Email" required="">
                                    </div>
                                    <div class="form-group">
                                        <textarea class="form-control" id="atbdp-contact-message" rows="6" placeholder="Message" required=""></textarea>
                                    </div>
                                    <button type="submit" class="btn btn-gradient btn-gradient-one btn-block">Send Message</button>
                                </form>
                            </div>
                            <!-- ends: .atbdp-widget-listing-contact -->
                        </div>
                        <!-- ends: .widget -->
                    </div>
                    <!-- ends: .col-lg-8 -->
                    <div class="col-lg-4">
                        <div class="widget atbd_widget widget-card">
                            <div class="atbd_widget_title">
                                <h4><span class="la la-phone"></span>Contact Info</h4>
                            </div>
                            <!-- ends: .atbd_widget_title -->
                            <div class="widget-body atbd_author_info_widget">
                                <div class="atbd_widget_contact_info">
                                    <ul>
                                        <li>
                                            <span class="la la-map-marker"></span>
                                            <span class="atbd_info">25 East Valley Road, Michigan</span>
                                        </li>
                                        <li>
                                            <span class="la la-phone"></span>
                                            <span class="atbd_info">(213) 995-77100</span>
                                        </li>
                                        <li>
                                            <span class="la la-envelope"></span>
                                            <span class="atbd_info">admin@moylishmotors.com</span>
                                        </li>
                                        <li>
                                            <span class="la la-globe"></span>
                                            <a href="" class="atbd_info">www.moylishmotors.com</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- ends: .atbd_widget_contact_info -->
                                <div class="atbd_social_wrap">
                                    <p><a href="https://lit.ie/" target="_blank"><span class="fab fa-facebook-f"></span></a></p>
                                    <p><a href="https://lit.ie/" target="_blank"><span class="fab fa-twitter"></span></a></p>
                                    <p><a href="https://lit.ie/" target="_blank"><span class="fab fa-google-plus-g"></span></a></p>
                                    <p><a href="https://lit.ie/" target="_blank"><span class="fab fa-linkedin-in"></span></a></p>
                                    <p><a href="https://lit.ie/" target="_blank"><span class="fab fa-dribbble"></span></a></p>
                                </div>
                                <!-- ends: .atbd_social_wrap -->
                            </div>
                            <!-- ends: .widget-body -->
                        </div>
                        <!-- ends: .widget -->
                    </div>
                    <!-- ends: .col-lg-4 -->
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