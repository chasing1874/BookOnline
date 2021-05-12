package chasing.web;

import chasing.pojo.User;
import chasing.service.UserService;
import chasing.service.impl.UserServiceimpl;
import chasing.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-05  3:41 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceimpl();

    /**
     * @describe: 处理登录的功能
     * @param req
	 * @param resp
     * @return void
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");

        User user = new User();
        WebUtils.copyParamToBean(req.getParameterMap(), user);

        User login = userService.login(user);
        if (login == null) {
            //把错误信息、和回显的表单项信息保存到request域中
            req.setAttribute("msg", "用户或密码错误");
            req.setAttribute("username", req.getParameter("username"));
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            // 登录成功
            // 保存用户登录的信息到Session域中
            req.getSession().setAttribute("user", login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * @describe: 处理注册的功能
     * @param req
	 * @param resp
     * @return void
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        //获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = new User();
        WebUtils.copyParamToBean(req.getParameterMap(), user);

        //检查验证码是否正确
        if (token != null && token.equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                System.out.println("the username has existed!");
                //回显信息，保存到request域中
                req.setAttribute("msg", "用户名已存在！");
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                //调用service保存到数据库
                userService.registUser(user);
                //session保存用户登录状态
                req.getSession().setAttribute("user", user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }



        } else {
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("email", email);

            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }

    /**
     * 用户注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 销毁session中用户登录的信息（或者直接销毁session，确保session域对象没有其他重要数据）
        req.getSession().invalidate();
        //2. 重定向回首页
        resp.sendRedirect(req.getContextPath());
    }
}
