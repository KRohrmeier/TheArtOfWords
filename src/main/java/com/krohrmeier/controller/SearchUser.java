package com.krohrmeier.controller;

import com.krohrmeier.entity.User;
import com.krohrmeier.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * A servlet to set the stage and troubleshoot
 */
@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class SearchUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao userDao = new GenericDao(User.class);
        final Logger logger = LogManager.getLogger(this.getClass());
        logger.info("In searchUser servlet...");

        if (req.getParameter("submit").equals("ViewAll")) {
            req.setAttribute("users", userDao.getAll());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/showUsers.jsp");
        dispatcher.forward(req, resp);
    }
}