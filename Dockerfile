# Usa a imagem oficial do OpenJDK 17 como base
FROM eclipse-temurin:21-jdk


# Diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo jar gerado para dentro do container
COPY target/*.jar app.jar

# Expõe a porta que a aplicação usa (padrão Spring Boot: 8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
