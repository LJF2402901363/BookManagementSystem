<%--
  Created by IntelliJ IDEA.
  User: 陌意随影
  Date: 2020/9/7 0007
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
<!-- Sidebar -->
<div class="sidebar">
    <!-- Sidebar user panel (optional) -->
    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
            <img src="${pageContext.request.contextPath}/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
             <c:if test="${not empty readercard}">
                 <a href="#" class="d-block">${readercard.username}</a>
                 <span style="color: green;">在线</span>
             </c:if>
        </div>
    </div>
    <!-- Sidebar Menu -->
    <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
            <!-- Add icons to the links using the .nav-icon class
                 with font-awesome or any other icon font library -->
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/reader_main.html" class="nav-link">
                    <i class="fa fa-home" aria-hidden="true"></i>
                    <p>
                        首页
                    </p>
                </a>
            </li>
            <li class="nav-item menu-open">
                <a href="#" class="nav-link active">
                    <i class="fa fa-cog" aria-hidden="true"></i>
                    <p>
                        图书
                        <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/reader_books" class="nav-link ">
                            <i class="far fa-circle nav-icon"></i>
                            <p>图书库</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>图书分类</p>
                        </a>
                    </li>

                </ul>
            </li>

            <li class="nav-item menu-open">
                <a href="#" class="nav-link active">
                    <i class="fa fa-cog" aria-hidden="true"></i>
                    <p>
                        个人管理
                        <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item">
                        <a href="#" class="nav-link ">
                            <i class="far fa-circle nav-icon"></i>
                            <p>个人信息</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="#" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>修改信息</p>
                        </a>
                    </li>

                </ul>
            </li>

            <li class="nav-item menu-open">
                <a href="${pageContext.request.contextPath}/toReaderLendBookManagement" class="nav-link active">
                    <i class="fa fa-cog" aria-hidden="true"></i>
                    <p>
                        借阅管理
                        <i class="right fas fa-angle-left"></i>
                    </p>
                </a>
                <ul class="nav nav-treeview">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/toReaderLenAndBackBook" class="nav-link ">
                            <i class="far fa-circle nav-icon"></i>
                            <p>所有借书还书</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/toReaderLenBook" class="nav-link ">
                            <i class="far fa-circle nav-icon"></i>
                            <p>现存借书管理</p>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/toReaderBackBook" class="nav-link">
                            <i class="far fa-circle nav-icon"></i>
                            <p>已还书记录</p>
                        </a>
                    </li>


                </ul>
            </li>
        </ul>
    </nav>
    <!-- /.sidebar-menu -->
</div>
<!-- /.sidebar -->
</aside>


