package chasing.dao.impl;

import chasing.dao.EbDao;
import chasing.pojo.Eb;

import java.sql.Date;


/**
 * @author 柴柴快乐每一天
 * @create 2021-05-14  7:27 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class EbDaoImpl extends BaseDao implements EbDao {

    @Override
    public Eb search(Date date) {
        String sql = "select no, info, href, day1, day2, day4, day7, day15, month1, month3, month6 from ebbinghaus where date = ?";
        Eb eb = queryForOne(Eb.class, sql, date);
        return eb;
    }

    @Override
    public Eb queryByNo(int no) {
        String sql = "select info,href from ebbinghaus where no = ?";
        return queryForOne(Eb.class, sql, no);
    }

    @Override
    public int update(Eb todayEb) {

        String sql = "update ebbinghaus set info = ?, href = ? where date = ?";

        return update(sql, todayEb.getInfo(), todayEb.getHref(), todayEb.getDate());
    }
}
