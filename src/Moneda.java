import java.util.ArrayList;
import java.util.List;

public class Moneda {
    String codigo;
    String nombre;
    String nombres;
    String pais;

    public Moneda(String codigo, String nombre, String nombres, String pais) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombres = nombres;
        this.pais = pais;
    }

    // Lista estática que contiene las monedas
    public static final List<Moneda> listaMonedas = new ArrayList<>();

    // Bloque estático para cargar la lista al inicio
    static {
        listaMonedas.add(new Moneda("ARS", " Peso argentino (ARS)", " Pesos argentinos (ARS)", "1. Argentina"));
        listaMonedas.add(new Moneda("BRL", " Real brasileño (BRL)", " Reales brasileños (BRL)", "2. Brasil"));
        listaMonedas.add(new Moneda("BOB", " Boliviano boliviano (BOB)", " Bolivianos bolivianos (BOB)", "3. Bolivia"));
        listaMonedas.add(new Moneda("CLP", " Peso chileno (CLP)", " Pesos chilenos (CLP)", "4. Chile"));
        listaMonedas.add(new Moneda("CNY", " Renminbi chino (CNY)", " Renminbis chinos (CNY)", "5. China"));
        listaMonedas.add(new Moneda("COP", " Peso colombiano (COP)", " Pesos colombianos (COP)", "6. Colombia"));
        listaMonedas.add(new Moneda("CUP", " Peso cubano (CUP)", " Pesos cubanos (CUP)", "7. Cuba"));
        listaMonedas.add(new Moneda("EGP", " Libra egipcia (EGP)", " Libras egipcias (EGP)", "8. Egipto"));
        listaMonedas.add(new Moneda("USD", " Dólar estadounidense (USD)", " Dólares estadounidenses (USD)", "9. Estados Unidos"));
        listaMonedas.add(new Moneda("JPY", " Yen japonés (JPY)", " Yenes japoneses (JPY)", "10. Japón"));
        listaMonedas.add(new Moneda("MGA", " Ariary malgache (MGA)", " Ariarys malgaches (MGA)", "11. Madagascar"));
        listaMonedas.add(new Moneda("MXN", " Peso mexicano (MXN)", " Pesos mexicanos (MXN)", "12. México"));
        listaMonedas.add(new Moneda("ZAR", " Rand sudafricano (ZAR)", " Rands sudafricanos (ZAR)", "13. Sudáfrica"));
        listaMonedas.add(new Moneda("SEK", " Corona sueca (SEK)", " Coronas suecas (SEK)", "14. Suecia"));
        listaMonedas.add(new Moneda("CHF", " Franco suizo (CHF)", " Francos suizos (CHF)", "15. Suiza"));
    }
}
