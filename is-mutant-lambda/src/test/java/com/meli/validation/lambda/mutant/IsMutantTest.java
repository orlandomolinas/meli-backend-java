package com.meli.validation.lambda.mutant;

import com.flextrade.jfixture.JFixture;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IsMutantTest {
    private JFixture fixture = new JFixture();

    protected JFixture getFixture() {
        return fixture;
    }

    @Test
    public void handleRequest() {


        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};


        IsMutant IsMutant = new IsMutant();

        // When

        // Then

        String response = IsMutant.handleRequest(dna, null);

        System.out.println("response test: " + response);
        // assertions

        assertNotNull(response);
        assertEquals("true", response);
    }

    @Test
    public void handleRequestBad() {


        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CXCCTA", "TCACTG"};


        IsMutant IsMutant = new IsMutant();

        // When

        // Then

        String response = IsMutant.handleRequest(dna, null);

        System.out.println("response test: " + response);
        // assertions

        assertNotNull(response);
        assertEquals("false", response);
    }
    @Test
    public void handleRequestNull() {


        String[] dna = {};


        IsMutant IsMutant = new IsMutant();

        // When

        // Then

        String response = IsMutant.handleRequest(dna, null);

        System.out.println("response test: " + response);
        // assertions

        assertNotNull(response);
        assertEquals("false", response);
    }

}
