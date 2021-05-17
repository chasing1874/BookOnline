package chasing.service.impl;

import chasing.dao.EbDao;
import chasing.dao.impl.EbDaoImpl;
import chasing.pojo.Eb;
import chasing.service.EbService;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-14  7:31 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class EbServiceImpl implements EbService {

    private EbDao ebDao = new EbDaoImpl();

    @Override
    public List<Eb> search(Date date) {
        //日期空指针待处理
        if (date == null) {
            return null;
        }
        Eb todayTodo = ebDao.search(date);
        List<Eb> ebList = new LinkedList<>();

        int day1 = 0;
        int day2 = 0;
        int day4 = 0;
        int day7 = 0;
        int day15 = 0;
        int month1 = 0;
        int month3 = 0;
        int month6 = 0;
        try {
            day1 = todayTodo.getDay1();
            day2 = todayTodo.getDay2();
            day4 = todayTodo.getDay4();
            day7 = todayTodo.getDay7();
            day15 = todayTodo.getDay15();
            month1 = todayTodo.getMonth1();
            month3 = todayTodo.getMonth3();
            month6 = todayTodo.getMonth6();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(day1);

        Eb ebDay1 = null;
        Eb ebDay2 = null;
        Eb ebDay4 = null;
        Eb ebDay7 = null;
        Eb ebDay15 = null;
        Eb ebMonth1 = null;
        Eb ebMonth3 = null;
        Eb ebMonth6 = null;
        try {
            ebDay1 = ebDao.queryByNo(day1);
            ebDay2 = ebDao.queryByNo(day2);
            ebDay4 = ebDao.queryByNo(day4);
            ebDay7 = ebDao.queryByNo(day7);
            ebDay15 = ebDao.queryByNo(day15);
            ebMonth1 = ebDao.queryByNo(month1);
            ebMonth3 = ebDao.queryByNo(month3);
            ebMonth6 = ebDao.queryByNo(month6);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ebList.add(ebDay1);
        ebList.add(ebDay2);
        ebList.add(ebDay4);
        ebList.add(ebDay7);
        ebList.add(ebDay15);
        ebList.add(ebMonth1);
        ebList.add(ebMonth3);
        ebList.add(ebMonth6);

        return ebList;
    }

    @Override
    public void addEb(Eb todayEb) {
        ebDao.update(todayEb);
    }
}
