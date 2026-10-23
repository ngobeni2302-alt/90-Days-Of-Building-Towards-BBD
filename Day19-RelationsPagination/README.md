# Day 19 / 90 - Relationships + Pagination
## OneToMany + Pageable - BBD Production

### New Concepts:

1. @OneToMany / @ManyToOne:
   Department has List<Employee>
   Employee has Department
   @JsonManagedReference / @JsonBackReference prevents infinite loop

2. CascadeType.ALL: When you save Department, employees save too

3. Pagination:
   GET /api/employees?page=0&size=2&sort=salary,desc
   Returns Page object: content, totalPages, totalElements

   PageableDefault size=5

Endpoints:
POST /api/departments {"name":"Engineering"}
GET /api/departments
POST /api/departments/1/employees {"name":"Thabo","role":"Developer","salary":20000}
GET /api/employees?page=0&size=2
GET /api/employees/department/Engineering?page=0&size=10

Run: mvn spring-boot:run
