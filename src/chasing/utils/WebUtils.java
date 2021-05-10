package chasing.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-05  4:12 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class WebUtils {

    /**
     * @describe: 将参数一次性批量注入对象
     * @param value map类型
	 * @param bean 待注入对象
     * @return T
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * @describe: 将字符串转换为int类型的数据
     * @param strInt    待转换字符串
	 * @param defaultValue  转换失败默认值
     * @return int
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
