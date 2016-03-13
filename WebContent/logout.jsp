<% request.getSession(false);
        session.invalidate();
        response.sendRedirect("home.jsp");
        %>