FROM adoptopenjdk/openjdk17:alpine-jre
LABEL authors="nkosinxumalo"

ENTRYPOINT ["top", "-b"]