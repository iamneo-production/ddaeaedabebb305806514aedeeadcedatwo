package com.examly.springapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringappApplicationTests {


	@Autowired
   private  MockMvc mockMvc ;
   
	@Test
	public void testCreateCourse() throws Exception {
		// Create a JSON object representing the request body
		String requestBody = "{\"courseId\": 1, \"title\": \"Test Course\", \"description\": \"Test Description\", \"instructorName\": \"Test Instructor\"}";

		// Perform the POST request
		mockMvc.perform(MockMvcRequestBuilders.post("/course/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
	}

	@Test
	public void testCreateLessonStatus() throws Exception {
		// Create a JSON object representing the request body
		String requestBody = "{\"lessonId\": 1, \"title\": \"Test Lesson\", \"content\": \"Test Content\"}";
		int courseId = 1;

		// Perform the POST request and check the status
		mockMvc.perform(MockMvcRequestBuilders.post("/course/" + courseId + "/lesson")
				.contentType(MediaType.APPLICATION_JSON)
				.content(requestBody)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGetAllCoursesWithExpectedResponseStatus() throws Exception {
		// Perform the GET request and check the status
		mockMvc.perform(MockMvcRequestBuilders.get("/course/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGetAllCoursesStatus() throws Exception {
		// Perform the GET request and check the status
		mockMvc.perform(MockMvcRequestBuilders.get("/course/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGetLessonWithCourseDetailsStatus() throws Exception {
		// Perform the GET request and check the status
		mockMvc.perform(MockMvcRequestBuilders.get("/course/lesson/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testCourseModelClassExists() {
		checkClassExists("com.examly.springapp.model.Course");
	}

	@Test
	public void testLessonModelClassExists() {
		checkClassExists("com.examly.springapp.model.Lesson");
	}

	@Test
	public void testCourceRepoClassExists() {
		checkClassExists("com.examly.springapp.Repository.CourseRepo");
	}
	@Test
	public void testServiceClassExists() {
		checkClassExists("com.examly.springapp.controller.ApiController");
	}

	@Test
	public void testControllerClassExists() {
		checkClassExists("com.examly.springapp.service.ApiService");
	}

	private void checkClassExists(String className) {
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			assertTrue(false, "Class " + className + " does not exist.");
		}
	}

	@Test

	public void controllerfolder() {
		String directoryPath = "src/main/java/com/examly/springapp/controller"; // Replace with the path to your
																				// directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void controllerfile() {
		String filePath = "src/main/java/com/examly/springapp/controller/ApiController.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testModelFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test
	public void testModelFile() {
		String filePath = "src/main/java/com/examly/springapp/model/Course.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testModelFile2() {
		String filePath = "src/main/java/com/examly/springapp/model/Lesson.java";
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testrepositoryfolder() {
		String directoryPath = "src/main/java/com/examly/springapp/Repository"; // Replace with the path to your
																				// directory
		File directory = new File(directoryPath);
		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test

	public void testrepositoryFile() {

		String filePath = "src/main/java/com/examly/springapp/Repository/CourseRepo.java";
		// Replace with the path to your file
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test

	public void testrepositoryFile2() {

		String filePath = "src/main/java/com/examly/springapp/Repository/LessonRepo.java";
		// Replace with the path to your file
		File file = new File(filePath);
		assertTrue(file.exists() && file.isFile());
	}

	@Test
	public void testServiceFolder() {
		String directoryPath = "src/main/java/com/examly/springapp/service";
		File directory = new File(directoryPath);

		assertTrue(directory.exists() && directory.isDirectory());
	}

	@Test

	public void testServieFile() {

		String filePath = "src/main/java/com/examly/springapp/service/ApiService.java";

		File file = new File(filePath);

		assertTrue(file.exists() && file.isFile());

	}

}
