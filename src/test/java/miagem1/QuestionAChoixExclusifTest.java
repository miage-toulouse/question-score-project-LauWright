/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miagem1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author laure
 */
public class QuestionAChoixExclusifTest {
    
    private QuestionAChoixExclusif question;
    
    @Before
    public void setUp() throws Exception {
        // given : un objet de type QuestionAChoixExclusif
        question = new QuestionAChoixExclusif("L'année 2016 est une année bissextile. 1. Vrai, 2. Faux", 1);
        
    }
    
    @Test
    public void testGetEnonce() {
        // when : on demande l'ennoncé de la question
        String enonce = question.getEnonce();
        //then: l'ennoncé est non null 
        assertNotNull(enonce);
        //and : l'ennoncé est bien celui fourni à la construction
        assertEquals("L'année 2016 est une année bissextile. 1. Vrai, 2. Faux", enonce);
    }

    @Test
    public void testGetScoreForIndice() {
        //when : un étudiant fourni l'indice correspondant à la bonne réponse
        int indiceEtudiant = 1;
        //and : on demande le calcul du score
        Float resScore = question.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 100
        assertEquals(new Float(100f), resScore);
       
        //when : un étudiant fourni l'indice correspondant à la mauvaise réponse
        indiceEtudiant = 2;
        //and : on demande le calcul du score
        resScore = question.getScoreForIndice(indiceEtudiant);
        //then : le score obtenu est 100
        assertEquals(new Float(0f), resScore);
    }
    
}
