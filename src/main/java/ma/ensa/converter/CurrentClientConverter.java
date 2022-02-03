package ma.ensa.converter;

import ma.ensa.dto.CurrentClientDTO;
import ma.ensa.model.CurrentClient;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CurrentClientConverter extends AbstractConverter<CurrentClient, CurrentClientDTO> {

    private final ModelMapper modelMapper;

    public CurrentClientConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        this.modelMapper = modelMapper;
    }

    @Override
    public CurrentClient convertToDM(CurrentClientDTO currentClientDTO) {
        return modelMapper.map(currentClientDTO, CurrentClient.class);
    }

    @Override
    public CurrentClientDTO convertToDTO(CurrentClient currentAgent) {
        return modelMapper.map(currentAgent, CurrentClientDTO.class);
    }
}