# Imagen base con Java 22
FROM eclipse-temurin:22-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos del proyecto
COPY . .

# Dar permisos de ejecución al wrapper de Gradle
RUN chmod +x ./gradlew

# Construir el proyecto sin ejecutar los tests
RUN ./gradlew build -x test

# Exponer el puerto 8080 (Render lo usará automáticamente)
EXPOSE 8080

# Ejecutar el archivo JAR generado por Gradle
CMD ["java", "-jar", "build/libs/api-backend-0.0.1-SNAPSHOT.jar"]
