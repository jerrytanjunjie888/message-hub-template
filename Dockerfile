# --- Build stage ---
FROM maven:3.6-jdk-11 AS builder
WORKDIR /app
 #Copy the dependency definition
COPY ./settings.xml /usr/share/maven/conf/settings.xml
COPY ./pom.xml ./pom.xml
# Download dependencies
RUN mvn dependency:go-offline -B
# Copy the source code
COPY ./src ./src
# Build for release
RUN mvn package

# --- Final stage ----
# FROM gcr.io/distroless/java:11
FROM registry-cn.subsidia.org/distroless/java:11
COPY --from=builder /app/target/message-hub-template.jar message-hub-template.jar
CMD ["message-hub-template.jar"]
EXPOSE 3006
LABEL Name=message-hub-template \
	  Version=0.1
