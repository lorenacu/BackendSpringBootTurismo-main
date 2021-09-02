package com.turismogta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.turismogta.dto.mensaje;
import com.turismogta.entity.atractivoTuristico;
import com.turismogta.entity.codigoQr;
import com.turismogta.generador.*;
import com.turismogta.repository.atractivoTuristicoRepository;
import com.turismogta.service.atractivoTuristicoService;
import com.turismogta.service.codigoQrService;

import net.glxn.qrgen.javase.QRCode;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.imageio.ImageIO;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;


@RestController
@RequestMapping("/atractivo_turistico")
public class QrCodesController {
	
	@Autowired
	codigoQrService codigoQrService;
	
	@Autowired
	atractivoTuristicoService atractivoTuristicoService;
	
	@Autowired
	atractivoTuristicoRepository atractivoTuristicoRepository;
	
	@Autowired 
	QrCodeGenerator qrCodeGenerator;
	

    @GetMapping(value = "/qrcodes/{text}/{width}/{height}", produces = IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generate(@PathVariable final String text,
                                                  @PathVariable final int width,
                                                  @PathVariable final int height,
                                                  @Autowired final QrCodeGenerator qrCodeGenerator) {

    	
        try {
        	
            return ok(qrCodeGenerator.generateQrCode(text, width, height));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    private ResponseEntity<BufferedImage> ok(final BufferedImage bufferedImage) {
        return new ResponseEntity<>(bufferedImage, OK);
    }
    
    /*
  //buscar por id
  	@GetMapping("/detalle/{id}")												
  	public ResponseEntity<codigoQr> getById(@PathVariable("id") int id){
  		if (!codigoQrService.existById(id)) 
  			return new ResponseEntity(new mensaje("No se encuentra el codigo Qr"), HttpStatus.NOT_FOUND);
  		codigoQr codigoQr = codigoQrService.getOne(id).get();
  		return new ResponseEntity(codigoQr,HttpStatus.OK);
  			
  	}*/
  	
  	
  //para generar qr
  	@PostMapping("/generar_qr/{idAtractivo}/{width}/{height}")
  	public ResponseEntity<?> create(
  			@PathVariable("idAtractivo") String idAtractivo,
  			@PathVariable final int width,
            @PathVariable final int height
  			) throws Exception{
  		
  		LocalDateTime localDateTime = LocalDateTime.now();
		Date date3 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		int id=Integer.parseInt(idAtractivo);  
		if(!atractivoTuristicoService.existsById(id) )
			return new ResponseEntity(new mensaje("No se encuentran los datos del atractivo turistico"), HttpStatus.NOT_FOUND);
		
		atractivoTuristico atractivoTuristico = atractivoTuristicoRepository.findById(id).get();
		
		BufferedImage bufferedImage = generateQrCode(idAtractivo, width, height); //aqui  tengo la imagen code Qr
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "jpg", baos);
		byte[] bytes = baos.toByteArray();
		
		String ruta = "C://Temp//uploads//";
		
		Path rutaCompletaPath = Paths.get(ruta);
		Files.write(rutaCompletaPath, bytes);
		String rutafinalString = rutaCompletaPath.toString();
		
		codigoQr codigoQr = new codigoQr();
		
  		codigoQr.setFechaQr(date3);
  		codigoQr.setAtractivoTuristico(atractivoTuristico);
  		codigoQr.setUbicacionQr(rutafinalString);
  		
  	codigoQrService.save(codigoQr);
  	return new ResponseEntity(new mensaje("CodigoQr generado correctamente"),HttpStatus.OK);
  	}
  	
  	
  	public BufferedImage generateQrCode(final String qrCodeText, final int width, final int height) throws Exception {
        final ByteArrayOutputStream stream = QRCode
                .from(qrCodeText)
                .withSize(width, height)
                .stream();

        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(stream.toByteArray());

        return ImageIO.read(byteArrayInputStream);
    }
  	
 // convert BufferedImage to byte[]
    public static byte[] toByteArray(BufferedImage bi, String format)
        throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, baos);
        byte[] bytes = baos.toByteArray();
        return bytes;

    }
    
}
