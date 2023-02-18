import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> estadosBrasil = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estadosBrasil);
        estadosBrasil.put("RN", 3534165);
        System.out.println(estadosBrasil);

        if (!estadosBrasil.containsKey("PB"))
            estadosBrasil.put("PB", 4039277);
        System.out.println(estadosBrasil);

        System.out.println("População de PE: " + estadosBrasil.get("PE"));

        // EXIBIR EM ORDEM ALFABETICA
        Map<String, Integer> estadosBrasil2 = new TreeMap<>(estadosBrasil);
        System.out.println(estadosBrasil2);

        //Exibir ESTADO COM MENOR POPULAÇÃO
        Collection<Integer> valoresMap = estadosBrasil2.values();
        Integer menorPopulacao = Collections.min(valoresMap);
        for (Map.Entry<String, Integer> estados : estadosBrasil2.entrySet()){
            if (estados.getValue().equals(menorPopulacao)){
                System.out.println("Estado com menor população: "
                        + estados.getKey() + " - População: " + menorPopulacao);
            }
        }

        //EXIBIR ESTADO COM MAIOR POPULAÇÃO
        Collection<Integer> valoresMap2 = estadosBrasil2.values();
        Integer maiorPopulacao = Collections.max(valoresMap);
        for (Map.Entry<String, Integer> estados : estadosBrasil2.entrySet()){
            if (estados.getValue().equals(maiorPopulacao)){
                System.out.println("Estado com maior população: "
                        + estados.getKey() + " - População: " + maiorPopulacao);
            }
        }

        //SOMA DAS POPULAÇÕES DO MAP
        Iterator<Integer> populacoes = estadosBrasil2.values().iterator();
        int soma = 0;
        while (populacoes.hasNext()){
            soma += populacoes.next();
        }
        System.out.println("Soma das populações: " + soma);
        System.out.println("Media de população: " + soma/estadosBrasil2.size());

        Iterator<Integer> populacoes2 = estadosBrasil2.values().iterator();
        while (populacoes2.hasNext()){
            if (populacoes2.next() <= 4000000){
                populacoes2.remove();
            }
        }

        System.out.println(estadosBrasil2);

        estadosBrasil2.clear();
        System.out.println(estadosBrasil2);
        System.out.println(estadosBrasil2.isEmpty());
    }
}