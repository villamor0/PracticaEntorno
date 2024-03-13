package src;

import java.util.Random;

public class FaltasAlumnosEnAsignaturas {

	private static final int NUMERO_ALUMNOS = 10;
	private static final int NUMERO_ASIGNATURAS = 4;

	private String[] asignaturas = { "PROG", "LM", "BD", "ED" };
	private Falta[][] matrizFaltas;

	public FaltasAlumnosEnAsignaturas() {
		matrizFaltas = new Falta[NUMERO_ALUMNOS][NUMERO_ASIGNATURAS];

		cargarConDatosAleatorios();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int numeroAlumno = 0; numeroAlumno < matrizFaltas.length; numeroAlumno++) {

			for (int numeroAsig = 0; numeroAsig < matrizFaltas[0].length; numeroAsig++) {
				sb.append(matrizFaltas[numeroAlumno][numeroAsig] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private void cargarConDatosAleatorios() {

		Random serie = new Random();
		Falta falta;

		for (int numeroAlumno = 0; numeroAlumno < matrizFaltas.length; numeroAlumno++) {

			for (int numeroAsig = 0; numeroAsig < matrizFaltas[0].length; numeroAsig++) {

				try {
					falta = new Falta(serie.nextInt(10), serie.nextInt(10), serie.nextInt(10));
					matrizFaltas[numeroAlumno][numeroAsig] = falta;

				} catch (FaltaException e) {
					// Este error no va a producirse
					System.out.println(e.getMessage());
				}

			}
		}

	}

	public String alumnoConMasFaltas() {
		int masFaltas = 0;
		int nAux = NUMERO_ASIGNATURAS;
		StringBuilder faltas = new StringBuilder();
		for (int indice = 0; indice < nAux; indice++) {

			for (int indiceAlumno = 0; indiceAlumno < matrizFaltas.length; indiceAlumno++) {

				if (matrizFaltas[indiceAlumno][indice].getInjustificadas() > matrizFaltas[masFaltas][indice].getInjustificadas()) {
					masFaltas = indiceAlumno;
				}
			}
			faltas.append(this.asignaturas[indice] + ": El alumno con más faltas injustificadas es el:"
					+ (masFaltas + 1) + " con:" + matrizFaltas[masFaltas][indice].getInjustificadas() + "\n");
			masFaltas = 0;
		}

		return faltas.toString();
	}

	public String  alumnoConRetrasoSuperiorMediaPorAsignatura() {
		int media = 0;
		int nAux = NUMERO_ASIGNATURAS;
		StringBuilder superiorMedia = new StringBuilder();
		Falta[][] aux2 = this.matrizFaltas;
		for(int indice = 0;indice < nAux;indice++) {
			
		for(int i = 0;i < aux2.length;i++) {
			media = aux2[i][indice].getRetrasos() + media;
		}
			media = media / NUMERO_ALUMNOS;
			superiorMedia.append(this.asignaturas[indice]+" la media es "+media+":\n");
		for(int indiceAlumno = 0;indiceAlumno < aux2.length;indiceAlumno++) {
			
			if(aux2[indiceAlumno][indice].getRetrasos()>media) {
				superiorMedia.append("El alumno :"+(indiceAlumno+1)+" tiene un indice de faltas superior con:"+aux2[indiceAlumno][indice].getRetrasos()+"\n");

			}
		}

		}
		
		return superiorMedia.toString();
	}
	

	public String alumnoConRetrasoSuperiorMedia() {
		double media = 0;
		int[] alumnos = new int[NUMERO_ALUMNOS];
		StringBuilder superiorMedia = new StringBuilder();

		for (int indice = 0; indice < alumnos.length; indice++) {

			for (int i = 0; i < matrizFaltas[0].length; i++) {
				media = this.matrizFaltas[indice][i].getRetrasos() + media;
				alumnos[indice] = matrizFaltas[indice][i].getRetrasos() + alumnos[indice];
			}
			////
		}
		media = (double) media / NUMERO_ALUMNOS;
		superiorMedia.append("La media es " + media + ":\n");

		for (int indiceAlumno = 0; indiceAlumno < alumnos.length; indiceAlumno++) {
			if (alumnos[indiceAlumno] > media) {
				superiorMedia.append("El alumno :" + (indiceAlumno + 1) + " tiene un indice de faltas superior con:"
						+ alumnos[indiceAlumno] + "\n");
			}
		}

		return superiorMedia.toString();
	}

	public String alumnoConMenosRetrasos() {
		int menosRetraso = 0;
		StringBuilder faltas = new StringBuilder();
		for (int indice = 0; indice < NUMERO_ASIGNATURAS; indice++) {

			for (int indiceAlumno = 0; indiceAlumno < matrizFaltas.length; indiceAlumno++) {

				if (matrizFaltas[indiceAlumno][indice].getRetrasos() < matrizFaltas[menosRetraso][indice].getRetrasos()) {
					menosRetraso = indiceAlumno;
				}
			}
			faltas.append(this.asignaturas[indice] + ": El alumno con menos retraso es el:" + (menosRetraso + 1)
					+ " con:" + matrizFaltas[menosRetraso][indice].getRetrasos() + "\n");
			menosRetraso = 0;
		}

		return faltas.toString();
	}

}
