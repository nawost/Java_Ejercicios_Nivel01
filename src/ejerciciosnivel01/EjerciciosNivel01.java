package ejerciciosnivel01;

import java.util.Arrays;

/**
 *
 * @author Joan Marí
 */
public class EjerciciosNivel01 {
    
    public int[] maximos(int[] lista){
        int[] arrayMaximos = {0,0};
        for (int i=0; i<lista.length; i++){
            if(lista[i] > arrayMaximos [0]){
                arrayMaximos[1] = arrayMaximos[0];
                arrayMaximos[0] = lista[i];
            }
            else if (lista[i] > arrayMaximos[1]){
                arrayMaximos[1] = lista[i];
            }
        }
        
        return arrayMaximos;
    }
    //segundo ejercicio: PALÍNDROMO
    //para hacer este ejercicio necesito hacer primero una función
    //que "limpie" el string para quitarle los acentos y los espacios en blanco
    
    private String limpiaFrase(String frase){
        frase = frase.toLowerCase(); //paso la frase a minúsculas
        frase = frase.replace('á', 'a');
        frase = frase.replace('é', 'e');
        frase = frase.replace('í', 'i');
        frase = frase.replace('ó', 'o');
        frase = frase.replace('ú', 'u');
        //quito también los espacios en blanco
        frase = frase.replace(" ", "");
        
        return frase;
    }
    public boolean esPalindromo(String frase){
        frase = limpiaFrase(frase);//quita acentos y espacios en la frase
        
        int indiceIzquierdo = 0;
        int indiceDerecho = frase.length()-1;
        
        while(frase.charAt(indiceIzquierdo) == frase.charAt(indiceDerecho) && indiceIzquierdo <= indiceDerecho){
            indiceIzquierdo++;
            indiceDerecho--;
        }
        if (indiceIzquierdo > indiceDerecho){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean esIsograma(String palabra){
        palabra = limpiaFrase(palabra);
        for (int i=0; i< palabra.length(); i++){
            for (int j=i+1; j< palabra.length(); j++){
                if (palabra.charAt(i) == palabra.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Convierte una frase en su acrónimo
     * @param frase la frase a convertir en acrónimo
     * @return el Acrónimo en mayúsculas
     */
    public String acronimo(String frase){
        //suponemos que por lo menos hay una letra en la frase
        frase = frase.toUpperCase();
        String palabras[] = frase.split(" ");
        String resultado = "";
        for (int i=0; i< palabras.length; i++){
            if (!(palabras[i].equals("Y")||
                   palabras[i].equals("E")||
                    palabras[i].equals("DE")||
                    palabras[i].equals("LA")||
                    palabras[i].equals("LAS"))){
            resultado = resultado + palabras[i].charAt(0);
            }
        }
        return resultado;
    }
    public boolean anagrama (String p1, String p2){
        p1 = limpiaFrase(p1);
        p2 = limpiaFrase(p2);
        
        if (p1.length() != p2.length()) {
            return false;
        }else{
            for(int i = 0; i < p1.length(); i++) {
                int j=0;
                while(j<p2.length() && (p1.charAt(i) != p2.charAt(j))) {
                    j++;
                }
                if (j==p2.length()){
                    return false;
                }else{
                    p2 = p2.substring(0, j) + p2.substring(j+1);
                }
            }
            if (p2.length() == 0){
                return true;
            }else{
                return false;
            }
        }
    }
    
    
    public static void main(String[] args) {
        int[] numeros = {99, 37, 7, 54, 13};
        int[] numero2 = {1000, 2, 200, 3, 20, 4000};
        int[] numero3 = {-1, -10, -200, -3, -80};
        
        EjerciciosNivel01 e = new EjerciciosNivel01();
        System.out.println(Arrays.toString(e.maximos(numeros)));
        System.out.println(Arrays.toString(e.maximos(numero2)));
        System.out.println(Arrays.toString(e.maximos(numero3)));
        
        System.out.println(e.esPalindromo("Acaso hubo buhos acá"));
        
        System.out.println("Isograma Pájaro:" + e.esIsograma("Pájaro"));
        System.out.println("Isograma Tijeras:" + e.esIsograma("Tijeras"));
        
        System.out.println("acronimo de Alta Velocidad Española:" + e.acronimo("Alta Velocidad Española "));
        System.out.println("acronimo de Objeto Volador No Identificado:" + e.acronimo("Objeto Volador No Identificado"));
        System.out.println("acronimo de Tecnología de la Información y de las Comunicaciones:" + e.acronimo("Tecnología de la Información y de las Comunicaciones"));
        
        System.out.println("anagrama:roma, amor: " + e.anagrama("roma", "amor"));
        System.out.println("anagrama:princesa, cinrespa: " + e.anagrama("princesa", "cinrespa"));
        System.out.println("anagrama:clavo, persona: " + e.anagrama("clavo", "persona"));
    }
    
}
