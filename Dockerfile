# Используем один этап сборки и выполнения
FROM maven:3.6.3-openjdk-17
# Устанавливаем рабочую директорию
WORKDIR /app
# Копируем ВСЕ файлы проекта за один раз
COPY . .
# Собираем проект (+ указываем конкретное имя JAR в CMD)
RUN mvn clean package -DskipTests
# Запускаем приложение (используем точное имя JAR из pom.xml)
CMD ["java", "-jar", "target/friend-0.0.1-SNAPSHOT.jar"]