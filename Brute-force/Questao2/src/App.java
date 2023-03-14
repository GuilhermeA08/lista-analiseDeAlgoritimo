import java.util.HashMap;
import java.util.Map;

public class App {

    public static double calcularDistancia(Ponto a, Ponto b) {
        int primeiro = b.x - a.x;
        int segundo = b.y - a.y;
        double num1 = Math.pow(primeiro, 2);
        double num2 = Math.pow(segundo, 2);
        double resultado = Math.sqrt(num1 + num2);
        return resultado;
    }

    public static void main(String[] args) throws Exception {
        Ponto[] lista = new Ponto[5];
        lista[0] = new Ponto(2, 5);
        lista[1] = new Ponto(-3, 7);
        lista[2] = new Ponto(1, -2);
        lista[3] = new Ponto(-4, -1);
        lista[4] = new Ponto(6, 3);

        double menorDistancia = 100000000.0;
        Map<Ponto, Ponto> menores = new HashMap<>();

        double holder = 0;
        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                holder = calcularDistancia(lista[i], lista[j]);
                System.out.println("Distancia:" + holder);
                if (holder < menorDistancia) {
                    menores.clear();
                    menorDistancia = holder;
                    menores.put(lista[i], lista[j]);
                } else if (holder == menorDistancia) {
                    menores.put(lista[i], lista[j]);
                }
            }
        }
        for (Map.Entry<Ponto, Ponto> item : menores.entrySet()) {
            String ponto1 = item.getKey().toString();
            String ponto2 = item.getValue().toString();
            System.out.println(ponto1 + "  " + ponto2);
        }
        System.out.println("Menor Distancia: " + menorDistancia);

    }
}
