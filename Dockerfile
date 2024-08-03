FROM eclipse-temurin:21 AS build
COPY . /app
WORKDIR /app
RUN .gradlew bootJar
RUN mv -f build/libs/*.jar app.jar

FROM eclipse-temurin:21
ARG PORT
ENV PORT=${PORT}
COPY --from=build /app/app.jar .
RUN useradd runtime
USER runtime
ENTRYPOINT [ java, -Dserver.port=${PORT}, -jar, app.jar ]