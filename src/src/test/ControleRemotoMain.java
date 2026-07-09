package test;


import domain.ControleRemoto;

public class ControleRemotoMain {
    public static void main(String[] args) {
        ControleRemoto controle = new ControleRemoto();
        controle.ligar();
        controle.play();
        controle.maisVolume();
        controle.maisVolume();
        controle.maisVolume();

    }
}
