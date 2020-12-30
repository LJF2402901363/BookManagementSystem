<%--
  Created by IntelliJ IDEA.
  User: 陌意随影
  Date: 2020/9/3 0003
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="utf-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理系统首页</title>
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/plugins/fontawesome-free/css/all.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/plugins/datatables-buttons/css/buttons.bootstrap4.css" />
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/dist/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="${pageContext.request.contextPath}/dist/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- DataTables -->
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables-buttons/js/buttons.print.js"></script>
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables-buttons/js/buttons.flash.min.js"></script>
    <script src="${pageContext.request.contextPath}/dist/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>

</head>
<body  class="hold-transition sidebar-mini">
<div class="wrapper">
    <%--引入导航栏--%>
    <jsp:include page="/WEB-INF/pages/navBar.jsp"></jsp:include>
    <%--引入侧边栏--%>
    <jsp:include page="/WEB-INF/pages/admin_sidebar.jsp"></jsp:include>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <jsp:include page="/WEB-INF/pages/admin_books_body.jsp"></jsp:include>
    </div>
    <!-- /.content-wrapper -->
    <%--引入底部脚本--%>
    <jsp:include page="/WEB-INF/pages/footer.jsp"></jsp:include>
</div>


</body>
</html>
