package com.pkkuw8.demo.get_data_from_wikamp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;

public class DataFromWikampDownloader {
    private String url = "https://adm.edu.p.lodz.pl/user/users.php";

    public static File test(String user, String login, String password) throws IOException {
//        URL url = new URL("https://weeia.edu.p.lodz.pl/login/index.php?authCAS=CAS&wantsurl=%2F");
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        connection.setRequestMethod("POST");
//
//        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
//        out.writeBytes("username=" + login + "&password=" + password + "&submit=LOGIN&lt=LT-bc78c3ef-f087-ec66-4550-62dc5abb688dZe3s1&_eventId=submit");
//
//        connection.disconnect();
        
        Document doc = Jsoup.connect("https://adm.edu.p.lodz.pl/user/users.php?search=" + user)
                .get();

        File file = new File("test.html");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter("test.html");
        fileWriter.write(doc.toString(), 0, doc.toString().length());
        return file;
    }
}
