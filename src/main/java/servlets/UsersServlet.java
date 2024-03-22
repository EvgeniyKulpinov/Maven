package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersServlet extends HttpServlet {
    private final AccountService accountService;

    public UsersServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    //get public user profile
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        //todo: module 2 home work
    }

    //sign up
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        if (login == null || pass == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Введите имя пользователя и пароль");
            return;
        }

        if (accountService.loginVerification(login)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Пользователь с таким именем существует");
            return;
        }

        accountService.addNewUser(new UserProfile(login, pass));
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Вы зарегистрированы");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    //change profile
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        //todo: module 2 home work
    }

    //unregister
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        //todo: module 2 home work
    }
}
