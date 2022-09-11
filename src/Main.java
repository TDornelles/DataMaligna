public class Main {

    public static void main (String[] args){
        try {
            Data d1 = new Data((byte)8, (byte)3, (short)1997);
            Data d2 = d1;
            Data d3 = new Data((byte)2, (byte)9, (short)1997);
            Data d4 = new Data((byte)14, (byte)2, (short)1997);

            if (d1.equals(d2)) System.out.println("d1 equals d2");
            else System.out.println("d1 not equals d2");

            if (d1.equals(d3)) System.out.println("d1 equals d3");
            else System.out.println("d1 not equals d3");

            if (d1.equals(d4)) System.out.println("d1 equals d4");
            else System.out.println("d1 not equals d4");

        } catch (Exception erro){
            System.err.println(erro.getMessage());
        }
    }
}
