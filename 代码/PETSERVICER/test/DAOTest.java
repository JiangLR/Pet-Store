import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.util.HibernateUtil;
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
    Session session = null;
    Transaction tx = null;

    @Before
    public void init() {
        session = HibernateUtil.openSession();
        tx = session.beginTransaction();
    }

    @Test
    public void insert() {
        MasterEntity master1 = new MasterEntity();
        master1.setMasterName("jianglr");
        master1.setMasterSex("male");
        master1.setMasterTel("13588899791");
        master1.setMasterMail("1024311844@qq.com");
        session.save(master1);
        tx.commit();
    }
}
