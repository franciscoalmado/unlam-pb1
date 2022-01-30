package PB12021RecSegundoParcial.Dominio;

public class Libro {
	
	private String isbn;
	private String nombre;
	private String editorial;
	private String autor;
	private int anioPublicacion;
	private double precio;
	private Genero genero;
	
	//Constructor de la Clase
	public Libro(String isbn, String nombre, String autor, String editorial , double precio) {
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
		this.editorial=editorial;
		this.precio=precio;
		this.anioPublicacion = 2021;
	}
	
	public Libro(String isbn, String nombre, String autor, String editorial , double precio, Genero genero, int anioPublicacion) {
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
		this.editorial=editorial;
		this.precio=precio;
		this.genero = genero;
		this.anioPublicacion = anioPublicacion;	
	}
	
	//Metodos de la clase
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [isbn= " + isbn + ", nombre= " + nombre + ", autor= " + autor + ", editorial= "
				+ editorial +  ", género= " + genero + ", año de publicación= " + anioPublicacion + "]";
	}	
}