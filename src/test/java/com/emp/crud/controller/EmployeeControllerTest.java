package com.emp.crud.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.emp.crud.dto.EmployeeDTO;
import com.emp.crud.service.EmployeeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeController empController;

	@MockBean
	private EmployeeServiceImpl employeeService;


	@Autowired 
	private WebApplicationContext context;


	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void getEmployeeByIdAPI() throws Exception
	{
		/*
		 * EmployeeDTO mockemployee = new EmployeeDTO(1,"name","sdfs","adfa","af");
		 * 
		 * Mockito.when(employeeService.getEmpById(Mockito.anyLong())).thenReturn(
		 * mockemployee);
		 * 
		 * mvc.perform( get("/employeeById/{id}", 1)
		 * .accept(MediaType.APPLICATION_JSON)) .andDo(print())
		 * .andExpect(status().isOk())
		 * .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		 * .andExpect(jsonPath("$.empId", is(1)));
		 */


		EmployeeDTO mockemployee = new EmployeeDTO(1,"name","sdfs","adfa","af");

		Mockito.when(employeeService.getEmpById(Mockito.anyLong()))
		.thenReturn(mockemployee);
		
		mvc.perform(MockMvcRequestBuilders.get("/employeeById/{id}",
				1)).andExpect(status().isOk()) .andDo(print());
		//.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		//.andExpect(jsonPath("$.empId", is(1))).andExpect(jsonPath("$.empName",
		// is("name"))) //.andExpect(jsonPath("$.empEmail", is("sdfs"))).
		//andDo(print());


		/*
		 * //Using Request Builder EmployeeDTO empDto = new
		 * EmployeeDTO(2,"name","sdfs","adfa","af");
		 * 
		 * String exampleJson =
		 * "{\"empId\":\"2\",\"empName\":\name\",\"empEmail\":\"sdfs\",\"empAddress\":\"adfa\",\"empContact\":af\"}";
		 * 
		 * Mockito.when(employeeService.getEmpById(Mockito.anyLong())).thenReturn(empDto
		 * );
		 * 
		 * RequestBuilder requestBuilder =
		 * MockMvcRequestBuilders.get("/employeeById/{id}")
		 * .accept(MediaType.APPLICATION_JSON);
		 * 
		 * MvcResult result = mvc.perform(requestBuilder).andReturn();
		 * 
		 * System.out.println(result.getResponse());
		 * 
		 * String expected =
		 * "empId:2,empName:sdfs,empMail:sdfs,empAddress:adfa,empContact:af";
		 * 
		 * JSONAssert.assertEquals(expected, result.getResponse() .getContentAsString(),
		 * false);
		 */

	}
	
	@Test
	public void createEmployee() throws Exception {
		EmployeeDTO mockemployee = new EmployeeDTO(1,"name","sdfs","adfa","af");
		
		ObjectMapper om = new ObjectMapper();
		
		String expected = om.writeValueAsString(mockemployee);
		
		Mockito.when(employeeService.createEmp(mockemployee)).thenReturn("Employee Created");

		mvc.perform(MockMvcRequestBuilders.post("/createEmployee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(expected))		
				.andExpect(status().isOk())
				.andDo(print());
		
		
	}

}
