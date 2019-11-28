package com.lf.sino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.lf.sino.upload.FileSaver;
import com.lf.sino.upload.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class, FileSaver.class
})
public class SinoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinoApplication.class, args);
	}

}
