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
    public void insert() {
        MasterEntity master1 = new MasterEntity();
        master1.setMasterName("huangwb");
        master1.setMasterSex("male");
        master1.setMasterTel("13736681153");
        master1.setMasterMail("1024311844@qq.com");
        session.save(master1);
        tx.commit();
    }

    @Test
    public void regPet() {
        try {
            MasterEntity master = new MasterManager().loadMaster(1);
            PetRaceEntity petRace = new PetRaceManager().loadAll();
            String name = "hashiqi";
            String sex = "female";
            String nickName = "yellow";

            PetEntity newPet = new PetManager().regPet()
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteMaster() {
        MasterEntity master1 = (MasterEntity) session.get(MasterEntity.class, 1);
        session.delete(master1);
        tx.commit();
    }

    @Test
    public void changePet() {
        PetEntity pet1 = (PetEntity) session.get(PetEntity.class, 7);
        MasterEntity master1 = (MasterEntity) session.get(MasterEntity.class, 3);
        pet1.setMaster(master1);
        master1.getPets().add(pet1);
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
    public void save_service_appointment() {
        MasterEntity master1 = new MasterEntity();
        master1.setMasterName("jianglr");
        master1.setMasterSex("male");
        master1.setMasterTel("13588899791");
        master1.setMasterMail("1024311844@qq.com");


        PetEntity pet1 = new PetEntity();
        pet1.setPetName("hashiqi");
        pet1.setPetNickname("yellow");
        pet1.setPetRace("dog");
        pet1.setPetSex("male");
        pet1.setMaster(master1);

        PetEntity pet2 = new PetEntity();
        pet2.setPetName("hashiqi");
        pet2.setPetNickname("black");
        pet2.setPetRace("dog");
        pet2.setPetSex("male");
        pet2.setMaster(master1);

        master1.getPets().add(pet1);
        master1.getPets().add(pet2);
        pet1.setMaster(master1);
        pet2.setMaster(master1);
        session.save(master1);

        //****************************************************************************
        AppointmentEntity appointment1 = new AppointmentEntity();
        appointment1.setPet(pet1);
        appointment1.setAppointmentStart(new Timestamp(new Date().getTime()));

        AppointmentEntity appointment2 = new AppointmentEntity();
        appointment2.setPet(pet2);
        appointment2.setAppointmentStart(new Timestamp(new Date().getTime()));

        session.save(appointment1);
        session.save(appointment2);

        //****************************************************************************

        ServiceRaceEntity service1 = new ServiceRaceEntity();
        service1.setServiceName("shower");
        service1.setServicePrice(20.0);
        service1.setServiceDescribe("take a shower");

        ServiceRaceEntity service2 = new ServiceRaceEntity();
        service2.setServiceName("cut");
        service2.setServicePrice(30.0);
        service2.setServiceDescribe("cut hair");

        session.save(service1);
        session.save(service2);

        //****************************************************************************

        ServiceAppointmentREntity service_appointment1 = new ServiceAppointmentREntity();
        service_appointment1.setFinishStatus((byte) 0);
        service_appointment1.setAppointment(appointment1);
        service_appointment1.setService(service1);

        ServiceAppointmentREntity service_appointment2 = new ServiceAppointmentREntity();
        service_appointment2.setFinishStatus((byte) 0);
        service_appointment2.setAppointment(appointment1);
        service_appointment2.setService(service2);

        ServiceAppointmentREntity service_appointment3 = new ServiceAppointmentREntity();
        service_appointment3.setFinishStatus((byte) 0);
        service_appointment3.setAppointment(appointment2);
        service_appointment3.setService(service1);

        ServiceAppointmentREntity service_appointment4 = new ServiceAppointmentREntity();
        service_appointment4.setFinishStatus((byte) 0);
        service_appointment4.setAppointment(appointment2);
        service_appointment4.setService(service2);

        session.save(service_appointment1);
        session.save(service_appointment2);
        session.save(service_appointment3);
        session.save(service_appointment4);
        tx.commit();
    }

    @Test
    public void query_test() {
        String hql = "from ServiceRaceEntity where servicePrice < 30";
        Query query = session.createQuery(hql);
        List<ServiceRaceEntity> services = query.list();
        for (ServiceRaceEntity service : services) {
            System.out.println(service.toString());
        }
        ServiceRaceEntity service1 = (ServiceRaceEntity) query.uniqueResult();
        System.out.println(service1);

        tx.commit();
    }

    @Test
    public void regGoods() throws IOException {
        GoodsRaceEntity goods_race = (GoodsRaceEntity) session.createQuery("from GoodsRaceEntity where goodsRaceName = :name")
                .setParameter("name", "沐浴露").uniqueResult();
        BrandsEntity brand = (BrandsEntity) session.createQuery("from BrandsEntity where brandsName = :name")
                .setParameter("name", "雕牌").uniqueResult();

        File file = new File("D:" + File.separator + "Pet-Store" + File.separator + "blob.png");
        InputStream in = new FileInputStream(file);
        Blob barCode = Hibernate.getLobCreator(session).createBlob(in, in.available());

        GoodsEntity goods = new GoodsEntity();
        goods.setGoodsName("男士沐浴露");
        goods.setGoodsPrice(20.0);
        goods.setGoodsRace(goods_race);
        goods.setBrand(brand);
        goods.setOnSale(0);
        goods.setGoodsAmount(10);
        goods.setGoodsBarcode(barCode);

        goods_race.getGoods().add(goods);
        brand.getGoods().add(goods);
        session.save(goods);
        tx.commit();
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
        try {
            List<GoodsRaceEntity> list = new GoodsRaceManager().loadAll();
            for (GoodsRaceEntity good_race : list) {
                System.out.println(good_race.toString());
            }
        } catch (BaseException e) {
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


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        try {
            new BrandManager().regBrand(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
