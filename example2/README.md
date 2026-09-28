# Ví dụ 2 — Custom login username hoặc email

- Spring Boot 4.1.1, Spring Security, JPA, SQL Server, MapStruct, Thymeleaf + Layout Dialect.
- `CustomUserDetails` đưa `fullName`, `images`, `email`, `role` ra view/header.
- Tạo DB bằng `database.sql`, sau đó sửa username/password SQL Server trong `application.properties` hoặc đặt biến môi trường.
- Chạy: `mvn spring-boot:run`
- Mở: http://localhost:8081/login
- Tài khoản mẫu: `user01` hoặc `user01@gmail.com` / `123456`.
