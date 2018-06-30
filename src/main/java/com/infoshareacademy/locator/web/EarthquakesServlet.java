package com.infoshareacademy.locator.web;

import com.infoshareacademy.locator.storage.EarthquakesCache;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/earthquake")
public class EarthquakesServlet extends HttpServlet {
    @Inject
    private EarthquakesCache storage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String year = req.getParameter("year");

        req.setAttribute("earthquakes", storage.get(year));
        req.setAttribute("year", year);

        req.getRequestDispatcher("earthquakes.jsp").forward(req, resp);
    }
}
