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
import java.util.Set;

/**
 * @Author JiangLR
 * @Time 2018-09-03 14:45
 */
public class PetManager implements IPetManager {
    @SuppressWarnings({ "unchecked" })
    @Override
    public List<PetEntity> loadAll(){
        String hql = "from PetEntity";
        Query<PetEntity> query = HibernateUtil.openSession().createQuery(hql);
        return query.list();
    }

    @Override
    public PetEntity loadPet(int pet_id){
        Session session = HibernateUtil.openSession();
        PetEntity pet = session.get(PetEntity.class, pet_id);
        return pet;
    }

    @Override
    public Set<PetEntity> loadPets(MasterEntity master){
        return master.getPets();
    }

    @Override
    public Set<PetEntity> loadPets(PetRaceEntity petRace){
        return petRace.getPets();
    }

    @Override
    public PetEntity regPet(String name, String nickname, String sex, MasterEntity master, PetRaceEntity petRace) throws BaseException {
        if (name.equals(""))
            throw new BaseException("宠物姓名不能为空");

        PetEntity newPet = new PetEntity();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            newPet.setPetName(name);
            newPet.setPetNickname(nickname);
            newPet.setPetSex(sex);

            master.getPets().add(newPet);
            newPet.setMaster(master);
            petRace.getPets().add(newPet);
            newPet.setPetRace(petRace);

            session.saveOrUpdate(master);
            tx.commit();

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.clear();
        }
        return newPet;
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
