# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory in the container
 # WORKDIR /app
ARG JAR_FILE=target/*.jar

# Copy the application JAR file into the container at /app
COPY target/grocery-app.jar app.jar

# Specify the command to run on container startup
CMD ["java", "-jar", "/app.jar"]