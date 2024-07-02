# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/*.jar api-gateway.jar

# Expose the port the application runs on
EXPOSE 8090

# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
