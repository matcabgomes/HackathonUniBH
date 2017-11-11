/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulo1;

/**
 *
 * @author Matheus Gomes Silva, Wilson Queiroz Rocha
 */
public class ModuloUm {

    public static void main(String[] args) {

        String teste = "AAAAAABCCCCf";
        String result;

        result = encapsulaRepetidas(teste);
        System.out.println(result);

    }

    private static String encapsulaRepetidas(String texto) {
        String inicio = null;
        String aux = null;
        String resultado = "";
        int cont = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (i == 0) {
                inicio = texto.substring(i, i + 1);
                cont++;

            } else if (i == texto.length() - 1) {
                aux = texto.substring(i, i + 1);
                if (aux.equals(inicio)) {
                    cont++;
                    if (inicio.equals("1")) {
                        resultado += confereContUm(cont,inicio);
                        resultado += "1" + aux;
                    } else {
                        resultado += Integer.toString(cont) + inicio;
                    }
                } else {
                    if (cont == 1) {
                        if (aux.equals("1")) {
                            resultado += confereContUm(cont,inicio);
                            resultado += "1" + aux;
                        } else {
                            resultado += Integer.toString(cont) + inicio + "0";
                            resultado += "1" + aux + "0";
                        }
                    } else {
                        if (aux.equals("1")) {
                            resultado += confereContUm(cont,inicio);
                            resultado += "1" + aux;
                        } else {
                            resultado += Integer.toString(cont) + inicio;
                            resultado += "1" + aux + "0";
                        }
                    }
                }
            } else {
                aux = texto.substring(i, i + 1);
                if (aux.equals(inicio)) {
                    if (cont == 9) {
                        resultado += Integer.toString(cont) + inicio;
                        cont = 0;
                    }
                    cont++;
                } else {
                    if (aux.equals("1")) {
                        resultado += confereContUm(cont,inicio);
                        resultado += "1" + aux;
                        inicio = aux;
                        i = i - 1;
                        cont = 0;
                    } else {
                        resultado += confereContUm(cont, inicio);
                        inicio = aux;
                        i = i - 1;
                        cont = 0;
                    }
                }
            }
        }
        return resultado;
    }

    private static String confereContUm(int cont, String inicio) {
        if (cont == 1) {
            return Integer.toString(cont) + inicio + "0";
        } else {
            return Integer.toString(cont) + inicio;
        }
    }

}
