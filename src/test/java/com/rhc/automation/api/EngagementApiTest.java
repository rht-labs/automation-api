package com.rhc.automation.api;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rhc.automation.BaseTest;
import com.rhc.automation.model.Engagement;
import com.rhc.automation.service.CustomerService;
import com.rhc.automation.service.OpenShiftService;
import com.rhc.automation.service.UserService;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Tests just the APIContoller which is a very limited class. It just calls the APIService. We can still validate that it correctly gets the expected return
 * from a mocked api-service and that the json mapper works as expected.
 * @author kmcanoy
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value=EngagementsApiController.class)
public class EngagementApiTest extends BaseTest {

    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private ApiService apiService;
    
    @MockBean private CustomerService customerService;
    @MockBean private OpenShiftService openShiftService;
    @MockBean private UserService userService;
    
    @Test
    public void testGetEngagementValid() throws Exception {
        Engagement e = this.getJsonData(Engagement.class, "/engagement.json");
        String json = this.getJsonString(Engagement.class, "/engagement.json"); 
        
        given(this.apiService.get(1L, Engagement.class)).willReturn(new ResponseEntity<>(e, HttpStatus.OK));
        
        this.mvc.perform(get("/engagements/1").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(content().json(json, false));
        
        
    }
    
    @Test 
    public void testGetEngagement404() throws Exception {
        
        given(this.apiService.get(2L, Engagement.class)).willReturn(new ResponseEntity<Engagement>(HttpStatus.NOT_FOUND));
        
        this.mvc.perform(get("/engagements/2").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
    }
    
    @Test
    public void testGetEnagements() throws Exception {
        Engagement e = this.getJsonData(Engagement.class, "/engagement.json");
        String json = this.getJsonString(Engagement.class, "/engagement.json"); 
        
        List<Engagement> engagementList = new ArrayList<>();
        engagementList.add(e);
        
        given(this.apiService.getList(10, 0L, Engagement.class)).willReturn(engagementList);
        
        this.mvc.perform(get("/engagements").param("offset", "0").param("size", "10")).andExpect(status().isOk()).andExpect(content().json("[" + json + "]", false));
    }
    
    @Test
    public void testAddEngagement() throws Exception {
        String json = this.getJsonString(Engagement.class, "/engagement.json");
        
        given(this.apiService.add(Mockito.any())).willReturn(new ResponseEntity<Void>(HttpStatus.CREATED));
        
        this.mvc.perform(post("/engagements").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
    }
}
