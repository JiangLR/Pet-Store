package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IPetRaceManager;
import cn.edu.zucc.pet_service.model.PetRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


/**
 * @Author JiangLR
 * @Time 2018-09-02 21:23
 */
public class PetRaceManager implements IPetRaceManager {
    @Override
    public PetRaceEntity reg_pet_race(String name, String describe) throws BaseException {
        if (name.equals(""))
            throw new BaseException("宠物类别不能为空");
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        PetRaceEntity pet_race = new PetRaceEntity();

        try {
            tx = session.beginTransaction();
            String hql = "from PetRaceEntity where petRaceName = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            pet_race = (PetRaceEntity) query.uniqueResult();
            if (pet_race != null)
                throw new BaseException("此类别已存在");
            pet_race.setPetRaceName(name);
            pet_race.setPetRaceDescribe(describe);
            session.save(pet_race);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.clear();
        }
        return pet_race;
    }
}
