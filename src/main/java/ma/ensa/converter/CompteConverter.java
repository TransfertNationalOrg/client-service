package ma.ensa.converter;


import ma.ensa.dto.CompteDTO;
import ma.ensa.model.Compte;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CompteConverter extends AbstractConverter<Compte, CompteDTO> {
    private final ModelMapper modelMapper;

    public CompteConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public Compte convertToDM(CompteDTO compteDTO) {
        return modelMapper.map(compteDTO, Compte.class);
    }

    @Override
    public CompteDTO convertToDTO(Compte compte) {
        return modelMapper.map(compte, CompteDTO.class);
    }

}
