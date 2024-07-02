# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/*.jar invoice-service.jar

# Expose the port the application runs on
EXPOSE 8083

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "invoice-service.jar"]
