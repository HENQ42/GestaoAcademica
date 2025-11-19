package domain;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected String email;

	public getNome(void){
		return this.nome;
	}
	public getCpf(){
		return this.cpf;
	}
	public getEmail(){
		return this.email;
	}
	public setNome(String nome){
		try{
			this.nome = nome;
		}catch(error){
			System.out.println("Erro ao setar nome: "+error);
		}	
	}
	public setCpf(String cpf){
		try{
			this.cpf = cpf;
		}catch(err){
			System.out.println("Erro ao definir cpf: "+err);
		}
	}
	public setEmail(email){
		try{
			this.email = email;
		}catch(err){
			System.out.println("Erro ao definir Email: "+err);
		}
	}
}
