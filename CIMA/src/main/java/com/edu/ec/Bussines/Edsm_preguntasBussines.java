package com.edu.ec.Bussines;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.edu.ec.Dao.Edsm_PreguntaDao;
import com.edu.ec.Dao.PreguntasDao;
import com.edu.ec.Favorito.EdsmPreguntasResultados;
import com.edu.ec.Modelos.Edsm;
import com.edu.ec.Modelos.Edsm_preguntas;
import com.edu.ec.Modelos.Nivel_preguntas;
import com.edu.ec.Modelos.Preguntas;

@Stateless
public class Edsm_preguntasBussines {

	@Inject
	private Edsm_PreguntaDao edsmpreDao;

	@Inject
	private PreguntasDao preDao;

	public void ingresar(Edsm edsm) {

		int i = 1;

		List<Preguntas> listatotal = preDao.listarporTodas();
		for (Preguntas preguntas : listatotal) {
			Edsm_preguntas edsmP = new Edsm_preguntas();
			edsmP.setPreguntas(preguntas);
			edsmP.setEds_pre_informador("");
			edsmP.setEds_pre_observador("");
			edsmP.setEdsm(edsm);
			edsmpreDao.ingresar(edsmP);
			System.out.println(i);
			i++;
		}

	}

	public List<Edsm_preguntas> Contarlistar(Edsm edsm, Nivel_preguntas nivel) {
		edsmpreDao.Contar(edsm, nivel);
		return edsmpreDao.listarEdsmPregunta(edsm, nivel);

	}

	public void actualizarEdsmPreguntas(Edsm_preguntas esdmpre) {
		edsmpreDao.actualizarEdsmPreguntas(esdmpre);
	}

	public List[] TemporalResultado(Edsm edsm, Nivel_preguntas nivel) {

		List[] resultadosAreglo = new List[2];
		List<Integer> listResultado = new ArrayList<Integer>();

		int A = 0;
		int N = 0;
		int P = 0;

		List<EdsmPreguntasResultados> resultados = new ArrayList<>();
		try {

			List<Edsm_preguntas> edsm_preguntas = edsmpreDao.listarEdsmPregunta(edsm, nivel);

			for (Edsm_preguntas edsm_preguntas2 : edsm_preguntas) {

				EdsmPreguntasResultados er = new EdsmPreguntasResultados();
				er.setArea(edsm_preguntas2.getPreguntas().getPre_nombre());
				er.setPregunta(edsm_preguntas2.getPreguntas().getPre_descripcion());
				er.setObservador(edsm_preguntas2.getEds_pre_observador());
				er.setPadre(edsm_preguntas2.getEds_pre_informador());

				if (edsm_preguntas2.getEds_pre_observador().equals(null)
						|| edsm_preguntas2.getEds_pre_informador().equals(null)
						|| edsm_preguntas2.getEds_pre_observador().equals("")
						|| edsm_preguntas2.getEds_pre_observador().equals("+/-")
						|| edsm_preguntas2.getEds_pre_observador().equals("NA")
						|| edsm_preguntas2.getEds_pre_informador().equals("")
						|| edsm_preguntas2.getEds_pre_informador().equals("+/-")
						|| edsm_preguntas2.getEds_pre_informador().equals("NA")) {
					er.setValor("P");
					P++;

				} else {

					if (edsm_preguntas2.getEds_pre_observador().equals("+")
							&& edsm_preguntas2.getEds_pre_informador().equals("+")) {
						er.setValor("A");
						A++;
					} else if (edsm_preguntas2.getEds_pre_observador().equals("-")
							&& edsm_preguntas2.getEds_pre_informador().equals("-")) {
						er.setValor("N");
						N++;
					} else if (edsm_preguntas2.getEds_pre_observador().equals("+")
							&& edsm_preguntas2.getEds_pre_informador().equals("-")) {
						er.setValor("P");
						P++;
					} else if (edsm_preguntas2.getEds_pre_observador().equals("-")
							&& edsm_preguntas2.getEds_pre_informador().equals("+")) {
						er.setValor("P");
						P++;
					}
				}

				resultados.add(er);

			}

		} catch (Exception e) {
			System.err.println("______________________________");
			e.printStackTrace();
		}
		listResultado.add(A);
		listResultado.add(N);
		listResultado.add(P);

		resultadosAreglo[0] = resultados;
		resultadosAreglo[1] = listResultado;

		System.out.println("A= " + A + "N= " + N + "P= " + P);

		return resultadosAreglo;
	}

	public List<EdsmPreguntasResultados> Listarnegativos(Edsm edsm) {
		List<EdsmPreguntasResultados> resultados = new ArrayList<>();
		try {

			List<Edsm_preguntas> edsm_preguntas = edsmpreDao.ListarNegativos(edsm);

			for (Edsm_preguntas edsm_preguntas2 : edsm_preguntas) {

				EdsmPreguntasResultados er = new EdsmPreguntasResultados();
				
				if (edsm_preguntas2.getEds_pre_observador().equals("-")	&& edsm_preguntas2.getEds_pre_informador().equals("-")) {
					er.setNivel(edsm_preguntas2.getPreguntas().getNivel().getNiv_nombre());
					er.setCategoria_pregunta(edsm_preguntas2.getPreguntas().getPre_nombre());
					er.setPregunta(edsm_preguntas2.getPreguntas().getPre_descripcion());
					er.setObservador(edsm_preguntas2.getEds_pre_observador());
					er.setPadre(edsm_preguntas2.getEds_pre_informador());
					er.setValor("N");
					resultados.add(er);
				}
			}

		} catch (

		Exception e) {
			System.err.println("______________________________");
			e.printStackTrace();
		}
		return resultados;
	}

}
