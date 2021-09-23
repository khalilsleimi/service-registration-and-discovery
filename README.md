# service-registration-and-discovery
A simple guide for writing Netflix Eureka Services and Clients

1. Make the parent project. I still am not sure what's the best approach: A distinct project per artifact vs artifacts as multimodules... Parent project inherits from spring boot starter and uses spring boot starter, spring boot starter test (generic dependencies that are needed in the other projects anyway). As well as define in the dependency management spring cloud dependencies and uses spring boot maven plugin as a build plugin... 
2. Make the Eureka Server that uses the spring cloud starter netflie eureka server. As we as define port, disable registring with eureka (only valid for bigger applications) as well as getting the other eureka's registry. Disabling the logging of eureka (since it wants replication, which we disabled) and as well disabled discovery
2.1 Added the bootstrap.properties file and give a name to our application, as well as added the spring cloud starter bootstrap to parent for both this and future projects (now when project loads, it reads bootstrap first) 
3. Make the Eureka Client that uses the spring cloud starter netflix eureka client and spring boot starter web
3.1 Add the bootstrap.proprties file and give a name to our application (spring cloud starter bootstrap is already added to parent)
=> The application is working awesomely
4. Add request mappings to the client that uses the discovery client to retrieve all services application names connected to eureka, as well as provide an endpoint to get service instance by application name (normally only one now - gives back all its details)