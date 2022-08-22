public class Main {

    public static void main (String[] args){

        try {
            Data data = new Data((byte) 31, (byte) 12, (short) 2020);
            System.out.println(data);
            data.torneSeODiaSeguinte();
            System.out.println(data);
        } catch (Exception erro){
            System.err.println(erro.getMessage());
        }
    }
}
