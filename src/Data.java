public class Data {
    private byte dia, mes;
    private short ano;

    public Data (byte dia,byte mes,short ano) throws Exception {
        if (!isValida(dia,mes,ano))
            throw new Exception("Data inválida");

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public byte getDia() {
        return dia;
    }

    public void setDia(byte dia) throws Exception {
        if (!isValida(dia,this.mes,this.ano))
            throw new Exception("Dia invalido");
        this.dia = dia;
    }

    public byte getMes() {
        return mes;
    }

    public void setMes(byte mes) throws Exception {
        if (!isValida(this.dia,mes,this.ano))
            throw new Exception("Mes invalido");
        this.mes = mes;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) throws Exception {
        if (!isValida(this.dia,this.mes,ano))
            throw new Exception("Ano invalido");
        this.ano = ano;
    }

    private boolean isBissexto (short ano)
    {
        //verifica se um ano é bissexto
        if (ano<1583)
            if (ano%4 == 0)
                return true;
            else
                return false;

        if (ano%4 != 0 && ano%400 == 0) return true;

        if (ano%4 == 0 && ano%100 != 0) return true;

        return false;
    }

    private boolean isValida (byte dia, byte mes, short ano)
    {
        //verifica a validez de qualquer data
        if (dia<1 || dia>31) return false;
        if (mes<1 || mes>12) return false;
        if (ano==0)          return false;

        if (dia>4 && dia<15 && mes==10 && ano==1582) return false;

        if (dia>30 && (mes==4 || mes==6 || mes==9 || mes==11)) return false;

        if (dia>29 && mes==2) return false;

        if (dia>28 && mes==2 && !isBissexto(ano)) return false;

        return true;
    }

    @Override
    public String toString(){
        return (this.dia < 10?"0":"") + this.dia +
                "/" + (this.mes < 10?"0":"") + this.mes
                + "/" + ano;
    }

    public void torneSeODiaSeguinte() throws Exception {

        //mudança para o calendário gregoriano
        if(this.dia == 4 && this.mes == 10 && this.ano == 1582){
            this.setDia((byte) 15);
            return;
        }

        //caso seja o último dia do mês
        if (!isValida((byte) (this.dia + 1), this.mes, this.ano)) {
            //caso seja o último mês do ano
            if (!isValida((byte) 1, (byte) (this.mes + 1), this.ano)) {
                anoNovo();
                return;
            }
            this.setDia((byte) 1);
            this.setMes((byte) (this.mes + 1));
            return;
        }
        this.setDia((byte) (this.dia + 1));
    }


    private void anoNovo() throws Exception {
        //caso a torneSeODiaSeguinte seja chamada para o último dia de um ano
        if(this.ano == -1) this.setAno((short) 1);
        else this.setAno((short) (this.ano + 1));

        this.setDia((byte) 1);
        this.setMes((byte) 1);
    }

}
