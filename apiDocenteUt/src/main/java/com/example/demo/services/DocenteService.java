package com.example.demo.services;

import java.util.List;
import com.example.demo.models.DocenteModel;
import com.example.demo.models.common.RequestDocenteDto;
import com.example.demo.repositories.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteService {
    @Autowired
    private DocenteRepository docenteRepository;

    private DocenteModel mapperDocente(RequestDocenteDto docente) {
        DocenteModel doc = new DocenteModel();
        doc.setApellidos(docente.getApellidos());
        doc.setNombres(docente.getNombres());
        doc.setEmail(docente.getEmail());
        doc.setGrupo(docente.getGrupo());
        doc.setTipoDocumento(docente.getTipoDocumento());
        doc.setNumeroIdentificacion(docente.getNumeroIdentificacion());
        doc.setId(0); 

        return doc;
    }

    public DocenteModel save(RequestDocenteDto docente) {
        if (!existeDocente(docente.getTipoDocumento(), docente.getNumeroIdentificacion())) {
            return docenteRepository.save(mapperDocente(docente));
        }
        return null; 
    }

    public List<DocenteModel> getAll() {
        return (List<DocenteModel>) docenteRepository.findAll();
    }

    public DocenteModel update(DocenteModel docente) {
        if (existeDocente(docente.getId())) {
            return docenteRepository.save(docente);
        }
        return null; 
    }

    public boolean delete(int id) {
        try {
            if (existeDocente(id)) {
                docenteRepository.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean existeDocente(int id) {
        return docenteRepository.existsById(id);
    }

    private boolean existeDocente(String tipoDocumento, String numeroIdentificacion) {
        return docenteRepository.findAll().stream()
                .anyMatch(docente -> docente.getTipoDocumento().equals(tipoDocumento) &&
                        docente.getNumeroIdentificacion().equals(numeroIdentificacion));
    }
    
	private boolean eliminarDocente(int Id) {
		return docenteRepository.existsById(null);
	}
}
