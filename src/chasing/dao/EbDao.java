package chasing.dao;

import chasing.pojo.Eb;

import java.sql.Date;


/**
 * @author 柴柴快乐每一天
 * @create 2021-05-14  7:21 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface EbDao {
    public Eb search(Date date);

    public Eb queryByNo(int no);

    public int update(Eb todayEb);


}
