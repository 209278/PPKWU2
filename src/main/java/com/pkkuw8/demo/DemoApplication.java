package com.pkkuw8.demo;

import com.pkkuw8.demo.get_data_from_wikamp.DataFromWikampDownloader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {
//		DataFromWikampDownloader.test();
		SpringApplication.run(DemoApplication.class, args);
	}

}
