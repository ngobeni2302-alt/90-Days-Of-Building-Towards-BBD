# Day 22 / 90 - Full Stack BBD Employee System
## Final Project Phase Started

### Stack:
Backend: Spring Boot + JPA + H2 + Validation
Frontend: Single index.html with vanilla JS (no React needed for BBD interview)
API: /api/employees CRUD + /api/employees/stats + /api/employees/payroll

### Run:
mvn spring-boot:run
Open: http://localhost:8080/
API: http://localhost:8080/api/employees

Frontend talks to backend via fetch()
- POST to create
- DELETE to remove
- GET stats for dashboard

### Docker:
docker build -t day22-bbd .
docker run -p 8080:8080 day22-bbd
Open localhost:8080

### Why this is BBD:
- Shows you can build end-to-end
- Stats endpoint: count, payroll, avg, departments
- @CrossOrigin for frontend
- Single jar serves both API and static frontend

### Next:
Day 23: Add JWT to this full stack
Day 24: Deploy to Render/Railway
Day 25-90: DSA + Interview prep

LinkedIn:
Day 22: From rejection to full-stack. My API now has a face. Backend + Frontend in one jar. Still cooking towards BBD.
