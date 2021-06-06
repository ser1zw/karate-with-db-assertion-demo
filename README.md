# karate-with-db-assertion-demo

KarateでのAPIテストと同時にAssertJ-DBでのデータのアサーションを行うサンプル

[KarateでのAPIテストと同時にAssertJ-DBでデータの確認もやりたい - ser1zw's blog](https://ser1zw.hatenablog.com/entry/2021/06/06/195358)

## 環境

- [Spring Boot](https://spring.io/projects/spring-boot) 2.5.0
- [Karate (karate-junit5)](https://github.com/intuit/karate) 1.0.1
- [AssertJ-DB](https://github.com/assertj/assertj-db) 2.0.2
- OpenJDK 11.0.11
- [H2 Database](https://h2database.com/html/main.html) 1.4.200

## 起動

H2 Database起動

```cmd
$ java -cp h2/h2-*.jar org.h2.tools.Server -ifNotExists
```

Webアプリ本体起動

```cmd
$ mvn clean package
$ java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## 動作確認

`curl` で動作確認

```cmd
$ curl -X POST localhost:8080 -H "Content-Type: application/json" -d '{ "message": "test" }'
$ curl localhost:8080                                                                                                                       (git)-[master]
[{"ID":1,"MESSAGE":"test"}]
```

## テスト

Karateでのテストシナリオ実行

```cmd
$ mvn test -Dtest=DemoTestRunner
```
