package logica;

public class AlgortimoEnvejecimiento {

	private static int num_cols = 0;
	private static int num_filas = 0;
	Object[][] mat1;
	Object[][] mat2;
	Object[][] mat3;

	public void recorrido1() {
	for(int i =0; i< num_filas; i++) {
		for(int j = 0; j < num_cols; j++) {
			mat3[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
	}
	

	public void recorrido2() {
		for(int j = 0; j < num_cols; j++) {
			for(int i = 0; i < num_filas; i++) {
				mat3[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
	}

	
}
