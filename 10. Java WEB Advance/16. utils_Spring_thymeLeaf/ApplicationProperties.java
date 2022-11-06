#Data Source Properties
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/coffee_shop?useSSL=false&createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=12345678

#JPA Properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=TRUE
spring.jpa.hibernate.ddl-auto=update
spring.jpa.open-in-view=false

# Disable the default loggers
logging.level.org=WARN
logging.level.blog=WARN

#Show SQL executed with parameter bindings
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor=TRACE

#Change server port
#server.port=8000
spring.mvc.hiddenmethod.filter.enabled=true