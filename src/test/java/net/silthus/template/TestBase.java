package net.silthus.template;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;

public abstract class TestBase {

    protected ServerMock server;
    protected Main plugin;

    @BeforeEach
    public void setUp() {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(Main.class);
    }

    @AfterEach
    public void tearDown() {
        MockBukkit.unmock();
    }
}
