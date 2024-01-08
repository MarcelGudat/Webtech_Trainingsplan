package htwberlin.Webtech_Trainingsplan;

import htwberlin.Webtech_Trainingsplan.Uebung.Uebung;
import htwberlin.Webtech_Trainingsplan.Uebung.UebungController;
import htwberlin.Webtech_Trainingsplan.Uebung.UebungService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

    @WebMvcTest(UebungController.class)
    public class UebungsControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private UebungService service;

        @Test
        public void testGetRoute() throws Exception {
            // Test Daten und Service Mock
            Uebung u1 = new Uebung("Testname", "Testbeschreibung");
            u1.setId(42L);
            when(service.get(42L)).thenReturn(u1);

            // Erwartetes Ergebnis
            String expected =
            "{\"id\":42,\"name\":\"Testname\",\"beschreibung\":\"Testbeschreibung\"}";
            // Aufruf und Vergleich
            this.mockMvc.perform(get("/uebung/42"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().string(containsString(expected)));
        }
    }


