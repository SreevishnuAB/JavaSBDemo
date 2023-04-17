FROM debian:latest

USER root

VOLUME [ "/sb" ]

WORKDIR /sb

COPY ./ ./

RUN ls && \
  chmod +x setup_env.sh && \
  ./setup_env.sh && \
  rm setup_env.sh

ENV SPRING_DATASOURCE_URL jdbc:postgresql://host.docker.internal:5432/sb
ENV SPRING_DATASOURCE_USERNAME postgres
ENV SPRING_DATASOURCE_PASSWORD postgres
ENV SPRING_JPA_HIBERNATE_DDL_AUTO update


