package entidades;

public class ReporteEntity extends CursoEntity{

	private int cantidadMatriculados;

	public ReporteEntity(int curId, String curNombre, int cantidadMatriculados) {
		super(curId, curNombre);
		this.cantidadMatriculados = cantidadMatriculados;
	}

	public int getCantidadMatriculados() {
		return cantidadMatriculados;
	}

	public void setCantidadMatriculados(int cantidadMatriculados) {
		this.cantidadMatriculados = cantidadMatriculados;
	}	
	
}
