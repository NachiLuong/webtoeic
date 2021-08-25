package vn.nacl.web.logic.controller.admin;

import org.apache.log4j.Logger;
import vn.nacl.core.dto.UserDTO;
import vn.nacl.core.service.UserService;
import vn.nacl.core.service.impl.UserServiceImpl;
import vn.nacl.core.web.common.WebConstant;
import vn.nacl.core.web.utils.FormUtil;
import vn.nacl.web.logic.command.UserCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import java.util.logging.Logger;

@WebServlet("/login.html")
public class LoginController extends HttpServlet {
    private final Logger logger= Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        RequestDispatcher rd=request.getRequestDispatcher("/views/admin/login.jsp");
        rd.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {

        //cách cũ
//        String name=request.getParameter("name");
//        String password= request.getParameter("password");

        //cách mới nên dùng
        UserCommand command= FormUtil.populate(UserCommand.class, request);
        UserDTO pojo=command.getPojo();
        UserService userService = new UserServiceImpl();
        try {
            if(userService.isUserExist(pojo) !=null) {
                if (userService.findRoleByUser(pojo) != null && userService.findRoleByUser(pojo).getRoleDTO() != null) {
                    if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_ADMIN)) {
                        response.sendRedirect("/admin-home.html");
                    } else if (userService.findRoleByUser(pojo).getRoleDTO().getName().equals(WebConstant.ROLE_USER)) {
                        response.sendRedirect("/home.html");
                    }
                }
            }
        } catch(NullPointerException e){
            logger.error(e.getMessage(), e);
            request.setAttribute(WebConstant.ALERT, WebConstant.TEST_ERROR);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Tên đăng nhập hoặc mật khẩu sai");
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/login.jsp");
            rd.forward(request,response);
        }
    }
}
