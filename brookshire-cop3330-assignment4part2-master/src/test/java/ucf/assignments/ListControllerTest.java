package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ListControllerTest {
    //Field fileChooser of type FileChooser - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    @Mock
    TextField descriptionTextField;
    @Mock
    ListView<Item> itemList;
    @Mock
    Button addButton;
    @Mock
    Button removeButton;
    @Mock
    Button clearButton;
    @Mock
    Button updateButton;
    @Mock
    Button exportButton;
    @Mock
    Button displayCompletedButton;
    @Mock
    Button importButton;
    @Mock
    Button markCompleteButton;
    @Mock
    Button markIncompleteButton;
    @Mock
    Button displayIncompletedButton;
    @Mock
    Button displayAllButton;
    @Mock
    DatePicker datePicker;
    @Mock
    ObservableList<Item> list;
    @InjectMocks
    ListController listController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInitialize() {
        listController.initialize(null, null);
    }

    @Test
    void testRefresh() {
        listController.refresh();
    }

    @Test
    void testAddItem() {
        listController.addItem(null);
    }

    @Test
    void testRemoveItem() {
        listController.removeItem(null);
    }

    @Test
    void testClearAll() {
        listController.clearAll(null);
    }

    @Test
    void testListViewSelectedItem() {
        listController.listViewSelectedItem();
    }

    @Test
    void testUpdateItem() {
        listController.updateItem(null);
    }

    @Test
    void testExportList() {
        listController.exportList(null);
    }

    @Test
    void testImportList() {
        listController.importList(null);
    }

    @Test
    void testMarkComplete() {
        listController.markComplete(null);
    }

    @Test
    void testMarkIncomplete() {
        listController.markIncomplete(null);
    }

    @Test
    void testDisplayComplete() {
        listController.displayComplete(null);
    }

    @Test
    void testDisplayIncomplete() {
        listController.displayIncomplete(null);
    }

    @Test
    void testDisplayAll() {
        listController.displayAll(null);
    }
}

