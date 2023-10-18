# A Sample Project Upon Biz SDK on Java

```
docker run -d --rm --name java-dev -v "$(pwd)":/app java-dev
docker exec -it java-dev /bin/bash
```


# Commands

## Git
```
git clone --recursive git@github.com:stcheng/meta-business-sdk-java-sample.git
git submodule update --recursive
```

## Maven
```
mvn compile
mvn exec:java
```
