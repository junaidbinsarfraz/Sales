<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <title>Spring Security Example </title>
    </head>
    <body>
    	<h2>Login with Username and Password</h2>
        <form th:action="@{/login}" method="post">
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <br />
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <br />
            <div><input type="submit" value="Sign In"/></div>
	    	<input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
        </form>
    </body>
</html>