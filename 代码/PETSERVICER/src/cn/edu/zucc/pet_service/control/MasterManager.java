package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IMasterManager;
import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.model.PetEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import com.mysql.cj.util.EscapeTokenizer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 * @Author JiangLR
 * @Time 2018-09-02 19:49
 */
public class MasterManager implements IMasterManager {
    @Override
    public MasterEntity reg_master(String name, String sex, String tel, String mail) throws BaseException {
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
            e.printStackTrace();
        } finally {
            session.clear();
        }
        return newmaster;
    }

    @Override
    public PetEntity reg_pet(String name, String nickname, String sex, MasterEntity master) throws BaseException {
        if (name.equals(""))
            throw new BaseException("姓名不能为空");

        PetEntity newpet = new PetEntity();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            newpet.setPetName(name);
            newpet.setPetNickname(nickname);
            newpet.setPetSex(sex);

            master.getPets().add(newpet);
            newpet.setMaster(master);

            session.update(master);
            tx.commit();

        } catch (Exception e) {
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.clear();
        }
        return newpet;
    }

    @Override
    public MasterEntity query_master(int master_id) {
        Session session = HibernateUtil.openSession();
        Transaction tx =  null;
        MasterEntity master = new MasterEntity();
        try {
            tx = session.beginTransaction();
            String hql = "from MasterEntity where masterId = :master_id";
            Query query = session.createQuery(hql);
            query.setParameter("master_id", master_id);
            master = (MasterEntity) query.uniqueResult();
            if (master == null) {
                throw new BaseException("此用户不存在");
            }

            tx.commit();
        }catch (Exception e){
            if(tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.clear();
        }
        return master;
    }
}