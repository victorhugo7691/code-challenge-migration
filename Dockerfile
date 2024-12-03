# Usando a imagem base do OpenJDK 17 slim
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho dentro do container
WORKDIR /app

# Copiando o JAR da aplicação para o diretório de trabalho
COPY target/*.jar app.jar

# Definindo variável de ambiente para a URL do DummyJSON
ENV URL_DUMMYJSON=https://dummyjson.com

# Expondo a porta 8080 (porta padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]