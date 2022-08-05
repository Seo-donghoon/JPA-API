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
            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();

            for(Member member : result){
                System.out.println("member.name= "+ member.getName());


            }

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

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }


       emf.close();
    }

}
