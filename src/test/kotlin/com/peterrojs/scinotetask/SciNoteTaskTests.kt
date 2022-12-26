package com.peterrojs.scinotetask

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc

@AutoConfigureMockMvc
@SpringBootTest(classes = [SciNoteTaskTests::class])
class SciNoteTaskTests(@Autowired val mockMvc: MockMvc) {

	@MockBean
	lateinit var plateController: PlateController

	@Test
	fun contextLoads() {
		assertThat(plateController).isNotNull
	}

}
