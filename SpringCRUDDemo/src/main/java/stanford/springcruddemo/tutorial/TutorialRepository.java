package stanford.springcruddemo.tutorial;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface TutorialRepository extends JpaRepository<Tutorial,Long> {
    List<Tutorial> findByPublished(boolean published);
}
