# Day 23 / 90 - Full Stack + JWT Auth

## Flow:
1. Open /login.html -> Register thabo/1234
2. Login -> token saved in localStorage -> redirect to /index.html
3. index.html checks token, sends Authorization: Bearer <token> on every fetch
4. Without token -> 403 -> redirect to login

## New:
- login.html with register + login
- index.html now protected: checks localStorage token
- SecurityConfig permits /login.html, / , static files, /api/auth/**
- All fetch() now include Authorization header

## Test:
mvn spring-boot:run
Open http://localhost:8080/login.html
Register, Login, Add employees - all protected

## BBD level:
Real apps have login page, not just curl with token. Now you have both.
