package br.com.coradini.flowable.example.services;

import org.springframework.stereotype.Service;

@Service
public class VerifiyApproveSituationService {

    public boolean verifyApṕroved(String articleName) {
        System.out.println("Verificando Aprovacao do artigo: "+ articleName);

        return true;
    }
}
