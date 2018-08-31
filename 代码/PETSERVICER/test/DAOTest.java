import cn.edu.zucc.pet_service.model.MasterInfoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author JiangLR
 * @Time 2018-08-31 16:16
 */
public class DAOTest {
    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;

    @Before
    public void init() {
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

    @Test
    public void insert() {
        MasterInfoEntity master1 = new MasterInfoEntity();
        master1.setMasterName("jianglr");
        master1.setMasterSex("male");
        master1.setMasterTel("13588899791");
        master1.setMasterMail("1024311844@qq.com");
        session.save(master1);
        tx.commit();
    }
}
