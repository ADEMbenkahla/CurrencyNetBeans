package currency;


import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import org.json.JSONObject;

@Path("currency")
public class CurrencyResource {

    // Champs pour les taux de change, la source de données, etc.

    private static final Map<String, Map<String, Double>> exchangeRates = new HashMap<>();

    static {
        // Initialise les taux de change
        exchangeRates.put("EUR", new HashMap<>());
        exchangeRates.get("EUR").put("USD", 1.12);
        exchangeRates.get("EUR").put("GBP", 0.85);
        exchangeRates.get("EUR").put("JPY", 125.00);

        exchangeRates.put("USD", new HashMap<>());
        exchangeRates.get("USD").put("EUR", 0.89);
        exchangeRates.get("USD").put("GBP", 0.72);
        exchangeRates.get("USD").put("JPY", 105.00);

        exchangeRates.put("GBP", new HashMap<>());
        exchangeRates.get("GBP").put("EUR", 1.18);
        exchangeRates.get("GBP").put("USD", 1.40);
        exchangeRates.get("GBP").put("JPY", 150.00);

        exchangeRates.put("JPY", new HashMap<>());
        exchangeRates.get("JPY").put("EUR", 0.0079);
        exchangeRates.get("JPY").put("USD", 0.0087);
        exchangeRates.get("JPY").put("GBP", 0.0067);
    }

    @GET
    @Produces("application/json") // Ou tout autre format approprié
    public String getExchangeRate(@QueryParam("from") String fromCurrency, @QueryParam("to") String toCurrency) {
        // Récupère le taux de change à partir des taux de change enregistrés
        Double exchangeRate = exchangeRates.get(fromCurrency).get(toCurrency);

        // Crée une réponse JSON
        JSONObject response = new JSONObject(); // Création de l'objet JSONObject
        response.put("fromCurrency", fromCurrency);
        response.put("toCurrency", toCurrency);
        response.put("exchangeRate", exchangeRate);

        return response.toString();
    }
}
