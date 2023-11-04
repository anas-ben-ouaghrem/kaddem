package tn.esprit.spring.kaddem.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

@ContextConfiguration(classes = {ContratServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ContratServiceImplDiffblueTest {
    @MockBean
    private ContratRepository contratRepository;

    @Autowired
    private ContratServiceImpl contratServiceImpl;

    @MockBean
    private EtudiantRepository etudiantRepository;

    /**
     * Method under test: {@link ContratServiceImpl#retrieveAllContrats()}
     */
    @Test
    void testRetrieveAllContrats() {
        ArrayList<Contrat> contratList = new ArrayList<>();
        when(contratRepository.findAll()).thenReturn(contratList);
        List<Contrat> actualRetrieveAllContratsResult = contratServiceImpl.retrieveAllContrats();
        verify(contratRepository).findAll();
        assertTrue(actualRetrieveAllContratsResult.isEmpty());
        assertSame(contratList, actualRetrieveAllContratsResult);
    }

    /**
     * Method under test: {@link ContratServiceImpl#updateContrat(Contrat)}
     */
    @Test
    void testUpdateContrat() {
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
        when(contratRepository.save(Mockito.<Contrat>any())).thenReturn(contrat);

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

        Contrat ce = new Contrat();
        ce.setArchive(true);
        ce.setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        ce.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        ce.setEtudiant(etudiant2);
        ce.setIdContrat(1);
        ce.setMontantContrat(2);
        ce.setSpecialite(Specialite.IA);
        Contrat actualUpdateContratResult = contratServiceImpl.updateContrat(ce);
        verify(contratRepository).save(Mockito.<Contrat>any());
        assertSame(contrat, actualUpdateContratResult);
    }

    /**
     * Method under test: {@link ContratServiceImpl#addContrat(Contrat)}
     */
    @Test
    void testAddContrat() {
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
        when(contratRepository.save(Mockito.<Contrat>any())).thenReturn(contrat);

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

        Contrat ce = new Contrat();
        ce.setArchive(true);
        ce.setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        ce.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        ce.setEtudiant(etudiant2);
        ce.setIdContrat(1);
        ce.setMontantContrat(2);
        ce.setSpecialite(Specialite.IA);
        Contrat actualAddContratResult = contratServiceImpl.addContrat(ce);
        verify(contratRepository).save(Mockito.<Contrat>any());
        assertSame(contrat, actualAddContratResult);
    }

    /**
     * Method under test: {@link ContratServiceImpl#retrieveContrat(Integer)}
     */
    @Test
    void testRetrieveContrat() {
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
        Optional<Contrat> ofResult = Optional.of(contrat);
        when(contratRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Contrat actualRetrieveContratResult = contratServiceImpl.retrieveContrat(1);
        verify(contratRepository).findById(Mockito.<Integer>any());
        assertSame(contrat, actualRetrieveContratResult);
    }

    /**
     * Method under test: {@link ContratServiceImpl#removeContrat(Integer)}
     */
    @Test
    void testRemoveContrat() {
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
        Optional<Contrat> ofResult = Optional.of(contrat);
        when(contratRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        doNothing().when(contratRepository).delete(Mockito.<Contrat>any());
        contratServiceImpl.removeContrat(1);
        verify(contratRepository).delete(Mockito.<Contrat>any());
        verify(contratRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ContratServiceImpl#affectContratToEtudiant(Integer, String, String)}
     */
    @Test
    void testAffectContratToEtudiant() {
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
        when(contratRepository.save(Mockito.<Contrat>any())).thenReturn(contrat2);
        when(contratRepository.findByIdContrat(Mockito.<Integer>any())).thenReturn(contrat);

        Departement departement3 = new Departement();
        departement3.setEtudiants(new HashSet<>());
        departement3.setIdDepart(1);
        departement3.setNomDepart("Nom Depart");

        Etudiant etudiant3 = new Etudiant();
        etudiant3.setContrats(new HashSet<>());
        etudiant3.setDepartement(departement3);
        etudiant3.setEquipes(new ArrayList<>());
        etudiant3.setIdEtudiant(1);
        etudiant3.setNomE("Nom E");
        etudiant3.setOp(Option.GAMIX);
        etudiant3.setPrenomE("Prenom E");
        when(etudiantRepository.findByNomEAndPrenomE(Mockito.<String>any(), Mockito.<String>any())).thenReturn(etudiant3);
        Contrat actualAffectContratToEtudiantResult = contratServiceImpl.affectContratToEtudiant(1, "Nom E", "Prenom E");
        verify(contratRepository).save(Mockito.<Contrat>any());
        verify(contratRepository).findByIdContrat(Mockito.<Integer>any());
        verify(etudiantRepository).findByNomEAndPrenomE(Mockito.<String>any(), Mockito.<String>any());
        assertEquals(etudiant2, actualAffectContratToEtudiantResult.getEtudiant());
        assertSame(contrat, actualAffectContratToEtudiantResult);
    }

    /**
     * Method under test: {@link ContratServiceImpl#affectContratToEtudiant(Integer, String, String)}
     */
    @Test
    void testAffectContratToEtudiant2() {
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
        when(contratRepository.save(Mockito.<Contrat>any())).thenReturn(contrat2);
        when(contratRepository.findByIdContrat(Mockito.<Integer>any())).thenReturn(contrat);

        Departement departement3 = new Departement();
        departement3.setEtudiants(new HashSet<>());
        departement3.setIdDepart(1);
        departement3.setNomDepart("Nom Depart");

        Etudiant etudiant3 = new Etudiant();
        etudiant3.setContrats(new HashSet<>());
        etudiant3.setDepartement(departement3);
        etudiant3.setEquipes(new ArrayList<>());
        etudiant3.setIdEtudiant(1);
        etudiant3.setNomE("Nom E");
        etudiant3.setOp(Option.GAMIX);
        etudiant3.setPrenomE("Prenom E");

        Contrat contrat3 = new Contrat();
        contrat3.setArchive(true);
        contrat3
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat3.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat3.setEtudiant(etudiant3);
        contrat3.setIdContrat(1);
        contrat3.setMontantContrat(2);
        contrat3.setSpecialite(Specialite.IA);

        HashSet<Contrat> contrats = new HashSet<>();
        contrats.add(contrat3);

        Departement departement4 = new Departement();
        departement4.setEtudiants(new HashSet<>());
        departement4.setIdDepart(1);
        departement4.setNomDepart("Nom Depart");

        Etudiant etudiant4 = new Etudiant();
        etudiant4.setContrats(contrats);
        etudiant4.setDepartement(departement4);
        etudiant4.setEquipes(new ArrayList<>());
        etudiant4.setIdEtudiant(1);
        etudiant4.setNomE("Nom E");
        etudiant4.setOp(Option.GAMIX);
        etudiant4.setPrenomE("Prenom E");
        when(etudiantRepository.findByNomEAndPrenomE(Mockito.<String>any(), Mockito.<String>any())).thenReturn(etudiant4);
        Contrat actualAffectContratToEtudiantResult = contratServiceImpl.affectContratToEtudiant(1, "Nom E", "Prenom E");
        verify(contratRepository).save(Mockito.<Contrat>any());
        verify(contratRepository).findByIdContrat(Mockito.<Integer>any());
        verify(etudiantRepository).findByNomEAndPrenomE(Mockito.<String>any(), Mockito.<String>any());
        assertSame(contrat, actualAffectContratToEtudiantResult);
        assertSame(etudiant4, actualAffectContratToEtudiantResult.getEtudiant());
    }

    /**
     * Method under test: {@link ContratServiceImpl#affectContratToEtudiant(Integer, String, String)}
     */
    @Test
    void testAffectContratToEtudiant3() {
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
        when(contratRepository.save(Mockito.<Contrat>any())).thenReturn(contrat2);
        when(contratRepository.findByIdContrat(Mockito.<Integer>any())).thenReturn(contrat);

        Departement departement3 = new Departement();
        departement3.setEtudiants(new HashSet<>());
        departement3.setIdDepart(1);
        departement3.setNomDepart("Nom Depart");

        Etudiant etudiant3 = new Etudiant();
        etudiant3.setContrats(new HashSet<>());
        etudiant3.setDepartement(departement3);
        etudiant3.setEquipes(new ArrayList<>());
        etudiant3.setIdEtudiant(1);
        etudiant3.setNomE("Nom E");
        etudiant3.setOp(Option.GAMIX);
        etudiant3.setPrenomE("Prenom E");

        Contrat contrat3 = new Contrat();
        contrat3.setArchive(true);
        contrat3
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat3.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat3.setEtudiant(etudiant3);
        contrat3.setIdContrat(1);
        contrat3.setMontantContrat(2);
        contrat3.setSpecialite(Specialite.IA);

        Departement departement4 = new Departement();
        departement4.setEtudiants(new HashSet<>());
        departement4.setIdDepart(2);
        departement4.setNomDepart("tn.esprit.spring.kaddem.entities.Departement");

        Etudiant etudiant4 = new Etudiant();
        etudiant4.setContrats(new HashSet<>());
        etudiant4.setDepartement(departement4);
        etudiant4.setEquipes(new ArrayList<>());
        etudiant4.setIdEtudiant(2);
        etudiant4.setNomE("tn.esprit.spring.kaddem.entities.Etudiant");
        etudiant4.setOp(Option.SE);
        etudiant4.setPrenomE("tn.esprit.spring.kaddem.entities.Etudiant");

        Contrat contrat4 = new Contrat();
        contrat4.setArchive(false);
        contrat4
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat4.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat4.setEtudiant(etudiant4);
        contrat4.setIdContrat(2);
        contrat4.setMontantContrat(1);
        contrat4.setSpecialite(Specialite.RESEAUX);

        HashSet<Contrat> contrats = new HashSet<>();
        contrats.add(contrat4);
        contrats.add(contrat3);

        Departement departement5 = new Departement();
        departement5.setEtudiants(new HashSet<>());
        departement5.setIdDepart(1);
        departement5.setNomDepart("Nom Depart");

        Etudiant etudiant5 = new Etudiant();
        etudiant5.setContrats(contrats);
        etudiant5.setDepartement(departement5);
        etudiant5.setEquipes(new ArrayList<>());
        etudiant5.setIdEtudiant(1);
        etudiant5.setNomE("Nom E");
        etudiant5.setOp(Option.GAMIX);
        etudiant5.setPrenomE("Prenom E");
        when(etudiantRepository.findByNomEAndPrenomE(Mockito.<String>any(), Mockito.<String>any())).thenReturn(etudiant5);
        Contrat actualAffectContratToEtudiantResult = contratServiceImpl.affectContratToEtudiant(1, "Nom E", "Prenom E");
        verify(contratRepository).save(Mockito.<Contrat>any());
        verify(contratRepository).findByIdContrat(Mockito.<Integer>any());
        verify(etudiantRepository).findByNomEAndPrenomE(Mockito.<String>any(), Mockito.<String>any());
        assertSame(contrat, actualAffectContratToEtudiantResult);
        assertSame(etudiant5, actualAffectContratToEtudiantResult.getEtudiant());
    }

    /**
     * Method under test: {@link ContratServiceImpl#nbContratsValides(Date, Date)}
     */
    @Test
    void testNbContratsValides() {
        when(contratRepository.getnbContratsValides(Mockito.<Date>any(), Mockito.<Date>any())).thenReturn(1);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        Integer actualNbContratsValidesResult = contratServiceImpl.nbContratsValides(startDate,
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        verify(contratRepository).getnbContratsValides(Mockito.<Date>any(), Mockito.<Date>any());
        assertEquals(1, actualNbContratsValidesResult.intValue());
    }

    /**
     * Method under test: {@link ContratServiceImpl#retrieveAndUpdateStatusContrat()}
     */
    @Test
    void testRetrieveAndUpdateStatusContrat() {
        when(contratRepository.findAll()).thenReturn(new ArrayList<>());
        contratServiceImpl.retrieveAndUpdateStatusContrat();
        verify(contratRepository).findAll();
    }

    /**
     * Method under test: {@link ContratServiceImpl#retrieveAndUpdateStatusContrat()}
     */
    @Test
    void testRetrieveAndUpdateStatusContrat2() {
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

        ArrayList<Contrat> contratList = new ArrayList<>();
        contratList.add(contrat);
        when(contratRepository.findAll()).thenReturn(contratList);
        contratServiceImpl.retrieveAndUpdateStatusContrat();
        verify(contratRepository).findAll();
    }

    /**
     * Method under test: {@link ContratServiceImpl#retrieveAndUpdateStatusContrat()}
     */
    @Test
    void testRetrieveAndUpdateStatusContrat3() {
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

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(2);
        departement2.setNomDepart("tn.esprit.spring.kaddem.entities.Departement");

        Etudiant etudiant2 = new Etudiant();
        etudiant2.setContrats(new HashSet<>());
        etudiant2.setDepartement(departement2);
        etudiant2.setEquipes(new ArrayList<>());
        etudiant2.setIdEtudiant(2);
        etudiant2.setNomE("tn.esprit.spring.kaddem.entities.Etudiant");
        etudiant2.setOp(Option.SE);
        etudiant2.setPrenomE("tn.esprit.spring.kaddem.entities.Etudiant");

        Contrat contrat2 = new Contrat();
        contrat2.setArchive(false);
        contrat2
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setEtudiant(etudiant2);
        contrat2.setIdContrat(2);
        contrat2.setMontantContrat(1);
        contrat2.setSpecialite(Specialite.RESEAUX);

        ArrayList<Contrat> contratList = new ArrayList<>();
        contratList.add(contrat2);
        contratList.add(contrat);
        when(contratRepository.findAll()).thenReturn(contratList);
        contratServiceImpl.retrieveAndUpdateStatusContrat();
        verify(contratRepository).findAll();
    }

    /**
     * Method under test: {@link ContratServiceImpl#getChiffreAffaireEntreDeuxDates(Date, Date)}
     */
    @Test
    void testGetChiffreAffaireEntreDeuxDates() {
        when(contratRepository.findAll()).thenReturn(new ArrayList<>());
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        float actualChiffreAffaireEntreDeuxDates = contratServiceImpl.getChiffreAffaireEntreDeuxDates(startDate,
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        verify(contratRepository).findAll();
        assertEquals(0.0f, actualChiffreAffaireEntreDeuxDates);
    }

    /**
     * Method under test: {@link ContratServiceImpl#getChiffreAffaireEntreDeuxDates(Date, Date)}
     */
    @Test
    void testGetChiffreAffaireEntreDeuxDates2() {
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

        ArrayList<Contrat> contratList = new ArrayList<>();
        contratList.add(contrat);
        when(contratRepository.findAll()).thenReturn(contratList);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        float actualChiffreAffaireEntreDeuxDates = contratServiceImpl.getChiffreAffaireEntreDeuxDates(startDate,
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        verify(contratRepository).findAll();
        assertEquals(0.0f, actualChiffreAffaireEntreDeuxDates);
    }

    /**
     * Method under test: {@link ContratServiceImpl#getChiffreAffaireEntreDeuxDates(Date, Date)}
     */
    @Test
    void testGetChiffreAffaireEntreDeuxDates3() {
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

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(2);
        departement2.setNomDepart("tn.esprit.spring.kaddem.entities.Departement");

        Etudiant etudiant2 = new Etudiant();
        etudiant2.setContrats(new HashSet<>());
        etudiant2.setDepartement(departement2);
        etudiant2.setEquipes(new ArrayList<>());
        etudiant2.setIdEtudiant(2);
        etudiant2.setNomE("tn.esprit.spring.kaddem.entities.Etudiant");
        etudiant2.setOp(Option.SE);
        etudiant2.setPrenomE("tn.esprit.spring.kaddem.entities.Etudiant");

        Contrat contrat2 = new Contrat();
        contrat2.setArchive(false);
        contrat2
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setEtudiant(etudiant2);
        contrat2.setIdContrat(2);
        contrat2.setMontantContrat(1);
        contrat2.setSpecialite(Specialite.RESEAUX);

        ArrayList<Contrat> contratList = new ArrayList<>();
        contratList.add(contrat2);
        contratList.add(contrat);
        when(contratRepository.findAll()).thenReturn(contratList);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        float actualChiffreAffaireEntreDeuxDates = contratServiceImpl.getChiffreAffaireEntreDeuxDates(startDate,
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        verify(contratRepository).findAll();
        assertEquals(0.0f, actualChiffreAffaireEntreDeuxDates);
    }

    /**
     * Method under test: {@link ContratServiceImpl#getChiffreAffaireEntreDeuxDates(Date, Date)}
     */
    @Test
    void testGetChiffreAffaireEntreDeuxDates4() {
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

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(2);
        departement2.setNomDepart("tn.esprit.spring.kaddem.entities.Departement");

        Etudiant etudiant2 = new Etudiant();
        etudiant2.setContrats(new HashSet<>());
        etudiant2.setDepartement(departement2);
        etudiant2.setEquipes(new ArrayList<>());
        etudiant2.setIdEtudiant(2);
        etudiant2.setNomE("tn.esprit.spring.kaddem.entities.Etudiant");
        etudiant2.setOp(Option.SE);
        etudiant2.setPrenomE("tn.esprit.spring.kaddem.entities.Etudiant");

        Contrat contrat2 = new Contrat();
        contrat2.setArchive(false);
        contrat2
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat2.setEtudiant(etudiant2);
        contrat2.setIdContrat(2);
        contrat2.setMontantContrat(1);
        contrat2.setSpecialite(Specialite.RESEAUX);

        Departement departement3 = new Departement();
        departement3.setEtudiants(new HashSet<>());
        departement3.setIdDepart(3);
        departement3.setNomDepart("42");

        Etudiant etudiant3 = new Etudiant();
        etudiant3.setContrats(new HashSet<>());
        etudiant3.setDepartement(departement3);
        etudiant3.setEquipes(new ArrayList<>());
        etudiant3.setIdEtudiant(3);
        etudiant3.setNomE("42");
        etudiant3.setOp(Option.SIM);
        etudiant3.setPrenomE("42");

        Contrat contrat3 = new Contrat();
        contrat3.setArchive(true);
        contrat3
                .setDateDebutContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat3.setDateFinContrat(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        contrat3.setEtudiant(etudiant3);
        contrat3.setIdContrat(3);
        contrat3.setMontantContrat(0);
        contrat3.setSpecialite(Specialite.CLOUD);

        ArrayList<Contrat> contratList = new ArrayList<>();
        contratList.add(contrat3);
        contratList.add(contrat2);
        contratList.add(contrat);
        when(contratRepository.findAll()).thenReturn(contratList);
        Date startDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        float actualChiffreAffaireEntreDeuxDates = contratServiceImpl.getChiffreAffaireEntreDeuxDates(startDate,
                Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        verify(contratRepository).findAll();
        assertEquals(0.0f, actualChiffreAffaireEntreDeuxDates);
    }
}

