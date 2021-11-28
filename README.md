# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.1/maven-plugin/reference/html/#build-image)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#production-ready)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Cloud Bootstrap](https://spring.io/projects/spring-cloud-commons)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.4.1/reference/htmlsingle/#using-boot-devtools)
* [Prometheus](https://docs.spring.io/spring-boot/docs/2.4.1/reference/html/production-ready-features.html#production-ready-metrics-export-prometheus)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### maven 配置

本地maven settings.xml中增加如下配置:

~~~xml
    <server>
      <id>yuan-snapshots</id>
      <username>admin</username>
      <password>yuan_nexus_admin</password>
    </server>
    <server>
      <id>yuan-release</id>
      <username>admin</username>
      <password>yuan_nexus_admin</password>
    </server>
~~~

### 代码生成

GeneratorServiceEntity.generateAllCode 会生dao层的相关代码

### 自定义banner

[自定义banner传送门](http://patorjk.com/software/taag/#p=display&f=Soft&t=VIP8.WMS)

建议使用Soft字体,将生成的内容复制到banner.txt即可,文件路径 app/src/main/resources/banner.txt
