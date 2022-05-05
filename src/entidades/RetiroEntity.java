package entidades;

import java.util.Date;

public class RetiroEntity extends MatriculaEntity{

	public RetiroEntity(int matId, int aluId, int curId, int docId, Date fecha, int matEstado) {
		super(matId, aluId, curId, docId, fecha, matEstado);
		// TODO Auto-generated constructor stub
	}

	public RetiroEntity(int matId) {
		super(matId);
		// TODO Auto-generated constructor stub
	}

	public RetiroEntity(int matId, int matEstado) {
		super(matId, matEstado);
		// TODO Auto-generated constructor stub
	}

	
}
