package br.com.magicApi.util;

/**
 * Classe que posssui as constantes utilizadas no sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
public class Constantes {

	//TAGS
	public static final String TAG_PERSONAGEM = "personagem";
	
	
	//PATHS
	public static final String PATH_RAIZ = "/api/magic";

    public static final String PATH_SWAGGER = "/docs";
    
    //personagem resource
    public static final String PATH_PERSONAGEM = PATH_RAIZ + "/personagem";
    
    
	//Swagger
    
    //serviços
    public static final String CREATE_PERSONAGEM = "Criar um personagem ";
    
    public static final String CREATE_PERSONAGEM_NOTES = "Cria um personagem de Harry Potter.";
    
    public static final String UPDATE_PERSONAGEM = "Atualizar um personagem ";
    
    public static final String UPDATE_PERSONAGEM_NOTES = "Atualiza um personagem de Harry Potter.";
    
    public static final String RETRIEVE_PERSONAGEM = "Recuperar um personagem ";
    
    public static final String RETRIEVE_PERSONAGEM_NOTES = "Recupera um personagem de Harry Potter.";
    
    public static final String DELETE_PERSONAGEM = "Deletar um personagem ";
    
    public static final String DELETE_PERSONAGEM_NOTES = "Deleta um personagem de Harry Potter.";
    
    public static final String LIST_PERSONAGEM = "Listar um personagem ";
    
    public static final String LIST_PERSONAGEM_NOTES = "Lista um personagem de Harry Potter.";
    
    
	//DTOs
	public static final String PERSONAGEM = "Armazena os dados do personagem";
	
	public static final String PERSONAGEM_PERSIST = "Armazena os dados do personagem";
	
	public static final String PERSONAGEM_ID = "Armazena o id do personagem";
	
	public static final String PERSONAGEM_NAME = "Nome do personagem";
	
	public static final String PERSONAGEM_ROLE = "Função do personagem";
	
	public static final String PERSONAGEM_SCHOOL = "Escola do personagem";
	
	public static final String PERSONAGEM_HOUSE = "Casa da esola do personagem";
	
	public static final String PERSONAGEM_PATRONUS = "Patrono/guardião do personagem";
	
	
	//outras constantes
	public static final String TAG_ERRO = "message";
	
	public static final String CIRCUIT_BREAKER = "circuitBreaker";
	

}
