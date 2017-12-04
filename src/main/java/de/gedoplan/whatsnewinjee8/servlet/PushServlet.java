package de.gedoplan.whatsnewinjee8.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.PushBuilder;

@WebServlet(urlPatterns = "/dummy")
public class PushServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PushBuilder pushBuilder = request.newPushBuilder();
    if (pushBuilder != null) {
      pushBuilder.path("/dummy.css").push();
    }

    response.setContentType("text/plain");
    try (PrintWriter writer = response.getWriter()) {
      writer.print("Hello, world!");
    }
  }
}
