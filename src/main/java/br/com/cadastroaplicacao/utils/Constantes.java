package br.com.cadastroaplicacao.utils;

import java.io.Serializable;

public class Constantes implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    
	private static String REDIRECT = "redirect";
	private static String INCLUIR  = "incluir";
	private static String ALTERAR  = "alterar";
	private static String EXCLUIR  = "excluir";
	private static String INDEX    = "index";
	private static String PRODUTO  = "produto";
	private static String PRODUTOS = "produtos";
	private static String FORNECEDOR  = "fornecedor";
	private static String FORNECEDORES = "fornecedores";

	public static String TEMPLATE_INDEX = "/"+INDEX;
	
	//PRODUTO
	public static String REDIRECT_PRODUTO = REDIRECT+":/"+PRODUTOS;
	public static String TEMPLATE_PRODUTO_INCLUIR = "/"+PRODUTO+"/"+INCLUIR;
	public static String TEMPLATE_PRODUTO_ALTERAR = "/"+PRODUTO+"/"+ALTERAR;
	public static String PRODUTO_INDEX = "/"+PRODUTO+"/"+INDEX;

	//FORNECEDOR
	public static String REDIRECT_FORNECEDOR = REDIRECT+":/"+FORNECEDORES;
	public static String TEMPLATE_FORNECEDOR_INCLUIR = "/"+FORNECEDOR+"/"+INCLUIR;
	public static String TEMPLATE_FORNECEDOR_ALTERAR = "/"+FORNECEDOR+"/"+ALTERAR;
	public static String FORNECEDOR_INDEX = "/"+FORNECEDOR+"/"+INDEX;
}
