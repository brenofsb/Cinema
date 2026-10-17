// Breno Borges e Yan Barreto

package Trabalho;

public class Filme {
	private String titulo;
	private double duracao;
	private int classificacao;
	private String categoria = "Ação";
	private String sinopse = "Não informada";
	
	
	public Filme (String titulo, double duracao, String categoria, int classificacao) {
		this.titulo = titulo;
		
		if(duracao <= 0) {
			this.duracao = 90;
		} else {
			this.duracao = duracao;
		}
		
		if(classificacao <= 0) {
			this.classificacao = 0;
		} else {
			this.classificacao = classificacao;
		}
		
		categorias(categoria);
	
	}
	
	public Filme (String titulo, double duracao) {
		this.titulo = titulo;
		
		if(duracao <= 0) {
			this.duracao = 90;
		} else {
			this.duracao = duracao;
		}
		
		classificacao = 0;
	}
	
	public boolean consultaDeIdadeMinima(int idade) {
	    if (idade < 0) {
	        return false;
	    }

	    if (classificacao == 0 || idade >= classificacao) {
	        return true;
	    } else {
	        return false;
	    }
	}

	public boolean categorias(String categoria) {
	    if(categoria.equalsIgnoreCase("Ação") ||
	       categoria.equalsIgnoreCase("Aventura") ||
	       categoria.equalsIgnoreCase("Comédia") ||
	       categoria.equalsIgnoreCase("Drama") ||
	       categoria.equalsIgnoreCase("Terror") ) {
	    	this.categoria = categoria;
	    	return true;
	    } else if (categoria == null) {
	    	return false;
	    } else {
	    	return false;
	    }
	
	}
	
	public String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracao() {
		return duracao;
	}

	private void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public int getClassificacao() {
		return classificacao;
	}

	private void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getCategoria() {
		return categoria;
	}

	private void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
	
	

}
