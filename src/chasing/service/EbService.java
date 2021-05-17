package chasing.service;

import chasing.pojo.Eb;

import java.sql.Date;
import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-14  7:30 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface EbService {
    public List<Eb> search(Date date);

    public void addEb(Eb todayEb);
}
