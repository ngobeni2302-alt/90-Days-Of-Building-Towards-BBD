# Day 20 / 90 - Security + JWT - WEEK 3 FINAL BOSS

## What you just built - BBD Production Security

1. JWT Flow:
   Register -> Login -> Get Token -> Use Token in Authorization header

2. Security:
   - BCryptPasswordEncoder (never store plain password)
   - Stateless session (SessionCreationPolicy.STATELESS)
   - JwtFilter checks Authorization: Bearer <token> every request
   - /api/auth/** is public, everything else needs token

3. Endpoints:
   POST /api/auth/register {"username":"thabo","password":"1234"}
   POST /api/auth/login {"username":"thabo","password":"1234"} -> returns {"token":"eyJ..."}
   GET /api/employees Header: Authorization: Bearer eyJ... -> protected
   POST /api/employees Header: Authorization: Bearer eyJ... + body

4. Test with curl:
   # Register
   curl -X POST http://localhost:8080/api/auth/register -H "Content-Type: application/json" -d '{"username":"thabo","password":"1234"}'

   # Login
   curl -X POST http://localhost:8080/api/auth/login -H "Content-Type: application/json" -d '{"username":"thabo","password":"1234"}'
   # Copy token

   # Access protected (without token -> 403)
   curl http://localhost:8080/api/employees

   # With token (replace TOKEN)
   curl http://localhost:8080/api/employees -H "Authorization: Bearer TOKEN"

   # Create employee with token
   curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -H "Authorization: Bearer TOKEN" -d '{"name":"Lucky","role":"Developer","salary":50000}'

### Why this is BBD level?
- No company deploys API without security
- JWT is interview question #1 at BBD
- Shows you understand Authentication vs Authorization

### LinkedIn Hook for today:
"Day 20 - I secured my API. From open endpoints to JWT auth. If you want to work at BBD, you need to bring security to the table. #90DaysOfJava #BBD"

Run: mvn spring-boot:run
