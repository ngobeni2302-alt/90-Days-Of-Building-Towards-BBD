Here is the complete **`README.md`** file for your Day 16 project:

```markdown
# Day 16 / 90 — Spring Boot REST API
### Making database speak on the internet

On Day 15, we built a manual JDBC data access layer with custom SQL. On Day 16, Spring Boot handles the heavy lifting, turning our database and business logic into a production-ready REST API.

## Core Concepts & Annotations
- **`@Entity`**: Marks the `Employee` class as a JPA database entity, mapping it automatically to an SQL table.
- **`JpaRepository`**: Eliminates manual SQL. Spring automatically provides `save()`, `findAll()`, `findById()`, and `deleteById()` out of the box.
- **`@RestController` & `@RequestMapping`**: Exposes Java methods as web endpoints, automatically handling JSON serialization and HTTP requests.
- **Dependency Injection (`@Autowired`)**: Injects the repository layer cleanly into the controller without manual object instantiation.

## Endpoints
- `GET /employees` -> Returns all employees as JSON
- `GET /employees/{id}` -> Returns a single employee by ID
- `POST /employees` -> Creates a new employee from a JSON request body
- `DELETE /employees/{id}` -> Deletes an employee by ID
- `GET /employees/payroll` -> Returns the total sum of all salaries

## How to Run
```bash
mvn spring-boot:run

```

## How to Test

Open a separate terminal and test the endpoints via `curl`:

```bash
# Create employee
curl -X POST http://localhost:8080/employees -H "Content-Type: application/json" -d '{"name":"Thabo","role":"Developer","salary":21500}'

# Get all employees
curl http://localhost:8080/employees

# Get total payroll
curl http://localhost:8080/employees/payroll

```

Or view the interactive H2 Database console at:
`http://localhost:8080/h2-console` *(JDBC URL: `jdbc:h2:mem:companydb`)*

---

*This is the core standard for modern backend development.*

```

```