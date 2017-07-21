/*package com.stats.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stats.controller.StatisticsController;
import com.stats.domain.Transaction;
import com.stats.service.TransactionService;

public class StatisticsControllerUnitTest {
	
	private MockMvc mockMvc;

    @Mock
    private TransactionService trans_service;

    @InjectMocks
    private StatisticsController statsController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(statsController)
                .build();
    }
    
    @Test
    public void save_Transaction() throws Exception {
        Transaction Trans = new Transaction();
        

        when(userService.exists(user)).thenReturn(false);
        doNothing().when(userService).create(user);

        mockMvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(trans_service)))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", containsString("http://localhost/users/")));

        verify(userService, times(1)).exists(user);
        verify(userService, times(1)).create(user);
        verifyNoMoreInteractions(userService);
    }

}
*/