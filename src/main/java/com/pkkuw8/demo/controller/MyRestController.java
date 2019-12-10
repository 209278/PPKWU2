package com.pkkuw8.demo.controller;

import com.pkkuw8.demo.get_data_from_wikamp.DataFromWikampDownloader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class MyRestController {

    @RequestMapping(method = RequestMethod.GET, value = "/getDataFromWikamp")
    void getDataFromWikamp(HttpServletResponse response, @RequestParam(name = "user", defaultValue = "Nowak") String user){
        try {
            File file = DataFromWikampDownloader.test(user, "test", "test");
            response.setContentType("application/text");
            response.addHeader("Content-Disposition", "attachment; filename="+file);
            Files.copy(file.toPath(), response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
