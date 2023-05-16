<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房屋租赁系统</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css">
</head>
<body>
<div class="wrapper">

	<div class="container">
		<h1>房屋租赁系统</h1>
		<form class="form" id="regform" action="registercheck.action" method="post">
			<div><input type="text" name="username" id="username" placeholder="用户名" ></div>
			<div><input type="password" name="password" id="password" placeholder="密码" ></div>
			<div><input type="password" name="repassword" id="repassword" placeholder="确认密码" ></div>
			<div>
		 
		</div>
        
			<button type="submit" id="login-button">租客注册</button>
			<br><br>
			
			<a href="login.jsp">登录</a>
		</form>
 	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	
</div>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>
<script type="text/javascript"
    src="<%=request.getContextPath()%>/js/localization/messages_zh.js"></script>
<script type="text/javascript">



	 $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#regform").validate({
        	/*success:function(){
             //label.text('').addClass('valid');
            $('#login-button').click(function(event){
			event.preventDefault();
			$('form').fadeOut(500);
			$('.wrapper').addClass('form-success');

		});

        },*/
            rules : {
                username : {
                    required : true,
                },
               
                password : {
                    required : true,
                  
                },
                repassword : {
                    required : true,
                  
                },
                
            },
            messages : {
                username : {
                    required : "请输入用户名",
                },

                password : {
                    required : "请输入密码",
                    
                },
                repassword : {
                    required : "请输入确认密码",
                    
                },
                
            }
        });
    })

var error="${error}";
if(error=="error"){

alert("帐户名或密码错误");
}



</script>
</body>
</html>