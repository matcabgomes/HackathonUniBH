/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo2;

/**
 *
 * @author hackathon
 */
public class ValidacaoSenha {

    public static void main(String[] args) {

        String senha = "2222222aB22";
        Boolean tamanhoValidado = false;
        Boolean letraNumValidado = false;
        Boolean pontosEspacoAcentoValidado = false;

        tamanhoValidado = validaTamanho(senha);
        if (!tamanhoValidado) {
            System.out.println("Senha invalida!");
            System.exit(0);
        }
        letraNumValidado = validaLetraNum(senha);
        if (!letraNumValidado) {
            System.out.println("Senha invalida2!");
            System.exit(0);
        }
        pontosEspacoAcentoValidado = validaPontoEspacoAcento(senha);
        if (!pontosEspacoAcentoValidado) {
            System.out.println("Senha invalida3!");
            System.exit(0);
        }
        System.out.println("uhul");
    }

    private static Boolean validaTamanho(String senha) {
        int tamanho = senha.length();
        if (tamanho >= 6 && tamanho <= 32) {
            return true;
        }
        return false;
    }

    private static Boolean validaLetraNum(String senha) {
        Boolean validaMaius = false;
        Boolean validaMinu = false;
        Boolean validaNum = false;

        for (int i = 0; i < senha.length(); i++) {

            char ch = senha.charAt(i); 

            if (Character.isLowerCase(ch)) {
                validaMinu = true;
            }

            if (Character.isUpperCase(ch)) {
                validaMaius = true;
            }

            if (Character.isDigit(ch)) {
                validaNum = true;
            }

        }

        if (validaMaius && validaMinu && validaNum) {
            return true;
        }
        return false;
    }

    private static Boolean validaPontoEspacoAcento(String senha) {
        Boolean invalidaEspaco = false;
        Boolean invalidaAcento = false;
        Boolean invalidaPonto = false;

        for (int i = 0; i < senha.length(); i++) {

            char ch = senha.charAt(i); // here i= 1,2,3......

            if (Character.isWhitespace(ch)) {
                invalidaEspaco = true;
            }

            if (Character.isDefined(ch)) {
                invalidaAcento = true;
            }

            if (Character.isValidCodePoint(ch)) {
                invalidaPonto = true;
            }

        }

        if (invalidaAcento && invalidaPonto && invalidaEspaco) {
            return false;
        }
        return true;

    }
}
