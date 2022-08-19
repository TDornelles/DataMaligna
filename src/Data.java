public class Data {
    public byte dia, mes;
    public short ano;

    public Data (byte dia,byte mes,short ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString(){
        return dia + "/" + mes + "/" + ano;
    }
}
