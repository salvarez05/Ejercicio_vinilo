import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[][] vinilo=  new String[100][3];
        agregarVinilo(vinilo, "Iron maiden", "Iron Maiden", "1980");
        agregarVinilo(vinilo, "Iron maiden", "Killers", "1981");
        agregarVinilo(vinilo, "Iron maiden", "The number of the beast", "1982");
        agregarVinilo(vinilo, "AC-DC", "Back in black", "1980");
        agregarVinilo(vinilo, "AC-DC", "Highway to Hell", "1979");
        agregarVinilo(vinilo, "AC-DC", "Who made who", "1986");
        agregarVinilo(vinilo, "Judas Priest", "British steel", "1980");
        agregarVinilo(vinilo, "Judas Priest", "Painkiller", "1990");
        agregarVinilo(vinilo, "Judas Priest", "Defenders of the faith", "1984");
        agregarVinilo(vinilo, "Kiss", "Destroyer", "1976");
        System.out.println("Espacio máximo colección: "+ vinilo.length);
        totalVinilos(vinilo);
        mostrarDisponibles(vinilo);
        System.out.println("¿Que artista desea buscar?");
        Scanner teclado = new Scanner(System.in);
        String artista = teclado.next();
        mostrarBusquedaArtista(vinilo,artista);
        mostrarColeccion(vinilo);

    }
    public static int totalVinilos(String vinilo[][]){
        int total=0;
        for (int i=0; i<vinilo.length;i++){
            if (vinilo[i][0]!=null) {
                total++;
            }
        }
        System.out.println("Hay "+total+" vinilos en la colección");
        return total;
    }

    public static String[][] agregarVinilo(String vinilo[][], String artista, String disco,String año){
        int fila = 0;
        for (int i = 0; i < 10; i++) {
            if (vinilo[i][0] == null) {
                break;
            }
            fila++;
        }

        vinilo[fila][0] = artista;
        vinilo[fila][1] = disco;
        vinilo[fila][2] = año;

        return vinilo;
    }

    public static void mostrarBusquedaArtista (String vinilo[][], String artista){
        if (buscarArtista(vinilo,artista)==true){
            System.out.println("Coleccion contiene al artista: "+artista);
        } else if (buscarArtista(vinilo,artista)==false) {
            System.out.println("Coleccion no contiene al artista: "+artista);
        }
    }
    public static boolean buscarArtista(String[][] vinilo, String artista){
        int a=0;
        for (int i = 0; i < vinilo.length; i++) {
            if (vinilo[i][0].equals(artista)) {
                return true;
            }
            break;
        }
        return false;
    }
    public static void mostrarColeccion(String[][] vinilo){
        for (int i=0; i<vinilo.length; i++){
            if(vinilo[i][0]!=null){
                System.out.println("Vinilo " +(i+1)+" : " +vinilo[i][0].toString() +", " +vinilo[i][1].toString()+", " +vinilo[i][2].toString());
            }
        }
    }

    public static void mostrarDisponibles(String vinilo[][]){
        int disponible =0;
        for (int i=0; i<vinilo.length;i++){
            if (vinilo[i][0]==null) {
                disponible++;
            }
        }
        System.out.println("Quedan "+disponible+" espacios disponibles");
    }
}