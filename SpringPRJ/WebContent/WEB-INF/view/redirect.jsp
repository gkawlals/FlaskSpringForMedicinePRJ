<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="poly.util.CmmUtil"%>
<%
    String msg = CmmUtil.nvl((String)request.getAttribute("msg"));
    String url = CmmUtil.nvl((String)request.getAttribute("url"));
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title></title>
    <!-- jquery -->
    <script src="../resource/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            Swal.fire({
                title: 'Start MDP',
                text: "<%=msg%>",
                icon: 'success',
                showConfirmButton: false,
                timer: 2500
            }).then(val => {
                if (val) {
                    location.href = "<%=url%>";
                }
            });
        })
    </script>
</body>
</html>