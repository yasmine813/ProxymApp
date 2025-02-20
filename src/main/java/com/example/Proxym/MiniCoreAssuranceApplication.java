package com.example.Proxym;

import com.example.Proxym.Entities.Contrat;
import com.example.Proxym.dto.ContratDTO.ContratRequestDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MiniCoreAssuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniCoreAssuranceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		/*modelMapper.typeMap(ContratRequestDTO.class, Contrat.class).addMappings(mapper -> {
			mapper.skip(Contrat::setId);
		});*/


		return modelMapper;
	}



}
