package hellojpa;

import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
       EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
       EntityManager em = emf.createEntityManager();
       /* 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
          엔티티 매니저는 쓰레드간에 공유 X
          JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
          JPQL은 엔티티 객체를 대상으로 쿼리
          SQL 은 데이터베이스 테이블을 대상으로 쿼리

        */

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member(200L,"hoony200");
            em.persist(member);

            em.flush();




          /*  List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();

            for(Member member : result){
                System.out.println("member.name= "+ member.getName());


            }*/
         /*   Member member1 = new Member(150L,"Hoon");
            Member member2 = new Member(160L,"Hoon2");
            em.persist(member1);
            em.persist(member2);*/
            System.out.println("===================");
            Member fineMember1 = em.find(Member.class, 101L);
            Member fineMember2 = em.find(Member.class, 101L);
            //Member member = em.find(Member.class,150L);
            member.setName("Tory");


            //조회
       /*    Member findMember = em.find(Member.class, 1L);
            System.out.println(findMember.getId());*/

           //수정
            /*Member findMember = em.find(Member.class, 1L);
            findMember.setName("Hello JPA"); //무언가 바뀌면 update 쿼리
*/


            //Insert
       /*     Member member = new Member();
            member.setId(2L);
            member.setName("HelloJPA2");
            em.persist(member);
*/

        //삭제
        //em.remove(fineMember);

 /*           //비영속
        Member member = new Member();
        member.setId(101L);
        member.setName("HElloJpa");
        //영속
            em.persist(member);
           Member findMember =  em.find(Member.class,101l);
            System.out.println(findMember.getId());*/
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }


       emf.close();
    }

}
