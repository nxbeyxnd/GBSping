package ru.geek.app;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@WebServlet (name = "first", value = "/market")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");

        for (int i = 0; i < getProductList().size(); i++) {
            resp.getWriter().printf(getProductList().get(i) + "<br>");
        }

        resp.getWriter().println("<hr>" + getProductList().get(Integer.parseInt(id)).toString());
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    private ArrayList<Product> getProductList(){
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1,"Potato", new Random().nextInt(1000))) ;
        products.add(new Product(2,"Orange",new Random().nextInt(1000)));
        products.add(new Product(3,"Milk",new Random().nextInt(1000)));
        products.add(new Product(4,"Grass",new Random().nextInt(1000)));
        products.add(new Product(5,"Water",new Random().nextInt(1000)));
        products.add(new Product(6,"Pan",new Random().nextInt(1000)));
        products.add(new Product(7,"Can",new Random().nextInt(1000)));
        products.add(new Product(8,"Cucumber",new Random().nextInt(1000)));
        products.add(new Product(9,"Filter",new Random().nextInt(1000)));
        products.add(new Product(10,"Apple",new Random().nextInt(1000)));
        return products;
    }
}
