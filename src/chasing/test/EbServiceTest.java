package chasing.test;

import chasing.pojo.Eb;
import chasing.service.EbService;
import chasing.service.impl.EbServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  4:54 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class EbServiceTest {
    EbService ebService = new EbServiceImpl();

    @Test
    public void search() {
//        List<Eb> search = ebService.search(new String("2021-05-18"));
//        System.out.println(search);
        Date date = new Date();
        System.out.println(date);

    }
}