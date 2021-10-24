FROM maven:3-openjdk-11
COPY . .
WORKDIR .
RUN mvn package -Dmaven.test.skip
EXPOSE 8081
CMD ["mvn", "spring-boot:run"]

