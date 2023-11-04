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
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.services.IEtudiantService;

@ContextConfiguration(classes = {EtudiantRestController.class})
@ExtendWith(SpringExtension.class)
class EtudiantRestControllerDiffblueTest {
    @Autowired
    private EtudiantRestController etudiantRestController;

    @MockBean
    private IEtudiantService iEtudiantService;

    /**
     * Method under test: {@link EtudiantRestController#addEtudiant(Etudiant)}
     */
    @Test
    void testAddEtudiant() throws Exception {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");

        Etudiant etudiant = new Etudiant();
        etudiant.setContrats(new HashSet<>());
        etudiant.setDepartement(departement);
        etudiant.setEquipes(new ArrayList<>());
        etudiant.setIdEtudiant(1);
        etudiant.setNomE("Nom E");
        etudiant.setOp(Option.GAMIX);
        etudiant.setPrenomE("Prenom E");
        when(iEtudiantService.addEtudiant(Mockito.<Etudiant>any())).thenReturn(etudiant);

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");

        Etudiant etudiant2 = new Etudiant();
        etudiant2.setContrats(new HashSet<>());
        etudiant2.setDepartement(departement2);
        etudiant2.setEquipes(new ArrayList<>());
        etudiant2.setIdEtudiant(1);
        etudiant2.setNomE("Nom E");
        etudiant2.setOp(Option.GAMIX);
        etudiant2.setPrenomE("Prenom E");
        String content = (new ObjectMapper()).writeValueAsString(etudiant2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/etudiant/add-etudiant")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(etudiantRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"idEtudiant\":1,\"nomE\":\"Nom E\",\"prenomE\":\"Prenom E\",\"op\":\"GAMIX\"}"));
    }

    /**
     * Method under test: {@link EtudiantRestController#addEtudiantWithEquipeAndContract(Etudiant, Integer, Integer)}
     */
    @Test
    void testAddEtudiantWithEquipeAndContract() throws Exception {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");

        Etudiant etudiant = new Etudiant();
        etudiant.setContrats(new HashSet<>());
        etudiant.setDepartement(departement);
        etudiant.setEquipes(new ArrayList<>());
        etudiant.setIdEtudiant(1);
        etudiant.setNomE("Nom E");
        etudiant.setOp(Option.GAMIX);
        etudiant.setPrenomE("Prenom E");
        when(iEtudiantService.addAndAssignEtudiantToEquipeAndContract(Mockito.<Etudiant>any(), Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(etudiant);

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");

        Etudiant etudiant2 = new Etudiant();
        etudiant2.setContrats(new HashSet<>());
        etudiant2.setDepartement(departement2);
        etudiant2.setEquipes(new ArrayList<>());
        etudiant2.setIdEtudiant(1);
        etudiant2.setNomE("Nom E");
        etudiant2.setOp(Option.GAMIX);
        etudiant2.setPrenomE("Prenom E");
        String content = (new ObjectMapper()).writeValueAsString(etudiant2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/etudiant/add-assign-Etudiant/{idContrat}/{idEquipe}", 1, 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(etudiantRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"idEtudiant\":1,\"nomE\":\"Nom E\",\"prenomE\":\"Prenom E\",\"op\":\"GAMIX\"}"));
    }

    /**
     * Method under test: {@link EtudiantRestController#affecterEtudiantToDepartement(Integer, Integer)}
     */
    @Test
    void testAffecterEtudiantToDepartement() throws Exception {
        doNothing().when(iEtudiantService).assignEtudiantToDepartement(Mockito.<Integer>any(), Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/etudiant/affecter-etudiant-departement/{etudiantId}/{departementId}", 1, 1);
        MockMvcBuilders.standaloneSetup(etudiantRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link EtudiantRestController#affecterEtudiantToDepartement(Integer, Integer)}
     */
    @Test
    void testAffecterEtudiantToDepartement2() throws Exception {
        doNothing().when(iEtudiantService).assignEtudiantToDepartement(Mockito.<Integer>any(), Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/etudiant/affecter-etudiant-departement/{etudiantId}/{departementId}", 1, 1);
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(etudiantRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link EtudiantRestController#getEtudiants()}
     */
    @Test
    void testGetEtudiants() throws Exception {
        when(iEtudiantService.retrieveAllEtudiants()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/etudiant/retrieve-all-etudiants");
        MockMvcBuilders.standaloneSetup(etudiantRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EtudiantRestController#getEtudiants()}
     */
    @Test
    void testGetEtudiants2() throws Exception {
        when(iEtudiantService.retrieveAllEtudiants()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/etudiant/retrieve-all-etudiants");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(etudiantRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

