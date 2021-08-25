package vn.nacl.web.logic.controller.admin;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.log4j.Logger;
import vn.nacl.core.common.utils.UploadUtil;
import vn.nacl.core.service.ListenGuidelineService;
import vn.nacl.core.service.impl.ListenGuidelineServiceImpl;
import vn.nacl.core.web.common.WebConstant;
import vn.nacl.core.web.utils.FormUtil;
import vn.nacl.web.logic.command.ListenGuideCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

//@WebServlet("/admin-guideline-listen-list.html")
@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html", "/admin-guideline-listen-edit.html"})
public class ListenGuidelineController extends HttpServlet {
    private final Logger logger= Logger.getLogger(this.getClass());
    private ListenGuidelineService guidelineService=new ListenGuidelineServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        ListenGuideCommand command= FormUtil.populate(ListenGuideCommand.class, request);
        ResourceBundle resourceBundle= ResourceBundle.getBundle("ApplicationResources");
        HttpSession session=request.getSession();
//        command.setMaxPageItems(2);
//        RequestUtil.initSearchBean(request,command);
//        Object[] objects= guidelineService.findListenGuidelineByProperty(null,null, command.getSortExpression(),
//                command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems() );
//        command.setListResult((List<ListenGuideLineDTO>) objects[1]);
//        command.setTotalItems(Integer.parseInt(objects[0].toString()) );
        request.setAttribute(WebConstant.ALERT, WebConstant.TEST_SUCCESS);
        request.setAttribute(WebConstant.LIST_ITEMS, command);
        request.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.content"));
        if(session!=null){
            request.setAttribute(WebConstant.ALERT, session.getAttribute(WebConstant.ALERT));
            request.setAttribute(WebConstant.MESSAGE_RESPONSE,session.getAttribute(WebConstant.MESSAGE_RESPONSE));
        }
        if(command.getUrlType() !=null && command.getUrlType().equals(WebConstant.URL_LIST))
        {
            RequestDispatcher rd=request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
            rd.forward(request,response);
        } else if(command.getUrlType() !=null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/edit.jsp");
            rd.forward(request, response);
        }
        session.removeAttribute(WebConstant.MESSAGE_RESPONSE);
        session.removeAttribute(WebConstant.ALERT);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException {
        ListenGuideCommand command= new ListenGuideCommand();
        UploadUtil uploadUtil= new UploadUtil();
        ResourceBundle resourceBundle= ResourceBundle.getBundle("ApplicationResources");
        HttpSession session=request.getSession();
        Set<String> valueTitle= new HashSet<String>();
        valueTitle.add("pojo.title");
        valueTitle.add("pojo.content");
        try {
            Object[] objects= uploadUtil.writeOrUpdateFile(request, valueTitle, WebConstant.LISTENGUIDELINE);
            session.setAttribute(WebConstant.ALERT, WebConstant.TEST_SUCCESS);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.guideline.listen.add.success"));
        }catch (FileUploadException e){
            logger.error(e.getMessage(), e);
            session.setAttribute(WebConstant.ALERT, WebConstant.TEST_ERROR);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.error"));
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            session.setAttribute(WebConstant.ALERT, WebConstant.TEST_ERROR);
            session.setAttribute(WebConstant.MESSAGE_RESPONSE, resourceBundle.getString("label.error"));
        }
        response.sendRedirect("/admin-guideline-listen-list.html?urlType=url-list");

    }
}
