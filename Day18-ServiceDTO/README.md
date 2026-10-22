# Day 18 / 90 - Service Layer + DTO Pattern
## BBD Standard Architecture

### Why Service + DTO?
Day 17 Controller talked directly to Repository - bad for BBD.
Day 18: Controller -> Service -> Repository
- Controller: Only HTTP (GET/POST)
- Service: Business logic + mapping
- Repository: DB only

DTO vs Entity:
- Entity = DB table (has @Entity)
- DTO = What client sees (has validation, extra field salaryGrade)
- Never expose Entity directly - security rule at BBD

Mapper:
EmployeeMapper.toDTO() adds salaryGrade:
 >50000 = A, >30000 = B, else C

Business rule in Service:
If role=Developer and department null -> set to Engineering

Endpoints now under /api/employees:
GET /api/employees?department=Engineering
POST /api/employees {"name":"Thabo","role":"Developer","salary":25000}
- Returns DTO with salaryGrade

Run: mvn spring-boot:run
Test: mvn test
Curl: curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -d '{"name":"Thabo","role":"Developer","salary":55000}' -> should return grade A + Engineering dept
