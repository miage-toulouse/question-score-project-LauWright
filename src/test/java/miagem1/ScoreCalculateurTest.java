package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple questionAChoixMultiple;
    private ScoreCalculateur calculateur;

    @Before
    public void setUp() throws Exception {
        // given : un objet de type Score Calculateur et un objet de type QuestionChoix
        List<Integer> indicesBonnesReponses = new ArrayList<>();
        indicesBonnesReponses.add(1);
        indicesBonnesReponses.add(2);
        this.questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
        this.calculateur = new ScoreCalculateur();
    }


    @Test
    public void testCalculeScore() {
        //when : un étudiant fourni les indices ne correspondant pas à la bonne réponse
        List<Integer> indicesMauvaisesReponsesEtudiant = new ArrayList<>();
        indicesMauvaisesReponsesEtudiant.add(1);
        indicesMauvaisesReponsesEtudiant.add(4);
        //and : on demande le calcul du score
        Float resScore = this.calculateur.calculeScore(indicesMauvaisesReponsesEtudiant, this.questionAChoixMultiple);
        //then : le score obtenu est 100
        assertEquals(new Float(0f), resScore);

        //when : un étudiant fourni certains bons indices
        List<Integer> indicesBonnesReponsesEtudiant = new ArrayList<>();
        indicesBonnesReponsesEtudiant.add(2);
        indicesBonnesReponsesEtudiant.add(3);
        //and : on demande le calcul du score
        Float resScore1 = this.calculateur.calculeScore(indicesBonnesReponsesEtudiant, this.questionAChoixMultiple);
        //then : le score obtenu est 100
        assertEquals(Math.round(new Float(100f/3)*2* 100.0)/100.0, resScore1, 0.01);

        //when : un étudiant fourni certains bons indices
        List<Integer> indicesBonnesReponsesEtudiant1 = new ArrayList<>();
        indicesBonnesReponsesEtudiant1.add(2);
        indicesBonnesReponsesEtudiant1.add(3);
        indicesBonnesReponsesEtudiant1.add(5);
        //and : on demande le calcul du score
        Float resScore2 = this.calculateur.calculeScore(indicesBonnesReponsesEtudiant1, this.questionAChoixMultiple);
        //then : le score obtenu est 66,66
        assertEquals(Math.round(new Float(100f)* 100.0)/100.0, resScore2, 0.01);
    }
}