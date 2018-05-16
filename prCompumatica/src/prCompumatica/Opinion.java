package prCompumatica;

public class Opinion {
	private String op;
	
	public Opinion(String op){
		this.op = op;
	}
	String getOpinion() {
		return op;
	}
	
	public void mandarOpinion(Datos datos){
		datos.recibirOpinion(this.op);
	}
	//This is just some dummy test. Hi.
}
