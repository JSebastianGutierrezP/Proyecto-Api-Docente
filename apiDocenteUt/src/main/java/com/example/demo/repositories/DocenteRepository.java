package com.example.demo.repositories;

import com.example.demo.models.DocenteModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteModel, Integer> {
    Optional<DocenteModel> findByTipoDocumentoAndNumeroIdentificacion(String tipoDocumento, String numeroIdentificacion);
}