package greenfield.group.com.journalservice.services;


import greenfield.group.com.journalservice.repositories.JournalRepository;
import greenfield.group.com.journalservice.exceptions.JournalRepositoryException;
import greenfield.group.com.journalservice.journal.JournalMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Апи для работы с журналом
 */
@Service
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    /**
     * Загрузка журнала согласно параметрам
     *
     * @param sysName системное имя журнала
     * @return
     */
    public JournalMetadata loadJournal(String sysName) {
        JournalMetadata journalMetadata = new JournalMetadata();
        try {
            journalMetadata = journalRepository.load(sysName);
        } catch (JournalRepositoryException e) {
            e.printStackTrace();
        }
        return journalMetadata;
    }
}
