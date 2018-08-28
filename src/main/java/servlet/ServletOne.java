package servlet;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Logger;


public class ServletOne extends HttpServlet {

    private static final Logger logger = Logger.getLogger(ServletOne.class.getName());
    //LoggerFactory.getLogger(ServletOne.class.getName());


    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getInitParameter("p1");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder builder = new StringBuilder();
        Map<String, String[]> requestParams = req.getParameterMap();
        for (String param : requestParams.keySet()) {
            builder.append(param).append(":=");
            for (String value : requestParams.get(param)) {
                builder.append(value).append("<p>");
            }
        }

        resp.setContentType("text/html; encoding=UTF-8");
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.append("<html>")
                    .append("<head>")
                    .append("<title>ServletOneTab</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<h4>servlet ServletOne at ")
                    // means project root folder
                    .append(req.getContextPath())
                    //--------------------------
                    .append("<p>")
                    .append(builder)
                    //--------------
                    .append("</h4>")
                    .append("</body>")
                    .append("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "getServletInfo stub";
    }
}
