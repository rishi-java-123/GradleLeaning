package com.rishi.learning;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Configuration {
	private String factoryType;
	private String location;

	public String getFactoryType() {
		return factoryType;
	}

	public void setFactoryType(String factoryType) {
		this.factoryType = factoryType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public static List<Configuration> loadConfiguration(String fileName) throws IOException {
		Path path = FileSystems.getDefault().getPath(fileName);
		String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		List<Configuration> config = objectMapper.readValue(contents, new TypeReference<List<Configuration>>(){});
		//Configuration config = objectMapper.readValue(contents, Configuration.class);
		return config;

	}

}
