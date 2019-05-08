package com.game.feignclient;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
public class FeignClientApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private ServiceClient serviceClient;

	@Test
	public void shouldReturnListOfBlocks_whenFetchBlocksCalled() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/fetchBlocks");
		mvc.perform(builder).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnBlock_whenvalidBlocksIsPassed() throws Exception {

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/fetchPlayers");
		mvc.perform(builder).andExpect(status().isOk());
	}

}
