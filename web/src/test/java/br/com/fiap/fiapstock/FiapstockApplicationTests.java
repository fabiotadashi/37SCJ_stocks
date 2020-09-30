package br.com.fiap.fiapstock;

import br.com.fiap.fiapstock.dto.UserCreateDTO;
import org.assertj.core.internal.bytebuddy.matcher.ElementMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.match.JsonPathRequestMatchers;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.datasource.url=jdbc:h2:mem:database")
class FiapstockApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void createUser() throws Exception {
		// Execução e Verificação
		String json = "{\"username\":\"Fabio\", \"password\":\"123456\"}";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/users")
					.content(json)
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
		)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.username", Matchers.is("Fabio")));
	}

}
