public class Main {

    public static void main (String[] args){

        try {
            Data data = new Data((byte) 19, (byte) 8, (short) 2022);
            System.out.println(data);
            data.torneSeODiaSeguinte();
            System.out.println(data);
        } catch (Exception erro){
            System.err.println(erro.getMessage());
        }
    }
}
