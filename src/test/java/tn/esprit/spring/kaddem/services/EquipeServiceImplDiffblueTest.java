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
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;

@ContextConfiguration(classes = {EquipeServiceImpl.class})
@ExtendWith(SpringExtension.class)
class EquipeServiceImplDiffblueTest {
    @MockBean
    private EquipeRepository equipeRepository;

    @Autowired
    private EquipeServiceImpl equipeServiceImpl;

    /**
     * Method under test: {@link EquipeServiceImpl#retrieveAllEquipes()}
     */
    @Test
    void testRetrieveAllEquipes() {
        when(equipeRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> equipeServiceImpl.retrieveAllEquipes());
        verify(equipeRepository).findAll();
    }

    /**
     * Method under test: {@link EquipeServiceImpl#addEquipe(Equipe)}
     */
    @Test
    void testAddEquipe() {
        Equipe equipe = new Equipe();
        equipe.setDetailEquipe(new DetailEquipe());
        equipe.setEtudiants(new HashSet<>());
        equipe.setIdEquipe(1);
        equipe.setNiveau(Niveau.JUNIOR);
        equipe.setNomEquipe("Nom Equipe");

        DetailEquipe detailEquipe = new DetailEquipe();
        detailEquipe.setEquipe(equipe);
        detailEquipe.setIdDetailEquipe(1);
        detailEquipe.setSalle(2);
        detailEquipe.setThematique("Thematique");

        Equipe equipe2 = new Equipe();
        equipe2.setDetailEquipe(detailEquipe);
        equipe2.setEtudiants(new HashSet<>());
        equipe2.setIdEquipe(1);
        equipe2.setNiveau(Niveau.JUNIOR);
        equipe2.setNomEquipe("Nom Equipe");

        DetailEquipe detailEquipe2 = new DetailEquipe();
        detailEquipe2.setEquipe(equipe2);
        detailEquipe2.setIdDetailEquipe(1);
        detailEquipe2.setSalle(2);
        detailEquipe2.setThematique("Thematique");

        Equipe equipe3 = new Equipe();
        equipe3.setDetailEquipe(detailEquipe2);
        equipe3.setEtudiants(new HashSet<>());
        equipe3.setIdEquipe(1);
        equipe3.setNiveau(Niveau.JUNIOR);
        equipe3.setNomEquipe("Nom Equipe");
        when(equipeRepository.save(Mockito.<Equipe>any())).thenReturn(equipe3);

        DetailEquipe detailEquipe3 = new DetailEquipe();
        detailEquipe3.setEquipe(new Equipe());
        detailEquipe3.setIdDetailEquipe(1);
        detailEquipe3.setSalle(2);
        detailEquipe3.setThematique("Thematique");

        Equipe equipe4 = new Equipe();
        equipe4.setDetailEquipe(detailEquipe3);
        equipe4.setEtudiants(new HashSet<>());
        equipe4.setIdEquipe(1);
        equipe4.setNiveau(Niveau.JUNIOR);
        equipe4.setNomEquipe("Nom Equipe");

        DetailEquipe detailEquipe4 = new DetailEquipe();
        detailEquipe4.setEquipe(equipe4);
        detailEquipe4.setIdDetailEquipe(1);
        detailEquipe4.setSalle(2);
        detailEquipe4.setThematique("Thematique");

        Equipe e = new Equipe();
        e.setDetailEquipe(detailEquipe4);
        e.setEtudiants(new HashSet<>());
        e.setIdEquipe(1);
        e.setNiveau(Niveau.JUNIOR);
        e.setNomEquipe("Nom Equipe");
        Equipe actualAddEquipeResult = equipeServiceImpl.addEquipe(e);
        verify(equipeRepository).save(Mockito.<Equipe>any());
        assertSame(equipe3, actualAddEquipeResult);
    }

    /**
     * Method under test: {@link EquipeServiceImpl#addEquipe(Equipe)}
     */
    @Test
    void testAddEquipe2() {
        when(equipeRepository.save(Mockito.<Equipe>any())).thenThrow(new IllegalArgumentException("foo"));

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

        Equipe e = new Equipe();
        e.setDetailEquipe(detailEquipe2);
        e.setEtudiants(new HashSet<>());
        e.setIdEquipe(1);
        e.setNiveau(Niveau.JUNIOR);
        e.setNomEquipe("Nom Equipe");
        assertThrows(IllegalArgumentException.class, () -> equipeServiceImpl.addEquipe(e));
        verify(equipeRepository).save(Mockito.<Equipe>any());
    }

    /**
     * Method under test: {@link EquipeServiceImpl#deleteEquipe(Integer)}
     */
    @Test
    void testDeleteEquipe() {
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
        doNothing().when(equipeRepository).delete(Mockito.<Equipe>any());
        when(equipeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        equipeServiceImpl.deleteEquipe(1);
        verify(equipeRepository).delete(Mockito.<Equipe>any());
        verify(equipeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EquipeServiceImpl#deleteEquipe(Integer)}
     */
    @Test
    void testDeleteEquipe2() {
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
        doThrow(new IllegalArgumentException("foo")).when(equipeRepository).delete(Mockito.<Equipe>any());
        when(equipeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class, () -> equipeServiceImpl.deleteEquipe(1));
        verify(equipeRepository).delete(Mockito.<Equipe>any());
        verify(equipeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EquipeServiceImpl#deleteEquipe(Integer)}
     */
    @Test
    void testDeleteEquipe3() {
        Optional<Equipe> emptyResult = Optional.empty();
        when(equipeRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> equipeServiceImpl.deleteEquipe(1));
        verify(equipeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EquipeServiceImpl#retrieveEquipe(Integer)}
     */
    @Test
    void testRetrieveEquipe() {
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
        Equipe actualRetrieveEquipeResult = equipeServiceImpl.retrieveEquipe(1);
        verify(equipeRepository).findById(Mockito.<Integer>any());
        assertSame(equipe2, actualRetrieveEquipeResult);
    }

    /**
     * Method under test: {@link EquipeServiceImpl#retrieveEquipe(Integer)}
     */
    @Test
    void testRetrieveEquipe2() {
        Optional<Equipe> emptyResult = Optional.empty();
        when(equipeRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);
        assertThrows(IllegalArgumentException.class, () -> equipeServiceImpl.retrieveEquipe(1));
        verify(equipeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EquipeServiceImpl#retrieveEquipe(Integer)}
     */
    @Test
    void testRetrieveEquipe3() {
        when(equipeRepository.findById(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("Invalid equipe Id:"));
        assertThrows(IllegalArgumentException.class, () -> equipeServiceImpl.retrieveEquipe(1));
        verify(equipeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link EquipeServiceImpl#updateEquipe(Equipe)}
     */
    @Test
    void testUpdateEquipe() {
        Equipe equipe = new Equipe();
        equipe.setDetailEquipe(new DetailEquipe());
        equipe.setEtudiants(new HashSet<>());
        equipe.setIdEquipe(1);
        equipe.setNiveau(Niveau.JUNIOR);
        equipe.setNomEquipe("Nom Equipe");

        DetailEquipe detailEquipe = new DetailEquipe();
        detailEquipe.setEquipe(equipe);
        detailEquipe.setIdDetailEquipe(1);
        detailEquipe.setSalle(2);
        detailEquipe.setThematique("Thematique");

        Equipe equipe2 = new Equipe();
        equipe2.setDetailEquipe(detailEquipe);
        equipe2.setEtudiants(new HashSet<>());
        equipe2.setIdEquipe(1);
        equipe2.setNiveau(Niveau.JUNIOR);
        equipe2.setNomEquipe("Nom Equipe");

        DetailEquipe detailEquipe2 = new DetailEquipe();
        detailEquipe2.setEquipe(equipe2);
        detailEquipe2.setIdDetailEquipe(1);
        detailEquipe2.setSalle(2);
        detailEquipe2.setThematique("Thematique");

        Equipe equipe3 = new Equipe();
        equipe3.setDetailEquipe(detailEquipe2);
        equipe3.setEtudiants(new HashSet<>());
        equipe3.setIdEquipe(1);
        equipe3.setNiveau(Niveau.JUNIOR);
        equipe3.setNomEquipe("Nom Equipe");
        when(equipeRepository.save(Mockito.<Equipe>any())).thenReturn(equipe3);

        DetailEquipe detailEquipe3 = new DetailEquipe();
        detailEquipe3.setEquipe(new Equipe());
        detailEquipe3.setIdDetailEquipe(1);
        detailEquipe3.setSalle(2);
        detailEquipe3.setThematique("Thematique");

        Equipe equipe4 = new Equipe();
        equipe4.setDetailEquipe(detailEquipe3);
        equipe4.setEtudiants(new HashSet<>());
        equipe4.setIdEquipe(1);
        equipe4.setNiveau(Niveau.JUNIOR);
        equipe4.setNomEquipe("Nom Equipe");

        DetailEquipe detailEquipe4 = new DetailEquipe();
        detailEquipe4.setEquipe(equipe4);
        detailEquipe4.setIdDetailEquipe(1);
        detailEquipe4.setSalle(2);
        detailEquipe4.setThematique("Thematique");

        Equipe e = new Equipe();
        e.setDetailEquipe(detailEquipe4);
        e.setEtudiants(new HashSet<>());
        e.setIdEquipe(1);
        e.setNiveau(Niveau.JUNIOR);
        e.setNomEquipe("Nom Equipe");
        Equipe actualUpdateEquipeResult = equipeServiceImpl.updateEquipe(e);
        verify(equipeRepository).save(Mockito.<Equipe>any());
        assertSame(equipe3, actualUpdateEquipeResult);
    }

    /**
     * Method under test: {@link EquipeServiceImpl#updateEquipe(Equipe)}
     */
    @Test
    void testUpdateEquipe2() {
        when(equipeRepository.save(Mockito.<Equipe>any())).thenThrow(new IllegalArgumentException("foo"));

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

        Equipe e = new Equipe();
        e.setDetailEquipe(detailEquipe2);
        e.setEtudiants(new HashSet<>());
        e.setIdEquipe(1);
        e.setNiveau(Niveau.JUNIOR);
        e.setNomEquipe("Nom Equipe");
        assertThrows(IllegalArgumentException.class, () -> equipeServiceImpl.updateEquipe(e));
        verify(equipeRepository).save(Mockito.<Equipe>any());
    }

    /**
     * Method under test: {@link EquipeServiceImpl#evoluerEquipes()}
     */
    @Test
    void testEvoluerEquipes() {
        when(equipeRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> equipeServiceImpl.evoluerEquipes());
        verify(equipeRepository).findAll();
    }
}

