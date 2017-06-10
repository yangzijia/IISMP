<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>创新实验室自主学习管理平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery.min.js"></script>	
	<script src="js/bootstrap_3.3.4.js" type="text/javascript"></script>
	<link href="css/bootstrap_3.3.4.css" rel="stylesheet">
 	<link rel="Shortcut icon" href="img/favicon.ico"> 
 	<link href="css/error.css" tppabs="css/error.css" rel="stylesheet">
  </head>
      <script type="text/javascript">
	  function reload(){
	  	 location.reload();
	  }
	  </script>
<body>
 <div class="col-sm-7" >
           <div class="tupian" >
               <img align="right" class="p1" src="img/500-1.png" ></img> 
           </div>
       </div>
       <div class="col-sm-5" >
       <div  class="p2" >
           <h3>               
                                    您可以尝试以下操作：
           </h3>
            <br>
          </div>
          <div  class="p3" >
   <a href="/IISMP">返回重新登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
   <a onclick="reload()" href="javascript:void(0)">重新加载</a>
</div>
       </div>
    
</body>
</html>
