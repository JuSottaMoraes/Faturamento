/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package faturamento;
import org.json.JSONArray;
import org.json.JSONObject;

public class Faturamento {

    public static void main(String[] args) {
        String jsonData = "[{\"dia\": 1, \"valor\": 100.0}, {\"dia\": 2, \"valor\": 200.0}, {\"dia\": 3, \"valor\": 0.0}, {\"dia\": 4, \"valor\": 300.0}, {\"dia\": 5, \"valor\": 0.0}]"; // Exemplo de dados em JSON

        JSONArray faturamentos = new JSONArray(jsonData);
        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double soma = 0;
        int diasComFaturamento = 0;

        for (int i = 0; i < faturamentos.length(); i++) {
            JSONbject diaFaturamento = faturamentos.getJSONObject(i);
            double valor = diaFaturamento.getDouble("valor");

            if (valor > 0) {
                if (valor < menorValor) {
                    menorValor = valor;
                }
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
                soma += valor;
                diasComFaturamento++;
            }
        }

        double mediaMensal = soma / diasComFaturamento;

        int diasAcimaDaMedia = 0;
        for (int i = 0; i < faturamentos.length(); i++) {
            JSONObject diaFaturamento = faturamentos.getJSONObject(i);
            double valor = diaFaturamento.getDouble("valor");

            if (valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);
    }
}
