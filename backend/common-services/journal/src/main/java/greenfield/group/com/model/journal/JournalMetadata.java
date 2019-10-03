package greenfield.group.com.model.journal;

import lombok.Data;

import java.util.List;

/**
 * Метаданные журнала
 */
@Data
public class JournalMetadata {
    private String id;
    private List<JournalButton> buttonList;
    private JournalColumnMetaData columnMetaData;
    private JournalFilter filter;
}