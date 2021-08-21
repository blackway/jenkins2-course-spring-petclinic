package org.springframework.samples.petclinic.web;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/business-config.xml", "classpath:spring/tools-config.xml", "classpath:spring/mvc-core-config.xml"})
@WebAppConfiguration
@ActiveProfiles("spring-data-jpa")
public class VetRestControllerTest2 {

	Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private VetRestController vetRestController;

    private MockMvc mockMvc;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.standaloneSetup(vetRestController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVetRestController() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowResourcesVetList() throws Exception {
        ResultActions actions = mockMvc.perform(get("/rest/vets.json").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
            actions.andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.vetList[0].id").value(1));
//		assertTrue(true);
//		fail("Not yet implemented");
	}

}
