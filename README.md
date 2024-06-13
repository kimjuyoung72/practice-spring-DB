## QueryDSL
- build.gradle 
  - spring boot 2.x
```groovy
//Querydsl 추가
implementation 'com.querydsl:querydsl-jpa'
annotationProcessor "com.querydsl:querydsl-apt:${dependencyManagement.importedProperties['querydsl.version']}:jpa"
annotationProcessor "jakarta.annotation:jakarta.annotation-api"
annotationProcessor "jakarta.persistence:jakarta.persistence-api"

//Querydsl 추가, 자동 생성된 Q클래스 gradle clean으로 제거
clean {
    delete file('src/main/generated')
}
```
  - spring boot 3.x : 2.x의 jpa -> jakarta

- Gradle
  - Task > build > clean
  - Task > other > compile.java
  - Preference의 Build and Run 설정이 Gradle일 경우 build/generated/sources/annotationProcessor/java/main/hello/itemservice/domain/QItem.java 생성. 이후 QItem 사용 가능.

