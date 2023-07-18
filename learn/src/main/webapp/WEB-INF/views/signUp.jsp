<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2023-07-09
  Time: 오전 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입 화면</title>
</head>
<body>
    <div>
        <h2>회원가입</h2>
        <form method="post" action="/signup">
            <table>
                <tr>
                    <th>아이디를 입력해주세요.</th>
                    <td><input type="text" name="id"></td>
                </tr>
                <tr>
                    <th>패스워드를 입력해주세요.</th>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <th>이름을 입력해주세요.</th>
                    <td><input type="text" name=name></td>
                </tr>
                <tr>
                    <th>생년월일을 입력해주세요.(0000-00-00)</th>
                    <td><input type="text" name="birth_date"></td>
                </tr>
                <tr>
                    <th>휴대폰을 입력해주세요.( - 는 제외)</th>
                    <td><input type="text" name="phone"></td>
                </tr>
                <tr>
                    <th>주소를 입력해주세요.</th>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <th>이메일을 입력해주세요.</th>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="가입하기"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
