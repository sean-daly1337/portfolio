<%@page import="Model.User"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        <%
            String getImageUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + "/Moylish_Motors3/getImage?imagePathID=";
        %>
        <section class="listing-details-wrapper bgimage">
            <div class="bg_image_holder"><img src="img/details-img.jpg" alt=""></div>
                <% if (userObj == null) { %>
                <jsp:include page="../shared/navbar.jsp" flush="true"/>
                <% } else { %>
                <jsp:include page = "../shared/navbarLoggedIn.jsp" flush = "true" />
                <%}
                %>
            <!-- ends: .mainmenu-wrapper -->
            <div class="listing-info content_above">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-7">
                            <ul class="list-unstyled listing-info--meta">
                                <li>
                                    <div class="atbd_listing_meta">
                                        <span class="atbd_meta atbd_listing_price">$ ${carDetails.getBuyPrice()}</span>
                                        <!-- atbd_badge_close -->
                                    </div>
                                </li>
                                <li>
                                    <div class="atbd_listing_category">
                                        <a href="#"><span class="las la-car"></span>Moylish Motors</a>
                                    </div>
                                </li>
                            </ul>
                            <!-- ends: .listing-info-meta -->
                            <h1>${carDetails.getMake()} - ${carDetails.getModel()} - ${carDetails.getYear()}</h1>
                            <p class="subtitle">${carDetails.getColor()}</p>
                        </div>
                        <div class="col-lg-4 col-md-5 d-flex align-items-end justify-content-start justify-content-md-end">
                            <div class="atbd_listing_action_area">
                                <div class="atbd_action atbd_save">
                                    <div class="action_button">
                                        <form action="addToFavourites" class="addFavForm" method="POST">
                                            <input type="hidden" name="removeOrAdd" value="1">
                                            <input type="hidden" value="${carDetails.getListing()}" name="listing">
                                            <button type="submit" class="btn btn-secondary"><span class="la la-heart-o"></span> Add to Favorite</a></button>
                                        </form>
                                    </div>
                                </div>
                                <!-- Report Abuse-->
                                <div class="atbd_action atbd_report">
                                    <div class="action_button">
                                        <a href="#" data-toggle="modal" data-target="#atbdp-report-abuse-modal"><span class="la la-flag-o"></span> Report</a>
                                    </div>
                                    <!-- Modal (report abuse form) -->
                                </div>
                            </div>
                            <!-- ends: .atbd_listing_action_area -->
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="atbdp-report-abuse-modal" tabindex="-1" role="dialog" aria-hidden="true" aria-labelledby="atbdp-report-abuse-modal-label">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <form action="/" id="atbdp-report-abuse-form" class="form-vertical">
                                <div class="modal-header">
                                    <h3 class="modal-title" id="atbdp-report-abuse-modal-label">Report Problem</h3>
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">Ã</span></button>
                                </div>
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="atbdp-report-abuse-message" class="not_empty">Your Complaint<span class="atbdp-star">*</span></label>
                                        <textarea class="form-control" id="atbdp-report-abuse-message" rows="4" placeholder="Message..." required=""></textarea>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger btn-sm" data-dismiss="modal">Close</button>
                                    <button type="submit" class="btn btn-secondary btn-sm">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="modal_purchase_car" tabindex="-1" role="dialog" aria-labelledby="claim_listing_label" aria-hidden="true">
                    <div class="modal-dialog modal-lg modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form action="/">
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <input type="text" placeholder="Your Name" class="form-control" required>
                                            </div>
                                            <div class="col-md-6">
                                                <input type="email" class="form-control" placeholder="Email Address" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <input type="text" class="form-control" placeholder="Phone Number" required>
                                            </div>
                                            <div class="col-md-6">
                                                <input type="url" class="form-control" placeholder="Listing URL" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <textarea class="form-control" rows="6" placeholder="Provie Listing Information" required></textarea>
                                                <button type="submit" class="btn btn-secondary">Confirm Purchase</button>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ends: .listing-info -->
        </section>
        <!-- ends: .card-details-wrapper -->
        <section class="directory_listiing_detail_area single_area section-bg section-padding-strict">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="atbd_content_module atbd_listing_details">
                            <div class="atbd_content_module__tittle_area">
                                <div class="atbd_area_title">
                                    <h4><span class="la la-file-text-o"></span>Vehicle Details</h4>
                                </div>
                            </div>
                            <div class="atbdb_content_module_contents">
                                <p>
                                    ${carDetails.getDescription()}
                                </p>
                            </div>
                        </div>
                        <!-- ends: .atbd_content_module -->
                        <div class="atbd_content_module atbd_listing_gallery">
                            <div class="atbd_content_module__tittle_area">
                                <div class="atbd_area_title">
                                    <h4><span class="la la-image"></span>Images</h4>
                                </div>
                            </div>
                            <div class="atbdb_content_module_contents">
                                <div class="row">

                                    <c:forEach items="${carImages}" var="image">
                                        <div class="col-lg-12 col-md-12 my-3">
                                            <img width="100%" height="100%" src="<%= getImageUrl%>${image.getID()}">
                                        </div>
                                    </c:forEach>

                                    <!-- ends: .gallery-thumbs -->
                                </div>
                                <!-- ends: .gallery-wrapper -->
                            </div>
                        </div>
                        <!-- ends: .atbd_content_module -->
                        <div class="atbd_content_module atbd_listing_features">
                            <div class="atbd_content_module__tittle_area">
                                <div class="atbd_area_title">
                                    <h4><span class="la la-list-alt"></span>Details</h4>
                                </div>
                            </div>
                            <div class="atbdb_content_module_contents">
                                <div class="row">
                                    <div class="col-lg-6">
                                        <ul class="atbd_custom_fields features-table">
                                            <!--  get data from custom field-->
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Listing: </p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getListing()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Make:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getMake()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Year:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getYear()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Model:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getModel()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Color:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getColor()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>IsoFix:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getIsofix()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Body:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getBody()}</p>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="col-lg-6">
                                        <ul class="atbd_custom_fields features-table">
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>List Price:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>$ ${carDetails.getListPrice()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Odometer:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getOdometer()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>0-60kph:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getKPH()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Engine:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getEngine()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Fuel:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getFuel()}</p>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="atbd_custom_field_title">
                                                    <p>Transmission:</p>
                                                </div>
                                                <div class="atbd_custom_field_content">
                                                    <p>${carDetails.getTransmission()}</p>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 mt-5 mt-lg-0">
                        <div class="widget atbd_widget widget-card">
                            <div class="atbd_widget_title">
                                <h4><span class="la la-user"></span>Salesman Info</h4>
                            </div>
                            <!-- ends: .atbd_widget_title -->
                            <div class="widget-body atbd_author_info_widget">
                                <div class="atbd_avatar_wrapper">
                                    <div class="atbd_review_avatar">
                                        <img src="img/salesman/${salesMan.getUsername()}.jpg" alt="Avatar Image">
                                    </div>
                                    <div class="atbd_name_time">
                                        <h4>${salesMan.getUsername()}<span class="verified" data-toggle="tooltip" data-placement="top" title="Verified"></span></h4>
                                    </div>
                                </div>
                                <!-- ends: .atbd_avatar_wrapper -->
                                <div class="atbd_widget_contact_info">
                                    <ul>
                                        <li>
                                            <span class="la la-user"></span>
                                            <span class="atbd_info">${salesMan.getName()}</span>
                                        </li>
                                        <li>
                                            <span class="la la-phone"></span>
                                            <span class="atbd_info">${salesMan.getPhone()}</span>
                                        </li>
                                        <li>
                                            <span class="la la-envelope"></span>
                                            <span class="atbd_info">${salesMan.getAddress()}</span>
                                        </li>
                                    </ul>
                                </div>
                                <a href="mailto: ${salesMan.getEmail()}" class="btn btn-outline-primary btn-block">Contact Salesman</a>
                            </div>
                            <!-- ends: .widget-body -->
                        </div>
                        <div class="widget atbd_widget widget-card">
                            <div class="atbd_widget_title">
                                <h4><span class="la la-clock-o"></span> Business Hours</h4>
                                <span class="badge badge-success">Open Now</span>
                            </div>
                            <!-- ends: .atbd_widget_title -->
                            <div class="directory_open_hours">
                                <ul>
                                    <li class="atbd_open">
                                        <span class="day">Monday</span>
                                        <div class="atbd_open_close_time">
                                            <span class="time">10:00 am</span> - <span class="time">06:00 pm</span>
                                        </div>
                                    </li>
                                    <li class="atbd_open">
                                        <span class="day">Tuesday</span>
                                        <div class="atbd_open_close_time">
                                            <span class="time">10:00 am</span> - <span class="time">06:30 pm</span>
                                        </div>
                                    </li>
                                    <li class="atbd_open">
                                        <span class="day">Wednesday</span>
                                        <div class="atbd_open_close_time">
                                            <span class="time">09:00 am</span> - <span class="time">05:00 pm</span>
                                        </div>
                                    </li>
                                    <li class="atbd_open">
                                        <span class="day">Thursday</span>
                                        <div class="atbd_open_close_time">
                                            <span class="time">10:00 am</span> - <span class="time">07:00 pm</span>
                                        </div>
                                    </li>
                                    <li class="atbd_open">
                                        <span class="day">Friday</span>
                                        <div class="atbd_open_close_time">
                                            <span class="time">11:00 am</span> - <span class="time">06:00 pm</span>
                                        </div>
                                    </li>
                                    <li class="atbd_closed">
                                        <span class="day">Saturday</span>
                                        <span>Closed</span>
                                    </li>
                                    <li class="atbd_closed">
                                        <span class="day">Sunday</span>
                                        <span>Closed</span>
                                    </li>
                                </ul>
                            </div>
                        </div>

                        <div class="widget atbd_widget widget-card">
                            <div class="atbd_widget_title">
                                <h4><span class="la la-tags"></span> Companies</h4>
                            </div>
                            <div class="widget-body atbdp-widget-tags">
                                <ul class="list-unstyled">
                                    <li><a href="#">Ford</a></li>
                                    <li><a href="#">Nissan</a></li>
                                    <li><a href="#">Toyota</a></li>
                                    <li><a href="#">Honda</a></li>
                                    <li><a href="#">Mazda</a></li>
                                    <li><a href="#">Jaguar</a></li>
                                    <li><a href="#">Kia</a></li>
                                    <li><a href="#">Mercedes-Benz</a></li>
                                    <li><a href="#">Land Rover</a></li>
                                </ul>
                            </div>
                            <!-- ends: .widget-body -->
                        </div>

                    </div>
                </div>
            </div>
        </section>


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
        <script src="theme_assets/js/addToFavourite.js"></script>
        <!-- endinject-->
    </body>

</html>