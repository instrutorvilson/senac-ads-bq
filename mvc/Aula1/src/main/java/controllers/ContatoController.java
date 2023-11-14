package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Contato;

public class ContatoController {
	static List<Contato> contatos = new ArrayList<Contato>();
	
	public ContatoController() {
		contatos.add(new Contato(1, "maria", "maria@gmail.com"));
		contatos.add(new Contato(2, "jose", "jose@gmail.com"));
		contatos.add(new Contato(3, "Antonio", "antonio@gmail.com"));
		contatos.add(new Contato(4, "joao", "joao@gmail.com"));
	}
	
    public boolean salvar(Contato ct) {
    	contatos.add(ct);
    	return true;
    }
    
    public List<Contato> getContatos(){
    	return contatos;
    }
}
