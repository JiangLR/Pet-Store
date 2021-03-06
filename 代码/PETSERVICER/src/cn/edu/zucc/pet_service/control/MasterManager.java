package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IMasterManager;
import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


/**
 * @Author JiangLR
 * @Time 2018-09-02 19:49
 */
public class MasterManager implements IMasterManager {
    @Override
    public MasterEntity regMaster(String name, String sex, String tel, String mail) throws BaseException {
        if (name.equals(""))
            throw new BaseException("姓名不能为空");
        if (tel.equals(""))
            throw new BaseException("联系方式不能为空");
        if (mail == null)
            mail = "";

        MasterEntity newmaster = new MasterEntity();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            newmaster.setMasterName(name);
            newmaster.setMasterSex(sex);
            newmaster.setMasterTel(tel);
            newmaster.setMasterMail(mail);

            session.save(newmaster);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.clear();
        }
        return newmaster;
    }

    @Override
    public MasterEntity loadMaster(int master_id) {
        Session session = HibernateUtil.openSession();
        MasterEntity master = session.get(MasterEntity.class, 1);
        return master;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public List<MasterEntity> loadAll() throws BaseException {
        String hql = "from MasterEntity";
        Query<MasterEntity> query = HibernateUtil.openSession().createQuery(hql);
        return query.list();
    }
}