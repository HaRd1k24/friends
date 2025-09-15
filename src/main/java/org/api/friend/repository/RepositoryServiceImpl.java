package main.java.org.api.friend.repository;


import ch.qos.logback.core.testUtil.RandomUtil;
import lombok.val;
import main.java.org.api.friend.repository.RepositoryService;
import org.api.friend.config.HibernateUtil;
import org.api.friendmodel.Friend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryServiceImpl implements RepositoryService {
    private final HibernateUtil hibernateUtil;

    public RepositoryServiceImpl(HibernateUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    private static final Logger log = LoggerFactory.getLogger(RepositoryServiceImpl.class);


    @Override
    public void add(Friend friend) {
        val sessionFactory = hibernateUtil.buildSessionFactory();
        try (val session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.persist(Friend.builder()
                    .id(RandomUtil.getPositiveInt())
                    .name(friend.getName())
                    .age(friend.getAge())
                    .priority(friend.getPriority())
                    .hobby(friend.getHobby())
                    .build());
            session.getTransaction().commit();
            log.info("Сохранили юзера: {}", friend);
        } catch (Exception ignored) {
        }
    }

    @Override
    public Friend findByName(String id) {
        val sessionFactory = hibernateUtil.buildSessionFactory();
        val session = sessionFactory.openSession();
        session.beginTransaction();
        val friend = session.get(Friend.class, id);
        System.out.println(friend);
        return friend;
    }
}
