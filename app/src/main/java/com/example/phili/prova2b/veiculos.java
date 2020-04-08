package com.example.phili.prova2b;

public class veiculos {
    Double preco;
    String Marc;
    String Camb;
    String Combust;
    String TipoVeic;
    Integer Kmtg;
    String TipoAnunciante;

    public void insere (Double p,
                        String TA,
            String Ma,
            String Cb,
            String Com,
            String TV,
            Integer Km){
        preco = p;
        Marc = Ma;
        Camb = Cb;
        Combust = Com;
        TipoVeic = TV;
        Kmtg = Km;
        TipoAnunciante = TA;
    }
}
