## Playing with Spring AOP


###Goal
Inject repository to the entity using AOP.

###Why?
Trying to follow DDD, I want to test a way to avoid anemic models, leading in self-explanatory use cases.

![Follow use case code](/docs/follow-use-case.png)

###Found problems
- First steps with Spring AOP are easy...
  
  but, now that I understand how AOP is working with Spring I think that I can't use Spring AOP for intercept method calls on **non beans** classes.

  Spring AOP works creating Proxys for classes that are registered in the Dependency Injection Container.

- Dealing with java agents could be problematic to lauch tests, launch from IDE...

- First attempt to use the LTW was not working... Examples and documentation found was not very good.

###Run
```bash
# Finally both agents are needed, found example in (https://github.com/jwilsoncredera/spring-aop-blog)
./gradlew clean build && java -javaagent:libs/aspectjweaver-1.8.10.jar -javaagent:libs/spring-instrument-4.3.6.RELEASE.jar -jar build/libs/ddd-aop-entity-behaviour-1.0-SNAPSHOT.jar
```

###Test
```bash
# manually with curl
curl -XPUT --header "Content-Type: application/json" localhost:8080/users/1/followers/2 -v
```

### Good feelings
IntelliJ has a good support for aspects, and the String syntax in the annotation is highlighted, navigable...

![Aspect class](/docs/aspect-class.png)

Spring AOP is really fast, but when the aspectj agent is working bootstrap is 3 times slower...

### Current status
It's working!

- [Use case](/src/main/java/org/odindelrio/dddaopentitybehaviour/application/followusecase/FollowUseCase.java)
- [Aspect declaration](/src/main/java/org/odindelrio/dddaopentitybehaviour/infrastructure/spring/configuration/FollowerAspect.java)
- [Entity without repository](/src/main/java/org/odindelrio/dddaopentitybehaviour/domain/Follower.java)