//package com.pjjstock.global;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.JwtParser;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//
//import java.security.Key;
//
//public class JWTDecoderExample {
//
//    public static void main(String[] args) {
//        // JWT 토큰
//        String token = "YOUR_JWT_TOKEN_HERE";
//
//        // JWT 토큰 서명 시 사용한 시크릿 키 (Base64 인코딩)
//        String secretKey = "YOUR_SECRET_KEY_HERE";
//
//        // 시크릿 키를 이용해 JWT 파서 생성
//        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
//        JwtParser parser = Jwts.parserBuilder().setSigningKey(key).build();
//
//        try {
//            // 토큰을 파싱하여 복호화
//            Jws<Claims> jws = parser.parseClaimsJws(token);
//            Claims claims = jws.getBody();
//
//            // 페이로드에 포함된 정보 확인
//            String memberId = claims.getSubject();
//            String username = (String) claims.get("username");
//            // 여기에 추가로 원하는 정보를 추출할 수 있습니다.
//
//            System.out.println("Member ID: " + memberId);
//            System.out.println("Username: " + username);
//        } catch (Exception e) {
//            // 토큰 검증에 실패하거나 잘못된 형식의 토큰인 경우 여기서 처리
//            e.printStackTrace();
//        }
//    }
//}