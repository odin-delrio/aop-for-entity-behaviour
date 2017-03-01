## Playing with Spring AOP


###Goal
Inject repository to the entity using AOP.

###Why?
Trying to follow DDD, I want to test a way to avoid anemic models, leading in self-explanatory use cases.

###Found problems
- First steps with Spring AOP are easy...
  
  but, now that I understand how AOP is working with Spring I think that I can't use Spring AOP for intercept method calls on **non beans** classes.

  Spring AOP works creating Proxys for classes that are registered in the Dependency Injection Container.

- First attempt to use the LTW is not working...

###Run (WIP)
```bash
# According to doc this should work
./gradlew clean build && java -javaagent:libs/spring-instrument-4.3.6.RELEASE.jar -jar build/libs/ddd-aop-entity-behaviour-1.0-SNAPSHOT.jar

# Searching for more info I went to something like: (https://github.com/jwilsoncredera/spring-aop-blog)
./gradlew clean build && java -javaagent:libs/spring-instrument-4.3.6.RELEASE.jar -javaagent:libs/aspectjweaver-1.8.10.jar -jar build/libs/ddd-aop-entity-behaviour-1.0-SNAPSHOT.jar
```

###Test
```bash
# manually with curl
curl -XPUT --header "Content-Type: application/json" localhost:8080/users/1/followers -d '{"follower_id": 2}' -v
```

### Current status
After making the example curl call a NPE is thrown, when AOP with LTW is working should be fixed due to the repository injection in the entity.

- [Aspect declaration](/src/main/java/org/odindelrio/dddaopentitybehaviour/infrastructure/spring/configuration/FollowerAspect.java)
- [Entity without repository](/src/main/java/org/odindelrio/dddaopentitybehaviour/domain/Follower.java)