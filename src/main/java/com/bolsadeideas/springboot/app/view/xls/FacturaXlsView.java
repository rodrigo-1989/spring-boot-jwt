package com.bolsadeideas.springboot.app.view.xls;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("factura/ver.xlsx")
public class FacturaXlsView extends AbstractXlsxView {
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private LocaleResolver localeResolver;

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse response) throws Exception {
        //Con la siguiente linea le cambiamos el nombre al archivo al descargarlo
        response.setHeader("Content-Disposition","attachment; file  name=\"factura_view.xlsx\"");
        MessageSourceAccessor mensaje = getMessageSourceAccessor();

        Factura factura = (Factura ) model.get("factura");
        Sheet sheet = workbook.createSheet("Factura Spring");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(mensaje.getMessage("text.factura.ver.datos.cliente"));

        row = sheet.createRow(1);
        cell = row.createCell(0);
        cell.setCellValue(factura.getCliente().getNombre()+" "+factura.getCliente().getApellido());

        row = sheet.createRow(2);
        cell = row.createCell(0);
        cell.setCellValue(factura.getCliente().getEmail());

        sheet.createRow(4).createCell(0).setCellValue(mensaje.getMessage("text.factura.ver.datos.factura"));

        sheet.createRow(5).createCell(0).setCellValue(mensaje.getMessage("text.cliente.factura.folio")+": "+factura.getId());
        sheet.createRow(6).createCell(0).setCellValue(mensaje.getMessage("text.cliente.factura.descripcion")+": "+factura.getDescripcion());
        sheet.createRow(7).createCell(0).setCellValue(mensaje.getMessage("text.cliente.factura.fecha")+": "+factura.getCreateAt());

        CellStyle theaderStyle = workbook.createCellStyle();
        theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
        theaderStyle.setBorderTop(BorderStyle.MEDIUM);
        theaderStyle.setBorderRight(BorderStyle.MEDIUM);
        theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
        theaderStyle.setFillBackgroundColor(IndexedColors.GOLD.index);
        theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle thBody = workbook.createCellStyle();
        thBody.setBorderBottom(BorderStyle.THIN);
        thBody.setBorderTop(BorderStyle.THIN);
        thBody.setBorderRight(BorderStyle.THIN);
        thBody.setBorderLeft(BorderStyle.THIN);

        Row header = sheet.createRow(9);
        header.createCell(0).setCellValue(mensaje.getMessage("text.factura.form.item.nombre"));
        header.createCell(1).setCellValue(mensaje.getMessage("text.factura.form.item.precio"));
        header.createCell(2).setCellValue(mensaje.getMessage("text.factura.form.item.cantidad"));
        header.createCell(3).setCellValue(mensaje.getMessage("text.factura.form.item.total"));

        header.getCell(0).setCellStyle(theaderStyle);
        header.getCell(1).setCellStyle(theaderStyle);
        header.getCell(2).setCellStyle(theaderStyle);
        header.getCell(3).setCellStyle(theaderStyle);

        int rownum = 10;
        for(ItemFactura item: factura.getItems()){
            Row fila = sheet.createRow( rownum++ );
            cell = fila.createCell(0);
            cell.setCellValue(item.getProducto().getNombre());
            cell.setCellStyle(thBody);

            cell = fila.createCell(1);
            cell.setCellValue(item.getProducto().getPrecio());
            cell.setCellStyle(thBody);

            cell = fila.createCell(2);
            cell.setCellValue(item.getCantidad());
            cell.setCellStyle(thBody);

            cell = fila.createCell(3);
            cell.setCellValue(item.calcularImporte());
            cell.setCellStyle(thBody);
        }

        Row filaTotal = sheet.createRow( rownum );
        cell = filaTotal.createCell(2);
        cell.setCellValue(mensaje.getMessage("text.factura.form.total"));
        cell.setCellStyle(thBody);

        cell = filaTotal.createCell(3);
        cell.setCellValue(factura.getTotal() );
        cell.setCellStyle(thBody);

    }
}
