# Day 21 / 90 - Testing + Docker
## BBD Deployment Ready

### 3 Levels of Testing (BBD Interview):

1. UNIT TEST - EmployeeTest.java
   - No Spring, plain JUnit
   - Tests calculateBonus() logic
   - Fastest: mvn test -Dtest=EmployeeTest

2. MOCKITO TEST - EmployeeServiceTest.java
   - @Mock repo, @InjectMocks service
   - Tests business logic without DB
   - verify(repo).save() - checks interaction

3. INTEGRATION TEST - EmployeeControllerTest.java
   - @SpringBootTest + @AutoConfigureMockMvc
   - Real H2 DB + real HTTP calls
   - Tests full flow: POST then GET

Run all: mvn test

### Docker:

Build: docker build -t day21-api .
Run: docker run -p 8080:8080 day21-api
Compose: docker-compose up --build

Then: curl http://localhost:8080/api/employees

### LinkedIn:
Day 21: From code to tested + dockerized API. 3 levels of tests, 1 Dockerfile. If you want to work at BBD, you need to ship it, not just code it.
