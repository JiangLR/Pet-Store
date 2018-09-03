package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IPetManager;
import cn.edu.zucc.pet_service.model.MasterEntity;
import cn.edu.zucc.pet_service.model.PetEntity;
import cn.edu.zucc.pet_service.model.PetRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @Author JiangLR
 * @Time 2018-09-03 14:45
 */
public class PetManager implements IPetManager {
    @SuppressWarnings({ "unchecked" })
    @Override
    public List<PetEntity> loadAll() throws BaseException {
        String hql = "from PetEntity";
        Query<PetEntity> query = HibernateUtil.openSession().createQuery(hql);
        return query.list();
    }

    @Override
    public PetEntity loadPet(int pet_id) throws BaseException {
        return null;
    }

    @Override
    public List<PetEntity> loadPets(MasterEntity master) throws BaseException {
        return null;
    }

    @Override
    public List<PetEntity> loadPets(PetRaceEntity pet_race) throws BaseException {
        return null;
    }

    @Override
    public PetEntity regPet(String name, String nickname, String sex, MasterEntity master) throws BaseException {
        if (name.equals(""))
            throw new BaseException("宠物姓名不能为空");

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
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.clear();
        }
        return newpet;
    }

    @Override
    public void deletePet(PetEntity pet, MasterEntity master) throws BaseException {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            master.getPets().remove(pet);
            session.delete(pet);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
            throw e;
        } finally {
            session.clear();
        }
    }
}
