package chasing.filter;

import chasing.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-18  7:47 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest, servletResponse);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();//回滚事务
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}
