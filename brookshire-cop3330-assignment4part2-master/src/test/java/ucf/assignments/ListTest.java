package ucf.assignments;

import org.junit.jupiter.api.Test;

class ListTest {
    //Field hostServices of type HostServices - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    List list = new List();

    @Test
    void testStart() {
        list.start(null);
    }

    @Test
    void testMain() {
        List.main(new String[]{"args"});
    }
}

