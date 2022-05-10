FROM tomcat:9.0 as runner
WORKDIR /usr/local/tomcat/webapps/
COPY --from=builder /app/app.war ROOT.war
CMD ["catalina.sh", "run"]

