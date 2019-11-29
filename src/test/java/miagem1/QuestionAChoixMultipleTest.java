package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;

    @Before
    public void setUp() throws Exception {
        // given : un objet de type QuestionAChoixMultiple
        List<Integer> indicesBonnesReponses = new ArrayList<>();
        indicesBonnesReponses.add(1);
        indicesBonnesReponses.add(2);
        this.question = new QuestionAChoixMultiple("L'année 2016 est une année bissextile. 1. Vrai, 2. Faux 3.lala 4.lili", indicesBonnesReponses);
    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'ennoncé de la question
        String enonce = question.getEnonce();
        //then: l'ennoncé est non null
        assertNotNull(enonce);
        //and : l'ennoncé est bien celui fourni à la construction
        assertEquals("L'année 2016 est une année bissextile. 1. Vrai, 2. Faux 3.lala 4.lili", enonce);
    }

    @Test
    public void testGetScoreForIndice() {
        //when : un étudiant fourni l'indice correspondant à la bonne réponse
        int indiceEtudiant = 1;
        //and : on demande le calcul du score
        Float resScore = question.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 100
        assertEquals(new Float(100f/2), resScore);

        //when : un étudiant fourni l'indice correspondant à la mauvaise réponse
        indiceEtudiant = 3;
        //and : on demande le calcul du score
        resScore = question.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 100
        assertEquals(new Float(0f), resScore);
    }
}