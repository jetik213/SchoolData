package entidades;

public class CursoEntity {
	
	private int curId;
	private String curNombre;
	private int curCiclo;
	private int curCreditos;
	private int curHoras;
	private int curEstado;
	
	
	
	public CursoEntity(int curId, String curNombre) {
		super();
		this.curId = curId;
		this.curNombre = curNombre;
	}
	public CursoEntity(String curNombre, int curCiclo, int curCreditos, int curHoras) {
		super();
		this.curNombre = curNombre;
		this.curCiclo = curCiclo;
		this.curCreditos = curCreditos;
		this.curHoras = curHoras;
	}
	public CursoEntity() {
		
	}
	public CursoEntity(int curId, String curNombre, int curCiclo, int curCreditos, int curHoras, int curEstado) {
		super();
		this.curId = curId;
		this.curNombre = curNombre;
		this.curCiclo = curCiclo;
		this.curCreditos = curCreditos;
		this.curHoras = curHoras;
		this.curEstado = curEstado;
	}
	public int getCurId() {
		return curId;
	}
	public void setCurId(int curId) {
		this.curId = curId;
	}
	public String getCurNombre() {
		return curNombre;
	}
	public void setCurNombre(String curNombre) {
		this.curNombre = curNombre;
	}
	public int getCurCiclo() {
		return curCiclo;
	}
	public void setCurCiclo(int curCiclo) {
		this.curCiclo = curCiclo;
	}
	public int getCurCreditos() {
		return curCreditos;
	}
	public void setCurCreditos(int curCreditos) {
		this.curCreditos = curCreditos;
	}
	public int getCurHoras() {
		return curHoras;
	}
	public void setCurHoras(int curHoras) {
		this.curHoras = curHoras;
	}
	public int getCurEstado() {
		return curEstado;
	}
	public void setCurEstado(int curEstado) {
		this.curEstado = curEstado;
	}
	
	

}
