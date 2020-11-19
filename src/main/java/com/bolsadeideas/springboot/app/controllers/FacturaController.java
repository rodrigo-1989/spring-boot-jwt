package com.bolsadeideas.springboot.app.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.Producto;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

import javax.validation.Valid;
@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/ver/{id}")
	public String ver (@PathVariable (value = "id")Long id,
					   Model modelo, RedirectAttributes flash, Locale locale){

		Factura factura = clienteService.fetchByIdWithClienteWithItemFacturaWithProducto(id);

		if (factura ==null ){
			flash.addFlashAttribute("error",messageSource.getMessage("text.factura.flash.db.error", null, locale));
			return "redirect:/listar";
		}
		modelo.addAttribute("factura",factura);
		modelo.addAttribute("titulo",String.format(messageSource.getMessage("text.factura.ver.titulo", null, locale), factura.getDescripcion()));

		return "factura/ver";
	}

	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value = "clienteId") Long clienteId, Map<String, Object> model,
			RedirectAttributes flash,Locale locale) {

		Cliente cliente = clienteService.findOne(clienteId);

		if (cliente == null) {
			flash.addFlashAttribute("error",  messageSource.getMessage("text.cliente.flash.db.error", null, locale));
			return "redirect:/listar";
		}

		Factura factura = new Factura();
		factura.setCliente(cliente);

		model.put("factura", factura);
		model.put("titulo", messageSource.getMessage("text.factura.form.titulo", null, locale));

		return "factura/form";
	}

	@GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
		return clienteService.findByNombre(term);
	}
	@PostMapping("/form")
	public String guardar (@Valid Factura factura,
						   BindingResult result, Model modelo,
						   @RequestParam (name = "item_id[]",required = false)Long []itemId,
						   @RequestParam (name = "cantidad[]",required = false)Integer[]cantidad,
						   RedirectAttributes flash, SessionStatus status,Locale locale){
		if (result.hasErrors()){
			modelo.addAttribute("titulo", messageSource.getMessage("text.factura.form.titulo", null, locale));
			return "factura/form";
		}
		if ( itemId==null || itemId.length==0 ){
			modelo.addAttribute("titulo",messageSource.getMessage("text.factura.form.titulo", null, locale));
			modelo.addAttribute("error",messageSource.getMessage("text.factura.flash.lineas.error", null, locale));
			return "factura/form";
		}
		for (int i=0 ; i< itemId.length ; i++ ){
			Producto producto = clienteService.findProductoById(itemId[i]);
			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			factura.addItemFactura(linea );
			log.info("ID: "+itemId.toString()+", cantidad: "+cantidad [i]);
		}
		clienteService.saveFactura(factura);
		status.setComplete();
		flash.addFlashAttribute("success",messageSource.getMessage("text.factura.flash.crear.success", null, locale));
		return "redirect:/ver/"+factura.getCliente().getId();
	}
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable (value = "id")Long id, RedirectAttributes flash,Locale locale){
		Factura factura = clienteService.findFacturaById(id);
		if ( factura!= null){
			clienteService.deleteFactura(id);
			flash.addFlashAttribute("success",messageSource.getMessage("text.factura.flash.eliminar.success", null, locale));
			return "redirect:/ver/"+factura.getCliente().getId();
		}
		flash.addFlashAttribute("error",messageSource.getMessage("text.factura.flash.db.error", null, locale));
		return "redirect:/listar";

	}
}
