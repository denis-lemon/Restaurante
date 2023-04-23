package br.com.restaurante.model;

public class Reserva {
    private String data;
    private String hora;
    private String qntPessoas;

    private String ambiente;
    private String obs;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getQntPessoas() {
        return qntPessoas;
    }

    public void setQntPessoas(String qntPessoas) {
        this.qntPessoas = qntPessoas;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }
}