package src;

public class Principal {

	public static void main(String[] args) {
		FaltasAlumnosEnAsignaturas faltas=new FaltasAlumnosEnAsignaturas();
		
		System.out.println(faltas);
		
		System.out.println(faltas.alumnoConMasFaltas());
		System.out.println(faltas.alumnoConRetrasoSuperiorMediaPorAsignatura());
		System.out.println(faltas.alumnoConRetrasoSuperiorMedia());
		System.out.println(faltas.alumnoConMenosRetrasos());
	}
	
	
}