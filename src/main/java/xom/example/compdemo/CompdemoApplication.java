package xom.example.compdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import xom.component.cloudFileAccessAzureSpring.AzureFileAccessApiModule;

@SpringBootApplication
@Import(AzureFileAccessApiModule.class)
public class CompdemoApplication { 

	public static void main(String[] args) {
		SpringApplication.run(CompdemoApplication.class, args);
	}

}
