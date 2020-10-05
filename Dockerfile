FROM openjdk:11-alpine
COPY ./* /app/
WORKDIR /app/
RUN javac -d ./output ./LexicalTest.java
WORKDIR /app/output
