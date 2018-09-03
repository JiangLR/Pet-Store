import cn.edu.zucc.pet_service.control.*;
import cn.edu.zucc.pet_service.model.*;
import cn.edu.zucc.pet_service.util.BaseException;
import cn.edu.zucc.pet_service.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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

    @After
    public void release() {
        session.clear();
    }


    @Test
    public void deleteMaster() {
        MasterEntity master1 = (MasterEntity) session.get(MasterEntity.class, 1);
        session.delete(master1);
        tx.commit();
    }

    @Test
    public void testDeletePet() {

        try {
            MasterEntity master = new MasterManager().loadMaster(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testRegGoods() throws IOException {
        GoodsRaceEntity goodsRace = (GoodsRaceEntity) session.createQuery("from GoodsRaceEntity where goodsRaceName = :name")
                .setParameter("name", "沐浴露").uniqueResult();
        BrandsEntity brand = (BrandsEntity) session.createQuery("from BrandsEntity where brandsName = :name")
                .setParameter("name", "雕牌").uniqueResult();

        File file = new File("D:" + File.separator + "Pet-Store" + File.separator + "blob.png");
        InputStream in = new FileInputStream(file);
        Blob barCode = Hibernate.getLobCreator(session).createBlob(in, in.available());

        try {
            new GoodsManager().regGoods("小狗沐浴露", 20.0, 0.0, barCode, 100, goodsRace, brand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteGoodsRace() {
        GoodsRaceManager goodRaceManager = new GoodsRaceManager();
        try {
            List<GoodsRaceEntity> list = goodRaceManager.loadAll();
            for (GoodsRaceEntity goodRace : list) {
                goodRaceManager.deleteGoodsRace(goodRace);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loadGoodsRace() {
        List<GoodsRaceEntity> list = new GoodsRaceManager().loadAll();
        for (GoodsRaceEntity good_race : list) {
            System.out.println(good_race.toString());
        }
    }

    @Test
    public void regPetRace() {
        String name = "dog";
        String describe = "very cute";
        try {
            new PetRaceManager().regPetRace(name, describe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void regMaster() {
        String name = "Jbooo";
        String sex = "male";
        String tel = "13588899791";
        String mail = "";

        try {
            new MasterManager().regMaster(name, sex, tel, mail);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void regPet() {
        String name = "hashiqi";
        String nickName = " black";
        String sex = "female";
        try {
            MasterEntity master = new MasterManager().loadMaster(1);
            PetRaceEntity petRace = new PetRaceManager().loadPetRace("dog");
            new PetManager().regPet(name, nickName, sex, master, petRace);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadPet() {
        MasterEntity master = new MasterManager().loadMaster(1);
        Set<PetEntity> pets = new PetManager().loadPets(master);
        for (PetEntity pet : pets) {
            System.out.println(pet);
        }
    }

    @Test
    public void loadGoods() {
        List<GoodsEntity> Goods = new GoodsManager().loadAll();
        for (GoodsEntity goods : Goods) {
            System.out.println(goods);
        }
    }

    @Test
    public void testRegGoodsOrder() {
        MasterEntity master = new MasterManager().loadMaster(2);
        try {
            new GoodsOrderManager().regGoodsOrder(master);
        } catch (BaseException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
    }
}
