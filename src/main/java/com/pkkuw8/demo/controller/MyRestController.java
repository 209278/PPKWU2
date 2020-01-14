package com.pkkuw8.demo.controller;

import com.pkkuw8.demo.Entry;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyRestController {

    @GetMapping("/getDataFromWikamp")
    public String getDataFromWikamp(Model model, @RequestParam(name = "user", defaultValue = "Nowak") String user){
        try {
            Document doc = Jsoup.connect("https://adm.edu.p.lodz.pl/user/users.php?search=" + user)
                    .timeout(30000).get();
            Elements response = doc.select(".user-info");

            List<Entry> list = new ArrayList<>();

            response.forEach(element->{
                String[] splitedString = element.select("h3").text().split(" ");
                list.add(
                        new Entry(
                                element.select("h3").text(),
                                element.select(".item-content").text(),
                                "/vcard?firstName=" + splitedString[0]
                                        + "&lastName=" + splitedString[1]
                                        + "&inst=" + element.select(".item-content").text()
                        )
                );
            });

            model.addAttribute("entries", list);
            return "results";
        } catch (IOException e) {
            e.printStackTrace();
            return "results";
        }
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
