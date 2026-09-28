# Ví dụ 1 — Spring Security login bằng email

- Spring Boot 4.1.1, Spring Security, JPA, SQL Server, MapStruct, Thymeleaf.
- Layout bằng `th:replace`, **không dùng Layout Dialect**.
- Tạo DB bằng `database.sql`, sau đó sửa username/password SQL Server trong `application.properties` hoặc đặt biến môi trường.
- Chạy: `mvn spring-boot:run`
- Mở: http://localhost:8080/login
- Tài khoản mẫu: `admin@hcmute.edu.vn` / `123456`.
