package tn.esprit.spring.kaddem.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;

@ContextConfiguration(classes = {EtudiantServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EtudiantServiceImplDiffblueTest {
    @MockBean
    private ContratRepository contratRepository;

    @MockBean
    private DepartementRepository departementRepository;

    @MockBean
    private EquipeRepository equipeRepository;

    @MockBean
    private EtudiantRepository etudiantRepository;

    @Autowired
    private EtudiantServiceImpl etudiantServiceImpl;

    /**
     * Method under test: {@link EtudiantServiceImpl#retrieveAllEtudiants()}
     */
    @Test
    void testRetrieveAllEtudiants() {
        when(etudiantRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.retrieveAllEtudiants());
        verify(etudiantRepository).findAll();
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#addEtudiant(Etudiant)}
     */
    @Test
    void testAddEtudiant() {
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
        when(etudiantRepository.save(Mockito.<Etudiant>any())).thenReturn(etudiant);

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");

        Etudiant e = new Etudiant();
        e.setContrats(new HashSet<>());
        e.setDepartement(departement2);
        e.setEquipes(new ArrayList<>());
        e.setIdEtudiant(1);
        e.setNomE("Nom E");
        e.setOp(Option.GAMIX);
        e.setPrenomE("Prenom E");
        Etudiant actualAddEtudiantResult = etudiantServiceImpl.addEtudiant(e);
        verify(etudiantRepository).save(Mockito.<Etudiant>any());
        assertSame(etudiant, actualAddEtudiantResult);
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#addEtudiant(Etudiant)}
     */
    @Test
    void testAddEtudiant2() {
        when(etudiantRepository.save(Mockito.<Etudiant>any())).thenThrow(new IllegalArgumentException("foo"));

        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");

        Etudiant e = new Etudiant();
        e.setContrats(new HashSet<>());
        e.setDepartement(departement);
        e.setEquipes(new ArrayList<>());
        e.setIdEtudiant(1);
        e.setNomE("Nom E");
        e.setOp(Option.GAMIX);
        e.setPrenomE("Prenom E");
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.addEtudiant(e));
        verify(etudiantRepository).save(Mockito.<Etudiant>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#updateEtudiant(Etudiant)}
     */
    @Test
    void testUpdateEtudiant() {
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
        when(etudiantRepository.save(Mockito.<Etudiant>any())).thenReturn(etudiant);

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");

        Etudiant e = new Etudiant();
        e.setContrats(new HashSet<>());
        e.setDepartement(departement2);
        e.setEquipes(new ArrayList<>());
        e.setIdEtudiant(1);
        e.setNomE("Nom E");
        e.setOp(Option.GAMIX);
        e.setPrenomE("Prenom E");
        Etudiant actualUpdateEtudiantResult = etudiantServiceImpl.updateEtudiant(e);
        verify(etudiantRepository).save(Mockito.<Etudiant>any());
        assertSame(etudiant, actualUpdateEtudiantResult);
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#updateEtudiant(Etudiant)}
     */
    @Test
    void testUpdateEtudiant2() {
        when(etudiantRepository.save(Mockito.<Etudiant>any())).thenThrow(new IllegalArgumentException("foo"));

        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");

        Etudiant e = new Etudiant();
        e.setContrats(new HashSet<>());
        e.setDepartement(departement);
        e.setEquipes(new ArrayList<>());
        e.setIdEtudiant(1);
        e.setNomE("Nom E");
        e.setOp(Option.GAMIX);
        e.setPrenomE("Prenom E");
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.updateEtudiant(e));
        verify(etudiantRepository).save(Mockito.<Etudiant>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#retrieveEtudiant(Integer)}
     */
    @Test
    void testRetrieveEtudiant() {
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
        Optional<Etudiant> ofResult = Optional.of(etudiant);
        when(etudiantRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Etudiant actualRetrieveEtudiantResult = etudiantServiceImpl.retrieveEtudiant(1);
        verify(etudiantRepository).findById(Mockito.<Integer>any());
        assertSame(etudiant, actualRetrieveEtudiantResult);
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#retrieveEtudiant(Integer)}
     */
    @Test
    void testRetrieveEtudiant2() {
        Optional<Etudiant> emptyResult = Optional.empty();
        when(etudiantRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.retrieveEtudiant(1));
        verify(etudiantRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#retrieveEtudiant(Integer)}
     */
    @Test
    void testRetrieveEtudiant3() {
        when(etudiantRepository.findById(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("Invalid etudiant Id:"));
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.retrieveEtudiant(1));
        verify(etudiantRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#removeEtudiant(Integer)}
     */
    @Test
    void testRemoveEtudiant() {
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
        Optional<Etudiant> ofResult = Optional.of(etudiant);
        doNothing().when(etudiantRepository).delete(Mockito.<Etudiant>any());
        when(etudiantRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        etudiantServiceImpl.removeEtudiant(1);
        verify(etudiantRepository).delete(Mockito.<Etudiant>any());
        verify(etudiantRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#removeEtudiant(Integer)}
     */
    @Test
    void testRemoveEtudiant2() {
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
        Optional<Etudiant> ofResult = Optional.of(etudiant);
        doThrow(new IllegalArgumentException("foo")).when(etudiantRepository).delete(Mockito.<Etudiant>any());
        when(etudiantRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.removeEtudiant(1));
        verify(etudiantRepository).delete(Mockito.<Etudiant>any());
        verify(etudiantRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#removeEtudiant(Integer)}
     */
    @Test
    void testRemoveEtudiant3() {
        Optional<Etudiant> emptyResult = Optional.empty();
        when(etudiantRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.removeEtudiant(1));
        verify(etudiantRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#assignEtudiantToDepartement(Integer, Integer)}
     */
    @Test
    void testAssignEtudiantToDepartement() {
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
        Optional<Etudiant> ofResult = Optional.of(etudiant);

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
        when(etudiantRepository.save(Mockito.<Etudiant>any())).thenReturn(etudiant2);
        when(etudiantRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Departement departement3 = new Departement();
        departement3.setEtudiants(new HashSet<>());
        departement3.setIdDepart(1);
        departement3.setNomDepart("Nom Depart");
        Optional<Departement> ofResult2 = Optional.of(departement3);
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult2);
        etudiantServiceImpl.assignEtudiantToDepartement(1, 1);
        verify(departementRepository).findById(Mockito.<Integer>any());
        verify(etudiantRepository).findById(Mockito.<Integer>any());
        verify(etudiantRepository).save(Mockito.<Etudiant>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#assignEtudiantToDepartement(Integer, Integer)}
     */
    @Test
    void testAssignEtudiantToDepartement2() {
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
        Optional<Etudiant> ofResult = Optional.of(etudiant);
        when(etudiantRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(departementRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.assignEtudiantToDepartement(1, 1));
        verify(departementRepository).findById(Mockito.<Integer>any());
        verify(etudiantRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#assignEtudiantToDepartement(Integer, Integer)}
     */
    @Test
    void testAssignEtudiantToDepartement3() {
        Optional<Etudiant> emptyResult = Optional.empty();
        when(etudiantRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        Optional<Departement> ofResult = Optional.of(departement);
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        etudiantServiceImpl.assignEtudiantToDepartement(1, 1);
        verify(departementRepository).findById(Mockito.<Integer>any());
        verify(etudiantRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#addAndAssignEtudiantToEquipeAndContract(Etudiant, Integer, Integer)}
     */
    @Test
    void testAddAndAssignEtudiantToEquipeAndContract() {
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
        Optional<Contrat> ofResult = Optional.of(contrat);
        when(contratRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        DetailEquipe detailEquipe = new DetailEquipe();
        detailEquipe.setEquipe(new Equipe());
        detailEquipe.setIdDetailEquipe(1);
        detailEquipe.setSalle(2);
        detailEquipe.setThematique("Thematique");

        Equipe equipe = new Equipe();
        equipe.setDetailEquipe(detailEquipe);
        equipe.setEtudiants(new HashSet<>());
        equipe.setIdEquipe(1);
        equipe.setNiveau(Niveau.JUNIOR);
        equipe.setNomEquipe("Nom Equipe");

        DetailEquipe detailEquipe2 = new DetailEquipe();
        detailEquipe2.setEquipe(equipe);
        detailEquipe2.setIdDetailEquipe(1);
        detailEquipe2.setSalle(2);
        detailEquipe2.setThematique("Thematique");

        Equipe equipe2 = new Equipe();
        equipe2.setDetailEquipe(detailEquipe2);
        equipe2.setEtudiants(new HashSet<>());
        equipe2.setIdEquipe(1);
        equipe2.setNiveau(Niveau.JUNIOR);
        equipe2.setNomEquipe("Nom Equipe");
        Optional<Equipe> ofResult2 = Optional.of(equipe2);
        when(equipeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult2);

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");

        Etudiant e = new Etudiant();
        e.setContrats(new HashSet<>());
        e.setDepartement(departement2);
        e.setEquipes(new ArrayList<>());
        e.setIdEtudiant(1);
        e.setNomE("Nom E");
        e.setOp(Option.GAMIX);
        e.setPrenomE("Prenom E");
        Etudiant actualAddAndAssignEtudiantToEquipeAndContractResult = etudiantServiceImpl
                .addAndAssignEtudiantToEquipeAndContract(e, 1, 1);
        verify(contratRepository).findById(Mockito.<Integer>any());
        verify(equipeRepository).findById(Mockito.<Integer>any());
        assertSame(e, actualAddAndAssignEtudiantToEquipeAndContractResult);
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#addAndAssignEtudiantToEquipeAndContract(Etudiant, Integer, Integer)}
     */
    @Test
    void testAddAndAssignEtudiantToEquipeAndContract2() {
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
        when(equipeRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");

        Etudiant e = new Etudiant();
        e.setContrats(new HashSet<>());
        e.setDepartement(departement2);
        e.setEquipes(new ArrayList<>());
        e.setIdEtudiant(1);
        e.setNomE("Nom E");
        e.setOp(Option.GAMIX);
        e.setPrenomE("Prenom E");
        assertThrows(IllegalArgumentException.class,
                () -> etudiantServiceImpl.addAndAssignEtudiantToEquipeAndContract(e, 1, 1));
        verify(contratRepository).findById(Mockito.<Integer>any());
        verify(equipeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#addAndAssignEtudiantToEquipeAndContract(Etudiant, Integer, Integer)}
     */
    @Test
    void testAddAndAssignEtudiantToEquipeAndContract3() {
        Optional<Contrat> emptyResult = Optional.empty();
        when(contratRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        DetailEquipe detailEquipe = new DetailEquipe();
        detailEquipe.setEquipe(new Equipe());
        detailEquipe.setIdDetailEquipe(1);
        detailEquipe.setSalle(2);
        detailEquipe.setThematique("Thematique");

        Equipe equipe = new Equipe();
        equipe.setDetailEquipe(detailEquipe);
        equipe.setEtudiants(new HashSet<>());
        equipe.setIdEquipe(1);
        equipe.setNiveau(Niveau.JUNIOR);
        equipe.setNomEquipe("Nom Equipe");

        DetailEquipe detailEquipe2 = new DetailEquipe();
        detailEquipe2.setEquipe(equipe);
        detailEquipe2.setIdDetailEquipe(1);
        detailEquipe2.setSalle(2);
        detailEquipe2.setThematique("Thematique");

        Equipe equipe2 = new Equipe();
        equipe2.setDetailEquipe(detailEquipe2);
        equipe2.setEtudiants(new HashSet<>());
        equipe2.setIdEquipe(1);
        equipe2.setNiveau(Niveau.JUNIOR);
        equipe2.setNomEquipe("Nom Equipe");
        Optional<Equipe> ofResult = Optional.of(equipe2);
        when(equipeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");

        Etudiant e = new Etudiant();
        e.setContrats(new HashSet<>());
        e.setDepartement(departement);
        e.setEquipes(new ArrayList<>());
        e.setIdEtudiant(1);
        e.setNomE("Nom E");
        e.setOp(Option.GAMIX);
        e.setPrenomE("Prenom E");
        Etudiant actualAddAndAssignEtudiantToEquipeAndContractResult = etudiantServiceImpl
                .addAndAssignEtudiantToEquipeAndContract(e, 1, 1);
        verify(contratRepository).findById(Mockito.<Integer>any());
        verify(equipeRepository).findById(Mockito.<Integer>any());
        assertSame(e, actualAddAndAssignEtudiantToEquipeAndContractResult);
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#addAndAssignEtudiantToEquipeAndContract(Etudiant, Integer, Integer)}
     */
    @Test
    void testAddAndAssignEtudiantToEquipeAndContract4() {
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
        Optional<Equipe> emptyResult = Optional.empty();
        when(equipeRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        Departement departement2 = new Departement();
        departement2.setEtudiants(new HashSet<>());
        departement2.setIdDepart(1);
        departement2.setNomDepart("Nom Depart");

        Etudiant e = new Etudiant();
        e.setContrats(new HashSet<>());
        e.setDepartement(departement2);
        e.setEquipes(new ArrayList<>());
        e.setIdEtudiant(1);
        e.setNomE("Nom E");
        e.setOp(Option.GAMIX);
        e.setPrenomE("Prenom E");
        Etudiant actualAddAndAssignEtudiantToEquipeAndContractResult = etudiantServiceImpl
                .addAndAssignEtudiantToEquipeAndContract(e, 1, 1);
        verify(contratRepository).findById(Mockito.<Integer>any());
        verify(equipeRepository).findById(Mockito.<Integer>any());
        assertSame(e, actualAddAndAssignEtudiantToEquipeAndContractResult);
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#getEtudiantsByDepartement(Integer)}
     */
    @Test
    void testGetEtudiantsByDepartement() {
        ArrayList<Etudiant> etudiantList = new ArrayList<>();
        when(etudiantRepository.findEtudiantsByDepartement_IdDepart(Mockito.<Integer>any())).thenReturn(etudiantList);
        List<Etudiant> actualEtudiantsByDepartement = etudiantServiceImpl.getEtudiantsByDepartement(1);
        verify(etudiantRepository).findEtudiantsByDepartement_IdDepart(Mockito.<Integer>any());
        assertTrue(actualEtudiantsByDepartement.isEmpty());
        assertSame(etudiantList, actualEtudiantsByDepartement);
    }

    /**
     * Method under test: {@link EtudiantServiceImpl#getEtudiantsByDepartement(Integer)}
     */
    @Test
    void testGetEtudiantsByDepartement2() {
        when(etudiantRepository.findEtudiantsByDepartement_IdDepart(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> etudiantServiceImpl.getEtudiantsByDepartement(1));
        verify(etudiantRepository).findEtudiantsByDepartement_IdDepart(Mockito.<Integer>any());
    }
}

