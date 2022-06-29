package com.meli.validation.lambda.mutant;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.security.NoSuchProviderException;
import java.util.logging.Logger;

public final class IsMutant implements RequestHandler<String[], String> {
    Logger logger = Logger.getLogger(String.valueOf(IsMutant.class));

    public static Boolean isMutant(String[] dna) throws NoSuchProviderException {
        boolean genMutant = false;
        String[] sequenceMutant = {"AAAA", "CCCC", "GGGG", "TTTTT"};

        for (String value : dna) {
            for (String sequence : sequenceMutant) {

                if (value.contains(sequence))
                    genMutant = true;
            }
        }
        return genMutant;
    }
    public String handleRequest(String[] dna, Context context) {

        logger.info("event: " + dna.toString());

        try {
            return isMutant(dna).toString();
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }
}
