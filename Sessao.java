// Breno Borges e Yan Barreto

import java.time.LocalTime;

class Sessao {
    private String id;
    private int capacMax;
    private int ingreVendidos;
    private LocalTime horarioInicio;
    private double valorArrecadado;
    private Filme filme;
    private static double precoIngresso = 20;

    public Sessao(String id, Filme filme, LocalTime horarioInicio, int capacMax) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.filme = filme;

        if (capacMax <= 0) {
            this.capacMax = 50;
        } else {
            this.capacMax = capacMax;
        }

        ingreVendidos = 0;
        valorArrecadado = 0.0;
    }
    public Sessao(String id, Filme filme, LocalTime horarioInicio) {
        this.id = id;
        this.horarioInicio = horarioInicio;
        this.filme = filme;
        capacMax = 50;
        ingreVendidos = 0;
        valorArrecadado = 0;
    }

    public String cId () {
        return id;
    }
    public Filme cFilme () {
        return filme;
    }
    public LocalTime cHorarioInicio () {
        return horarioInicio;
    }
    public int cCapacidade () {
        return capacMax;
    }
    public int cIngreVend () {
        return ingreVendidos;
    }
    public double cValorArre () {
        return valorArrecadado;
    }

    public static double cPrecoingresso () {
        return precoIngresso;
    }
    public static boolean altPrecoingresso (double preco) {
        if (preco <= 0) {
            return false;
        } else {
            precoIngresso = preco;
            return true;
        }
    }

    public int lugarDisponivel () {
        return capacMax - ingreVendidos;
    }

    public double vendaIngre (int idade) {
        if (idade < 0) {
            return -1;
        } 
        else if (!filme.consultaDeIdadeMinima(idade)) {
            return -2;
        } else if (lugarDisponivel() <= 0) {
            return -3;
        } else {
            double valor = calPercentual(0);

            ingreVendidos++;
            valorArrecadado += valor;
            return valor;
        }
    }
    public double vendaIngre (int idade, String documento) {
        if (idade < 0 || documento == null || documento.isBlank()) {
            return -1;
        } 
        else if (!filme.consultaDeIdadeMinima(idade)) {
            return -2;
        } else if (lugarDisponivel() <= 0) {
            return -3;
        } else {
            double valor = calPercentual(50);
            ingreVendidos++;
            valorArrecadado += valor;
            return valor;
        }
    }
    private double calPercentual (double percent) {
        return precoIngresso * (1 - percent / 100);
    }

    public LocalTime cHorarioTermino () {
        return horarioInicio.plusMinutes((long) filme.getDuracao());
    }

}