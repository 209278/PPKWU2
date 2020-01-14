package com.pkkuw8.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

@RestController
public class vCardRestController {
    @GetMapping("/vcard")
    public ResponseEntity<String> vCard(
            HttpServletResponse response,
            @RequestParam(name = "firstName", defaultValue = "") String firstName,
            @RequestParam(name = "lastName", defaultValue = "") String lastName,
            @RequestParam(name = "inst", defaultValue = "") String inst
    ) throws IOException {
        String vCardString = "BEGIN:VCARD\n" +
                        "VERSION:2.1\n" +
                        "FN:" + firstName + " " + lastName + "\n" +
                        "N:" + lastName + ";" + firstName + "\n" +
                        "ORG:" + inst + "\n" +
                        "END:VCARD";

        return ResponseEntity
                .ok()
                .header("Content-Disposition", "attachment; filename=\"" + firstName + ".vcf\"")
                .header("Content-Type","text/x-vcard")
                .body(vCardString);

    }
}
