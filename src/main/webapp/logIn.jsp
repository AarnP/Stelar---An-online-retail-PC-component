<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<link rel="stylesheet" href="CSS/styles.css">
<title>Log In</title>
<link rel="icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
<h2>Login</h2>
<form action="LogInServlet" method="post">
  <div class="imgcontainer">
    <img src="user_icon.png" alt="company_logo" class="avatar">
  </div>

  <div class="container">
    <label for="username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit" class="loginbtn">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="regst"> <a href="#">Join our community</a></span>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>


</body>
</html>