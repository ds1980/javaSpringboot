package com.in.cafe.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.pdfbox.io.IOUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.in.cafe.JWT.JwtFilter;
import com.in.cafe.POJO.Bill;
import com.in.cafe.constants.CafeConstants;
import com.in.cafe.repository.BillRepository;
import com.in.cafe.service.BillService;
import com.in.cafe.utils.CafeUtils;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BillServiceImpl implements BillService {

	@Autowired
	JwtFilter jwtFilter;
	
	@Autowired
	BillRepository billRepository;
	
	@Override
	public ResponseEntity<String> getGenerateReport(Map<String, Object> requestMap) {
		log.info("inside Generrated report");
		// TODO Auto-generated method stub
		try {
			String fileName = "";
			if(validateRequestmap(requestMap)) {
				if(requestMap.containsKey("isGenerate") && !(Boolean)requestMap.get("isGenerate")) {
					fileName = (String) requestMap.get("uuid");
				} else {
					fileName = CafeUtils.getUUID();
					requestMap.put("uuid", fileName);
					insertBill(requestMap);
				}
				String data = "Name: "+ requestMap.get("name")+ "\n"+"Contanct Number: "+requestMap.get("contactNumber")
				+ "\n"+"Email: "+requestMap.get("email")+"\n"+"Payment Method: "+requestMap.get("paymentMethod");
				
				Document document = new Document();
				PdfWriter.getInstance(document, new FileOutputStream(CafeConstants.STORE_LOCATION+"\\"+fileName+".pdf"));
				
				document.open();
				setRectAngleInPdf(document);
				
				Paragraph chunk = new Paragraph("Cafe Management System", getFont("Header"));
				chunk.setAlignment(Element.ALIGN_CENTER);
				document.add(chunk);
				
				Paragraph paragraph = new Paragraph(data+"\n\n", getFont("Data"));
				document.add(paragraph);
				
				PdfPTable table = new PdfPTable(5);
				table.setWidthPercentage(100);
				addTableHeader(table);
				
				JSONArray jsonArray = CafeUtils.convertJsonArrayFromString((String)requestMap.get("productDetails"));
				
				for(int i=0; i<jsonArray.length(); i++) {
					addRow(table, CafeUtils.getMapfromJson(jsonArray.getString(i)));
				}
				document.add(table);
				
				Paragraph footer = new Paragraph("Total: "+requestMap.get("totalAmount")+"\n"+"Thank you for visiting.Please visit again!!", getFont("Data"));
				document.add(footer);
				document.close();
				
				return new ResponseEntity<>("{\"uuid\":\"" + fileName + "\"}", HttpStatus.OK);
				
				
			}
			return CafeUtils.getresponseEntity("Required data not found", HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return CafeUtils.getresponseEntity(CafeConstants.SOMETING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	private void addRow(PdfPTable table, Map<String, Object> data) {
		log.info("Inside add Row");
		table.addCell((String) data.get("name"));
		table.addCell((String) data.get("category"));
		table.addCell((String) data.get("quantity"));
		table.addCell(Double.toString((Double)data.get("price")));
		table.addCell(Double.toString((Double)data.get("total")));
	}


	private void addTableHeader(PdfPTable table) {
		// TODO Auto-generated method stub
		log.info("Inside Table Header");
		Stream.of("Name", "Category", "Qantity", "Price", "Sub Total")
		.forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(columnTitle));
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(header);
		});
	}


	private Font getFont(String type) {
		// TODO Auto-generated method stub
		log.info("Inside get font");
		switch (type) {
		case "Header":
			Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
			headerFont.setStyle(Font.BOLD);
			return headerFont;
		case "Data":
			Font datafont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, BaseColor.BLACK);
			datafont.setStyle(Font.BOLD);
			return datafont;

		default:
			return new Font();
		}
	}


	private void setRectAngleInPdf(Document document) throws DocumentException {
		log.info("Inside SetRectangle in PDF");
		Rectangle rect = new Rectangle(577, 825, 18, 15);
		rect.enableBorderSide(1);
		rect.enableBorderSide(2);
		rect.enableBorderSide(4);
		rect.enableBorderSide(8);
		rect.setBorderColor(BaseColor.BLACK);
		rect.setBorderWidth(1);
		document.add(rect);
	}
	private void insertBill(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		try {
			Bill bill = new Bill();
			bill.setUuid((String) requestMap.get("uuid"));
			bill.setName((String) requestMap.get("name"));
			bill.setEmail((String) requestMap.get("email"));
			bill.setContactNumber((String)requestMap.get("contactNumber"));
			bill.setTotal(Integer.parseInt((String)requestMap.get("totalAmount")));
			bill.setProductDetails((String)requestMap.get("productDetails"));
			bill.setCreatedBy(jwtFilter.getCurrentUser());
			
			System.out.println(bill);
			billRepository.save(bill);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	private Boolean validateRequestmap(Map<String, Object> requestMap) {
		if(requestMap.containsKey("name") &&
				requestMap.containsKey("contactNumber") &&
				requestMap.containsKey("email") &&
				requestMap.containsKey("paymentMethod") &&
				requestMap.containsKey("productDetails") &&
				requestMap.containsKey("totalAmount")
				) {
			return true;
		}
		return false;
	}

	@Override
	public ResponseEntity<List<Bill>> getBills() {
		try {
			List<Bill> list = new ArrayList<Bill>();
			
			if(jwtFilter.isAdmin()) {
				list = billRepository.getAllBills();
			} else {
				list = billRepository.getBillByUserName(jwtFilter.getCurrentUser());
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
			
		} catch (Exception e) {
			
		}
		return null;
	}


	@Override
	public ResponseEntity<byte[]> getpdf(Map<String, Object> requestMap) {
		// TODO Auto-generated method stub
		log.info("inside getPdf : requestMap {}", requestMap);
		try {
			byte[] byteArray = new byte[0];
			if(!requestMap.containsKey("uuid") && validateRequestmap(requestMap)) 
				return new ResponseEntity<byte[]>(byteArray, HttpStatus.BAD_REQUEST);
			String filePath = CafeConstants.STORE_LOCATION+"\\"+(String) requestMap.get("uuid") + ".pdf"; 
			if(CafeUtils.isFileExist(filePath)) {
				byteArray = getByteByArray(filePath);
				return new ResponseEntity<byte[]>(byteArray, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// get 
	private byte[] getByteByArray(String filePath) throws Exception {
		File intialFile = new File(filePath);
		InputStream targetStream = new FileInputStream(intialFile);
		byte[] byteArray = IOUtils.toByteArray(targetStream);
		targetStream.close();
		return byteArray;
	}

}
