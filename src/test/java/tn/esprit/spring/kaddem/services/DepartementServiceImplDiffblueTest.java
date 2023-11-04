package tn.esprit.spring.kaddem.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.kaddem.entities.Departement;
import tn.esprit.spring.kaddem.repositories.DepartementRepository;

@ContextConfiguration(classes = {DepartementServiceImpl.class})
@ExtendWith(SpringExtension.class)
class DepartementServiceImplDiffblueTest {
    @MockBean
    private DepartementRepository departementRepository;

    @Autowired
    private DepartementServiceImpl departementServiceImpl;

    /**
     * Method under test: {@link DepartementServiceImpl#retrieveAllDepartements()}
     */
    @Test
    void testRetrieveAllDepartements() {
        when(departementRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> departementServiceImpl.retrieveAllDepartements());
        verify(departementRepository).findAll();
    }

    /**
     * Method under test: {@link DepartementServiceImpl#addDepartement(Departement)}
     */
    @Test
    void testAddDepartement() {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        when(departementRepository.save(Mockito.<Departement>any())).thenReturn(departement);

        Departement d = new Departement();
        d.setEtudiants(new HashSet<>());
        d.setIdDepart(1);
        d.setNomDepart("Nom Depart");
        Departement actualAddDepartementResult = departementServiceImpl.addDepartement(d);
        verify(departementRepository).save(Mockito.<Departement>any());
        assertSame(departement, actualAddDepartementResult);
    }

    /**
     * Method under test: {@link DepartementServiceImpl#addDepartement(Departement)}
     */
    @Test
    void testAddDepartement2() {
        when(departementRepository.save(Mockito.<Departement>any())).thenThrow(new IllegalArgumentException("foo"));

        Departement d = new Departement();
        d.setEtudiants(new HashSet<>());
        d.setIdDepart(1);
        d.setNomDepart("Nom Depart");
        assertThrows(IllegalArgumentException.class, () -> departementServiceImpl.addDepartement(d));
        verify(departementRepository).save(Mockito.<Departement>any());
    }

    /**
     * Method under test: {@link DepartementServiceImpl#updateDepartement(Departement)}
     */
    @Test
    void testUpdateDepartement() {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        when(departementRepository.save(Mockito.<Departement>any())).thenReturn(departement);

        Departement d = new Departement();
        d.setEtudiants(new HashSet<>());
        d.setIdDepart(1);
        d.setNomDepart("Nom Depart");
        Departement actualUpdateDepartementResult = departementServiceImpl.updateDepartement(d);
        verify(departementRepository).save(Mockito.<Departement>any());
        assertSame(departement, actualUpdateDepartementResult);
    }

    /**
     * Method under test: {@link DepartementServiceImpl#updateDepartement(Departement)}
     */
    @Test
    void testUpdateDepartement2() {
        when(departementRepository.save(Mockito.<Departement>any())).thenThrow(new IllegalArgumentException("foo"));

        Departement d = new Departement();
        d.setEtudiants(new HashSet<>());
        d.setIdDepart(1);
        d.setNomDepart("Nom Depart");
        assertThrows(IllegalArgumentException.class, () -> departementServiceImpl.updateDepartement(d));
        verify(departementRepository).save(Mockito.<Departement>any());
    }

    /**
     * Method under test: {@link DepartementServiceImpl#retrieveDepartement(Integer)}
     */
    @Test
    void testRetrieveDepartement() {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        Optional<Departement> ofResult = Optional.of(departement);
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Departement actualRetrieveDepartementResult = departementServiceImpl.retrieveDepartement(1);
        verify(departementRepository).findById(Mockito.<Integer>any());
        assertSame(departement, actualRetrieveDepartementResult);
    }

    /**
     * Method under test: {@link DepartementServiceImpl#retrieveDepartement(Integer)}
     */
    @Test
    void testRetrieveDepartement2() {
        Optional<Departement> emptyResult = Optional.empty();
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> departementServiceImpl.retrieveDepartement(1));
        verify(departementRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link DepartementServiceImpl#retrieveDepartement(Integer)}
     */
    @Test
    void testRetrieveDepartement3() {
        when(departementRepository.findById(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("Invalid departement Id:"));
        assertThrows(IllegalArgumentException.class, () -> departementServiceImpl.retrieveDepartement(1));
        verify(departementRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link DepartementServiceImpl#deleteDepartement(Integer)}
     */
    @Test
    void testDeleteDepartement() {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        Optional<Departement> ofResult = Optional.of(departement);
        doNothing().when(departementRepository).delete(Mockito.<Departement>any());
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        departementServiceImpl.deleteDepartement(1);
        verify(departementRepository).delete(Mockito.<Departement>any());
        verify(departementRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link DepartementServiceImpl#deleteDepartement(Integer)}
     */
    @Test
    void testDeleteDepartement2() {
        Departement departement = new Departement();
        departement.setEtudiants(new HashSet<>());
        departement.setIdDepart(1);
        departement.setNomDepart("Nom Depart");
        Optional<Departement> ofResult = Optional.of(departement);
        doThrow(new IllegalArgumentException("foo")).when(departementRepository).delete(Mockito.<Departement>any());
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class, () -> departementServiceImpl.deleteDepartement(1));
        verify(departementRepository).delete(Mockito.<Departement>any());
        verify(departementRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link DepartementServiceImpl#deleteDepartement(Integer)}
     */
    @Test
    void testDeleteDepartement3() {
        Optional<Departement> emptyResult = Optional.empty();
        when(departementRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> departementServiceImpl.deleteDepartement(1));
        verify(departementRepository).findById(Mockito.<Integer>any());
    }
}

