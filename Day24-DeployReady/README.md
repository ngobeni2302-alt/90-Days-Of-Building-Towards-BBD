# Day 24 / 90 - DEPLOYED - BBD Employee System Live

## Live URL
Deploy this to Render.com / Railway.app in 5 mins

### Steps to deploy to Render (Free):
1. Push this folder to GitHub
2. Go to render.com -> New -> Web Service -> Connect repo
3. Choose Docker, it reads Dockerfile
4. Add env var: JWT_SECRET = (generate random 64 char base64)
5. Deploy -> Live URL e.g. https://bbd-employee-system.onrender.com

Your BBD portfolio now has live URL for CV

### Local run:
mvn spring-boot:run -> http://localhost:8080/login.html

### Docker:
docker build -t bbd-live .
docker run -p 8080:8080 -e JWT_SECRET=$(openssl rand -base64 64) bbd-live

### Env vars for prod (Render):
- DATABASE_URL = jdbc:postgresql://... (if using Render Postgres)
- DB_DRIVER = org.postgresql.Driver
- JPA_DIALECT = org.hibernate.dialect.PostgreSQLDialect
- DB_USER / DB_PASSWORD from Postgres
- PORT = 8080 (Render sets automatically)
- JWT_SECRET = base64 64 bytes - IMPORTANT: generate with: openssl rand -base64 64

Without DATABASE_URL it defaults to H2 in-memory (data lost on restart - fine for demo, use Postgres for prod)

### Health:
GET /api/employees/health -> {status: UP}

### Final Pitch for BBD Grad Programme 2027:
From Day 1 Calculator to Day 24 Live Deployed Full Stack with JWT
- 24 days consistent commits
- Backend: Spring Boot, JPA, Validation, Service, DTO, Relations, Pagination, Security, JWT
- Frontend: Vanilla JS, login, protected dashboard
- DevOps: Docker, Dockerfile multi-stage, render.yaml, health check
- Story: Rejection -> 90 Days cooking towards BBD

LinkedIn Day 24:
"Day 24: From rejection email to live URL. My BBD Employee System is deployed. 24 days ago I couldn't explain encapsulation. Today my API is live on the internet with JWT auth. Still 66 days left. If you want to work at BBD, you need to ship."

Lucky quote still core: "if you want to work at BBD, you need to know how to cook. You need to bring something to the table."

### Next 66 days:
DSA + LeetCode + System Design + Interview prep + Polish this system

Commit: git add Day24-DeployReady/ && git commit -m "Day 24: Deployed - Dockerfile, render.yaml, env vars, live ready - BBD portfolio live"
