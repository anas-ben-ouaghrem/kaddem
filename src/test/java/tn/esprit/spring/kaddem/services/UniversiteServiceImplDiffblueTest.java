package tn.esprit.spring.kaddem.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;

@ContextConfiguration(classes = {UniversiteServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UniversiteServiceImplDiffblueTest {
    @MockBean
    private DepartementRepository departementRepository;

    @MockBean
    private UniversiteRepository universiteRepository;

    @Autowired
    private UniversiteServiceImpl universiteServiceImpl;

    /**
     * Method under test: {@link UniversiteServiceImpl#retrieveAllUniversites()}
     */
    @Test
    void testRetrieveAllUniversites() {
        when(universiteRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.retrieveAllUniversites());
        verify(universiteRepository).findAll();
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#addUniversite(Universite)}
     */
    @Test
    void testAddUniversite() {
        Universite universite = new Universite();
        universite.setDepartements(new HashSet<>());
        universite.setIdUniv(1);
        universite.setNomUniv("Nom Univ");
        when(universiteRepository.save(Mockito.<Universite>any())).thenReturn(universite);

        Universite u = new Universite();
        u.setDepartements(new HashSet<>());
        u.setIdUniv(1);
        u.setNomUniv("Nom Univ");
        Universite actualAddUniversiteResult = universiteServiceImpl.addUniversite(u);
        verify(universiteRepository).save(Mockito.<Universite>any());
        assertSame(universite, actualAddUniversiteResult);
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#addUniversite(Universite)}
     */
    @Test
    void testAddUniversite2() {
        when(universiteRepository.save(Mockito.<Universite>any())).thenThrow(new IllegalArgumentException("foo"));

        Universite u = new Universite();
        u.setDepartements(new HashSet<>());
        u.setIdUniv(1);
        u.setNomUniv("Nom Univ");
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.addUniversite(u));
        verify(universiteRepository).save(Mockito.<Universite>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#updateUniversite(Universite)}
     */
    @Test
    void testUpdateUniversite() {
        Universite universite = new Universite();
        universite.setDepartements(new HashSet<>());
        universite.setIdUniv(1);
        universite.setNomUniv("Nom Univ");
        when(universiteRepository.save(Mockito.<Universite>any())).thenReturn(universite);

        Universite u = new Universite();
        u.setDepartements(new HashSet<>());
        u.setIdUniv(1);
        u.setNomUniv("Nom Univ");
        Universite actualUpdateUniversiteResult = universiteServiceImpl.updateUniversite(u);
        verify(universiteRepository).save(Mockito.<Universite>any());
        assertSame(universite, actualUpdateUniversiteResult);
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#updateUniversite(Universite)}
     */
    @Test
    void testUpdateUniversite2() {
        when(universiteRepository.save(Mockito.<Universite>any())).thenThrow(new IllegalArgumentException("foo"));

        Universite u = new Universite();
        u.setDepartements(new HashSet<>());
        u.setIdUniv(1);
        u.setNomUniv("Nom Univ");
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.updateUniversite(u));
        verify(universiteRepository).save(Mockito.<Universite>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#retrieveUniversite(Integer)}
     */
    @Test
    void testRetrieveUniversite() {
        Universite universite = new Universite();
        universite.setDepartements(new HashSet<>());
        universite.setIdUniv(1);
        universite.setNomUniv("Nom Univ");
        Optional<Universite> ofResult = Optional.of(universite);
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Universite actualRetrieveUniversiteResult = universiteServiceImpl.retrieveUniversite(1);
        verify(universiteRepository).findById(Mockito.<Integer>any());
        assertSame(universite, actualRetrieveUniversiteResult);
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#retrieveUniversite(Integer)}
     */
    @Test
    void testRetrieveUniversite2() {
        Optional<Universite> emptyResult = Optional.empty();
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.retrieveUniversite(1));
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#retrieveUniversite(Integer)}
     */
    @Test
    void testRetrieveUniversite3() {
        when(universiteRepository.findById(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("Invalid universite Id:"));
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.retrieveUniversite(1));
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#deleteUniversite(Integer)}
     */
    @Test
    void testDeleteUniversite() {
        Universite universite = new Universite();
        universite.setDepartements(new HashSet<>());
        universite.setIdUniv(1);
        universite.setNomUniv("Nom Univ");
        Optional<Universite> ofResult = Optional.of(universite);
        doNothing().when(universiteRepository).delete(Mockito.<Universite>any());
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        universiteServiceImpl.deleteUniversite(1);
        verify(universiteRepository).delete(Mockito.<Universite>any());
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#deleteUniversite(Integer)}
     */
    @Test
    void testDeleteUniversite2() {
        Universite universite = new Universite();
        universite.setDepartements(new HashSet<>());
        universite.setIdUniv(1);
        universite.setNomUniv("Nom Univ");
        Optional<Universite> ofResult = Optional.of(universite);
        doThrow(new IllegalArgumentException("foo")).when(universiteRepository).delete(Mockito.<Universite>any());
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.deleteUniversite(1));
        verify(universiteRepository).delete(Mockito.<Universite>any());
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#deleteUniversite(Integer)}
     */
    @Test
    void testDeleteUniversite3() {
        Optional<Universite> emptyResult = Optional.empty();
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.deleteUniversite(1));
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#assignUniversiteToDepartement(Integer, Integer)}
     */
    @Test
    void testAssignUniversiteToDepartement() {
        Universite universite = new Universite();
        universite.setDepartements(new HashSet<>());
        universite.setIdUniv(1);
        universite.setNomUniv("Nom Univ");
        Optional<Universite> ofResult = Optional.of(universite);

        Universite universite2 = new Universite();
        universite2.setDepartements(new HashSet<>());
        universite2.setIdUniv(1);
        universite2.setNomUniv("Nom Univ");
        when(universiteRepository.save(Mockito.<Universite>any())).thenReturn(universite2);
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        Optional<Departement> ofResult2 = Optional.of(departement);
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult2);
        universiteServiceImpl.assignUniversiteToDepartement(1, 1);
        verify(departementRepository).findById(Mockito.<Integer>any());
        verify(universiteRepository).findById(Mockito.<Integer>any());
        verify(universiteRepository).save(Mockito.<Universite>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#assignUniversiteToDepartement(Integer, Integer)}
     */
    @Test
    void testAssignUniversiteToDepartement2() {
        Universite universite = new Universite();
        universite.setDepartements(new HashSet<>());
        universite.setIdUniv(1);
        universite.setNomUniv("Nom Univ");
        Optional<Universite> ofResult = Optional.of(universite);
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(departementRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.assignUniversiteToDepartement(1, 1));
        verify(departementRepository).findById(Mockito.<Integer>any());
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#assignUniversiteToDepartement(Integer, Integer)}
     */
    @Test
    void testAssignUniversiteToDepartement3() {
        Optional<Universite> emptyResult = Optional.empty();
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        Optional<Departement> ofResult = Optional.of(departement);
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        universiteServiceImpl.assignUniversiteToDepartement(1, 1);
        verify(departementRepository).findById(Mockito.<Integer>any());
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#retrieveDepartementsByUniversite(Integer)}
     */
    @Test
    void testRetrieveDepartementsByUniversite() {
        Universite universite = new Universite();
        HashSet<Departement> departements = new HashSet<>();
        universite.setDepartements(departements);
        universite.setIdUniv(1);
        universite.setNomUniv("Nom Univ");
        Optional<Universite> ofResult = Optional.of(universite);
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Set<Departement> actualRetrieveDepartementsByUniversiteResult = universiteServiceImpl
                .retrieveDepartementsByUniversite(1);
        verify(universiteRepository).findById(Mockito.<Integer>any());
        assertTrue(actualRetrieveDepartementsByUniversiteResult.isEmpty());
        assertSame(departements, actualRetrieveDepartementsByUniversiteResult);
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#retrieveDepartementsByUniversite(Integer)}
     */
    @Test
    void testRetrieveDepartementsByUniversite2() {
        Optional<Universite> emptyResult = Optional.empty();
        when(universiteRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.retrieveDepartementsByUniversite(1));
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UniversiteServiceImpl#retrieveDepartementsByUniversite(Integer)}
     */
    @Test
    void testRetrieveDepartementsByUniversite3() {
        when(universiteRepository.findById(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("Invalid universite Id:"));
        assertThrows(IllegalArgumentException.class, () -> universiteServiceImpl.retrieveDepartementsByUniversite(1));
        verify(universiteRepository).findById(Mockito.<Integer>any());
    }
}

