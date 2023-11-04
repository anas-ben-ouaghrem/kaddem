package tn.esprit.spring.kaddem.controllers;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.services.IContratService;

@ContextConfiguration(classes = {ContratRestController.class})
@ExtendWith(SpringExtension.class)
class ContratRestControllerDiffblueTest {
    @Autowired
    private ContratRestController contratRestController;

    @MockBean
    private IContratService iContratService;

    /**
     * Method under test: {@link ContratRestController#retrieveContrat(Integer)}
     */
    @Test
    void testRetrieveContrat() throws Exception {
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

        Contrat contrat = new Contrat();
        contrat.setArchive(true);
        contrat
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat.setEtudiant(etudiant);
        contrat.setIdContrat(1);
        contrat.setMontantContrat(2);
        contrat.setSpecialite(Specialite.IA);
        when(iContratService.retrieveContrat(Mockito.<Integer>any())).thenReturn(contrat);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/contrat/retrieve-contrat/{contrat-id}", 1);
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idContrat\":1,\"dateDebutContrat\":0,\"dateFinContrat\":0,\"specialite\":\"IA\",\"archive\":true,\"montantContrat"
                                        + "\":2,\"etudiant\":{\"idEtudiant\":1,\"nomE\":\"Nom E\",\"prenomE\":\"Prenom E\",\"op\":\"GAMIX\"}}"));
    }

    /**
     * Method under test: {@link ContratRestController#addContrat(Contrat)}
     */
    @Test
    void testAddContrat() throws Exception {
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

        Contrat contrat = new Contrat();
        contrat.setArchive(true);
        contrat.setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat.setEtudiant(etudiant);
        contrat.setIdContrat(1);
        contrat.setMontantContrat(2);
        contrat.setSpecialite(Specialite.IA);
        when(iContratService.addContrat(Mockito.<Contrat>any())).thenReturn(contrat);

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

        Contrat contrat2 = new Contrat();
        contrat2.setArchive(true);
        contrat2.setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setEtudiant(etudiant2);
        contrat2.setIdContrat(1);
        contrat2.setMontantContrat(2);
        contrat2.setSpecialite(Specialite.IA);
        String content = (new ObjectMapper()).writeValueAsString(contrat2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/contrat/add-contrat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idContrat\":1,\"dateDebutContrat\":0,\"dateFinContrat\":0,\"specialite\":\"IA\",\"archive\":true,\"montantContrat"
                                        + "\":2,\"etudiant\":{\"idEtudiant\":1,\"nomE\":\"Nom E\",\"prenomE\":\"Prenom E\",\"op\":\"GAMIX\"}}"));
    }

    /**
     * Method under test: {@link ContratRestController#removeContrat(Integer)}
     */
    @Test
    void testRemoveContrat() throws Exception {
        doNothing().when(iContratService).removeContrat(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/contrat/remove-contrat/{contrat-id}", 1);
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ContratRestController#removeContrat(Integer)}
     */
    @Test
    void testRemoveContrat2() throws Exception {
        doNothing().when(iContratService).removeContrat(Mockito.<Integer>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/contrat/remove-contrat/{contrat-id}", 1);
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ContratRestController#updateContrat(Contrat)}
     */
    @Test
    void testUpdateContrat() throws Exception {
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

        Contrat contrat = new Contrat();
        contrat.setArchive(true);
        contrat
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat.setEtudiant(etudiant);
        contrat.setIdContrat(1);
        contrat.setMontantContrat(2);
        contrat.setSpecialite(Specialite.IA);
        when(iContratService.updateContrat(Mockito.<Contrat>any())).thenReturn(contrat);

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

        Contrat contrat2 = new Contrat();
        contrat2.setArchive(true);
        contrat2
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setEtudiant(etudiant2);
        contrat2.setIdContrat(1);
        contrat2.setMontantContrat(2);
        contrat2.setSpecialite(Specialite.IA);
        String content = (new ObjectMapper()).writeValueAsString(contrat2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/contrat/update-contrat")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idContrat\":1,\"dateDebutContrat\":0,\"dateFinContrat\":0,\"specialite\":\"IA\",\"archive\":true,\"montantContrat"
                                        + "\":2,\"etudiant\":{\"idEtudiant\":1,\"nomE\":\"Nom E\",\"prenomE\":\"Prenom E\",\"op\":\"GAMIX\"}}"));
    }

    /**
     * Method under test: {@link ContratRestController#assignContratToEtudiant(Integer, String, String)}
     */
    @Test
    void testAssignContratToEtudiant() throws Exception {
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

        Contrat contrat = new Contrat();
        contrat.setArchive(true);
        contrat
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat.setEtudiant(etudiant);
        contrat.setIdContrat(1);
        contrat.setMontantContrat(2);
        contrat.setSpecialite(Specialite.IA);
        when(
                iContratService.affectContratToEtudiant(Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(contrat);
        MockHttpServletRequestBuilder putResult = MockMvcRequestBuilders.put("/contrat/assignContratToEtudiant/42/42/42");
        MockHttpServletRequestBuilder requestBuilder = putResult.param("idContrat", String.valueOf(1))
                .param("nomE", "foo")
                .param("prenomE", "foo");
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idContrat\":1,\"dateDebutContrat\":0,\"dateFinContrat\":0,\"specialite\":\"IA\",\"archive\":true,\"montantContrat"
                                        + "\":2,\"etudiant\":{\"idEtudiant\":1,\"nomE\":\"Nom E\",\"prenomE\":\"Prenom E\",\"op\":\"GAMIX\"}}"));
    }

    /**
     * Method under test: {@link ContratRestController#calculChiffreAffaireEntreDeuxDates(Date, Date)}
     */
    @Test
    void testCalculChiffreAffaireEntreDeuxDates() throws Exception {
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/contrat/calculChiffreAffaireEntreDeuxDate/{startDate}/{endDate}", fromResult,
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link ContratRestController#getContrats()}
     */
    @Test
    void testGetContrats() throws Exception {
        when(iContratService.retrieveAllContrats()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contrat/retrieve-all-contrats");
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ContratRestController#getContrats()}
     */
    @Test
    void testGetContrats2() throws Exception {
        when(iContratService.retrieveAllContrats()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contrat/retrieve-all-contrats");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ContratRestController#getnbContratsValides(Date, Date)}
     */
    @Test
    void testGetnbContratsValides() throws Exception {
        Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/contrat/getnbContratsValides/{startDate}/{endDate}", fromResult,
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link ContratRestController#majStatusContrat()}
     */
    @Test
    void testMajStatusContrat() throws Exception {
        doNothing().when(iContratService).retrieveAndUpdateStatusContrat();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/contrat/majStatusContrat");
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link ContratRestController#majStatusContrat()}
     */
    @Test
    void testMajStatusContrat2() throws Exception {
        doNothing().when(iContratService).retrieveAndUpdateStatusContrat();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/contrat/majStatusContrat");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(contratRestController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

