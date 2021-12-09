package com.ginogipsy.magicbus.marshall;


import com.ginogipsy.magicbus.domain.Fritto;
import com.ginogipsy.magicbus.domain.enums.Status;
import com.ginogipsy.magicbus.dto.FrittoDTO;
import com.ginogipsy.magicbus.repository.FrittoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class FrittoMapper {

    private final ModelMapper modelMapper;
    private final FrittoRepository frittoRepository;

    public FrittoMapper(ModelMapper modelMapper, FrittoRepository frittoRepository) {
        this.modelMapper = modelMapper;
        this.frittoRepository = frittoRepository;
    }

    public Fritto convertToEntity(final FrittoDTO frittoDTO){
        return (frittoDTO != null) ? modelMapper.map(frittoDTO, Fritto.class) : null;
    }

    public FrittoDTO convertToDTO(final Fritto fritto){
        return (fritto != null) ? modelMapper.map(fritto, FrittoDTO.class) : null;
    }

    public FrittoDTO findByName(final String nome){
        return convertToDTO(frittoRepository.findByNome(nome));
    }

    public List<FrittoDTO> findByStatus(final String status){
        return frittoRepository.findByStatus(Status.getStatus(status)).stream().map(this::convertToDTO).toList();
    }

    public FrittoDTO save(final FrittoDTO frittoDTO){
        return convertToDTO(frittoRepository.save(convertToEntity(frittoDTO)));
    }


}
