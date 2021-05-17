package chasing.test;

import chasing.dao.EbDao;
import chasing.dao.impl.EbDaoImpl;
import chasing.pojo.Eb;
import org.junit.Test;


import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  11:38 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class EbDaoTest {
    EbDao ebDao = new EbDaoImpl();

    @Test
    public void search() {
        java.util.Date  utilDate = new java.util.Date();
        //System.out.println("utilDate : " + utilDate);
        //util.Date转sql.Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Eb eb = ebDao.search(sqlDate);
        System.out.println(eb);
    }

    @Test
    public void queryByNo() {
        Eb eb = ebDao.queryByNo(1);
        System.out.println(eb);
    }
}