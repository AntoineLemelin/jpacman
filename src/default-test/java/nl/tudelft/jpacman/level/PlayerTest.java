package nl.tudelft.jpacman.level;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    void testAddPoints() {
        PacManSprites pacManSprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(pacManSprites);
        Player player = playerFactory.createPacMan();
        player.addPoints(5);
        assertThat(player.getScore() == 5);
    }
}
