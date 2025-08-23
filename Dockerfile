# Sử dụng một image Docker có sẵn Java và Maven
FROM maven:3.9.6-sapmachine-21

# Đặt thư mục làm việc bên trong container
WORKDIR /app

# Sao chép file pom.xml và các file cấu hình khác để tối ưu hóa việc build
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .

# Chạy lệnh build để tải các dependency
RUN mvn dependency:go-offline -B

# Sao chép toàn bộ mã nguồn của ứng dụng vào container
COPY src ./src

# Chạy lệnh build cuối cùng để tạo file JAR
RUN mvn clean install -DskipTests

# Cài đặt lệnh mặc định để chạy ứng dụng
CMD ["java", "-jar", "target/gemini_ai-0.0.1-SNAPSHOT.jar"]