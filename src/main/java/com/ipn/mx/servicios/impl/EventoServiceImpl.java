package com.ipn.mx.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import  org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Stream;

import com.ipn.mx.dominio.entidades.Evento;
import com.ipn.mx.dominio.repositorios.EventoRepository;
import com.ipn.mx.servicios.EventoService;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import 
@Service
public class EventoServiceImpl implements EventoService {
    @Autowired
    private EventoRepository eventoRepository;
    @Override
    public List<Evento> readAll() {
        return eventoRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Evento read(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }
    @Override
    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }
    @Override
    public void delete(Long id) {
        eventoRepository.deleteById(id);
    }
    @Override
    public ByteArrayInputStream getStream() {
        Document documento = new Document();
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(documento, salida);
            documento.open();
            Font fuente = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLUE);
            Paragraph parrafo = new Paragraph("Lista de eventos", fuente);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            documento.add(parrafo);
            documento.add(Chunk.NEWLINE);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null; 
    }
    @Override
    public ByteArrayInputStream reportePDF(List<Evento> eventos) {
        Document documento = new Document();
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        try {
            PdfWriter.getInstance(documento, salida);
            documento.open();
            Font fuente = FontFactory.getFont(FontFactory.COURIER, 10, BaseColor.BLUE);
            Paragraph parrafo = new Paragraph("Lista de eventos", fuente);
            parrafo.setAlignment(Element.ALIGN_CENTER);
            documento.add(parrafo);
            documento.add(Chunk.NEWLINE);
           Font tipoletra = FontFactory.getFont(FontFactory.HELVETICA, 10, BaseColor.BLUE);
           PdfTable tabla = new PdfPTable(4);
           Stream.of("Clave", "Nombre", "Fecha", "Duracion").forEach(t -> {
                PdfPCell encabezadoTabla = new PdfPCell();
                Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 9);
               // encabezadoTabla.addElement(new Paragraph(encabezadoTabla, headerFont));
           }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
        return new ByteArrayInputStream(salida.toByteArray());
    }
}