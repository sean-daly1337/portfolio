<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    User userObj = (User) session.getAttribute("loggedInUser");
%>

<!DOCTYPE html>
<html>
    <head>
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
        <section class="intro-wrapper bgimage overlay overlay--dark">
            <!-- background video -->
            <div class="bg_image_holder">
                <video autoplay muted loop id="myVideo">
                    <source src="img/index/bg-video.mp4" type="video/mp4">
                </video>
            </div>
            <% if (userObj == null) { %>
            <jsp:include page="shared/navbar.jsp" flush="true"/>
            <% } else { %>
            <jsp:include page = "shared/navbarLoggedIn.jsp" flush = "true" />
            <%}
            %>
            <!-- ends: .mainmenu-wrapper -->
            <div class="directory_content_area">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-10 offset-lg-1">
                            <div class="search_title_area">
                                <h2 class="title">Find the Best cars in Limerick</h2>
                                <p class="sub_title">All the best used cars ? from Toyota, to Volkswagen, to Ford, to BMW and what not..</p>
                            </div>
                            <!-- ends: .search_title_area -->
                            <!-- ends: .search_form -->
                            <div class="directory_home_category_area">
                                <ul class="categories">
                                    <li>
                                        <a href="allCars">
                                            <span class="color-primary"><i class="las la-car"></i></span> Nissan
                                        </a>
                                    </li>
                                    <li>
                                        <a href="allCars">
                                            <span class="color-success"><i class="las la-car"></i></span> Ford
                                        </a>
                                    </li>
                                    <li>
                                        <a href="allCars">
                                            <span class="color-warning"><i class="las la-car"></i></span> BMW
                                        </a>
                                    </li>
                                    <li>
                                        <a href="allCars">
                                            <span class="color-danger"><i class="las la-car"></i></span> Mercedes
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <!-- ends: .directory_home_category_area -->
                        </div>
                        <!-- ends: .col-lg-10 -->
                    </div>
                </div>
            </div>
            <!-- ends: .directory_search_area -->
        </section>

        <section class="cta section-padding border-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Why <span>Moylish Motors</span> for you and your family?</h2>
                            <p>Quality, comfort, luxury, all at one place - Moylish Motors</p>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="row align-items-center">
                            <div class="col-lg-6 col-md-6">
                                <img src="img/svg/illustration-1.svg" alt="" class="svg">
                            </div>
                            <div class="col-lg-5 offset-lg-1 col-md-6 mt-5 mt-md-0">
                                <ul class="feature-list-wrapper list-unstyled">
                                    <li>
                                        <div class="icon"><span class="circle-secondary"><i class="la la-check-circle"></i></span></div>
                                        <div class="list-content">
                                            <h4>Tested Cars</h4>
                                            <p>All cars are properly inspected and tested by experts to ensure that you get the best thing</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="icon"><span class="circle-success"><i class="la la-money"></i></span></div>
                                        <div class="list-content">
                                            <h4>Cheap Prices</h4>
                                            <p>Our prices are the lowest in the market as our aim is to make luxury cars available to almost everyone</p>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="icon"><span class="circle-primary"><i class="la la-line-chart"></i></span></div>
                                        <div class="list-content">
                                            <h4>Enhance your standards</h4>
                                            <p>Enjoy the comfort and luxury of our used cars, which doesn't look used at all :)</p>
                                        </div>
                                    </li>
                                </ul>
                                <!-- ends: .feature-list-wrapper -->
                                <ul class="action-btns list-unstyled">
                                    <li><a href="allCars" class="btn btn-success">See our Vehicles</a></li>
                                    <li><a href="" class="btn btn-primary" data-toggle="modal" data-target="#signup_modal">Sign up</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="testimonial-wrapper section-padding--bottom">
            <br><br>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>Trusted By Over 4000+ Users</h2>
                            <p>Here is what people say about Moylish Motors</p>
                        </div>
                    </div>
                    <!-- ends: .col-lg-12 -->
                    <div class="testimonial-carousel owl-carousel">
                        <div class="carousel-single">
                            <div class="author-thumb">
                                <img src="img/auth1.png" alt="" class="rounded-circle">
                            </div>
                            <div class="author-info">
                                <h4>Francis Burton</h4>
                                <span>Toronto, Canada</span>
                            </div>
                            <p class="author-comment">
                                Very polite and supportive staff of Moylish Motors.They provide very good hospitality and after sales services also.Full transparency for your car regarding service, repairing, accessories etc.Jamnagar People have this better choice to get benefits.
                            </p>
                        </div>
                        <!-- ends: .carousel-single -->
                        <div class="carousel-single">
                            <div class="author-thumb">
                                <img src="img/auth1.png" alt="" class="rounded-circle">
                            </div>
                            <div class="author-info">
                                <h4>John Wick</h4>
                                <span>New York, States</span>
                            </div>
                            <p class="author-comment">
                                Very good service, work perfection, and quality of work, hospitable staff, good sales persons, technical staff, and overall excellent experience. Worth having job done.
                            </p>
                        </div>
                        <!-- ends: .carousel-single -->
                        <div class="carousel-single">
                            <div class="author-thumb">
                                <img src="img/auth1.png" alt="" class="rounded-circle">
                            </div>
                            <div class="author-info">
                                <h4>JK Dulfam</h4>
                                <span>Lodon, UK</span>
                            </div>
                            <p class="author-comment">
                                I had a wonderful experience here. These guys are professional and courteous I had Jacob/ everything went smoothly never had a better or easier ...
                            </p>
                        </div>
                        <!-- ends: .carousel-single -->
                    </div>
                    <!-- ends: .testimonial-carousel -->
                </div>
            </div>
        </section>
        <!-- ends: .testimonial-wrapper -->
        <section class="clients-logo-wrapper border-top p-top-100">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="logo-carousel owl-carousel">
                            <div class="carousel-single">
                                <img src="img/brands/7.jpg" alt="">
                            </div>
                            <div class="carousel-single">
                                <img src="img/brands/8.jpg" alt="">
                            </div>
                            <div class="carousel-single">
                                <img src="img/brands/3.jpg" alt="">
                            </div>
                            <div class="carousel-single">
                                <img src="img/brands/4.jpg" alt="">
                            </div>
                            <div class="carousel-single">
                                <img src="img/brands/9.jpg" alt="">
                            </div>
                            <div class="carousel-single">
                                <img src="img/brands/6.jpg" alt="">
                            </div>
                        </div>
                        <!-- ends: .logo-carousel -->
                    </div>
                </div>
            </div>
        </section>



        <%@ include file ="shared/footer.jsp" %>
        <!-- inject:js-->
        <script src="vendor_assets/js/bootstrap/popper.js"></script>
        <script src="vendor_assets/js/jquery/jquery-1.12.3.js"></script>
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

    </body>

</html>