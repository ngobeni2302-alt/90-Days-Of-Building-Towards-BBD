# Day 17 / 90 — Production-Ready API
## Validation + Global Exception Handling

### What is new from Day 16:

1. @Valid + jakarta.validation.constraints:
   - @NotBlank, @Size, @Min, @Max on Employee fields
   - POST with empty name -> 400 Bad Request with message

2. GlobalExceptionHandler with @RestControllerAdvice:
   - EmployeeNotFoundException -> 404 JSON {error, status}
   - MethodArgumentNotValidException -> 400 JSON {field: message}
   - Generic Exception -> 500

3. New endpoints:
   - PUT /employees/{id} -> update
   - GET /employees?role=Developer -> filter
   - DELETE returns 204 No Content
   - POST returns 201 Created

### Run:
mvn spring-boot:run

### Test with curl:
# Valid
curl -X POST http://localhost:8080/employees -H "Content-Type: application/json" -d '{"name":"Thabo","role":"Developer","salary":21500}'

# Invalid - should return 400 with validation errors
curl -X POST http://localhost:8080/employees -H "Content-Type: application/json" -d '{"name":"","role":"","salary":-100}'

# Not found - 404
curl http://localhost:8080/employees/999

# Filter by role
curl http://localhost:8080/employees?role=Developer

# Update
curl -X PUT http://localhost:8080/employees/1 -H "Content-Type: application/json" -d '{"name":"Thabo Updated","role":"Senior Dev","salary":30000}'

### Tests:
mvn test
