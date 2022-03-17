# spring-boot-microservices-discovery

This project has 4 spring boot microservice applications
1. student-service
2. course-service
3. progress-report-service
4. discovery-service

The discovery-service is a spring boot eureka server. The other 3 services are clients of the discovery-service. The progress-report-service uses RestTemplate and calls out to student-service and course-service using client-side service discovery and load-balancing.

There is also and example for using WebClient instead of RestTemplate.
