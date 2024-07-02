# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/*.jar customer-service.jar

# Expose the port the application runs on
EXPOSE 8082

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "customer-service.jar"]
