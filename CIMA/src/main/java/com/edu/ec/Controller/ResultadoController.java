package com.edu.ec.Controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;

import com.edu.ec.Bussines.Edsm_preguntasBussines;
import com.edu.ec.Bussines.RespuestaBussines;
import com.edu.ec.Favorito.EdsmFavorito;
import com.edu.ec.Favorito.EdsmPreguntasResultados;
import com.edu.ec.Modelos.Resultados;

@ManagedBean
public class ResultadoController {

	private List<Resultados> ListaRespuestas;

	private List<EdsmPreguntasResultados> listaNo;

	@Inject
	private RespuestaBussines respBussines;

	@Inject
	private Edsm_preguntasBussines edsmpreguntasBussines;

	@Inject
	private EdsmFavorito edsmFav;

	@PostConstruct
	public void init() {

		ListaRespuestas = respBussines.listarHistorial(edsmFav.getEdsm());
		listaNo = edsmpreguntasBussines.Listarnegativos(edsmFav.getEdsm());
	}

	public List<Resultados> getListaRespuestas() {
		return ListaRespuestas;
	}

	public void setListaRespuestas(List<Resultados> listaRespuestas) {
		ListaRespuestas = listaRespuestas;
	}

	public List<EdsmPreguntasResultados> getListaNo() {
		return listaNo;
	}

	public void setListaNo(List<EdsmPreguntasResultados> listaNo) {
		this.listaNo = listaNo;
	}

	public void postProcessXLS(Object document) {

		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);

		HSSFCell celda = header.createCell((short) 0);

		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		System.out.println(header.getPhysicalNumberOfCells());

		HSSFRichTextString texto = new HSSFRichTextString("Nombre: ");
		celda.setCellValue(texto);

		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
			HSSFCell cell = header.getCell(i);
			cell.setCellStyle(cellStyle);

		}
	}

	public void preProcessXLS(Object document) {

		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);

		HSSFCell celda = header.createCell((short) 0);
		System.out.println(header.getPhysicalNumberOfCells());

		HSSFRichTextString texto = new HSSFRichTextString("Nombre: ");
		celda.setCellValue(texto);

	}

}
