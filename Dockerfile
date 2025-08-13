# Stage 1: Build com Maven + JDK 21
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copia o pom.xml e baixa dependências (cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código fonte
COPY src ./src

# Build do Spring Boot JAR sem rodar testes
RUN mvn clean package -DskipTests

# Stage 2: Imagem final leve com JDK 21
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copia o JAR gerado
COPY --from=build /app/target/*.jar app.jar

# Expondo porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
