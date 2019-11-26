package com.pkkuw8.demo.get_data_from_wikamp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataFromWikampDownloader {
    private String url = "https://adm.edu.p.lodz.pl/user/users.php";

    public static void test() throws IOException {
        Map<String, String> h = new HashMap<>();
        h.put("ga", "GA1.2.1550341512.1573576568");
        h.put("wikamp_authpref", "CAS");
        h.put("_gid", "GA1.2.2115317034.1574780801");
        h.put("MoodleSessionadm", "r9f8ukb0929gtbv6q1i0gsl6hu");

        Document doc = Jsoup.connect("https://adm.edu.p.lodz.pl/user/users.php?search=Adamus")
                .cookies(h)
                .get();

        System.out.println(doc);
//        Map<String, String> h = new HashMap<>();
//        h.put("cookie", "_ga=GA1.2.1550341512.1573576568; wikamp_authpref=CAS; _gid=GA1.2.2115317034.1574780801; MoodleSessionadm=r9f8ukb0929gtbv6q1i0gsl6hu");
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://adm.edu.p.lodz.pl/user/users.php?search=Adamus"))
//                .build();
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();
    }
}
