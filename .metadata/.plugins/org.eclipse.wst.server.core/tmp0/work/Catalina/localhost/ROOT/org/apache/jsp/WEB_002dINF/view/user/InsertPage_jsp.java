/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.57
 * Generated at: 2021-10-21 20:43:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class InsertPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<title>Create User</title>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<link rel=\"icon\" type=\"image/png\" href=\"../resource/images/icons/favicon.ico\"/>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../resource/vendor/bootstrap/css/bootstrap.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../resource/fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../resource/vendor/animate/animate.css\">\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../resource/vendor/css-hamburgers/hamburgers.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../resource/vendor/select2/select2.min.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../resource/css/util.css\">\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../resource/css/main.css\">\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t\n");
      out.write("\t<div class=\"limiter\">\n");
      out.write("\t\t<div class=\"container-login100\">\n");
      out.write("\t\t\t<div class=\"wrap-login100\">\n");
      out.write("\t\t\t\t<div class=\"login100-pic js-tilt\" data-tilt>\n");
      out.write("\t\t\t\t\t<img src=\"../resource/images/img-01.png\" alt=\"IMG\"  onclick=\"location.href='/index.do'\">\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t<form class=\"login100-form validate-form\" action=\"../user/InsertStart.do\" method=\"post\">\n");
      out.write("\t\t\t\t\t<span class=\"login100-form-title\">\n");
      out.write("\t\t\t\t\t\tJoin\n");
      out.write("\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t<span class=\"id_ok\">?????? ????????? ??????????????????.</span>\n");
      out.write("\t\t\t\t\t<span class=\"id_already\" >????????? ??? ???????????? ???????????? ?????????.</span>\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"???????????? ??????????????????\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"user_id\" placeholder=\"User id\" >\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"symbol-input100\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-envelope\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"????????? ??????????????????\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"text\" name=\"user_name\" placeholder=\"User name\">\n");
      out.write("\t\t\t\t\t\t<div class=\"check_font\" id=\"id_check\"></div>\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"symbol-input100\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-envelope\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"??????????????? ??????????????????\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"password\" name=\"user_pwd\" placeholder=\"Password\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"symbol-input100\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-lock\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"wrap-input100 validate-input\" data-validate = \"?????? ??????????????? ??????????????????\">\n");
      out.write("\t\t\t\t\t\t<input class=\"input100\" type=\"password\" name=\"check_pwd\" placeholder=\"Check Password\">\n");
      out.write("\t\t\t\t\t\t<span class=\"focus-input100\"></span>\n");
      out.write("\t\t\t\t\t\t<span class=\"symbol-input100\">\n");
      out.write("\t\t\t\t\t\t\t<i class=\"fa fa-lock\" aria-hidden=\"true\"></i>\n");
      out.write("\t\t\t\t\t\t</span>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<br>\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"container-login100-form-btn\">\n");
      out.write("\t\t\t\t\t\t<input type=\"button\" class=\"login100-form-btn\" id=\"signupbtn\" onclick=\"NullCheck()\" value=\"????????????\">\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" style=\"display:none\" name=\"InsertStart\" id=\"InsertStart\"/>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\t\tfunction NullCheck(){\n");
      out.write("\t        \t$(function(){\n");
      out.write("\t        \t\t$('#signupbtn').on('click', function(){\n");
      out.write("\t\t        \t\tvar user_id = $(\"input[name=user_id]\").val();\n");
      out.write("\t\t        \t\tif (user_id == \"\"){\n");
      out.write("\t\t        \t\t\talert(\"???????????? ??????????????????\");\n");
      out.write("\t        \t\t\t}else{\n");
      out.write("\t        \t\t\t\tNameCheck();\n");
      out.write("\t        \t\t\t\tconsole.log(\"user_id\" + user_id);\n");
      out.write("\t        \t\t\t}\n");
      out.write("\t        \t\t});\n");
      out.write("\t        \t});\n");
      out.write("\n");
      out.write("\t        }\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction NameCheck(){\n");
      out.write("\t        \t$(function(){\n");
      out.write("\t\t        \t\tvar user_name = $(\"input[name=user_name]\").val();\n");
      out.write("\t\t        \t\tif (user_name == \"\"){\n");
      out.write("\t\t        \t\t\talert(\"????????? ??????????????????\");\n");
      out.write("\t        \t\t\t}else{\n");
      out.write("\t        \t\t\t\tPWDCheck();\n");
      out.write("\t        \t\t\t\tconsole.log(\"user_name\" + user_name);\n");
      out.write("\t        \t\t\t}\n");
      out.write("\t        \t\t});\n");
      out.write("\t        }\n");
      out.write("\t\t\t\n");
      out.write("\t\tfunction PWDCheck(){\n");
      out.write("\t        \t$(function(){\n");
      out.write("\t\t        \t\tvar user_pwd = $(\"input[name=user_pwd]\").val();\n");
      out.write("\t\t        \t\tvar check_pwd = $(\"input[name=check_pwd]\").val();\n");
      out.write("\t\t        \t\tif (user_pwd == \"\"){\n");
      out.write("\t\t        \t\t\talert(\"??????????????? ??????????????????\");\n");
      out.write("\t        \t\t\t}else if(check_pwd == \"\"){\n");
      out.write("\t        \t\t\t\talert(\"?????? ??????????????? ??????????????????\");\n");
      out.write("\t        \t\t\t}else{\n");
      out.write("\t        \t\t\t\tCheckPWD();\n");
      out.write("\t        \t\t\t\n");
      out.write("\t        \t\t\t}\n");
      out.write("\t        \t\t});\n");
      out.write("\t        }\n");
      out.write("\t\tfunction CheckPWD(){\n");
      out.write("\t        \t$(function(){\n");
      out.write("\t\t        \t\tvar user_pwd = $(\"input[name=user_pwd]\").val();\n");
      out.write("\t\t        \t\tvar check_pwd = $(\"input[name=check_pwd]\").val();\n");
      out.write("\t\t        \t\tif (user_pwd === check_pwd ){\n");
      out.write("\t\t        \t\t\t//alert(\"??????????????? ???????????????.\");\n");
      out.write("\t\t        \t\t\tdocument.all.InsertStart.click();\n");
      out.write("\t\t        \t\t}else{\n");
      out.write("\t        \t\t\t\talert(\"??????????????? ????????????. ?????? ?????????????????? \");\n");
      out.write("\t        \t\t\t\n");
      out.write("\t        \t\t\t\tconsole.log(\"user_pwd\" + user_pwd);\n");
      out.write("\t        \t\t\t\tconsole.log(\"check_pwd\" + check_pwd);\n");
      out.write("\t        \t\t\t}\n");
      out.write("\t\t        \t});\n");
      out.write("\t        \t}\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("<!--===============================================================================================-->\t\n");
      out.write("\t<script src=\"../resource/vendor/jquery/jquery-3.2.1.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"../resource/vendor/bootstrap/js/popper.js\"></script>\n");
      out.write("\t<script src=\"../resource/vendor/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"../resource/vendor/select2/select2.min.js\"></script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"../resource/vendor/tilt/tilt.jquery.min.js\"></script>\n");
      out.write("\t<script >\n");
      out.write("\t\t$('.js-tilt').tilt({\n");
      out.write("\t\t\tscale: 1.1\n");
      out.write("\t\t})\n");
      out.write("\t</script>\n");
      out.write("<!--===============================================================================================-->\n");
      out.write("\t<script src=\"../resource/js/main.js\"></script>\n");
      out.write("\t<script src=\"../resource/js/main.js\"></script>\n");
      out.write("\t<script src=\"../resource/js/jquery-3.4.1.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
