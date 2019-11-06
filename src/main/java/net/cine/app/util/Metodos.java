package net.cine.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Metodos {

	public static List<String> getNextDays(int count) {

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(start);
		List<String> nextDays = new ArrayList<>();
		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(format.format(d));

		}
		return nextDays;

	}

	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphanumeric(8) + nombreOriginal;
		String rutaFinal = request.getSession().getServletContext().getRealPath("/resources/images/");

		try {
			File imageFile = new File(rutaFinal + nombreFinal);
			multiPart.transferTo(imageFile);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}

	}

	public static String randomAlphanumeric(int count) {

		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));

		}
		return builder.toString();
	}

}
