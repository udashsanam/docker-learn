# Use an official Java runtime as a parent image
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the application JAR file and its dependencies to the container
COPY target/docker-complete-0.0.1-SNAPSHOT.jar /app

# Expose port 8080 for the application
EXPOSE 8080

# Run the application when the container starts
CMD ["java", "-jar", "docker-complete-0.0.1-SNAPSHOT.jar"]
