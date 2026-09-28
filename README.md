# Bài tập Ví dụ 1 & 2 — Spring Security

Hai project độc lập, bám theo file hướng dẫn.

- `example1`: login bằng email; header hiển thị tài khoản; Thymeleaf fragment/layout không Dialect; port 8080; DB `webst4`.
- `example2`: custom login username hoặc email; header hiển thị fullname + avatar + username + email; Thymeleaf Layout Dialect; port 8081; DB `webst9`.

## Chuẩn bị SQL Server
Chạy `database.sql` trong từng project. Sau đó chỉnh `spring.datasource.username/password` nếu máy bạn không dùng `sa/123456`.

## Build
Trong từng thư mục: `mvn clean package` hoặc `mvn spring-boot:run`.

Java đặt ở 21 để dễ chạy trên JDK 21+; nếu giảng viên bắt buộc Java 26, đổi `<java.version>21</java.version>` thành `26`.
