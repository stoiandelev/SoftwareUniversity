spring:
  datasource:
    driverClassName: org.h2.Driver
    url: jdbc:h2:mem:cloudinary
    username: root
    password: 12345678

  servlet:
    multipart:
      max-file-size: 10MB
      max-request-size: 10MB

  mvc:
    hiddenmethod:
      filter:
        enabled: true
  h2:
    console:
      enabled: true

  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: create

#Cloudinary Properties
cloudinary:
  api-key: 346427122949418
  api-secret: ${CLOUDINARY_API_SECRET}
  cloud-name: duuldaidw



  # Choose either MySQL 8 or MySQL 5 below
  # For MySQL 8
  # database-platform: org.hibernate.dialect.MySQL8Dialect
  # For MySQL 5
  # database-platform: org.hibernate.dialect.MySQL5InnoDBDialect
  #        sql:
  #          init:
  #            mode: always
  #  defer-datasource-initialization: true
  #    open-in-view: false
  #    properties:
  #      hibernate:
  #        format_sql: true

