package cn.edu.zucc.pet_service.control;

import cn.edu.zucc.pet_service.itf.IPetRaceManager;
import cn.edu.zucc.pet_service.model.PetRaceEntity;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.sound.midi.Soundbank;
import java.util.List;


/**
 * @Author JiangLR
 * @Time 2018-09-02 21:23
 */
public class PetRaceManager implements IPetRaceManager {
    @Override
    public PetRaceEntity regPetRace(String name, String describe) throws BaseException {
        if (name.equals(""))
            throw new BaseException("宠物类别不能为空");
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        PetRaceEntity new_pet_race = new PetRaceEntity();

        try {
            tx = session.beginTransaction();
            String hql = "from PetRaceEntity where petRaceName = :name";
            Query query = session.createQuery(hql);
            query.setParameter("name", name);
            PetRaceEntity pet_race = (PetRaceEntity) query.uniqueResult();
            if (pet_race != null)
                throw new BaseException("此类别已存在");
            new_pet_race.setPetRaceName(name);
            new_pet_race.setPetRaceDescribe(describe);
            session.save(new_pet_race);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.clear();
        }
        return new_pet_race;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public List<PetRaceEntity> loadAll(){
        String hql = "from PetRaceEntity";
        Query<PetRaceEntity> query = HibernateUtil.openSession().createQuery(hql);
        return query.list();
    }

    @Override
    public PetRaceEntity loadPetRace(String name) throws BaseException {
        String hql = "from PetRaceEntity where petRaceName = :name";
        PetRaceEntity petRace = (PetRaceEntity) HibernateUtil.openSession()
                .createQuery(hql).setParameter("name", name).uniqueResult();
        if(petRace == null)
            throw new BaseException("此类不存在");
        return petRace;
    }
}
