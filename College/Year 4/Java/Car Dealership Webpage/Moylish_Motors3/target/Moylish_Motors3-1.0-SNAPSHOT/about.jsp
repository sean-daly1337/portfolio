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
        <section class="about-wrapper bg-gradient-ps">
            <% if (userObj == null) { %>
            <jsp:include page="shared/navbar.jsp" flush="true"/>
            <% } else { %>
            <jsp:include page = "shared/navbarLoggedIn.jsp" flush = "true" />
            <%}
            %>
            <!-- ends: .mainmenu-wrapper -->
            <div class="about-intro content_above">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-5 col-md-6">
                            <h1>Buy your dream car at an insanely amazing prices</h1>
                            <a href="#" class="play-btn-two" onclick="goToIDbyScrolling('youtube-video')">
                                <span class="icon"><i class="la la-youtube-play"></i></span>
                                <span>Play our Video</span>
                            </a>
                        </div>
                        <div class="col-lg-6 offset-lg-1 col-md-6 offset-md-0 col-sm-8 offset-sm-2">
                            <img src="img/about-illustration.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
            <!-- ends: .about-intro -->
        </section>
        <!-- ends: .intro-wrapper -->
        <section class="about-contents section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 contents-wrapper">
                        <div class="contents">
                            <div class="row align-items-center" id="youtube-video">
                                <iframe width="100%" height="600" src="https://www.youtube.com/embed/yz36G2t3Jz4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>
                        </div>
                        <!-- ends: .contents -->
                        <div class="contents">
                            <div class="row align-items-center">
                                <div class="col-lg-5 col-sm-6">
                                    <h1>Why buy cars from <span>Moylish Motors</span></h1>
                                    <ul class="list-unstyled list-features p-top-15">
                                        <li>
                                            <div class="list-count"><span>1</span></div>
                                            <div class="list-content">
                                                <h4>Easy Registration</h4>
                                                <p>Login/Register your accounts in seconds, view the best cars in town.</p>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="list-count"><span>2</span></div>
                                            <div class="list-content">
                                                <h4>Purchase a car anytime</h4>
                                                <p>View your dream cars and make them yours within a few button clicks.</p>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="list-count"><span>3</span></div>
                                            <div class="list-content">
                                                <h4>Trade with us</h4>
                                                <p>Come to our office with your car and trade with us for your dream vehicle.</p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="col-lg-6 offset-lg-1 text-right col-sm-6 mt-5 mt-md-0">
                                    <img src="img/about-img2.png" alt="">
                                </div>
                            </div>
                        </div>
                        <!-- ends: .contents -->
                    </div>
                    <!-- ends: .content-block -->
                </div>
            </div>
        </section>
        <!-- ends: .about-contents -->
        <section class="counters-wrapper bg-gradient-pw section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <h1>Thousands of People</h1>
                        <p>turn to Moylish Motors every day to make spending decisions</p>
                        <ul class="list-unstyled counter-items">
                            <li>
                                <p><span class="count_up">59</span>k+</p>
                                <span>Cars</span>
                            </li>
                            <li>
                                <p><span class="count_up">23</span>k+</p>
                                <span>Verified Users</span>
                            </li>
                            <li>
                                <p><span class="count_up">5</span>k+</p>
                                <span>New users per month</span>
                            </li>
                            <li>
                                <p><span class="count_up">42</span>k+</p>
                                <span>Visitors per month</span>
                            </li>
                        </ul>
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
      
        <!-- ends: .clients-logo-wrapper -->
        <section class="subscribe-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <h1>Subscribe to Newsletter</h1>
                        <p>Subscribe to get update and information. Don't worry, we won't send spam!</p>
                        <form action="/" class="subscribe-form m-top-40">
                            <div class="form-group">
                                <span class="la la-envelope-o"></span>
                                <input type="text" placeholder="Enter your email" required>
                            </div>
                            <button class="btn btn-gradient btn-gradient-one">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <!-- ends: .subscribe-wrapper -->
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