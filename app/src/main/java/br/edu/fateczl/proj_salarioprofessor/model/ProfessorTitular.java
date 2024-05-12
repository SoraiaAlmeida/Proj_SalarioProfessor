package br.edu.fateczl.proj_salarioprofessor.model;

public class ProfessorTitular extends Professor {
    private int anosInstituicao;
    private double salarioBase;

    public ProfessorTitular() {
        super();
    }
    @Override
    public double calcSalario(int tempo) {
        if (tempo >= 5) {
            int TC = tempo % 2;
            salarioBase = 7000 * (1 + (TC * 0.5));
                   }
        return salarioBase;
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    }
