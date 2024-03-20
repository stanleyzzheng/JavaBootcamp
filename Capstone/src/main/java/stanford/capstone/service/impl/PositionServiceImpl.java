package stanford.capstone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stanford.capstone.model.Position;
import stanford.capstone.repository.PositionRepository;
import stanford.capstone.service.PositionService;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public Position findPositionById(Long id) {
        Optional<Position> position = positionRepository.findById(id);
        return position.orElse(null);
    }
}
