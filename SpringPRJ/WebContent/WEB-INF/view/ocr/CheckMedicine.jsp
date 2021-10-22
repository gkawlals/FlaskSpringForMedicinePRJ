<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="poly.dto.OcrDTO"%>

<%

	List<String> OTList = ((List<String>)request.getAttribute("OTList"));

	String fullFileInfo = (String)request.getAttribute("fullFileInfo");
	
	String medicine_no = (String)request.getAttribute("medicine_no");	
	
	
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Start MedicineProject</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="../resource/assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../resource/css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="#page-top">Medicine Name</a>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" data-bs-toggle="modal" data-bs-target="#AddMedicien" >Picture</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#about">Logs</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#contact">Contact</a></li>
                    </ul>
                </div>
            </div>
            <div>
                <form enctype="multipart/form-data" action="/ocr/getReadForImageText" >
                    <input type="file" name="fileUpload" style="display:none" onchange="fileSelect()"/>
                    <input type="submit" name="fileInsert" style="display:none"/>
                </form>
            </div>
        </nav>
        <!-- Portfolio Section-->
        <!--Ajax로 불러와야하고 -->
        <section class="page-section portfolio" id="portfolio">
            <div class="container">
            <br>
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">확인 후 입력해주세요</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Portfolio Grid Items-->
                <div class="row justify-content-center">
          		<form action="/ocr/MD_name_insert.do" method="post">
                    <!-- Portfolio Item 1-->
                    <img class="img-fluid"  src="../resource/ocrImage/upload/<%=fullFileInfo%>" alt="Not Found Image" name="fullFileInfo" />
                    <%for(String MD_name : OTList) {%>
                   
	                    <div>
	                    	약 이름 : <input type="text" name="MD_name" style="width:90%" value="<%=MD_name%>">
	                    </div>
	                    
                    <%} %>
                    <br>
                    <div id="MD_container">
                    <input type="text" id="MD_list" style="display:none" name="MD_list" value="" />
                    </div>
                    <input type="hidden" id="medicine_no" name="medicine_no" value="<%=medicine_no %>"/>
                    <input id="MD_plus" class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" value="저장하기" onclick="PlusString()"/>
                    <input type="submit" name="GoInsert" id="GoInsert" style="display:none"/>
                </form>
                </div>
            </div>
        </section>
        <script type="text/javascript">
        function PlusString(){
        	$(function(){
        		$('#MD_plus').on('click', function(){
	        		var MD_cnt = $("input[name=MD_name]").length;
	        		
	        		var MD_name = new Array(MD_cnt);
	        		
	        		var MD_names = '';
	        		
	        		
	                for(var i=0; i < MD_cnt; i++)
	                {        
	                	
	                	MD_name[i] = $("input[name=MD_name]").eq(i).val();
	                	
	                	MD_names = MD_names + ' ' + MD_name[i]
	                }
	                
	                console.log(MD_names)
	                
	                var String_MD_names = MD_names.toString()
	                
	                $('input[name=MD_list]').attr('value',MD_names);
	                
	                document.all.GoInsert.click();
	               
        		});
        	});

        }
        </script>
        <!-- Footer-->
        <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright &copy; Your Website 2021</small></div>
        </div>
        <!-- object = List / Ajax로 계속 반복해서 불러오기 -->
        <!-- Portfolio Modal 1-->
        <footer class="footer text-center">
            <div class="container">
                <div class="row">
                    <!-- Footer Location-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">To much Information</h4>
                        <p class="lead mb-0">
                            1997 - 01 - 21 / MEN
                            <br />
                            Republic of Korea 
                        </p>
                    </div>
                    <!-- Footer Social Icons-->
                    <!-- Footer About Text-->
                    <div class="col-lg-4">
                        <p class="lead mb-0">
                            혼자 자랑해보는 
                            <a href="https://github.com/gkawlals">My project page</a>
                            .
                        </p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../resource/js/scripts.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
