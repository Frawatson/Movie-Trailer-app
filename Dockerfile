# Stage 1: Build React Frontend
FROM node:alpine AS frontend-build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2: Build Java Backend
FROM maven:alpine AS backend-build
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package

# Stage 3: Final Image
FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=backend-build /app/target/Sapey*.jar ./backend.jar
COPY --from=frontend-build /app/build ./frontend/build

# Expose ports
EXPOSE 8080

# Command to run the backend
CMD ["java", "-jar", "backend.jar"]
