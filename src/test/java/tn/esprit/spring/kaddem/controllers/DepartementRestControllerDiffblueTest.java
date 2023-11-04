package tn.esprit.spring.kaddem.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.services.IDepartementService;

@ContextConfiguration(classes = {DepartementRestController.class})
@ExtendWith(SpringExtension.class)
class DepartementRestControllerDiffblueTest {
    @Autowired
    private DepartementRestController departementRestController;

    @MockBean
    private IDepartementService iDepartementService;

    /**
     * Method under test: {@link DepartementRestController#retrieveDepartement(Integer)}
     */
    @Test
    void testRetrieveDepartement() throws Exception {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        when(iDepartementService.retrieveDepartement(Mockito.<Integer>any())).thenReturn(departement);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/departement/retrieve-departement/{departement-id}", 1);
        MockMvcBuilders.standaloneSetup(departementRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"idDepart\":1,\"nomDepart\":\"Nom Depart\"}"));
    }

    /**
     * Method under test: {@link DepartementRestController#addDepartement(Departement)}
     */
    @Test
    void testAddDepartement() throws Exception {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        when(iDepartementService.addDepartement(Mockito.<Departement>any())).thenReturn(departement);

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");
        String content = (new ObjectMapper()).writeValueAsString(departement2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/departement/add-departement")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(departementRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"idDepart\":1,\"nomDepart\":\"Nom Depart\"}"));
    }

    /**
     * Method under test: {@link DepartementRestController#updateDepartement(Departement)}
     */
    @Test
    void testUpdateDepartement() throws Exception {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        when(iDepartementService.updateDepartement(Mockito.<Departement>any())).thenReturn(departement);

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");
        String content = (new ObjectMapper()).writeValueAsString(departement2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/departement/update-departement")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(departementRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"idDepart\":1,\"nomDepart\":\"Nom Depart\"}"));
    }

    /**
     * Method under test: {@link DepartementRestController#getDepartements()}
     */
    @Test
    void testGetDepartements() throws Exception {
        when(iDepartementService.retrieveAllDepartements()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/departement/retrieve-all-departements");
        MockMvcBuilders.standaloneSetup(departementRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DepartementRestController#getDepartements()}
     */
    @Test
    void testGetDepartements2() throws Exception {
        when(iDepartementService.retrieveAllDepartements()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/departement/retrieve-all-departements");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(departementRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link DepartementRestController#removeDepartement(Integer)}
     */
    @Test
    void testRemoveDepartement() throws Exception {
        doNothing().when(iDepartementService).deleteDepartement(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/departement/remove-departement/{departement-id}", 1);
        MockMvcBuilders.standaloneSetup(departementRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link DepartementRestController#removeDepartement(Integer)}
     */
    @Test
    void testRemoveDepartement2() throws Exception {
        doNothing().when(iDepartementService).deleteDepartement(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/departement/remove-departement/{departement-id}", 1);
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(departementRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

