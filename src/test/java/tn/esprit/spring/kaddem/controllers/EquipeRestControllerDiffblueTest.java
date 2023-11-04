package tn.esprit.spring.kaddem.controllers;

import java.util.HashSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;

class EquipeRestControllerDiffblueTest {
    /**
     * Method under test: {@link EquipeRestController#getEquipes()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetEquipes() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "tn.esprit.spring.kaddem.services.IEquipeService.retrieveAllEquipes()" because "this.equipeService" is null
        //       at tn.esprit.spring.kaddem.controllers.EquipeRestController.getEquipes(EquipeRestController.java:20)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:670)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:779)
        //   See https://diff.blue/R013 to resolve this issue.

        (new EquipeRestController()).getEquipes();
    }

    /**
     * Method under test: {@link EquipeRestController#retrieveEquipe(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRetrieveEquipe() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "tn.esprit.spring.kaddem.services.IEquipeService.retrieveEquipe(java.lang.Integer)" because "this.equipeService" is null
        //       at tn.esprit.spring.kaddem.controllers.EquipeRestController.retrieveEquipe(EquipeRestController.java:26)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:670)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:779)
        //   See https://diff.blue/R013 to resolve this issue.

        (new EquipeRestController()).retrieveEquipe(1);
    }

    /**
     * Method under test: {@link EquipeRestController#addEquipe(Equipe)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddEquipe() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "tn.esprit.spring.kaddem.services.IEquipeService.addEquipe(tn.esprit.spring.kaddem.entities.Equipe)" because "this.equipeService" is null
        //       at tn.esprit.spring.kaddem.controllers.EquipeRestController.addEquipe(EquipeRestController.java:32)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:696)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:779)
        //   See https://diff.blue/R013 to resolve this issue.

        EquipeRestController equipeRestController = new EquipeRestController();

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

        Equipe e = new Equipe();
        e.setDetailEquipe(detailEquipe2);
        e.setEtudiants(new HashSet<>());
        e.setIdEquipe(1);
        e.setNiveau(Niveau.JUNIOR);
        e.setNomEquipe("Nom Equipe");
        equipeRestController.addEquipe(e);
    }

    /**
     * Method under test: {@link EquipeRestController#removeEquipe(Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRemoveEquipe() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "tn.esprit.spring.kaddem.services.IEquipeService.deleteEquipe(java.lang.Integer)" because "this.equipeService" is null
        //       at tn.esprit.spring.kaddem.controllers.EquipeRestController.removeEquipe(EquipeRestController.java:38)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:702)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:779)
        //   See https://diff.blue/R013 to resolve this issue.

        (new EquipeRestController()).removeEquipe(1);
    }

    /**
     * Method under test: {@link EquipeRestController#updateEtudiant(Equipe)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateEtudiant() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "tn.esprit.spring.kaddem.services.IEquipeService.updateEquipe(tn.esprit.spring.kaddem.entities.Equipe)" because "this.equipeService" is null
        //       at tn.esprit.spring.kaddem.controllers.EquipeRestController.updateEtudiant(EquipeRestController.java:44)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:699)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:779)
        //   See https://diff.blue/R013 to resolve this issue.

        EquipeRestController equipeRestController = new EquipeRestController();

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

        Equipe e = new Equipe();
        e.setDetailEquipe(detailEquipe2);
        e.setEtudiants(new HashSet<>());
        e.setIdEquipe(1);
        e.setNiveau(Niveau.JUNIOR);
        e.setNomEquipe("Nom Equipe");
        equipeRestController.updateEtudiant(e);
    }

    /**
     * Method under test: {@link EquipeRestController#faireEvoluerEquipes()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testFaireEvoluerEquipes() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "tn.esprit.spring.kaddem.services.IEquipeService.evoluerEquipes()" because "this.equipeService" is null
        //       at tn.esprit.spring.kaddem.controllers.EquipeRestController.faireEvoluerEquipes(EquipeRestController.java:50)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:699)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:779)
        //   See https://diff.blue/R013 to resolve this issue.

        (new EquipeRestController()).faireEvoluerEquipes();
    }
}

