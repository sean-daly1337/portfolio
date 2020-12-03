<%@page import="Model.User"%>
<%
    User userObj1 = (User) session.getAttribute("loggedInUser");
    String dashboardName = "userDashboard";
    if (userObj1 != null) {
        if (userObj1.getRoleId() == 1) {
            dashboardName = "adminDashboard";
        }
    }
%>

<div class="mainmenu-wrapper">
    <div class="menu-area menu1 menu--light">
        <div class="top-menu-area">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="menu-fullwidth">
                            <div class="logo-wrapper order-lg-0 order-sm-1">
                                <div class="logo logo-top">
                                    <h2 class="white">Moylish &nbsp;</h2>
                                </div>
                            </div>
                            <!-- ends: .logo-wrapper -->
                            <div class="menu-container order-lg-1 order-sm-0">
                                <div class="d_menu">
                                    <nav class="navbar navbar-expand-lg mainmenu__menu">
                                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#direo-navbar-collapse" aria-controls="direo-navbar-collapse" aria-expanded="false" aria-label="Toggle navigation">
                                            <span class="navbar-toggler-icon icon-menu"><i class="la la-reorder"></i></span>
                                        </button>
                                        <div class="collapse navbar-collapse" id="direo-navbar-collapse">
                                            <ul class="navbar-nav">
                                                <li>
                                                    <a href="index.jsp">Home</a>
                                                </li>
                                                <li>
                                                    <a href="allCars">Cars</a>
                                                </li>
                                                <li>
                                                    <a href="about.jsp">About Us</a>
                                                </li>
                                                <li>
                                                    <a href="contact.jsp">Contact Us</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <!-- /.navbar-collapse -->
                                    </nav>
                                </div>
                            </div>
                            <div class="menu-right order-lg-2 order-sm-2">
                                <div class="author-area">
                                    <div class="author__access_area">
                                        <ul class="d-flex list-unstyled align-items-center">
                                            <li>
                                                <div class="author-info">
                                                    <a href="" class="author-avatar"><img src="img/auth2.png" alt="" class="rounded-circle"></a>
                                                    <ul class="list-unstyled">
                                                        <li><a href="<% out.println(dashboardName); %>">My Dashboard</a></li>
                                                        <li><a href="logout">Logout</a></li>
                                                    </ul>
                                                </div>
                                                <!-- ends: .author-info -->
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <!-- end .author-area -->
                                <div class="offcanvas-menu d-none">
                                    <a href="" class="offcanvas-menu__user"><i class="la la-user"></i></a>
                                    <div class="offcanvas-menu__contents">
                                        <a href="" class="offcanvas-menu__close"><i class="la la-times-circle"></i></a>
                                        <div class="author-avatar">
                                            <img src="img/auth2.png" alt="" class="rounded-circle">
                                        </div>
                                        <ul class="list-unstyled">
                                            <li><a href="<% out.println(dashboardName);%>">My Dashboard</a></li>
                                            <li><a href="logout">Logout</a></li>
                                        </ul>
                                        <!-- ends: .search_area -->
                                    </div>
                                    <!-- ends: .author-info -->
                                </div>
                                <!-- ends: .offcanvas-menu -->
                            </div>
                            <!-- ends: .menu-right -->
                        </div>
                    </div>
                </div>
                <!-- end /.row -->
            </div>
            <!-- end /.container -->
        </div>
        <!-- end  -->
    </div>
</div>