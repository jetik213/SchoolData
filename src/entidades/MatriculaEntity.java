package entidades;

import java.util.Date;

public class MatriculaEntity {

	private int matId;
	private int aluId;
	private int curId;
	private int docId;
	private Date fecha;
	private int matEstado;
	

	public MatriculaEntity(int matId) {
		super();
		this.matId = matId;
	}

	public MatriculaEntity(int matId, int matEstado) {
		super();
		this.matId = matId;
		this.matEstado = matEstado;
	}



	public MatriculaEntity(int matId, int aluId, int curId, int docId, Date fecha) {
		super();
		this.matId = matId;
		this.aluId = aluId;
		this.curId = curId;
		this.docId = docId;
		this.fecha = fecha;
	}

	public MatriculaEntity(int aluId, int curId, int docId) {
		super();
		this.aluId = aluId;
		this.curId = curId;
		this.docId = docId;
	}

	public MatriculaEntity(int matId, int aluId, int curId, int docId, Date fecha, int matEstado) {
		super();
		this.matId = matId;
		this.aluId = aluId;
		this.curId = curId;
		this.docId = docId;
		this.fecha = fecha;
		this.matEstado = matEstado;
	}
	
	public int getMatId() {
		return matId;
	}
	public void setMatId(int matId) {
		this.matId = matId;
	}
	public int getAluId() {
		return aluId;
	}
	public void setAluId(int aluId) {
		this.aluId = aluId;
	}
	public int getCurId() {
		return curId;
	}
	public void setCurId(int curId) {
		this.curId = curId;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getMatEstado() {
		return matEstado;
	}
	public void setMatEstado(int matEstado) {
		this.matEstado = matEstado;
	}
		
}
