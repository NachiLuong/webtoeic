package vn.nacl.web.logic.controller.admin;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/admin-user-list.html"})
public class UserController extends HttpServlet {
    UserService userService= new UserServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        UserCommand command= FormUtil.populate(UserCommand.class,  request);
        UserDTO pojo=command.getPojo();
        if(command.getUrlType().equals(WebConstant.URL_LIST)){
            Map<String,Object> mapProperty= new HashMap<String,Object>();
            Object[] objects= userService.findByProperty(mapProperty,command.getSortExpression(), command.getSortDirection(), command.getFirstItem(),command.getMaxPageItems());
            command.setListResult((List<UserDTO>) objects[1]);
            command.setTotalItems((Integer) objects[0]);
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/user/list.jsp");
            rd.forward(request,response);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        RequestDispatcher rd=request.getRequestDispatcher("/views/admin/home.jsp");
        rd.forward(request,response);

    }
}
