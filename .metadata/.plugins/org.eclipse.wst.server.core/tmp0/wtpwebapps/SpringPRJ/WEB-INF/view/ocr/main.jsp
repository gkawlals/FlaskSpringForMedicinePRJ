<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="poly.util.CmmUtil" %>
<%@page import="java.util.List"%>
<%@page import="poly.dto.OcrDTO"%>

<%

	String ss_user_id = CmmUtil.nvl((String)session.getAttribute("ss_user_id"));
	String ss_user_name = CmmUtil.nvl((String)session.getAttribute("ss_user_name"));
	
	List<OcrDTO> ocrList = ((List<OcrDTO>)request.getAttribute("ocrList"));
	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="#page-top">Start MDP</a>
                <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                    	<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" onclick="document.all.fileUpload.click()" >Picture</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="#contact" onclick="location.href='/user/logOut.do'">Logout</a></li>
                    </ul>
                    
                    <a data-bs-toggle="modal" data-bs-target="#ModalDiseane" id="MDiseane" style="display:none" ></a>
                    <a data-bs-toggle="modal" data-bs-target="#resultOcr" id="TextOcr" style="display:none" ></a>
                    
                    <!-- Nonne ?????? ??????????????? Insert??? ?????? ????????? ?????? -->
                    <form enctype="multipart/form-data" method="post" action="../ocr/fileUpload.do" >
                    	<input type="file" name="fileUpload" id="fileUpload" style="display:none" accept="image/*" onchange="fileSelect(this)"/>
                    	<input type="submit" name="fileInsert" id="fileInsert" style="display:none" />
                    	
                    </form>
                    <script type="text/javascript">
                
	                    <!--  FileSelect function start  -->
	                  	function fileSelect(input){
	                  		
	                  		var file_src = input.files[0];
	                  		
	                  		// ??????????????? ?????? div??? text??????
	                  		var file_name = document.getElementById('fileUpload');
	                  		file_name.textContent = file_src.file_name;
	                  		
	                  		newImage = document.createElement("img");
	                  		newImage.setAttribute("class", 'img')
	                  		
	                  		newImage.src = URL.createObjectURL(file_src);
	                  		
	                  		newImage.style.width = "100%";
	                  	    newImage.style.height = "100%";
	                  	    newImage.style.objectFit = "contain";
	                  	    newImage.id = "OcrID";
	                  		
	                  		var container = document.getElementById('Select_image');
	                  	    container.appendChild(newImage);
	                  		
	                  		if(file_name != null){
	                  			
	                  			document.all.MDiseane.click();
	                  			
	                  		}else {
	                  			
	                  			alert("?????? ????????? ?????? ?????????");
	                  			
	                  		}
	                  	
	                  		
	                  	}
	                  	
	                  
	                  	
                    </script>
                </div>
            </div>
        </nav>
        
                
        <div class="portfolio-modal modal fade" id="ModalDiseane" tabindex="-1" aria-labelledby="MDiseane" aria-hidden="true">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header border-0"><button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button></div>
                    <div class="modal-body text-center pb-5">
                        <div class="container" id="Medicine_no">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <!-- Portfolio Modal - Title-->
                                    <h2 class="portfolio-modal-title text-secondary text-uppercase mb-0">?????? ????????????</h2>
                                    <!-- Icon Divider-->
                                    <div class="divider-custom">
                                    	<input type="text" name="medicine_cnt" style="display:none" />
                                    </div>
                                    <!-- Portfolio Modal - Image-->
                                    
                                    <!-- Portfolio Modal - Text-->
                                    <p class="mb-4">????????? ?????????</p>
                                    <div id="Select_image">
                                    </div>
                                    <button class="btn btn-primary" id="MBDiseane" onclick="fileInsert()">
                                        Next
                                    </button>
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script>
        	function fileInsert(){
        		
        		document.all.fileInsert.click();
        		
        	}
        </script>
        <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image-->
                <img class="masthead-avatar mb-5" src="../resource/assets/img/avataaars.svg" alt="..." />
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase mb-0"><%=ss_user_id %> <br>Start MDP</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Masthead Subheading-->
                <p class="masthead-subheading font-weight-light mb-0">???????????? - ????????? ???????????? ?????? - ?????? ?????????????</p>
            </div>
        </header>
        
        <script>
        	function OcrList(){ 
        		var medicine_no = $('#medicine_no').val();
        		
        		if($('#medicine_no').val() == ""){
    				$('#medicine_no').focus();
    			}
    			
    			console.log("medicine_no : " + medicine_no);
    			
    			$.ajax({
    				url : '/ocr/ocrList.do',
    				type : 'post',
    				data : {
    					"medicine_no" : medicine_no
    				},
    				success : function(data) { 
    					console.log("test");
    					
    					var userHTML = ""; // ??????????????? ???????????? ??? userId, userProfile ?????? ????????????
    					userHTML = '<div class="portfolio-item mx-auto" data-bs-toggle="modal" data-bs-target="#portfolioModal1">';
    					userHTML = '<div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">';
    					userHTML = '<div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div></div>';
    					userHTML = '<div name="medicine_no" style="display:none">'+data.getMedicine_no()+'"</div>';
    					userHTML = '<img class="img-fluid" src=" '+ data.getSave_file_path() + '" alt="..." /></div></div>';
    					
    					if(data.length == 0){
    						userHTML = '<div class="portfolio-item mx-auto" data-bs-toggle="modal" data-bs-target="#portfolioModal1">';
    						userHTML = '<div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">';
    						userHTML = '<div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div></div>';
    						userHTML = '<img class="img-fluid" src="../resource/assets/img/portfolio/cabin.png" alt="..." /></div></div> '
    					}else{
    						for(var i = 0;  i < data.lenth(); i++){
    							userHTML = '<div class="portfolio-item mx-auto" data-bs-toggle="modal" data-bs-target="#portfolioModal1">';
    	    					userHTML = '<div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">';
    	    					userHTML = '<div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div></div>';
    	    					userHTML = '<div name="medicine_no" style="display:none">'+data.getMedicine_no()+'"</div>';
    	    					userHTML = '<img class="img-fluid" src=" '+ data.getSave_file_path()+' " alt="..." /></div></div>';
    						}
    						$("#col-md-6 col-lg-4 mb-5").html(userHTML);
    					}
    				}
    			});
        		
        	}
        </script>
        
        
        <!-- Portfolio Section-->
        <section class="page-section portfolio" id="portfolio">
            <div class="container">
                <!-- Portfolio Section Heading-->
                <h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">?????? ?????????</h2>
                <!-- Icon Divider-->
                <div class="divider-custom">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Portfolio Grid Items-->
                <%for(OcrDTO Medicine : ocrList ) {%>	
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4 mb-5">
                    	<div name="medicine_no" style="display:none"> <%=Medicine.getMedicine_no()%> </div>
                        <div class="portfolio-item mx-auto" data-bs-toggle="modal" id="modalList<%=Medicine.getMedicine_no()%>" onclick="MD_list()" data-bs-target="#portfolioModal<%=Medicine.getMedicine_no()%>">
                            <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                                <div class="portfolio-item-caption-content text-center text-white"><i class="fas fa-plus fa-3x"></i></div>
                            </div>
                            <img class="img-fluid" src="../resource/ocrImage/upload/<%=Medicine.getSave_folder_name()%>/<%=Medicine.getSave_file_name() %>" alt="..." />
                        </div>
                    </div>
                </div>
              <%} %>
            </div>                                  
        </section>
        <!-- Portfolio Modal -->
        <%for(OcrDTO Medicine : ocrList ) {%>
        <div class="portfolio-modal modal fade" id="portfolioModal<%=Medicine.getMedicine_no()%>" tabindex="-1" aria-labelledby="portfolioModal<%=Medicine.getMedicine_no()%>" aria-hidden="true">
            <div class="modal-dialog modal-xl"><%=Medicine.getMedicine_no()%>
                <div class="modal-content">
                    <div class="modal-header border-0"><button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button></div>
                    <div class="modal-body text-center pb-5">
                        <div class="container">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <h2 class="portfolio-modal-title text-secondary text-uppercase mb-0">????????? <!-- CRE_DT --></h2>
                                    <!-- Icon Divider-->
                                    <div class="divider-custom">
                                        <div class="divider-custom-line"></div>
                                        <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                                        <div class="divider-custom-line"></div>
                                    </div>
                                    <!-- Portfolio Modal - Image-->
                                    <!-- Image_no ???????????? ????????? ?????? ????????????-->
                                    <img class="img-fluid rounded mb-5" src="../resource/ocrImage/upload/<%=Medicine.getSave_folder_name()%>/<%=Medicine.getSave_file_name() %>" alt="..." />
                                    <!-- Portfolio Modal - Text-->
                                    <script type="text/javascript">
                                    	
                                    	
                                    	$(function() {
                                    		$('#modalList<%=Medicine.getMedicine_no()%>').on('click', function(){
                                    			
	                                    		var Medicine_name = "<%=Medicine.getMedicine_name() %>";
	                                        	var Medicine_list = Medicine_name.replace(",","  ");
	                                        	console.log("Medicine_list : " + Medicine_list);
	                                        	Medicine_list = Medicine_list.split(",");
	                                        	var wordlist = []
	                                        	
	                                    		for ( i = 0; i < Medicine_list.length; i++){
	                                        		
	                                        		wordlist[i] = Medicine_list[i];
	                                        		console.log("wordlist : " + wordlist[i].trim());
	                                        	
	                                        	}
	                                        	 $('p[id=MD_list]').attr('value',wordlist);
	                                    		
                                    		});
                                	    });
                                    	
                                    </script>
                                    <div id="MDList">
                                    	<p class="masthead-subheading font-weight-light mb-0" id="MD_list"><%=Medicine.getMedicine_name() %></p>
                                    </div>
                                    <p class="mb-4"><!-- Medicine_name(??? ?????? ) ???????????? --></p>
                                    <button class="btn btn-primary" href="#!" data-bs-dismiss="modal">
                                        <i class="fas fa-times fa-fw"></i>
                                        Close Window
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%} %>
        <!-- Footer-->
        <footer class="footer text-center">
            <div class="container">
                <div class="row">
                    <!-- Footer Location-->
                    <div class="col-lg-4 mb-5 mb-lg-0">
                        <h4 class="text-uppercase mb-4">Developer Information</h4>
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
                            ?????? ??????????????? 
                            <a href="https://github.com/gkawlals">My Git page</a>
                            .
                        </p>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>Copyright &copy; Your Website 2021</small></div>
        </div>
        
        <!-- Modal Ajax ?????? -->
        <!-- Ajax ?????? ???  -->
        <!-- ???????????? ????????? Modal Page -->
        <div class="portfolio-modal modal fade" id="AddModal" tabindex="-1" aria-labelledby="AddMedicien" aria-hidden="true">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header border-0"><button class="btn-close" type="button" data-bs-dismiss="modal" aria-label="Close"></button></div>
                    <div class="modal-body text-center pb-5">
                        <div class="container" id="Medicine_no">
                            <div class="row justify-content-center">
                                <div class="col-lg-8">
                                    <!-- Portfolio Modal - Title-->
                                    <h2 class="portfolio-modal-title text-secondary text-uppercase mb-0">?????? ????????????</h2>
                                    <!-- Icon Divider-->
                                    <div class="divider-custom">
                                    </div>
                                    <!-- Portfolio Modal - Image-->
                                    
                                    <!-- Portfolio Modal - Text-->
                                    <p class="mb-4">???????????? ????????? ??????????????????<input type="text" name="receive_dt" id="receive_dt" style="width: 50%;"> </p>
                                    <button class="btn btn-primary" onclick="fileSelect()">
                                        Next
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Bootstrap core JS-->
        <script src="../resource/js/jquery-3.4.1.min.js"></script>
        <script src="../resource/js/jquery-3.2.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../resource/js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>