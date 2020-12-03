<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
    <%
        String getImageUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + "/Moylish_Motors3/getImage?imagePathID=";
    %>
    <body>
        <section class="header-breadcrumb bgimage overlay overlay--dark">
            <div class="bg_image_holder"><img src="img/breadcrumb1.jpg" alt=""></div>
                <% if (userObj == null) { %>
                <jsp:include page="../shared/navbar.jsp" flush="true"/>
                <% } else { %>
                <jsp:include page = "../shared/navbarLoggedIn.jsp" flush = "true" />
                <%}
                %>
            <!-- ends: .mainmenu-wrapper -->
            <div class="breadcrumb-wrapper content_above">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <h1 class="page-title">Vehicles</h1>
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">All Vehicles</li>
                                </ol>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ends: .breadcrumb-wrapper -->
        </section>
        <section class="all-listing-wrapper section-bg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="atbd_generic_header">
                            <div class="atbd_generic_header_title">
                                <h4>Moylish Motor Cars</h4>
                                <p>Total Cars Found: ${fn:length(allCars)}</p>
                            </div>
                        </div>
                        <!-- ends: .atbd_generic_header -->
                    </div>
                    <!-- ends: .col-lg-12 -->
                    <div class="col-lg-12 listing-items">
                        <div class="row">
                            <!-- ends: .col-lg-4 -->
                            <div class="col-lg-12">
                                <div class="row">
                                    <c:forEach items="${allCars}" var="car">
                                        <div class="col-lg-4 col-sm-6">
                                            <div class="atbd_single_listing ">
                                                <article class="atbd_single_listing_wrapper">
                                                    <figure class="atbd_listing_thumbnail_area">
                                                        <div class="atbd_listing_image">
                                                            <a href="car-details.jsp?listing=${car.getListing()}" target="_blank">
                                                                <img width="70px" height="200px" class="car-thumbnail" src="<%= getImageUrl%>${car.getThumbnailID()}"  alt="Car Img">
                                                            </a>
                                                        </div>
                                                        <div class="atbd_thumbnail_overlay_content">
                                                        </div>
                                                    </figure>
                                                    <div class="atbd_listing_info">
                                                        <div class="atbd_content_upper">
                                                            <h4 class="atbd_listing_title">
                                                                <a href="car-details.jsp?listing=${car.getListing()}" target="_blank">${car.getListing()} | ${car.getYear()}</a>
                                                            </h4>
                                                            <div class="atbd_listing_meta">
                                                                <span class="atbd_meta atbd_listing_price">$ ${car.getListPrice()}</span>
                                                                <span class="atbd_meta atbd_badge_open">Available</span>
                                                                <!-- atbd_badge_close -->
                                                            </div>
                                                            <div class="row">
                                                                <div class="col-6">
                                                                    <div class="atbd_listing_data_list">
                                                                        <ul>
                                                                            <li>
                                                                                <p><span class="las la-arrow-right"></span>${car.getMake()}</p>
                                                                            </li>
                                                                            <li>
                                                                                <p><span class="las la-arrow-right"></span>${car.getColor()}</p>
                                                                            </li>
                                                                            <li>
                                                                                <p><span class="las la-arrow-right"></span>${car.getOdometer()}</p>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                                <div class="col-6">
                                                                    <div class="atbd_listing_data_list">
                                                                        <ul>
                                                                            <li>
                                                                                <p><span class="las la-arrow-right"></span>${car.getEngine()}</p>
                                                                            </li>
                                                                            <li>
                                                                                <p><span class="las la-arrow-right"></span>${car.getFuel()}</p>
                                                                            </li>
                                                                            <li>
                                                                                <p><span class="las la-arrow-right"></span>${car.getTransmission()}</p>
                                                                            </li>
                                                                        </ul>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- end .atbd_content_upper -->
                                                        <div class="atbd_listing_bottom_content">
                                                            <div class="atbd_content_left">
                                                                <div class="atbd_listing_category">
                                                                    <a href=""><span class="las la-car"></span>Moylish Motors</a>
                                                                </div>
                                                            </div>
                                                            <ul class="atbd_content_right">
                                                                <li class="atbd_save">
                                                                    <form action="addToFavourites" method="POST">
                                                                        <span class="las la-thumbs-up" onclick="submitFavouriteForm(${car.getListing()},1)"></span>
                                                                    </form>
                                                                </li>
                                                                <li class="atbd_save">
                                                                    <form action="addToFavourites" method="POST">
                                                                        <span class="las la-thumbs-down" onclick="submitFavouriteForm(${car.getListing()},0)"></span>
                                                                    </form>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </article>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <!-- ends: .col-lg-8 -->
                        </div>
                    </div>
                    <!-- ends: .listing-items -->
                </div>
            </div>
        </section>
        <!-- ends: .all-listing-wrapper -->
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
        <script src="theme_assets/js/index.js"></script>
        <script src="theme_assets/js/addToFavourite.js"></script>

        <!-- endinject-->

    </body>

</html>