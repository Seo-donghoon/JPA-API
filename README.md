# JPA-API
About JPA, and developing API
👉🏻 JPA : Java Persitence API

자바에서 ORM 기술 표준으로 사용되는 인터페이스 모음

구현된 클래스와 매핑을 해주기 위해 사용되는 프레임워크 

*ORM (Object-Relational Mapping) 어플리케이션의 객체를 RDB 테이블에 자동으로 영속화 해주는 것 

sql 문이 아닌 method 를 통해 db를 조작할 수 있어 개발자는 객체 모델을 이용하여 비즈니스 로직을 구성하는데만 집중 할 수 있음

(ex) Mysql 를 쓰다가 Postgre로 변환이 필요할때, ORM를 사용하면 쿼리를 수정할 필요가 없음

👉🏻 JPA : ex) Hibernate

JPA 는 반복적인 CURD를 처리해 준다.  

매핑된 관계를 이용해서 SQL을 생성하고 실행

가장 큰 이점 : 객체 중심으로 개발할 수 있다. 

**JPA(ORM)**

- **장점**

1) RDB에 종류와 관계없이 사용 가능하다. 추후 DB 변경이나 코드 재활용에 용이하다.

2) 기본적인 CRUD 제공과 페이징 처리 등 상당 부분 구현되어 있어 비지니스 로직에 집중할 수 있다.

3) 테이블 생성, 변경 등 엔티티 관리가 간편하다.

4) 쿼리에 집중할 필요 없어 빠른 개발이 가능하다.   - SQL을 몰라도 된다는 뜻은 아니다. JPA는 SQL을 잘할수록 훨씬 더 잘 사용할 수 있다.    위 말의 뜻은 select * from user 같은 쿼리를 직접 작성할 필요 없이 Java 코드로 간편하게 사용할수 있다는 뜻

- **단점**

1) 어렵다.

: 단방향, 양방향, 임베디드 관계 등 이해해야할 내용이 많으며, 연관관계 이해 없이 잘못 코딩 했을 시 성능상의 문제와 동작이 원하는대로 되지 않는 일이 발생한다.

ex) Board 엔티티에 List의 형태로 Reply 엔티티가 있을 시, 단방향 연관관계인 경우 하나의 reply가 변경되어도 모두 삭제되고 다시 전부 insert되는 경우

하나의 Board 조회 시 reply를 Join이 아닌 여러개의 select문으로 하나하나 읽어오는 문제

**MyBatis(SQL Mapper)**

- **장점**

1) JPA에 비해 쉽다.

: SQL 쿼리를 그대로 사용하기에 복잡한 Join, 튜닝 등을 좀더 수월하게 작성 가능하다.

2) SQL의 세부적인 내용 변경 시 좀 더 간편하다.

3) 동적 쿼리 사용 시 JPA보다 간편하게 구현 가능하다.

- **단점**

1) 데이터 베이스 설정 변경 시 수정할 부분이 너무 많다. (Oracle의 페이징 쿼리를 MySQL에서 사용 불가능!)

2) Mapper작성부터 인터페이스 설계까지 JPA보다 많은 설계와 파일, 로직이 필요하다.

3) 특정 DB에 종속적이다.



