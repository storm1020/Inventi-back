package br.com.fiap.inventi.beans;

public class TipoUsuario {
	private int codigoTipo;
	private String descricaoTipo;
	
	public TipoUsuario(){
		
	}
	
	public TipoUsuario(int pCodigoTipo, String pDescricaoTipo){
		setCodigoTipo(pCodigoTipo);
		setDescricaoTipo(pDescricaoTipo);
	}
	
	public String getAll(){
		return "C�digo Tipo: " + codigoTipo + "\n" +
				"Descri��o Tipo: " + descricaoTipo;
	}
	
	public void setAll(int pCodigoTipo, String pDescricaoTipo){
		setCodigoTipo(pCodigoTipo);
		setDescricaoTipo(pDescricaoTipo);
	}	
	
	public int getCodigoTipo() {
		return codigoTipo;
	}
	public void setCodigoTipo(int codigoTipo) {
		this.codigoTipo = codigoTipo;
	}
	public String getDescricaoTipo() {
		return descricaoTipo;
	}
	public void setDescricaoTipo(String descricaoTipo) {
		this.descricaoTipo = descricaoTipo;
	}
}
