package ru.gblesson.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

public class MainApp {

    private static boolean CHECK = true;
    private static final String DEL = "\\s";

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean("productService", ProductService.class);



        Scanner scan = new Scanner(System.in);


        while (CHECK){
            String[] cmd = scan.nextLine().split(DEL);

            switch (cmd[0]){
                case("/add"):
                    productService.add(new Product(Integer.parseInt(cmd[1]), cmd[2], Integer.parseInt(cmd[3])));
                    break;
                case("/update"):
                    productService.update(Integer.parseInt(cmd[1]), Integer.parseInt(cmd[2]), cmd[3], Integer.parseInt(cmd[4]));
                    break;
                case ("/rm"):
                    productService.remove(Integer.parseInt(cmd[1]));
                    break;
                case ("/show"):
                    System.out.println(context.getBean("/getProducts"));
                    break;
                case ("/count"):
                    System.out.println(context.getBean("/getCount"));
                    break;
                case ("/avg"):
                    System.out.println(context.getBean("/getAvg"));
                    break;
                default:
                    System.out.println("Unknown command: " + cmd[0]);

            }
        }
        context.close();
    }

}
