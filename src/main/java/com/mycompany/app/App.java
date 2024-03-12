package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

public class App
{
    /*
    * takes 2 Integer arraylists
    * takes 2 integers
    *
    *
    * */

    public static boolean search(ArrayList<Integer> i, int k) {
        return true;
    }
    public static String lowerCase(ArrayList<Integer> array1, ArrayList<Integer> array2, int n, ArrayList<String> str) {

        /*
        * iki integer arraylistin de ninci saysını alıp toplayacak
        * string arrayinin stirnglerini lowercase yapıp concatenate sonra syıyla
        */

        String str_to_return = "";


        // boş array kontrolü
        // null string elemanı kontrolü
        // negatif sayı gelmesi kontrolü
        // n out of bound kontrolü
        // doğru çalışan bi normal test
        if (str != null && str.size() != 0) {
            for (int i = 0; i < str.size(); i++) {

                if (str.get(i) != null) {
                    str.set(i, str.get(i).toLowerCase());
                    str_to_return = str_to_return + str.get(i) + " ";
                }
            }
        }

        int num1 = -1;
        int num2 = -1;

        // sayı pozitif olduğu sürece toplanıp concat edilir
        if (n <= array1.size() && n >= 0 && array1.get(n) >=0) {
            num1 = array1.get(n);
        }

        if (n <= array2.size() && n >= 0 && array2.get(n) >= 0) {
            num2 = array2.get(n);
        }

        int sum = 0;

        if(num1 >= 0 && num2 >= 0) sum = num1 + num2;
        else if(num1 >= 0) sum = num1;
        else if(num2 >= 0) sum = num2;


        return str_to_return + "" + sum;
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
            //System.out.println(req.queryParams("input1"));
            //System.out.println(req.queryParams("input2"));

            // array1
            String input1 = req.queryParams("input1");
            java.util.Scanner sc1 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
            while (sc1.hasNext())
            {
                int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
                inputList.add(value);
            }
            System.out.println(inputList);

            // array2
            String input2 = req.queryParams("input2");
            java.util.Scanner sc2 = new java.util.Scanner(input2);
            sc1.useDelimiter("[;\r\n]+");
            java.util.ArrayList<Integer> inputList1 = new java.util.ArrayList<>();
            while (sc2.hasNext())
            {
                int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
                inputList1.add(value);
            }
            System.out.println(inputList1);


            // int n'i alıyor
            String input3 = req.queryParams("input3").replaceAll("\\s","");
            int input3AsInt = Integer.parseInt(input3);

            // string array
            String input4 = req.queryParams("input4");
            java.util.Scanner sc4 = new java.util.Scanner(input1);
            sc1.useDelimiter("[;\r\n]+");
            ArrayList<String> stringList = new ArrayList<>();
            while (sc4.hasNext())
            {
                String value = sc4.next().replaceAll("\\s","");
                stringList.add(value);
            }
            System.out.println(stringList);

            String result = App.lowerCase(inputList, inputList1, input3AsInt, stringList);

            Map map = new HashMap();
            map.put("result", result);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
                (rq, rs) -> {
                    Map map = new HashMap();
                    map.put("result", "not computed yet!");
                    return new ModelAndView(map, "compute.mustache");
                },
                new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}

