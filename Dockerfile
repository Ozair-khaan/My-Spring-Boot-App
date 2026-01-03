# 1. Use Amazon Corretto (Works great on Mac M1/M2/M3)
FROM amazoncorretto:17-alpine-jdk

# 2. Set the working directory
WORKDIR /app

# 3. Copy the JAR file
COPY target/*.jar app.jar

# 4. Expose the port
EXPOSE 8080

# 5. Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]