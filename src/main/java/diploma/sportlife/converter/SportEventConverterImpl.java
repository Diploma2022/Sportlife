package diploma.sportlife.converter;

import diploma.sportlife.model.Activity;
import diploma.sportlife.model.SportEvent;
import diploma.sportlife.model.Profile;
import diploma.sportlife.web.model.SportEventDto;
import org.springframework.stereotype.Component;

@Component
public class SportEventConverterImpl implements ConverterInterface<SportEventDto, SportEvent>{
    @Override
    public SportEvent fromDto(SportEventDto dto) {
        return new SportEvent(
                dto.getId(),
                dto.getName(),
                dto.getSportEventType(),
                dto.getStartDate(),
                dto.getDescription(),
                Profile.builder().id(dto.getProfileId()).build(),
                dto.getTown(),
                dto.getLongitude(),
                dto.getLatitude(),
                Activity.builder().id(dto.getActivityId()).build(),
                dto.getMinCount(),
                dto.getMaxCount()
        );
    }

    @Override
    public SportEventDto toDto(SportEvent model) {
        return new SportEventDto(
                model.getId(),
                model.getName(),
                model.getStartDate(),
                model.getSportEventType().toString(),
                model.getProfile().getId(),
                model.getTown(),
                model.getLongitude(),
                model.getLatitude(),
                model.getActivity().getId(),
                model.getDescription(),
                model.getMinCount(),
                model.getMaxCount()
        );
    }
}
