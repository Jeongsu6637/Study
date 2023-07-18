<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-07-09
  Time: 오후 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
    <div>
        <form method="post" action="/login">
            <table>
                <h2>로그인</h2>
                <tr>
                    <td><input type="text" name="id">아이디를 입력해주세요</td>
                </tr>
                <tr>
                    <td><input type="password" name="password">패스워드를 입력해주세요.</td>
                </tr>
                <tr>
                    <td><input type="submit" value="로그인"></td>
                </tr>
            </table>
        </form>
        <a href="/signup">회원가입</a>
    </div>
</body>
</html>
