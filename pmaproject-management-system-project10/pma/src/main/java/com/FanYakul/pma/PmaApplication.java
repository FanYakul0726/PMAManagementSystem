package com.FanYakul.pma;

import com.FanYakul.pma.dao.ProjectRepository;
import com.FanYakul.pma.dao.StudentRepository;
import com.FanYakul.pma.entities.Project;
import com.FanYakul.pma.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class PmaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmaApplication.class, args);
	}

}
