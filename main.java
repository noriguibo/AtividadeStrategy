package strategy;

interface ICalcMedia {
	double CalcularMedia(double P1, double P2);
	String Situacao(double media);
}

class Aritmetica implements ICalcMedia {	
	
	@Override
	public double CalcularMedia(double P1, double P2) {
		return (P1 + P2) / 2;
	}
	
	@Override
	public String Situacao(double media) {
		return media >= 5 ? "Aprovado" : "Reprovado";
	}
}

class Geometrica implements ICalcMedia {	
	
	@Override
	public double CalcularMedia(double P1, double P2) {
		return Math.sqrt(P1 * P2);
	}
	
	@Override
	public String Situacao(double media) {
		return media >= 7 ? "Aprovado" : "Reprovado";
	}
}

class Disciplina {
	private ICalcMedia CalcMedia;
	private double Media, P1, P2;
	private String Nome, Situacao;
	
	public Disciplina(ICalcMedia CalcMedia) {
		this.CalcMedia = CalcMedia;
	}
	
	public void CalcularMedia() {
		Media = CalcMedia.CalcularMedia(P1, P2);
		Situacao = CalcMedia.Situacao(Media);
	}
	
	void setNome(String Nome) {
		this.Nome = Nome;
	}
	
	void setP1(double P1) {
		this.P1 = P1;
	}
	
	void setP2(double P2) {
		this.P2 = P2;
	}
	
	double getP1() {
		return P1;
	}

	double getP2() {
		return P2;
	}
	
	double getMedia() {
		return Media;
	}
	
	String getSituacao() {
		return Situacao;
	}
}

public class Main {public static void main(String[] args) {
	//Aritmetica calculo = new Aritmetica();
	Geometrica calculo = new Geometrica();
	
	Disciplina d = new Disciplina(calculo);
	
	d.setNome( "Padroes de Desenvolvimento");
	d.setP1(5); 
	d.setP2(5);
	d.CalcularMedia();
	System.out.println(
		String.format("P1:%.2f P2:%.2f Media:%.2f  Situacao: %s",
		d.getP1(),d.getP2(), d.getMedia(), d.getSituacao()));
	}
}