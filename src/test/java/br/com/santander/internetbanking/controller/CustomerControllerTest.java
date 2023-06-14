

import br.com.santander.internetbanking.customer.CustomerController;
import br.com.santander.internetbanking.customer.CustomerRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EntityManager entityManager;

    @Test
    public void testCreateCustomer() throws Exception {
        CustomerRequest request = new CustomerRequest("Anderson Camacho", true, BigDecimal.valueOf(100.0), "123456789");

        request.setName("Anderson Camacho");


        String jsonRequest = objectMapper.writeValueAsString(request);

        ResultActions result = mockMvc.perform(post("/api/v1/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest));

        result.andExpect(status().isOk());

    }
}
