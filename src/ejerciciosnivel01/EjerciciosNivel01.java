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
    
    public static void main(String[] args) {
        int[] numeros = {99, 37, 7, 54, 13};
        int[] numero2 = {1000, 2, 200, 3, 20, 4000};
        int[] numero3 = {-1, -10, -200, -3, -80};
        
        EjerciciosNivel01 e = new EjerciciosNivel01();
        System.out.println(Arrays.toString(e.maximos(numeros)));
        System.out.println(Arrays.toString(e.maximos(numero2)));
        System.out.println(Arrays.toString(e.maximos(numero3)));
        
        System.out.println(e.esPalindromo("Acaso hubo buhos acá"));
    }
    
}
